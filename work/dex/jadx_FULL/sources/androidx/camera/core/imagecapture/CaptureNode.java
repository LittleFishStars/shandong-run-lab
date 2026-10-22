package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import com.zj.adlib.o9a;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
class CaptureNode implements Node<In, Out> {

    @VisibleForTesting
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";

    @Nullable
    private In mInputEdge;

    @Nullable
    private Out mOutputEdge;

    @Nullable
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;

    @NonNull
    private final Set<Integer> mPendingStageIds = new HashSet();
    ProcessingRequest mCurrentRequest = null;

    @AutoValue
    public static abstract class In {

        @NonNull
        private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.imagecapture.CaptureNode.In.1
        };

        @Nullable
        private DeferrableSurface mSurface;

        @NonNull
        public static In of(Size size, int i, int i2, boolean z, @Nullable ImageReaderProxyProvider imageReaderProxyProvider) {
            return new AutoValue_CaptureNode_In(size, i, i2, z, imageReaderProxyProvider, new Edge(), new Edge());
        }

        @NonNull
        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        @NonNull
        public abstract Edge<ImageCaptureException> getErrorEdge();

        @Nullable
        public abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        @NonNull
        public abstract Edge<ProcessingRequest> getRequestEdge();

        public abstract Size getSize();

        @NonNull
        public DeferrableSurface getSurface() {
            DeferrableSurface deferrableSurface = this.mSurface;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        public abstract boolean isVirtualCamera();

        public void setCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        public void setSurface(@NonNull Surface surface) {
            Preconditions.checkState(this.mSurface == null, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }
    }

    @AutoValue
    public static abstract class Out {
        public static Out of(int i, int i2) {
            return new AutoValue_CaptureNode_Out(new Edge(), new Edge(), i, i2);
        }

        public abstract Edge<ImageProxy> getImageEdge();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        public abstract Edge<ProcessingRequest> getRequestEdge();
    }

    @NonNull
    private static ImageReaderProxy createImageReaderProxy(@Nullable ImageReaderProxyProvider imageReaderProxyProvider, int i, int i2, int i3) {
        return imageReaderProxyProvider != null ? imageReaderProxyProvider.newInstance(i, i2, i3, 4, 0L) : ImageReaderProxys.createIsolatedReader(i, i2, i3, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$0(NoMetadataImageReader noMetadataImageReader, ProcessingRequest processingRequest) {
        onRequestAvailable(processingRequest);
        noMetadataImageReader.acceptProcessingRequest(processingRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$1(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (imageProxyAcquireLatestImage != null) {
                onImageProxyAvailable(imageProxyAcquireLatestImage);
            } else {
                sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", null));
            }
        } catch (IllegalStateException e) {
            sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", e));
        }
    }

    private void matchAndPropagateImage(@NonNull ImageProxy imageProxy) {
        Object tag = imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey());
        Objects.requireNonNull(tag);
        int iIntValue = ((Integer) tag).intValue();
        Preconditions.checkState(this.mPendingStageIds.contains(Integer.valueOf(iIntValue)), "Received an unexpected stage id" + iIntValue);
        this.mPendingStageIds.remove(Integer.valueOf(iIntValue));
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getImageEdge().accept(imageProxy);
        if (this.mPendingStageIds.isEmpty()) {
            ProcessingRequest processingRequest = this.mCurrentRequest;
            this.mCurrentRequest = null;
            processingRequest.onImageCaptured();
        }
    }

    private void releaseInputResources(@NonNull In in, @NonNull SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        in.getSurface().close();
        ListenableFuture<Void> terminationFuture = in.getSurface().getTerminationFuture();
        Objects.requireNonNull(safeCloseImageReaderProxy);
        terminationFuture.addListener(new o9a(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
    }

    @MainThread
    public int getCapacity() {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    @NonNull
    @VisibleForTesting
    public In getInputEdge() {
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        return in;
    }

    @NonNull
    @VisibleForTesting
    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        return safeCloseImageReaderProxy;
    }

    @MainThread
    @VisibleForTesting
    public void onImageProxyAvailable(@NonNull ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest != null) {
            matchAndPropagateImage(imageProxy);
            return;
        }
        Logger.d(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
        imageProxy.close();
    }

    @MainThread
    @VisibleForTesting
    public void onRequestAvailable(@NonNull final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        boolean z = true;
        Preconditions.checkState(getCapacity() > 0, "Too many acquire images. Close image to be able to process next.");
        if (this.mCurrentRequest != null && !this.mPendingStageIds.isEmpty()) {
            z = false;
        }
        Preconditions.checkState(z, "The previous request is not complete");
        this.mCurrentRequest = processingRequest;
        this.mPendingStageIds.addAll(processingRequest.getStageIds());
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getRequestEdge().accept(processingRequest);
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.CaptureNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Threads.checkMainThread();
                ProcessingRequest processingRequest2 = processingRequest;
                CaptureNode captureNode = CaptureNode.this;
                if (processingRequest2 == captureNode.mCurrentRequest) {
                    captureNode.mCurrentRequest = null;
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r1) {
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.processing.Node
    @MainThread
    public void release() {
        Threads.checkMainThread();
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        releaseInputResources(in, safeCloseImageReaderProxy);
    }

    @MainThread
    public void sendCaptureError(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest != null) {
            processingRequest.onCaptureFailure(imageCaptureException);
        }
    }

    @MainThread
    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }

    @Override // androidx.camera.core.processing.Node
    @NonNull
    public Out transform(@NonNull In in) {
        Consumer<ProcessingRequest> consumer;
        ImageReaderProxy imageReaderProxy;
        Preconditions.checkState(this.mInputEdge == null && this.mSafeCloseImageReaderProxy == null, "CaptureNode does not support recreation yet.");
        this.mInputEdge = in;
        Size size = in.getSize();
        int inputFormat = in.getInputFormat();
        if ((true ^ in.isVirtualCamera()) && in.getImageReaderProxyProvider() == null) {
            MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), inputFormat, 4);
            in.setCameraCaptureCallback(metadataImageReader.getCameraCaptureCallback());
            consumer = new Consumer() { // from class: androidx.camera.core.imagecapture.a
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    this.f21361a.onRequestAvailable((ProcessingRequest) obj);
                }
            };
            imageReaderProxy = metadataImageReader;
        } else {
            final NoMetadataImageReader noMetadataImageReader = new NoMetadataImageReader(createImageReaderProxy(in.getImageReaderProxyProvider(), size.getWidth(), size.getHeight(), inputFormat));
            consumer = new Consumer() { // from class: androidx.camera.core.imagecapture.b
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    this.f21362a.lambda$transform$0(noMetadataImageReader, (ProcessingRequest) obj);
                }
            };
            imageReaderProxy = noMetadataImageReader;
        }
        Surface surface = imageReaderProxy.getSurface();
        Objects.requireNonNull(surface);
        in.setSurface(surface);
        this.mSafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(imageReaderProxy);
        imageReaderProxy.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.imagecapture.c
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy2) {
                this.f21363a.lambda$transform$1(imageReaderProxy2);
            }
        }, CameraXExecutors.mainThreadExecutor());
        in.getRequestEdge().setListener(consumer);
        in.getErrorEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.d
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f21364a.sendCaptureError((ImageCaptureException) obj);
            }
        });
        Out outOf = Out.of(in.getInputFormat(), in.getOutputFormat());
        this.mOutputEdge = outOf;
        return outOf;
    }
}
