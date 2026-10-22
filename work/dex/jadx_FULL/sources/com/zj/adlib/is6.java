package com.zj.adlib;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.core.os.BuildCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@VisibleForTesting
@KeepForSdk
public final class is6 {
    @ChecksSdkIntAtLeast(api = 11)
    @KeepForSdk
    public static boolean a() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 12)
    @KeepForSdk
    public static boolean b() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 14)
    @KeepForSdk
    public static boolean c() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 15)
    @KeepForSdk
    public static boolean d() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 16)
    @KeepForSdk
    public static boolean e() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 17)
    @KeepForSdk
    public static boolean f() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 18)
    @KeepForSdk
    public static boolean g() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 19)
    @KeepForSdk
    public static boolean h() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 20)
    @KeepForSdk
    public static boolean i() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 21)
    @KeepForSdk
    public static boolean j() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 22)
    @KeepForSdk
    public static boolean k() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 23)
    @KeepForSdk
    public static boolean l() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 24)
    @KeepForSdk
    public static boolean m() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 26)
    @KeepForSdk
    public static boolean n() {
        return true;
    }

    @ChecksSdkIntAtLeast(api = 28)
    @KeepForSdk
    public static boolean o() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @ChecksSdkIntAtLeast(api = 29)
    @KeepForSdk
    public static boolean p() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @ChecksSdkIntAtLeast(api = 30)
    @KeepForSdk
    public static boolean q() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @ChecksSdkIntAtLeast(api = 31)
    @KeepForSdk
    public static boolean r() {
        return Build.VERSION.SDK_INT >= 31;
    }

    @ChecksSdkIntAtLeast(api = 32)
    @KeepForSdk
    public static boolean s() {
        return Build.VERSION.SDK_INT >= 32;
    }

    @ChecksSdkIntAtLeast(api = 33)
    @KeepForSdk
    public static boolean t() {
        return Build.VERSION.SDK_INT >= 33 || Build.VERSION.CODENAME.charAt(0) == 'T';
    }

    @ChecksSdkIntAtLeast(api = 33, codename = "UpsideDownCake")
    @KeepForSdk
    public static boolean u() {
        if (t()) {
            return BuildCompat.isAtLeastU();
        }
        return false;
    }
}
