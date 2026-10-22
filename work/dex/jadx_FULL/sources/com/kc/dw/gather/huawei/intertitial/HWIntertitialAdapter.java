package com.kc.dw.gather.huawei.intertitial;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.ReportUrlListener;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.interstitial.InterstitialCommonAdLoader;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HWIntertitialAdapter extends MsCustomInterstitialAdapter {
    private InterstitialAd interstitialAd;

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        InterstitialAd interstitialAd = new InterstitialAd(((InterstitialCommonAdLoader) this.adLoader).getContext());
        this.interstitialAd = interstitialAd;
        interstitialAd.setAdId(getSdkAdInfo().getPid());
        AdParam.Builder builder = new AdParam.Builder();
        if (this.sdkAdInfo.getIs_bidding() == 1) {
            try {
                builder.addBiddingParamMap(getSdkAdInfo().getPid(), new BiddingParam.Builder().setBidFloor(Float.valueOf(getSdkAdInfo().getPrice() / 100.0f)).setBidFloorCur("CNY").build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            builder.setTMax(3000);
        }
        AdParam adParamBuild = builder.build();
        this.interstitialAd.setAdListener(new AdListener(this) { // from class: com.kc.dw.gather.huawei.intertitial.HWIntertitialAdapter.1
            public final HWIntertitialAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onAdClicked() {
                this.this$0.callAdClicked();
            }

            public void onAdClosed() {
                this.this$0.callAdClosed();
            }

            public void onAdFailed(int i) {
                this.this$0.callLoadedError(i, "load error");
            }

            public void onAdImpression() {
            }

            public void onAdLeave() {
            }

            public void onAdLoaded() {
                try {
                    if (this.this$0.getSdkAdInfo() != null) {
                        this.this$0.getSdkAdInfo().setEcpm(String.valueOf((int) (this.this$0.interstitialAd.getBiddingInfo().getPrice().floatValue() * 100.0f)));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            }

            public void onAdOpened() {
                this.this$0.callAdExposure();
            }
        });
        this.interstitialAd.loadAd(adParamBuild);
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        BiddingInfo biddingInfo;
        try {
            InterstitialAd interstitialAd = this.interstitialAd;
            if (interstitialAd != null && (biddingInfo = interstitialAd.getBiddingInfo()) != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("SECOND_PRICE", Float.valueOf((s0.a((int) (biddingInfo.getPrice().floatValue() * 100.0f), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()) * 1.0f) / 100.0f));
                    map.put("AUCTION_CURRENCY", "CNY");
                    this.interstitialAd.sendBiddingSuccess(map, new ReportUrlListener(this) { // from class: com.kc.dw.gather.huawei.intertitial.HWIntertitialAdapter.2
                        public final HWIntertitialAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void reportFailed(String str, int i2) {
                        }

                        public void reportSuccess() {
                        }
                    });
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("AUCTION_PRICE", Float.valueOf((i * 1.0f) / 100.0f));
                    map2.put("AUCTION_CURRENCY", "CNY");
                    map2.put("AUCTION_LOSS", 102);
                    map2.put("AUCTION_CP_ID", "100");
                    this.interstitialAd.sendBiddingFailed(map2, new ReportUrlListener(this) { // from class: com.kc.dw.gather.huawei.intertitial.HWIntertitialAdapter.3
                        public final HWIntertitialAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void reportFailed(String str, int i2) {
                        }

                        public void reportSuccess() {
                        }
                    });
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void showAd(Activity activity) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null || !interstitialAd.isLoaded()) {
            return;
        }
        this.interstitialAd.show(activity);
    }
}
