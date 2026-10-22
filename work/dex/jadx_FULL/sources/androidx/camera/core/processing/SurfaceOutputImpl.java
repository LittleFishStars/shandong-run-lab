package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
final class SurfaceOutputImpl implements SurfaceOutput {
    private static final String TAG = "SurfaceOutputImpl";

    @Nullable
    private CameraInternal mCameraInternal;

    @NonNull
    private final ListenableFuture<Void> mCloseFuture;
    private CallbackToFutureAdapter.Completer<Void> mCloseFutureCompleter;

    @Nullable
    @GuardedBy("mLock")
    private Consumer<SurfaceOutput.Event> mEventListener;

    @Nullable
    @GuardedBy("mLock")
    private Executor mExecutor;
    private final int mFormat;
    private final Rect mInputCropRect;
    private final Size mInputSize;
    private final boolean mMirroring;
    private final int mRotationDegrees;

    @NonNull
    private Matrix mSensorToBufferTransform;

    @NonNull
    private final Size mSize;

    @NonNull
    private final Surface mSurface;
    private final int mTargets;
    private final Object mLock = new Object();

    @NonNull
    private final float[] mAdditionalTransform = new float[16];

    @NonNull
    private final float[] mInvertedTextureTransform = new float[16];

    @GuardedBy("mLock")
    private boolean mHasPendingCloseRequest = false;

    @GuardedBy("mLock")
    private boolean mIsClosed = false;

    public SurfaceOutputImpl(@NonNull Surface surface, int i, int i2, @NonNull Size size, @NonNull Size size2, @NonNull Rect rect, int i3, boolean z, @Nullable CameraInternal cameraInternal, @NonNull Matrix matrix) {
        this.mSurface = surface;
        this.mTargets = i;
        this.mFormat = i2;
        this.mSize = size;
        this.mInputSize = size2;
        this.mInputCropRect = new Rect(rect);
        this.mMirroring = z;
        this.mRotationDegrees = i3;
        this.mCameraInternal = cameraInternal;
        this.mSensorToBufferTransform = matrix;
        calculateAdditionalTransform();
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.e
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f21386a.lambda$new$0(completer);
            }
        });
    }

    private void calculateAdditionalTransform() {
        android.opengl.Matrix.setIdentityM(this.mAdditionalTransform, 0);
        MatrixExt.preVerticalFlip(this.mAdditionalTransform, 0.5f);
        MatrixExt.preRotate(this.mAdditionalTransform, this.mRotationDegrees, 0.5f, 0.5f);
        if (this.mMirroring) {
            android.opengl.Matrix.translateM(this.mAdditionalTransform, 0, 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.scaleM(this.mAdditionalTransform, 0, -1.0f, 1.0f, 1.0f);
        }
        Size sizeRotateSize = TransformUtils.rotateSize(this.mInputSize, this.mRotationDegrees);
        Matrix rectToRect = TransformUtils.getRectToRect(TransformUtils.sizeToRectF(this.mInputSize), TransformUtils.sizeToRectF(sizeRotateSize), this.mRotationDegrees, this.mMirroring);
        RectF rectF = new RectF(this.mInputCropRect);
        rectToRect.mapRect(rectF);
        float width = rectF.left / sizeRotateSize.getWidth();
        float height = ((sizeRotateSize.getHeight() - rectF.height()) - rectF.top) / sizeRotateSize.getHeight();
        float fWidth = rectF.width() / sizeRotateSize.getWidth();
        float fHeight = rectF.height() / sizeRotateSize.getHeight();
        android.opengl.Matrix.translateM(this.mAdditionalTransform, 0, width, height, 0.0f);
        android.opengl.Matrix.scaleM(this.mAdditionalTransform, 0, fWidth, fHeight, 1.0f);
        calculateInvertedTextureTransform();
        float[] fArr = this.mAdditionalTransform;
        android.opengl.Matrix.multiplyMM(fArr, 0, this.mInvertedTextureTransform, 0, fArr, 0);
    }

    private void calculateInvertedTextureTransform() {
        android.opengl.Matrix.setIdentityM(this.mInvertedTextureTransform, 0);
        MatrixExt.preVerticalFlip(this.mInvertedTextureTransform, 0.5f);
        CameraInternal cameraInternal = this.mCameraInternal;
        if (cameraInternal != null) {
            Preconditions.checkState(cameraInternal.getHasTransform(), "Camera has no transform.");
            MatrixExt.preRotate(this.mInvertedTextureTransform, this.mCameraInternal.getCameraInfo().getSensorRotationDegrees(), 0.5f, 0.5f);
            if (this.mCameraInternal.isFrontFacing()) {
                android.opengl.Matrix.translateM(this.mInvertedTextureTransform, 0, 1.0f, 0.0f, 0.0f);
                android.opengl.Matrix.scaleM(this.mInvertedTextureTransform, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        float[] fArr = this.mInvertedTextureTransform;
        android.opengl.Matrix.invertM(fArr, 0, fArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCloseFutureCompleter = completer;
        return "SurfaceOutputImpl close future complete";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestClose$1(AtomicReference atomicReference) {
        ((Consumer) atomicReference.get()).accept(SurfaceOutput.Event.of(0, this));
    }

    @Override // androidx.camera.core.SurfaceOutput, java.io.Closeable, java.lang.AutoCloseable
    @AnyThread
    public void close() {
        synchronized (this.mLock) {
            if (!this.mIsClosed) {
                this.mIsClosed = true;
            }
        }
        this.mCloseFutureCompleter.set(null);
    }

    @VisibleForTesting
    public CameraInternal getCamera() {
        return this.mCameraInternal;
    }

    @NonNull
    public ListenableFuture<Void> getCloseFuture() {
        return this.mCloseFuture;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getFormat() {
        return this.mFormat;
    }

    @VisibleForTesting
    public Rect getInputCropRect() {
        return this.mInputCropRect;
    }

    @VisibleForTesting
    public Size getInputSize() {
        return this.mInputSize;
    }

    @VisibleForTesting
    public boolean getMirroring() {
        return this.mMirroring;
    }

    @VisibleForTesting
    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @Override // androidx.camera.core.SurfaceOutput
    @NonNull
    public Matrix getSensorToBufferTransform() {
        return new Matrix(this.mSensorToBufferTransform);
    }

    @Override // androidx.camera.core.SurfaceOutput
    @NonNull
    public Size getSize() {
        return this.mSize;
    }

    @Override // androidx.camera.core.SurfaceOutput
    @NonNull
    public Surface getSurface(@NonNull Executor executor, @NonNull Consumer<SurfaceOutput.Event> consumer) {
        boolean z;
        synchronized (this.mLock) {
            this.mExecutor = executor;
            this.mEventListener = consumer;
            z = this.mHasPendingCloseRequest;
        }
        if (z) {
            requestClose();
        }
        return this.mSurface;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getTargets() {
        return this.mTargets;
    }

    @VisibleForTesting
    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mIsClosed;
        }
        return z;
    }

    public void requestClose() {
        Executor executor;
        Consumer<SurfaceOutput.Event> consumer;
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (this.mLock) {
            if (this.mExecutor == null || (consumer = this.mEventListener) == null) {
                this.mHasPendingCloseRequest = true;
            } else if (!this.mIsClosed) {
                atomicReference.set(consumer);
                executor = this.mExecutor;
                this.mHasPendingCloseRequest = false;
            }
            executor = null;
        }
        if (executor != null) {
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.core.processing.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21387a.lambda$requestClose$1(atomicReference);
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.d(TAG, "Processor executor closed. Close request not posted.", e);
            }
        }
    }

    @Override // androidx.camera.core.SurfaceOutput
    @AnyThread
    public void updateTransformMatrix(@NonNull float[] fArr, @NonNull float[] fArr2) {
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, this.mAdditionalTransform, 0);
    }
}
