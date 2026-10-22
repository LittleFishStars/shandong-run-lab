package androidx.camera.core.internal;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
class SupportedOutputSizesSorter {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final CameraInfoInternal mCameraInfoInternal;
    private final Rational mFullFovRatio;
    private final boolean mIsSensorLandscapeResolution;
    private final int mLensFacing;
    private final int mSensorOrientation;
    private final SupportedOutputSizesSorterLegacy mSupportedOutputSizesSorterLegacy;

    public SupportedOutputSizesSorter(@NonNull CameraInfoInternal cameraInfoInternal, @Nullable Size size) {
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mSensorOrientation = cameraInfoInternal.getSensorRotationDegrees();
        this.mLensFacing = cameraInfoInternal.getLensFacing();
        Rational rationalCalculateFullFovRatioFromActiveArraySize = size != null ? calculateFullFovRatioFromActiveArraySize(size) : calculateFullFovRatioFromSupportedOutputSizes(cameraInfoInternal);
        this.mFullFovRatio = rationalCalculateFullFovRatioFromActiveArraySize;
        boolean z = true;
        if (rationalCalculateFullFovRatioFromActiveArraySize != null && rationalCalculateFullFovRatioFromActiveArraySize.getNumerator() < rationalCalculateFullFovRatioFromActiveArraySize.getDenominator()) {
            z = false;
        }
        this.mIsSensorLandscapeResolution = z;
        this.mSupportedOutputSizesSorterLegacy = new SupportedOutputSizesSorterLegacy(cameraInfoInternal, rationalCalculateFullFovRatioFromActiveArraySize);
    }

    @NonNull
    private LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategy(@NonNull List<Size> list, @NonNull AspectRatioStrategy aspectRatioStrategy) {
        return applyAspectRatioStrategyFallbackRule(groupSizesByAspectRatio(list), aspectRatioStrategy);
    }

    private LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategyFallbackRule(@NonNull Map<Rational, List<Size>> map, @NonNull AspectRatioStrategy aspectRatioStrategy) {
        Rational targetAspectRatioRationalValue = getTargetAspectRatioRationalValue(aspectRatioStrategy.getPreferredAspectRatio(), this.mIsSensorLandscapeResolution);
        if (aspectRatioStrategy.getFallbackRule() == 0) {
            Rational targetAspectRatioRationalValue2 = getTargetAspectRatioRationalValue(aspectRatioStrategy.getPreferredAspectRatio(), this.mIsSensorLandscapeResolution);
            for (Rational rational : new ArrayList(map.keySet())) {
                if (!rational.equals(targetAspectRatioRationalValue2)) {
                    map.remove(rational);
                }
            }
        }
        ArrayList<Rational> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(targetAspectRatioRationalValue, this.mFullFovRatio));
        LinkedHashMap<Rational, List<Size>> linkedHashMap = new LinkedHashMap<>();
        for (Rational rational2 : arrayList) {
            linkedHashMap.put(rational2, map.get(rational2));
        }
        return linkedHashMap;
    }

    @NonNull
    private List<Size> applyHighResolutionSettings(@NonNull List<Size> list, @NonNull ResolutionSelector resolutionSelector, int i) {
        if (resolutionSelector.getAllowedResolutionMode() != 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.mCameraInfoInternal.getSupportedHighResolutions(i));
        Collections.sort(arrayList, new CompareSizesByArea(true));
        return arrayList;
    }

    private static void applyMaxResolutionRestriction(@NonNull LinkedHashMap<Rational, List<Size>> linkedHashMap, @NonNull Size size) {
        int area = SizeUtil.getArea(size);
        Iterator<Rational> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            List<Size> list = linkedHashMap.get(it.next());
            ArrayList arrayList = new ArrayList();
            for (Size size2 : list) {
                if (SizeUtil.getArea(size2) <= area) {
                    arrayList.add(size2);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
    }

    @NonNull
    private List<Size> applyResolutionFilter(@NonNull List<Size> list, @Nullable ResolutionFilter resolutionFilter, int i) {
        if (resolutionFilter == null) {
            return list;
        }
        List<Size> listFilter = resolutionFilter.filter(new ArrayList(list), CameraOrientationUtil.getRelativeImageRotation(CameraOrientationUtil.surfaceRotationToDegrees(i), this.mSensorOrientation, this.mLensFacing == 1));
        if (list.containsAll(listFilter)) {
            return listFilter;
        }
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    private static void applyResolutionStrategy(@NonNull LinkedHashMap<Rational, List<Size>> linkedHashMap, @Nullable ResolutionStrategy resolutionStrategy) {
        if (resolutionStrategy == null) {
            return;
        }
        Iterator<Rational> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            applyResolutionStrategyFallbackRule(linkedHashMap.get(it.next()), resolutionStrategy);
        }
    }

    private static void applyResolutionStrategyFallbackRule(@NonNull List<Size> list, @NonNull ResolutionStrategy resolutionStrategy) {
        if (list.isEmpty()) {
            return;
        }
        Integer numValueOf = Integer.valueOf(resolutionStrategy.getFallbackRule());
        if (resolutionStrategy.equals(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY)) {
            return;
        }
        Size boundSize = resolutionStrategy.getBoundSize();
        int iIntValue = numValueOf.intValue();
        if (iIntValue == 0) {
            sortSupportedSizesByFallbackRuleNone(list, boundSize);
            return;
        }
        if (iIntValue == 1) {
            sortSupportedSizesByFallbackRuleClosestHigherThenLower(list, boundSize, true);
            return;
        }
        if (iIntValue == 2) {
            sortSupportedSizesByFallbackRuleClosestHigherThenLower(list, boundSize, false);
        } else if (iIntValue == 3) {
            sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list, boundSize, true);
        } else {
            if (iIntValue != 4) {
                return;
            }
            sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list, boundSize, false);
        }
    }

    @NonNull
    private Rational calculateFullFovRatioFromActiveArraySize(@NonNull Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    @Nullable
    private Rational calculateFullFovRatioFromSupportedOutputSizes(@NonNull CameraInfoInternal cameraInfoInternal) {
        List<Size> supportedResolutions = cameraInfoInternal.getSupportedResolutions(256);
        if (supportedResolutions.isEmpty()) {
            return null;
        }
        Size size = (Size) Collections.max(supportedResolutions, new CompareSizesByArea());
        return new Rational(size.getWidth(), size.getHeight());
    }

    @Nullable
    private List<Size> getCustomizedSupportedResolutionsFromConfig(int i, @NonNull ImageOutputConfig imageOutputConfig) {
        Size[] sizeArr;
        List<Pair<Integer, Size[]>> supportedResolutions = imageOutputConfig.getSupportedResolutions(null);
        if (supportedResolutions != null) {
            for (Pair<Integer, Size[]> pair : supportedResolutions) {
                if (((Integer) pair.first).intValue() == i) {
                    sizeArr = (Size[]) pair.second;
                }
            }
            sizeArr = null;
        } else {
            sizeArr = null;
        }
        if (sizeArr == null) {
            return null;
        }
        return Arrays.asList(sizeArr);
    }

    @NonNull
    private List<Size> getResolutionCandidateList(@NonNull UseCaseConfig<?> useCaseConfig) {
        int inputFormat = useCaseConfig.getInputFormat();
        List<Size> customizedSupportedResolutionsFromConfig = getCustomizedSupportedResolutionsFromConfig(inputFormat, (ImageOutputConfig) useCaseConfig);
        if (customizedSupportedResolutionsFromConfig == null) {
            customizedSupportedResolutionsFromConfig = this.mCameraInfoInternal.getSupportedResolutions(inputFormat);
        }
        ArrayList arrayList = new ArrayList(customizedSupportedResolutionsFromConfig);
        Collections.sort(arrayList, new CompareSizesByArea(true));
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "The retrieved supported resolutions from camera info internal is empty. Format is " + inputFormat + Consts.DOT);
        }
        return arrayList;
    }

    @NonNull
    public static List<Rational> getResolutionListGroupingAspectRatioKeys(@NonNull List<Size> list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_4_3);
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_16_9);
        for (Size size : list) {
            Rational rational = new Rational(size.getWidth(), size.getHeight());
            if (!arrayList.contains(rational)) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (AspectRatioUtil.hasMatchingAspectRatio(size, (Rational) it.next())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(rational);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static Rational getTargetAspectRatioRationalValue(int i, boolean z) {
        if (i != -1) {
            if (i == 0) {
                return z ? AspectRatioUtil.ASPECT_RATIO_4_3 : AspectRatioUtil.ASPECT_RATIO_3_4;
            }
            if (i == 1) {
                return z ? AspectRatioUtil.ASPECT_RATIO_16_9 : AspectRatioUtil.ASPECT_RATIO_9_16;
            }
            Logger.e(TAG, "Undefined target aspect ratio: " + i);
        }
        return null;
    }

    public static Map<Rational, List<Size>> groupSizesByAspectRatio(@NonNull List<Size> list) {
        HashMap map = new HashMap();
        Iterator<Rational> it = getResolutionListGroupingAspectRatioKeys(list).iterator();
        while (it.hasNext()) {
            map.put(it.next(), new ArrayList());
        }
        for (Size size : list) {
            for (Rational rational : map.keySet()) {
                if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                    ((List) map.get(rational)).add(size);
                }
            }
        }
        return map;
    }

    @NonNull
    private List<Size> sortSupportedOutputSizesByResolutionSelector(@NonNull UseCaseConfig<?> useCaseConfig) {
        ResolutionSelector resolutionSelector = ((ImageOutputConfig) useCaseConfig).getResolutionSelector();
        List<Size> resolutionCandidateList = getResolutionCandidateList(useCaseConfig);
        if (!useCaseConfig.isHigResolutionDisabled(false)) {
            resolutionCandidateList = applyHighResolutionSettings(resolutionCandidateList, resolutionSelector, useCaseConfig.getInputFormat());
        }
        LinkedHashMap<Rational, List<Size>> linkedHashMapApplyAspectRatioStrategy = applyAspectRatioStrategy(resolutionCandidateList, resolutionSelector.getAspectRatioStrategy());
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        Size maxResolution = imageOutputConfig.getMaxResolution(null);
        if (maxResolution != null) {
            applyMaxResolutionRestriction(linkedHashMapApplyAspectRatioStrategy, maxResolution);
        }
        applyResolutionStrategy(linkedHashMapApplyAspectRatioStrategy, resolutionSelector.getResolutionStrategy());
        ArrayList arrayList = new ArrayList();
        Iterator<List<Size>> it = linkedHashMapApplyAspectRatioStrategy.values().iterator();
        while (it.hasNext()) {
            for (Size size : it.next()) {
                if (!arrayList.contains(size)) {
                    arrayList.add(size);
                }
            }
        }
        return applyResolutionFilter(arrayList, resolutionSelector.getResolutionFilter(), imageOutputConfig.getTargetRotation(0));
    }

    public static void sortSupportedSizesByFallbackRuleClosestHigherThenLower(@NonNull List<Size> list, @NonNull Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z) {
            list.addAll(arrayList);
        }
    }

    private static void sortSupportedSizesByFallbackRuleClosestLowerThenHigher(@NonNull List<Size> list, @NonNull Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Size size2 = list.get(i);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z) {
            list.addAll(arrayList);
        }
    }

    private static void sortSupportedSizesByFallbackRuleNone(@NonNull List<Size> list, @NonNull Size size) {
        boolean zContains = list.contains(size);
        list.clear();
        if (zContains) {
            list.add(size);
        }
    }

    @NonNull
    public List<Size> getSortedSupportedOutputSizes(@NonNull UseCaseConfig<?> useCaseConfig) {
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        List<Size> customOrderedResolutions = imageOutputConfig.getCustomOrderedResolutions(null);
        if (customOrderedResolutions != null) {
            return customOrderedResolutions;
        }
        return imageOutputConfig.getResolutionSelector(null) == null ? this.mSupportedOutputSizesSorterLegacy.sortSupportedOutputSizes(getResolutionCandidateList(useCaseConfig), useCaseConfig) : sortSupportedOutputSizesByResolutionSelector(useCaseConfig);
    }
}
