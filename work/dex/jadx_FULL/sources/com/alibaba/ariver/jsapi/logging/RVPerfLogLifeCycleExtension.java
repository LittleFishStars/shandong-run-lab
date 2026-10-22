package com.alibaba.ariver.jsapi.logging;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVPerfLogLifeCycleExtension implements AppExitPoint, PageExitPoint, PageInitPoint {
    @Override // com.alibaba.ariver.app.api.point.app.AppExitPoint
    public void onAppExit(App app) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).uploadPerfLog(app, app.getStartUrl(), RVPerformanceTrackerImpl.RV_PERFORMANCE_APP_STARTUP_TYPE);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
    public void onPageExit(Page page) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).addData2Performance(page.getApp(), page.getPageURI(), "apiCalledSum", "" + page.getIntValue(RVConstants.JSAPI_COUNT));
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).uploadPerfLog(page.getApp(), page.getPageURI(), RVPerformanceTrackerImpl.RV_PERFORMANCE_PAGE_TYPE);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageInitPoint
    public void onPageInit(String str, Bundle bundle, Bundle bundle2) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).init(RVPerformanceTrackerImpl.RV_PERFORMANCE_PAGE_TYPE, BundleUtils.getString(bundle, "appId"), Long.valueOf(BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN)), str);
    }
}
