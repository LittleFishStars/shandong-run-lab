package com.fl.saas.s2s;

import android.app.Activity;
import android.text.TextUtils;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener;
import com.fl.saas.s2s.sdk.ad.video.reward.S2SRewardVideoAD;
import com.fl.saas.s2s.sdk.ad.video.reward.S2SRewardVideoADManager;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommReportHelper;
import com.fl.spi.SPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Advertiser(5)
@SPI({AdapterAPI.class})
public class S2SRewardVideoAdapter extends AdViewVideoAdapter implements OnS2SRewardVideoADListener, BiddingResult, AdChangeCacheData {
    private S2SRewardVideoADManager adManager;
    private AdInfoPoJo adPoJo;
    private S2SRewardVideoAD s2SRewardVideoAD = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRewardVideo$0(Activity activity) {
        S2SRewardVideoADManager s2SRewardVideoADManager = this.adManager;
        if (s2SRewardVideoADManager == null || !s2SRewardVideoADManager.isReady()) {
            onRewardVideoAdFailed(new YdError(400, "暂无可用激励视频广告，请等待缓存加载或者重新刷新"));
        } else {
            onShowEvent();
            this.adManager.showAd(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRewardVideo$1() {
        onError(YdError.create(0, "activity is null"));
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
        AdInfoPoJo adInfoPoJo = this.adPoJo;
        if (adInfoPoJo == null) {
            return;
        }
        adInfoPoJo.second_price = i2;
        if (!z) {
            if (i > 0) {
                adInfoPoJo.price = i;
            }
            CommReportHelper.getInstance().reportApiBidFail(this.adPoJo);
        } else {
            if (i > 0 && i <= adInfoPoJo.price) {
                adInfoPoJo.price = i;
            }
            CommReportHelper.getInstance().reportApiBidSuccess(this.adPoJo);
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (this.s2SRewardVideoAD == null || isCache()) {
            return;
        }
        this.s2SRewardVideoAD.destroy();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        S2SRewardVideoAD s2SRewardVideoAD = new S2SRewardVideoAD(this, getAdSource().isCacheAd);
        this.s2SRewardVideoAD = s2SRewardVideoAD;
        s2SRewardVideoAD.loadAd(getAdSource());
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener
    public void onClick(String str) {
        LogcatUtil.d("YdSDK-S2S-Video", "onADClick");
        onClickedEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener
    public void onClose() {
        LogcatUtil.d("YdSDK-S2S-Video", "onADClose");
        onClosedEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener
    public void onComplete(double d) {
        onVideoCompletedEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener
    public void onError(YdError ydError) {
        onRewardVideoAdFailed(ydError);
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener
    public void onLoad(S2SRewardVideoADManager s2SRewardVideoADManager) {
        AdInfoPoJo.Creative creative;
        if (s2SRewardVideoADManager == null) {
            onError(YdError.create(0, "S2SRewardVideoADManager is null"));
            return;
        }
        this.adManager = s2SRewardVideoADManager;
        AdInfoPoJo adInfoPoJo = s2SRewardVideoADManager.getAdInfoPoJo();
        this.adPoJo = adInfoPoJo;
        if (adInfoPoJo != null && (creative = adInfoPoJo.creative) != null && !TextUtils.isEmpty(creative.cid)) {
            getAdSource().creative_id = this.adPoJo.creative.cid;
        }
        onLoadedEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener
    public void onReward(double d) {
        onRewardEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener
    public void onRewardVideoAdFailed(YdError ydError) {
        disposeError(ydError);
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.reward.OnS2SRewardVideoADListener
    public void onSkip() {
        LogcatUtil.d("YdSDK-S2S-Video", "onSkip");
        onSkipEvent();
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        AdInfoPoJo adInfoPoJo = this.adPoJo;
        if (adInfoPoJo != null) {
            adInfoPoJo.trackId = str;
            adInfoPoJo.adPool = adSource.adPool;
            String str2 = adSource.place_id;
            adInfoPoJo.place_id = str2;
            adInfoPoJo.global_group_id = adSource.group_id;
            adInfoPoJo.global_place_id = str2;
            adInfoPoJo.global_test_id = adSource.test_id;
        }
    }

    @Override // com.fl.saas.base.adapter.AdViewVideoAdapter
    public void showRewardVideo() {
        getActivityValid().ifPresentOrElse(new Consumer() { // from class: com.zj.adlib.tp7
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f44978a.lambda$showRewardVideo$0((Activity) obj);
            }
        }, new Runnable() { // from class: com.zj.adlib.up7
            @Override // java.lang.Runnable
            public final void run() {
                this.f45201a.lambda$showRewardVideo$1();
            }
        });
    }
}
