package com.alipay.sdk.m.y;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25528a = "00:00:00:00:00:00";
    public static d b;

    public d(Context context) {
    }

    public static d b(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static i d(Context context) {
        try {
            NetworkInfo networkInfoA = com.alipay.sdk.m.a0.b.a(null, context);
            if (networkInfoA == null || networkInfoA.getType() != 0) {
                return (networkInfoA == null || networkInfoA.getType() != 1) ? i.NONE : i.WIFI;
            }
            return i.a(networkInfoA.getSubtype());
        } catch (Exception unused) {
            return i.NONE;
        }
    }

    public String a() {
        String str = b() + "|";
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return str + "000000000000000";
        }
        return str + strC;
    }

    public String b() {
        return "000000000000000";
    }

    public String c() {
        return "000000000000000";
    }

    public String d() {
        return f25528a;
    }

    public static String a(Context context) {
        return b(context).a().substring(0, 8);
    }
}
