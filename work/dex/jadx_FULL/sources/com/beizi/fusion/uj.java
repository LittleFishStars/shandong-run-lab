package com.beizi.fusion;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static xd f27836a;

    public static xd a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        xd xdVar = f27836a;
        if (xdVar != null) {
            return xdVar;
        }
        xd xdVarB = b(context);
        f27836a = xdVarB;
        if (xdVarB == null || !xdVarB.a()) {
            xd xdVarC = c(context);
            f27836a = xdVarC;
            return xdVarC;
        }
        xj.a("Manufacturer interface has been found: " + f27836a.getClass().getName());
        return f27836a;
    }

    private static xd b(Context context) {
        if (zj.g() || zj.j()) {
            return new ah(context);
        }
        if (zj.h()) {
            return new wh(context);
        }
        if (zj.k()) {
            return new oj(context);
        }
        if (zj.p() || zj.i() || zj.b()) {
            return new nq(context);
        }
        if (zj.n()) {
            return new um(context);
        }
        if (zj.o()) {
            return new eq(context);
        }
        if (zj.a()) {
            return new z2(context);
        }
        if (zj.f() || zj.d()) {
            return new n9(context);
        }
        if (zj.m() || zj.l()) {
            return new sk(context);
        }
        if (zj.a(context)) {
            return new c6(context);
        }
        if (zj.c()) {
            return new e6(context);
        }
        if (zj.e()) {
            return new h8(context);
        }
        return null;
    }

    private static xd c(Context context) {
        di diVar = new di(context);
        if (diVar.a()) {
            xj.a("Mobile Security Alliance has been found: " + di.class.getName());
            return diVar;
        }
        o8 o8Var = new o8(context);
        if (o8Var.a()) {
            xj.a("Google Play Service has been found: " + o8.class.getName());
            return o8Var;
        }
        m6 m6Var = new m6();
        xj.a("OAID was not supported: " + m6.class.getName());
        return m6Var;
    }
}
