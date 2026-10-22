package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.gtd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzuu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzuu f31370a = m().l();
    public static final zzuu b;

    static {
        zzut zzutVarM = m();
        zzutVarM.h(false);
        b = zzutVarM.l();
    }

    public static zzut m() {
        gtd gtdVar = new gtd();
        gtdVar.m(10);
        gtdVar.e(5);
        gtdVar.f(0.25f);
        gtdVar.d(0.8f);
        gtdVar.h(true);
        gtdVar.c(0.5f);
        gtdVar.b(0.8f);
        gtdVar.j(com.igexin.push.config.c.j);
        gtdVar.g(3000L);
        gtdVar.a(true);
        gtdVar.i(0.1f);
        gtdVar.k(0.05f);
        return gtdVar;
    }

    public abstract float a();

    public abstract float b();

    public abstract float c();

    public abstract float d();

    public abstract float e();

    public abstract float f();

    public abstract int g();

    public abstract int h();

    public abstract long i();

    public abstract long j();

    public abstract boolean k();

    public abstract boolean l();
}
