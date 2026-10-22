package com.kc.dw.gather.gdt.banner;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.s2s.ISBidding;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.banner.MsCustomBannerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTBannerAdapter extends MsCustomBannerAdapter {
    private static final String TAG = "GDTBannerAdapter";
    private UnifiedBannerView gdtBannerView;

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void destory() {
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        StringBuilder sbA = a.a("load gdt custom ad,current thread=");
        sbA.append(Looper.myLooper() == Looper.getMainLooper());
        LogUtil.d(TAG, sbA.toString());
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, customInfo.getPid(), new UnifiedBannerADListener(this) { // from class: com.kc.dw.gather.gdt.banner.GDTBannerAdapter.1
            public final GDTBannerAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onADClicked() {
                this.this$0.callAdClicked();
            }

            public void onADClosed() {
                this.this$0.callAdClosed();
            }

            public void onADExposure() {
                this.this$0.callAdExposure();
            }

            public void onADLeftApplication() {
            }

            public void onADReceive() {
                LogUtil.d(GDTBannerAdapter.TAG, "onADReceive");
                try {
                    int ecpm = this.this$0.gdtBannerView.getECPM();
                    if (ecpm > 0) {
                        this.this$0.setEcpm(ecpm);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            }

            public void onNoAD(AdError adError) {
                try {
                    LogUtil.d(GDTBannerAdapter.TAG, "onNoAD code=" + adError.getErrorCode() + ",msg=" + adError.getErrorMsg());
                    this.this$0.callLoadedError(adError.getErrorCode(), adError.getErrorMsg());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.gdtBannerView = unifiedBannerView;
        unifiedBannerView.setRefresh(0);
        this.gdtBannerView.loadAD();
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.gdtBannerView != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put(ISBidding.EXPECT_COST_PRICE, Integer.valueOf(this.gdtBannerView.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(s0.a(this.gdtBannerView.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.gdtBannerView.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.gdtBannerView.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void showAd(ViewGroup viewGroup) {
        try {
            if (this.gdtBannerView != null) {
                viewGroup.removeAllViews();
                if (this.gdtBannerView.getParent() != null && (this.gdtBannerView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.gdtBannerView.getParent()).removeView(this.gdtBannerView);
                }
                viewGroup.addView(this.gdtBannerView);
            }
        } catch (Exception e) {
            callRenderError(200002, "gdt banner render err");
            e.printStackTrace();
        }
    }
}
