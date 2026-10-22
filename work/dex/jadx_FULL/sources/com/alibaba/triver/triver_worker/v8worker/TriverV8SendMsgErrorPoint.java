package com.alibaba.triver.triver_worker.v8worker;

import android.util.Log;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.legacy.v8worker.extension.V8SendMessageErrorPoint;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverV8SendMsgErrorPoint implements V8SendMessageErrorPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.legacy.v8worker.extension.V8SendMessageErrorPoint
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
