package com.zj.adlib;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ija {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f42371a = false;

    public static void a(Object obj) {
        if (f42371a) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }
}
