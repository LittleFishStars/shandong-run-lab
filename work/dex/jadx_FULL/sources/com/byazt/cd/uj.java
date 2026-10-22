package com.byazt.cd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 43, 15})
public final class uj {
    public static String c;
    public static Resources tt;

    @SuppressLint({"StaticFieldLeak"})
    public static Context ve;

    private static String c(Context context) {
        if (c == null) {
            c = context.getPackageName();
        }
        return c;
    }

    public static int tt(Context context, String str) {
        return c(context, str, "drawable");
    }

    private static int c(Context context, String str, String str2) {
        if (tt == null) {
            tt = context.getResources();
        }
        return tt.getIdentifier(str, str2, c(context));
    }

    public static int c(Context context, String str) {
        return c(context, str, "raw");
    }
}
