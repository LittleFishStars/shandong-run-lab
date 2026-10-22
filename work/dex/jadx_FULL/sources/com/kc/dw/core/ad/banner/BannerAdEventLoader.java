package com.kc.dw.core.ad.banner;

import android.app.Activity;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BannerAdEventLoader extends BannerCommonAdLoader {
    private static final String TAG = "BannerV3AdLoader";

    public BannerAdEventLoader(Activity activity, SsdAdSlot ssdAdSlot, BannerAdLoadListener bannerAdLoadListener) {
        if (ssdAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
        } else {
            init(activity, ssdAdSlot, bannerAdLoadListener);
        }
    }
}
