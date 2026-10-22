package cj.mobile.wm;

import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.IAdLoader;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.template.rendering.reward.RewardExpressAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class jd {
    public void dexa() {
    }

    public void dexa(AdSlot adSlot, List<INativeAd> list, IAdLoader.OnTemplateAdLoadListener<RewardExpressAd> onTemplateAdLoadListener) {
        if (list == null || list.isEmpty()) {
            if (onTemplateAdLoadListener != null) {
                onTemplateAdLoadListener.onAdLoadErr(-1, "ad is empty!");
                return;
            }
            return;
        }
        INativeAd iNativeAd = list.get(0);
        Map extraInfo = iNativeAd.getExtraInfo();
        extraInfo.put("slot_id", adSlot.getSlotId());
        extraInfo.put("req_params", adSlot.getRequestParams());
        RewardExpressAd rewardExpressAd = new RewardExpressAd(adSlot, iNativeAd);
        ArrayList arrayList = new ArrayList();
        arrayList.add(rewardExpressAd);
        if (onTemplateAdLoadListener != null) {
            onTemplateAdLoadListener.onAdLoaded(arrayList);
        }
    }
}
