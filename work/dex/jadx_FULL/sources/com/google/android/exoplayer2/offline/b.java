package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.z07;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements Downloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Downloader.ProgressListener f30802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f3603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheDataSource f3604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheWriter f3605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final PriorityTaskManager f3606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile RunnableFutureTask<Void, IOException> f3607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f3608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f3609a;

    public class a extends RunnableFutureTask<Void, IOException> {
        public a() {
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public void cancelWork() {
            b.this.f3605a.b();
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public Void doWork() throws IOException {
            b.this.f3605a.a();
            return null;
        }
    }

    public b(g gVar, CacheDataSource.b bVar) {
        this(gVar, bVar, new z07());
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0049 */
    @Override // com.google.android.exoplayer2.offline.Downloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable Downloader.ProgressListener progressListener) throws InterruptedException, IOException {
        this.f30802a = progressListener;
        this.f3607a = new a();
        PriorityTaskManager priorityTaskManager = this.f3606a;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-1000);
        }
        boolean z = false;
        while (!z) {
            if (this.f3609a) {
                break;
            }
            PriorityTaskManager priorityTaskManager2 = this.f3606a;
            if (priorityTaskManager2 != null) {
                priorityTaskManager2.b(-1000);
            }
            this.f3608a.execute(this.f3607a);
            try {
                this.f3607a.get();
                z = true;
            } catch (ExecutionException e) {
                Throwable th = (Throwable) sb0.g(e.getCause());
                if (!(th instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (th instanceof IOException) {
                        throw ((IOException) th);
                    }
                    gj9.s1(th);
                }
            }
        }
        this.f3607a.c();
        PriorityTaskManager priorityTaskManager3 = this.f3606a;
        if (priorityTaskManager3 != null) {
            priorityTaskManager3.e(-1000);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        this.f3609a = true;
        RunnableFutureTask<Void, IOException> runnableFutureTask = this.f3607a;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    public final void d(long j, long j2, long j3) {
        Downloader.ProgressListener progressListener = this.f30802a;
        if (progressListener == null) {
            return;
        }
        progressListener.onProgress(j, j2, (j == -1 || j == 0) ? -1.0f : (j2 * 100.0f) / j);
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void remove() {
        this.f3604a.g().removeResource(this.f3604a.h().b(this.f3603a));
    }

    public b(g gVar, CacheDataSource.b bVar, Executor executor) {
        this.f3608a = (Executor) sb0.g(executor);
        sb0.g(gVar.f3327a);
        DataSpec dataSpecA = new DataSpec.b().j(gVar.f3327a.f30751a).g(gVar.f3327a.b).c(4).a();
        this.f3603a = dataSpecA;
        CacheDataSource cacheDataSourceE = bVar.e();
        this.f3604a = cacheDataSourceE;
        this.f3605a = new CacheWriter(cacheDataSourceE, dataSpecA, null, new CacheWriter.ProgressListener() { // from class: com.zj.adlib.k17
            @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
            public final void onProgress(long j, long j2, long j3) {
                this.f42720a.d(j, j2, j3);
            }
        });
        this.f3606a = bVar.j();
    }
}
