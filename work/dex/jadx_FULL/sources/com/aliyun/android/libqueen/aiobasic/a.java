package com.aliyun.android.libqueen.aiobasic;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f25561a = false;
    public static Throwable b;

    static {
        try {
            System.loadLibrary("all_in_one");
            f25561a = true;
        } catch (Throwable th) {
            Log.e("QueenLoaderAIO", "Load Queen_AIO library error ", th);
            b = th;
            f25561a = false;
        }
    }

    public static boolean a() {
        return f25561a;
    }
}
