package com.kc.dw.gather.gdt.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.s2s.ISBidding;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTSplashAdapter extends MsCustomSplashAdapter {
    private static final String TAG = "GDTSplashAdapter";
    private SsdAdSlot adSlot;
    private SplashAD splashAD;

    @Override // com.kc.dw.platform.BasePlatformLoader
    public HashMap<String, Object> getExtraMap() {
        return super.getExtraMap();
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        this.adSlot = ssdAdSlot;
        this.splashAD = new SplashAD(context, customInfo.getPid(), new SplashADListener(this) { // from class: com.kc.dw.gather.gdt.splash.GDTSplashAdapter.1
            public final GDTSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onADClicked() {
                this.this$0.callAdClicked();
            }

            public void onADDismissed() {
                this.this$0.callAdClosed();
            }

            public void onADExposure() {
                this.this$0.callAdExposure();
            }

            public void onADLoaded(long j) {
                LogUtil.d(GDTSplashAdapter.TAG, "GDT loaded success");
                try {
                    int ecpm = this.this$0.splashAD.getECPM();
                    if (ecpm > 0) {
                        this.this$0.setEcpm(ecpm);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            }

            public void onADPresent() {
            }

            public void onADTick(long j) {
                this.this$0.callAdTick(j);
            }

            public void onNoAD(AdError adError) {
                StringBuilder sbA = a.a("GDT  onNoAD,code=");
                sbA.append(adError.getErrorCode());
                sbA.append(",msg=");
                sbA.append(adError.getErrorMsg());
                LogUtil.d(GDTSplashAdapter.TAG, sbA.toString());
                this.this$0.callLoadedError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }, 3500);
        if (ssdAdSlot.isSplashFullScreen()) {
            this.splashAD.fetchFullScreenAdOnly();
        } else {
            this.splashAD.fetchAdOnly();
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.splashAD != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put(ISBidding.EXPECT_COST_PRICE, Integer.valueOf(this.splashAD.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(s0.a(this.splashAD.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.splashAD.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.splashAD.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        try {
            if (this.splashAD != null) {
                SsdAdSlot ssdAdSlot = this.adSlot;
                if (ssdAdSlot != null && ssdAdSlot.isSplashFullScreen()) {
                    this.splashAD.showFullScreenAd(viewGroup);
                } else {
                    this.splashAD.showAd(viewGroup);
                }
            }
        } catch (Exception e) {
            callRenderError(200002, "render err");
            e.printStackTrace();
        }
    }
}
