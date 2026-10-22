package com.alibaba.triver.triver_worker.v8worker;

import android.util.Log;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.legacy.v8worker.extension.V8ImportScriptErrorPoint;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverV8ImportScriptErrorPoint implements V8ImportScriptErrorPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.legacy.v8worker.extension.V8ImportScriptErrorPoint
    public void onLoadScriptError(Throwable th, String str) {
        try {
            HashMap map = new HashMap();
            map.put("appId", str);
            map.put("pluginId", "");
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_JS_ERROR, th.getMessage(), th.getMessage(), map, null);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog(ErrId.RV_TYPE_JS_ERROR, "ImportScript Error: " + th.getMessage(), "", str, null, map);
        } catch (Throwable th2) {
            RVLogger.w(Log.getStackTraceString(th2));
        }
    }
}
