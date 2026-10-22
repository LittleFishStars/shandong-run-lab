package com.alibaba.ariver.jsapi.logging;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HandleLoggingActionBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24152a = RVLogger.makeLogTag("HandleLoggingActionBridgeExtension");
    private static final String b = "performance";
    private static final String c = "behavior";
    private static final String d = "error";
    private static final int e = 1000;
    private int f;

    private void a(Page page, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String str;
        String str2;
        String str3;
        String string = JSONUtils.getString(jSONObject, "type");
        String string2 = JSONUtils.getString(jSONObject, "subType");
        String string3 = JSONUtils.getString(jSONObject, "spmId");
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "commonData", new JSONObject());
        JSONObject jSONObject3 = JSONUtils.getJSONObject(jSONObject, "extData", new JSONObject());
        String string4 = JSONUtils.getString(jSONObject, "actionType");
        if ("reportEvent".equalsIgnoreCase(string4)) {
            JSONObject jSONObject4 = JSONUtils.getJSONObject(jSONObject, "params", new JSONObject());
            String string5 = JSONUtils.getString(jSONObject4, com.heytap.mcssdk.constant.b.k);
            String string6 = JSONUtils.getString(jSONObject4, "bizType");
            String string7 = JSONUtils.getString(jSONObject4, "spmId");
            str = b;
            if ("10073".equalsIgnoreCase(string5)) {
                str3 = str;
            } else if ("10201".equalsIgnoreCase(string5)) {
                str3 = "error";
            } else {
                jSONObject3.put("param", (Object) jSONObject);
                str3 = c;
            }
            jSONObject3 = JSONUtils.getJSONObject(jSONObject4, "extData", jSONObject3);
            String string8 = JSONUtils.getString(jSONObject3, "state");
            jSONObject3.put("bizType", (Object) string6);
            jSONObject3.put("spmId", (Object) string7);
            if (str3.equals(c)) {
                jSONObject3.put("param", (Object) jSONObject);
            }
            str2 = string8;
            string = str3;
            string3 = string7;
        } else {
            str = b;
            if (TextUtils.isEmpty(string4)) {
                str2 = string2;
            } else {
                jSONObject3.put("param", (Object) jSONObject);
                str2 = string2;
                string = c;
            }
        }
        Map<String, Object> mapJsonToMap = JSONUtils.jsonToMap(jSONObject2, new HashMap());
        Map<String, Object> mapJsonToMap2 = JSONUtils.jsonToMap(jSONObject3, new HashMap());
        if (!TextUtils.isEmpty(string3)) {
            mapJsonToMap.put("spmId", string3);
        }
        if (c.equals(string)) {
            a.a(page.getApp(), mapJsonToMap);
            a.a(page, mapJsonToMap);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).behavior(page, str2, mapJsonToMap, mapJsonToMap2, bridgeCallback);
            return;
        }
        if (!"error".equals(string)) {
            if (!str.equals(string)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "type invalid"));
                return;
            }
            a(page.getApp(), page.getPageURI(), str2, mapJsonToMap, mapJsonToMap2);
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                return;
            }
            return;
        }
        String string9 = JSONUtils.getString(jSONObject3, "errorCode");
        String string10 = JSONUtils.getString(jSONObject3, "msg");
        a.a(page.getApp(), mapJsonToMap);
        a.a(page, mapJsonToMap);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(page, str2, string9, string10, mapJsonToMap, mapJsonToMap2);
        if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void handleLoggingAction(@BindingRequest JSONObject jSONObject, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        String str = f24152a;
        RVLogger.d(str, "handleLoggingAction invoke params : " + jSONObject);
        if (jSONObject == null || jSONObject.isEmpty()) {
            RVLogger.w(str, "invalid params " + jSONObject);
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "params is null"));
            }
        }
        int i = this.f + 1;
        this.f = i;
        boolean z = i > 1000;
        RVLogger.d(str, "handleLoggingAction mLogCount: " + this.f);
        if (z) {
            RVLogger.d(str, "handleLoggingAction over limit, LogCount : " + this.f);
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                return;
            }
        }
        a(page, jSONObject, bridgeCallback);
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

    private void a(App app, String str, String str2, Map<String, Object> map, Map<String, Object> map2) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(app, str, str2, map, map2, -1L);
    }
}
