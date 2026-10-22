package com.alibaba.triver.open.preload;

import android.net.Uri;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.open.prefetch.PrefectchCallback;
import com.alibaba.triver.point.DataPreloadPoint;
import com.zj.adlib.u15;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DataPreloadExtension implements DataPreloadPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.triver.point.DataPreloadPoint
    public boolean onPreload(String str, long j, List<JSONObject> list) {
        if (str == null || list == null || list.size() <= 0) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("PREFETCH_ERROR", "config error", "DataPrefetch", null, null, null);
            return false;
        }
        try {
            final String appId = TRiverUtils.getAppId(Uri.parse(str));
            if (com.alibaba.triver.open.prefetch.b.a().a(str, list, new PrefectchCallback() { // from class: com.alibaba.triver.open.preload.DataPreloadExtension.1
                @Override // com.alibaba.triver.open.prefetch.PrefectchCallback
                public void onPreload(PrefectchCallback.PrefetchCallbackType prefetchCallbackType, Object obj) {
                    String str2;
                    String str3;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appId", (Object) appId);
                    if (prefetchCallbackType == PrefectchCallback.PrefetchCallbackType.TYPE_HIT) {
                        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "dataPrefetch", null, null, jSONObject.toString());
                        str2 = "PREFETCH_HIT";
                    } else {
                        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "dataPrefetch", "-100", "prefetch_miss", jSONObject.toString());
                        str2 = "PREFETCH_MISS";
                    }
                    String str4 = str2;
                    if (obj != null) {
                        str3 = prefetchCallbackType + u15.f19942b + JSON.toJSONString(obj);
                    } else {
                        str3 = prefetchCallbackType + "";
                    }
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(str4, str3, "DataPrefetch", appId, null, null);
                }
            }, new Object[0])) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("PREFETCH_START", "prefetch size " + list.size(), "DataPrefetch", appId, null, null);
            } else {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("PREFETCH_ERROR", "prefetch start error", "DataPrefetch", appId, null, null);
            }
            return true;
        } catch (Exception e) {
            RVLogger.e("Triver:Preload", "DataPreloadExtension onPreload error", e);
            return true;
        }
    }
}
