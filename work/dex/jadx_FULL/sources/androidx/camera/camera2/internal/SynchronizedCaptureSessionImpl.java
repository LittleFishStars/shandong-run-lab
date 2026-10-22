package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseDeferrableSurface;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
class SynchronizedCaptureSessionImpl extends SynchronizedCaptureSessionBaseImpl {
    private static final String TAG = "SyncCaptureSessionImpl";
    private final ForceCloseDeferrableSurface mCloseSurfaceQuirk;

    @Nullable
    @GuardedBy("mObjectLock")
    private List<DeferrableSurface> mDeferrableSurfaces;
    private final ForceCloseCaptureSession mForceCloseSessionQuirk;
    private final Object mObjectLock;

    @Nullable
    @GuardedBy("mObjectLock")
    ListenableFuture<Void> mOpeningCaptureSession;
    private final WaitForRepeatingRequestStart mWaitForOtherSessionCompleteQuirk;

    public SynchronizedCaptureSessionImpl(@NonNull Quirks quirks, @NonNull Quirks quirks2, @NonNull CaptureSessionRepository captureSessionRepository, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler) {
        super(captureSessionRepository, executor, scheduledExecutorService, handler);
        this.mObjectLock = new Object();
        this.mCloseSurfaceQuirk = new ForceCloseDeferrableSurface(quirks, quirks2);
        this.mWaitForOtherSessionCompleteQuirk = new WaitForRepeatingRequestStart(quirks);
        this.mForceCloseSessionQuirk = new ForceCloseCaptureSession(quirks2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$close$3() {
        debugLog("Session call super.close()");
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConfigured$2(SynchronizedCaptureSession synchronizedCaptureSession) {
        super.onConfigured(synchronizedCaptureSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture lambda$openCaptureSession$0(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        return super.openCaptureSession(cameraDevice, sessionConfigurationCompat, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$setSingleRepeatingRequest$1(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return super.setSingleRepeatingRequest(captureRequest, captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        debugLog("Session call close()");
        this.mWaitForOtherSessionCompleteQuirk.onSessionEnd();
        this.mWaitForOtherSessionCompleteQuirk.getStartStreamFuture().addListener(new Runnable() { // from class: androidx.camera.camera2.internal.s1
            @Override // java.lang.Runnable
            public final void run() {
                this.f21331a.lambda$close$3();
            }
        }, getExecutor());
    }

    public void debugLog(String str) {
        Logger.d(TAG, "[" + this + "] " + str);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public ListenableFuture<Void> getOpeningBlocker() {
        return this.mWaitForOtherSessionCompleteQuirk.getStartStreamFuture();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mObjectLock) {
            this.mCloseSurfaceQuirk.onSessionEnd(this.mDeferrableSurfaces);
        }
        debugLog("onClosed()");
        super.onClosed(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        debugLog("Session onConfigured()");
        this.mForceCloseSessionQuirk.onSessionConfigured(synchronizedCaptureSession, this.mCaptureSessionRepository.getCreatingCaptureSessions(), this.mCaptureSessionRepository.getCaptureSessions(), new ForceCloseCaptureSession.OnConfigured() { // from class: androidx.camera.camera2.internal.u1
            @Override // androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession.OnConfigured
            public final void run(SynchronizedCaptureSession synchronizedCaptureSession2) {
                this.f21337a.lambda$onConfigured$2(synchronizedCaptureSession2);
            }
        });
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public ListenableFuture<Void> openCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list) {
        ListenableFuture<Void> listenableFutureNonCancellationPropagating;
        synchronized (this.mObjectLock) {
            ListenableFuture<Void> listenableFutureOpenCaptureSession = this.mWaitForOtherSessionCompleteQuirk.openCaptureSession(cameraDevice, sessionConfigurationCompat, list, this.mCaptureSessionRepository.getClosingCaptureSession(), new WaitForRepeatingRequestStart.OpenCaptureSession() { // from class: androidx.camera.camera2.internal.t1
                @Override // androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.OpenCaptureSession
                public final ListenableFuture run(CameraDevice cameraDevice2, SessionConfigurationCompat sessionConfigurationCompat2, List list2) {
                    return this.f21334a.lambda$openCaptureSession$0(cameraDevice2, sessionConfigurationCompat2, list2);
                }
            });
            this.mOpeningCaptureSession = listenableFutureOpenCaptureSession;
            listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(listenableFutureOpenCaptureSession);
        }
        return listenableFutureNonCancellationPropagating;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mWaitForOtherSessionCompleteQuirk.setSingleRepeatingRequest(captureRequest, captureCallback, new WaitForRepeatingRequestStart.SingleRepeatingRequest() { // from class: androidx.camera.camera2.internal.v1
            @Override // androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.SingleRepeatingRequest
            public final int run(CaptureRequest captureRequest2, CameraCaptureSession.CaptureCallback captureCallback2) {
                return this.f21340a.lambda$setSingleRepeatingRequest$1(captureRequest2, captureCallback2);
            }
        });
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public ListenableFuture<List<Surface>> startWithDeferrableSurface(@NonNull List<DeferrableSurface> list, long j) {
        ListenableFuture<List<Surface>> listenableFutureStartWithDeferrableSurface;
        synchronized (this.mObjectLock) {
            this.mDeferrableSurfaces = list;
            listenableFutureStartWithDeferrableSurface = super.startWithDeferrableSurface(list, j);
        }
        return listenableFutureStartWithDeferrableSurface;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    public boolean stop() {
        boolean zStop;
        synchronized (this.mObjectLock) {
            if (isCameraCaptureSessionOpen()) {
                this.mCloseSurfaceQuirk.onSessionEnd(this.mDeferrableSurfaces);
            } else {
                ListenableFuture<Void> listenableFuture = this.mOpeningCaptureSession;
                if (listenableFuture != null) {
                    listenableFuture.cancel(true);
                }
            }
            zStop = super.stop();
        }
        return zStop;
    }
}
