package com.kwad.sdk.core.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ol implements com.kwad.sdk.core.d<WebViewLoadMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebViewLoadMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebViewLoadMsg) bVar, jSONObject);
    }

    private static void a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewLoadMsg.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.url)) {
            webViewLoadMsg.url = "";
        }
        webViewLoadMsg.state = jSONObject.optInt("state");
        webViewLoadMsg.interval = jSONObject.optString("interval");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.interval)) {
            webViewLoadMsg.interval = "";
        }
        webViewLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.failReason)) {
            webViewLoadMsg.failReason = "";
        }
        webViewLoadMsg.costTime = jSONObject.optString(HiAnalyticsConstant.BI_KEY_COST_TIME);
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.costTime)) {
            webViewLoadMsg.costTime = "";
        }
    }

    private static JSONObject b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewLoadMsg.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", webViewLoadMsg.url);
        }
        int i = webViewLoadMsg.state;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "state", i);
        }
        String str2 = webViewLoadMsg.interval;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interval", webViewLoadMsg.interval);
        }
        String str3 = webViewLoadMsg.failReason;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "fail_reason", webViewLoadMsg.failReason);
        }
        String str4 = webViewLoadMsg.costTime;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HiAnalyticsConstant.BI_KEY_COST_TIME, webViewLoadMsg.costTime);
        }
        return jSONObject;
    }
}
