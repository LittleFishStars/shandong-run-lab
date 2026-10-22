package com.alibaba.ariver.jsapi;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppRunTimeInfoBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24102a = "ltr";
    private static final String b = "rtl";
    private static final String c = "AriverInt:AppRunTimeInfoBridge";

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getLayoutDirection(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page) {
        if (app.getAppContext().getContext() == null) {
            RVLogger.e(c, "getLayoutDirection getContext null");
            return BridgeResponse.INVALID_PARAM;
        }
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            RVLogger.e(c, "getLayoutDirection RVEnvironmentServiceImpl is null");
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("layoutDirection", (Object) (rVEnvironmentService.getAppLayoutDirection() == 1 ? b : f24102a));
        RVLogger.e(c, "getLayoutDirection  " + jSONObject.toJSONString());
        return new BridgeResponse(jSONObject);
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getLocaleInfo(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page) {
        if (app.getAppContext().getContext() == null) {
            RVLogger.e(c, "getLocaleInfo getContext null");
            return BridgeResponse.INVALID_PARAM;
        }
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            RVLogger.e(c, "getLocaleInfo RVEnvironmentServiceImpl is null");
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        JSONObject jSONObject = new JSONObject();
        String appRegion = rVEnvironmentService.getAppRegion();
        String appLanguage = rVEnvironmentService.getAppLanguage();
        String appCurrency = rVEnvironmentService.getAppCurrency();
        jSONObject.put("regionCode", (Object) appRegion);
        jSONObject.put("languageTag", (Object) appLanguage);
        jSONObject.put("currencyCode", (Object) appCurrency);
        RVLogger.e(c, "getLocaleInfo:" + jSONObject.toJSONString());
        return new BridgeResponse(jSONObject);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        RVLogger.d(c, "onFinalized");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVLogger.d(c, "onInitialized");
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
