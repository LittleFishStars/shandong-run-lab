package com.alibaba.triver.basic.api;

import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OriginRouteUrlBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24681a = "ori_url";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ActionFilter
    public void originalRouteUrl(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        String string = "";
        if (app != null) {
            try {
                if (app.getStartParams() != null) {
                    string = app.getStartParams().getString("ori_url", "");
                }
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
        }
        jSONObject.put("url", (Object) string);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
