package com.byazt.dz;

import android.content.Context;
import com.byazt.omf.eo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 106, 54})
public class ve {
    public static com.byazt.jg.c c;

    public static void c(tt ttVar) {
        if (uj() == null) {
            return;
        }
        c.c(ttVar);
    }

    public static void tt(String str, String str2) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.i(str, str2);
    }

    private static com.byazt.jg.c uj() {
        if (c == null) {
            c = eo.c().n();
        }
        return c;
    }

    public static void ve(String str, String str2) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.w(str, str2);
    }

    public static void c() {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.destroy();
    }

    public static void tt(String str, String str2, Throwable th) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.e(str, str2, th);
    }

    public static void ve() {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.execCloudManagerSafely();
    }

    public static void uj(String str, String str2) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.e(str, str2);
    }

    public static void c(int i) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.changeLogLevel(i);
    }

    public static void tt() {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.fetchCommand();
    }

    public static void c(String str, String str2) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.d(str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.w(str, str2, th);
    }

    public static void c(String str, Throwable th) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.e(str, th);
    }

    public static boolean c(Context context, JSONObject jSONObject) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return false;
        }
        cVarUj.initCLog(context, jSONObject);
        return true;
    }

    public static void c(Context context, String str, String str2) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.initCloudMessageManager(context, str, str2);
    }

    public static void c(String str) {
        com.byazt.jg.c cVarUj = uj();
        if (cVarUj == null) {
            return;
        }
        cVarUj.setUploadHost(str);
    }
}
