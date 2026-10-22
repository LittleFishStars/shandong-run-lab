package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class StreamUseCaseUtil {
    public static final Config.Option<Long> STREAM_USE_CASE_STREAM_SPEC_OPTION = Config.Option.create("camera2.streamSpec.streamUseCase", Long.TYPE);
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
    private static final String TAG = "Camera2CameraImpl";

    static {
        HashMap map = new HashMap();
        STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP = map;
        HashMap map2 = new HashMap();
        STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP = map2;
        if (Build.VERSION.SDK_INT >= 33) {
            HashSet hashSet = new HashSet();
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.PREVIEW;
            hashSet.add(captureType);
            map.put(4L, hashSet);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(captureType);
            hashSet2.add(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
            map.put(1L, hashSet2);
            HashSet hashSet3 = new HashSet();
            UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE;
            hashSet3.add(captureType2);
            map.put(2L, hashSet3);
            HashSet hashSet4 = new HashSet();
            UseCaseConfigFactory.CaptureType captureType3 = UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            hashSet4.add(captureType3);
            map.put(3L, hashSet4);
            HashSet hashSet5 = new HashSet();
            hashSet5.add(captureType);
            hashSet5.add(captureType2);
            hashSet5.add(captureType3);
            map2.put(4L, hashSet5);
            HashSet hashSet6 = new HashSet();
            hashSet6.add(captureType);
            hashSet6.add(captureType3);
            map2.put(3L, hashSet6);
        }
    }

    private StreamUseCaseUtil() {
    }

    public static boolean areCaptureTypesEligible(@NonNull Map<Integer, AttachedSurfaceInfo> map, @NonNull Map<Integer, UseCaseConfig<?>> map2, @NonNull List<SurfaceConfig> list) {
        for (int i = 0; i < list.size(); i++) {
            long streamUseCase = list.get(i).getStreamUseCase();
            if (map.containsKey(Integer.valueOf(i))) {
                AttachedSurfaceInfo attachedSurfaceInfo = map.get(Integer.valueOf(i));
                if (!isEligibleCaptureType(attachedSurfaceInfo.getCaptureTypes().size() == 1 ? attachedSurfaceInfo.getCaptureTypes().get(0) : UseCaseConfigFactory.CaptureType.STREAM_SHARING, streamUseCase, attachedSurfaceInfo.getCaptureTypes())) {
                    return false;
                }
            } else {
                if (!map2.containsKey(Integer.valueOf(i))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                UseCaseConfig<?> useCaseConfig = map2.get(Integer.valueOf(i));
                if (!isEligibleCaptureType(useCaseConfig.getCaptureType(), streamUseCase, useCaseConfig.getCaptureType() == UseCaseConfigFactory.CaptureType.STREAM_SHARING ? ((StreamSharingConfig) useCaseConfig).getCaptureTypes() : Collections.emptyList())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean areStreamUseCasesAvailable(Set<Long> set, Set<Long> set2) {
        Iterator<Long> it = set2.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean areStreamUseCasesAvailableForSurfaceConfigs(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull List<SurfaceConfig> list) {
        long[] jArr;
        if (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (long j : jArr) {
            hashSet.add(Long.valueOf(j));
        }
        Iterator<SurfaceConfig> it = list.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(it.next().getStreamUseCase()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsZslUseCase(@NonNull List<AttachedSurfaceInfo> list, @NonNull List<UseCaseConfig<?>> list2) {
        for (AttachedSurfaceInfo attachedSurfaceInfo : list) {
            if (isZslUseCase(attachedSurfaceInfo.getImplementationOptions(), attachedSurfaceInfo.getCaptureTypes().get(0))) {
                return true;
            }
        }
        for (UseCaseConfig<?> useCaseConfig : list2) {
            if (isZslUseCase(useCaseConfig, useCaseConfig.getCaptureType())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static Camera2ImplConfig getStreamSpecImplementationOptions(@NonNull UseCaseConfig<?> useCaseConfig) {
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        Config.Option<?> option = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
        if (useCaseConfig.containsOption(option)) {
            mutableOptionsBundleCreate.insertOption(option, (Long) useCaseConfig.retrieveOption(option));
        }
        Config.Option<?> option2 = UseCaseConfig.OPTION_ZSL_DISABLED;
        if (useCaseConfig.containsOption(option2)) {
            mutableOptionsBundleCreate.insertOption(option2, (Boolean) useCaseConfig.retrieveOption(option2));
        }
        Config.Option<?> option3 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (useCaseConfig.containsOption(option3)) {
            mutableOptionsBundleCreate.insertOption(option3, (Integer) useCaseConfig.retrieveOption(option3));
        }
        Config.Option<?> option4 = ImageInputConfig.OPTION_INPUT_FORMAT;
        if (useCaseConfig.containsOption(option4)) {
            mutableOptionsBundleCreate.insertOption(option4, (Integer) useCaseConfig.retrieveOption(option4));
        }
        return new Camera2ImplConfig(mutableOptionsBundleCreate);
    }

    @Nullable
    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    private static Config getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(Config config, long j) {
        Config.Option<Long> option = STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (config.containsOption(option) && ((Long) config.retrieveOption(option)).longValue() == j) {
            return null;
        }
        MutableOptionsBundle mutableOptionsBundleFrom = MutableOptionsBundle.from(config);
        mutableOptionsBundleFrom.insertOption(option, Long.valueOf(j));
        return new Camera2ImplConfig(mutableOptionsBundleFrom);
    }

    private static boolean isEligibleCaptureType(UseCaseConfigFactory.CaptureType captureType, long j, List<UseCaseConfigFactory.CaptureType> list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (captureType != UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            Map<Long, Set<UseCaseConfigFactory.CaptureType>> map = STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
            return map.containsKey(Long.valueOf(j)) && map.get(Long.valueOf(j)).contains(captureType);
        }
        Map<Long, Set<UseCaseConfigFactory.CaptureType>> map2 = STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
        if (!map2.containsKey(Long.valueOf(j))) {
            return false;
        }
        Set<UseCaseConfigFactory.CaptureType> set = map2.get(Long.valueOf(j));
        if (list.size() != set.size()) {
            return false;
        }
        Iterator<UseCaseConfigFactory.CaptureType> it = list.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static boolean isStreamUseCaseSupported(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        long[] jArr;
        return (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) ? false : true;
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    private static boolean isValidCamera2InteropOverride(List<AttachedSurfaceInfo> list, List<UseCaseConfig<?>> list2, Set<Long> set) {
        boolean z;
        boolean z2;
        HashSet hashSet = new HashSet();
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        if (it.hasNext()) {
            AttachedSurfaceInfo next = it.next();
            Config implementationOptions = next.getImplementationOptions();
            Config.Option<Long> option = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
            if (implementationOptions.containsOption(option) && ((Long) next.getImplementationOptions().retrieveOption(option)).longValue() != 0) {
                z = true;
                z2 = false;
            } else {
                z2 = true;
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        for (UseCaseConfig<?> useCaseConfig : list2) {
            Config.Option<?> option2 = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
            if (useCaseConfig.containsOption(option2)) {
                long jLongValue = ((Long) useCaseConfig.retrieveOption(option2)).longValue();
                if (jLongValue != 0) {
                    if (z2) {
                        throwInvalidCamera2InteropOverrideException();
                    }
                    hashSet.add(Long.valueOf(jLongValue));
                    z = true;
                } else if (z) {
                    throwInvalidCamera2InteropOverrideException();
                }
            } else if (z) {
                throwInvalidCamera2InteropOverrideException();
            }
            z2 = true;
        }
        return !z2 && areStreamUseCasesAvailable(set, hashSet);
    }

    private static boolean isZslUseCase(Config config, UseCaseConfigFactory.CaptureType captureType) {
        if (((Boolean) config.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.FALSE)).booleanValue()) {
            return false;
        }
        Config.Option<Integer> option = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        return config.containsOption(option) && TemplateTypeUtil.getSessionConfigTemplateType(captureType, ((Integer) config.retrieveOption(option)).intValue()) == 5;
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static boolean populateStreamUseCaseStreamSpecOptionWithInteropOverride(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull List<AttachedSurfaceInfo> list, @NonNull Map<UseCaseConfig<?>, StreamSpec> map, @NonNull Map<AttachedSurfaceInfo, StreamSpec> map2) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        ArrayList<UseCaseConfig<?>> arrayList = new ArrayList(map.keySet());
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        while (it.hasNext()) {
            Preconditions.checkNotNull(it.next().getImplementationOptions());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Preconditions.checkNotNull(((StreamSpec) Preconditions.checkNotNull(map.get((UseCaseConfig) it2.next()))).getImplementationOptions());
        }
        long[] jArr = (long[]) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
        if (jArr != null && jArr.length != 0) {
            HashSet hashSet = new HashSet();
            for (long j : jArr) {
                hashSet.add(Long.valueOf(j));
            }
            if (isValidCamera2InteropOverride(list, arrayList, hashSet)) {
                for (AttachedSurfaceInfo attachedSurfaceInfo : list) {
                    Config implementationOptions = attachedSurfaceInfo.getImplementationOptions();
                    Config updatedImplementationOptionsWithUseCaseStreamSpecOption = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions, ((Long) implementationOptions.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                        map2.put(attachedSurfaceInfo, attachedSurfaceInfo.toStreamSpec(updatedImplementationOptionsWithUseCaseStreamSpecOption));
                    }
                }
                for (UseCaseConfig<?> useCaseConfig : arrayList) {
                    StreamSpec streamSpec = map.get(useCaseConfig);
                    Config implementationOptions2 = streamSpec.getImplementationOptions();
                    Config updatedImplementationOptionsWithUseCaseStreamSpecOption2 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions2, ((Long) implementationOptions2.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                        map.put(useCaseConfig, streamSpec.toBuilder().setImplementationOptions(updatedImplementationOptionsWithUseCaseStreamSpecOption2).build());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(@NonNull Map<UseCaseConfig<?>, StreamSpec> map, @NonNull Map<AttachedSurfaceInfo, StreamSpec> map2, @NonNull Map<Integer, AttachedSurfaceInfo> map3, @NonNull Map<Integer, UseCaseConfig<?>> map4, @NonNull List<SurfaceConfig> list) {
        for (int i = 0; i < list.size(); i++) {
            long streamUseCase = list.get(i).getStreamUseCase();
            if (map3.containsKey(Integer.valueOf(i))) {
                AttachedSurfaceInfo attachedSurfaceInfo = map3.get(Integer.valueOf(i));
                Config updatedImplementationOptionsWithUseCaseStreamSpecOption = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(attachedSurfaceInfo.getImplementationOptions(), streamUseCase);
                if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                    map2.put(attachedSurfaceInfo, attachedSurfaceInfo.toStreamSpec(updatedImplementationOptionsWithUseCaseStreamSpecOption));
                }
            } else {
                if (!map4.containsKey(Integer.valueOf(i))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                UseCaseConfig<?> useCaseConfig = map4.get(Integer.valueOf(i));
                StreamSpec streamSpec = map.get(useCaseConfig);
                Config updatedImplementationOptionsWithUseCaseStreamSpecOption2 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(streamSpec.getImplementationOptions(), streamUseCase);
                if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                    map.put(useCaseConfig, streamSpec.toBuilder().setImplementationOptions(updatedImplementationOptionsWithUseCaseStreamSpecOption2).build());
                }
            }
        }
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static void populateSurfaceToStreamUseCaseMapping(@NonNull Collection<SessionConfig> collection, @NonNull Collection<UseCaseConfig<?>> collection2, @NonNull Map<DeferrableSurface, Long> map) {
        boolean z;
        SessionConfig next;
        Config.Option<Long> option;
        ArrayList arrayList = new ArrayList(collection2);
        Iterator<SessionConfig> it = collection.iterator();
        do {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            next = it.next();
            Config implementationOptions = next.getImplementationOptions();
            option = STREAM_USE_CASE_STREAM_SPEC_OPTION;
            z = true;
            if (implementationOptions.containsOption(option) && next.getSurfaces().size() != 1) {
                Logger.e(TAG, String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", Integer.valueOf(next.getSurfaces().size())));
                return;
            }
        } while (!next.getImplementationOptions().containsOption(option));
        if (z) {
            int i = 0;
            for (SessionConfig sessionConfig : collection) {
                if (((UseCaseConfig) arrayList.get(i)).getCaptureType() == UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                    map.put(sessionConfig.getSurfaces().get(0), 1L);
                } else {
                    Config implementationOptions2 = sessionConfig.getImplementationOptions();
                    Config.Option<Long> option2 = STREAM_USE_CASE_STREAM_SPEC_OPTION;
                    if (implementationOptions2.containsOption(option2)) {
                        map.put(sessionConfig.getSurfaces().get(0), (Long) sessionConfig.getImplementationOptions().retrieveOption(option2));
                    }
                }
                i++;
            }
        }
    }

    public static boolean shouldUseStreamUseCase(@NonNull SupportedSurfaceCombination.FeatureSettings featureSettings) {
        return featureSettings.getCameraMode() == 0 && featureSettings.getRequiredMaxBitDepth() == 8;
    }

    private static void throwInvalidCamera2InteropOverrideException() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }
}
