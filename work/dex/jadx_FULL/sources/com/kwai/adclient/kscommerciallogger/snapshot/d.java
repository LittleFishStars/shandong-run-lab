package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class d {
    private final String bvj;
    private final LinkedHashMap<String, String> bvk = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    public d(String str) {
        this.bvj = str;
    }

    public synchronized JSONObject Yr() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.bvk.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("time", this.time);
            jSONObject.put("span_name", this.bvj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
