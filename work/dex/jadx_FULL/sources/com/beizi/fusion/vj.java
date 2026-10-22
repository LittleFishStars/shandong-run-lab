package com.beizi.fusion;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class vj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static yd f27870a;

    public static yd a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        yd ydVar = f27870a;
        if (ydVar != null) {
            return ydVar;
        }
        yd ydVarB = b(context);
        f27870a = ydVarB;
        if (ydVarB == null || !ydVarB.a()) {
            yd ydVarC = c(context);
            f27870a = ydVarC;
            return ydVarC;
        }
        yj.a("Manufacturer interface has been found: " + f27870a.getClass().getName());
        return f27870a;
    }

    private static yd b(Context context) {
        if (ak.g() || ak.j()) {
            return new bh(context);
        }
        if (ak.h()) {
            return new xh(context);
        }
        if (ak.k()) {
            return new pj(context);
        }
        if (ak.p() || ak.i() || ak.b()) {
            return new oq(context);
        }
        if (ak.n()) {
            return new vm(context);
        }
        if (ak.o()) {
            return new fq(context);
        }
        if (ak.a()) {
            return new a3(context);
        }
        if (ak.f() || ak.d()) {
            return new o9(context);
        }
        if (ak.m() || ak.l()) {
            return new tk(context);
        }
        if (ak.a(context)) {
            return new d6(context);
        }
        if (ak.c()) {
            return new f6(context);
        }
        if (ak.e()) {
            return new i8(context);
        }
        return null;
    }

    private static yd c(Context context) {
        ei eiVar = new ei(context);
        if (eiVar.a()) {
            yj.a("Mobile Security Alliance has been found: " + ei.class.getName());
            return eiVar;
        }
        n6 n6Var = new n6();
        yj.a("OAID was not supported: " + n6.class.getName());
        return n6Var;
    }
}
