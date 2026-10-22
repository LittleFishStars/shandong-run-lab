package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@SuppressLint({"AnnotateVersionCheck"})
final class AndroidVersion {
    static final int ANDROID_10 = 29;
    static final int ANDROID_11 = 30;
    static final int ANDROID_12 = 31;
    static final int ANDROID_12_L = 32;
    static final int ANDROID_13 = 33;
    static final int ANDROID_14 = 34;
    static final int ANDROID_4_0 = 14;
    static final int ANDROID_4_1 = 16;
    static final int ANDROID_4_2 = 17;
    static final int ANDROID_4_3 = 18;
    static final int ANDROID_4_4 = 19;
    static final int ANDROID_5 = 21;
    static final int ANDROID_5_1 = 22;
    static final int ANDROID_6 = 23;
    static final int ANDROID_7 = 24;
    static final int ANDROID_7_1 = 25;
    static final int ANDROID_8 = 26;
    static final int ANDROID_8_1 = 27;
    static final int ANDROID_9 = 28;

    public static int getAndroidVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    public static int getTargetSdkVersionCode(Context context) {
        return context.getApplicationInfo().targetSdkVersion;
    }

    public static boolean isAndroid10() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isAndroid11() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isAndroid12() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean isAndroid13() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean isAndroid14() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public static boolean isAndroid4() {
        return true;
    }

    public static boolean isAndroid4_2() {
        return true;
    }

    public static boolean isAndroid4_3() {
        return true;
    }

    public static boolean isAndroid4_4() {
        return true;
    }

    public static boolean isAndroid5() {
        return true;
    }

    public static boolean isAndroid5_1() {
        return true;
    }

    public static boolean isAndroid6() {
        return true;
    }

    public static boolean isAndroid7() {
        return true;
    }

    public static boolean isAndroid7_1() {
        return true;
    }

    public static boolean isAndroid8() {
        return true;
    }

    public static boolean isAndroid9() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
