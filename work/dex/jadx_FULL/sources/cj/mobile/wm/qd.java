package cj.mobile.wm;

import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.IAdLoader;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.template.rendering.splash.SplashExpressAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class qd {
    public void dexa() {
    }

    public void dexa(AdSlot adSlot, List<INativeAd> list, IAdLoader.OnTemplateAdLoadListener<SplashExpressAd> onTemplateAdLoadListener) {
        if (list == null || list.isEmpty()) {
            if (onTemplateAdLoadListener != null) {
                onTemplateAdLoadListener.onAdLoadErr(-1, "ad is empty!");
            }
        } else {
            SplashExpressAd splashExpressAd = new SplashExpressAd(adSlot, list.get(0));
            ArrayList arrayList = new ArrayList();
            arrayList.add(splashExpressAd);
            if (onTemplateAdLoadListener != null) {
                onTemplateAdLoadListener.onAdLoaded(arrayList);
            }
        }
    }
}
