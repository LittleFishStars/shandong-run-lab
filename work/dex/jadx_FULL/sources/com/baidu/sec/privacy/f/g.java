package com.baidu.sec.privacy.f;

import com.acse.ottn.p3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g {
    public static String a(String str, String str2) {
        try {
            Class clsA = com.baidu.sec.privacy.b.b.a(com.baidu.sec.privacy.b.b.a()).a(g.class.getClassLoader(), "android.os.SystemProperties");
            return clsA == null ? str2 : (String) clsA.getMethod(p3.f, String.class).invoke(clsA, str);
        } catch (Throwable th) {
            c.a(th);
            return str2;
        }
    }
}
