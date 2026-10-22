package androidx.camera.camera2.interop;

import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
@ExperimentalCamera2Interop
public final class Camera2CameraControl {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_KEY = "Camera2CameraControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    CallbackToFutureAdapter.Completer<Void> mCompleter;
    final Executor mExecutor;
    private boolean mIsActive = false;
    private boolean mPendingUpdate = false;
    final Object mLock = new Object();

    @GuardedBy("mLock")
    private Camera2ImplConfig.Builder mBuilder = new Camera2ImplConfig.Builder();
    private final Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener = new Camera2CameraControlImpl.CaptureResultListener(this) { // from class: com.zj.adlib.sa1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Camera2CameraControl f44646a;

        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
    }

    private void addCaptureRequestOptionsInternal(@NonNull CaptureRequestOptions captureRequestOptions) {
        synchronized (this.mLock) {
            for (Config.Option<?> option : captureRequestOptions.listOptions()) {
                this.mBuilder.getMutableConfig().insertOption(option, captureRequestOptions.retrieveOption(option));
            }
        }
    }

    private void clearCaptureRequestOptionsInternal() {
        synchronized (this.mLock) {
            this.mBuilder = new Camera2ImplConfig.Builder();
        }
    }

    @NonNull
    public static Camera2CameraControl from(@NonNull CameraControl cameraControl) {
        CameraControlInternal implementation = ((CameraControlInternal) cameraControl).getImplementation();
        Preconditions.checkArgument(implementation instanceof Camera2CameraControlImpl, "CameraControl doesn't contain Camera2 implementation.");
        return ((Camera2CameraControlImpl) implementation).getCamera2CameraControl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addCaptureRequestOptions$4(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable(this, completer) { // from class: com.zj.adlib.oa1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraControl f43705a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ CallbackToFutureAdapter.Completer f18594a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return "addCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$clearCaptureRequestOptions$6(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable(this, completer) { // from class: com.zj.adlib.ua1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraControl f45100a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ CallbackToFutureAdapter.Completer f20018a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return "clearCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0032  */
    public /* synthetic */ boolean lambda$new$0(TotalCaptureResult totalCaptureResult) {
        CallbackToFutureAdapter.Completer<Void> completer;
        Integer num;
        if (this.mCompleter != null) {
            Object tag = totalCaptureResult.getRequest().getTag();
            if ((tag instanceof TagBundle) && (num = (Integer) ((TagBundle) tag).getTag(TAG_KEY)) != null && num.equals(Integer.valueOf(this.mCompleter.hashCode()))) {
                completer = this.mCompleter;
                this.mCompleter = null;
            } else {
                completer = null;
            }
        } else {
            completer = null;
        }
        if (completer == null) {
            return false;
        }
        completer.set(null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setCaptureRequestOptions$2(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable(this, completer) { // from class: com.zj.adlib.va1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraControl f45315a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ CallbackToFutureAdapter.Completer f20195a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return "setCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setActiveInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$setActive$7(boolean z) {
        if (this.mIsActive == z) {
            return;
        }
        this.mIsActive = z;
        if (z) {
            if (this.mPendingUpdate) {
                updateSession();
            }
        } else {
            CallbackToFutureAdapter.Completer<Void> completer = this.mCompleter;
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("The camera control has became inactive."));
                this.mCompleter = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateConfig, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$setCaptureRequestOptions$1(CallbackToFutureAdapter.Completer<Void> completer) {
        this.mPendingUpdate = true;
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mCompleter;
        if (completer2 == null) {
            completer2 = null;
        }
        this.mCompleter = completer;
        if (this.mIsActive) {
            updateSession();
        }
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        }
    }

    private void updateSession() {
        this.mCamera2CameraControlImpl.updateSessionConfig();
        this.mPendingUpdate = false;
    }

    @NonNull
    public ListenableFuture<Void> addCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: com.zj.adlib.ra1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraControl f44407a;

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            }
        }));
    }

    @NonNull
    public ListenableFuture<Void> clearCaptureRequestOptions() {
        clearCaptureRequestOptionsInternal();
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: com.zj.adlib.qa1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraControl f44160a;

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            }
        }));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2ImplConfig getCamera2ImplConfig() {
        Camera2ImplConfig camera2ImplConfigBuild;
        synchronized (this.mLock) {
            if (this.mCompleter != null) {
                this.mBuilder.getMutableConfig().insertOption(Camera2ImplConfig.CAPTURE_REQUEST_TAG_OPTION, Integer.valueOf(this.mCompleter.hashCode()));
            }
            camera2ImplConfigBuild = this.mBuilder.build();
        }
        return camera2ImplConfigBuild;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControlImpl.CaptureResultListener getCaptureRequestListener() {
        return this.mCaptureResultListener;
    }

    @NonNull
    public CaptureRequestOptions getCaptureRequestOptions() {
        CaptureRequestOptions captureRequestOptionsBuild;
        synchronized (this.mLock) {
            captureRequestOptionsBuild = CaptureRequestOptions.Builder.from(this.mBuilder.build()).build();
        }
        return captureRequestOptionsBuild;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActive(final boolean z) {
        this.mExecutor.execute(new Runnable(this, z) { // from class: com.zj.adlib.pa1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraControl f43932a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ boolean f18809a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @NonNull
    public ListenableFuture<Void> setCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        clearCaptureRequestOptionsInternal();
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: com.zj.adlib.ta1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera2CameraControl f44877a;

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            }
        }));
    }
}
