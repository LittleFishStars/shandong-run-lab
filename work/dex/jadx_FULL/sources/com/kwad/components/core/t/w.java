package com.kwad.components.core.t;

import android.content.Context;
import android.os.Build;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class w {
    private static final String[] alW = {"ONEPLUS A6000", "ONEPLUS A6003", "IN2010"};
    private static Boolean alX;

    public static boolean aR(Context context) {
        Boolean bool = alX;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (bd.UA()) {
            alX = Boolean.valueOf(aS(context));
        } else if (bd.UB()) {
            alX = Boolean.valueOf(wY() || wZ());
        } else if (bd.Wa()) {
            alX = Boolean.valueOf(xa());
        } else if (bd.Wb()) {
            alX = Boolean.valueOf(xb());
        } else if (bd.Wd()) {
            alX = wX();
        } else {
            alX = Boolean.valueOf(xc());
        }
        return alX.booleanValue();
    }

    private static boolean aS(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception unused) {
            return false;
        }
    }

    private static Boolean wX() {
        Boolean bool;
        boolean z = false;
        try {
            bool = (Boolean) ab.a("smartisanos.api.DisplayUtilsSmt", "isFeatureSupport", 1);
        } catch (Exception unused) {
            bool = null;
        }
        if (bool != null && bool.booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private static boolean wY() {
        Boolean bool;
        try {
            bool = (Boolean) ab.a("android.util.FtFeature", "isFeatureSupport", 32);
        } catch (Exception unused) {
            bool = null;
        }
        return bool != null && bool.booleanValue();
    }

    private static boolean wZ() {
        Boolean bool;
        try {
            bool = (Boolean) ab.a("android.util.FtFeature", "isFeatureSupport", "vivo.hardware.holescreen");
        } catch (Exception unused) {
            bool = null;
        }
        return bool != null && bool.booleanValue();
    }

    private static boolean xa() {
        Boolean bool;
        try {
            bool = (Boolean) ab.a("com.huawei.android.util.HwNotchSizeUtil", "hasNotchInScreen", new Object[0]);
        } catch (Exception unused) {
            bool = null;
        }
        return bool != null && bool.booleanValue();
    }

    private static boolean xb() {
        Integer num;
        try {
            num = (Integer) ab.a("android.os.SystemProperties", "getInt", "ro.miui.notch", 0);
        } catch (Exception unused) {
            num = null;
        }
        return num != null && num.intValue() == 1;
    }

    private static boolean xc() {
        for (String str : alW) {
            if (str.equalsIgnoreCase(Build.MODEL)) {
                return true;
            }
        }
        return false;
    }
}
