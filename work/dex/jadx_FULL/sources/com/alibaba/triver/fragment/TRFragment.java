package com.alibaba.triver.fragment;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRFragment extends RVFragment {
    private Long fragmentLastOnPause;

    @Override // com.alibaba.ariver.app.api.ui.fragment.RVFragment, androidx.fragment.app.Fragment
    public void onPause() {
        App app;
        LaunchMonitorData subMonitorData;
        super.onPause();
        Page page = getPage();
        if (page == null || (app = page.getApp()) == null || TROrangeController.enableCustomUT(app)) {
            return;
        }
        if (isVisible()) {
            this.fragmentLastOnPause = Long.valueOf(System.currentTimeMillis());
        }
        try {
            if (!TRiverUrlUtils.isShop(page.getApp())) {
                HashMap map = new HashMap();
                map.put("miniAppBucketId", String.valueOf(TROrangeController.bucketId));
                map.put("isMiniApp", "true");
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updatePageProperties(getActivity(), map);
            }
            if (!TRiverUrlUtils.isShop(page.getApp())) {
                HashMap map2 = new HashMap();
                map2.put("miniAppBucketId", String.valueOf(TROrangeController.bucketId));
                map2.put("fromMiniApp", "true");
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updateNextPageProperties(getActivity(), map2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TRiverUrlUtils.isShop(app) && (subMonitorData = LaunchMonitorUtils.getSubMonitorData(page)) != null && !subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED)) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(getActivity(), TextUtils.equals("allitems", TRiverUrlUtils.getShopTabKey(app)) ? "Page_Shop_All_Item" : "Page_Shop");
        }
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(getActivity());
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.RVFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long l = this.fragmentLastOnPause;
            Long lValueOf = Long.valueOf(l == null ? 0L : l.longValue());
            this.fragmentLastOnPause = lValueOf;
            if (jCurrentTimeMillis - lValueOf.longValue() > 500) {
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).pageAppear(getActivity());
            }
        }
    }
}
