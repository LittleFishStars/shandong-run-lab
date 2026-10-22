package com.byazt.vm;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 115})
public final class rh {
    public static nu c(Context context) {
        if (com.byazt.he.c.rh()) {
            return new qy(new yv());
        }
        if (com.byazt.he.c.my() && yv.c()) {
            return new yv();
        }
        if (rl.c()) {
            return new rl(context);
        }
        if (com.byazt.he.c.t() && com.byazt.he.c.u()) {
            return new i();
        }
        if (com.byazt.he.c.t() && !com.byazt.he.c.u()) {
            return new t();
        }
        if (com.byazt.he.c.c(context) || com.byazt.he.c.t()) {
            return new i();
        }
        if (com.byazt.he.c.qy()) {
            return new qy();
        }
        if (com.byazt.he.c.rl()) {
            return new yp();
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (com.byazt.he.c.yp() || !i.c(context)) {
                return null;
            }
            return new i();
        }
        if (com.byazt.he.c.gu()) {
            return new gr();
        }
        if (com.byazt.he.c.zm()) {
            return new z();
        }
        if (com.byazt.he.c.gr()) {
            return new u();
        }
        if (com.byazt.he.c.yv()) {
            return new c();
        }
        a aVar = new a(context);
        return aVar.tt(context) ? aVar : new n();
    }
}
