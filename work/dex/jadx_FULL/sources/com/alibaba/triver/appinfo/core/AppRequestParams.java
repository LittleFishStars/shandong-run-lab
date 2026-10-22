package com.alibaba.triver.appinfo.core;

import android.os.Bundle;
import android.util.Pair;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppRequestParams implements Serializable {
    public Map<String, String> extRequest;
    public Pair<String, String> mainRequest;
    public String mainRequestType;
    public String oriUrl;
    public JSONObject params;
    public Bundle startParams;
    public boolean notOnline = false;
    public boolean needCache = true;

    public JSONArray getRequests() {
        if (this.extRequest == null) {
            this.extRequest = new HashMap();
        }
        Pair<String, String> pair = this.mainRequest;
        if (pair != null) {
            this.extRequest.remove(pair.first);
        }
        JSONArray jSONArray = new JSONArray();
        if (this.mainRequest != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", this.mainRequest.first);
            Object obj = this.mainRequest.second;
            if (obj != null && !"*".equals(obj)) {
                jSONObject.put("version", this.mainRequest.second);
            }
            JSONObject jSONObject2 = this.params;
            if (jSONObject2 != null) {
                jSONObject.put("params", (Object) jSONObject2);
            }
            jSONArray.add(jSONObject);
        }
        Map<String, String> map = this.extRequest;
        if (map != null && !map.isEmpty()) {
            for (String str : this.extRequest.keySet()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("appId", (Object) str);
                String str2 = this.extRequest.get(str);
                if (!"*".equals(str2)) {
                    jSONObject3.put("version", (Object) str2);
                }
                jSONArray.add(jSONObject3);
            }
        }
        return jSONArray;
    }
}
