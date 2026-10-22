package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f25344a = "";

    public static long a(Context context) {
        String strI = i(context, "update_time_interval");
        if (!com.alipay.sdk.m.d0.a.b(strI)) {
            return 86400000L;
        }
        try {
            return Long.parseLong(strI);
        } catch (Exception unused) {
            return 86400000L;
        }
    }

    public static void a(Context context, String str) {
        a(context, "update_time_interval", str);
    }

    public static void a(Context context, String str, long j) {
        com.alipay.sdk.m.g0.a.a(context, "vkeyid_settings", "vkey_valid" + str, j + "");
    }

    private static void a(Context context, String str, String str2) {
        com.alipay.sdk.m.g0.a.a(context, "vkeyid_settings", str, str2);
    }

    public static void a(Context context, boolean z) {
        a(context, "log_switch", z ? "1" : "0");
    }

    public static String b(Context context) {
        return i(context, "last_apdid_env");
    }

    public static void b(Context context, String str) {
        a(context, "last_machine_boot_time", str);
    }

    public static void c(Context context, String str) {
        a(context, "last_apdid_env", str);
    }

    public static boolean c(Context context) {
        String strI = i(context, "log_switch");
        return strI != null && "1".equals(strI);
    }

    public static String d(Context context) {
        return i(context, "dynamic_key");
    }

    public static void d(Context context, String str) {
        a(context, "agent_switch", str);
    }

    public static String e(Context context) {
        return i(context, "apse_degrade");
    }

    public static void e(Context context, String str) {
        a(context, "dynamic_key", str);
    }

    public static String f(Context context) {
        String str;
        synchronized (h.class) {
            if (com.alipay.sdk.m.d0.a.a(f25344a)) {
                String strB = com.alipay.sdk.m.g0.e.b(context, "alipay_vkey_random", "random", "");
                f25344a = strB;
                if (com.alipay.sdk.m.d0.a.a(strB)) {
                    String strA = com.alipay.sdk.m.e0.b.a(UUID.randomUUID().toString());
                    f25344a = strA;
                    com.alipay.sdk.m.g0.e.a(context, "alipay_vkey_random", "random", strA);
                }
            }
            str = f25344a;
        }
        return str;
    }

    public static void f(Context context, String str) {
        a(context, "webrtc_url", str);
    }

    public static void g(Context context, String str) {
        a(context, "apse_degrade", str);
    }

    public static long h(Context context, String str) {
        try {
            String strA = com.alipay.sdk.m.g0.a.a(context, "vkeyid_settings", "vkey_valid" + str);
            if (com.alipay.sdk.m.d0.a.a(strA)) {
                return 0L;
            }
            return Long.parseLong(strA);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static String i(Context context, String str) {
        return com.alipay.sdk.m.g0.a.a(context, "vkeyid_settings", str);
    }
}
