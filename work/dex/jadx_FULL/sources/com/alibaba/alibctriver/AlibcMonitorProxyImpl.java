package com.alibaba.alibctriver;

import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.inside.impl.TriverAppMonitorProxyImpl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcMonitorProxyImpl extends TriverAppMonitorProxyImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23644a = "Alibc_";

    @Override // com.alibaba.triver.inside.impl.TriverAppMonitorProxyImpl, com.alibaba.ariver.mtop.monitor.TRVMonitor, com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void trackAlarm(boolean z, String str, String str2, String str3, String str4, String str5) {
        try {
            JSONObject object = JSON.parseObject(str5);
            object.put("aliTradesdk", (Object) "5.0.2.5");
            str5 = object.toJSONString();
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        super.trackAlarm(z, f23644a + str, str2, str3, str4, str5);
    }

    @Override // com.alibaba.triver.inside.impl.TriverAppMonitorProxyImpl, com.alibaba.ariver.mtop.monitor.TRVMonitor, com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void trackCounter(String str, String str2, int i, String str3) {
        super.trackCounter(f23644a + str, str2, i, str3);
    }

    @Override // com.alibaba.triver.inside.impl.TriverAppMonitorProxyImpl, com.alibaba.ariver.mtop.monitor.TRVMonitor, com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void trackStat(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            jSONObject.put("aliTradesdk", "5.0.2.5");
        }
        super.trackStat(f23644a + str, str2, jSONObject, jSONObject2);
    }
}
