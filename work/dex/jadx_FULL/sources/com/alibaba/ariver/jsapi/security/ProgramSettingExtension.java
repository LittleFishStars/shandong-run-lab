package com.alibaba.ariver.jsapi.security;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.common.service.rpc.api.MobilegwInvokeService;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.PermissionSettingPoint;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.openauth.model.request.JsApiInvokeRequestModel;
import com.alibaba.ariver.permission.openauth.model.result.JsApiInvokeResultModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProgramSettingExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24176a = "ProgramSettingExtension";
    private static final String b = "tinySource";
    private static final String c = "miniservice";

    private boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return c.equals(BundleUtils.getString(bundle, b));
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getSetting(@BindingParam({"platform"}) String str, @BindingParam({"withSubscriptions"}) final boolean z, @BindingNode(App.class) final App app, @BindingApiContext final ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (TextUtils.isEmpty(str)) {
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (rVEnvironmentService == null) {
                str = "AP";
            } else if (appModel != null && appModel.getAppInfoModel() != null) {
                str = rVEnvironmentService.convertPlatform(appModel.getAppInfoModel().getOrigin());
            }
            if (TextUtils.isEmpty(str)) {
                str = rVEnvironmentService.defaultPlatform();
            }
        }
        final String str2 = str;
        final String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(app);
        RVLogger.d(f24176a, "[getSetting] enter.");
        if (TextUtils.isEmpty(userId) && !"TB".equals(rVEnvironmentService.defaultPlatform())) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            RVLogger.d(f24176a, "[getSetting] userId is null");
            return;
        }
        final String string = a(app.getStartParams()) ? BundleUtils.getString(app.getStartParams(), RVConstants.EXTRA_PARENT_APP_ID) : BundleUtils.getString(app.getStartParams(), "appId");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            RVLogger.d(f24176a, "[getSetting] userId is null");
            return;
        }
        RVLogger.d(f24176a, "[getSetting] userId = " + userId + ", appId = " + string);
        ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alibaba.ariver.jsapi.security.ProgramSettingExtension.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject object;
                JSONObject jSONObject;
                JSONArray jSONArray;
                AuthenticationProxy authenticationProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
                if (authenticationProxy == null) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    RVLogger.d(ProgramSettingExtension.f24176a, "getSetting,service is null");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                HashMap map = new HashMap();
                try {
                    JsApiInvokeRequestModel jsApiInvokeRequestModel = new JsApiInvokeRequestModel();
                    jsApiInvokeRequestModel.setAppId(string);
                    jsApiInvokeRequestModel.setMethod("getAuthSetting");
                    if ("TB".equals(str2)) {
                        JSONObject setting = z ? ((PermissionSettingPoint) ExtensionPoint.as(PermissionSettingPoint.class).node(app).create()).getSetting(apiContext.getPluginId()) : null;
                        if (setting != null) {
                            jSONObject2 = setting;
                        } else {
                            jSONObject2.put("authSetting", (Object) JSON.parseObject(JSON.toJSONString(a.a(app, jsApiInvokeRequestModel, apiContext.getPluginId()))));
                        }
                    } else {
                        Map<String, Boolean> allPermissions = authenticationProxy.getAllPermissions(userId, string, (AppModel) null, (App) null, app.getActivePage());
                        if (allPermissions != null && !allPermissions.isEmpty()) {
                            for (Map.Entry<String, Boolean> entry : allPermissions.entrySet()) {
                                String key = entry.getKey();
                                Boolean value = entry.getValue();
                                if (key.startsWith("scope.")) {
                                    key = key.substring(6);
                                }
                                map.put(key, value);
                            }
                        }
                        JsApiInvokeResultModel jsApiInvokeResultModelJsApiInvoke = ((MobilegwInvokeService) RVProxy.get(MobilegwInvokeService.class)).jsApiInvoke(jsApiInvokeRequestModel);
                        if (jsApiInvokeResultModelJsApiInvoke != null && !TextUtils.isEmpty(jsApiInvokeResultModelJsApiInvoke.getResponse()) && (object = JSON.parseObject(jsApiInvokeResultModelJsApiInvoke.getResponse())) != null && (jSONObject = object.getJSONObject(ConnectionLog.CONN_LOG_STATE_RESPONSE)) != null && (jSONArray = jSONObject.getJSONArray("validScopeNicks")) != null) {
                            int size = jSONArray.size();
                            for (int i = 0; i < size; i++) {
                                map.put(jSONArray.getString(i), Boolean.TRUE);
                            }
                        }
                        jSONObject2.put("authSetting", (Object) JSON.parseObject(JSON.toJSONString(map)));
                    }
                } catch (Throwable th) {
                    RVLogger.e(ProgramSettingExtension.f24176a, "[handleEvent] openSetting Exception: " + th.toString(), th);
                }
                RVLogger.d(ProgramSettingExtension.f24176a, "[getSetting] result= " + jSONObject2.toString());
                bridgeCallback.sendJSONResponse(jSONObject2);
            }
        });
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
