package com.bwt.top;

import android.app.Activity;
import com.bwt.top.ad.bean.InterstitialAdInfo;
import com.bwt.top.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InterstitialAdUtils {
    private static volatile InterstitialAdUtils mUtils;
    private InterstitialAdInfo mAdInfo;

    private InterstitialAdUtils() {
    }

    private static boolean checkInterstitialAd(InterstitialAdInfo interstitialAdInfo) {
        if (interstitialAdInfo != null && !interstitialAdInfo.hasShown() && !interstitialAdInfo.hasExpired()) {
            return true;
        }
        ALog.d("AdUtil", "同一条广告不能重复曝光，(一次load只能show一次)");
        return false;
    }

    public static InterstitialAdUtils getInstance() {
        if (mUtils == null) {
            synchronized (InterstitialAdUtils.class) {
                if (mUtils == null) {
                    mUtils = new InterstitialAdUtils();
                }
            }
        }
        return mUtils;
    }

    public void setAdInfo(InterstitialAdInfo interstitialAdInfo) {
        this.mAdInfo = interstitialAdInfo;
    }

    public boolean showInterstitialAd(Activity activity) {
        if (activity == null || activity.isFinishing() || !checkInterstitialAd(this.mAdInfo)) {
            return false;
        }
        this.mAdInfo.showInterstitial(activity);
        this.mAdInfo = null;
        return true;
    }
}
