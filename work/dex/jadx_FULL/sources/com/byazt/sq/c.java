package com.byazt.sq;

import com.byazt.nr.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 900, 20})
public class c {
    public static Boolean c;

    private static boolean c() {
        if (c == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.mediation.MediationConstant$AdIsReadyStatus");
                c = Boolean.TRUE;
            } catch (Throwable unused) {
                c = Boolean.FALSE;
            }
        }
        return c.booleanValue();
    }

    public static Integer c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        try {
            if (c()) {
                if (obj == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
                    return 1;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
                    return 2;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
                    return 3;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
                    return 4;
                }
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return null;
    }
}
