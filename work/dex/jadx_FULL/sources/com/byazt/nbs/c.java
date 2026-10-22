package com.byazt.nbs;

import android.text.TextUtils;
import com.alipay.sdk.m.n.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1871, 20})
public class c {
    public String c;
    public String tt;
    public com.byazt.ih.tt uj;
    public String ve;

    public c(String str, String str2, String str3) {
        this.c = str;
        this.tt = str2;
        this.ve = str3;
        this.uj = new com.byazt.ih.tt();
    }

    public String a() {
        com.byazt.ih.tt ttVar = this.uj;
        if (ttVar != null) {
            return ttVar.tt();
        }
        return null;
    }

    public String c() {
        return this.c;
    }

    public boolean n() {
        com.byazt.ih.tt ttVar = this.uj;
        return ttVar != null && ttVar.uj();
    }

    public String toString() {
        return "AdNetworkConfValue{mAdnName='" + this.c + "'mAppId='" + this.tt + "', mAppKey='" + this.ve + "', mGMCustomConfig=" + this.uj + '}';
    }

    public String tt() {
        return this.tt;
    }

    public com.byazt.ih.tt uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }

    public static c c(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("app_id");
        String strOptString2 = jSONObject.optString(b.h);
        String strOptString3 = jSONObject.optString("custom_type");
        return !TextUtils.equals(strOptString3, "1") ? new c(str, strOptString, strOptString2) : new c(str, strOptString, strOptString2, jSONObject.optString("init_class_name"), jSONObject.optString("banner_class_name"), jSONObject.optString("interstitial_class_name"), jSONObject.optString("reward_class_name"), jSONObject.optString("full_video_class_name"), jSONObject.optString("splash_class_name"), jSONObject.optString("feed_class_name"), jSONObject.optString("draw_class_name"), strOptString3);
    }

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.c = str;
        this.tt = str2;
        this.ve = str3;
        this.uj = new com.byazt.ih.tt(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }
}
