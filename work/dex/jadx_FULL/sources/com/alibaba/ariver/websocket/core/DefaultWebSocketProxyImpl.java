package com.alibaba.ariver.websocket.core;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.websocket.proxy.RVWebSocketProxy;
import java.net.URI;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultWebSocketProxyImpl implements RVWebSocketProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24533a = "AriverWebSocket:DefaultWebSocketProxyImpl";

    @Override // com.alibaba.ariver.websocket.proxy.RVWebSocketProxy
    public d createWebSocketClient(String str, String str2, Map<String, String> map, c cVar) {
        URI uriCreate;
        try {
            uriCreate = URI.create(str2);
        } catch (Exception e) {
            RVLogger.e(f24533a, "URI create error! url: " + str2, e);
            uriCreate = null;
        }
        if (uriCreate == null) {
            return null;
        }
        return new b(str, uriCreate, map, cVar);
    }
}
