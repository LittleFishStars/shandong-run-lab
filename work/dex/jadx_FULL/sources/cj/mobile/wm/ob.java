package cj.mobile.wm;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class ob {
    public static String dexa(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(com.acse.ottn.p3.f, String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean dexa() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean dexb() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase(AssistUtils.BRAND_HW) || str.equalsIgnoreCase(AssistUtils.BRAND_HON) || str.equalsIgnoreCase("华为")) {
            return true;
        }
        return (TextUtils.isEmpty(dexa("ro.build.version.emui")) && TextUtils.isEmpty(dexa(com.alipay.sdk.m.d.a.b))) ? false : true;
    }

    public static boolean dexc() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod(com.acse.ottn.p3.f, String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }
}
