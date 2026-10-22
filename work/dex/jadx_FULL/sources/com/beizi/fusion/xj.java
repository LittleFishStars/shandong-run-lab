package com.beizi.fusion;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class xj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f28035a = false;

    public static void a(Object obj) {
        if (f28035a) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }
}
