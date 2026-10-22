package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface SynchronizedCaptureSession {

    public static abstract class StateCallback {
        public void onActive(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        @RequiresApi(api = 26)
        public void onCaptureQueueEmpty(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onSessionFinished(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        @RequiresApi(api = 23)
        public void onSurfacePrepared(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
        }
    }

    void abortCaptures() throws CameraAccessException;

    int captureBurstRequests(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int captureBurstRequests(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int captureSingleRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int captureSingleRequest(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    void close();

    void finishClose();

    @NonNull
    CameraDevice getDevice();

    @Nullable
    Surface getInputSurface();

    @NonNull
    ListenableFuture<Void> getOpeningBlocker();

    @NonNull
    StateCallback getStateCallback();

    int setRepeatingBurstRequests(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int setRepeatingBurstRequests(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    void stopRepeating() throws CameraAccessException;

    @NonNull
    CameraCaptureSessionCompat toCameraCaptureSessionCompat();
}
