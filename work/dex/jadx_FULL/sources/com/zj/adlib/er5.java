package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class er5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final er5 f41508a = new er5(929, 3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f16392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fr5 f16393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f16394a;
    public final fr5 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f16395b;

    public er5(int i, int i2) {
        this.f16392a = i;
        this.f16394a = new int[i];
        this.f16395b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f16394a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f16395b[this.f16394a[i5]] = i5;
        }
        this.f16393a = new fr5(this, new int[]{0});
        this.b = new fr5(this, new int[]{1});
    }

    public int a(int i, int i2) {
        return (i + i2) % this.f16392a;
    }

    public fr5 b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f16393a;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new fr5(this, iArr);
    }

    public int c(int i) {
        return this.f16394a[i];
    }

    public fr5 d() {
        return this.b;
    }

    public int e() {
        return this.f16392a;
    }

    public fr5 f() {
        return this.f16393a;
    }

    public int g(int i) {
        if (i != 0) {
            return this.f16394a[(this.f16392a - this.f16395b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i) {
        if (i != 0) {
            return this.f16395b[i];
        }
        throw new IllegalArgumentException();
    }

    public int i(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f16394a;
        int[] iArr2 = this.f16395b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f16392a - 1)];
    }

    public int j(int i, int i2) {
        int i3 = this.f16392a;
        return ((i + i3) - i2) % i3;
    }
}
