package com.kc.cw.ad.d.a;

import android.util.Log;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f38806a = false;

    public static void a(Object obj) {
        if (f38806a) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }

    public static void b(Object obj) {
        if (obj == null) {
            obj = "<null>";
        }
        Log.d("OAID", obj.toString());
    }
}
