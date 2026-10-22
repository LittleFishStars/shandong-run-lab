package com.ltmb.gromoreadapter;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawLoadListener;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LTAdGroMoreDrawLoader extends MediationCustomNativeLoader {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$0(MediationCustomServiceConfig mediationCustomServiceConfig, final Context context) {
        LTAdSdk.getInstance().getLTAdDrawLoader(new LTAdSlot.Builder().setAdId(mediationCustomServiceConfig.getADNNetworkSlotId()).setRequestAdSize(1080, 1920).setAdCount(1).build(), new LTAdDrawLoadListener() { // from class: com.ltmb.gromoreadapter.LTAdGroMoreDrawLoader.1
            public void onAdLoadFailed(int i, String str) {
                LTAdGroMoreDrawLoader.this.callLoadFail(i, str);
            }

            public void onLoaded(LTDrawAd lTDrawAd) {
                ArrayList arrayList = new ArrayList();
                LTAdDrawGroMoreExpressAd lTAdDrawGroMoreExpressAd = new LTAdDrawGroMoreExpressAd(context, lTDrawAd);
                lTAdDrawGroMoreExpressAd.setBiddingPrice(lTDrawAd.getEcpm());
                arrayList.add(lTAdDrawGroMoreExpressAd);
                LTAdGroMoreDrawLoader.this.callLoadSuccess(arrayList);
            }
        });
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    public boolean isServerBidding() {
        return getBiddingType() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(final Context context, AdSlot adSlot, final MediationCustomServiceConfig mediationCustomServiceConfig) {
        getAdm();
        getExtraDataNoParse();
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.ju4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17500a.lambda$load$0(mediationCustomServiceConfig, context);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        Log.d("LTAdSdk-", "win=" + z + ", winnerPrice=" + d + ", loseReason=" + i);
    }
}
