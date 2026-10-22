package com.alibaba.triver.triver_worker.v8worker.jsi.extensionImpl;

import android.util.Log;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.v8worker.extension.V8ImportScriptErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.zj.adlib.c49;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRVJSIWorkerErrorPoint implements V8ImportScriptErrorPoint, V8SendMessageErrorPoint {
    public static String getPluginIdByJsContextName(String str) {
        if (str == null || !str.contains("Plugin")) {
            return null;
        }
        String[] strArrSplit = str.split(c49.f40900a);
        if (strArrSplit.length == 4) {
            return strArrSplit[3];
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.v8worker.extension.V8ImportScriptErrorPoint
    public void onLoadScriptError(Throwable th, String str, String str2, String str3) {
        try {
            HashMap map = new HashMap();
            if (str2 == null && (str2 = getPluginIdByJsContextName(str3)) == null) {
                str2 = "";
            }
            map.put("appId", str);
            map.put("pluginId", str2);
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("JS_ERROR", str3 + " , " + th);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_JS_ERROR, th.getMessage(), th.getMessage(), map, null);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog(ErrId.RV_TYPE_JS_ERROR, "ImportScript Error: " + th.getMessage(), "", str, null, map);
        } catch (Throwable th2) {
            RVLogger.w(Log.getStackTraceString(th2));
        }
    }

    @Override // com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint
    public void onSendMessageException(Throwable th, String str) {
        try {
            HashMap map = new HashMap();
            map.put("appId", str);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_JS_ERROR, th.getMessage(), th.getMessage(), map, null);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog(ErrId.RV_TYPE_JS_ERROR, "V8SendMessage Error: " + th.getMessage(), "", str, null, map);
        } catch (Throwable th2) {
            RVLogger.w(Log.getStackTraceString(th2));
        }
    }
}
