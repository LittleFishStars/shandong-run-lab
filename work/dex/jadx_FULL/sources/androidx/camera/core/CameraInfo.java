package androidx.camera.core;

import android.util.Range;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import androidx.p002lifecycle.LiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface CameraInfo {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final float INTRINSIC_ZOOM_RATIO_UNKNOWN = 1.0f;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ImplementationType {
    }

    @NonNull
    CameraSelector getCameraSelector();

    @NonNull
    LiveData<CameraState> getCameraState();

    @NonNull
    ExposureState getExposureState();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    String getImplementationType();

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false)
    default float getIntrinsicZoomRatio() {
        return 1.0f;
    }

    default int getLensFacing() {
        return -1;
    }

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int i);

    @NonNull
    default Set<Range<Integer>> getSupportedFrameRateRanges() {
        return Collections.emptySet();
    }

    @NonNull
    LiveData<Integer> getTorchState();

    @NonNull
    LiveData<ZoomState> getZoomState();

    boolean hasFlashUnit();

    default boolean isFocusMeteringSupported(@NonNull FocusMeteringAction focusMeteringAction) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default boolean isPrivateReprocessingSupported() {
        return false;
    }

    @ExperimentalZeroShutterLag
    default boolean isZslSupported() {
        return false;
    }
}
