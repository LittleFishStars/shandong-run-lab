package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30795a = 131072;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f3563a = 20000000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f3564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ParsingLoadable.Parser<M> f3565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Cache f3566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheDataSource.b f3567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f3568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final PriorityTaskManager f3569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<StreamKey> f3570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f3571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f3572a;
    public final ArrayList<RunnableFutureTask<?, ?>> b;

    public class a extends RunnableFutureTask<M, IOException> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DataSource f3573a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DataSpec f3574a;

        public a(DataSource dataSource, DataSpec dataSpec) {
            this.f3573a = dataSource;
            this.f3574a = dataSpec;
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public M doWork() throws IOException {
            return (M) ParsingLoadable.f(this.f3573a, SegmentDownloader.this.f3565a, this.f3574a, 4);
        }
    }

    public static final class b implements CacheWriter.ProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30797a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f3575a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Downloader.ProgressListener f3576a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f3577b;

        public b(Downloader.ProgressListener progressListener, long j, int i, long j2, int i2) {
            this.f3576a = progressListener;
            this.f3575a = j;
            this.f30797a = i;
            this.f3577b = j2;
            this.b = i2;
        }

        public final float a() {
            long j = this.f3575a;
            if (j != -1 && j != 0) {
                return (this.f3577b * 100.0f) / j;
            }
            int i = this.f30797a;
            if (i != 0) {
                return (this.b * 100.0f) / i;
            }
            return -1.0f;
        }

        public void b() {
            this.b++;
            this.f3576a.onProgress(this.f3575a, this.f3577b, a());
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
        public void onProgress(long j, long j2, long j3) {
            long j4 = this.f3577b + j3;
            this.f3577b = j4;
            this.f3576a.onProgress(this.f3575a, j4, a());
        }
    }

    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30798a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataSpec f3578a;

        public c(long j, DataSpec dataSpec) {
            this.f30798a = j;
            this.f3578a = dataSpec;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return gj9.q(this.f30798a, cVar.f30798a);
        }
    }

    public static final class d extends RunnableFutureTask<Void, IOException> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final b f30799a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final c f3579a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CacheDataSource f3580a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CacheWriter f3581a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f3582a;

        public d(c cVar, CacheDataSource cacheDataSource, @Nullable b bVar, byte[] bArr) {
            this.f3579a = cVar;
            this.f3580a = cacheDataSource;
            this.f30799a = bVar;
            this.f3582a = bArr;
            this.f3581a = new CacheWriter(cacheDataSource, cVar.f3578a, bArr, bVar);
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public void cancelWork() {
            this.f3581a.b();
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public Void doWork() throws IOException {
            this.f3581a.a();
            b bVar = this.f30799a;
            if (bVar == null) {
                return null;
            }
            bVar.b();
            return null;
        }
    }

    public SegmentDownloader(g gVar, ParsingLoadable.Parser<M> parser, CacheDataSource.b bVar, Executor executor) {
        sb0.g(gVar.f3327a);
        this.f3564a = getCompressibleDataSpec(gVar.f3327a.f30751a);
        this.f3565a = parser;
        this.f3570a = new ArrayList<>(gVar.f3327a.f3372a);
        this.f3567a = bVar;
        this.f3571a = executor;
        this.f3566a = (Cache) sb0.g(bVar.h());
        this.f3568a = bVar.i();
        this.f3569a = bVar.j();
        this.b = new ArrayList<>();
    }

    public static boolean d(DataSpec dataSpec, DataSpec dataSpec2) {
        if (dataSpec.f5026a.equals(dataSpec2.f5026a)) {
            long j = dataSpec.f5033d;
            if (j != -1 && dataSpec.f5032c + j == dataSpec2.f5032c && gj9.c(dataSpec.f5028a, dataSpec2.f5028a) && dataSpec.b == dataSpec2.b && dataSpec.f31105a == dataSpec2.f31105a && dataSpec.f5029a.equals(dataSpec2.f5029a)) {
                return true;
            }
        }
        return false;
    }

    public static void e(List<c> list, CacheKeyFactory cacheKeyFactory) {
        HashMap map = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            String strB = cacheKeyFactory.b(cVar.f3578a);
            Integer num = (Integer) map.get(strB);
            c cVar2 = num == null ? null : list.get(num.intValue());
            if (cVar2 == null || cVar.f30798a > cVar2.f30798a + 20000000 || !d(cVar2.f3578a, cVar.f3578a)) {
                map.put(strB, Integer.valueOf(i));
                list.set(i, cVar);
                i++;
            } else {
                long j = cVar.f3578a.f5033d;
                list.set(((Integer) sb0.g(num)).intValue(), new c(cVar2.f30798a, cVar2.f3578a.f(0L, j != -1 ? cVar2.f3578a.f5033d + j : -1L)));
            }
        }
        gj9.m1(list, i, list.size());
    }

    public static DataSpec getCompressibleDataSpec(Uri uri) {
        return new DataSpec.b().j(uri).c(1).a();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0199 */
    @Override // com.google.android.exoplayer2.offline.Downloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@Nullable Downloader.ProgressListener progressListener) throws Throwable {
        SegmentDownloader<M> segmentDownloader;
        CacheDataSource cacheDataSourceE;
        byte[] bArr;
        SegmentDownloader<M> segmentDownloader2 = this;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager = segmentDownloader2.f3569a;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-1000);
        }
        try {
            CacheDataSource cacheDataSourceE2 = segmentDownloader2.f3567a.e();
            FilterableManifest manifest = segmentDownloader2.getManifest(cacheDataSourceE2, segmentDownloader2.f3564a, false);
            if (!segmentDownloader2.f3570a.isEmpty()) {
                manifest = (FilterableManifest) manifest.copy(segmentDownloader2.f3570a);
            }
            List<c> segments = segmentDownloader2.getSegments(cacheDataSourceE2, manifest, false);
            Collections.sort(segments);
            e(segments, segmentDownloader2.f3568a);
            int size = segments.size();
            int size2 = segments.size() - 1;
            int i = 0;
            long j = 0;
            long j2 = 0;
            while (size2 >= 0) {
                try {
                    DataSpec dataSpec = segments.get(size2).f3578a;
                    String strB = segmentDownloader2.f3568a.b(dataSpec);
                    long j3 = dataSpec.f5033d;
                    if (j3 == -1) {
                        long jA = ContentMetadata.a(segmentDownloader2.f3566a.c(strB));
                        if (jA != -1) {
                            j3 = jA - dataSpec.f5032c;
                        }
                    }
                    ArrayDeque arrayDeque3 = arrayDeque;
                    long cachedBytes = segmentDownloader2.f3566a.getCachedBytes(strB, dataSpec.f5032c, j3);
                    j2 += cachedBytes;
                    if (j3 != -1) {
                        if (j3 == cachedBytes) {
                            i++;
                            segments.remove(size2);
                        }
                        if (j != -1) {
                            j += j3;
                        }
                    } else {
                        j = -1;
                    }
                    size2--;
                    segmentDownloader2 = this;
                    arrayDeque = arrayDeque3;
                } catch (Throwable th) {
                    th = th;
                    segmentDownloader = this;
                    for (int i2 = 0; i2 < segmentDownloader.b.size(); i2++) {
                        segmentDownloader.b.get(i2).cancel(true);
                    }
                    for (int size3 = segmentDownloader.b.size() - 1; size3 >= 0; size3--) {
                        segmentDownloader.b.get(size3).c();
                        segmentDownloader.f(size3);
                    }
                    PriorityTaskManager priorityTaskManager2 = segmentDownloader.f3569a;
                    if (priorityTaskManager2 != null) {
                        priorityTaskManager2.e(-1000);
                    }
                    throw th;
                }
            }
            ArrayDeque arrayDeque4 = arrayDeque;
            b bVar = progressListener != null ? new b(progressListener, j, size, j2, i) : null;
            arrayDeque4.addAll(segments);
            segmentDownloader = this;
            while (!segmentDownloader.f3572a && !arrayDeque4.isEmpty()) {
                PriorityTaskManager priorityTaskManager3 = segmentDownloader.f3569a;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.b(-1000);
                }
                if (arrayDeque2.isEmpty()) {
                    cacheDataSourceE = segmentDownloader.f3567a.e();
                    bArr = new byte[131072];
                } else {
                    d dVar = (d) arrayDeque2.removeFirst();
                    cacheDataSourceE = dVar.f3580a;
                    bArr = dVar.f3582a;
                }
                d dVar2 = new d((c) arrayDeque4.removeFirst(), cacheDataSourceE, bVar, bArr);
                segmentDownloader.c(dVar2);
                segmentDownloader.f3571a.execute(dVar2);
                for (int size4 = segmentDownloader.b.size() - 1; size4 >= 0; size4--) {
                    d dVar3 = (d) segmentDownloader.b.get(size4);
                    if (arrayDeque4.isEmpty() || dVar3.isDone()) {
                        try {
                            dVar3.get();
                            segmentDownloader.f(size4);
                            arrayDeque2.addLast(dVar3);
                        } catch (ExecutionException e) {
                            Throwable th2 = (Throwable) sb0.g(e.getCause());
                            if (th2 instanceof PriorityTaskManager.PriorityTooLowException) {
                                arrayDeque4.addFirst(dVar3.f3579a);
                                segmentDownloader.f(size4);
                                arrayDeque2.addLast(dVar3);
                            } else {
                                if (th2 instanceof IOException) {
                                    throw ((IOException) th2);
                                }
                                gj9.s1(th2);
                            }
                        }
                    }
                }
                dVar2.d();
            }
            for (int i3 = 0; i3 < segmentDownloader.b.size(); i3++) {
                segmentDownloader.b.get(i3).cancel(true);
            }
            for (int size5 = segmentDownloader.b.size() - 1; size5 >= 0; size5--) {
                segmentDownloader.b.get(size5).c();
                segmentDownloader.f(size5);
            }
            PriorityTaskManager priorityTaskManager4 = segmentDownloader.f3569a;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.e(-1000);
            }
        } catch (Throwable th3) {
            th = th3;
            segmentDownloader = segmentDownloader2;
        }
    }

    public final <T> void c(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.b) {
            if (this.f3572a) {
                throw new InterruptedException();
            }
            this.b.add(runnableFutureTask);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        synchronized (this.b) {
            this.f3572a = true;
            for (int i = 0; i < this.b.size(); i++) {
                this.b.get(i).cancel(true);
            }
        }
    }

    public final <T> T execute(RunnableFutureTask<T, ?> runnableFutureTask, boolean z) throws Throwable {
        if (z) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e) {
                Throwable th = (Throwable) sb0.g(e.getCause());
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                gj9.s1(e);
            }
        }
        while (!this.f3572a) {
            PriorityTaskManager priorityTaskManager = this.f3569a;
            if (priorityTaskManager != null) {
                priorityTaskManager.b(-1000);
            }
            c(runnableFutureTask);
            this.f3571a.execute(runnableFutureTask);
            try {
                T t = runnableFutureTask.get();
                runnableFutureTask.c();
                g(runnableFutureTask);
                return t;
            } catch (ExecutionException e2) {
                try {
                    Throwable th2 = (Throwable) sb0.g(e2.getCause());
                    if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th2 instanceof IOException) {
                            throw ((IOException) th2);
                        }
                        gj9.s1(e2);
                    }
                    runnableFutureTask.c();
                    g(runnableFutureTask);
                } catch (Throwable th3) {
                    runnableFutureTask.c();
                    g(runnableFutureTask);
                    throw th3;
                }
            }
        }
        throw new InterruptedException();
    }

    public final void f(int i) {
        synchronized (this.b) {
            this.b.remove(i);
        }
    }

    public final void g(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.b) {
            this.b.remove(runnableFutureTask);
        }
    }

    public final M getManifest(DataSource dataSource, DataSpec dataSpec, boolean z) throws InterruptedException, IOException {
        return (M) execute(new a(dataSource, dataSpec), z);
    }

    public abstract List<c> getSegments(DataSource dataSource, M m, boolean z) throws InterruptedException, IOException;

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void remove() {
        CacheDataSource cacheDataSourceF = this.f3567a.f();
        try {
            List<c> segments = getSegments(cacheDataSourceF, getManifest(cacheDataSourceF, this.f3564a, true), true);
            for (int i = 0; i < segments.size(); i++) {
                this.f3566a.removeResource(this.f3568a.b(segments.get(i).f3578a));
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (Exception unused2) {
        } finally {
            this.f3566a.removeResource(this.f3568a.b(this.f3564a));
        }
    }
}
