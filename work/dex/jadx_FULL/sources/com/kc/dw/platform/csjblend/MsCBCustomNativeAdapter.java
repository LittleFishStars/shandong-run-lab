package com.kc.dw.platform.csjblend;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.byazt.op.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.ad.recycler.RecyclerAdLoadListener;
import com.kc.dw.core.ad.recycler.RecyclerMixAdEventLoader;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBCustomNativeAdapter extends MediationCustomNativeLoader {
    private static final String TAG = "MsCBCustomNativeAdapter";
    private RecyclerAdData adData;
    private MsCBGMExpressAd hygmExpressAd;
    private MsCBGMNativeAd hygmNativeAd;

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        StringBuilder sbA = a.a("开始加载gromore自定义平台信息流，pid=");
        sbA.append(mediationCustomServiceConfig.getADNNetworkSlotId());
        LogUtil.d(TAG, sbA.toString());
        new RecyclerMixAdEventLoader(context, new SsdAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new RecyclerAdLoadListener(this, context) { // from class: com.kc.dw.platform.csjblend.MsCBCustomNativeAdapter.1
            public final MsCBCustomNativeAdapter this$0;
            public final Context val$context;

            {
                this.this$0 = this;
                this.val$context = context;
            }

            @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
            public void onLoadFail(AdError adError) {
                this.this$0.callLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
            public void onLoadedSuccess(List<RecyclerAdData> list) {
                c cVar;
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            this.this$0.adData = list.get(0);
                            if (this.this$0.adData == null) {
                                this.this$0.callLoadFail(-1, "加载失败");
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            boolean zIsNativeExpress = this.this$0.adData.isNativeExpress();
                            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            if (zIsNativeExpress) {
                                MsCBCustomNativeAdapter msCBCustomNativeAdapter = this.this$0;
                                msCBCustomNativeAdapter.hygmExpressAd = new MsCBGMExpressAd(this.val$context, msCBCustomNativeAdapter.adData);
                                try {
                                    this.this$0.hygmExpressAd.setExpressAd(true);
                                    if (this.this$0.isClientBidding()) {
                                        if (this.this$0.adData.getData() != null) {
                                            try {
                                                d = Double.parseDouble(this.this$0.adData.getData().getEcpm());
                                            } catch (NumberFormatException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        this.this$0.hygmExpressAd.setBiddingPrice(d);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                cVar = this.this$0.hygmExpressAd;
                            } else {
                                MsCBCustomNativeAdapter msCBCustomNativeAdapter2 = this.this$0;
                                msCBCustomNativeAdapter2.hygmNativeAd = new MsCBGMNativeAd(msCBCustomNativeAdapter2.adData);
                                if (this.this$0.isClientBidding()) {
                                    if (this.this$0.adData.getData() != null) {
                                        try {
                                            d = Double.parseDouble(this.this$0.adData.getData().getEcpm());
                                        } catch (NumberFormatException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    this.this$0.hygmNativeAd.setBiddingPrice(d);
                                }
                                cVar = this.this$0.hygmNativeAd;
                            }
                            arrayList.add(cVar);
                            this.this$0.callLoadSuccess(arrayList);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }).loadAd();
    }
}
