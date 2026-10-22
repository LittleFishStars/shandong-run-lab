package com.efs.sdk.memleaksdk.monitor.shark;

import android.util.Log;
import com.efs.sdk.memleaksdk.MemLeakManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class g {
    public static void a(String str, String str2) {
        if (MemLeakManager.isDebug) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (MemLeakManager.isDebug) {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (MemLeakManager.isDebug) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (MemLeakManager.isDebug) {
            Log.e(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (MemLeakManager.isDebug) {
            Log.w(str, str2, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (MemLeakManager.isDebug) {
            Log.e(str, str2, th);
        }
    }
}
