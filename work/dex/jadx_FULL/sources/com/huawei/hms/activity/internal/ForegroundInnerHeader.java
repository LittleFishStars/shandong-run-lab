package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ForegroundInnerHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37421a;
    private String b;
    private String c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f37421a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.b = JsonUtil.getStringValue(jSONObject, "action");
            this.c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e.getMessage());
        }
    }

    public String getAction() {
        return this.b;
    }

    public int getApkVersion() {
        return this.f37421a;
    }

    public String getResponseCallbackKey() {
        return this.c;
    }

    public void setAction(String str) {
        this.b = str;
    }

    public void setApkVersion(int i) {
        this.f37421a = i;
    }

    public void setResponseCallbackKey(String str) {
        this.c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f37421a);
            jSONObject.put("action", this.b);
            jSONObject.put("responseCallbackKey", this.c);
        } catch (JSONException e) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f37421a + ", action:" + this.b + ", responseCallbackKey:" + this.c;
    }
}
