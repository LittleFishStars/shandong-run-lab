package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class fb implements com.kwad.sdk.core.d<FeedPageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedPageInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedPageInfo) bVar, jSONObject);
    }

    private static void a(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedPageInfo.status = jSONObject.optInt("status");
        feedPageInfo.loadStatus = jSONObject.optInt("load_status");
        feedPageInfo.adNum = jSONObject.optInt("ad_num");
        feedPageInfo.type = jSONObject.optInt("type");
        feedPageInfo.loadType = jSONObject.optLong("load_type");
        feedPageInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        feedPageInfo.resourceLoadDuration = jSONObject.optLong("resource_load_duration_ms");
        feedPageInfo.materialType = jSONObject.optInt("material_type");
        feedPageInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(feedPageInfo.materialUrl)) {
            feedPageInfo.materialUrl = "";
        }
        feedPageInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        feedPageInfo.renderType = jSONObject.optInt("render_type");
        feedPageInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        feedPageInfo.convertDuration = jSONObject.optLong("convert_duartion_ms");
        feedPageInfo.extMsg = jSONObject.optString("ext_msg");
        if (JSONObject.NULL.toString().equals(feedPageInfo.extMsg)) {
            feedPageInfo.extMsg = "";
        }
        feedPageInfo.abParams = jSONObject.optString("ab_params");
        if (JSONObject.NULL.toString().equals(feedPageInfo.abParams)) {
            feedPageInfo.abParams = "";
        }
        feedPageInfo.callbackType = jSONObject.optInt("callback_type");
        feedPageInfo.materialInfoList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("material_info");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                FeedPageInfo.a aVar = new FeedPageInfo.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                feedPageInfo.materialInfoList.add(aVar);
            }
        }
    }

    private static JSONObject b(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = feedPageInfo.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        int i2 = feedPageInfo.loadStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_status", i2);
        }
        int i3 = feedPageInfo.adNum;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_num", i3);
        }
        int i4 = feedPageInfo.type;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", i4);
        }
        long j = feedPageInfo.loadType;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_type", j);
        }
        long j2 = feedPageInfo.loadDataDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_data_duration_ms", j2);
        }
        long j3 = feedPageInfo.resourceLoadDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "resource_load_duration_ms", j3);
        }
        int i5 = feedPageInfo.materialType;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", i5);
        }
        String str = feedPageInfo.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_url", feedPageInfo.materialUrl);
        }
        long j4 = feedPageInfo.renderDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "render_duration_ms", j4);
        }
        int i6 = feedPageInfo.renderType;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "render_type", i6);
        }
        int i7 = feedPageInfo.expectedRenderType;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "expected_render_type", i7);
        }
        long j5 = feedPageInfo.convertDuration;
        if (j5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convert_duartion_ms", j5);
        }
        String str2 = feedPageInfo.extMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ext_msg", feedPageInfo.extMsg);
        }
        String str3 = feedPageInfo.abParams;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ab_params", feedPageInfo.abParams);
        }
        int i8 = feedPageInfo.callbackType;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callback_type", i8);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "material_info", feedPageInfo.materialInfoList);
        return jSONObject;
    }
}
