package com.acse.ottn;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h2 {
    public static void a(String str, String str2) {
        if (!l0.d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2 + "---" + Process.myPid());
    }

    public static void b(String str, String str2) {
        if (!l0.d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, str2 + "---" + Process.myPid());
    }

    public static void c(String str, String str2) {
        if (!l0.d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, str2 + "---" + Process.myPid());
    }

    public static void d(String str, String str2) {
        if (!l0.d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.v(str, str2 + "---" + Process.myPid());
    }

    public static void a(String str, String str2, IOException iOException) {
        if (!l0.d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, str2, iOException);
    }
}
