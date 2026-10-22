package com.alibaba.ariver.engine.api.proxy;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.integration.proxy.impl.DefaultBridgeInterceptProxyImpl")
public interface RVBridgeInterceptProxy extends Proxiable {
    boolean postInvoke(Node node, NativeCallContext nativeCallContext, ApiContext apiContext, BridgeResponseHelper bridgeResponseHelper);

    boolean preInvoke(Node node, NativeCallContext nativeCallContext, ApiContext apiContext, BridgeResponseHelper bridgeResponseHelper);

    boolean shouldInterceptPreInvoke(String str);
}
