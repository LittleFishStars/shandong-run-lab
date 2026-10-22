package com.fl.saas.fl;

import android.app.Activity;
import android.view.ViewGroup;
import com.fl.saas.adx.api.FLSpread;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewSpreadListener;
import com.fl.saas.adx.base.interfaces.SpreadLoadListener;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
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
@Advertiser(keyClass = {FLSpread.class}, value = 22)
@SPI({AdapterAPI.class})
public class FlSpreadAdapter extends AdViewSpreadAdapter implements BiddingResult {
    private static final String TAG = CommConstant.getClassTag("FL", FlSpreadAdapter.class);
    private FLSpread flSpread;

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, int i3) {
        Optional.ofNullable(this.flSpread).ifPresent(new Consumer() { // from class: com.zj.adlib.di3
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((FLSpread) obj).biddingResultUpload(z, i, i2);
            }
        });
    }

    @Override // com.fl.saas.base.adapter.AdViewSpreadAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (this.flSpread == null || isCache()) {
            return;
        }
        this.flSpread.destroy();
        this.flSpread = null;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        LogcatUtil.d(TAG, "handle");
        FlAdManagerHolder.init(getContext(), getAppId());
        FLSpread fLSpreadBuild = new FLSpread.Builder(activity).setKey(getPosId()).setLinkId(getAdSource().req_id).setSpreadLoadListener(new SpreadLoadListener() { // from class: com.fl.saas.fl.FlSpreadAdapter.2
            @Override // com.fl.saas.adx.base.interfaces.SpreadLoadListener
            public void onADLoaded(final SpreadLoadListener.SpreadAd spreadAd) {
                LogcatUtil.d(FlSpreadAdapter.TAG, "onSplashAdLoad");
                if (spreadAd != null) {
                    if (FlSpreadAdapter.this.getAdSource().isC2SBidAd) {
                        FlSpreadAdapter.this.setECPM(spreadAd.getEcpm());
                    }
                    FlSpreadAdapter.this.onSpreadLoadedEvent(null, new AdViewSpreadAdapter.AdViewLoadListener() { // from class: com.zj.adlib.ei3
                        @Override // com.fl.saas.base.adapter.AdViewSpreadAdapter.AdViewLoadListener
                        public final void AdViewLoad(ViewGroup viewGroup) {
                            spreadAd.show(viewGroup);
                        }
                    });
                }
            }
        }).setSpreadListener(new AdViewSpreadListener() { // from class: com.fl.saas.fl.FlSpreadAdapter.1
            @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
            public void onAdClick(String str) {
                LogcatUtil.d(FlSpreadAdapter.TAG, "onAdClicked");
                FlSpreadAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
            public void onAdClose() {
                LogcatUtil.d(FlSpreadAdapter.TAG, "onAdClose");
                FlSpreadAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
            public void onAdDisplay() {
                LogcatUtil.d(FlSpreadAdapter.TAG, "onAdDisplay");
                FlSpreadAdapter.this.onShowEvent();
            }

            @Override // com.fl.saas.adx.base.interfaces.AdViewListener
            public void onAdFailed(FLError fLError) {
                FlSpreadAdapter.this.disposeError(YdError.create(fLError.getCode(), fLError.getMsg()));
            }
        }).build();
        this.flSpread = fLSpreadBuild;
        fLSpreadBuild.requestSpread();
    }
}
