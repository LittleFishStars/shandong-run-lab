package com.alibaba.ariver.engine.api.bridge.model;

import com.alibaba.ariver.engine.api.Render;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RenderCallContext {
    public static final String TYPE_CALL = "call";
    public static final String TYPE_CALLBACK = "callback";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24051a;
    private String b;
    private JSONObject c;
    private String d;
    private Render e;
    private boolean f;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24052a = "native_" + System.currentTimeMillis();
        private String b;
        private JSONObject c;
        private String d;
        private Render e;
        private boolean f;

        public Builder(Render render) {
            this.e = render;
        }

        public Builder action(String str) {
            this.b = str;
            return this;
        }

        public RenderCallContext build() {
            return new RenderCallContext(this);
        }

        public Builder eventId(String str) {
            this.f24052a = str;
            return this;
        }

        public Builder keep(boolean z) {
            this.f = z;
            return this;
        }

        public Builder param(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public Builder type(String str) {
            this.d = str;
            return this;
        }
    }

    public RenderCallContext(Builder builder) {
        this.f24051a = builder.f24052a;
        this.b = builder.b;
        JSONObject jSONObject = builder.c;
        this.c = jSONObject;
        if (jSONObject == null) {
            this.c = new JSONObject();
        }
        this.d = builder.d;
        this.f = builder.f;
        this.e = builder.e;
    }

    public static Builder newBuilder(Render render) {
        return new Builder(render);
    }

    public String getAction() {
        return this.b;
    }

    public String getEventId() {
        return this.f24051a;
    }

    public boolean getKeep() {
        return this.f;
    }

    public JSONObject getParam() {
        return this.c;
    }

    public Render getTarget() {
        return this.e;
    }

    public String getType() {
        return this.d;
    }

    public void setAction(String str) {
        this.b = str;
    }

    public void setEventId(String str) {
        this.f24051a = str;
    }

    public void setKeep(boolean z) {
        this.f = z;
    }

    public void setParam(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void setType(String str) {
        this.d = str;
    }
}
