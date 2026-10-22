package com.huawei.hms.hatool;

import com.kc.openset.constant.DeviceIdType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l extends t {
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    protected String f = "";
    private String g;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f37586a);
        jSONObject.put(DeviceIdType.OAID, this.g);
        jSONObject.put("uuid", this.f);
        jSONObject.put("upid", this.e);
        jSONObject.put(DeviceIdType.IMEI, this.b);
        jSONObject.put("sn", this.c);
        jSONObject.put("udid", this.d);
        return jSONObject;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.f = str;
    }
}
