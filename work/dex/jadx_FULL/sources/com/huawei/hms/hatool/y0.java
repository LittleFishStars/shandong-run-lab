package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class y0 extends t0 {
    String f;
    String g;
    private String h;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.h);
        jSONObject.put("_emui_ver", this.f37587a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f);
        jSONObject.put("_mnc", this.g);
        jSONObject.put("_package_name", this.b);
        jSONObject.put("_app_ver", this.c);
        jSONObject.put("_lib_ver", "2.2.0.314");
        jSONObject.put("_channel", this.d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.e);
        return jSONObject;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.g = str;
    }

    public void h(String str) {
        this.h = str;
    }
}
