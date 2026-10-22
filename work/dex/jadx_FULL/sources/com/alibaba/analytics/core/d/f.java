package com.alibaba.analytics.core.d;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class f {
    private static boolean J = false;
    private static String ay = "";

    public static String b(Context context) {
        if (J || context == null) {
            return ay;
        }
        synchronized (f.class) {
            if (J) {
                return ay;
            }
            String str = "oaid=" + com.alibaba.analytics.core.d.a().getOaid();
            ay = str;
            J = true;
            return str;
        }
    }
}
