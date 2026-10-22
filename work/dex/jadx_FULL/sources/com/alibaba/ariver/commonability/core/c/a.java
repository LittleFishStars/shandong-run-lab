package com.alibaba.ariver.commonability.core.c;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements BridgeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BridgeCallback f23941a;
    private String b;
    private JSONObject c;
    private String d;
    private String e;

    public a(BridgeCallback bridgeCallback, JSONObject jSONObject, String str, String str2, String str3) {
        this.f23941a = bridgeCallback;
        this.c = jSONObject;
        this.b = str;
        this.d = str2;
        this.e = str3;
    }

    private void a(JSONObject jSONObject) {
        com.alibaba.ariver.commonability.core.util.c.a aVarA = com.alibaba.ariver.commonability.core.util.c.a(this.e);
        if (!TextUtils.isEmpty(this.d)) {
            aVarA.a(this.d);
        }
        if (!TextUtils.isEmpty(this.b)) {
            aVarA.a("js_api", this.b);
        }
        JSONObject jSONObject2 = this.c;
        if (jSONObject2 != null) {
            aVarA.a(com.alipay.sdk.m.n.c.i, jSONObject2.toJSONString());
        }
        if (jSONObject != null) {
            aVarA.a("response_param", jSONObject.toJSONString());
        }
        aVarA.a();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendBridgeResponse(BridgeResponse bridgeResponse) {
        this.f23941a.sendBridgeResponse(bridgeResponse);
        a(bridgeResponse.get());
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendJSONResponse(JSONObject jSONObject, boolean z) {
        this.f23941a.sendJSONResponse(jSONObject, z);
        a(jSONObject);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendJSONResponse(JSONObject jSONObject) {
        this.f23941a.sendJSONResponse(jSONObject);
        a(jSONObject);
    }
}
