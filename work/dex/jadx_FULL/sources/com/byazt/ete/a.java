package com.byazt.ete;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.triver.basic.api.RequestPermission;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 34})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28480a;
    public String c;
    public String da;
    public JSONArray i;
    public String n;
    public String sl;
    public String sp;
    public float t;
    public String tt;
    public JSONArray u;
    public String uj;
    public String ve;
    public String x;
    public HashMap<String, String> yp = new HashMap<>();

    public a() {
    }

    public String a() {
        return this.tt;
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.yp.put(str, str2);
    }

    public String da() {
        return this.sp;
    }

    public String i() {
        return this.f28480a;
    }

    public String n() {
        return this.c;
    }

    public String sl() {
        return this.x;
    }

    public String sp() {
        return this.ve;
    }

    public JSONArray t() {
        return this.i;
    }

    public String tt() {
        return this.n;
    }

    public String u() {
        return this.da;
    }

    public JSONArray uj() {
        return this.u;
    }

    public float ve() {
        return this.t;
    }

    public String x() {
        return this.uj;
    }

    public String yp() {
        return this.sl;
    }

    public void a(String str) {
        this.f28480a = str;
    }

    public void da(String str) {
        this.sl = str;
    }

    public void i(String str) {
        this.da = str;
    }

    public void n(String str) {
        this.uj = str;
    }

    public void sp(String str) {
        this.sp = str;
    }

    public void tt(String str) {
        this.c = str;
    }

    public void uj(String str) {
        this.ve = str;
    }

    public void ve(String str) {
        this.tt = str;
    }

    public void x(String str) {
        this.x = str;
    }

    public a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uj(jSONObject.optString("developer_name"));
        tt(jSONObject.optString(AlibcCommonConstant.APP_VERSION));
        tt(jSONObject.optJSONArray(RequestPermission.PERMISSIONS));
        n(jSONObject.optString("privacy_policy_url"));
        i(jSONObject.optString("package_name"));
        da(jSONObject.optString("app_name"));
        c((float) jSONObject.optDouble("score", AudioStats.AUDIO_AMPLITUDE_NONE));
        c(jSONObject.optJSONArray("creative_tags"));
        c(jSONObject.optString("permissions_url"));
        a(jSONObject.optString("desc_url"));
        sp(jSONObject.optString("reg_number"));
        x(jSONObject.optString("reg_url"));
    }

    public HashMap<String, String> c() {
        return this.yp;
    }

    public void tt(JSONArray jSONArray) {
        this.i = jSONArray;
    }

    public void c(String str) {
        this.n = str;
    }

    public void c(float f) {
        this.t = f;
    }

    public void c(JSONArray jSONArray) {
        this.u = jSONArray;
    }
}
