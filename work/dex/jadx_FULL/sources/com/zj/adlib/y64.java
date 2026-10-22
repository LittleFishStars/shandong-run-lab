package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class y64 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20802a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f20803b;
    public boolean c;
    public boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45961a = 100;
    public int b = -1;

    public x64 a() {
        return new x64(this);
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.f20803b;
    }

    public boolean e() {
        return this.f20802a;
    }

    public int f() {
        return this.f45961a;
    }

    public boolean g() {
        return this.c;
    }

    public y64 h(int i) {
        this.b = i;
        return this;
    }

    public y64 i(boolean z) {
        this.d = z;
        return this;
    }

    public y64 j(boolean z) {
        this.f20803b = z;
        return this;
    }

    public y64 k(boolean z) {
        this.f20802a = z;
        return this;
    }

    public y64 l(x64 x64Var) {
        this.b = x64Var.b;
        this.f20802a = x64Var.f20609a;
        this.f20803b = x64Var.f20610b;
        this.c = x64Var.c;
        this.d = x64Var.d;
        return this;
    }

    public y64 m(int i) {
        this.f45961a = i;
        return this;
    }

    public y64 n(boolean z) {
        this.c = z;
        return this;
    }
}
