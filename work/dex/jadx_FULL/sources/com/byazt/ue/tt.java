package com.byazt.ue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1265, 13})
public class tt {
    public static boolean c;
    public static boolean tt;

    public static void c(String str) {
        if (!tt) {
            com.byazt.vif.uj.c(str, "sp_multi_info").put("is_support_multi_process", true);
        }
        c = true;
        tt = true;
    }

    public static void tt(String str) {
        if (tt) {
            com.byazt.vif.uj.c(str, "sp_multi_info").put("is_support_multi_process", false);
        }
        c = false;
    }

    public static boolean c() {
        if (!tt) {
            c = com.byazt.vif.uj.c(com.byazt.vxy.c.uj(), "sp_multi_info").get("is_support_multi_process", false);
            tt = true;
        }
        return c;
    }
}
