package com.igexin.push.config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37912a = "IDCConfigParse";

    public static void a(String str, boolean z) {
        JSONObject jSONObject;
        String[] strArrA;
        String[] strArrA2;
        String[] strArrA3;
        String[] strArrA4;
        String[] strArrA5;
        com.igexin.c.a.c.a.b(f37912a, " parse idc config data : ".concat(String.valueOf(str)));
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("N")) {
            try {
                SDKUrlConfig.setLocation(jSONObject.getString("N"));
            } catch (JSONException e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (jSONObject.has("X1") && (strArrA5 = a(jSONObject, "X1")) != null && strArrA5.length > 0) {
            SDKUrlConfig.setXfrAddressIps(strArrA5);
            if (z) {
                com.igexin.c.a.c.a.b("Detect_IDCConfigParse", "parse idc success, set new xfr address, reset and redetect +++++++++++++++++");
                com.igexin.push.c.c.a().e();
            }
        }
        if (jSONObject.has("X2") && (strArrA4 = a(jSONObject, "X2")) != null && strArrA4.length > 0) {
            SDKUrlConfig.XFR_ADDRESS_BAK = strArrA4;
        }
        if (jSONObject.has("B") && (strArrA3 = a(jSONObject, "B")) != null && strArrA3.length > 0) {
            SDKUrlConfig.BI_ADDRESS_IPS = strArrA3;
        }
        if (jSONObject.has("C") && (strArrA2 = a(jSONObject, "C")) != null && strArrA2.length > 0) {
            SDKUrlConfig.CONFIG_ADDRESS_IPS = strArrA2;
        }
        if (!jSONObject.has("LO") || (strArrA = a(jSONObject, "LO")) == null || strArrA.length <= 0) {
            return;
        }
        SDKUrlConfig.LOG_ADDRESS_IPS = strArrA;
    }

    private static String[] a(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                if ("X1".equals(str) || "X2".equals(str)) {
                    strArr[i] = "socket://" + jSONArray.getString(i);
                } else {
                    strArr[i] = "https://" + jSONArray.getString(i);
                }
            }
            return strArr;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }
}
