package com.kwad.sdk.core.b.a;

import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hn implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jsPublicBridge.a.a.C1234a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jsPublicBridge.a.a.C1234a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jsPublicBridge.a.a.C1234a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jsPublicBridge.a.a.C1234a c1234a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1234a.apb = jSONObject.optInt("platform");
        c1234a.apc = jSONObject.optInt("flowSource");
        c1234a.apd = jSONObject.optInt("clientId");
        c1234a.appVersion = jSONObject.optString(AlibcCommonConstant.APP_VERSION);
        if (JSONObject.NULL.toString().equals(c1234a.appVersion)) {
            c1234a.appVersion = "";
        }
        c1234a.netType = jSONObject.optInt(HiAnalyticsConstant.BI_KEY_NET_TYPE);
        c1234a.ape = jSONObject.optString("publicKey");
        if (JSONObject.NULL.toString().equals(c1234a.ape)) {
            c1234a.ape = "";
        }
        c1234a.apf = jSONObject.optString("sdkgetNumberName");
        if (JSONObject.NULL.toString().equals(c1234a.apf)) {
            c1234a.apf = "";
        }
        c1234a.apg = jSONObject.optString("sdkoperJudgeName");
        if (JSONObject.NULL.toString().equals(c1234a.apg)) {
            c1234a.apg = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jsPublicBridge.a.a.C1234a c1234a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c1234a.apb;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "platform", i);
        }
        int i2 = c1234a.apc;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "flowSource", i2);
        }
        int i3 = c1234a.apd;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clientId", i3);
        }
        String str = c1234a.appVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, AlibcCommonConstant.APP_VERSION, c1234a.appVersion);
        }
        int i4 = c1234a.netType;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HiAnalyticsConstant.BI_KEY_NET_TYPE, i4);
        }
        String str2 = c1234a.ape;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "publicKey", c1234a.ape);
        }
        String str3 = c1234a.apf;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkgetNumberName", c1234a.apf);
        }
        String str4 = c1234a.apg;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkoperJudgeName", c1234a.apg);
        }
        return jSONObject;
    }
}
