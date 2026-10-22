package com.hailiang.advlib.open.oaid.hla;

import android.app.Application;
import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.hailiang.advlib.open.oaid.b f32592a;

    private e() {
    }

    public static com.hailiang.advlib.open.oaid.b a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.hailiang.advlib.open.oaid.b bVar = f32592a;
        if (bVar != null) {
            return bVar;
        }
        com.hailiang.advlib.open.oaid.b bVarB = b(context);
        f32592a = bVarB;
        if (bVarB != null && bVarB.a()) {
            return f32592a;
        }
        com.hailiang.advlib.open.oaid.b bVarC = c(context);
        f32592a = bVarC;
        return bVarC;
    }

    private static com.hailiang.advlib.open.oaid.b b(Context context) {
        if (com.hailiang.advlib.open.oaid.c.d()) {
            return new c(context);
        }
        if (com.hailiang.advlib.open.oaid.c.j() || com.hailiang.advlib.open.oaid.c.e() || com.hailiang.advlib.open.oaid.c.a()) {
            return new j(context);
        }
        if (com.hailiang.advlib.open.oaid.c.h()) {
            return new h(context);
        }
        if (com.hailiang.advlib.open.oaid.c.i()) {
            return new i(context);
        }
        if (com.hailiang.advlib.open.oaid.c.c() || com.hailiang.advlib.open.oaid.c.b()) {
            return new b(context);
        }
        if (com.hailiang.advlib.open.oaid.c.g() || com.hailiang.advlib.open.oaid.c.f()) {
            return new g(context);
        }
        return null;
    }

    private static com.hailiang.advlib.open.oaid.b c(Context context) {
        d dVar = new d(context);
        return dVar.a() ? dVar : new a();
    }
}
