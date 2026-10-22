package com.zj.adlib;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b72 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f40690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f15455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f15456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15457a = false;
    public boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f15458a = new byte[1];

    public b72(DataSource dataSource, DataSpec dataSpec) {
        this.f15455a = dataSource;
        this.f15456a = dataSpec;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.b) {
            return;
        }
        this.f15455a.close();
        this.b = true;
    }

    public long g() {
        return this.f40690a;
    }

    public final void h() throws IOException {
        if (this.f15457a) {
            return;
        }
        this.f15455a.a(this.f15456a);
        this.f15457a = true;
    }

    public void j() throws IOException {
        h();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f15458a) == -1) {
            return -1;
        }
        return this.f15458a[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        sb0.i(!this.b);
        h();
        int i3 = this.f15455a.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.f40690a += (long) i3;
        return i3;
    }
}
