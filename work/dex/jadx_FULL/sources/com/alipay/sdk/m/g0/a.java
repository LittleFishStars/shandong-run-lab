package com.alipay.sdk.m.g0;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        synchronized (a.class) {
            String strB = null;
            if (context != null) {
                try {
                    if (!com.alipay.sdk.m.d0.a.a(str) && !com.alipay.sdk.m.d0.a.a(str2)) {
                        try {
                            String strB2 = e.b(context, str, str2, "");
                            if (com.alipay.sdk.m.d0.a.a(strB2)) {
                                return null;
                            }
                            strB = com.alipay.sdk.m.e0.c.b(com.alipay.sdk.m.e0.c.a(), strB2);
                        } catch (Throwable unused) {
                        }
                        return strB;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
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
    }
}
