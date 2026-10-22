package com.byazt.aas;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 133})
public class z {
    public static volatile String c;
    public static String tt;

    public static void c(String str) {
        if (com.byazt.lkt.c.c() != null) {
            com.byazt.lkt.c.c().c(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(c)) {
            return;
        }
        com.byazt.omf.tt.c().put("did", str);
        c = str;
    }

    public static String c() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String str = com.byazt.omf.tt.c().get("did", tt);
        c = str;
        return str;
    }
}
