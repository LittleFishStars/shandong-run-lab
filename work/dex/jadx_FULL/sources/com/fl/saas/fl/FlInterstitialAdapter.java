package com.fl.saas.fl;

import android.app.Activity;
import com.fl.saas.adx.api.FLInterstitial;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.fl.config.FlAdManagerHolder;
import com.fl.spi.SPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Advertiser(keyClass = {FLInterstitial.class}, value = 22)
@SPI({AdapterAPI.class})
public class FlInterstitialAdapter extends AdViewInterstitialAdapter implements BiddingResult {
    private static final String TAG = CommConstant.getClassTag("FL", FlInterstitialAdapter.class);
    private FLInterstitial mInterstitialAd;

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, int i3) {
        Optional.ofNullable(this.mInterstitialAd).ifPresent(new Consumer() { // from class: com.zj.adlib.ai3
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((FLInterstitial) obj).biddingResultUpload(z, i, i2);
            }
        });
    }

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (this.mInterstitialAd == null && isCache()) {
            return;
        }
        this.mInterstitialAd.destroy();
        this.mInterstitialAd = null;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(final Activity activity) {
        LogcatUtil.d(TAG, "handle");
        FlAdManagerHolder.init(getContext(), getAppId());
        FLInterstitial fLInterstitialBuild = new FLInterstitial.Builder(activity).setKey(getPosId()).setLinkId(getAdSource().req_id).setInterstitialListener(new AdViewInterstitialListener() { // from class: com.fl.saas.fl.FlInterstitialAdapter.1
            @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
                LogcatUtil.d(FlInterstitialAdapter.TAG, "onAdClicked");
                FlInterstitialAdapter.this.onClickedEvent();
                FlInterstitialAdapter.this.checkReRequest(activity);
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                LogcatUtil.d(FlInterstitialAdapter.TAG, "onAdClosed");
                FlInterstitialAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
                LogcatUtil.d(FlInterstitialAdapter.TAG, "onAdDisplay");
                FlInterstitialAdapter.this.onShowEvent();
            }

            @Override // com.fl.saas.adx.base.interfaces.AdViewListener
            public void onAdFailed(FLError fLError) {
                FlInterstitialAdapter.this.disposeError(new YdError(fLError.getCode(), fLError.getMsg()));
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
            public void onAdReady() {
                LogcatUtil.d(FlInterstitialAdapter.TAG, "onAdReady");
                if (FlInterstitialAdapter.this.mInterstitialAd != null) {
                    if (FlInterstitialAdapter.this.getAdSource().isC2SBidAd) {
                        FlInterstitialAdapter flInterstitialAdapter = FlInterstitialAdapter.this;
                        flInterstitialAdapter.setECPM(flInterstitialAdapter.mInterstitialAd.getECPM());
                    }
                    FlInterstitialAdapter.this.onLoadedEvent();
                }
            }
        }).build();
        this.mInterstitialAd = fLInterstitialBuild;
        fLInterstitialBuild.requestInterstitial();
    }

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter
    public void showInterstitial(Activity activity) {
        LogcatUtil.d(TAG, "showInterstitialAd activity");
        FLInterstitial fLInterstitial = this.mInterstitialAd;
        if (fLInterstitial != null) {
            fLInterstitial.show(activity);
        }
    }
}
