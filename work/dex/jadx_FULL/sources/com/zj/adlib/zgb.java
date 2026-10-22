package com.zj.adlib;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class zgb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f46260a;
    public static String b;

    public static String a() {
        return b;
    }

    public static String b() {
        return f46260a;
    }

    public static void c(String str, String str2) {
        StringBuilder sb;
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.endsWith(WVNativeCallbackUtil.SEPERATER)) {
            f46260a = str2 + "infoConfig/" + str;
            sb = new StringBuilder();
            sb.append(str2);
            str3 = "notice/";
        } else {
            f46260a = str2 + "/infoConfig/" + str;
            sb = new StringBuilder();
            sb.append(str2);
            str3 = "/notice/";
        }
        sb.append(str3);
        sb.append(str);
        b = sb.toString();
    }
}
