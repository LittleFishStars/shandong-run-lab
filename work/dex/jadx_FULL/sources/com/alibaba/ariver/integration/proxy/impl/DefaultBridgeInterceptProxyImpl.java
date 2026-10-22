package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy;
import com.alibaba.ariver.kernel.api.node.Node;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultBridgeInterceptProxyImpl implements RVBridgeInterceptProxy {
    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy
    public boolean postInvoke(Node node, NativeCallContext nativeCallContext, ApiContext apiContext, BridgeResponseHelper bridgeResponseHelper) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy
    public boolean preInvoke(Node node, NativeCallContext nativeCallContext, ApiContext apiContext, BridgeResponseHelper bridgeResponseHelper) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy
    public boolean shouldInterceptPreInvoke(String str) {
        return false;
    }
}
