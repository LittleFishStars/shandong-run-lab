package com.byazt.sq;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 900, 13})
public class tt {
    public static Boolean c;

    private static boolean c() {
        if (c == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.mediation.MediationConstant$BiddingLossReason");
                c = Boolean.TRUE;
            } catch (Throwable unused) {
                c = Boolean.FALSE;
            }
        }
        return c.booleanValue();
    }

    public static Object c(int i) {
        if (!c()) {
            return Integer.valueOf(i);
        }
        try {
            if (i == 1) {
                return MediationConstant.BiddingLossReason.LOW_PRICE;
            }
            if (i == 2) {
                return MediationConstant.BiddingLossReason.TIME_OUT;
            }
            if (i == 3) {
                return MediationConstant.BiddingLossReason.NO_AD;
            }
            if (i == 4) {
                return MediationConstant.BiddingLossReason.AD_DATA_ERROR;
            }
            if (i != 10001) {
                return null;
            }
            return MediationConstant.BiddingLossReason.OTHER;
        } catch (Throwable unused) {
            return null;
        }
    }
}
