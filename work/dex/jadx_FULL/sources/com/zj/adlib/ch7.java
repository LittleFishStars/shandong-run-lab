package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ch7 {
    public static final int c = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15814a;
    public int b;

    public ch7() {
        a();
    }

    public static ch7 c() {
        return new ch7();
    }

    public void a() {
        this.f15814a = false;
        this.f40969a = 4;
        e();
    }

    public boolean b() {
        return this.f15814a;
    }

    public void d() {
        this.b++;
    }

    public void e() {
        this.b = 0;
    }

    public void f(boolean z) {
        this.f15814a = z;
    }

    public boolean g() {
        return this.f15814a && this.b < this.f40969a;
    }
}
