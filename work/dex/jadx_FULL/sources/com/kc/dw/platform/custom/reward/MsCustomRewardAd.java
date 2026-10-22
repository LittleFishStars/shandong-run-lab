package com.kc.dw.platform.custom.reward;

import android.app.Activity;
import com.kc.dw.core.ad.a;
import com.kc.dw.core.ad.reward.RewardAdMediaListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCustomRewardAd extends a implements RewardVideoAd {
    private RewardAdMediaListener rewardAdMediaListener;
    private final MsCustomRewardAdapter rewardLoader;

    public MsCustomRewardAd(MsCustomRewardAdapter msCustomRewardAdapter, String str) {
        super(msCustomRewardAdapter, str);
        this.rewardLoader = msCustomRewardAdapter;
    }

    public void destroy() {
    }

    @Override // com.kc.dw.core.ad.a
    public HashMap<String, Object> getExtraMap() {
        MsCustomRewardAdapter msCustomRewardAdapter = this.rewardLoader;
        if (msCustomRewardAdapter != null) {
            return msCustomRewardAdapter.getExtraMap();
        }
        return null;
    }

    public RewardAdMediaListener getRewardAdMediaListener() {
        return this.rewardAdMediaListener;
    }

    @Override // com.kc.dw.core.ad.reward.RewardVideoAd, com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void render() {
        MsCustomRewardAdapter msCustomRewardAdapter;
        if (!isMSPlatform() || isAutoRender() || (msCustomRewardAdapter = this.rewardLoader) == null) {
            return;
        }
        msCustomRewardAdapter.render();
    }

    @Override // com.kc.dw.core.ad.reward.RewardVideoAd
    public void setMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        this.rewardAdMediaListener = rewardAdMediaListener;
    }

    @Override // com.kc.dw.core.ad.reward.RewardVideoAd, com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        com.kc.dw.core.service.logrecord.a.a(5, "e6", this.adWrapper);
        MsCustomRewardAdapter msCustomRewardAdapter = this.rewardLoader;
        if (msCustomRewardAdapter != null) {
            msCustomRewardAdapter.setAdShowStatus(true);
            this.rewardLoader.showAd(activity);
        }
    }
}
