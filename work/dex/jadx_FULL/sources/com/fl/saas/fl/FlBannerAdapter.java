package com.fl.saas.fl;

import android.app.Activity;
import android.view.View;
import com.fl.saas.adx.api.FLBanner;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewBannerListener;
import com.fl.saas.base.adapter.AdViewBannerAdapter;
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
@Advertiser(keyClass = {FLBanner.class}, value = 22)
@SPI({AdapterAPI.class})
public class FlBannerAdapter extends AdViewBannerAdapter implements BiddingResult {
    private static final String TAG = CommConstant.getClassTag("FL", FlBannerAdapter.class);
    private FLBanner banner;

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, int i3) {
        Optional.ofNullable(this.banner).ifPresent(new Consumer() { // from class: com.zj.adlib.zh3
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((FLBanner) obj).biddingResultUpload(z, i, i2);
            }
        });
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (this.banner == null || isCache()) {
            return;
        }
        this.banner.destroy();
        this.banner = null;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        LogcatUtil.d(TAG, "handle");
        FlAdManagerHolder.init(getContext(), getAppId());
        FLBanner fLBanner = this.banner;
        if (fLBanner != null) {
            fLBanner.destroy();
        }
        FLBanner fLBannerBuild = new FLBanner.Builder(activity).setKey(getPosId()).setExpressWidth(getWidth()).setExpressHeight(getHeight()).setLinkId(getAdSource().req_id).setBannerListener(new AdViewBannerListener() { // from class: com.fl.saas.fl.FlBannerAdapter.1
            @Override // com.fl.saas.adx.base.base.listener.InnerBannerListener
            public void onAdClick(String str) {
                LogcatUtil.d(FlBannerAdapter.TAG, "onAdClick");
                FlBannerAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerBannerListener
            public void onAdExposure() {
                LogcatUtil.d(FlBannerAdapter.TAG, "onAdExposure");
                FlBannerAdapter.this.onShowEvent();
            }

            @Override // com.fl.saas.adx.base.interfaces.AdViewListener
            public void onAdFailed(FLError fLError) {
                FlBannerAdapter.this.disposeError(new YdError(fLError.getCode(), fLError.getMsg()));
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerBannerListener
            public void onClosed() {
                LogcatUtil.d(FlBannerAdapter.TAG, "onClosed");
                FlBannerAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerBannerListener
            public void onReceived(View view) {
                LogcatUtil.d(FlBannerAdapter.TAG, "onADReceive");
                if (FlBannerAdapter.this.banner != null) {
                    if (FlBannerAdapter.this.getAdSource().isC2SBidAd) {
                        FlBannerAdapter flBannerAdapter = FlBannerAdapter.this;
                        flBannerAdapter.setECPM(flBannerAdapter.banner.getECPM());
                    }
                    FlBannerAdapter.this.onLoadedEvent(view);
                }
            }
        }).build();
        this.banner = fLBannerBuild;
        fLBannerBuild.requestBanner();
    }
}
