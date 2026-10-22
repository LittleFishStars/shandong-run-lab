package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import com.alipay.sdk.m.g0.e;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        if (context == null || com.alipay.sdk.m.d0.a.a(str) || com.alipay.sdk.m.d0.a.a(str2)) {
            return null;
        }
        try {
            String strB = e.b(context, str, str2, "");
            if (com.alipay.sdk.m.d0.a.a(strB)) {
                return null;
            }
            return com.alipay.sdk.m.e0.c.b(com.alipay.sdk.m.e0.c.a(), strB);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (com.alipay.sdk.m.d0.a.a(str) || com.alipay.sdk.m.d0.a.a(str2)) {
                return null;
            }
            try {
                String strA = com.alipay.sdk.m.g0.b.a(str);
                if (com.alipay.sdk.m.d0.a.a(strA)) {
                    return null;
                }
                String string = new JSONObject(strA).getString(str2);
                if (com.alipay.sdk.m.d0.a.a(string)) {
                    return null;
                }
                return com.alipay.sdk.m.e0.c.b(com.alipay.sdk.m.e0.c.a(), string);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (com.alipay.sdk.m.d0.a.a(str) || com.alipay.sdk.m.d0.a.a(str2) || context == null) {
            return;
        }
        try {
            String strA = com.alipay.sdk.m.e0.c.a(com.alipay.sdk.m.e0.c.a(), str3);
            HashMap map = new HashMap();
            map.put(str2, strA);
            e.a(context, str, map);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (com.alipay.sdk.m.d0.a.a(str) || com.alipay.sdk.m.d0.a.a(str2)) {
                return;
            }
            try {
                String strA = com.alipay.sdk.m.g0.b.a(str);
                JSONObject jSONObject = new JSONObject();
                if (com.alipay.sdk.m.d0.a.b(strA)) {
                    try {
                        jSONObject = new JSONObject(strA);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                }
                jSONObject.put(str2, com.alipay.sdk.m.e0.c.a(com.alipay.sdk.m.e0.c.a(), str3));
                com.alipay.sdk.m.g0.b.a(str, jSONObject.toString());
            } catch (Throwable unused2) {
            }
        }
    }
}
