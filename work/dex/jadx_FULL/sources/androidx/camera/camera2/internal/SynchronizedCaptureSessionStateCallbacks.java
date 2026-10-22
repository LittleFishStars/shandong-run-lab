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
final class SynchronizedCaptureSessionStateCallbacks extends SynchronizedCaptureSession.StateCallback {
    private final List<SynchronizedCaptureSession.StateCallback> mCallbacks;

    public SynchronizedCaptureSessionStateCallbacks(@NonNull List<SynchronizedCaptureSession.StateCallback> list) {
        ArrayList arrayList = new ArrayList();
        this.mCallbacks = arrayList;
        arrayList.addAll(list);
    }

    @NonNull
    public static SynchronizedCaptureSession.StateCallback createComboCallback(@NonNull SynchronizedCaptureSession.StateCallback... stateCallbackArr) {
        return new SynchronizedCaptureSessionStateCallbacks(Arrays.asList(stateCallbackArr));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onActive(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Iterator<SynchronizedCaptureSession.StateCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onActive(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    @RequiresApi(api = 26)
    public void onCaptureQueueEmpty(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Iterator<SynchronizedCaptureSession.StateCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onCaptureQueueEmpty(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Iterator<SynchronizedCaptureSession.StateCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onClosed(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Iterator<SynchronizedCaptureSession.StateCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onConfigureFailed(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Iterator<SynchronizedCaptureSession.StateCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onConfigured(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Iterator<SynchronizedCaptureSession.StateCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onReady(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onSessionFinished(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        Iterator<SynchronizedCaptureSession.StateCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onSessionFinished(synchronizedCaptureSession);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    @RequiresApi(api = 23)
    public void onSurfacePrepared(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
        Iterator<SynchronizedCaptureSession.StateCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onSurfacePrepared(synchronizedCaptureSession, surface);
        }
    }

    @RequiresApi(21)
    public static class Adapter extends SynchronizedCaptureSession.StateCallback {

        @NonNull
        private final CameraCaptureSession.StateCallback mCameraCaptureSessionStateCallback;

        public Adapter(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.mCameraCaptureSessionStateCallback = stateCallback;
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onActive(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onActive(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        @RequiresApi(api = 26)
        public void onCaptureQueueEmpty(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            ApiCompat.Api26Impl.onCaptureQueueEmpty(this.mCameraCaptureSessionStateCallback, synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onClosed(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onConfigureFailed(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onConfigured(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onReady(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSessionFinished(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        @RequiresApi(api = 23)
        public void onSurfacePrepared(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
            ApiCompat.Api23Impl.onSurfacePrepared(this.mCameraCaptureSessionStateCallback, synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession(), surface);
        }

        public Adapter(@NonNull List<CameraCaptureSession.StateCallback> list) {
            this(CameraCaptureSessionStateCallbacks.createComboCallback(list));
        }
    }
}
