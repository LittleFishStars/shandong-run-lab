package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f42544a;
    public final Object b;
    public final Object c;

    public jac(Object obj, Object obj2, Object obj3) {
        this.f42544a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final IllegalArgumentException a() {
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(this.f42544a) + "=" + String.valueOf(this.b) + " and " + String.valueOf(this.f42544a) + "=" + String.valueOf(this.c));
    }
}
