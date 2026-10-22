package com.alibaba.ariver.jsapi.security;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.OfficialAppPoint;
import com.alibaba.ariver.permission.extension.auth.b;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBAuthorizeBridge implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24178a = RVConstants.PERMISSION_TAG + TBAuthorizeBridge.class.getSimpleName();

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void authorize(@BindingParam({"platform"}) String str, @BindingParam({"scopeNicks"}) String str2, @BindingParam({"appId"}) String str3, @BindingParam({"isvAppId"}) String str4, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        JSONArray jSONArray;
        String pluginId;
        if (!BundleUtils.getBoolean(page.getStartParams(), RVParams.isTinyApp, false)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.FORBIDDEN_ERROR);
            return;
        }
        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
        if (((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(page.getApp()).create()).isOfficial(apiContext.getPluginId()) || !com.alibaba.ariver.jsapi.mtop.a.a(page.getApp(), appModel, apiContext.getPluginId())) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            return;
        }
        HashMap map = new HashMap();
        map.put("callMethod", "authorize");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            jSONArray = JSON.parseArray(str2);
        } catch (Throwable unused) {
            jSONArray = new JSONArray();
            jSONArray.add(str2);
        }
        JSONArray jSONArray2 = jSONArray;
        if (TextUtils.isEmpty(apiContext.getPluginId())) {
            pluginId = str4;
        } else {
            RVLogger.d(f24178a, "getBusinessAuth get isvAppId from pluginId: " + apiContext.getPluginId());
            pluginId = apiContext.getPluginId();
        }
        new OpenAuthExtension().auth(str, jSONArray2, null, str3, pluginId, false, map, app, page, bridgeCallback, null);
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void getTBCode(@BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        final JSONObject jSONObject = new JSONObject();
        SendMtopParams sendMtopParams = new SendMtopParams(apiContext.getAppId(), app.getStartParams());
        sendMtopParams.api = "mtop.taobao.openlink.fusionapp.login.auth.code";
        sendMtopParams.v = "1.0";
        Map<String, String> mapA = com.alibaba.ariver.jsapi.mtop.a.a(app, appModel, apiContext);
        sendMtopParams.needAuth = !((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(app).create()).isOfficial(apiContext.getPluginId()) && com.alibaba.ariver.jsapi.mtop.a.a(app, appModel, apiContext.getPluginId());
        sendMtopParams.ignoreAuth = com.alibaba.ariver.jsapi.mtop.a.a(appModel, apiContext.getPluginId(), sendMtopParams.api);
        sendMtopParams.needLogin = true;
        sendMtopParams.setHeaders(mapA);
        ((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestAsync(app, sendMtopParams, new IMtopProxy.Callback() { // from class: com.alibaba.ariver.jsapi.security.TBAuthorizeBridge.1
            @Override // com.alibaba.ariver.app.api.mtop.IMtopProxy.Callback
            public void onResult(SendMtopResponse sendMtopResponse) {
                JSONObject jSONObject2;
                if (sendMtopResponse.success) {
                    try {
                        byte[] bArr = sendMtopResponse.data;
                        if (bArr != null && bArr.length > 0) {
                            String str = new String(bArr, Charset.forName("UTF-8"));
                            if (!TextUtils.isEmpty(str) && (jSONObject2 = JSON.parseObject(str).getJSONObject("data")) != null && !jSONObject2.isEmpty()) {
                                jSONObject2.put("success", (Object) Boolean.TRUE);
                                bridgeCallback.sendJSONResponse(jSONObject2);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        RVLogger.e("TRVLink", "requestRecentlyApp onSuccess parseObject error", e);
                    }
                }
                jSONObject.put("code", (Object) (-1));
                jSONObject.put("message", (Object) sendMtopResponse.errorMsg);
                jSONObject.put("success", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getTBSessionInfo(@BindingParam({"platform"}) String str, @BindingNode(App.class) App app) {
        String appKey = ((AppModel) app.getData(AppModel.class)).getAppInfoModel().getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            return BridgeResponse.INVALID_PARAM;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TB";
        }
        KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
        if (kVStorageProxy != null) {
            String string = kVStorageProxy.getString(app.getAppId(), b.a(app, appKey + "_skey_new_" + str));
            if (!TextUtils.isEmpty(string)) {
                String string2 = kVStorageProxy.getString(app.getAppId(), b.a(app, appKey + "token"));
                if (!TextUtils.isEmpty(string2)) {
                    JSONObject object = JSON.parseObject(string2);
                    String string3 = object.getString("accessToken");
                    long jLongValue = object.getLong("expirationTime").longValue();
                    if (!TextUtils.isEmpty(string3) && jLongValue > System.currentTimeMillis()) {
                        return new BridgeResponse(JSON.parseObject(string));
                    }
                }
                return BridgeResponse.SUCCESS;
            }
        }
        return BridgeResponse.NOT_FOUND;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void openSetting(@BindingParam({"platform"}) String str, @BindingParam({"withSubscriptions"}) boolean z, @BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (!((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(app).create()).isOfficial(apiContext.getPluginId()) && com.alibaba.ariver.jsapi.mtop.a.a(app, appModel, apiContext.getPluginId())) {
            app.pushPage("trvNative://authorize/settings", app.getStartParams(), app.getSceneParams());
        }
        new ProgramSettingExtension().getSetting(str, z, app, apiContext, bridgeCallback);
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setTBSessionInfo(@BindingParam({"sessionInfo"}) String str, @BindingParam({"platform"}) String str2, @BindingNode(App.class) App app) {
        String appKey = ((AppModel) app.getData(AppModel.class)).getAppInfoModel().getAppKey();
        if (TextUtils.isEmpty(appKey) || TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "TB";
        }
        KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
        if (kVStorageProxy == null) {
            return BridgeResponse.NOT_FOUND;
        }
        kVStorageProxy.putString(app.getAppId(), b.a(app, appKey + "_skey_new_" + str2), str);
        return new BridgeResponse.NamedValue("success", "true");
    }
}
