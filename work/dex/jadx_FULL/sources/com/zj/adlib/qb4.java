package com.zj.adlib;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qb4 {
    public static final int e = 16;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f19052a;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44169a = 0;
    public int b = -1;
    public int c = 0;

    public qb4() {
        int[] iArr = new int[16];
        this.f19052a = iArr;
        this.d = iArr.length - 1;
    }

    public void a(int i) {
        if (this.c == this.f19052a.length) {
            d();
        }
        int i2 = (this.b + 1) & this.d;
        this.b = i2;
        this.f19052a[i2] = i;
        this.c++;
    }

    public int b() {
        return this.f19052a.length;
    }

    public void c() {
        this.f44169a = 0;
        this.b = -1;
        this.c = 0;
    }

    public final void d() {
        int[] iArr = this.f19052a;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i = this.f44169a;
        int i2 = length2 - i;
        System.arraycopy(iArr, i, iArr2, 0, i2);
        System.arraycopy(this.f19052a, 0, iArr2, i2, i);
        this.f44169a = 0;
        this.b = this.c - 1;
        this.f19052a = iArr2;
        this.d = iArr2.length - 1;
    }

    public boolean e() {
        return this.c == 0;
    }

    public int f() {
        int i = this.c;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f19052a;
        int i2 = this.f44169a;
        int i3 = iArr[i2];
        this.f44169a = (i2 + 1) & this.d;
        this.c = i - 1;
        return i3;
    }

    public int g() {
        return this.c;
    }
}
