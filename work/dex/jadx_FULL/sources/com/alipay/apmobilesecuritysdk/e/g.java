package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {
    public static synchronized String a(Context context, String str) {
        String strB = com.alipay.sdk.m.g0.e.b(context, "openapi_file_pri", "openApi" + str, "");
        if (com.alipay.sdk.m.d0.a.a(strB)) {
            return "";
        }
        String strB2 = com.alipay.sdk.m.e0.c.b(com.alipay.sdk.m.e0.c.a(), strB);
        return com.alipay.sdk.m.d0.a.a(strB2) ? "" : strB2;
    }

    public static synchronized void a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
        if (editorEdit != null) {
            editorEdit.clear();
            editorEdit.commit();
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (editorEdit != null) {
                editorEdit.putString("openApi" + str, com.alipay.sdk.m.e0.c.a(com.alipay.sdk.m.e0.c.a(), str2));
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void b(Context context, String str) {
    }
}
