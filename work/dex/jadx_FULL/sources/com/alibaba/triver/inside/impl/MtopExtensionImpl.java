package com.alibaba.triver.inside.impl;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.mtop.SendMtopProxyImpl;
import com.alibaba.triver.basic.proxy.ILogNetworkPoint;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IPrefetchResultProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.prefetch.mtop.c;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MtopExtensionImpl extends SendMtopProxyImpl {
    public static final String MTOP_NEEDLOGIN_FORCE = "mtop_needLoginForce";

    private void a(App app, String str, String str2) {
        try {
            ((IPrefetchResultProxy) RVProxy.get(IPrefetchResultProxy.class)).addDynamicPrefetchResult(app, "Mtop cache Hit \napi = " + str + " , version = " + str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.alibaba.ariver.mtop.SendMtopProxyImpl
    public String getRequestCache(App app, String str, String str2, Map<String, String> map) {
        String strA = c.a(str, str2, map);
        if (strA != null) {
            if (RVProxy.get(ILogNetworkPoint.class) != null) {
                ((ILogNetworkPoint) RVProxy.get(ILogNetworkPoint.class)).onMtopCacheHit(str, app, true);
            }
            a(app, str, str2);
        } else if (RVProxy.get(ILogNetworkPoint.class) != null) {
            ((ILogNetworkPoint) RVProxy.get(ILogNetworkPoint.class)).onMtopCacheHit(str, app, false);
        }
        return strA;
    }

    @Override // com.alibaba.ariver.mtop.SendMtopProxyImpl
    public void putRequestCache(App app, String str, String str2, Map<String, String> map, byte[] bArr) {
        if (app == null || str == null || str2 == null || bArr == null || !TROrangeController.enableMtopCache(app)) {
            return;
        }
        long longConfigFromAppJSON = TRiverUtils.getLongConfigFromAppJSON("prefetchCacheTime", 60000L, app);
        try {
            String str3 = new String(bArr);
            BasicMtopRequestParam basicMtopRequestParam = new BasicMtopRequestParam(app.getAppId(), app.getStartParams(), map);
            basicMtopRequestParam.api = str;
            basicMtopRequestParam.version = str2;
            c.a(basicMtopRequestParam, str3, longConfigFromAppJSON);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
