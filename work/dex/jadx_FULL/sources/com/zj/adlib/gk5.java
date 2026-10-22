package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class gk5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f16804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f16805a;
    public final int b;
    public final int c;

    public gk5(Object obj) {
        this(obj, -1L);
    }

    public gk5 a(Object obj) {
        return this.f16805a.equals(obj) ? this : new gk5(obj, this.f41928a, this.b, this.f16804a, this.c);
    }

    public gk5 b(long j) {
        return this.f16804a == j ? this : new gk5(this.f16805a, this.f41928a, this.b, j, this.c);
    }

    public boolean c() {
        return this.f41928a != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gk5)) {
            return false;
        }
        gk5 gk5Var = (gk5) obj;
        return this.f16805a.equals(gk5Var.f16805a) && this.f41928a == gk5Var.f41928a && this.b == gk5Var.b && this.f16804a == gk5Var.f16804a && this.c == gk5Var.c;
    }

    public int hashCode() {
        return ((((((((527 + this.f16805a.hashCode()) * 31) + this.f41928a) * 31) + this.b) * 31) + ((int) this.f16804a)) * 31) + this.c;
    }

    public gk5(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public gk5(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }

    public gk5(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    public gk5(gk5 gk5Var) {
        this.f16805a = gk5Var.f16805a;
        this.f41928a = gk5Var.f41928a;
        this.b = gk5Var.b;
        this.f16804a = gk5Var.f16804a;
        this.c = gk5Var.c;
    }

    public gk5(Object obj, int i, int i2, long j, int i3) {
        this.f16805a = obj;
        this.f41928a = i;
        this.b = i2;
        this.f16804a = j;
        this.c = i3;
    }
}
