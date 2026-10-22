package com.igexin.base.api;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class GTBase {
    public static Context context;

    public static boolean init(Context context2) {
        if (context2 == null) {
            return false;
        }
        context = context2;
        SharedPreferencesManager.init(context2);
        return true;
    }
}
