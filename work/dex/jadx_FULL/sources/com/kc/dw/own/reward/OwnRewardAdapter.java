package com.kc.dw.own.reward;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.g;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.ad.z;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.b;
import com.kc.dw.core.ad.reward.RewardAdMediaListener;
import com.kc.dw.core.ad.reward.RewardInteractionListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.ad_adapter.reward.SsdRewardOwnListener;
import com.kc.dw.platform.ad_adapter.reward.c;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnRewardAdapter extends MsCustomRewardAdapter {
    private RewardVideoAd ad;
    private c adDelegate;
    private final SsdRewardOwnListener ownListener = new SsdRewardOwnListener(this) { // from class: com.kc.dw.own.reward.OwnRewardAdapter.1
        public final OwnRewardAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(RewardVideoAd rewardVideoAd, AdError adError, int i) {
            this.this$0.callRenderError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadedError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(RewardVideoAd rewardVideoAd) {
            this.this$0.ad = rewardVideoAd;
            rewardVideoAd.setInteractionListener(this.this$0.rewardInteractionListener);
            rewardVideoAd.setMediaListener(this.this$0.rewardAdMediaListener);
            this.this$0.callLoadedSuccess();
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(RewardVideoAd rewardVideoAd) {
            this.this$0.callRenderSuccess();
        }

        @Override // com.kc.dw.platform.ad_adapter.reward.SsdRewardOwnListener
        public void onVideoLoaded(RewardVideoAd rewardVideoAd) {
            this.this$0.callVideoLoaded();
        }
    };
    public RewardInteractionListener rewardInteractionListener = new RewardInteractionListener(this) { // from class: com.kc.dw.own.reward.OwnRewardAdapter.2
        public final OwnRewardAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClicked() {
            this.this$0.callAdClicked();
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClosed() {
            this.this$0.callAdClosed();
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdExposure() {
            this.this$0.callAdExposure();
        }

        @Override // com.kc.dw.core.ad.reward.RewardInteractionListener
        public void onReward(Map<String, Object> map) {
            this.this$0.callReward(map);
        }
    };
    public RewardAdMediaListener rewardAdMediaListener = new RewardAdMediaListener(this) { // from class: com.kc.dw.own.reward.OwnRewardAdapter.3
        public final OwnRewardAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public void onSkippedVideo() {
            this.this$0.callSkippedVideo();
        }

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public void onVideoCompleted() {
            this.this$0.callVideoCompleted();
        }

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public void onVideoError() {
            this.this$0.callVideoError();
        }

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public void onVideoLoaded() {
            this.this$0.callVideoLoaded();
        }

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public void onVideoPause() {
            this.this$0.callVideoPause();
        }

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public void onVideoResume() {
            this.this$0.callVideoResume();
        }

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public void onVideoStart() {
            this.this$0.callVideoStart();
        }
    };

    public BaseAdSlot getBaseAdSlot() {
        c cVar = this.adDelegate;
        if (cVar != null) {
            return (BaseAdSlot) cVar.f39477a;
        }
        return null;
    }

    public RewardVideoAd getRewardVideoAd() {
        return this.ad;
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        a.a(5, "e2", this);
        c cVar = this.adDelegate;
        if (cVar != null) {
            cVar.setLocalParams(getLocalParams());
            c cVar2 = this.adDelegate;
            cVar2.g = this.ownListener;
            cVar2.loadAd();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void render() {
        c cVar = this.adDelegate;
        if (cVar != null) {
            try {
                i iVar = (i) cVar.f39477a;
                com.kc.dw.platform.ad_adapter.reward.a aVar = cVar.f;
                b bVar = (b) cVar.getAdLoader();
                g gVar = cVar.j;
                cVar.a(iVar, aVar, bVar, gVar, (NormalMediaView) gVar.g);
            } catch (Exception e) {
                LogUtil.e("MeishuRewardVideoAdWrap", "render() error", e);
                cVar.a(cVar.f, "render() error", com.kc.dw.core.exception.b.i);
            }
        }
    }

    public void setRewardAdDelegate(com.kc.dw.core.loader.b bVar) {
        this.adDelegate = (c) bVar;
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void showAd(Activity activity) {
        String str;
        c cVar = this.adDelegate;
        if (cVar != null) {
            if (!cVar.isAutoRender() && cVar.b == 0) {
                str = "show方法应在收到renderSuccess后调用。(autoRender为false时)请在收到loadSuccess后，调用render接口";
            } else {
                if (cVar.c == 0) {
                    cVar.h.showAd(activity);
                    return;
                }
                str = "素材加载失败，请重新loadAd";
            }
            LogUtil.w("MeishuRewardVideoAdWrap", str);
            cVar.a((z) cVar.f, str, (Integer) 9000002);
        }
    }
}
