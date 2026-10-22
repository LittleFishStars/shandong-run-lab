package com.alibaba.triver.basic.api;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import mtopsdk.mtop.global.SDKUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ServerTimeBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24682a = "ServerTimeBridge";

    @ActionFilter
    public void getServerTime(@BindingCallback BridgeCallback bridgeCallback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time", (Object) Long.valueOf(SDKUtils.getCorrectionTime() * 1000));
            bridgeCallback.sendJSONResponse(jSONObject);
        } catch (Exception e) {
            RVLogger.e(f24682a, "getServerTime :" + e);
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
