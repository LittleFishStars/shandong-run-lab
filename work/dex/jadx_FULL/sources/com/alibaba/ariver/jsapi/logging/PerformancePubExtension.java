package com.alibaba.ariver.jsapi.logging;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.monitor.RVPub;
import com.alibaba.ariver.kernel.common.RVProxy;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PerformancePubExtension implements RVPub {
    @Override // com.alibaba.ariver.app.api.monitor.RVPub
    public void addData2Performance(App app, String str, String str2, String str3) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).addData2Performance(app, str, str2, str3);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPub
    public void addDatas2Performance(App app, String str, String str2, Map<String, String> map) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).addDatas2Performance(app, str, str2, map);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPub
    public void addEvent2Performance(App app, String str, String str2, Map<String, String> map) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).addEvent2Performance(app, str, str2, map);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPub
    public void addStage2Performance(App app, String str, String str2) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(app, str, str2);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
