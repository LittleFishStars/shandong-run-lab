package com.baidu.a;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f26252a = false;

    public static void a(String str, Object... objArr) {
        if (f26252a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }
}
