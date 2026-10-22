package com.alibaba.triver.triver_worker.v8worker;

import android.util.Log;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.legacy.v8worker.extension.V8JSErrorPoint;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverV8JSErrorPoint implements V8JSErrorPoint {
    @Override // com.alibaba.ariver.legacy.v8worker.extension.V8JSErrorPoint
    public void onException(String str, String str2, String str3) {
        try {
            HashMap map = new HashMap();
            map.put("appId", str2);
            map.put("pluginId", str3);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_JS_ERROR, str, str, map, null);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog(ErrId.RV_TYPE_JS_ERROR, "JSError: " + str, "", str2, null, map);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
