package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class cv7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f41048a;
    public float b;

    public cv7(float f, float f2) {
        this.f41048a = f;
        this.b = f2;
    }

    public boolean a(float f, float f2) {
        return this.f41048a == f && this.b == f2;
    }

    public float b() {
        return this.f41048a;
    }

    public float c() {
        return this.b;
    }

    public void d(float f, float f2) {
        this.f41048a = f;
        this.b = f2;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public cv7() {
        this(1.0f, 1.0f);
    }
}
