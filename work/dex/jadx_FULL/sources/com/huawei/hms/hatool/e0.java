package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class e0 {
    private i a(int i) {
        String strF;
        if (i != 0) {
            strF = f();
            if (!TextUtils.isEmpty(strF)) {
                return new i(d0.UDID, strF);
            }
        } else {
            strF = "";
        }
        return new i(d0.EMPTY, strF);
    }

    private i b(int i) {
        String strF;
        if ((i & 4) != 0) {
            strF = f();
            if (!TextUtils.isEmpty(strF)) {
                return new i(d0.UDID, strF);
            }
        } else {
            strF = "";
        }
        return new i(d0.EMPTY, strF);
    }

    private boolean e() {
        g1 g1VarB = s.c().b();
        if (TextUtils.isEmpty(g1VarB.l())) {
            g1VarB.h(o.a());
        }
        return !TextUtils.isEmpty(g1VarB.l());
    }

    private String f() {
        g1 g1VarB = s.c().b();
        if (TextUtils.isEmpty(g1VarB.i())) {
            g1VarB.e(x0.c());
        }
        return g1VarB.i();
    }

    public i a(Context context) {
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            return new i(d0.UDID, strC);
        }
        String strA = a();
        if (!TextUtils.isEmpty(strA)) {
            return new i(d0.IMEI, strA);
        }
        boolean zE = e();
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return zE ? a(d()) : b(d());
        }
        return zE ? new i(d0.SN, strB) : new i(d0.UDID, a(strB));
    }

    public abstract String a();

    public abstract String a(String str);

    public abstract String b();

    public abstract String c();

    public abstract int d();
}
