package com.zj.adlib;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cr5 extends lq1 {
    public static final int t = 0;
    public static final int u = 46000;
    public static final int v = 46001;
    public static final int w = 46002;
    public static final int x = 46003;

    @NonNull
    public static String a(int i) {
        switch (i) {
            case u /* 46000 */:
                return "UNKNOWN_MODULE";
            case v /* 46001 */:
                return "NOT_ALLOWED_MODULE";
            case w /* 46002 */:
                return "MODULE_NOT_FOUND";
            case x /* 46003 */:
                return "INSUFFICIENT_STORAGE";
            default:
                return lq1.a(i);
        }
    }
}
