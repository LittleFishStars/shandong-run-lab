package com.alipay.sdk.m.m0;

import android.content.Context;
import com.alipay.sdk.m.b.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static String a(Context context) {
        if (com.alipay.sdk.m.b.a.f25388a) {
            return b.C0187b.f25391a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (com.alipay.sdk.m.b.a.f25388a) {
            return b.C0187b.f25391a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (com.alipay.sdk.m.b.a.f25388a) {
            return b.C0187b.f25391a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (com.alipay.sdk.m.b.a.f25388a) {
            return b.C0187b.f25391a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void e(Context context) {
        com.alipay.sdk.m.b.a.b = b.C0187b.f25391a.a(context.getApplicationContext());
        com.alipay.sdk.m.b.a.f25388a = true;
    }

    public static boolean a() {
        if (com.alipay.sdk.m.b.a.f25388a) {
            return com.alipay.sdk.m.b.a.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
