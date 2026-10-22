package com.kc.dw.core.ad.interstitial;

import android.app.Activity;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class InterstitialAdEventLoader extends InterstitialCommonAdLoader {
    private static final String TAG = "InterstitialV3AdLoader";

    public InterstitialAdEventLoader(Activity activity, SsdAdSlot ssdAdSlot, InterstitialAdLoadListener interstitialAdLoadListener) {
        if (ssdAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.accept_ad_width = Integer.valueOf(ssdAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(ssdAdSlot.getHeight());
        this.isClickToClose = ssdAdSlot.getIsClickToClose();
        this.isVideoAutoPlay = ssdAdSlot.getIsVideoAutoPlay();
        this.channel = ssdAdSlot.getChannel();
        init(activity, ssdAdSlot, interstitialAdLoadListener);
    }
}
