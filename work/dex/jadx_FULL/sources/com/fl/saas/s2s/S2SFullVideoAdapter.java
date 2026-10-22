package com.fl.saas.s2s;

import android.app.Activity;
import android.text.TextUtils;
import com.fl.saas.base.adapter.AdViewFullVideoAdapter;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener;
import com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoAD;
import com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoADManager;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommReportHelper;
import com.fl.spi.SPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Advertiser(5)
@SPI({AdapterAPI.class})
public class S2SFullVideoAdapter extends AdViewFullVideoAdapter implements OnS2SFullVideoADListener, BiddingResult, AdChangeCacheData {
    private static final String TAG = CommConstant.getClassTag("S2S", S2SFullVideoAdapter.class);
    private S2SFullVideoADManager adManager;
    private AdInfoPoJo adPoJo;
    private S2SFullVideoAD s2SFullVideoAD = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRewardVideo$0(Activity activity) {
        onShowEvent();
        S2SFullVideoADManager s2SFullVideoADManager = this.adManager;
        if (s2SFullVideoADManager == null || !s2SFullVideoADManager.isReady()) {
            onFullVideoAdFailed(new YdError(400, "暂无可用全屏视频广告，请等待缓存加载或者重新刷新"));
        } else {
            this.adManager.showAd(activity);
        }
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
        if (this.s2SFullVideoAD == null || isCache()) {
            return;
        }
        this.s2SFullVideoAD.destroy();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        S2SFullVideoAD s2SFullVideoAD = new S2SFullVideoAD(this, getAdSource().isCacheAd);
        this.s2SFullVideoAD = s2SFullVideoAD;
        s2SFullVideoAD.loadAd(getAdSource());
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onClick(String str) {
        LogcatUtil.d(TAG, "onADClick");
        onClickedEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onClose() {
        LogcatUtil.d(TAG, "onADClose");
        onClosedEvent();
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onComplete(double d) {
        LogcatUtil.d(TAG, "onComplete");
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onError(YdError ydError) {
        onFullVideoAdFailed(ydError);
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onFullVideoAdFailed(YdError ydError) {
        disposeError(ydError);
    }

    @Override // com.fl.saas.s2s.sdk.ad.video.fullscreen.OnS2SFullVideoADListener
    public void onLoad(S2SFullVideoADManager s2SFullVideoADManager) {
        AdInfoPoJo.Creative creative;
        if (s2SFullVideoADManager == null) {
            onError(YdError.create(0, "S2SFullVideoADManager is null"));
            return;
        }
        this.adManager = s2SFullVideoADManager;
        AdInfoPoJo adInfoPoJo = s2SFullVideoADManager.getAdInfoPoJo();
        this.adPoJo = adInfoPoJo;
        if (adInfoPoJo != null && (creative = adInfoPoJo.creative) != null && !TextUtils.isEmpty(creative.cid)) {
            getAdSource().creative_id = this.adPoJo.creative.cid;
        }
        onLoadedEvent();
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

    @Override // com.fl.saas.base.adapter.AdViewFullVideoAdapter
    public void showRewardVideo() {
        getActivityValid().ifPresent(new Consumer() { // from class: com.zj.adlib.wo7
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f45648a.lambda$showRewardVideo$0((Activity) obj);
            }
        });
    }
}
