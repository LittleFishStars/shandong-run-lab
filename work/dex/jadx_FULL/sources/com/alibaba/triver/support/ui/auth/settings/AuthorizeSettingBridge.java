package com.alibaba.triver.support.ui.auth.settings;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthorizeSettingBridge implements BridgeExtension {
    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse needShowAuthSettingEntry(@BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext) {
        if (app == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        try {
            boolean z = c.a((AppModel) app.getData(AppModel.class), (DynamicPluginInfo) app.getData(DynamicPluginInfo.class), false).isEmpty() ? false : true;
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put("needShow", (Object) Boolean.TRUE);
            } else {
                jSONObject.put("needShow", (Object) Boolean.FALSE);
            }
            return new BridgeResponse(jSONObject);
        } catch (Exception unused) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
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
