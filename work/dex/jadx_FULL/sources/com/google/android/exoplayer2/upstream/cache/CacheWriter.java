package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.zj.adlib.d72;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class CacheWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31136a = 131072;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f5162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Cache f5163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheDataSource f5164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ProgressListener f5165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f5167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f5168a;
    public long b;
    public long c;

    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, @Nullable byte[] bArr, @Nullable ProgressListener progressListener) {
        this.f5164a = cacheDataSource;
        this.f5163a = cacheDataSource.g();
        this.f5162a = dataSpec;
        this.f5168a = bArr == null ? new byte[131072] : bArr;
        this.f5165a = progressListener;
        this.f5166a = cacheDataSource.h().b(dataSpec);
        this.f5161a = dataSpec.f5032c;
    }

    @WorkerThread
    public void a() throws IOException {
        g();
        Cache cache = this.f5163a;
        String str = this.f5166a;
        DataSpec dataSpec = this.f5162a;
        this.c = cache.getCachedBytes(str, dataSpec.f5032c, dataSpec.f5033d);
        DataSpec dataSpec2 = this.f5162a;
        long j = dataSpec2.f5033d;
        if (j != -1) {
            this.b = dataSpec2.f5032c + j;
        } else {
            long jA = ContentMetadata.a(this.f5163a.c(this.f5166a));
            if (jA == -1) {
                jA = -1;
            }
            this.b = jA;
        }
        ProgressListener progressListener = this.f5165a;
        if (progressListener != null) {
            progressListener.onProgress(c(), this.c, 0L);
        }
        while (true) {
            long j2 = this.b;
            if (j2 != -1 && this.f5161a >= j2) {
                return;
            }
            g();
            long j3 = this.b;
            long cachedLength = this.f5163a.getCachedLength(this.f5166a, this.f5161a, j3 == -1 ? Long.MAX_VALUE : j3 - this.f5161a);
            if (cachedLength > 0) {
                this.f5161a += cachedLength;
            } else {
                long j4 = -cachedLength;
                if (j4 == Long.MAX_VALUE) {
                    j4 = -1;
                }
                long j5 = this.f5161a;
                this.f5161a = j5 + f(j5, j4);
            }
        }
    }

    public void b() {
        this.f5167a = true;
    }

    public final long c() {
        long j = this.b;
        if (j == -1) {
            return -1L;
        }
        return j - this.f5162a.f5032c;
    }

    public final void d(long j) {
        this.c += j;
        ProgressListener progressListener = this.f5165a;
        if (progressListener != null) {
            progressListener.onProgress(c(), this.c, j);
        }
    }

    public final void e(long j) {
        if (this.b == j) {
            return;
        }
        this.b = j;
        ProgressListener progressListener = this.f5165a;
        if (progressListener != null) {
            progressListener.onProgress(c(), this.c, 0L);
        }
    }

    public final long f(long j, long j2) throws IOException {
        long jA;
        boolean z = true;
        boolean z2 = j + j2 == this.b || j2 == -1;
        if (j2 != -1) {
            try {
                jA = this.f5164a.a(this.f5162a.a().i(j).h(j2).a());
            } catch (IOException unused) {
                d72.a(this.f5164a);
                z = false;
                jA = -1;
            }
        } else {
            z = false;
            jA = -1;
        }
        if (!z) {
            g();
            try {
                jA = this.f5164a.a(this.f5162a.a().i(j).h(-1L).a());
            } catch (IOException e) {
                d72.a(this.f5164a);
                throw e;
            }
        }
        if (z2 && jA != -1) {
            try {
                e(jA + j);
            } catch (IOException e2) {
                d72.a(this.f5164a);
                throw e2;
            }
        }
        int i = 0;
        int i2 = 0;
        while (i != -1) {
            g();
            CacheDataSource cacheDataSource = this.f5164a;
            byte[] bArr = this.f5168a;
            i = cacheDataSource.read(bArr, 0, bArr.length);
            if (i != -1) {
                d(i);
                i2 += i;
            }
        }
        if (z2) {
            e(j + ((long) i2));
        }
        this.f5164a.close();
        return i2;
    }

    public final void g() throws InterruptedIOException {
        if (this.f5167a) {
            throw new InterruptedIOException();
        }
    }
}
