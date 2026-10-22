package com.zj.adlib;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class dva {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f41288a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        f41288a = sb.toString();
    }

    public static void a() {
        e(f41288a);
        e("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
        e(f41288a);
    }

    public static void b(Context context, String str) {
        e(f41288a);
        if (context != null) {
            d("key:" + j4b.j(context));
        }
        e(str);
        e(f41288a);
    }

    public static void c(String str) {
        e(f41288a);
        e(str);
        e(f41288a);
    }

    public static void d(String str) {
        if (str.length() >= 78) {
            e("|" + str.substring(0, 78) + "|");
            d(str.substring(78));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (int i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        e(sb.toString());
    }

    public static void e(String str) {
        Log.i("authErrLog", str);
    }
}
