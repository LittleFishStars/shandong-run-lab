package com.fl.saas.s2s.sdk.ad.video.reward;

import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.OnYqAdListener;
import com.fl.saas.s2s.sdk.helper.S2sRequestHelper;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2SRewardVideoAD {
    private final boolean mIsCache;
    private final OnS2SRewardVideoADListener mListener;
    private S2SRewardVideoADManager manager;

    public S2SRewardVideoAD(OnS2SRewardVideoADListener onS2SRewardVideoADListener, boolean z) {
        this.mListener = onS2SRewardVideoADListener;
        this.mIsCache = z;
    }

    public void destroy() {
        S2SRewardVideoADManager s2SRewardVideoADManager = this.manager;
        if (s2SRewardVideoADManager != null) {
            s2SRewardVideoADManager.destroy();
        }
    }

    public void loadAd(final AdSource adSource) {
        S2sRequestHelper.getInstance().requestAd(1, adSource, new OnYqAdListener() { // from class: com.fl.saas.s2s.sdk.ad.video.reward.S2SRewardVideoAD.1
            @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
            public void onAdFailed(YdError ydError) {
                if (S2SRewardVideoAD.this.mListener == null || ydError == null || ydError.getCode() == 1001) {
                    return;
                }
                S2SRewardVideoAD.this.mListener.onRewardVideoAdFailed(ydError);
            }

            @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
            public void onNativeAdReceived(List<AdInfoPoJo> list) {
                S2SRewardVideoAD s2SRewardVideoAD = S2SRewardVideoAD.this;
                s2SRewardVideoAD.manager = new S2SRewardVideoADManager(s2SRewardVideoAD.mIsCache, adSource);
                S2SRewardVideoAD.this.manager.init(list, S2SRewardVideoAD.this.mListener);
            }
        });
    }
}
