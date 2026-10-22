package com.kwad.sdk.core.imageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecodingInfo;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingProgressListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class LoadAndDisplayImageTask implements IoUtils.CopyListener, Runnable {
    private static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
    private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PROCESSOR_FOR_DISK_CACHE_NULL = "Bitmap processor for disk cache returned null [%s]";
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISK = "Cache image on disk [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISK_CACHE = "Load image from disk cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK = "Process image before cache on disk [%s]";
    private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disk cache [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    final ImageAware imageAware;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageLoadingListener listener;
    private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    final DisplayImageOptions options;
    final ImageLoadingProgressListener progressListener;
    private final ImageDownloader slowNetworkDownloader;
    private final boolean syncLoading;
    private final ImageSize targetSize;
    final String uri;

    public static class FireCancelEventRunnable implements Runnable {
        private WeakReference<LoadAndDisplayImageTask> weakReference;

        public FireCancelEventRunnable(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.weakReference = new WeakReference<>(loadAndDisplayImageTask);
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = this.weakReference.get();
            if (loadAndDisplayImageTask != null) {
                loadAndDisplayImageTask.listener.onLoadingCancelled(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView());
            }
        }
    }

    public static class FireFailEventRunnable implements Runnable {
        final Throwable failCause;
        final FailReason.FailType failType;
        private WeakReference<LoadAndDisplayImageTask> weakReference;

        public FireFailEventRunnable(LoadAndDisplayImageTask loadAndDisplayImageTask, FailReason.FailType failType, Throwable th) {
            this.weakReference = new WeakReference<>(loadAndDisplayImageTask);
            this.failCause = th;
            this.failType = failType;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = this.weakReference.get();
            if (loadAndDisplayImageTask != null) {
                if (loadAndDisplayImageTask.options.shouldShowImageOnFail()) {
                    loadAndDisplayImageTask.imageAware.setImageDrawable(loadAndDisplayImageTask.options.getImageOnFail(loadAndDisplayImageTask.configuration.resources));
                }
                loadAndDisplayImageTask.listener.onLoadingFailed(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), new FailReason(this.failType, this.failCause));
            }
        }
    }

    public class TaskCancelledException extends Exception {
        private static final long serialVersionUID = -504619855289909996L;

        public TaskCancelledException() {
        }
    }

    public LoadAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        ImageLoaderConfiguration imageLoaderConfiguration = imageLoaderEngine.configuration;
        this.configuration = imageLoaderConfiguration;
        this.downloader = imageLoaderConfiguration.downloader;
        this.networkDeniedDownloader = imageLoaderConfiguration.networkDeniedDownloader;
        this.slowNetworkDownloader = imageLoaderConfiguration.slowNetworkDownloader;
        this.decoder = imageLoaderConfiguration.decoder;
        this.uri = imageLoadingInfo.uri;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.imageAware = imageLoadingInfo.imageAware;
        this.targetSize = imageLoadingInfo.targetSize;
        DisplayImageOptions displayImageOptions = imageLoadingInfo.options;
        this.options = displayImageOptions;
        this.listener = imageLoadingInfo.listener;
        this.progressListener = imageLoadingInfo.progressListener;
        this.syncLoading = displayImageOptions.isSyncLoading();
    }

    private void checkTaskInterrupted() throws TaskCancelledException {
        if (isTaskInterrupted()) {
            throw new TaskCancelledException();
        }
    }

    private void checkTaskNotActual() throws TaskCancelledException {
        checkViewCollected();
        checkViewReused();
    }

    private void checkViewCollected() throws TaskCancelledException {
        if (isViewCollected()) {
            throw new TaskCancelledException();
        }
    }

    private void checkViewReused() throws TaskCancelledException {
        if (isViewReused()) {
            throw new TaskCancelledException();
        }
    }

    private DecodedResult decodeImage(String str) {
        return this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, str, this.uri, this.targetSize, this.imageAware.getScaleType(), getDownloader(), this.options, this.listener));
    }

    private boolean delayIfNeed() {
        if (!this.options.shouldDelayBeforeLoading()) {
            return false;
        }
        L.d(LOG_DELAY_BEFORE_LOADING, Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
        try {
            Thread.sleep(this.options.getDelayBeforeLoading());
            return isTaskNotActual();
        } catch (InterruptedException unused) {
            L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
            return true;
        }
    }

    private boolean downloadImage() {
        InputStream stream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
        if (stream == null) {
            L.e(ERROR_NO_IMAGE_STREAM, this.memoryCacheKey);
            return false;
        }
        try {
            return this.configuration.diskCache.save(this.uri, stream, this);
        } finally {
            b.closeQuietly(stream);
        }
    }

    private void fireCancelEvent() {
        if (this.syncLoading || isTaskInterrupted()) {
            return;
        }
        runTask(new FireCancelEventRunnable(this), false, this.handler, this.engine);
    }

    private void fireFailEvent(FailReason.FailType failType, Throwable th) {
        if (this.syncLoading || isTaskInterrupted() || isTaskNotActual()) {
            return;
        }
        runTask(new FireFailEventRunnable(this, failType, th), false, this.handler, this.engine);
    }

    private boolean fireProgressEvent(final int i, final int i2) {
        if (isTaskInterrupted() || isTaskNotActual()) {
            return false;
        }
        if (this.progressListener == null) {
            return true;
        }
        runTask(new Runnable() { // from class: com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.1
            @Override // java.lang.Runnable
            public void run() {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.progressListener.onProgressUpdate(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), i, i2);
            }
        }, false, this.handler, this.engine);
        return true;
    }

    private ImageDownloader getDownloader() {
        if (this.engine.isNetworkDenied()) {
            return this.networkDeniedDownloader;
        }
        return this.engine.isSlowNetwork() ? this.slowNetworkDownloader : this.downloader;
    }

    private boolean isTaskInterrupted() {
        if (!Thread.interrupted()) {
            return false;
        }
        L.d(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
        return true;
    }

    private boolean isTaskNotActual() {
        return isViewCollected() || isViewReused();
    }

    private boolean isViewCollected() {
        if (!this.imageAware.isCollected()) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED, this.memoryCacheKey);
        return true;
    }

    private boolean isViewReused() {
        if (!(!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware)))) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED, this.memoryCacheKey);
        return true;
    }

    private boolean resizeAndSaveImage(int i, int i2) {
        File file = this.configuration.diskCache.get(this.uri);
        if (file == null || !file.exists()) {
            return false;
        }
        DecodedResult decodedResultDecode = this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.uri, new ImageSize(i, i2), ViewScaleType.FIT_INSIDE, getDownloader(), new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build(), this.listener));
        Bitmap bitmapProcess = decodedResultDecode != null ? decodedResultDecode.mBitmap : null;
        if (bitmapProcess != null && this.configuration.processorForDiskCache != null) {
            L.d(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK, this.memoryCacheKey);
            bitmapProcess = this.configuration.processorForDiskCache.process(bitmapProcess);
            if (bitmapProcess == null) {
                L.e(ERROR_PROCESSOR_FOR_DISK_CACHE_NULL, this.memoryCacheKey);
            }
        }
        if (bitmapProcess == null) {
            return false;
        }
        boolean zSave = this.configuration.diskCache.save(this.uri, bitmapProcess);
        bitmapProcess.recycle();
        return zSave;
    }

    public static void runTask(Runnable runnable, boolean z, Handler handler, ImageLoaderEngine imageLoaderEngine) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            imageLoaderEngine.fireCallback(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private boolean tryCacheImageOnDisk() {
        L.d(LOG_CACHE_IMAGE_ON_DISK, this.memoryCacheKey);
        try {
            boolean zDownloadImage = downloadImage();
            if (zDownloadImage) {
                ImageLoaderConfiguration imageLoaderConfiguration = this.configuration;
                int i = imageLoaderConfiguration.maxImageWidthForDiskCache;
                int i2 = imageLoaderConfiguration.maxImageHeightForDiskCache;
                if (i > 0 || i2 > 0) {
                    L.d(LOG_RESIZE_CACHED_IMAGE_FILE, this.memoryCacheKey);
                    resizeAndSaveImage(i, i2);
                }
            }
            return zDownloadImage;
        } catch (IOException e) {
            L.e(e);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0049 A[Catch: all -> 0x0093, OutOfMemoryError -> 0x0098, IOException -> 0x009d, TaskCancelledException -> 0x00c1, IllegalStateException -> 0x00c4, TryCatch #7 {TaskCancelledException -> 0x00c1, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0015, B:9:0x001f, B:13:0x0043, B:24:0x0087, B:26:0x008d, B:15:0x0049, B:17:0x0062, B:19:0x0068, B:21:0x0074, B:22:0x007e), top: B:47:0x0001 }] */
    private DecodedResult tryLoadBitmap() throws TaskCancelledException {
        DecodedResult decodedResultDecodeImage;
        String strWrap;
        File file;
        DecodedResult decodedResult = null;
        try {
            try {
                File file2 = this.configuration.diskCache.get(this.uri);
                if (file2 == null || !file2.exists() || file2.length() <= 0) {
                    decodedResultDecodeImage = null;
                } else {
                    L.d(LOG_LOAD_IMAGE_FROM_DISK_CACHE, this.memoryCacheKey);
                    this.loadedFrom = LoadedFrom.DISC_CACHE;
                    checkTaskNotActual();
                    decodedResultDecodeImage = decodeImage(ImageDownloader.Scheme.FILE.wrap(file2.getAbsolutePath()));
                }
                if (decodedResultDecodeImage != null) {
                    try {
                        if (!decodedResultDecodeImage.isDecoded()) {
                            L.d(LOG_LOAD_IMAGE_FROM_NETWORK, this.memoryCacheKey);
                            this.loadedFrom = LoadedFrom.NETWORK;
                            strWrap = this.uri;
                            if (this.options.isCacheOnDisk() && tryCacheImageOnDisk() && (file = this.configuration.diskCache.get(this.uri)) != null) {
                                strWrap = ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
                            }
                            checkTaskNotActual();
                            decodedResultDecodeImage = decodeImage(strWrap);
                        }
                    } catch (IOException e) {
                        DecodedResult decodedResult2 = decodedResultDecodeImage;
                        e = e;
                        decodedResult = decodedResult2;
                        L.e(e);
                        fireFailEvent(FailReason.FailType.IO_ERROR, e);
                        return decodedResult;
                    } catch (IllegalStateException unused) {
                        fireFailEvent(FailReason.FailType.NETWORK_DENIED, null);
                        return decodedResultDecodeImage;
                    } catch (OutOfMemoryError e2) {
                        DecodedResult decodedResult3 = decodedResultDecodeImage;
                        e = e2;
                        decodedResult = decodedResult3;
                        L.e(e);
                        fireFailEvent(FailReason.FailType.OUT_OF_MEMORY, e);
                        return decodedResult;
                    } catch (Throwable th) {
                        DecodedResult decodedResult4 = decodedResultDecodeImage;
                        th = th;
                        decodedResult = decodedResult4;
                        L.e(th);
                        fireFailEvent(FailReason.FailType.UNKNOWN, th);
                        return decodedResult;
                    }
                } else {
                    L.d(LOG_LOAD_IMAGE_FROM_NETWORK, this.memoryCacheKey);
                    this.loadedFrom = LoadedFrom.NETWORK;
                    strWrap = this.uri;
                    if (this.options.isCacheOnDisk()) {
                        strWrap = ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
                    }
                    checkTaskNotActual();
                    decodedResultDecodeImage = decodeImage(strWrap);
                }
                if (decodedResultDecodeImage != null && decodedResultDecodeImage.isDecoded()) {
                    return decodedResultDecodeImage;
                }
                fireFailEvent(FailReason.FailType.DECODING_ERROR, null);
                return decodedResultDecodeImage;
            } catch (TaskCancelledException e3) {
                throw e3;
            }
        } catch (IOException e4) {
            e = e4;
        } catch (IllegalStateException unused2) {
            decodedResultDecodeImage = null;
        } catch (OutOfMemoryError e5) {
            e = e5;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean waitIfPaused() {
        AtomicBoolean pause = this.engine.getPause();
        if (pause.get()) {
            synchronized (this.engine.getPauseLock()) {
                if (pause.get()) {
                    L.d(LOG_WAITING_FOR_RESUME, this.memoryCacheKey);
                    try {
                        this.engine.getPauseLock().wait();
                        L.d(LOG_RESUME_AFTER_PAUSE, this.memoryCacheKey);
                    } catch (InterruptedException unused) {
                        L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                        return true;
                    }
                }
            }
        }
        return isTaskNotActual();
    }

    public final String getLoadingUri() {
        return this.uri;
    }

    @Override // com.kwad.sdk.core.imageloader.utils.IoUtils.CopyListener
    public final boolean onBytesCopied(int i, int i2) {
        return this.syncLoading || fireProgressEvent(i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (waitIfPaused() || delayIfNeed()) {
            return;
        }
        ReentrantLock reentrantLock = this.imageLoadingInfo.loadFromUriLock;
        L.d(LOG_START_DISPLAY_IMAGE_TASK, this.memoryCacheKey);
        if (reentrantLock.isLocked()) {
            L.d(LOG_WAITING_FOR_IMAGE_LOADED, this.memoryCacheKey);
        }
        reentrantLock.lock();
        try {
            try {
                checkTaskNotActual();
                DecodedResult decodedResultTryLoadBitmap = this.configuration.memoryCache.get(this.memoryCacheKey);
                if (decodedResultTryLoadBitmap == null || !decodedResultTryLoadBitmap.isDecoded()) {
                    decodedResultTryLoadBitmap = tryLoadBitmap();
                    if (decodedResultTryLoadBitmap != null && decodedResultTryLoadBitmap.isDecoded()) {
                        checkTaskNotActual();
                        checkTaskInterrupted();
                        if (this.options.shouldPreProcess()) {
                            L.d(LOG_PREPROCESS_IMAGE, this.memoryCacheKey);
                            if (decodedResultTryLoadBitmap.mBitmap != null) {
                                decodedResultTryLoadBitmap.mBitmap = this.options.getPreProcessor().process(decodedResultTryLoadBitmap.mBitmap);
                            }
                            if (decodedResultTryLoadBitmap.mBitmap == null) {
                                L.e(ERROR_PRE_PROCESSOR_NULL, this.memoryCacheKey);
                            }
                        }
                        if (this.options.isCacheInMemory()) {
                            L.d(LOG_CACHE_IMAGE_IN_MEMORY, this.memoryCacheKey);
                            this.configuration.memoryCache.put(this.memoryCacheKey, decodedResultTryLoadBitmap);
                        }
                    }
                    reentrantLock.unlock();
                    return;
                }
                this.loadedFrom = LoadedFrom.MEMORY_CACHE;
                L.d(LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING, this.memoryCacheKey);
                if (this.options.shouldPostProcess()) {
                    L.d(LOG_POSTPROCESS_IMAGE, this.memoryCacheKey);
                    Bitmap bitmapProcess = this.options.getPostProcessor().process(decodedResultTryLoadBitmap.mBitmap);
                    decodedResultTryLoadBitmap.mBitmap = bitmapProcess;
                    if (bitmapProcess == null) {
                        L.e(ERROR_POST_PROCESSOR_NULL, this.memoryCacheKey);
                    }
                }
                checkTaskNotActual();
                checkTaskInterrupted();
                reentrantLock.unlock();
                runTask(new DisplayBitmapTask(decodedResultTryLoadBitmap, this.imageLoadingInfo, this.engine, this.loadedFrom), this.syncLoading, this.handler, this.engine);
            } catch (TaskCancelledException unused) {
                fireCancelEvent();
                reentrantLock.unlock();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
