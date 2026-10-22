package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class q1 extends t1 {
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public q1(int i, InputStream inputStream) throws IOException {
        super(i, inputStream);
        this.e = false;
        this.f = true;
        this.c = inputStream.read();
        int i2 = inputStream.read();
        this.d = i2;
        if (i2 < 0) {
            throw new EOFException();
        }
        c();
    }

    public final boolean c() {
        if (!this.e && this.f && this.c == 0 && this.d == 0) {
            this.e = true;
            b();
        }
        return this.e;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (c()) {
            return -1;
        }
        int i = this.f26644a.read();
        if (i < 0) {
            throw new EOFException();
        }
        int i2 = this.c;
        this.c = this.d;
        this.d = i;
        return i2;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f || i2 < 3) {
            return super.read(bArr, i, i2);
        }
        if (this.e) {
            return -1;
        }
        int i3 = this.f26644a.read(bArr, i + 2, i2 - 2);
        if (i3 < 0) {
            throw new EOFException();
        }
        bArr[i] = (byte) this.c;
        bArr[i + 1] = (byte) this.d;
        this.c = this.f26644a.read();
        int i4 = this.f26644a.read();
        this.d = i4;
        if (i4 >= 0) {
            return i3 + 2;
        }
        throw new EOFException();
    }
}
