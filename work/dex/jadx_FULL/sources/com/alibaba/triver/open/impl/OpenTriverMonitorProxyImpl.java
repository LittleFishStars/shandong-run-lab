package com.alibaba.triver.open.impl;

import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.inside.impl.TriverMonitorProxyImpl;
import com.alibaba.triver.open.proxy.IMonitorProxy;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OpenTriverMonitorProxyImpl extends TriverMonitorProxyImpl {
    @Override // com.alibaba.triver.inside.impl.TriverMonitorProxyImpl, com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean customAdvance(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, Object> map2) {
        try {
            int i = Integer.parseInt(str);
            if (i == 19999 && !((IMonitorProxy) RVProxy.get(IMonitorProxy.class)).hitSampling(str2, str3, str4, str5)) {
                return false;
            }
            HashMap map3 = new HashMap();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    map3.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str2, i, str3, str4, str5, map3).build());
            return true;
        } catch (NumberFormatException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return false;
        }
    }
}
