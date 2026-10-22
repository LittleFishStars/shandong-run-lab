package com.byazt.lf;

import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 526, 46})
public class n {
    public static boolean c = false;
    public static int tt = 4;

    public static boolean c() {
        return c;
    }

    public static void c(String str, String str2) {
        if (c && str2 != null && tt <= 4) {
            m.c(m.uj(str), str2);
        }
    }
}
