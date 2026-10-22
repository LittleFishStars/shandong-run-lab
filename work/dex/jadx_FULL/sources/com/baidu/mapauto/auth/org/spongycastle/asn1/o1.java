package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class o1 extends t1 {
    public static final byte[] e = new byte[0];
    public final int c;
    public int d;

    public o1(int i, InputStream inputStream) {
        super(i, inputStream);
        if (i < 0) {
            throw new IllegalArgumentException("negative lengths not allowed");
        }
        this.c = i;
        this.d = i;
        if (i == 0) {
            b();
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.t1
    public final int a() {
        return this.d;
    }

    public final byte[] c() throws IOException {
        int i = this.d;
        if (i == 0) {
            return e;
        }
        byte[] bArr = new byte[i];
        InputStream inputStream = this.f26644a;
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, 0 + i2, i - i2);
            if (i3 < 0) {
                break;
            }
            i2 += i3;
        }
        int i4 = i - i2;
        this.d = i4;
        if (i4 == 0) {
            b();
            return bArr;
        }
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("DEF length ");
        sbA.append(this.c);
        sbA.append(" object truncated by ");
        sbA.append(this.d);
        throw new EOFException(sbA.toString());
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.d == 0) {
            return -1;
        }
        int i = this.f26644a.read();
        if (i >= 0) {
            int i2 = this.d - 1;
            this.d = i2;
            if (i2 == 0) {
                b();
            }
            return i;
        }
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("DEF length ");
        sbA.append(this.c);
        sbA.append(" object truncated by ");
        sbA.append(this.d);
        throw new EOFException(sbA.toString());
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int i4 = this.f26644a.read(bArr, i, Math.min(i2, i3));
        if (i4 >= 0) {
            int i5 = this.d - i4;
            this.d = i5;
            if (i5 == 0) {
                b();
            }
            return i4;
        }
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("DEF length ");
        sbA.append(this.c);
        sbA.append(" object truncated by ");
        sbA.append(this.d);
        throw new EOFException(sbA.toString());
    }
}
