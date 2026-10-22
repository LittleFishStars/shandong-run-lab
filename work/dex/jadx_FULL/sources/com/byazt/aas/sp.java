package com.byazt.aas;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 91})
public class sp {
    public static boolean c() {
        try {
            if (com.byazt.omf.x.m().bm()) {
                return true;
            }
            Context context = com.byazt.omf.gt.getContext();
            if (context.getApplicationInfo() != null && (context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void c(com.byazt.dj.c cVar) {
        try {
            if (!cVar.x() || com.byazt.nr.m.c()) {
                return;
            }
            System.currentTimeMillis();
            if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                com.byazt.nr.m.tt();
                com.byazt.lt.tt.c();
                com.byazt.hm.c.c();
                com.byazt.zlb.ve.tt();
                com.byazt.btt.tt.c().openDebugLog(true);
            }
        } catch (Exception unused) {
        }
    }
}
