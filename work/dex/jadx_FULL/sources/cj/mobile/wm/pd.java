package cj.mobile.wm;

import android.content.Context;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.view.InsightAdView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class pd extends od {
    public pd(Context context, InsightAdView insightAdView, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, insightAdView, adSlot, iNativeAd);
    }

    @Override // cj.mobile.wm.od
    public int a() {
        return R.layout.fanti_xadsdk_layout_reward_ver;
    }
}
