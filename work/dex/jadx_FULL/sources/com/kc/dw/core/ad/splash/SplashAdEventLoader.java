package com.kc.dw.core.ad.splash;

import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SplashAdEventLoader extends SplashCommonAdLoader {
    private static final String TAG = "SplashV3AdLoader";

    public SplashAdEventLoader(Context context, SsdAdSlot ssdAdSlot, SplashAdLoadListener splashAdLoadListener, int i) {
        this.fetchDelay = i;
        if (ssdAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.isVideoMute = ssdAdSlot.getIsMute();
        this.isHideSkipBtn = ssdAdSlot.getIsHideSkipButton();
        ssdAdSlot.getSplashShowTime();
        ssdAdSlot.getIsClickToClose();
        ssdAdSlot.isSplashClickPause();
        init(context, ssdAdSlot, splashAdLoadListener);
    }
}
