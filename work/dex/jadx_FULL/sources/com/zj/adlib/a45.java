package com.zj.adlib;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a45<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f40450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public T f15153a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public T f15154b;
    public float c;
    public float d;
    public float e;

    public float a() {
        return this.b;
    }

    public T b() {
        return this.f15154b;
    }

    public float c() {
        return this.d;
    }

    public float d() {
        return this.c;
    }

    public float e() {
        return this.e;
    }

    public float f() {
        return this.f40450a;
    }

    public T g() {
        return this.f15153a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public a45<T> h(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        this.f40450a = f;
        this.b = f2;
        this.f15153a = t;
        this.f15154b = t2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        return this;
    }
}
