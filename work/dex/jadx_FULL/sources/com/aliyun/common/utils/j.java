package com.aliyun.common.utils;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f25580a = false;

    private static void a(int i, Throwable th, String str, Object... objArr) {
        if (f25580a) {
            return;
        }
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (th != null) {
            if (str == null) {
                str = th.getMessage();
            }
            str = String.format("%1$s\n%2$s", str, Log.getStackTraceString(th));
        }
        Log.println(i, "VideoLoader", str);
    }

    public static void a(String str, Object... objArr) {
        a(4, null, str, objArr);
    }

    public static void b(String str, Object... objArr) {
        a(5, null, str, objArr);
    }
}
