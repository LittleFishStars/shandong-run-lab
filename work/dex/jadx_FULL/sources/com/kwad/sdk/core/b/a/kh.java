package com.kwad.sdk.core.b.a;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.zj.adlib.ze1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class kh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ah.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ah.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ah.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(aVar.SDKVersion)) {
            aVar.SDKVersion = "";
        }
        aVar.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        aVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(aVar.sdkApiVersion)) {
            aVar.sdkApiVersion = "";
        }
        aVar.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt(UserTrackConstant.SDK_TYPE);
        aVar.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.aqu = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(aVar.aqu)) {
            aVar.aqu = "";
        }
        aVar.aqv = jSONObject.optString(ze1.p);
        if (JSONObject.NULL.toString().equals(aVar.aqv)) {
            aVar.aqv = "";
        }
        aVar.model = jSONObject.optString(ze1.k);
        if (JSONObject.NULL.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.Nq = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(aVar.Nq)) {
            aVar.Nq = "";
        }
        aVar.aqw = jSONObject.optInt("osType");
        aVar.aqx = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(aVar.aqx)) {
            aVar.aqx = "";
        }
        aVar.aqy = jSONObject.optInt("osApi");
        aVar.aqz = jSONObject.optString(MediaFormat.KEY_LANGUAGE);
        if (JSONObject.NULL.toString().equals(aVar.aqz)) {
            aVar.aqz = "";
        }
        aVar.Un = jSONObject.optString(ze1.r);
        if (JSONObject.NULL.toString().equals(aVar.Un)) {
            aVar.Un = "";
        }
        aVar.Sq = jSONObject.optInt("screenWidth");
        aVar.Sp = jSONObject.optInt("screenHeight");
        aVar.aqA = jSONObject.optInt("statusBarHeight");
        aVar.aqB = jSONObject.optInt("titleBarHeight");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.SDKVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "SDKVersion", aVar.SDKVersion);
        }
        int i = aVar.SDKVersionCode;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = aVar.sdkApiVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersion", aVar.sdkApiVersion);
        }
        int i2 = aVar.sdkApiVersionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = aVar.sdkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, UserTrackConstant.SDK_TYPE, i3);
        }
        String str3 = aVar.appVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        String str4 = aVar.appName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", aVar.appName);
        }
        String str5 = aVar.appId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appId", aVar.appId);
        }
        String str6 = aVar.aqu;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "networkType", aVar.aqu);
        }
        String str7 = aVar.aqv;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ze1.p, aVar.aqv);
        }
        String str8 = aVar.model;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ze1.k, aVar.model);
        }
        String str9 = aVar.Nq;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceBrand", aVar.Nq);
        }
        int i4 = aVar.aqw;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osType", i4);
        }
        String str10 = aVar.aqx;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "systemVersion", aVar.aqx);
        }
        int i5 = aVar.aqy;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osApi", i5);
        }
        String str11 = aVar.aqz;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediaFormat.KEY_LANGUAGE, aVar.aqz);
        }
        String str12 = aVar.Un;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ze1.r, aVar.Un);
        }
        int i6 = aVar.Sq;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = aVar.Sp;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenHeight", i7);
        }
        int i8 = aVar.aqA;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = aVar.aqB;
        if (i9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "titleBarHeight", i9);
        }
        return jSONObject;
    }
}
