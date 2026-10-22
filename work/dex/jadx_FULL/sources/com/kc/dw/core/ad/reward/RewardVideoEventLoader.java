package com.kc.dw.core.ad.reward;

import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RewardVideoEventLoader extends RewardVideoCommonLoader {
    private static final String TAG = "RewardVideoV3Loader";

    public RewardVideoEventLoader(Context context, SsdAdSlot ssdAdSlot, RewardAdLoadListener rewardAdLoadListener) {
        if (ssdAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
        } else {
            init(context, ssdAdSlot, rewardAdLoadListener);
        }
    }
}
