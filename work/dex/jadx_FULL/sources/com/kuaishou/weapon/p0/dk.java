package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f40120a;

    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private dk() {
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(Context context) {
        try {
            return c(context) == a.ARM64_V8A;
        } catch (Throwable unused) {
        }
    }

    private static a c(Context context) {
        a aVar = f40120a;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = Process.is64Bit() ? a.ARM64_V8A : a.ARMEABI_V7A;
        f40120a = aVar2;
        return aVar2;
    }
}
