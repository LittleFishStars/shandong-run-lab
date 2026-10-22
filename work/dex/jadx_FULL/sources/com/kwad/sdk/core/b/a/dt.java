package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dt implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo.DeeplinkItemInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdConversionInfo.DeeplinkItemInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdConversionInfo.DeeplinkItemInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        deeplinkItemInfo.sceneConf = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sceneConf");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                deeplinkItemInfo.sceneConf.add((Integer) jSONArrayOptJSONArray.opt(i));
            }
        }
        deeplinkItemInfo.areaConf = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("areaConf");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                deeplinkItemInfo.areaConf.add((Integer) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        deeplinkItemInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(deeplinkItemInfo.url)) {
            deeplinkItemInfo.url = "";
        }
    }

    private static JSONObject b(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "sceneConf", deeplinkItemInfo.sceneConf);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "areaConf", deeplinkItemInfo.areaConf);
        String str = deeplinkItemInfo.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", deeplinkItemInfo.url);
        }
        return jSONObject;
    }
}
