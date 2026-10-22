package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class om implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.WidgetAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.WidgetAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.WidgetAdInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        widgetAdInfo.widgetAdIcon = jSONObject.optString("widgetAdIcon");
        if (JSONObject.NULL.toString().equals(widgetAdInfo.widgetAdIcon)) {
            widgetAdInfo.widgetAdIcon = "";
        }
        widgetAdInfo.downloadStartLabel = jSONObject.optString("downloadStartLabel", new String(com.ipd.dsp.internal.b1.b.a.l));
        widgetAdInfo.downloadOngoingLabel = jSONObject.optString("downloadOngoingLabel", new String(com.ipd.dsp.internal.b1.b.a.m));
        widgetAdInfo.downloadResumeLabel = jSONObject.optString("downloadResumeLabel", new String("恢复下载"));
        widgetAdInfo.installAppLabel = jSONObject.optString("installAppLabel", new String("开始安装"));
        widgetAdInfo.openAppLabel = jSONObject.optString("openAppLabel", new String("立刻打开"));
        widgetAdInfo.type = jSONObject.optInt("type");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = widgetAdInfo.widgetAdIcon;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "widgetAdIcon", widgetAdInfo.widgetAdIcon);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadStartLabel", widgetAdInfo.downloadStartLabel);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadOngoingLabel", widgetAdInfo.downloadOngoingLabel);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadResumeLabel", widgetAdInfo.downloadResumeLabel);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "installAppLabel", widgetAdInfo.installAppLabel);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "openAppLabel", widgetAdInfo.openAppLabel);
        int i = widgetAdInfo.type;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", i);
        }
        return jSONObject;
    }
}
