package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class DynamicRangesCompat {
    private final DynamicRangeProfilesCompatImpl mImpl;

    public interface DynamicRangeProfilesCompatImpl {
        @NonNull
        Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(@NonNull DynamicRange dynamicRange);

        @NonNull
        Set<DynamicRange> getSupportedDynamicRanges();

        boolean isExtraLatencyPresent(@NonNull DynamicRange dynamicRange);

        @Nullable
        DynamicRangeProfiles unwrap();
    }

    public DynamicRangesCompat(@NonNull DynamicRangeProfilesCompatImpl dynamicRangeProfilesCompatImpl) {
        this.mImpl = dynamicRangeProfilesCompatImpl;
    }

    @NonNull
    public static DynamicRangesCompat fromCameraCharacteristics(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        DynamicRangesCompat dynamicRangesCompat = Build.VERSION.SDK_INT >= 33 ? toDynamicRangesCompat((DynamicRangeProfiles) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES)) : null;
        return dynamicRangesCompat == null ? DynamicRangesCompatBaseImpl.COMPAT_INSTANCE : dynamicRangesCompat;
    }

    @Nullable
    @RequiresApi(33)
    public static DynamicRangesCompat toDynamicRangesCompat(@Nullable DynamicRangeProfiles dynamicRangeProfiles) {
        if (dynamicRangeProfiles == null) {
            return null;
        }
        Preconditions.checkState(Build.VERSION.SDK_INT >= 33, "DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.");
        return new DynamicRangesCompat(new DynamicRangesCompatApi33Impl(dynamicRangeProfiles));
    }

    @NonNull
    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(@NonNull DynamicRange dynamicRange) {
        return this.mImpl.getDynamicRangeCaptureRequestConstraints(dynamicRange);
    }

    @NonNull
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mImpl.getSupportedDynamicRanges();
    }

    public boolean isExtraLatencyPresent(@NonNull DynamicRange dynamicRange) {
        return this.mImpl.isExtraLatencyPresent(dynamicRange);
    }

    @Nullable
    @RequiresApi(33)
    public DynamicRangeProfiles toDynamicRangeProfiles() {
        Preconditions.checkState(Build.VERSION.SDK_INT >= 33, "DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.");
        return this.mImpl.unwrap();
    }
}
