package com.byazt.sq;

import com.bytedance.sdk.openadsdk.TTAdLoadType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 900, 34})
public class a {
    public static Boolean c;

    private static boolean c() {
        if (c == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdLoadType");
                c = Boolean.TRUE;
            } catch (Throwable unused) {
                c = Boolean.FALSE;
            }
        }
        return c.booleanValue();
    }

    public static int c(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (c()) {
            try {
                if (TTAdLoadType.LOAD == obj) {
                    return 3;
                }
                if (TTAdLoadType.PRELOAD == obj) {
                    return 1;
                }
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
            } catch (Throwable unused) {
            }
        }
        return -1;
    }
}
