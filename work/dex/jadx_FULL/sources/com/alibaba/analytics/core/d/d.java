package com.alibaba.analytics.core.d;

import android.content.Context;
import com.alibaba.analytics.a.r;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {
    private static boolean I = true;
    private static String ax;

    public static String a(Context context) {
        if (context == null || !I) {
            return null;
        }
        try {
            Object objA = r.a(Class.forName("com.taobao.dp.DeviceSecuritySDK"), "getInstance", new Object[]{context}, Context.class);
            if (objA == null) {
                return null;
            }
            Object objA2 = r.a(objA, "getSecurityToken");
            if (objA2 != null) {
                ax = (String) objA2;
            }
            return (String) objA2;
        } catch (Exception unused) {
            return null;
        }
    }
}
