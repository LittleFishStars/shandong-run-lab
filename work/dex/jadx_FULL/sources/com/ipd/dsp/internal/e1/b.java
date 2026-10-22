package com.ipd.dsp.internal.e1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.triver.basic.api.RequestPermission;
import com.ipd.dsp.internal.c2.o;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements Serializable {
    public static final String E = "H5";
    public static final String F = "App";
    public static final String G = "Wechat_mini";
    public String A;
    public String B;
    public String C;
    public l D;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public ArrayList<String> u;
    public String v;
    public boolean w;
    public String x;
    public String y;
    public String z;

    public b(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f = jSONObject.optString("type");
            this.g = "browser".equals(jSONObject.optString("h5_type"));
            this.h = jSONObject.optString("schema");
            this.i = jSONObject.optString("app_store");
            this.j = jSONObject.optString("page");
            this.k = jSONObject.optString("apk_url");
            this.l = jSONObject.optString("apk_file_name");
            this.m = jSONObject.optString("package_name");
            this.n = jSONObject.optString("wechat_appid");
            this.o = jSONObject.optString("wechat_mini_id");
            this.p = jSONObject.optString("wechat_mini_path");
            this.q = jSONObject.optString("app_name");
            this.r = jSONObject.optString("version");
            this.s = jSONObject.optString("developer");
            this.t = jSONObject.optString("update_at");
            this.u = new ArrayList<>();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(RequestPermission.PERMISSIONS);
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.u.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            this.v = jSONObject.optString("privacy_policy_url");
            this.w = jSONObject.optInt("is_dplink_click_confirm", 0) == 1;
            this.x = jSONObject.optString("app_feature_link");
            this.y = jSONObject.optString("permission_link");
            this.z = jSONObject.optString("package_size");
            this.A = jSONObject.optString("target_age");
            this.B = jSONObject.optString("icp_no");
            this.C = jSONObject.optString("icp_link");
        } else {
            this.f = "";
            this.h = "";
            this.i = "";
            this.j = "";
            this.k = "";
            this.l = "";
            this.m = "";
            this.n = "";
            this.o = "";
            this.p = "";
            this.q = "";
            this.r = "";
            this.s = "";
            this.t = "";
            this.u = new ArrayList<>();
            this.v = "";
            this.w = false;
            this.x = "";
            this.y = "";
            this.z = "0";
            this.A = "";
            this.B = "";
            this.C = "";
        }
        this.D = new l(this);
    }

    public String a() {
        if (!F.equals(this.f)) {
            if (G.equals(this.f)) {
                return "跳转到微信";
            }
            return ("H5".equals(this.f) && this.g) ? "在浏览器中查看" : "查看详情";
        }
        if (o.c(this.h) && com.ipd.dsp.internal.b1.a.a(com.ipd.dsp.internal.l1.a.a().getContext(), this.h) != null) {
            return "跳转到第三方";
        }
        if (!o.c(this.i) || com.ipd.dsp.internal.b1.a.a(com.ipd.dsp.internal.l1.a.a().getContext(), this.i) == null) {
            return (o.c(this.m) && com.ipd.dsp.internal.c2.g.a().a(this.m)) ? "跳转到第三方" : com.ipd.dsp.internal.b1.b.a.l;
        }
        return "在应用商店中查看";
    }

    public boolean b() {
        if (!F.equals(this.f) || !o.c(this.k)) {
            return false;
        }
        if (TextUtils.isEmpty(this.h) || com.ipd.dsp.internal.b1.a.a(com.ipd.dsp.internal.l1.a.a().getContext(), this.h) == null) {
            return TextUtils.isEmpty(this.i) || com.ipd.dsp.internal.b1.a.a(com.ipd.dsp.internal.l1.a.a().getContext(), this.i) == null;
        }
        return false;
    }
}
