package com.alibaba.ariver.commonability.device.jsapi.navigator;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NavigatorBridgeExtension implements BridgeExtension {
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public BridgeResponse navigateToSetting(@BindingApiContext ApiContext apiContext, @BindingParam({"option"}) String str) {
        return new c(apiContext.getActivity()).a() ? BridgeResponse.SUCCESS : BridgeResponse.UNKNOWN_ERROR;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
