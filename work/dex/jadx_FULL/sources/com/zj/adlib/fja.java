package com.zj.adlib;

import android.app.Application;
import android.content.Context;
import com.bwt.top.cn_oaid.assa.a;
import com.bwt.top.cn_oaid.assa.b;
import com.bwt.top.cn_oaid.assa.c;
import com.bwt.top.cn_oaid.assa.d;
import com.bwt.top.cn_oaid.assa.e;
import com.bwt.top.cn_oaid.assa.f;
import com.bwt.top.cn_oaid.assa.g;
import com.bwt.top.cn_oaid.assa.h;
import com.bwt.top.cn_oaid.assa.i;
import com.bwt.top.cn_oaid.dkkd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class fja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static dkkd f41691a;

    public static dkkd a(Context context) {
        if (pqb.l() || pqb.e()) {
            return new e(context);
        }
        if (pqb.k()) {
            return new ova(context);
        }
        if (pqb.g()) {
            return new gva(context);
        }
        if (pqb.p() || pqb.i() || pqb.h()) {
            return new tgb(context);
        }
        if (pqb.a()) {
            return new i(context);
        }
        if (pqb.r()) {
            return new lqb(context);
        }
        if (pqb.n()) {
            return new g(context);
        }
        if (pqb.d() || pqb.c()) {
            return new f(context);
        }
        if (pqb.f() || pqb.b()) {
            return new a(context);
        }
        if (pqb.o(context)) {
            return new d(context);
        }
        if (pqb.j()) {
            return new hwa(context);
        }
        if (pqb.q()) {
            return new h(context);
        }
        return null;
    }

    public static dkkd b(Context context) {
        StringBuilder sb;
        Class cls;
        dkkd cVar = new c(context);
        if (cVar.a()) {
            sb = new StringBuilder();
            sb.append("Mobile Security Alliance has been found: ");
            cls = c.class;
        } else {
            cVar = new b(context);
            if (!cVar.a()) {
                gja gjaVar = new gja();
                ija.a("OAID/AAID was not supported: " + gja.class.getName());
                return gjaVar;
            }
            sb = new StringBuilder();
            sb.append("Google Play Service has been found: ");
            cls = b.class;
        }
        sb.append(cls.getName());
        ija.a(sb.toString());
        return cVar;
    }

    public static dkkd c(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        dkkd dkkdVar = f41691a;
        if (dkkdVar != null) {
            return dkkdVar;
        }
        dkkd dkkdVarA = a(context);
        f41691a = dkkdVarA;
        if (dkkdVarA == null || !dkkdVarA.a()) {
            dkkd dkkdVarB = b(context);
            f41691a = dkkdVarB;
            return dkkdVarB;
        }
        ija.a("Manufacturer interface has been found: " + f41691a.getClass().getName());
        return f41691a;
    }
}
