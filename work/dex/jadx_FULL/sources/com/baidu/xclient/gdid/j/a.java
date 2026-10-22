package com.baidu.xclient.gdid.j;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static String a(Context context) {
        try {
            String strC = com.baidu.mshield.b.b.a.c(context);
            return TextUtils.isEmpty(strC) ? com.baidu.mshield.b.b.a.b(context) : strC;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
