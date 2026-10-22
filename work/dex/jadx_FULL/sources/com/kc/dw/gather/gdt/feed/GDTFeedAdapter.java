package com.kc.dw.gather.gdt.feed;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.s2s.ISBidding;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTFeedAdapter extends MsCustomRecyclerAdapter {
    private static final String TAG = "GDTFeedAdapter";
    private List<GDTFeedExpressAd> expressAds;
    private List<NativeExpressADView> expressList;
    private boolean isPreRender;
    private List<NativeUnifiedADData> nativeList;

    private void loadExpress(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        NativeExpressAD nativeExpressAD = new NativeExpressAD(context, new ADSize(ssdAdSlot.getWidth() > 0 ? (int) (ssdAdSlot.getWidth() / displayMetrics.density) : -1, ssdAdSlot.getHeight() > 0 ? (int) (ssdAdSlot.getHeight() / displayMetrics.density) : -2), customInfo.getPid(), new NativeExpressAD.NativeExpressADListener(this) { // from class: com.kc.dw.gather.gdt.feed.GDTFeedAdapter.2
            public final GDTFeedAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onADClicked(NativeExpressADView nativeExpressADView) {
                try {
                    if (this.this$0.expressAds == null || this.this$0.expressAds.isEmpty()) {
                        return;
                    }
                    for (int i = 0; i < this.this$0.expressAds.size(); i++) {
                        GDTFeedExpressAd gDTFeedExpressAd = (GDTFeedExpressAd) this.this$0.expressAds.get(i);
                        if (gDTFeedExpressAd.getExpressView().equals(nativeExpressADView)) {
                            gDTFeedExpressAd.callAdClicked();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onADClosed(NativeExpressADView nativeExpressADView) {
                if (nativeExpressADView != null) {
                    try {
                        if (nativeExpressADView.getParent() != null) {
                            ((ViewGroup) nativeExpressADView.getParent()).removeView(nativeExpressADView);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if (this.this$0.expressAds == null || this.this$0.expressAds.isEmpty()) {
                        return;
                    }
                    for (int i = 0; i < this.this$0.expressAds.size(); i++) {
                        GDTFeedExpressAd gDTFeedExpressAd = (GDTFeedExpressAd) this.this$0.expressAds.get(i);
                        if (gDTFeedExpressAd.getExpressView().equals(nativeExpressADView)) {
                            gDTFeedExpressAd.callAdClosed();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public void onADExposure(NativeExpressADView nativeExpressADView) {
                try {
                    if (this.this$0.expressAds == null || this.this$0.expressAds.isEmpty()) {
                        return;
                    }
                    for (int i = 0; i < this.this$0.expressAds.size(); i++) {
                        GDTFeedExpressAd gDTFeedExpressAd = (GDTFeedExpressAd) this.this$0.expressAds.get(i);
                        if (gDTFeedExpressAd.getExpressView().equals(nativeExpressADView)) {
                            gDTFeedExpressAd.callAdExposure();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            public void onADLoaded(List<NativeExpressADView> list) {
                this.this$0.expressList = list;
                if (list != null) {
                    try {
                        if (list.isEmpty()) {
                            return;
                        }
                        this.this$0.expressAds = new ArrayList();
                        for (int i = 0; i < list.size(); i++) {
                            this.this$0.expressAds.add(new GDTFeedExpressAd(list.get(i)));
                        }
                        GDTFeedAdapter gDTFeedAdapter = this.this$0;
                        gDTFeedAdapter.callLoadedSuccess(gDTFeedAdapter.expressAds);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onNoAD(AdError adError) {
                try {
                    Log.d(GDTFeedAdapter.TAG, "gdt onNoAD");
                    LogUtil.d(GDTFeedAdapter.TAG, "onNoAD code=" + adError.getErrorCode() + ",msg=" + adError.getErrorMsg());
                    this.this$0.callLoadedError(adError.getErrorCode(), adError.getErrorMsg());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                try {
                    if (this.this$0.expressAds == null || this.this$0.expressAds.isEmpty()) {
                        return;
                    }
                    for (int i = 0; i < this.this$0.expressAds.size(); i++) {
                        GDTFeedExpressAd gDTFeedExpressAd = (GDTFeedExpressAd) this.this$0.expressAds.get(i);
                        if (gDTFeedExpressAd.getExpressView().equals(nativeExpressADView)) {
                            gDTFeedExpressAd.callRenderError(200002, "gdt render error");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                try {
                    if (this.this$0.expressAds == null || this.this$0.expressAds.isEmpty()) {
                        return;
                    }
                    for (int i = 0; i < this.this$0.expressAds.size(); i++) {
                        GDTFeedExpressAd gDTFeedExpressAd = (GDTFeedExpressAd) this.this$0.expressAds.get(i);
                        if (gDTFeedExpressAd.getExpressView().equals(nativeExpressADView)) {
                            gDTFeedExpressAd.callRenderSuccess();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        nativeExpressAD.setVideoOption(new VideoOption.Builder().build());
        nativeExpressAD.loadAD(ssdAdSlot.getFetchCount());
    }

    private void loadNative(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        new NativeUnifiedAD(context, customInfo.getPid(), new NativeADUnifiedListener(this, context) { // from class: com.kc.dw.gather.gdt.feed.GDTFeedAdapter.1
            public final GDTFeedAdapter this$0;
            public final Context val$context;

            {
                this.this$0 = this;
                this.val$context = context;
            }

            public void onADLoaded(List<NativeUnifiedADData> list) {
                this.this$0.nativeList = list;
                if (list != null) {
                    try {
                        if (list.isEmpty()) {
                            return;
                        }
                        try {
                            int ecpm = list.get(0).getECPM();
                            if (ecpm > 0) {
                                this.this$0.setEcpm(ecpm);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < list.size(); i++) {
                            arrayList.add(new GDTFeedNativeAd(this.val$context, list.get(i)));
                        }
                        this.this$0.callLoadedSuccess(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void onNoAD(AdError adError) {
                try {
                    LogUtil.d(GDTFeedAdapter.TAG, "onNoAD code=" + adError.getErrorCode() + ",msg=" + adError.getErrorMsg());
                    this.this$0.callLoadedError(adError.getErrorCode(), adError.getErrorMsg());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).loadData(ssdAdSlot.getFetchCount());
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void destroy() {
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        if (!customInfo.isExpress()) {
            loadNative(context, ssdAdSlot, customInfo);
        } else {
            this.isPreRender = true;
            loadExpress(context, ssdAdSlot, customInfo);
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.isPreRender) {
                List<NativeExpressADView> list = this.expressList;
                if (list != null) {
                    for (NativeExpressADView nativeExpressADView : list) {
                        if (z) {
                            HashMap map = new HashMap();
                            map.put(ISBidding.EXPECT_COST_PRICE, Integer.valueOf(nativeExpressADView.getECPM()));
                            map.put("highestLossPrice", Integer.valueOf(i));
                            nativeExpressADView.sendWinNotification(map);
                        } else {
                            HashMap map2 = new HashMap();
                            map2.put("winPrice", Integer.valueOf(i));
                            map2.put("lossReason", 1);
                            map2.put("adnId", "2");
                            nativeExpressADView.sendLossNotification(map2);
                        }
                    }
                    return;
                }
                return;
            }
            List<NativeUnifiedADData> list2 = this.nativeList;
            if (list2 != null) {
                for (NativeUnifiedADData nativeUnifiedADData : list2) {
                    if (z) {
                        HashMap map3 = new HashMap();
                        map3.put(ISBidding.EXPECT_COST_PRICE, Integer.valueOf(nativeUnifiedADData.getECPM()));
                        map3.put("highestLossPrice", Integer.valueOf(s0.a(nativeUnifiedADData.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                        nativeUnifiedADData.sendWinNotification(map3);
                    } else {
                        HashMap map4 = new HashMap();
                        map4.put("winPrice", Integer.valueOf(i));
                        map4.put("lossReason", 1);
                        map4.put("adnId", "2");
                        nativeUnifiedADData.sendLossNotification(map4);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
