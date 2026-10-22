package cn.hzjizhun.admin.ad.utils;

import android.app.Activity;
import cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo;
import cn.hzjizhun.admin.ad.impl.JZInterstitialAsyncAd;
import cn.hzjizhun.admin.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JZInterstitialAdUtils {
    private static volatile JZInterstitialAdUtils mUtils;
    private JZInterstitialAsyncAd mAd;
    private JZInterstitialAdInfo mAdInfo;

    private JZInterstitialAdUtils() {
    }

    private static boolean checkInterstitialAd(JZInterstitialAdInfo jZInterstitialAdInfo) {
        if (jZInterstitialAdInfo != null && !jZInterstitialAdInfo.hasShown() && !jZInterstitialAdInfo.hasExpired()) {
            return true;
        }
        ALog.d("AdUtil", "同一条广告不能重复曝光，(一次load只能show一次)");
        return false;
    }

    public static JZInterstitialAdUtils getInstance() {
        if (mUtils == null) {
            synchronized (JZInterstitialAdUtils.class) {
                if (mUtils == null) {
                    mUtils = new JZInterstitialAdUtils();
                }
            }
        }
        return mUtils;
    }

    public static boolean isAdInfoEmpty() {
        return getInstance().mAdInfo == null;
    }

    public static boolean isAdInfoRelease() {
        return getInstance().mAdInfo.hasShown() || getInstance().mAdInfo.hasExpired();
    }

    public void release() {
        JZInterstitialAsyncAd jZInterstitialAsyncAd = this.mAd;
        if (jZInterstitialAsyncAd != null) {
            jZInterstitialAsyncAd.releaseAd();
        }
    }

    public void setAd(JZInterstitialAsyncAd jZInterstitialAsyncAd) {
        this.mAd = jZInterstitialAsyncAd;
    }

    public void setAdInfo(JZInterstitialAdInfo jZInterstitialAdInfo) {
        this.mAdInfo = jZInterstitialAdInfo;
    }

    public boolean showJZInterstitialAd(Activity activity) {
        if (activity == null || activity.isFinishing() || !checkInterstitialAd(this.mAdInfo)) {
            return false;
        }
        this.mAdInfo.showInterstitial(activity);
        this.mAdInfo = null;
        return true;
    }
}
