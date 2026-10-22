package com.kc.dw.gather.bd.intertitial;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BDIntertitialAdapter extends MsCustomInterstitialAdapter {
    private static final String TAG = "BDIntertitialAdapter";
    private ExpressInterstitialAd interstitialAd;

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(context, customInfo.getPid());
        this.interstitialAd = expressInterstitialAd;
        expressInterstitialAd.setLoadListener(new ExpressInterstitialListener(this) { // from class: com.kc.dw.gather.bd.intertitial.BDIntertitialAdapter.1
            public final BDIntertitialAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onADExposed() {
                LogUtil.d(BDIntertitialAdapter.TAG, "onADExposed: ");
                this.this$0.callAdExposure();
            }

            public void onADExposureFailed() {
                LogUtil.d(BDIntertitialAdapter.TAG, "onNoAd code=200002,msg=onADExposureFailed");
                this.this$0.callRenderError(200002, "onADExposureFailed");
            }

            public void onADLoaded() {
                LogUtil.d(BDIntertitialAdapter.TAG, "onADLoaded: ");
                try {
                    int i = Integer.parseInt(this.this$0.interstitialAd.getECPMLevel());
                    if (i > 0) {
                        this.this$0.setEcpm(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
            }

            public void onAdCacheFailed() {
            }

            public void onAdCacheSuccess() {
            }

            public void onAdClick() {
                LogUtil.d(BDIntertitialAdapter.TAG, "onAdClick: ");
                this.this$0.callAdClicked();
            }

            public void onAdClose() {
                LogUtil.d(BDIntertitialAdapter.TAG, "onAdClose: ");
                this.this$0.callAdClosed();
            }

            public void onAdFailed(int i, String str) {
                LogUtil.d(BDIntertitialAdapter.TAG, "onAdFailed: i=" + i + ",s=" + str);
                this.this$0.callLoadedError(i, str);
            }

            public void onLpClosed() {
            }

            public void onNoAd(int i, String str) {
                LogUtil.d(BDIntertitialAdapter.TAG, "onNoAd code=" + i + ",msg=" + str);
                this.this$0.callLoadedError(i, str);
            }

            public void onVideoDownloadFailed() {
            }

            public void onVideoDownloadSuccess() {
            }
        });
        this.interstitialAd.setDialogFrame(true);
        this.interstitialAd.load();
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        LogUtil.e(TAG, "isWin=" + z + ",price=" + i);
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.SplashAd");
            if (z) {
                Method declaredMethod = cls.getDeclaredMethod("biddingSuccess", String.class);
                ExpressInterstitialAd expressInterstitialAd = this.interstitialAd;
                declaredMethod.invoke(expressInterstitialAd, String.valueOf(s0.a(Integer.parseInt(expressInterstitialAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(this.interstitialAd, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("ecpm", Integer.valueOf(s0.a(Integer.parseInt(this.interstitialAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    this.interstitialAd.biddingSuccess(linkedHashMap, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.intertitial.BDIntertitialAdapter.2
                        public final BDIntertitialAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("ecpm", Integer.valueOf(i));
                    int iNextInt = new Random().nextInt(10);
                    if (iNextInt != 0) {
                        i2 = iNextInt;
                    }
                    linkedHashMap2.put("adn", Integer.valueOf(i2));
                    linkedHashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap2.put("bid_t", 3);
                    linkedHashMap2.put(MediationConstant.KEY_REASON, "203");
                    this.interstitialAd.biddingFail(linkedHashMap2, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.intertitial.BDIntertitialAdapter.3
                        public final BDIntertitialAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                }
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void showAd(Activity activity) {
        ExpressInterstitialAd expressInterstitialAd = this.interstitialAd;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.show(activity);
        }
    }
}
