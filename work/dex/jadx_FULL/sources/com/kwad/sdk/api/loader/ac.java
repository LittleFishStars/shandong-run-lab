package com.kwad.sdk.api.loader;

import android.os.Process;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
final class ac {
    public static String Ex() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean is64Bit() {
        return Process.is64Bit();
    }
}
