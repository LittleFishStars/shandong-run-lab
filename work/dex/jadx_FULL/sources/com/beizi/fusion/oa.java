package com.beizi.fusion;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class oa implements fd {
    private boolean hasParseException = false;
    protected JSONObject mJsonObject;

    public oa(JSONObject jSONObject) {
        this.mJsonObject = jSONObject;
        parseFormJson(jSONObject);
    }

    public JSONObject asJsonObject() {
        return this.mJsonObject;
    }

    public boolean hasParseException() {
        return this.hasParseException;
    }

    public void parseFormJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                mg.a(this, jSONObject);
            } catch (JSONException unused) {
                this.hasParseException = true;
            }
        }
    }

    @Override // com.beizi.fusion.fd
    public String toJsonString() {
        JSONObject jSONObject = this.mJsonObject;
        return jSONObject != null ? jSONObject.toString() : "";
    }
}
