package cj.mobile.wm;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j1 {
    public static final j1 dexa = new j1();

    public class dexa implements k9 {
        public dexa() {
        }

        @Override // cj.mobile.wm.k9
        public void a(int i, String str) {
            f1.dexb("ReportManager", "reportParams onFailed ... errorCode : " + i + " , msg : " + str);
        }

        @Override // cj.mobile.wm.k9
        public void dexa(h9 h9Var) {
            f1.dexa("ReportManager", "reportParams onSuccess ...");
        }
    }

    public static j1 dexa() {
        return dexa;
    }

    private void dexa(String str, Map<String, Object> map, AdSlot adSlot, INativeAd iNativeAd) {
        k1 k1Var = new k1(str, iNativeAd);
        q9 q9Var = new q9();
        q9Var.dexa(adSlot);
        q9Var.dexa(map);
        InsightProxy.getInstance().getNetworkProxy().dexa(k1Var.dexa(q9Var), new dexa());
    }

    public void dexa(long j, AdSlot adSlot, INativeAd iNativeAd) {
        f1.dexa("ReportManager", "reportLoadTime ... loadTime = " + j);
        HashMap map = new HashMap();
        map.put(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(j));
        dexa("loadTime", map, adSlot, iNativeAd);
    }

    public void dexa(boolean z, String str, AdSlot adSlot, INativeAd iNativeAd) {
        f1.dexa("ReportManager", "reportLoadAdFailed ... isError = " + z + " , errorMsg = " + str);
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(z);
        map.put("isError", sb.toString());
        map.put("errorMsg", str);
        dexa("load_ad_failed", map, adSlot, iNativeAd);
    }

    public void dexb(long j, AdSlot adSlot, INativeAd iNativeAd) {
        f1.dexa("ReportManager", "reportRenderTime ... renderTime = " + j);
        HashMap map = new HashMap();
        map.put(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(j));
        dexa("renderTime", map, adSlot, iNativeAd);
    }
}
