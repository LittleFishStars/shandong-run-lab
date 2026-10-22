package com.kc.dw.gather.huawei.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.splash.SplashAd;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.igexin.push.config.c;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HWSplashAdapter extends MsCustomSplashAdapter {
    private boolean showed;
    private SplashAd splashAd;
    private SplashView splashView;

    /* JADX INFO: renamed from: com.kc.dw.gather.huawei.splash.HWSplashAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements SplashLoadListener {
        public final HWSplashAdapter this$0;

        /* JADX INFO: renamed from: com.kc.dw.gather.huawei.splash.HWSplashAdapter$2$1, reason: invalid class name */
        @Keep
        public class AnonymousClass1 extends SplashAdDisplayListener {
            public final AnonymousClass2 this$1;

            public AnonymousClass1(AnonymousClass2 anonymousClass2) {
                this.this$1 = anonymousClass2;
            }

            public void onAdClick() {
                this.this$1.this$0.callAdClicked();
                SdkHandler.getInstance().postDelay(new j(this) { // from class: com.kc.dw.gather.huawei.splash.HWSplashAdapter.2.1.1
                    public final AnonymousClass1 this$2;

                    {
                        this.this$2 = this;
                    }

                    @Override // com.kc.dw.core.safe.j
                    public void safeRun() {
                        this.this$2.this$1.this$0.callAdClosed();
                    }
                }, c.j);
            }
        }

        public AnonymousClass2(HWSplashAdapter hWSplashAdapter) {
            this.this$0 = hWSplashAdapter;
        }

        public void onAdFailed(int i) {
            this.this$0.callLoadedError(i, "load err");
        }

        public void onAdLoaded() {
            try {
                try {
                    if (this.this$0.getSdkAdInfo() != null) {
                        this.this$0.getSdkAdInfo().setEcpm(String.valueOf((int) (this.this$0.splashAd.getBiddingInfo().getPrice().floatValue() * 100.0f)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HWSplashAdapter hWSplashAdapter = this.this$0;
                hWSplashAdapter.splashView = hWSplashAdapter.splashAd.getSplashView();
                this.this$0.splashView.setAdDisplayListener(new AnonymousClass1(this));
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        AdParam.Builder builder = new AdParam.Builder();
        try {
            builder.addBiddingParamMap(getSdkAdInfo().getPid(), new BiddingParam.Builder().setBidFloor(Float.valueOf(getSdkAdInfo().getPrice() / 100.0f)).setBidFloorCur("CNY").build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.setTMax(3000);
        SplashAd splashAd = new SplashAd(context);
        this.splashAd = splashAd;
        splashAd.setAdParam(getSdkAdInfo().getPid(), 1, builder.build());
        this.splashAd.setAudioFocusType(1);
        this.splashAd.setSplashListener(new SplashListener(this) { // from class: com.kc.dw.gather.huawei.splash.HWSplashAdapter.1
            public final HWSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onAdDismissed() {
                this.this$0.callAdClosed();
            }

            public void onAdError(int i) {
            }

            public void onAdShowStart() {
                this.this$0.callAdExposure();
            }
        });
        this.splashAd.loadAd(new AnonymousClass2(this));
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        BiddingInfo biddingInfo;
        try {
            SplashAd splashAd = this.splashAd;
            if (splashAd != null && (biddingInfo = splashAd.getBiddingInfo()) != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("SECOND_PRICE", Float.valueOf((s0.a((int) (biddingInfo.getPrice().floatValue() * 100.0f), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()) * 1.0f) / 100.0f));
                    map.put("AUCTION_CURRENCY", "CNY");
                    this.splashAd.sendBiddingSuccess(map, new ReportUrlListener(this) { // from class: com.kc.dw.gather.huawei.splash.HWSplashAdapter.3
                        public final HWSplashAdapter this$0;

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
                    this.splashAd.sendBiddingFailed(map2, new ReportUrlListener(this) { // from class: com.kc.dw.gather.huawei.splash.HWSplashAdapter.4
                        public final HWSplashAdapter this$0;

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

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        if (this.showed || this.splashView == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView((View) this.splashView, -1, -1);
        this.showed = true;
        viewGroup.bringToFront();
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            splashAd.showAd(false);
        }
    }
}
