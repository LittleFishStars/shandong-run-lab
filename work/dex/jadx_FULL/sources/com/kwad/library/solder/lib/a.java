package com.kwad.library.solder.lib;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static String DH() {
        return "";
    }

    private static String F(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + DH();
    }

    public static void e(String str, String str2) {
        Log.e("Sodler", F(str, str2));
    }

    public static void e(String str, Throwable th) {
        Log.e("Sodler", F(str, ""), th);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e("Sodler", F(str, str2), th);
    }
}
