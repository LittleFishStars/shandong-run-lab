package com.alibaba.triver.basic.remotelog;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.trace.b;
import com.alibaba.triver.trace.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteLogBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24743a = "AriverAPI:RemoteLogBridgeExtension";

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
    public BridgeResponse remoteLog(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            String jSONString = "";
            if (jSONObject != null) {
                jSONString = jSONObject.toJSONString();
                jSONObject2.put("message", (Object) jSONString);
            }
            String str = jSONString;
            App app = page != null ? page.getApp() : null;
            if (jSONObject != null && app != null && CommonUtils.isApkDebug()) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("REMOTE_LOG", str, "REMOTE_LOG", app.getAppId(), null, null);
            }
            if (TextUtils.equals(jSONObject.getString("type"), "error") && TextUtils.equals(jSONObject.getString("seedId"), "H5_CUSTOM_ERROR")) {
                LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
                if (subMonitorData != null && !subMonitorData.containsKey("jsError")) {
                    subMonitorData.addPoint("jsError");
                }
                b.a(c.j, c.av, TRiverUtils.getSessionId(app), app, page, jSONObject2);
            } else {
                b.a(c.j, c.ax, TRiverUtils.getSessionId(app), app, page, jSONObject2);
            }
        } catch (Throwable th) {
            RVLogger.e(f24743a, th);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse traceLog(@BindingNode(Page.class) Page page, @BindingParam(stringDefault = "JS_LOG", value = {"stage"}) String str, @BindingParam({"message"}) String str2) {
        App app;
        if (page != null) {
            try {
                app = page.getApp();
            } catch (Throwable th) {
                RVLogger.e(f24743a, th);
            }
        } else {
            app = null;
        }
        App app2 = app;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message", (Object) str2);
        b.a(c.k, str, TRiverUtils.getSessionId(app2), app2, page, jSONObject);
        return BridgeResponse.SUCCESS;
    }
}
