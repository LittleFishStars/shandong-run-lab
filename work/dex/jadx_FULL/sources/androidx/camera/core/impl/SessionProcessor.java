package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraInfo;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface SessionProcessor {

    public interface CaptureCallback {
        default void onCaptureCompleted(long j, int i, @NonNull Map<CaptureResult.Key, Object> map) {
        }

        default void onCaptureFailed(int i) {
        }

        default void onCaptureProcessStarted(int i) {
        }

        default void onCaptureSequenceAborted(int i) {
        }

        default void onCaptureSequenceCompleted(int i) {
        }

        default void onCaptureStarted(int i, long j) {
        }
    }

    void abortCapture(int i);

    void deInitSession();

    @Nullable
    default Pair<Long, Long> getRealtimeCaptureLatency() {
        return null;
    }

    @NonNull
    @RestrictedCameraControl.CameraOperation
    default Set<Integer> getSupportedCameraOperations() {
        return Collections.emptySet();
    }

    @NonNull
    SessionConfig initSession(@NonNull CameraInfo cameraInfo, @NonNull OutputSurface outputSurface, @NonNull OutputSurface outputSurface2, @Nullable OutputSurface outputSurface3);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(@NonNull RequestProcessor requestProcessor);

    void setParameters(@NonNull Config config);

    int startCapture(@NonNull CaptureCallback captureCallback);

    int startRepeating(@NonNull CaptureCallback captureCallback);

    default int startTrigger(@NonNull Config config, @NonNull CaptureCallback captureCallback) {
        return -1;
    }

    void stopRepeating();
}
