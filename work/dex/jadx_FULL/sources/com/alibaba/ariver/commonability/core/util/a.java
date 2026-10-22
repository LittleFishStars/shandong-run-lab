package com.alibaba.ariver.commonability.core.util;

import com.acse.ottn.p3;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f23949a;

    public static boolean a() {
        Boolean bool = f23949a;
        if (bool != null) {
            return bool.booleanValue();
        }
        Object objInvoke = null;
        boolean z = false;
        boolean z2 = true;
        try {
            objInvoke = Class.forName("android.os.SystemProperties").getMethod(p3.f, String.class).invoke(null, "ro.secure");
        } catch (Throwable unused) {
        }
        if ((objInvoke == null || !"1".equals(objInvoke)) && objInvoke != null && "0".equals(objInvoke)) {
            z = true;
        }
        if (z || (!new File("/system/bin/su").exists() && !new File("/system/xbin/su").exists())) {
            z2 = z;
        }
        Boolean boolValueOf = Boolean.valueOf(z2);
        f23949a = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static String a(long j) {
        String str;
        float f = j;
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " KB";
        } else {
            str = " B";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " MB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " GB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " TB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " PB";
        }
        String str2 = "%.2f";
        if (f >= 1.0f && f >= 10.0f && f >= 100.0f) {
            str2 = "%.0f";
        }
        return String.format(str2, Float.valueOf(f)) + str;
    }
}
