package com.kc.dw.core.ad.fullscreenvideo;

import android.app.Activity;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class FullScreenVideoEventAdLoader extends FullScreenVideoCommonAdLoader {
    private static final String TAG = "FullScreenVideoV3AdLoader";

    public FullScreenVideoEventAdLoader(Activity activity, SsdAdSlot ssdAdSlot, FullScreenAdLoadListener fullScreenAdLoadListener) {
        if (ssdAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
        } else {
            init(activity, ssdAdSlot, fullScreenAdLoadListener);
        }
    }
}
