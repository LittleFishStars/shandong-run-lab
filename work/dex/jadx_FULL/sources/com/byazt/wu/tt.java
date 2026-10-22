package com.byazt.wu;

import android.util.SparseArray;
import com.byazt.aas.eo;
import com.byazt.iy.n;
import com.byazt.nr.m;
import com.byazt.omf.x;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1128, 13})
public class tt {
    public static n c;

    public static void c(String str) {
        tt();
        try {
            n nVar = c;
            if (nVar != null) {
                c.put("live_init_".concat(String.valueOf(str)), nVar.get("live_init_".concat(String.valueOf(str)), 0) + 1);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private static void tt() {
        if (c == null) {
            c = eo.c("csj_live");
        }
    }

    public static void uj(String str) {
        c();
        tt(str);
    }

    public static boolean ve(String str) {
        tt();
        n nVar = c;
        return (nVar != null ? nVar.get("live_init_".concat(String.valueOf(str)), 0) : 0) < 5;
    }

    public static void tt(String str) {
        tt();
        try {
            n nVar = c;
            if (nVar != null) {
                nVar.put("live_init_".concat(String.valueOf(str)), 0);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void c() {
        try {
            Function<SparseArray<Object>, Object> functionA = x.m().a(4);
            if (functionA != null) {
                functionA.apply(com.byazt.yxi.uj.c().c(100).c(Void.class).c(0, "com.byted.live.lite").tt());
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
