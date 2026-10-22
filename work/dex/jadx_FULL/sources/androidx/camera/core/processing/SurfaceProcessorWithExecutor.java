package androidx.camera.core.processing;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
public class SurfaceProcessorWithExecutor implements SurfaceProcessorInternal {
    private static final String TAG = "SurfaceProcessor";

    @NonNull
    private final Consumer<Throwable> mErrorListener;

    @NonNull
    private final Executor mExecutor;

    @NonNull
    private final SurfaceProcessor mSurfaceProcessor;

    public SurfaceProcessorWithExecutor(@NonNull CameraEffect cameraEffect) {
        SurfaceProcessor surfaceProcessor = cameraEffect.getSurfaceProcessor();
        Objects.requireNonNull(surfaceProcessor);
        this.mSurfaceProcessor = surfaceProcessor;
        this.mExecutor = cameraEffect.getExecutor();
        this.mErrorListener = cameraEffect.getErrorListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputSurface$0(SurfaceRequest surfaceRequest) {
        try {
            this.mSurfaceProcessor.onInputSurface(surfaceRequest);
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to setup SurfaceProcessor input.", e);
            this.mErrorListener.accept(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOutputSurface$1(SurfaceOutput surfaceOutput) {
        try {
            this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to setup SurfaceProcessor output.", e);
            this.mErrorListener.accept(e);
        }
    }

    @NonNull
    @VisibleForTesting
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @NonNull
    @VisibleForTesting
    public SurfaceProcessor getProcessor() {
        return this.mSurfaceProcessor;
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(@NonNull final SurfaceRequest surfaceRequest) {
        this.mExecutor.execute(new Runnable(this, surfaceRequest) { // from class: com.zj.adlib.hx8

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceRequest f42228a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ SurfaceProcessorWithExecutor f17090a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(@NonNull final SurfaceOutput surfaceOutput) {
        this.mExecutor.execute(new Runnable(this, surfaceOutput) { // from class: com.zj.adlib.ix8

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceOutput f42463a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ SurfaceProcessorWithExecutor f17296a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    @NonNull
    public ListenableFuture<Void> snapshot(@IntRange(from = 0, to = 100) int i, @IntRange(from = 0, to = 359) int i2) {
        return Futures.immediateFailedFuture(new Exception("Snapshot not supported by external SurfaceProcessor"));
    }
}
