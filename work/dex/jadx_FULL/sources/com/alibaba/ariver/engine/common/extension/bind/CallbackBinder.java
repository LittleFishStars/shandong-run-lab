package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.common.bridge.internal.DefaultBridgeCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CallbackBinder implements Binder<BindingCallback, BridgeCallback> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BridgeResponseHelper f24067a;

    public CallbackBinder(BridgeResponseHelper bridgeResponseHelper) {
        this.f24067a = bridgeResponseHelper;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public BridgeCallback bind(Class<BridgeCallback> cls, BindingCallback bindingCallback) {
        return new DefaultBridgeCallback(this.f24067a, bindingCallback.isSticky());
    }
}
