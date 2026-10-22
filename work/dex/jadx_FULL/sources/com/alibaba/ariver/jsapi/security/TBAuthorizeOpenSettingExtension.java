package com.alibaba.ariver.jsapi.security;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.api.models.AppModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBAuthorizeOpenSettingExtension implements BridgeExtension {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void openSetting(@BindingParam({"platform"}) String str, @BindingParam({"withSubscriptions"}) boolean z, @BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        if (com.alibaba.ariver.jsapi.mtop.a.a(app, (AppModel) app.getData(AppModel.class), apiContext.getPluginId())) {
            app.pushPage("trvNative://authorize/settings", app.getStartParams(), app.getSceneParams());
        }
        new ProgramSettingExtension().getSetting("TB", z, app, apiContext, bridgeCallback);
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
