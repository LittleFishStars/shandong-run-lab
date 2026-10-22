package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class CameraCaptureSessionStateCallbacks {

    @RequiresApi(21)
    public static final class ComboSessionStateCallback extends CameraCaptureSession.StateCallback {
        private final List<CameraCaptureSession.StateCallback> mCallbacks = new ArrayList();

        public ComboSessionStateCallback(@NonNull List<CameraCaptureSession.StateCallback> list) {
            for (CameraCaptureSession.StateCallback stateCallback : list) {
                if (!(stateCallback instanceof NoOpSessionStateCallback)) {
                    this.mCallbacks.add(stateCallback);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
            Iterator<CameraCaptureSession.StateCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onActive(cameraCaptureSession);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        @RequiresApi(api = 26)
        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
            Iterator<CameraCaptureSession.StateCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                ApiCompat.Api26Impl.onCaptureQueueEmpty(it.next(), cameraCaptureSession);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
            Iterator<CameraCaptureSession.StateCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onClosed(cameraCaptureSession);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            Iterator<CameraCaptureSession.StateCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onConfigureFailed(cameraCaptureSession);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Iterator<CameraCaptureSession.StateCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onConfigured(cameraCaptureSession);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            Iterator<CameraCaptureSession.StateCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onReady(cameraCaptureSession);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        @RequiresApi(api = 23)
        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
            Iterator<CameraCaptureSession.StateCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                ApiCompat.Api23Impl.onSurfacePrepared(it.next(), cameraCaptureSession, surface);
            }
        }
    }

    public static final class NoOpSessionStateCallback extends CameraCaptureSession.StateCallback {
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
        }
    }

    private CameraCaptureSessionStateCallbacks() {
    }

    @NonNull
    public static CameraCaptureSession.StateCallback createComboCallback(@NonNull List<CameraCaptureSession.StateCallback> list) {
        if (list.isEmpty()) {
            return createNoOpCallback();
        }
        return list.size() == 1 ? list.get(0) : new ComboSessionStateCallback(list);
    }

    @NonNull
    public static CameraCaptureSession.StateCallback createNoOpCallback() {
        return new NoOpSessionStateCallback();
    }

    @NonNull
    public static CameraCaptureSession.StateCallback createComboCallback(@NonNull CameraCaptureSession.StateCallback... stateCallbackArr) {
        return createComboCallback((List<CameraCaptureSession.StateCallback>) Arrays.asList(stateCallbackArr));
    }
}
