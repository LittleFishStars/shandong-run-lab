package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cn implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.C1273a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.a.C1273a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.a.C1273a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.a.C1273a c1273a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1273a.aLf = jSONObject.optInt("ad_retry_type");
        c1273a.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(c1273a.templateId)) {
            c1273a.templateId = "";
        }
        c1273a.aLg = jSONObject.optString("template_sub_id");
        if (JSONObject.NULL.toString().equals(c1273a.aLg)) {
            c1273a.aLg = "";
        }
        c1273a.aLh = jSONObject.optString("default_type");
        if (JSONObject.NULL.toString().equals(c1273a.aLh)) {
            c1273a.aLh = "";
        }
        c1273a.aLi = jSONObject.optString("tk_template_id");
        if (JSONObject.NULL.toString().equals(c1273a.aLi)) {
            c1273a.aLi = "";
        }
        c1273a.aLj = jSONObject.optString("tk_template_version");
        if (JSONObject.NULL.toString().equals(c1273a.aLj)) {
            c1273a.aLj = "";
        }
        c1273a.tkPublishType = jSONObject.optInt("tk_publish_type", new Integer("0").intValue());
        c1273a.aLl = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c1273a.aLl)) {
            c1273a.aLl = "";
        }
        c1273a.aLm = jSONObject.optInt("network_download_status", new Integer("3").intValue());
        c1273a.aLn = jSONObject.optInt("award_task_name");
        c1273a.aLo = jSONObject.optInt("jumps_liveroom_type");
        c1273a.aLp = jSONObject.optInt("universe_feature_freg");
        c1273a.aLq = jSONObject.optInt("replace_url_succ");
        c1273a.aLr = jSONObject.optBoolean("is_dp_opt");
        c1273a.aLs = jSONObject.optString("component_module");
        if (JSONObject.NULL.toString().equals(c1273a.aLs)) {
            c1273a.aLs = "";
        }
        c1273a.aLu = jSONObject.optInt("is_carousel");
        c1273a.aLv = jSONObject.optInt("is_special_preload");
        c1273a.aLw = jSONObject.optInt("card_type");
        c1273a.aLx = jSONObject.optInt("is_closure");
        c1273a.aLy = jSONObject.optInt("is_click_invoked");
        c1273a.aLz = jSONObject.optString("authorization_status");
        if (JSONObject.NULL.toString().equals(c1273a.aLz)) {
            c1273a.aLz = "";
        }
        c1273a.aLA = jSONObject.optString("login_source");
        if (JSONObject.NULL.toString().equals(c1273a.aLA)) {
            c1273a.aLA = "";
        }
        c1273a.aLB = jSONObject.optInt("is_login");
        c1273a.aLC = jSONObject.optInt("interception_time");
        c1273a.aLD = jSONObject.optInt("interception_reason");
        c1273a.aLE = jSONObject.optInt("coupon_receive_status");
        c1273a.aLG = jSONObject.optInt("deeplink_evocation_source");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.a.C1273a c1273a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c1273a.aLf;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_retry_type", i);
        }
        String str = c1273a.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "template_id", c1273a.templateId);
        }
        String str2 = c1273a.aLg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "template_sub_id", c1273a.aLg);
        }
        String str3 = c1273a.aLh;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "default_type", c1273a.aLh);
        }
        String str4 = c1273a.aLi;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_template_id", c1273a.aLi);
        }
        String str5 = c1273a.aLj;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_template_version", c1273a.aLj);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_publish_type", c1273a.tkPublishType);
        String str6 = c1273a.aLl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "template_show_type", c1273a.aLl);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "network_download_status", c1273a.aLm);
        int i2 = c1273a.aLn;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "award_task_name", i2);
        }
        int i3 = c1273a.aLo;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "jumps_liveroom_type", i3);
        }
        int i4 = c1273a.aLp;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "universe_feature_freg", i4);
        }
        int i5 = c1273a.aLq;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "replace_url_succ", i5);
        }
        boolean z = c1273a.aLr;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_dp_opt", z);
        }
        String str7 = c1273a.aLs;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "component_module", c1273a.aLs);
        }
        int i6 = c1273a.aLu;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_carousel", i6);
        }
        int i7 = c1273a.aLv;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_special_preload", i7);
        }
        int i8 = c1273a.aLw;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "card_type", i8);
        }
        int i9 = c1273a.aLx;
        if (i9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_closure", i9);
        }
        int i10 = c1273a.aLy;
        if (i10 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_click_invoked", i10);
        }
        String str8 = c1273a.aLz;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "authorization_status", c1273a.aLz);
        }
        String str9 = c1273a.aLA;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "login_source", c1273a.aLA);
        }
        int i11 = c1273a.aLB;
        if (i11 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_login", i11);
        }
        int i12 = c1273a.aLC;
        if (i12 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interception_time", i12);
        }
        int i13 = c1273a.aLD;
        if (i13 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interception_reason", i13);
        }
        int i14 = c1273a.aLE;
        if (i14 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "coupon_receive_status", i14);
        }
        int i15 = c1273a.aLG;
        if (i15 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplink_evocation_source", i15);
        }
        return jSONObject;
    }
}
