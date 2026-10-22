package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.ResolutionValidatedEncoderProfilesProvider;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.video.internal.BackupHdrProfileEncoderProfilesProvider;
import androidx.camera.video.internal.DynamicRangeMatchedEncoderProfilesProvider;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.workaround.QualityValidatedEncoderProfilesProvider;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class RecorderVideoCapabilities implements VideoCapabilities {
    private static final String TAG = "RecorderVideoCapabilities";
    private final Map<DynamicRange, CapabilitiesByQuality> mCapabilitiesMapForFullySpecifiedDynamicRange = new HashMap();
    private final Map<DynamicRange, CapabilitiesByQuality> mCapabilitiesMapForNonFullySpecifiedDynamicRange = new HashMap();
    private final EncoderProfilesProvider mProfilesProvider;

    @VisibleForTesting
    public static class CapabilitiesByQuality {
        private final VideoValidatedEncoderProfilesProxy mHighestProfiles;
        private final VideoValidatedEncoderProfilesProxy mLowestProfiles;
        private final Map<Quality, VideoValidatedEncoderProfilesProxy> mSupportedProfilesMap = new LinkedHashMap();
        private final TreeMap<Size, Quality> mAreaSortedSizeToQualityMap = new TreeMap<>(new CompareSizesByArea());

        public CapabilitiesByQuality(@NonNull EncoderProfilesProvider encoderProfilesProvider) {
            for (Quality quality : Quality.getSortedQualities()) {
                EncoderProfilesProxy encoderProfiles = getEncoderProfiles(quality, encoderProfilesProvider);
                if (encoderProfiles != null) {
                    Logger.d(RecorderVideoCapabilities.TAG, "profiles = " + encoderProfiles);
                    VideoValidatedEncoderProfilesProxy validatedProfiles = toValidatedProfiles(encoderProfiles);
                    if (validatedProfiles == null) {
                        Logger.w(RecorderVideoCapabilities.TAG, "EncoderProfiles of quality " + quality + " has no video validated profiles.");
                    } else {
                        EncoderProfilesProxy.VideoProfileProxy defaultVideoProfile = validatedProfiles.getDefaultVideoProfile();
                        this.mAreaSortedSizeToQualityMap.put(new Size(defaultVideoProfile.getWidth(), defaultVideoProfile.getHeight()), quality);
                        this.mSupportedProfilesMap.put(quality, validatedProfiles);
                    }
                }
            }
            if (this.mSupportedProfilesMap.isEmpty()) {
                Logger.e(RecorderVideoCapabilities.TAG, "No supported EncoderProfiles");
                this.mLowestProfiles = null;
                this.mHighestProfiles = null;
            } else {
                ArrayDeque arrayDeque = new ArrayDeque(this.mSupportedProfilesMap.values());
                this.mHighestProfiles = (VideoValidatedEncoderProfilesProxy) arrayDeque.peekFirst();
                this.mLowestProfiles = (VideoValidatedEncoderProfilesProxy) arrayDeque.peekLast();
            }
        }

        private static void checkQualityConstantsOrThrow(@NonNull Quality quality) {
            Preconditions.checkArgument(Quality.containsQuality(quality), "Unknown quality: " + quality);
        }

        @Nullable
        private EncoderProfilesProxy getEncoderProfiles(@NonNull Quality quality, @NonNull EncoderProfilesProvider encoderProfilesProvider) {
            Preconditions.checkState(quality instanceof Quality.ConstantQuality, "Currently only support ConstantQuality");
            return encoderProfilesProvider.getAll(((Quality.ConstantQuality) quality).getValue());
        }

        @Nullable
        private VideoValidatedEncoderProfilesProxy toValidatedProfiles(@NonNull EncoderProfilesProxy encoderProfilesProxy) {
            if (encoderProfilesProxy.getVideoProfiles().isEmpty()) {
                return null;
            }
            return VideoValidatedEncoderProfilesProxy.from(encoderProfilesProxy);
        }

        @Nullable
        public VideoValidatedEncoderProfilesProxy findHighestSupportedEncoderProfilesFor(@NonNull Size size) {
            Quality qualityFindHighestSupportedQualityFor = findHighestSupportedQualityFor(size);
            Logger.d(RecorderVideoCapabilities.TAG, "Using supported quality of " + qualityFindHighestSupportedQualityFor + " for size " + size);
            if (qualityFindHighestSupportedQualityFor == Quality.NONE) {
                return null;
            }
            VideoValidatedEncoderProfilesProxy profiles = getProfiles(qualityFindHighestSupportedQualityFor);
            if (profiles != null) {
                return profiles;
            }
            throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles for advertised quality.");
        }

        @NonNull
        public Quality findHighestSupportedQualityFor(@NonNull Size size) {
            Map.Entry<Size, Quality> entryCeilingEntry = this.mAreaSortedSizeToQualityMap.ceilingEntry(size);
            if (entryCeilingEntry != null) {
                return entryCeilingEntry.getValue();
            }
            Map.Entry<Size, Quality> entryFloorEntry = this.mAreaSortedSizeToQualityMap.floorEntry(size);
            return entryFloorEntry != null ? entryFloorEntry.getValue() : Quality.NONE;
        }

        @Nullable
        public VideoValidatedEncoderProfilesProxy getProfiles(@NonNull Quality quality) {
            checkQualityConstantsOrThrow(quality);
            if (quality == Quality.HIGHEST) {
                return this.mHighestProfiles;
            }
            return quality == Quality.LOWEST ? this.mLowestProfiles : this.mSupportedProfilesMap.get(quality);
        }

        @NonNull
        public List<Quality> getSupportedQualities() {
            return new ArrayList(this.mSupportedProfilesMap.keySet());
        }

        public boolean isQualitySupported(@NonNull Quality quality) {
            checkQualityConstantsOrThrow(quality);
            return getProfiles(quality) != null;
        }
    }

    @VisibleForTesting
    public RecorderVideoCapabilities(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> function) {
        EncoderProfilesProvider encoderProfilesProvider = cameraInfoInternal.getEncoderProfilesProvider();
        this.mProfilesProvider = new QualityValidatedEncoderProfilesProvider(new ResolutionValidatedEncoderProfilesProvider(isHlg10SupportedByCamera(cameraInfoInternal) ? new BackupHdrProfileEncoderProfilesProvider(encoderProfilesProvider, function) : encoderProfilesProvider, cameraInfoInternal.getCameraQuirks()), cameraInfoInternal, DeviceQuirks.getAll());
        for (DynamicRange dynamicRange : cameraInfoInternal.getSupportedDynamicRanges()) {
            CapabilitiesByQuality capabilitiesByQuality = new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.mProfilesProvider, dynamicRange));
            if (!capabilitiesByQuality.getSupportedQualities().isEmpty()) {
                this.mCapabilitiesMapForFullySpecifiedDynamicRange.put(dynamicRange, capabilitiesByQuality);
            }
        }
    }

    private static boolean canMatchBitDepth(@NonNull DynamicRange dynamicRange, @NonNull DynamicRange dynamicRange2) {
        Preconditions.checkState(isFullySpecified(dynamicRange2), "Fully specified range is not actually fully specified.");
        return dynamicRange.getBitDepth() == 0 || dynamicRange.getBitDepth() == dynamicRange2.getBitDepth();
    }

    private static boolean canMatchEncoding(@NonNull DynamicRange dynamicRange, @NonNull DynamicRange dynamicRange2) {
        Preconditions.checkState(isFullySpecified(dynamicRange2), "Fully specified range is not actually fully specified.");
        int encoding = dynamicRange.getEncoding();
        if (encoding == 0) {
            return true;
        }
        int encoding2 = dynamicRange2.getEncoding();
        return (encoding == 2 && encoding2 != 1) || encoding == encoding2;
    }

    private static boolean canResolve(@NonNull DynamicRange dynamicRange, @NonNull Set<DynamicRange> set) {
        if (isFullySpecified(dynamicRange)) {
            return set.contains(dynamicRange);
        }
        for (DynamicRange dynamicRange2 : set) {
            if (canMatchBitDepth(dynamicRange, dynamicRange2) && canMatchEncoding(dynamicRange, dynamicRange2)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public static RecorderVideoCapabilities from(@NonNull CameraInfo cameraInfo) {
        return new RecorderVideoCapabilities((CameraInfoInternal) cameraInfo, BackupHdrProfileEncoderProfilesProvider.DEFAULT_VALIDATOR);
    }

    @Nullable
    private CapabilitiesByQuality generateCapabilitiesForNonFullySpecifiedDynamicRange(@NonNull DynamicRange dynamicRange) {
        if (canResolve(dynamicRange, getSupportedDynamicRanges())) {
            return new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.mProfilesProvider, dynamicRange));
        }
        return null;
    }

    @Nullable
    private CapabilitiesByQuality getCapabilities(@NonNull DynamicRange dynamicRange) {
        if (isFullySpecified(dynamicRange)) {
            return this.mCapabilitiesMapForFullySpecifiedDynamicRange.get(dynamicRange);
        }
        if (this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.containsKey(dynamicRange)) {
            return this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.get(dynamicRange);
        }
        CapabilitiesByQuality capabilitiesByQualityGenerateCapabilitiesForNonFullySpecifiedDynamicRange = generateCapabilitiesForNonFullySpecifiedDynamicRange(dynamicRange);
        this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.put(dynamicRange, capabilitiesByQualityGenerateCapabilitiesForNonFullySpecifiedDynamicRange);
        return capabilitiesByQualityGenerateCapabilitiesForNonFullySpecifiedDynamicRange;
    }

    private static boolean isFullySpecified(@NonNull DynamicRange dynamicRange) {
        return (dynamicRange.getEncoding() == 0 || dynamicRange.getEncoding() == 2 || dynamicRange.getBitDepth() == 0) ? false : true;
    }

    private static boolean isHlg10SupportedByCamera(@NonNull CameraInfoInternal cameraInfoInternal) {
        for (DynamicRange dynamicRange : cameraInfoInternal.getSupportedDynamicRanges()) {
            Integer numValueOf = Integer.valueOf(dynamicRange.getEncoding());
            int bitDepth = dynamicRange.getBitDepth();
            if (numValueOf.equals(3) && bitDepth == 10) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.VideoCapabilities
    @Nullable
    public VideoValidatedEncoderProfilesProxy findHighestSupportedEncoderProfilesFor(@NonNull Size size, @NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities == null) {
            return null;
        }
        return capabilities.findHighestSupportedEncoderProfilesFor(size);
    }

    @Override // androidx.camera.video.VideoCapabilities
    @NonNull
    public Quality findHighestSupportedQualityFor(@NonNull Size size, @NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        return capabilities == null ? Quality.NONE : capabilities.findHighestSupportedQualityFor(size);
    }

    @Override // androidx.camera.video.VideoCapabilities
    @Nullable
    public VideoValidatedEncoderProfilesProxy getProfiles(@NonNull Quality quality, @NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities == null) {
            return null;
        }
        return capabilities.getProfiles(quality);
    }

    @Override // androidx.camera.video.VideoCapabilities
    @NonNull
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mCapabilitiesMapForFullySpecifiedDynamicRange.keySet();
    }

    @Override // androidx.camera.video.VideoCapabilities
    @NonNull
    public List<Quality> getSupportedQualities(@NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        return capabilities == null ? new ArrayList() : capabilities.getSupportedQualities();
    }

    @Override // androidx.camera.video.VideoCapabilities
    public boolean isQualitySupported(@NonNull Quality quality, @NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        return capabilities != null && capabilities.isQualitySupported(quality);
    }
}
