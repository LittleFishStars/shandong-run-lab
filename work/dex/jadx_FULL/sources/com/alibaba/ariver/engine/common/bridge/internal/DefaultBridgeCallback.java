package com.alibaba.ariver.engine.common.bridge.internal;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultBridgeCallback implements BridgeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24063a = "AriverEngine:DefaultBridgeCallback";
    private boolean b;
    private BridgeResponseHelper c;

    public DefaultBridgeCallback(BridgeResponseHelper bridgeResponseHelper) {
        this(bridgeResponseHelper, false);
    }

    public BridgeResponseHelper getResponseHelper() {
        return this.c;
    }

    public boolean isSticky() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendBridgeResponse(BridgeResponse bridgeResponse) {
        if (bridgeResponse == null) {
            bridgeResponse = BridgeResponse.SUCCESS;
        }
        if (bridgeResponse instanceof BridgeResponse.Error) {
            BridgeResponse.Error error = (BridgeResponse.Error) bridgeResponse;
            this.c.sendError(error.getErrorCode(), error.getErrorMessage());
            return;
        }
        JSONObject jSONObject = bridgeResponse.get();
        if (this.b) {
            this.c.sendBridgeResultWithCallbackKept(jSONObject);
        } else {
            this.c.sendBridgeResult(jSONObject);
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendJSONResponse(JSONObject jSONObject, boolean z) {
        if (z) {
            this.c.sendBridgeResultWithCallbackKept(jSONObject);
        } else {
            this.c.sendBridgeResult(jSONObject);
        }
    }

    public DefaultBridgeCallback(BridgeResponseHelper bridgeResponseHelper, boolean z) {
        this.b = z;
        this.c = bridgeResponseHelper;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendJSONResponse(JSONObject jSONObject) {
        if (this.b) {
            this.c.sendBridgeResultWithCallbackKept(jSONObject);
        } else {
            this.c.sendBridgeResult(jSONObject);
        }
    }
}
