package com.alipay.sdk.m.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25421a = "ro.build.version.emui";
    public static final String b = "hw_sc.build.platform.version";

    public static com.alipay.sdk.m.c.b a(Context context) {
        String str = Build.BRAND;
        com.alipay.sdk.m.e.a.b("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_HW) || str.equalsIgnoreCase(AssistUtils.BRAND_HON) || str.equalsIgnoreCase("华为")) {
            return new b();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new i();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new h();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new f();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new c();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new e();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new g();
        }
        if (a()) {
            return new b();
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_MZ) || str.equalsIgnoreCase("mblu")) {
            return new d();
        }
        return null;
    }

    public static boolean a() {
        return (TextUtils.isEmpty(a("ro.build.version.emui")) && TextUtils.isEmpty(a(b))) ? false : true;
    }

    public static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(p3.f, String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
