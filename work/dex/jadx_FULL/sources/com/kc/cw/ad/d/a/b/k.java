package com.kc.cw.ad.d.a.b;

import android.app.Application;
import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.kc.cw.ad.d.a.d f38798a;

    public static com.kc.cw.ad.d.a.d a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.kc.cw.ad.d.a.d dVar = f38798a;
        if (dVar != null) {
            return dVar;
        }
        com.kc.cw.ad.d.a.d dVarB = b(context);
        f38798a = dVarB;
        if (dVarB == null || !dVarB.a()) {
            com.kc.cw.ad.d.a.d dVarC = c(context);
            f38798a = dVarC;
            return dVarC;
        }
        com.kc.cw.ad.d.a.f.a("Manufacturer interface has been found: " + f38798a.getClass().getName());
        return f38798a;
    }

    private static com.kc.cw.ad.d.a.d b(Context context) {
        if (com.kc.cw.ad.d.a.g.k() || com.kc.cw.ad.d.a.g.n()) {
            return new g(context);
        }
        if (com.kc.cw.ad.d.a.g.j()) {
            return new h(context);
        }
        if (com.kc.cw.ad.d.a.g.l()) {
            return new j(context);
        }
        if (com.kc.cw.ad.d.a.g.e() || com.kc.cw.ad.d.a.g.f() || com.kc.cw.ad.d.a.g.g()) {
            return new p(context);
        }
        if (com.kc.cw.ad.d.a.g.i()) {
            return new n(context);
        }
        if (com.kc.cw.ad.d.a.g.d()) {
            return new o(context);
        }
        if (com.kc.cw.ad.d.a.g.m()) {
            return new a(context);
        }
        if (com.kc.cw.ad.d.a.g.a() || com.kc.cw.ad.d.a.g.b()) {
            return new f(context);
        }
        if (com.kc.cw.ad.d.a.g.c() || com.kc.cw.ad.d.a.g.h()) {
            return new m(context);
        }
        if (com.kc.cw.ad.d.a.g.a(context)) {
            return new b(context);
        }
        if (com.kc.cw.ad.d.a.g.p()) {
            return new c(context);
        }
        if (com.kc.cw.ad.d.a.g.o()) {
            return new e(context);
        }
        return null;
    }

    private static com.kc.cw.ad.d.a.d c(Context context) {
        i iVar = new i(context);
        if (iVar.a()) {
            com.kc.cw.ad.d.a.f.a("Mobile Security Alliance has been found: " + i.class.getName());
            return iVar;
        }
        d dVar = new d();
        com.kc.cw.ad.d.a.f.a("OAID/GAID was not supported: " + d.class.getName());
        return dVar;
    }
}
