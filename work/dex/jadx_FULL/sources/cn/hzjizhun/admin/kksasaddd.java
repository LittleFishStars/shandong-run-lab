package cn.hzjizhun.admin;

import android.app.Application;
import android.content.Context;
import com.zj.adlib.cia;
import com.zj.adlib.dja;
import com.zj.adlib.jja;
import com.zj.adlib.mqb;
import com.zj.adlib.oja;
import com.zj.adlib.uqb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class kksasaddd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static sdkdda f22748a;

    public static sdkdda a(Context context) {
        if (dkdkadssa.l() || dkdkadssa.e()) {
            return new i(context);
        }
        if (dkdkadssa.k()) {
            return new uqb(context);
        }
        if (dkdkadssa.g()) {
            return new oja(context);
        }
        if (dkdkadssa.p() || dkdkadssa.i() || dkdkadssa.h()) {
            return new jja(context);
        }
        if (dkdkadssa.a()) {
            return new b(context);
        }
        if (dkdkadssa.r()) {
            return new cia(context);
        }
        if (dkdkadssa.n()) {
            return new h(context);
        }
        if (dkdkadssa.d() || dkdkadssa.c()) {
            return new c(context);
        }
        if (dkdkadssa.f() || dkdkadssa.b()) {
            return new g(context);
        }
        if (dkdkadssa.o(context)) {
            return new e(context);
        }
        if (dkdkadssa.j()) {
            return new dja(context);
        }
        if (dkdkadssa.q()) {
            return new d(context);
        }
        return null;
    }

    public static sdkdda b(Context context) {
        j jVar = new j(context);
        if (jVar.a()) {
            dddssad.a("Mobile Security Alliance has been found: " + j.class.getName());
            return jVar;
        }
        a aVar = new a(context);
        if (aVar.a()) {
            dddssad.a("Google Play Service has been found: " + a.class.getName());
            return aVar;
        }
        mqb mqbVar = new mqb();
        dddssad.a("OAID/AAID was not supported: " + mqb.class.getName());
        return mqbVar;
    }

    public static sdkdda c(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        sdkdda sdkddaVar = f22748a;
        if (sdkddaVar != null) {
            return sdkddaVar;
        }
        sdkdda sdkddaVarA = a(context);
        f22748a = sdkddaVarA;
        if (sdkddaVarA == null || !sdkddaVarA.a()) {
            sdkdda sdkddaVarB = b(context);
            f22748a = sdkddaVarB;
            return sdkddaVarB;
        }
        dddssad.a("Manufacturer interface has been found: " + f22748a.getClass().getName());
        return f22748a;
    }
}
