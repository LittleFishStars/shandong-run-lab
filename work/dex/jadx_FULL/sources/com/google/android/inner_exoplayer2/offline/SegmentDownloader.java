package com.google.android.inner_exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.MediaItem;
import com.google.android.inner_exoplayer2.offline.FilterableManifest;
import com.google.android.inner_exoplayer2.upstream.DataSource;
import com.google.android.inner_exoplayer2.upstream.DataSpec;
import com.google.android.inner_exoplayer2.upstream.ParsingLoadable;
import com.google.android.inner_exoplayer2.upstream.cache.Cache;
import com.google.android.inner_exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.inner_exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.inner_exoplayer2.upstream.cache.CacheWriter;
import com.google.android.inner_exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.PriorityTaskManager;
import com.google.android.inner_exoplayer2.util.RunnableFutureTask;
import com.google.android.inner_exoplayer2.util.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {
    private static final int BUFFER_SIZE_BYTES = 131072;
    public static final long DEFAULT_MAX_MERGED_SEGMENT_START_TIME_DIFF_MS = 20000;
    private final ArrayList<RunnableFutureTask<?, ?>> activeRunnables;
    private final Cache cache;
    private final CacheDataSource.Factory cacheDataSourceFactory;
    private final CacheKeyFactory cacheKeyFactory;
    private final Executor executor;
    private volatile boolean isCanceled;
    private final DataSpec manifestDataSpec;
    private final ParsingLoadable.Parser<M> manifestParser;
    private final long maxMergedSegmentStartTimeDiffUs;

    @Nullable
    private final PriorityTaskManager priorityTaskManager;
    private final ArrayList<StreamKey> streamKeys;

    public static final class ProgressNotifier implements CacheWriter.ProgressListener {
        private long bytesDownloaded;
        private final long contentLength;
        private final Downloader.ProgressListener progressListener;
        private int segmentsDownloaded;
        private final int totalSegments;

        public ProgressNotifier(Downloader.ProgressListener progressListener, long j, int i, long j2, int i2) {
            this.progressListener = progressListener;
            this.contentLength = j;
            this.totalSegments = i;
            this.bytesDownloaded = j2;
            this.segmentsDownloaded = i2;
        }

        private float getPercentDownloaded() {
            long j = this.contentLength;
            if (j != -1 && j != 0) {
                return (this.bytesDownloaded * 100.0f) / j;
            }
            int i = this.totalSegments;
            if (i != 0) {
                return (this.segmentsDownloaded * 100.0f) / i;
            }
            return -1.0f;
        }

        @Override // com.google.android.inner_exoplayer2.upstream.cache.CacheWriter.ProgressListener
        public void onProgress(long j, long j2, long j3) {
            long j4 = this.bytesDownloaded + j3;
            this.bytesDownloaded = j4;
            this.progressListener.onProgress(this.contentLength, j4, getPercentDownloaded());
        }

        public void onSegmentDownloaded() {
            this.segmentsDownloaded++;
            this.progressListener.onProgress(this.contentLength, this.bytesDownloaded, getPercentDownloaded());
        }
    }

    public static class Segment implements Comparable<Segment> {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, DataSpec dataSpec) {
            this.startTimeUs = j;
            this.dataSpec = dataSpec;
        }

        @Override // java.lang.Comparable
        public int compareTo(Segment segment) {
            return Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        private final CacheWriter cacheWriter;
        public final CacheDataSource dataSource;

        @Nullable
        private final ProgressNotifier progressNotifier;
        public final Segment segment;
        public final byte[] temporaryBuffer;

        public SegmentDownloadRunnable(Segment segment, CacheDataSource cacheDataSource, @Nullable ProgressNotifier progressNotifier, byte[] bArr) {
            this.segment = segment;
            this.dataSource = cacheDataSource;
            this.progressNotifier = progressNotifier;
            this.temporaryBuffer = bArr;
            this.cacheWriter = new CacheWriter(cacheDataSource, segment.dataSpec, bArr, progressNotifier);
        }

        @Override // com.google.android.inner_exoplayer2.util.RunnableFutureTask
        public void cancelWork() {
            this.cacheWriter.cancel();
        }

        @Override // com.google.android.inner_exoplayer2.util.RunnableFutureTask
        public Void doWork() throws InterruptedIOException {
            this.cacheWriter.cache();
            ProgressNotifier progressNotifier = this.progressNotifier;
            if (progressNotifier == null) {
                return null;
            }
            progressNotifier.onSegmentDownloaded();
            return null;
        }
    }

    @Deprecated
    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, parser, factory, executor, 20000L);
    }

    private <T> void addActiveRunnable(RunnableFutureTask<T, ?> runnableFutureTask) {
        synchronized (this.activeRunnables) {
            if (this.isCanceled) {
                throw new InterruptedException();
            }
            this.activeRunnables.add(runnableFutureTask);
        }
    }

    private static boolean canMergeSegments(DataSpec dataSpec, DataSpec dataSpec2) {
        if (dataSpec.uri.equals(dataSpec2.uri)) {
            long j = dataSpec.length;
            if (j != -1 && dataSpec.position + j == dataSpec2.position && Util.areEqual(dataSpec.key, dataSpec2.key) && dataSpec.flags == dataSpec2.flags && dataSpec.httpMethod == dataSpec2.httpMethod && dataSpec.httpRequestHeaders.equals(dataSpec2.httpRequestHeaders)) {
                return true;
            }
        }
        return false;
    }

    public static DataSpec getCompressibleDataSpec(Uri uri) {
        return new DataSpec.Builder().setUri(uri).setFlags(1).build();
    }

    private static void mergeSegments(List<Segment> list, CacheKeyFactory cacheKeyFactory, long j) {
        HashMap map = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Segment segment = list.get(i2);
            String strBuildCacheKey = cacheKeyFactory.buildCacheKey(segment.dataSpec);
            Integer num = (Integer) map.get(strBuildCacheKey);
            Segment segment2 = num == null ? null : list.get(num.intValue());
            if (segment2 == null || segment.startTimeUs > segment2.startTimeUs + j || !canMergeSegments(segment2.dataSpec, segment.dataSpec)) {
                map.put(strBuildCacheKey, Integer.valueOf(i));
                list.set(i, segment);
                i++;
            } else {
                long j2 = segment.dataSpec.length;
                list.set(((Integer) Assertions.checkNotNull(num)).intValue(), new Segment(segment2.startTimeUs, segment2.dataSpec.subrange(0L, j2 != -1 ? segment2.dataSpec.length + j2 : -1L)));
            }
        }
        Util.removeRange(list, i, list.size());
    }

    private void removeActiveRunnable(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.activeRunnables) {
            this.activeRunnables.remove(runnableFutureTask);
        }
    }

    @Override // com.google.android.inner_exoplayer2.offline.Downloader
    public void cancel() {
        synchronized (this.activeRunnables) {
            this.isCanceled = true;
            for (int i = 0; i < this.activeRunnables.size(); i++) {
                this.activeRunnables.get(i).cancel(true);
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x018e */
    @Override // com.google.android.inner_exoplayer2.offline.Downloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void download(@Nullable Downloader.ProgressListener progressListener) {
        CacheDataSource cacheDataSourceCreateDataSourceForDownloading;
        byte[] bArr;
        int i;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager != null) {
            priorityTaskManager.add(-1000);
        }
        CacheDataSource cacheDataSourceCreateDataSourceForDownloading2 = this.cacheDataSourceFactory.createDataSourceForDownloading();
        FilterableManifest manifest = getManifest(cacheDataSourceCreateDataSourceForDownloading2, this.manifestDataSpec, false);
        if (!this.streamKeys.isEmpty()) {
            manifest = (FilterableManifest) manifest.copy(this.streamKeys);
        }
        List<Segment> segments = getSegments(cacheDataSourceCreateDataSourceForDownloading2, manifest, false);
        Collections.sort(segments);
        mergeSegments(segments, this.cacheKeyFactory, this.maxMergedSegmentStartTimeDiffUs);
        int size = segments.size();
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        for (int size2 = segments.size() - 1; size2 >= 0; size2 = i - 1) {
            DataSpec dataSpec = segments.get(size2).dataSpec;
            String strBuildCacheKey = this.cacheKeyFactory.buildCacheKey(dataSpec);
            long j3 = dataSpec.length;
            if (j3 == -1) {
                long contentLength = ContentMetadata.getContentLength(this.cache.getContentMetadata(strBuildCacheKey));
                if (contentLength != -1) {
                    j3 = contentLength - dataSpec.position;
                }
            }
            int i3 = size2;
            long cachedBytes = this.cache.getCachedBytes(strBuildCacheKey, dataSpec.position, j3);
            j2 += cachedBytes;
            if (j3 != -1) {
                if (j3 == cachedBytes) {
                    i2++;
                    i = i3;
                    segments.remove(i);
                } else {
                    i = i3;
                }
                if (j != -1) {
                    j += j3;
                }
            } else {
                i = i3;
                j = -1;
            }
        }
        ProgressNotifier progressNotifier = progressListener != null ? new ProgressNotifier(progressListener, j, size, j2, i2) : null;
        arrayDeque.addAll(segments);
        while (!this.isCanceled && !arrayDeque.isEmpty()) {
            PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
            if (priorityTaskManager2 != null) {
                priorityTaskManager2.proceed(-1000);
            }
            if (arrayDeque2.isEmpty()) {
                cacheDataSourceCreateDataSourceForDownloading = this.cacheDataSourceFactory.createDataSourceForDownloading();
                bArr = new byte[131072];
            } else {
                SegmentDownloadRunnable segmentDownloadRunnable = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                cacheDataSourceCreateDataSourceForDownloading = segmentDownloadRunnable.dataSource;
                bArr = segmentDownloadRunnable.temporaryBuffer;
            }
            SegmentDownloadRunnable segmentDownloadRunnable2 = new SegmentDownloadRunnable((Segment) arrayDeque.removeFirst(), cacheDataSourceCreateDataSourceForDownloading, progressNotifier, bArr);
            addActiveRunnable(segmentDownloadRunnable2);
            this.executor.execute(segmentDownloadRunnable2);
            for (int size3 = this.activeRunnables.size() - 1; size3 >= 0; size3--) {
                SegmentDownloadRunnable segmentDownloadRunnable3 = (SegmentDownloadRunnable) this.activeRunnables.get(size3);
                if (arrayDeque.isEmpty() || segmentDownloadRunnable3.isDone()) {
                    try {
                        segmentDownloadRunnable3.get();
                        removeActiveRunnable(size3);
                        arrayDeque2.addLast(segmentDownloadRunnable3);
                    } catch (ExecutionException e) {
                        Throwable th = (Throwable) Assertions.checkNotNull(e.getCause());
                        if (th instanceof PriorityTaskManager.PriorityTooLowException) {
                            arrayDeque.addFirst(segmentDownloadRunnable3.segment);
                            removeActiveRunnable(size3);
                            arrayDeque2.addLast(segmentDownloadRunnable3);
                        } else {
                            if (th instanceof IOException) {
                                throw ((IOException) th);
                            }
                            Util.sneakyThrow(th);
                        }
                    }
                }
            }
            segmentDownloadRunnable2.blockUntilStarted();
        }
        for (int i4 = 0; i4 < this.activeRunnables.size(); i4++) {
            this.activeRunnables.get(i4).cancel(true);
        }
        for (int size4 = this.activeRunnables.size() - 1; size4 >= 0; size4--) {
            this.activeRunnables.get(size4).blockUntilFinished();
            removeActiveRunnable(size4);
        }
        PriorityTaskManager priorityTaskManager3 = this.priorityTaskManager;
        if (priorityTaskManager3 != null) {
            priorityTaskManager3.remove(-1000);
        }
    }

    public final <T> T execute(RunnableFutureTask<T, ?> runnableFutureTask, boolean z) throws Throwable {
        if (z) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e) {
                Throwable th = (Throwable) Assertions.checkNotNull(e.getCause());
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                Util.sneakyThrow(e);
            }
        }
        while (!this.isCanceled) {
            PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
            if (priorityTaskManager != null) {
                priorityTaskManager.proceed(-1000);
            }
            addActiveRunnable(runnableFutureTask);
            this.executor.execute(runnableFutureTask);
            try {
                T t = runnableFutureTask.get();
                runnableFutureTask.blockUntilFinished();
                removeActiveRunnable((RunnableFutureTask<?, ?>) runnableFutureTask);
                return t;
            } catch (ExecutionException e2) {
                try {
                    Throwable th2 = (Throwable) Assertions.checkNotNull(e2.getCause());
                    if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th2 instanceof IOException) {
                            throw ((IOException) th2);
                        }
                        Util.sneakyThrow(e2);
                    }
                    runnableFutureTask.blockUntilFinished();
                    removeActiveRunnable((RunnableFutureTask<?, ?>) runnableFutureTask);
                } catch (Throwable th3) {
                    runnableFutureTask.blockUntilFinished();
                    removeActiveRunnable((RunnableFutureTask<?, ?>) runnableFutureTask);
                    throw th3;
                }
            }
        }
        throw new InterruptedException();
    }

    public final M getManifest(final DataSource dataSource, final DataSpec dataSpec, boolean z) {
        return (M) execute(new RunnableFutureTask<M, IOException>() { // from class: com.google.android.inner_exoplayer2.offline.SegmentDownloader.1
            @Override // com.google.android.inner_exoplayer2.util.RunnableFutureTask
            public M doWork() {
                return (M) ParsingLoadable.load(dataSource, SegmentDownloader.this.manifestParser, dataSpec, 4);
            }
        }, z);
    }

    public abstract List<Segment> getSegments(DataSource dataSource, M m, boolean z);

    @Override // com.google.android.inner_exoplayer2.offline.Downloader
    public final void remove() {
        CacheDataSource cacheDataSourceCreateDataSourceForRemovingDownload = this.cacheDataSourceFactory.createDataSourceForRemovingDownload();
        try {
            List<Segment> segments = getSegments(cacheDataSourceCreateDataSourceForRemovingDownload, getManifest(cacheDataSourceCreateDataSourceForRemovingDownload, this.manifestDataSpec, true), true);
            for (int i = 0; i < segments.size(); i++) {
                this.cache.removeResource(this.cacheKeyFactory.buildCacheKey(segments.get(i).dataSpec));
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (Exception unused2) {
        } finally {
            this.cache.removeResource(this.cacheKeyFactory.buildCacheKey(this.manifestDataSpec));
        }
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor, long j) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        this.manifestDataSpec = getCompressibleDataSpec(mediaItem.localConfiguration.uri);
        this.manifestParser = parser;
        this.streamKeys = new ArrayList<>(mediaItem.localConfiguration.streamKeys);
        this.cacheDataSourceFactory = factory;
        this.executor = executor;
        this.cache = (Cache) Assertions.checkNotNull(factory.getCache());
        this.cacheKeyFactory = factory.getCacheKeyFactory();
        this.priorityTaskManager = factory.getUpstreamPriorityTaskManager();
        this.activeRunnables = new ArrayList<>();
        this.maxMergedSegmentStartTimeDiffUs = Util.msToUs(j);
    }

    private void removeActiveRunnable(int i) {
        synchronized (this.activeRunnables) {
            this.activeRunnables.remove(i);
        }
    }
}
