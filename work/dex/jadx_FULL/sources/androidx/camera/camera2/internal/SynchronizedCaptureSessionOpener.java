package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseDeferrableSurface;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
final class SynchronizedCaptureSessionOpener {

    @NonNull
    private final OpenerImpl mImpl;

    public static class Builder {
        private final Quirks mCameraQuirks;
        private final CaptureSessionRepository mCaptureSessionRepository;
        private final Handler mCompatHandler;
        private final Quirks mDeviceQuirks;
        private final Executor mExecutor;
        private final boolean mQuirkExist;
        private final ScheduledExecutorService mScheduledExecutorService;

        public Builder(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler, @NonNull CaptureSessionRepository captureSessionRepository, @NonNull Quirks quirks, @NonNull Quirks quirks2) {
            this.mExecutor = executor;
            this.mScheduledExecutorService = scheduledExecutorService;
            this.mCompatHandler = handler;
            this.mCaptureSessionRepository = captureSessionRepository;
            this.mCameraQuirks = quirks;
            this.mDeviceQuirks = quirks2;
            this.mQuirkExist = new ForceCloseDeferrableSurface(quirks, quirks2).shouldForceClose() || new WaitForRepeatingRequestStart(quirks).shouldWaitRepeatingSubmit() || new ForceCloseCaptureSession(quirks2).shouldForceClose();
        }

        @NonNull
        public SynchronizedCaptureSessionOpener build() {
            return new SynchronizedCaptureSessionOpener(this.mQuirkExist ? new SynchronizedCaptureSessionImpl(this.mCameraQuirks, this.mDeviceQuirks, this.mCaptureSessionRepository, this.mExecutor, this.mScheduledExecutorService, this.mCompatHandler) : new SynchronizedCaptureSessionBaseImpl(this.mCaptureSessionRepository, this.mExecutor, this.mScheduledExecutorService, this.mCompatHandler));
        }
    }

    public interface OpenerImpl {
        @NonNull
        SessionConfigurationCompat createSessionConfigurationCompat(int i, @NonNull List<OutputConfigurationCompat> list, @NonNull SynchronizedCaptureSession.StateCallback stateCallback);

        @NonNull
        Executor getExecutor();

        @NonNull
        ListenableFuture<Void> openCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list);

        @NonNull
        ListenableFuture<List<Surface>> startWithDeferrableSurface(@NonNull List<DeferrableSurface> list, long j);

        boolean stop();
    }

    public SynchronizedCaptureSessionOpener(@NonNull OpenerImpl openerImpl) {
        this.mImpl = openerImpl;
    }

    @NonNull
    public SessionConfigurationCompat createSessionConfigurationCompat(int i, @NonNull List<OutputConfigurationCompat> list, @NonNull SynchronizedCaptureSession.StateCallback stateCallback) {
        return this.mImpl.createSessionConfigurationCompat(i, list, stateCallback);
    }

    @NonNull
    public Executor getExecutor() {
        return this.mImpl.getExecutor();
    }

    @NonNull
    public ListenableFuture<Void> openCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list) {
        return this.mImpl.openCaptureSession(cameraDevice, sessionConfigurationCompat, list);
    }

    @NonNull
    public ListenableFuture<List<Surface>> startWithDeferrableSurface(@NonNull List<DeferrableSurface> list, long j) {
        return this.mImpl.startWithDeferrableSurface(list, j);
    }

    public boolean stop() {
        return this.mImpl.stop();
    }
}
