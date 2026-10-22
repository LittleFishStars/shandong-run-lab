package com.kc.dw.gather.gdt.intertitial;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.ad.lifecycle.c;
import com.kc.dw.ad.lifecycle.d;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.s2s.ISBidding;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTIntertitialAdapter extends MsCustomInterstitialAdapter {
    private static final String TAG = "GDTIntertitialAdapter";
    private boolean enableInterstitialAutoClose;
    private boolean isClick;
    private c lifecycleHelper;
    private d lifecycleListener = new d(this) { // from class: com.kc.dw.gather.gdt.intertitial.GDTIntertitialAdapter.2
        public final GDTIntertitialAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.ad.lifecycle.d
        public void onDestroy() {
            LogUtil.e(GDTIntertitialAdapter.TAG, "onDestroy");
        }

        @Override // com.kc.dw.ad.lifecycle.d
        public void onPause() {
            LogUtil.e(GDTIntertitialAdapter.TAG, "onPause");
            if (this.this$0.unifiedInterstitialAD == null || this.this$0.isClick) {
                return;
            }
            this.this$0.unifiedInterstitialAD.close();
        }

        @Override // com.kc.dw.ad.lifecycle.d
        public void onResume() {
        }

        @Override // com.kc.dw.ad.lifecycle.d
        public void onStart() {
        }

        @Override // com.kc.dw.ad.lifecycle.d
        public void onStop() {
            LogUtil.e(GDTIntertitialAdapter.TAG, "onStop");
        }
    };
    private UnifiedInterstitialAD unifiedInterstitialAD;

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        if (ssdAdSlot != null) {
            this.enableInterstitialAutoClose = ssdAdSlot.isEnableInterstitialAutoClose();
        }
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, customInfo.getPid(), new UnifiedInterstitialADListener(this) { // from class: com.kc.dw.gather.gdt.intertitial.GDTIntertitialAdapter.1
            public final GDTIntertitialAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onADClicked() {
                LogUtil.d(GDTIntertitialAdapter.TAG, "onADClicked");
                this.this$0.isClick = true;
                this.this$0.callAdClicked();
            }

            public void onADClosed() {
                LogUtil.d(GDTIntertitialAdapter.TAG, "onADClosed");
                this.this$0.callAdClosed();
            }

            public void onADExposure() {
                LogUtil.d(GDTIntertitialAdapter.TAG, "onADExposure");
                this.this$0.callAdExposure();
            }

            public void onADLeftApplication() {
            }

            public void onADOpened() {
            }

            public void onADReceive() {
                LogUtil.e(GDTIntertitialAdapter.TAG, "onADReceive: ");
                try {
                    int ecpm = this.this$0.unifiedInterstitialAD.getECPM();
                    if (ecpm > 0) {
                        this.this$0.setEcpm(ecpm);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
            }

            public void onNoAD(AdError adError) {
                try {
                    LogUtil.d(GDTIntertitialAdapter.TAG, "onNoAD code =" + adError.getErrorCode() + ",msg=" + adError.getErrorMsg());
                    this.this$0.callLoadedError(adError.getErrorCode(), adError.getErrorMsg());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onRenderFail() {
                LogUtil.d(GDTIntertitialAdapter.TAG, "onRenderFail");
                this.this$0.callRenderError(200002, "onRenderFail");
            }

            public void onRenderSuccess() {
                LogUtil.d(GDTIntertitialAdapter.TAG, "onRenderSuccess");
                this.this$0.callRenderSuccess();
            }

            public void onVideoCached() {
            }
        });
        this.unifiedInterstitialAD = unifiedInterstitialAD;
        unifiedInterstitialAD.loadAD();
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.unifiedInterstitialAD != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put(ISBidding.EXPECT_COST_PRICE, Integer.valueOf(this.unifiedInterstitialAD.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(s0.a(this.unifiedInterstitialAD.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.unifiedInterstitialAD.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.unifiedInterstitialAD.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void showAd(Activity activity) {
        if (this.unifiedInterstitialAD != null) {
            try {
                if (this.enableInterstitialAutoClose) {
                    if (this.lifecycleHelper == null) {
                        this.lifecycleHelper = new c();
                    }
                    if (activity != null) {
                        c cVar = this.lifecycleHelper;
                        cVar.b = activity;
                        cVar.a(this.lifecycleListener);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.unifiedInterstitialAD.show(activity);
        }
    }
}
