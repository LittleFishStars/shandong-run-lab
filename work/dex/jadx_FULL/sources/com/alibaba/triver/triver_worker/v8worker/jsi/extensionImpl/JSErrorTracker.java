package com.alibaba.triver.triver_worker.v8worker.jsi.extensionImpl;

import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.v8worker.extension.V8WorkerJSErrorTracker;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JSErrorTracker implements V8WorkerJSErrorTracker {
    @Override // com.alibaba.ariver.v8worker.extension.V8WorkerJSErrorTracker
    public void trackJsError(String str, String str2, String str3, String str4, App app) {
        String pluginIdByJsContextName;
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("JS_ERROR", str4 + " , " + str);
        try {
            HashMap map = new HashMap();
            if (str3 == null) {
                pluginIdByJsContextName = TRVJSIWorkerErrorPoint.getPluginIdByJsContextName(str4);
                if (pluginIdByJsContextName == null) {
                    pluginIdByJsContextName = "";
                }
            } else {
                pluginIdByJsContextName = str3;
            }
            map.put("appId", str2);
            map.put("pluginId", pluginIdByJsContextName);
            if (TRiverUrlUtils.isShop(app)) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_JS_ERROR, str, str, map, null);
            }
            LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
            if (subMonitorData == null || subMonitorData.containsKey("jsError")) {
                return;
            }
            subMonitorData.addPoint("jsError");
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }
}
