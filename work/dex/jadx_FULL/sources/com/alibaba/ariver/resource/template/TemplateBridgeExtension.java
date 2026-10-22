package com.alibaba.ariver.resource.template;

import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class TemplateBridgeExtension implements BridgeExtension {
    private static final String TAG = "AriverAPI:TemplateBridgeExtension";

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getExtConfig(@BindingNode(App.class) App app) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null || appModel.getAppInfoModel() == null) {
            return new BridgeResponse.Error(20, "appModel is null");
        }
        TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
        if (templateConfig == null || !templateConfig.isTemplateValid()) {
            return new BridgeResponse.Error(20, "templateConfigModel is null");
        }
        if (!templateConfig.getExtModel().isExtEnable()) {
            RVLogger.d(TAG, "getExtConfig...extEnable false");
            return new BridgeResponse.Error(21, "templateConfig disabled");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", (Object) templateConfig.getExtModel().getExtObj());
        return new BridgeResponse(jSONObject);
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
