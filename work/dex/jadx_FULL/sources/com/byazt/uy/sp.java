package com.byazt.uy;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1180, 91})
public final class sp {
    public static boolean c = false;
    public static boolean tt = false;
    public static boolean uj = false;
    public static boolean ve = false;

    public static synchronized void c(@NonNull Context context, @NonNull n nVar, boolean z, boolean z2) {
        c(context, nVar, z, false, z2);
    }

    public static synchronized void c(@NonNull Context context, @NonNull n nVar, boolean z, boolean z2, boolean z3) {
        c(context, nVar, z, z, z2, z3);
    }

    public static synchronized void c(@NonNull final Context context, @NonNull n nVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        if (c) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context must be not null.");
        }
        if (nVar != null) {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            if (com.byazt.mg.c.ve(context)) {
                return;
            }
            x.c(context, nVar);
            com.byazt.ia.n.c(context);
            if (z || z2) {
                com.byazt.yg.c cVarC = com.byazt.yg.c.c();
                if (z) {
                    cVarC.c(new com.byazt.yg.ve(context));
                }
                tt = true;
            }
            uj = z3;
            c = true;
            ve = z4;
            com.byazt.rx.sp.tt().post(new Runnable() { // from class: com.byazt.uy.sp.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.kr.c.c().c(context);
                    com.byazt.jz.uj.c(context);
                    if (z4) {
                        com.byazt.kg.a.c(context).c();
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("params must be not null.");
    }

    @Deprecated
    public static void c(String str) {
        if (x.n().c()) {
            com.byazt.yg.c.c(str);
        }
    }

    public static void c(a aVar) {
        x.tt().c(aVar);
    }

    public static void c(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        x.tt().c(map);
    }

    public static void c(final com.byazt.ba.tt ttVar) {
        com.byazt.rx.sp.tt().post(new Runnable() { // from class: com.byazt.uy.sp.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ba.c.c(ttVar);
            }
        });
    }

    public static void c() {
        com.byazt.yg.c.tt();
    }
}
