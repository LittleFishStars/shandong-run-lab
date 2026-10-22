package com.alibaba.ariver.jsapi.rpc;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TinyAppxRpcBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24168a = RVLogger.makeLogTag(TinyAppxRpcBridgeExtension.class.getName());
    private static final String b = "tinySource";
    private static final String c = "miniservice";
    private static final String d = "headers";
    private static final String e = "TINY_APP_ID";
    private static final String f = "TINY_APP_PARENT_ID";

    private boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return c.equals(BundleUtils.getString(bundle, b));
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void appxrpc(@BindingParam({"operationType"}) String str, @BindingParam({d}) JSONObject jSONObject, @BindingRequest JSONObject jSONObject2, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback final BridgeCallback bridgeCallback, @BindingApiContext ApiContext apiContext) {
        String string;
        if (page == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(3, "page is null"));
            RVLogger.d(f24168a, "page is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "operationType is null"));
            RVLogger.d(f24168a, "operationType is null");
            return;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_appx_rpc_whitelist_cfg");
        if (configJSONArray != null && !configJSONArray.contains(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "operationType is wrong"));
            RVLogger.d(f24168a, "operationType is wrong");
            return;
        }
        if (a(page.getStartParams())) {
            string = BundleUtils.getString(page.getStartParams(), RVConstants.EXTRA_PARENT_APP_ID);
        } else {
            string = BundleUtils.getString(page.getStartParams(), "MINI-PROGRAM-WEB-VIEW-TAG");
            if (TextUtils.isEmpty(string)) {
                string = BundleUtils.getString(page.getStartParams(), "appId");
            } else {
                String string2 = BundleUtils.getString(page.getStartParams(), "appId");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
            }
        }
        String string3 = BundleUtils.getString(page.getStartParams(), RVConstants.EXTRA_PARENT_APP_ID);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put(e, (Object) string);
        if (!TextUtils.isEmpty(string3)) {
            jSONObject.put(f, (Object) string3);
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        jSONObject2.put(d, (Object) jSONObject);
        jSONObject2.put("operationType", (Object) str);
        apiContext.callBridgeApi(new NativeCallContext.Builder().node(page).name("rpc").params(jSONObject2).render(page.getRender()).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.jsapi.rpc.TinyAppxRpcBridgeExtension.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject3, boolean z) {
                bridgeCallback.sendJSONResponse(jSONObject3);
            }
        }, false);
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
