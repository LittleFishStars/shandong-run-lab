package com.byazt.yy;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 122, 54})
public class ve {
    public static volatile Context c;

    public static void c(Context context) {
        if (c == null && context != null) {
            c = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        return c;
    }
}
