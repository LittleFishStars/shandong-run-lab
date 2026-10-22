package com.zj.adlib;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class xl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zl0[] f20677a;
    public final int b;
    public final int c;

    public xl0(int i, int i2) {
        zl0[] zl0VarArr = new zl0[i];
        this.f20677a = zl0VarArr;
        int length = zl0VarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f20677a[i3] = new zl0(((i2 + 4) * 17) + 1);
        }
        this.c = i2 * 17;
        this.b = i;
        this.f45843a = -1;
    }

    public zl0 a() {
        return this.f20677a[this.f45843a];
    }

    public byte[][] b() {
        return c(1, 1);
    }

    public byte[][] c(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.b * i2, this.c * i);
        int i3 = this.b * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f20677a[i4 / i2].b(i);
        }
        return bArr;
    }

    public void d(int i, int i2, byte b) {
        this.f20677a[i2].c(i, b);
    }

    public void e() {
        this.f45843a++;
    }
}
