package com.czhj.devicehelper.cnoaid;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29330a = "OAID";
    private static boolean b = false;

    private g() {
    }

    public static void a() {
        b = true;
    }

    public static void a(Object obj) {
        if (b) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.i("OAID", obj.toString());
        }
    }
}
