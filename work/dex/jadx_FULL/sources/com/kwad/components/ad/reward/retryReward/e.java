package com.kwad.components.ad.reward.retryReward;

import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private Object BH;

    public static class a {
        private static final e BI = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e kI() {
        return a.BI;
    }

    public static boolean kJ() {
        return bz.aE(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion(), "4.9.20.1");
    }

    public final void e(Object obj) {
        try {
            if (kJ() && (obj instanceof KsRewardVideoAd.KSAdRewardRetryTaskListener)) {
                this.BH = obj;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void onAdRewardRetryTaskNotify(KSAdInfoData kSAdInfoData) {
        try {
            if (kJ()) {
                Object obj = this.BH;
                if (obj instanceof KsRewardVideoAd.KSAdRewardRetryTaskListener) {
                    ((KsRewardVideoAd.KSAdRewardRetryTaskListener) obj).onAdRewardRetryTaskNotify(kSAdInfoData);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private e() {
    }
}
