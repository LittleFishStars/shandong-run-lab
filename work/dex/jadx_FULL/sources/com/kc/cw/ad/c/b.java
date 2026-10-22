package com.kc.cw.ad.c;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.igexin.assist.util.AssistUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {
    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(p3.f, String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean c() {
        String str = Build.BRAND;
        if (!str.equalsIgnoreCase(AssistUtils.BRAND_HW) && !str.equalsIgnoreCase(AssistUtils.BRAND_HON) && !str.equalsIgnoreCase("华为")) {
            String strA = a("ro.build.version.emui");
            String strA2 = a(com.alipay.sdk.m.d.a.b);
            if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(strA2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }
}
