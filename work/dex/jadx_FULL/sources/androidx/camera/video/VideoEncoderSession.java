package androidx.camera.video;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
final class VideoEncoderSession {
    private static final String TAG = "VideoEncoderSession";
    private final Executor mExecutor;
    private final Executor mSequentialExecutor;
    private final EncoderFactory mVideoEncoderFactory;
    private Encoder mVideoEncoder = null;
    private Surface mActiveSurface = null;
    private SurfaceRequest mSurfaceRequest = null;
    private Executor mOnSurfaceUpdateExecutor = null;
    private Encoder.SurfaceInput.OnSurfaceUpdateListener mOnSurfaceUpdateListener = null;
    private VideoEncoderState mVideoEncoderState = VideoEncoderState.NOT_INITIALIZED;
    private ListenableFuture<Void> mReleasedFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Void> mReleasedCompleter = null;
    private ListenableFuture<Encoder> mReadyToReleaseFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Encoder> mReadyToReleaseCompleter = null;

    /* JADX INFO: renamed from: androidx.camera.video.VideoEncoderSession$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState;

        static {
            int[] iArr = new int[VideoEncoderState.values().length];
            $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState = iArr;
            try {
                iArr[VideoEncoderState.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.PENDING_RELEASE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.RELEASED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum VideoEncoderState {
        NOT_INITIALIZED,
        INITIALIZING,
        PENDING_RELEASE,
        READY,
        RELEASED
    }

    public VideoEncoderSession(@NonNull EncoderFactory encoderFactory, @NonNull Executor executor, @NonNull Executor executor2) {
        this.mExecutor = executor2;
        this.mSequentialExecutor = executor;
        this.mVideoEncoderFactory = encoderFactory;
    }

    private void closeInternal() {
        int i = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i == 1 || i == 2) {
            terminateNow();
            return;
        }
        if (i == 3 || i == 4) {
            Logger.d(TAG, "closeInternal in " + this.mVideoEncoderState + " state");
            this.mVideoEncoderState = VideoEncoderState.PENDING_RELEASE;
            return;
        }
        if (i == 5) {
            Logger.d(TAG, "closeInternal in RELEASED state, No-op");
            return;
        }
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    }

    private void configureVideoEncoderInternal(@NonNull final SurfaceRequest surfaceRequest, @NonNull Timebase timebase, @Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, @NonNull MediaSpec mediaSpec, @NonNull final CallbackToFutureAdapter.Completer<Encoder> completer) {
        DynamicRange dynamicRange = surfaceRequest.getDynamicRange();
        try {
            Encoder encoderCreateEncoder = this.mVideoEncoderFactory.createEncoder(this.mExecutor, VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(mediaSpec, dynamicRange, videoValidatedEncoderProfilesProxy), timebase, mediaSpec.getVideoSpec(), surfaceRequest.getResolution(), dynamicRange, surfaceRequest.getExpectedFrameRate()));
            this.mVideoEncoder = encoderCreateEncoder;
            Encoder.EncoderInput input = encoderCreateEncoder.getInput();
            if (input instanceof Encoder.SurfaceInput) {
                ((Encoder.SurfaceInput) input).setOnSurfaceUpdateListener(this.mSequentialExecutor, new Encoder.SurfaceInput.OnSurfaceUpdateListener() { // from class: androidx.camera.video.t
                    @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput.OnSurfaceUpdateListener
                    public final void onSurfaceUpdate(Surface surface) {
                        this.f162a.lambda$configureVideoEncoderInternal$5(completer, surfaceRequest, surface);
                    }
                });
            } else {
                completer.setException(new AssertionError("The EncoderInput of video isn't a SurfaceInput."));
            }
        } catch (InvalidConfigException e) {
            Logger.e(TAG, "Unable to initialize video encoder.", e);
            completer.setException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mReleasedCompleter = completer;
        return "ReleasedFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$1(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mReadyToReleaseCompleter = completer;
        return "ReadyToReleaseFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$2(SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, MediaSpec mediaSpec, CallbackToFutureAdapter.Completer completer) throws Exception {
        configureVideoEncoderInternal(surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, mediaSpec, completer);
        return "ConfigureVideoEncoderFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureVideoEncoderInternal$4(Surface surface) {
        this.mOnSurfaceUpdateListener.onSurfaceUpdate(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureVideoEncoderInternal$5(CallbackToFutureAdapter.Completer completer, SurfaceRequest surfaceRequest, final Surface surface) {
        Executor executor;
        int i = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (surfaceRequest.isServiced()) {
                    Logger.d(TAG, "Not provide surface, " + Objects.toString(surfaceRequest, "EMPTY") + " is already serviced.");
                    completer.set(null);
                    closeInternal();
                    return;
                }
                this.mActiveSurface = surface;
                Logger.d(TAG, "provide surface: " + surface);
                surfaceRequest.provideSurface(surface, this.mSequentialExecutor, new Consumer() { // from class: androidx.camera.video.q
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        this.f21423a.onSurfaceRequestComplete((SurfaceRequest.Result) obj);
                    }
                });
                this.mVideoEncoderState = VideoEncoderState.READY;
                completer.set(this.mVideoEncoder);
                return;
            }
            if (i == 3) {
                if (this.mOnSurfaceUpdateListener != null && (executor = this.mOnSurfaceUpdateExecutor) != null) {
                    executor.execute(new Runnable() { // from class: androidx.camera.video.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f161a.lambda$configureVideoEncoderInternal$4(surface);
                        }
                    });
                }
                Logger.w(TAG, "Surface is updated in READY state: " + surface);
                return;
            }
            if (i != 4 && i != 5) {
                throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
            }
        }
        Logger.d(TAG, "Not provide surface in " + this.mVideoEncoderState);
        completer.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$terminateNow$3() {
        this.mReleasedCompleter.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceRequestComplete(@NonNull SurfaceRequest.Result result) {
        Logger.d(TAG, "Surface can be closed: " + result.getSurface().hashCode());
        Surface surface = result.getSurface();
        if (surface != this.mActiveSurface) {
            surface.release();
            return;
        }
        this.mActiveSurface = null;
        this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
        closeInternal();
    }

    @NonNull
    public ListenableFuture<Encoder> configure(@NonNull final SurfaceRequest surfaceRequest, @NonNull final Timebase timebase, @NonNull final MediaSpec mediaSpec, @Nullable final VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        if (AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()] != 1) {
            return Futures.immediateFailedFuture(new IllegalStateException("configure() shouldn't be called in " + this.mVideoEncoderState));
        }
        this.mVideoEncoderState = VideoEncoderState.INITIALIZING;
        this.mSurfaceRequest = surfaceRequest;
        Logger.d(TAG, "Create VideoEncoderSession: " + this);
        this.mReleasedFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.u
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f21426a.lambda$configure$0(completer);
            }
        });
        this.mReadyToReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.v
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f21427a.lambda$configure$1(completer);
            }
        });
        ListenableFuture future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.w
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f166a.lambda$configure$2(surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, mediaSpec, completer);
            }
        });
        Futures.addCallback(future, new FutureCallback<Encoder>() { // from class: androidx.camera.video.VideoEncoderSession.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Logger.w(VideoEncoderSession.TAG, "VideoEncoder configuration failed.", th);
                VideoEncoderSession.this.terminateNow();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Encoder encoder) {
            }
        }, this.mSequentialExecutor);
        return Futures.nonCancellationPropagating(future);
    }

    @Nullable
    public Surface getActiveSurface() {
        if (this.mVideoEncoderState != VideoEncoderState.READY) {
            return null;
        }
        return this.mActiveSurface;
    }

    @NonNull
    public ListenableFuture<Encoder> getReadyToReleaseFuture() {
        return Futures.nonCancellationPropagating(this.mReadyToReleaseFuture);
    }

    @Nullable
    public Encoder getVideoEncoder() {
        return this.mVideoEncoder;
    }

    public boolean isConfiguredSurfaceRequest(@NonNull SurfaceRequest surfaceRequest) {
        int i = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2 || i == 3) {
            return this.mSurfaceRequest == surfaceRequest;
        }
        if (i == 4 || i == 5) {
            return false;
        }
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    }

    public void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
        this.mOnSurfaceUpdateExecutor = executor;
        this.mOnSurfaceUpdateListener = onSurfaceUpdateListener;
    }

    @NonNull
    public ListenableFuture<Void> signalTermination() {
        closeInternal();
        return Futures.nonCancellationPropagating(this.mReleasedFuture);
    }

    public void terminateNow() {
        int i = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i == 1) {
            this.mVideoEncoderState = VideoEncoderState.RELEASED;
            return;
        }
        if (i != 2 && i != 3 && i != 4) {
            if (i != 5) {
                throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
            }
            Logger.d(TAG, "terminateNow in " + this.mVideoEncoderState + ", No-op");
            return;
        }
        this.mVideoEncoderState = VideoEncoderState.RELEASED;
        this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
        this.mSurfaceRequest = null;
        if (this.mVideoEncoder == null) {
            Logger.w(TAG, "There's no VideoEncoder to release! Finish release completer.");
            this.mReleasedCompleter.set(null);
            return;
        }
        Logger.d(TAG, "VideoEncoder is releasing: " + this.mVideoEncoder);
        this.mVideoEncoder.release();
        this.mVideoEncoder.getReleasedFuture().addListener(new Runnable() { // from class: androidx.camera.video.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f21422a.lambda$terminateNow$3();
            }
        }, this.mSequentialExecutor);
        this.mVideoEncoder = null;
    }

    @NonNull
    public String toString() {
        return "VideoEncoderSession@" + hashCode() + " for " + Objects.toString(this.mSurfaceRequest, "SURFACE_REQUEST_NOT_CONFIGURED");
    }
}
