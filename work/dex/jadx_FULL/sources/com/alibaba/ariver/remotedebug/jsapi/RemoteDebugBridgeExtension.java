package com.alibaba.ariver.remotedebug.jsapi;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.b.b;
import com.alibaba.ariver.remotedebug.b.c;
import com.alibaba.ariver.remotedebug.core.DebugMessageType;
import com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteDebugBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24388a = "AriverAPI:RemoteDebugBridgeExtension";
    private static final int b = 103;

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

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse tinyAppStandardLog(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject) {
        String strA = c.a(jSONObject);
        if (!TextUtils.isEmpty(strA)) {
            RVLogger.d(f24388a, "tinyAppStandardLog errMsg is empty.");
            return BridgeResponse.newError(103, strA);
        }
        AppContext appContext = app.getAppContext();
        if (appContext == null) {
            RVLogger.d(f24388a, "appContext is null.");
            return BridgeResponse.UNKNOWN_ERROR;
        }
        b.a(page, DebugMessageType.STANDARD_LOG, c.a((Activity) appContext.getContext(), page, jSONObject));
        return BridgeResponse.SUCCESS;
    }

    @ActionFilter
    public void tyroRequest(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page == null) {
            RVLogger.d(f24388a, "page is null");
            return;
        }
        String string = JSONUtils.getString(jSONObject, "url");
        if (TextUtils.isEmpty(string)) {
            RVLogger.d(f24388a, "tyroRequest url is empty.");
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (page.getApp() == null) {
            RVLogger.d(f24388a, "tyroRequest app is null.");
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        if (!((RVRemoteDebugProxy) RVProxy.get(RVRemoteDebugProxy.class)).tyroRequestHasPermission(page.getApp().getAppId(), string)) {
            RVLogger.d(f24388a, "tyroRequest url is forbidden url: " + string);
            bridgeCallback.sendBridgeResponse(BridgeResponse.FORBIDDEN_ERROR);
            return;
        }
        NativeCallContext nativeCallContextBuild = new NativeCallContext.Builder().node(page).name(com.alibaba.ariver.permission.b.m).params(jSONObject).id("tyroRequest_" + NativeCallContext.generateUniqueId()).render(page.getRender()).build();
        SendToNativeCallback sendToNativeCallback = new SendToNativeCallback() { // from class: com.alibaba.ariver.remotedebug.jsapi.RemoteDebugBridgeExtension.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject2, boolean z) {
                BridgeCallback bridgeCallback2 = bridgeCallback;
                if (bridgeCallback2 != null) {
                    bridgeCallback2.sendJSONResponse(jSONObject2, z);
                }
            }
        };
        RVLogger.d(f24388a, "tyroReqeust transport to httpRequest params:" + jSONObject);
        apiContext.callBridgeApi(nativeCallContextBuild, sendToNativeCallback, false);
    }
}
