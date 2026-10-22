package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.dh7;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class CacheDataSink implements DataSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31131a = "CacheDataSink";
    public static final int b = 20480;
    public static final long e = 5242880;
    public static final long f = 2097152;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f5121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f5122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DataSpec f5123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Cache f5124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dh7 f5125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public File f5126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public OutputStream f5127a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5128b;
    public long c;
    public long d;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public static final class a implements DataSink.Factory {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Cache f5130a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f5129a = 5242880;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31132a = 20480;

        @Override // com.google.android.exoplayer2.upstream.DataSink.Factory
        public DataSink a() {
            return new CacheDataSink((Cache) sb0.g(this.f5130a), this.f5129a, this.f31132a);
        }

        public a b(int i) {
            this.f31132a = i;
            return this;
        }

        public a c(Cache cache) {
            this.f5130a = cache;
            return this;
        }

        public a d(long j) {
            this.f5129a = j;
            return this;
        }
    }

    public CacheDataSink(Cache cache, long j) {
        this(cache, j, 20480);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void a(DataSpec dataSpec) throws CacheDataSinkException {
        sb0.g(dataSpec.f5028a);
        if (dataSpec.f5033d == -1 && dataSpec.d(2)) {
            this.f5123a = null;
            return;
        }
        this.f5123a = dataSpec;
        this.f5128b = dataSpec.d(4) ? this.f5122a : Long.MAX_VALUE;
        this.d = 0L;
        try {
            c(dataSpec);
        } catch (IOException e2) {
            throw new CacheDataSinkException(e2);
        }
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.f5127a;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            gj9.p(this.f5127a);
            this.f5127a = null;
            File file = (File) gj9.k(this.f5126a);
            this.f5126a = null;
            this.f5124a.commitFile(file, this.c);
        } catch (Throwable th) {
            gj9.p(this.f5127a);
            this.f5127a = null;
            File file2 = (File) gj9.k(this.f5126a);
            this.f5126a = null;
            file2.delete();
            throw th;
        }
    }

    public final void c(DataSpec dataSpec) throws IOException {
        long j = dataSpec.f5033d;
        this.f5126a = this.f5124a.startFile((String) gj9.k(dataSpec.f5028a), dataSpec.f5032c + this.d, j != -1 ? Math.min(j - this.d, this.f5128b) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f5126a);
        if (this.f5121a > 0) {
            dh7 dh7Var = this.f5125a;
            if (dh7Var == null) {
                this.f5125a = new dh7(fileOutputStream, this.f5121a);
            } else {
                dh7Var.a(fileOutputStream);
            }
            this.f5127a = this.f5125a;
        } else {
            this.f5127a = fileOutputStream;
        }
        this.c = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws CacheDataSinkException {
        if (this.f5123a == null) {
            return;
        }
        try {
            b();
        } catch (IOException e2) {
            throw new CacheDataSinkException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) throws CacheDataSinkException {
        DataSpec dataSpec = this.f5123a;
        if (dataSpec == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.c == this.f5128b) {
                    b();
                    c(dataSpec);
                }
                int iMin = (int) Math.min(i2 - i3, this.f5128b - this.c);
                ((OutputStream) gj9.k(this.f5127a)).write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.c += j;
                this.d += j;
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        }
    }

    public CacheDataSink(Cache cache, long j, int i) {
        sb0.j(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < 2097152) {
            Log.n(f31131a, "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f5124a = (Cache) sb0.g(cache);
        this.f5122a = j == -1 ? Long.MAX_VALUE : j;
        this.f5121a = i;
    }
}
