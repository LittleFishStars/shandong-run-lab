package com.alipay.sdk.m.g0;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static String a(String str) {
        String strA;
        try {
            strA = f.a(str);
        } catch (Throwable unused) {
            strA = "";
        }
        if (!com.alipay.sdk.m.d0.a.a(strA)) {
            return strA;
        }
        return c.a(".SystemConfig" + File.separator + str);
    }

    public static void a(String str, String str2) {
        try {
            f.a(str, str2);
        } catch (Throwable unused) {
        }
        if (c.a()) {
            c.a(".SystemConfig" + File.separator + str, str2);
        }
    }
}
