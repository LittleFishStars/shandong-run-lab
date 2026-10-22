package com.kwad.sdk.core.b.a;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ga implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.a.C1292a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.a.C1292a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.a.C1292a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.a.C1292a c1292a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1292a.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c1292a.SDKVersion)) {
            c1292a.SDKVersion = "";
        }
        c1292a.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        c1292a.aWn = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c1292a.aWn)) {
            c1292a.aWn = "";
        }
        c1292a.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c1292a.sdkApiVersion)) {
            c1292a.sdkApiVersion = "";
        }
        c1292a.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        c1292a.sdkType = jSONObject.optInt(UserTrackConstant.SDK_TYPE);
        c1292a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c1292a.appVersion)) {
            c1292a.appVersion = "";
        }
        c1292a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c1292a.appName)) {
            c1292a.appName = "";
        }
        c1292a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c1292a.appId)) {
            c1292a.appId = "";
        }
        c1292a.bda = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c1292a.bda)) {
            c1292a.bda = "";
        }
        c1292a.aXb = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c1292a.aXb)) {
            c1292a.aXb = "";
        }
        c1292a.aXa = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c1292a.aXa)) {
            c1292a.aXa = "";
        }
        c1292a.aqu = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c1292a.aqu)) {
            c1292a.aqu = "";
        }
        c1292a.aqv = jSONObject.optString(ze1.p);
        if (JSONObject.NULL.toString().equals(c1292a.aqv)) {
            c1292a.aqv = "";
        }
        c1292a.model = jSONObject.optString(ze1.k);
        if (JSONObject.NULL.toString().equals(c1292a.model)) {
            c1292a.model = "";
        }
        c1292a.Nq = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c1292a.Nq)) {
            c1292a.Nq = "";
        }
        c1292a.aqw = jSONObject.optInt("osType");
        c1292a.aqx = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c1292a.aqx)) {
            c1292a.aqx = "";
        }
        c1292a.aqy = jSONObject.optInt("osApi");
        c1292a.aqz = jSONObject.optString(MediaFormat.KEY_LANGUAGE);
        if (JSONObject.NULL.toString().equals(c1292a.aqz)) {
            c1292a.aqz = "";
        }
        c1292a.Un = jSONObject.optString(ze1.r);
        if (JSONObject.NULL.toString().equals(c1292a.Un)) {
            c1292a.Un = "";
        }
        c1292a.bdb = jSONObject.optString("uuid");
        if (JSONObject.NULL.toString().equals(c1292a.bdb)) {
            c1292a.bdb = "";
        }
        c1292a.bdc = jSONObject.optBoolean("isDynamic");
        c1292a.Sq = jSONObject.optInt("screenWidth");
        c1292a.Sp = jSONObject.optInt("screenHeight");
        c1292a.aQZ = jSONObject.optString(DeviceIdType.IMEI);
        if (JSONObject.NULL.toString().equals(c1292a.aQZ)) {
            c1292a.aQZ = "";
        }
        c1292a.aRa = jSONObject.optString(DeviceIdType.OAID);
        if (JSONObject.NULL.toString().equals(c1292a.aRa)) {
            c1292a.aRa = "";
        }
        c1292a.aWY = jSONObject.optString(DeviceIdType.ANDROID_ID);
        if (JSONObject.NULL.toString().equals(c1292a.aWY)) {
            c1292a.aWY = "";
        }
        c1292a.aXo = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(c1292a.aXo)) {
            c1292a.aXo = "";
        }
        c1292a.aqA = jSONObject.optInt("statusBarHeight");
        c1292a.aqB = jSONObject.optInt("titleBarHeight");
        c1292a.bdd = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c1292a.bdd)) {
            c1292a.bdd = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.a.C1292a c1292a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c1292a.SDKVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "SDKVersion", c1292a.SDKVersion);
        }
        int i = c1292a.SDKVersionCode;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c1292a.aWn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tkVersion", c1292a.aWn);
        }
        String str3 = c1292a.sdkApiVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersion", c1292a.sdkApiVersion);
        }
        int i2 = c1292a.sdkApiVersionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c1292a.sdkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, UserTrackConstant.SDK_TYPE, i3);
        }
        String str4 = c1292a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appVersion", c1292a.appVersion);
        }
        String str5 = c1292a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appName", c1292a.appName);
        }
        String str6 = c1292a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appId", c1292a.appId);
        }
        String str7 = c1292a.bda;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "globalId", c1292a.bda);
        }
        String str8 = c1292a.aXb;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "eGid", c1292a.aXb);
        }
        String str9 = c1292a.aXa;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceSig", c1292a.aXa);
        }
        String str10 = c1292a.aqu;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "networkType", c1292a.aqu);
        }
        String str11 = c1292a.aqv;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ze1.p, c1292a.aqv);
        }
        String str12 = c1292a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ze1.k, c1292a.model);
        }
        String str13 = c1292a.Nq;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceBrand", c1292a.Nq);
        }
        int i4 = c1292a.aqw;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osType", i4);
        }
        String str14 = c1292a.aqx;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "systemVersion", c1292a.aqx);
        }
        int i5 = c1292a.aqy;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c1292a.aqz;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediaFormat.KEY_LANGUAGE, c1292a.aqz);
        }
        String str16 = c1292a.Un;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ze1.r, c1292a.Un);
        }
        String str17 = c1292a.bdb;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uuid", c1292a.bdb);
        }
        boolean z = c1292a.bdc;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isDynamic", z);
        }
        int i6 = c1292a.Sq;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c1292a.Sp;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c1292a.aQZ;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, DeviceIdType.IMEI, c1292a.aQZ);
        }
        String str19 = c1292a.aRa;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, DeviceIdType.OAID, c1292a.aRa);
        }
        String str20 = c1292a.aWY;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, DeviceIdType.ANDROID_ID, c1292a.aWY);
        }
        String str21 = c1292a.aXo;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mac", c1292a.aXo);
        }
        int i8 = c1292a.aqA;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c1292a.aqB;
        if (i9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "titleBarHeight", i9);
        }
        String str22 = c1292a.bdd;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bridgeVersion", c1292a.bdd);
        }
        return jSONObject;
    }
}
