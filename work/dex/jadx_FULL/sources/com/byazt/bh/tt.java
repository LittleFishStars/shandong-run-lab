package com.byazt.bh;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public enum tt {
    INSTANCE;

    public Map<String, ve> tt = new HashMap();

    tt() {
    }

    public ve c(String str) {
        return this.tt.get(str);
    }

    public void c(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                ve veVar = new ve(jSONObject2);
                this.tt.put(veVar.ve(), veVar);
            } catch (JSONException unused) {
            }
        }
    }
}
