package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class q implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f29883a = new l();
    public final v b;
    boolean c;

    public q(v vVar) {
        if (vVar == null) {
            throw new NullPointerException("source == null");
        }
        this.b = vVar;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public String a(long j) throws IOException {
        d(j);
        return this.f29883a.a(j);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.v
    public long b(l lVar, long j) throws IOException {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        l lVar2 = this.f29883a;
        if (lVar2.b == 0 && this.b.b(lVar2, 8192L) == -1) {
            return -1L;
        }
        return this.f29883a.b(lVar, Math.min(j, this.f29883a.b));
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public byte c() throws IOException {
        d(1L);
        return this.f29883a.c();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.v, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.f29883a.g();
    }

    public void d(long j) throws IOException {
        if (!e(j)) {
            throw new EOFException();
        }
    }

    public boolean e(long j) throws IOException {
        l lVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            lVar = this.f29883a;
            if (lVar.b >= j) {
                return true;
            }
        } while (this.b.b(lVar, 8192L) != -1);
        return false;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public long f() throws IOException {
        d(8L);
        return this.f29883a.f();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        l lVar = this.f29883a;
        if (lVar.b == 0 && this.b.b(lVar, 8192L) == -1) {
            return -1;
        }
        return this.f29883a.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public short d() throws IOException {
        d(2L);
        return this.f29883a.d();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public String a(long j, Charset charset) throws IOException {
        d(j);
        if (charset != null) {
            return this.f29883a.a(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public void c(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            l lVar = this.f29883a;
            if (lVar.b == 0 && this.b.b(lVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f29883a.a());
            this.f29883a.c(jMin);
            j -= jMin;
        }
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public long a(byte b) throws IOException {
        return a(b, 0L, Long.MAX_VALUE);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public int e() throws IOException {
        d(4L);
        return this.f29883a.e();
    }

    public long a(byte b, long j, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jA = this.f29883a.a(b, j, j2);
            if (jA != -1) {
                return jA;
            }
            l lVar = this.f29883a;
            long j3 = lVar.b;
            if (j3 >= j2 || this.b.b(lVar, 8192L) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public boolean b() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.f29883a.b() && this.b.b(this.f29883a, 8192L) == -1;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public byte[] b(long j) throws IOException {
        d(j);
        return this.f29883a.b(j);
    }
}
