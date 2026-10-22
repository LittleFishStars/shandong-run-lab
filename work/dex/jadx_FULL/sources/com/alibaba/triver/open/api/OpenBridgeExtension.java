package com.alibaba.triver.open.api;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.app.e;
import com.alibaba.triver.app.g;
import com.alibaba.triver.open.proxy.IRouterProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OpenBridgeExtension implements BridgeExtension {
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

    @ThreadType(ExecutorType.IDLE)
    @ActionFilter
    @AutoCallback
    public BridgeResponse popToAppHome(@BindingNode(App.class) App app, @BindingParam({"extraData"}) JSONObject jSONObject, @BindingNode(Page.class) Page page) {
        ((IRouterProxy) RVProxy.get(IRouterProxy.class)).popToHome(app.getAppContext().getContext(), new g(page, new e(app)), jSONObject != null ? JSONUtils.toBundle(jSONObject) : null);
        return BridgeResponse.SUCCESS;
    }
}
