package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kc.openset.constant.DeviceIdType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dy implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aQZ = jSONObject.optString(DeviceIdType.IMEI);
        if (JSONObject.NULL.toString().equals(bVar.aQZ)) {
            bVar.aQZ = "";
        }
        bVar.aWR = jSONObject.optString("imei1");
        if (JSONObject.NULL.toString().equals(bVar.aWR)) {
            bVar.aWR = "";
        }
        bVar.aWS = jSONObject.optString("imei2");
        if (JSONObject.NULL.toString().equals(bVar.aWS)) {
            bVar.aWS = "";
        }
        bVar.aWT = jSONObject.optString("meid");
        if (JSONObject.NULL.toString().equals(bVar.aWT)) {
            bVar.aWT = "";
        }
        bVar.aRa = jSONObject.optString(DeviceIdType.OAID);
        if (JSONObject.NULL.toString().equals(bVar.aRa)) {
            bVar.aRa = "";
        }
        bVar.aWU = jSONObject.optString("appMkt");
        if (JSONObject.NULL.toString().equals(bVar.aWU)) {
            bVar.aWU = "";
        }
        bVar.aWV = jSONObject.optString("appMktParam");
        if (JSONObject.NULL.toString().equals(bVar.aWV)) {
            bVar.aWV = "";
        }
        bVar.Ns = jSONObject.optString("romName");
        if (JSONObject.NULL.toString().equals(bVar.Ns)) {
            bVar.Ns = "";
        }
        bVar.aqw = jSONObject.optInt("osType");
        bVar.aqy = jSONObject.optInt("osApi");
        bVar.Nr = jSONObject.optString("osVersion");
        if (JSONObject.NULL.toString().equals(bVar.Nr)) {
            bVar.Nr = "";
        }
        bVar.aqz = jSONObject.optString(MediaFormat.KEY_LANGUAGE);
        if (JSONObject.NULL.toString().equals(bVar.aqz)) {
            bVar.aqz = "";
        }
        bVar.Sq = jSONObject.optInt("screenWidth");
        bVar.Sp = jSONObject.optInt("screenHeight");
        bVar.aWW = jSONObject.optInt("deviceWidth");
        bVar.aWX = jSONObject.optInt("deviceHeight");
        bVar.aWY = jSONObject.optString(DeviceIdType.ANDROID_ID);
        if (JSONObject.NULL.toString().equals(bVar.aWY)) {
            bVar.aWY = "";
        }
        bVar.Nt = jSONObject.optString("deviceId");
        if (JSONObject.NULL.toString().equals(bVar.Nt)) {
            bVar.Nt = "";
        }
        bVar.aWZ = jSONObject.optString("deviceVendor");
        if (JSONObject.NULL.toString().equals(bVar.aWZ)) {
            bVar.aWZ = "";
        }
        bVar.apb = jSONObject.optInt("platform");
        bVar.Np = jSONObject.optString("deviceModel");
        if (JSONObject.NULL.toString().equals(bVar.Np)) {
            bVar.Np = "";
        }
        bVar.Nq = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(bVar.Nq)) {
            bVar.Nq = "";
        }
        bVar.aXa = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(bVar.aXa)) {
            bVar.aXa = "";
        }
        bVar.aXb = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(bVar.aXb)) {
            bVar.aXb = "";
        }
        bVar.aXc = jSONObject.optJSONArray("appPackageName");
        bVar.aXd = jSONObject.optString("uaidToken");
        if (JSONObject.NULL.toString().equals(bVar.aXd)) {
            bVar.aXd = "";
        }
        bVar.uaid = jSONObject.optString("uaid");
        if (JSONObject.NULL.toString().equals(bVar.uaid)) {
            bVar.uaid = "";
        }
        bVar.aXe = jSONObject.optString("arch");
        if (JSONObject.NULL.toString().equals(bVar.aXe)) {
            bVar.aXe = "";
        }
        bVar.aXf = jSONObject.optInt("screenDirection");
        bVar.aXg = jSONObject.optString("kwaiVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aXg)) {
            bVar.aXg = "";
        }
        bVar.aXh = jSONObject.optString("kwaiNebulaVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aXh)) {
            bVar.aXh = "";
        }
        bVar.aXi = jSONObject.optString("wechatVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aXi)) {
            bVar.aXi = "";
        }
        bVar.aXj = jSONObject.optLong("sourceFlag");
        bVar.aXk = jSONObject.optString("systemBootTime");
        if (JSONObject.NULL.toString().equals(bVar.aXk)) {
            bVar.aXk = "";
        }
        bVar.aXl = jSONObject.optString("systemUpdateTime");
        if (JSONObject.NULL.toString().equals(bVar.aXl)) {
            bVar.aXl = "";
        }
        bVar.aXm = jSONObject.optInt("probeBatch");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aQZ;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, DeviceIdType.IMEI, bVar.aQZ);
        }
        String str2 = bVar.aWR;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imei1", bVar.aWR);
        }
        String str3 = bVar.aWS;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "imei2", bVar.aWS);
        }
        String str4 = bVar.aWT;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "meid", bVar.aWT);
        }
        String str5 = bVar.aRa;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, DeviceIdType.OAID, bVar.aRa);
        }
        String str6 = bVar.aWU;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appMkt", bVar.aWU);
        }
        String str7 = bVar.aWV;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appMktParam", bVar.aWV);
        }
        String str8 = bVar.Ns;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "romName", bVar.Ns);
        }
        int i = bVar.aqw;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osType", i);
        }
        int i2 = bVar.aqy;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osApi", i2);
        }
        String str9 = bVar.Nr;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "osVersion", bVar.Nr);
        }
        String str10 = bVar.aqz;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediaFormat.KEY_LANGUAGE, bVar.aqz);
        }
        int i3 = bVar.Sq;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenWidth", i3);
        }
        int i4 = bVar.Sp;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenHeight", i4);
        }
        int i5 = bVar.aWW;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceWidth", i5);
        }
        int i6 = bVar.aWX;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceHeight", i6);
        }
        String str11 = bVar.aWY;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, DeviceIdType.ANDROID_ID, bVar.aWY);
        }
        String str12 = bVar.Nt;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceId", bVar.Nt);
        }
        String str13 = bVar.aWZ;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceVendor", bVar.aWZ);
        }
        int i7 = bVar.apb;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "platform", i7);
        }
        String str14 = bVar.Np;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceModel", bVar.Np);
        }
        String str15 = bVar.Nq;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceBrand", bVar.Nq);
        }
        String str16 = bVar.aXa;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deviceSig", bVar.aXa);
        }
        String str17 = bVar.aXb;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "eGid", bVar.aXb);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appPackageName", bVar.aXc);
        String str18 = bVar.aXd;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uaidToken", bVar.aXd);
        }
        String str19 = bVar.uaid;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uaid", bVar.uaid);
        }
        String str20 = bVar.aXe;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "arch", bVar.aXe);
        }
        int i8 = bVar.aXf;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "screenDirection", i8);
        }
        String str21 = bVar.aXg;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "kwaiVersionName", bVar.aXg);
        }
        String str22 = bVar.aXh;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "kwaiNebulaVersionName", bVar.aXh);
        }
        String str23 = bVar.aXi;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "wechatVersionName", bVar.aXi);
        }
        long j = bVar.aXj;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sourceFlag", j);
        }
        String str24 = bVar.aXk;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "systemBootTime", bVar.aXk);
        }
        String str25 = bVar.aXl;
        if (str25 != null && !str25.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "systemUpdateTime", bVar.aXl);
        }
        int i9 = bVar.aXm;
        if (i9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "probeBatch", i9);
        }
        return jSONObject;
    }
}
