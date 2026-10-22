package com.byazt.ti;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2161, 46})
public class n {
    public static String c = "com.bytedance.openadsdk";
    public static String tt = "content://" + c + ".TTMultiProvider";

    static {
        c();
    }

    public static void c() {
        Context context = tt.getContext();
        if (context != null) {
            c = context.getPackageName();
            tt = "content://" + c + ".TTMultiProvider";
        }
    }
}
