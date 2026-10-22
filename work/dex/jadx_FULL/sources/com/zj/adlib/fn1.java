package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class fn1 {
    public static final int f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41711a;
    public final int b;
    public final int c;
    public final int d;
    public int e = -1;

    public fn1(int i, int i2, int i3, int i4) {
        this.f41711a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f41711a;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.b - this.f41711a;
    }

    public boolean g() {
        return h(this.e);
    }

    public boolean h(int i) {
        return i != -1 && this.c == (i % 3) * 3;
    }

    public void i(int i) {
        this.e = i;
    }

    public void j() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    public String toString() {
        return this.e + "|" + this.d;
    }
}
