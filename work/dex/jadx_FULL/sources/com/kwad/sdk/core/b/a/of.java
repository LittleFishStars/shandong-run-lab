package com.kwad.sdk.core.b.a;

import com.kwad.sdk.resourceCache.model.WarmUpReportMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class of implements com.kwad.sdk.core.d<WarmUpReportMessage> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WarmUpReportMessage) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WarmUpReportMessage) bVar, jSONObject);
    }

    private static void a(WarmUpReportMessage warmUpReportMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        warmUpReportMessage.downloadStatus = jSONObject.optInt("status", new Integer("0").intValue());
        warmUpReportMessage.resourceType = jSONObject.optInt("resource_type");
        warmUpReportMessage.resourceKey = jSONObject.optString("resource_key");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.resourceKey)) {
            warmUpReportMessage.resourceKey = "";
        }
        warmUpReportMessage.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.url)) {
            warmUpReportMessage.url = "";
        }
        warmUpReportMessage.localItems = jSONObject.optString("local_items");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.localItems)) {
            warmUpReportMessage.localItems = "";
        }
        warmUpReportMessage.configItems = jSONObject.optString("config_items");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.configItems)) {
            warmUpReportMessage.configItems = "";
        }
        warmUpReportMessage.freeDisk = jSONObject.optLong("free_disk");
        warmUpReportMessage.zipFileMd5 = jSONObject.optString("zip_file_md5");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.zipFileMd5)) {
            warmUpReportMessage.zipFileMd5 = "";
        }
    }

    private static JSONObject b(WarmUpReportMessage warmUpReportMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "status", warmUpReportMessage.downloadStatus);
        int i = warmUpReportMessage.resourceType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "resource_type", i);
        }
        String str = warmUpReportMessage.resourceKey;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "resource_key", warmUpReportMessage.resourceKey);
        }
        String str2 = warmUpReportMessage.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", warmUpReportMessage.url);
        }
        String str3 = warmUpReportMessage.localItems;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "local_items", warmUpReportMessage.localItems);
        }
        String str4 = warmUpReportMessage.configItems;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "config_items", warmUpReportMessage.configItems);
        }
        long j = warmUpReportMessage.freeDisk;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "free_disk", j);
        }
        String str5 = warmUpReportMessage.zipFileMd5;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "zip_file_md5", warmUpReportMessage.zipFileMd5);
        }
        return jSONObject;
    }
}
