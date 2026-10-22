package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.ShaderProvider;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class DefaultSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DefaultSurfaceProcessor";
    private final Executor mGlExecutor;

    @VisibleForTesting
    final Handler mGlHandler;
    private final OpenGlRenderer mGlRenderer;

    @VisibleForTesting
    final HandlerThread mGlThread;
    private int mInputSurfaceCount;
    private final AtomicBoolean mIsReleaseRequested;
    private boolean mIsReleased;
    final Map<SurfaceOutput, Surface> mOutputSurfaces;
    private final List<PendingSnapshot> mPendingSnapshots;
    private final float[] mSurfaceOutputMatrix;
    private final float[] mTextureMatrix;

    public static class Factory {
        private static Function<DynamicRange, SurfaceProcessorInternal> sSupplier = new Function() { // from class: com.zj.adlib.zi2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
            }
        };

        private Factory() {
        }

        @NonNull
        public static SurfaceProcessorInternal newInstance(@NonNull DynamicRange dynamicRange) {
            return sSupplier.apply(dynamicRange);
        }

        @VisibleForTesting
        public static void setSupplier(@NonNull Function<DynamicRange, SurfaceProcessorInternal> function) {
            sSupplier = function;
        }
    }

    @AutoValue
    public static abstract class PendingSnapshot {
        @NonNull
        public static AutoValue_DefaultSurfaceProcessor_PendingSnapshot of(@IntRange(from = 0, to = 100) int i, @IntRange(from = 0, to = 359) int i2, @NonNull CallbackToFutureAdapter.Completer<Void> completer) {
            return new AutoValue_DefaultSurfaceProcessor_PendingSnapshot(i, i2, completer);
        }

        @NonNull
        public abstract CallbackToFutureAdapter.Completer<Void> getCompleter();

        @IntRange(from = 0, to = 100)
        public abstract int getJpegQuality();

        @IntRange(from = 0, to = 359)
        public abstract int getRotationDegrees();
    }

    public DefaultSurfaceProcessor(@NonNull DynamicRange dynamicRange) {
        this(dynamicRange, ShaderProvider.DEFAULT);
    }

    @WorkerThread
    private void checkReadyToRelease() {
        if (this.mIsReleased && this.mInputSurfaceCount == 0) {
            Iterator<SurfaceOutput> it = this.mOutputSurfaces.keySet().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            Iterator<PendingSnapshot> it2 = this.mPendingSnapshots.iterator();
            while (it2.hasNext()) {
                it2.next().getCompleter().setException(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            this.mOutputSurfaces.clear();
            this.mGlRenderer.release();
            this.mGlThread.quit();
        }
    }

    private void executeSafely(@NonNull Runnable runnable) {
        executeSafely(runnable, new Runnable() { // from class: com.zj.adlib.ni2
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.lambda$executeSafely$10();
            }
        });
    }

    private void failAllPendingSnapshots(@NonNull Throwable th) {
        Iterator<PendingSnapshot> it = this.mPendingSnapshots.iterator();
        while (it.hasNext()) {
            it.next().getCompleter().setException(th);
        }
        this.mPendingSnapshots.clear();
    }

    @NonNull
    private Bitmap getBitmap(@NonNull Size size, @NonNull float[] fArr, int i) {
        float[] fArr2 = new float[16];
        Matrix.setIdentityM(fArr2, 0);
        MatrixExt.preVerticalFlip(fArr2, 0.5f);
        MatrixExt.preRotate(fArr2, i, 0.5f, 0.5f);
        Matrix.multiplyMM(fArr2, 0, fArr2, 0, fArr, 0);
        return this.mGlRenderer.snapshot(TransformUtils.rotateSize(size, i), fArr2);
    }

    private void initGlRenderer(@NonNull final DynamicRange dynamicRange, @NonNull final ShaderProvider shaderProvider) {
        try {
            CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this, dynamicRange, shaderProvider) { // from class: com.zj.adlib.pi2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ DynamicRange f43987a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ DefaultSurfaceProcessor f18850a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ ShaderProvider f18851a;

                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e = e;
            if (e instanceof ExecutionException) {
                e = e.getCause();
            }
            if (!(e instanceof RuntimeException)) {
                throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
            }
            throw ((RuntimeException) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$executeSafely$10() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSafely$11(Runnable runnable, Runnable runnable2) {
        if (this.mIsReleased) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGlRenderer$8(DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.Completer completer) {
        try {
            this.mGlRenderer.init(dynamicRange, shaderProvider);
            completer.set(null);
        } catch (RuntimeException e) {
            completer.setException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$initGlRenderer$9(final DynamicRange dynamicRange, final ShaderProvider shaderProvider, final CallbackToFutureAdapter.Completer completer) throws Exception {
        executeSafely(new Runnable(this, dynamicRange, shaderProvider, completer) { // from class: com.zj.adlib.mi2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DynamicRange f43310a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DefaultSurfaceProcessor f18223a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ShaderProvider f18224a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ CallbackToFutureAdapter.Completer f18225a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return "Init GlRenderer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputSurface$0(SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.Result result) {
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
        surface.release();
        this.mInputSurfaceCount--;
        checkReadyToRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputSurface$1(SurfaceRequest surfaceRequest) {
        this.mInputSurfaceCount++;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(this.mGlRenderer.getTextureName());
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, this.mGlExecutor, new Consumer(this, surfaceTexture, surface) { // from class: com.zj.adlib.qi2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceTexture f44216a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Surface f19111a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DefaultSurfaceProcessor f19112a;

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
            }
        });
        surfaceTexture.setOnFrameAvailableListener(this, this.mGlHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOutputSurface$2(SurfaceOutput surfaceOutput, SurfaceOutput.Event event) {
        surfaceOutput.close();
        Surface surfaceRemove = this.mOutputSurfaces.remove(surfaceOutput);
        if (surfaceRemove != null) {
            this.mGlRenderer.unregisterOutputSurface(surfaceRemove);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOutputSurface$3(final SurfaceOutput surfaceOutput) {
        Surface surface = surfaceOutput.getSurface(this.mGlExecutor, new Consumer(this, surfaceOutput) { // from class: com.zj.adlib.oi2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceOutput f43756a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DefaultSurfaceProcessor f18643a;

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
            }
        });
        this.mGlRenderer.registerOutputSurface(surface);
        this.mOutputSurfaces.put(surfaceOutput, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4() {
        this.mIsReleased = true;
        checkReadyToRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$snapshot$5(PendingSnapshot pendingSnapshot) {
        this.mPendingSnapshots.add(pendingSnapshot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$snapshot$6(CallbackToFutureAdapter.Completer completer) {
        completer.setException(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$snapshot$7(int i, int i2, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final AutoValue_DefaultSurfaceProcessor_PendingSnapshot autoValue_DefaultSurfaceProcessor_PendingSnapshotOf = PendingSnapshot.of(i, i2, completer);
        executeSafely(new Runnable() { // from class: androidx.camera.core.processing.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f121a.lambda$snapshot$5(autoValue_DefaultSurfaceProcessor_PendingSnapshotOf);
            }
        }, new Runnable(completer) { // from class: com.zj.adlib.xi2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CallbackToFutureAdapter.Completer f45827a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return "DefaultSurfaceProcessor#snapshot";
    }

    @WorkerThread
    private void takeSnapshotAndDrawJpeg(@Nullable Triple<Surface, Size, float[]> triple) {
        if (this.mPendingSnapshots.isEmpty()) {
            return;
        }
        if (triple == null) {
            failAllPendingSnapshots(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator<PendingSnapshot> it = this.mPendingSnapshots.iterator();
                int rotationDegrees = -1;
                int jpegQuality = -1;
                Bitmap bitmap = null;
                byte[] byteArray = null;
                while (it.hasNext()) {
                    PendingSnapshot next = it.next();
                    if (rotationDegrees != next.getRotationDegrees() || bitmap == null) {
                        rotationDegrees = next.getRotationDegrees();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        bitmap = getBitmap((Size) triple.getSecond(), (float[]) triple.getThird(), rotationDegrees);
                        jpegQuality = -1;
                    }
                    if (jpegQuality != next.getJpegQuality()) {
                        byteArrayOutputStream.reset();
                        jpegQuality = next.getJpegQuality();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, jpegQuality, byteArrayOutputStream);
                        byteArray = byteArrayOutputStream.toByteArray();
                    }
                    Surface surface = (Surface) triple.getFirst();
                    Objects.requireNonNull(byteArray);
                    ImageProcessingUtil.writeJpegBytesToSurface(surface, byteArray);
                    next.getCompleter().set(null);
                    it.remove();
                }
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            failAllPendingSnapshots(e);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture) {
        if (this.mIsReleaseRequested.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.mTextureMatrix);
        Triple<Surface, Size, float[]> triple = null;
        for (Map.Entry<SurfaceOutput, Surface> entry : this.mOutputSurfaces.entrySet()) {
            Surface value = entry.getValue();
            SurfaceOutput key = entry.getKey();
            key.updateTransformMatrix(this.mSurfaceOutputMatrix, this.mTextureMatrix);
            if (key.getFormat() == 34) {
                try {
                    this.mGlRenderer.render(surfaceTexture.getTimestamp(), this.mSurfaceOutputMatrix, value);
                } catch (RuntimeException e) {
                    Logger.e(TAG, "Failed to render with OpenGL.", e);
                }
            } else {
                Preconditions.checkState(key.getFormat() == 256, "Unsupported format: " + key.getFormat());
                Preconditions.checkState(triple == null, "Only one JPEG output is supported.");
                triple = new Triple<>(value, key.getSize(), (float[]) this.mSurfaceOutputMatrix.clone());
            }
        }
        try {
            takeSnapshotAndDrawJpeg(triple);
        } catch (RuntimeException e2) {
            failAllPendingSnapshots(e2);
        }
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(@NonNull final SurfaceRequest surfaceRequest) {
        if (this.mIsReleaseRequested.get()) {
            surfaceRequest.willNotProvideSurface();
            return;
        }
        Runnable runnable = new Runnable(this, surfaceRequest) { // from class: com.zj.adlib.ui2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceRequest f45152a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DefaultSurfaceProcessor f20076a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        };
        Objects.requireNonNull(surfaceRequest);
        executeSafely(runnable, new Runnable(surfaceRequest) { // from class: com.zj.adlib.vi2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceRequest f45359a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(@NonNull final SurfaceOutput surfaceOutput) {
        if (this.mIsReleaseRequested.get()) {
            surfaceOutput.close();
            return;
        }
        Runnable runnable = new Runnable(this, surfaceOutput) { // from class: com.zj.adlib.ri2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceOutput f44462a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DefaultSurfaceProcessor f19334a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        };
        Objects.requireNonNull(surfaceOutput);
        executeSafely(runnable, new Runnable(surfaceOutput) { // from class: com.zj.adlib.si2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceOutput f44696a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
        if (this.mIsReleaseRequested.getAndSet(true)) {
            return;
        }
        executeSafely(new Runnable(this) { // from class: com.zj.adlib.yi2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DefaultSurfaceProcessor f46034a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    @NonNull
    public ListenableFuture<Void> snapshot(@IntRange(from = 0, to = 100) final int i, @IntRange(from = 0, to = 359) final int i2) {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this, i, i2) { // from class: com.zj.adlib.wi2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f45602a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DefaultSurfaceProcessor f20448a;
            public final /* synthetic */ int b;

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            }
        }));
    }

    public DefaultSurfaceProcessor(@NonNull DynamicRange dynamicRange, @NonNull ShaderProvider shaderProvider) {
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mTextureMatrix = new float[16];
        this.mSurfaceOutputMatrix = new float[16];
        this.mOutputSurfaces = new LinkedHashMap();
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mPendingSnapshots = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.mGlThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mGlHandler = handler;
        this.mGlExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mGlRenderer = new OpenGlRenderer();
        try {
            initGlRenderer(dynamicRange, shaderProvider);
        } catch (RuntimeException e) {
            release();
            throw e;
        }
    }

    private void executeSafely(@NonNull final Runnable runnable, @NonNull final Runnable runnable2) {
        try {
            this.mGlExecutor.execute(new Runnable(this, runnable2, runnable) { // from class: com.zj.adlib.ti2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ DefaultSurfaceProcessor f44929a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Runnable f19826a;
                public final /* synthetic */ Runnable b;

                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.w(TAG, "Unable to executor runnable", e);
            runnable2.run();
        }
    }
}
