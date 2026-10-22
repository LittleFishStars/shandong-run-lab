package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ah3 extends xg7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40532a;
    public final float c;

    public ah3(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    public boolean f(float f, float f2, float f3) {
        if (Math.abs(f2 - d()) > f || Math.abs(f3 - c()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.c);
        return fAbs <= 1.0f || fAbs <= this.c;
    }

    public ah3 g(float f, float f2, float f3) {
        int i = this.f40532a;
        int i2 = i + 1;
        float fC = (i * c()) + f2;
        float f4 = i2;
        return new ah3(fC / f4, ((this.f40532a * d()) + f) / f4, ((this.f40532a * this.c) + f3) / f4, i2);
    }

    public int h() {
        return this.f40532a;
    }

    public float i() {
        return this.c;
    }

    public ah3(float f, float f2, float f3, int i) {
        super(f, f2);
        this.c = f3;
        this.f40532a = i;
    }
}
