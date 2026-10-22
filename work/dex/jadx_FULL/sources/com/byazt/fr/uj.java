package com.byazt.fr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2053, 15})
public class uj implements Function<SparseArray<Object>, Object> {
    private final IMediationSplashRequestInfo c;

    public uj(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.c = iMediationSplashRequestInfo;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        String adnName = "";
        switch (com.byazt.rl.ve.c(sparseArray).tt().intValue(-99999987)) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.c;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    adnName = this.c.getAdnName();
                }
                return String.valueOf(adnName);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.c;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    adnName = this.c.getAdnSlotId();
                }
                return String.valueOf(adnName);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.c;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    adnName = this.c.getAppId();
                }
                return String.valueOf(adnName);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.c;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    adnName = this.c.getAppkey();
                }
                return String.valueOf(adnName);
            default:
                return null;
        }
    }
}
