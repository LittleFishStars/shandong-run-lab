package com.alibaba.ariver.engine.api.bridge.extension;

import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface BridgeCallback {
    void sendBridgeResponse(BridgeResponse bridgeResponse);

    void sendJSONResponse(JSONObject jSONObject);

    void sendJSONResponse(JSONObject jSONObject, boolean z);
}
