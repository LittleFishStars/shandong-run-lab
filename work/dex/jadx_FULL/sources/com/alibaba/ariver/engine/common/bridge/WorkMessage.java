package com.alibaba.ariver.engine.common.bridge;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WorkMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24061a;
    private String b;
    private JSONObject c;
    private String d;
    private JSONObject e;

    public WorkMessage(String str) {
        JSONObject object = JSONUtils.parseObject(str);
        this.e = object;
        if (object != null) {
            this.d = object.getString("handlerName");
            this.f24061a = this.e.getString("clientId");
            JSONObject jSONObject = JSONUtils.getJSONObject(this.e, "data", null);
            this.c = jSONObject;
            if (jSONObject == null) {
                this.b = jSONObject.getString("viewId");
            }
        }
    }

    public String getClientID() {
        return this.f24061a;
    }

    public JSONObject getData() {
        return null;
    }

    public String getHandlerName() {
        return this.d;
    }

    public JSONObject getRaw() {
        return this.e;
    }

    public String getRenderId() {
        return this.b;
    }
}
