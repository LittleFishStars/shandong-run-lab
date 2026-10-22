package com.kc.dw.gather.bd.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.exception.b;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BDSplashAdapter extends MsCustomSplashAdapter {
    private static final String TAG = "BDSplashAdapter";
    private SplashAd splashAd;

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("use_dialog_frame", "true");
        SplashAd splashAd = new SplashAd(context.getApplicationContext(), customInfo.getPid(), builder.build(), new SplashInteractionListener(this) { // from class: com.kc.dw.gather.bd.splash.BDSplashAdapter.1
            public final BDSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onADLoaded() {
                LogUtil.d(BDSplashAdapter.TAG, "BD onADLoaded");
                try {
                    int i = Integer.parseInt(this.this$0.splashAd.getECPMLevel());
                    if (i > 0) {
                        this.this$0.setEcpm(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            }

            public void onAdCacheFailed() {
            }

            public void onAdCacheSuccess() {
            }

            public void onAdClick() {
                this.this$0.callAdClicked();
            }

            public void onAdDismissed() {
                this.this$0.callAdClosed();
            }

            public void onAdExposed() {
                this.this$0.callAdExposure();
            }

            public void onAdFailed(String str) {
                LogUtil.d(BDSplashAdapter.TAG, "BD onAdFailed:" + str);
                this.this$0.callLoadedError(b.i.intValue(), str);
            }

            public void onAdPresent() {
            }

            public void onAdSkip() {
                this.this$0.callAdSkip();
            }

            public void onLpClosed() {
            }
        });
        this.splashAd = splashAd;
        splashAd.load();
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        LogUtil.e(TAG, "isWin=" + z + ",price=" + i);
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.SplashAd");
            if (z) {
                Method declaredMethod = cls.getDeclaredMethod("biddingSuccess", String.class);
                SplashAd splashAd = this.splashAd;
                declaredMethod.invoke(splashAd, String.valueOf(s0.a(Integer.parseInt(splashAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(this.splashAd, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("ecpm", Integer.valueOf(s0.a(Integer.parseInt(this.splashAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    this.splashAd.biddingSuccess(linkedHashMap, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.splash.BDSplashAdapter.2
                        public final BDSplashAdapter this$0;

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
                    this.splashAd.biddingFail(linkedHashMap2, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.splash.BDSplashAdapter.3
                        public final BDSplashAdapter this$0;

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

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            splashAd.show(viewGroup);
        }
    }
}
