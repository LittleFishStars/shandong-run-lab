package com.google.android.inner_exoplayer2.offline;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.MediaItem;
import com.google.android.inner_exoplayer2.upstream.DataSpec;
import com.google.android.inner_exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.inner_exoplayer2.upstream.cache.CacheWriter;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.PriorityTaskManager;
import com.google.android.inner_exoplayer2.util.RunnableFutureTask;
import com.google.android.inner_exoplayer2.util.Util;
import com.zj.adlib.z07;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ProgressiveDownloader implements Downloader {
    private final CacheWriter cacheWriter;
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private volatile RunnableFutureTask<Void, IOException> downloadRunnable;
    private final Executor executor;
    private volatile boolean isCanceled;

    @Nullable
    private final PriorityTaskManager priorityTaskManager;

    @Nullable
    private Downloader.ProgressListener progressListener;

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new z07());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(long j, long j2, long j3) {
        Downloader.ProgressListener progressListener = this.progressListener;
        if (progressListener == null) {
            return;
        }
        progressListener.onProgress(j, j2, (j == -1 || j == 0) ? -1.0f : (j2 * 100.0f) / j);
    }

    @Override // com.google.android.inner_exoplayer2.offline.Downloader
    public void cancel() {
        this.isCanceled = true;
        RunnableFutureTask<Void, IOException> runnableFutureTask = this.downloadRunnable;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0049 */
    @Override // com.google.android.inner_exoplayer2.offline.Downloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void download(@Nullable Downloader.ProgressListener progressListener) {
        this.progressListener = progressListener;
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager != null) {
            priorityTaskManager.add(-1000);
        }
        boolean z = false;
        while (!z) {
            if (this.isCanceled) {
                break;
            }
            this.downloadRunnable = new RunnableFutureTask<Void, IOException>() { // from class: com.google.android.inner_exoplayer2.offline.ProgressiveDownloader.1
                @Override // com.google.android.inner_exoplayer2.util.RunnableFutureTask
                public void cancelWork() {
                    ProgressiveDownloader.this.cacheWriter.cancel();
                }

                @Override // com.google.android.inner_exoplayer2.util.RunnableFutureTask
                public Void doWork() throws InterruptedIOException {
                    ProgressiveDownloader.this.cacheWriter.cache();
                    return null;
                }
            };
            PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
            if (priorityTaskManager2 != null) {
                priorityTaskManager2.proceed(-1000);
            }
            this.executor.execute(this.downloadRunnable);
            try {
                this.downloadRunnable.get();
                z = true;
            } catch (ExecutionException e) {
                Throwable th = (Throwable) Assertions.checkNotNull(e.getCause());
                if (!(th instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (th instanceof IOException) {
                        throw ((IOException) th);
                    }
                    Util.sneakyThrow(th);
                }
            }
        }
        ((RunnableFutureTask) Assertions.checkNotNull(this.downloadRunnable)).blockUntilFinished();
        PriorityTaskManager priorityTaskManager3 = this.priorityTaskManager;
        if (priorityTaskManager3 != null) {
            priorityTaskManager3.remove(-1000);
        }
    }

    @Override // com.google.android.inner_exoplayer2.offline.Downloader
    public void remove() {
        this.dataSource.getCache().removeResource(this.dataSource.getCacheKeyFactory().buildCacheKey(this.dataSpec));
    }

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this.executor = (Executor) Assertions.checkNotNull(executor);
        Assertions.checkNotNull(mediaItem.localConfiguration);
        DataSpec dataSpecBuild = new DataSpec.Builder().setUri(mediaItem.localConfiguration.uri).setKey(mediaItem.localConfiguration.customCacheKey).setFlags(4).build();
        this.dataSpec = dataSpecBuild;
        CacheDataSource cacheDataSourceCreateDataSourceForDownloading = factory.createDataSourceForDownloading();
        this.dataSource = cacheDataSourceCreateDataSourceForDownloading;
        this.cacheWriter = new CacheWriter(cacheDataSourceCreateDataSourceForDownloading, dataSpecBuild, null, new CacheWriter.ProgressListener() { // from class: com.zj.adlib.j17
            @Override // com.google.android.inner_exoplayer2.upstream.cache.CacheWriter.ProgressListener
            public final void onProgress(long j, long j2, long j3) {
                this.f42487a.onProgress(j, j2, j3);
            }
        });
        this.priorityTaskManager = factory.getUpstreamPriorityTaskManager();
    }
}
