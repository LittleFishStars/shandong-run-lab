package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ji implements com.kwad.sdk.core.d<AdGlobalConfigInfo.NeoScanAggregationSceneInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdGlobalConfigInfo.NeoScanAggregationSceneInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdGlobalConfigInfo.NeoScanAggregationSceneInfo) bVar, jSONObject);
    }

    private static void a(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger = jSONObject.optBoolean("neoCountDownNeedSwipeTrigger");
        neoScanAggregationSceneInfo.neoCountDownTime = jSONObject.optInt("neoCountDownTime");
        neoScanAggregationSceneInfo.noActionStopCountDown = jSONObject.optBoolean("noActionStopCountDown");
        neoScanAggregationSceneInfo.noActionTime = jSONObject.optInt("noActionTime");
        neoScanAggregationSceneInfo.guidSwipezShowMore = jSONObject.optBoolean("guidSwipezShowMore");
        neoScanAggregationSceneInfo.mute = jSONObject.optBoolean(com.alibaba.ariver.jsapi.multimedia.video.a.f);
    }

    private static JSONObject b(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "neoCountDownNeedSwipeTrigger", z);
        }
        int i = neoScanAggregationSceneInfo.neoCountDownTime;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "neoCountDownTime", i);
        }
        boolean z2 = neoScanAggregationSceneInfo.noActionStopCountDown;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "noActionStopCountDown", z2);
        }
        int i2 = neoScanAggregationSceneInfo.noActionTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "noActionTime", i2);
        }
        boolean z3 = neoScanAggregationSceneInfo.guidSwipezShowMore;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "guidSwipezShowMore", z3);
        }
        boolean z4 = neoScanAggregationSceneInfo.mute;
        if (z4) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.alibaba.ariver.jsapi.multimedia.video.a.f, z4);
        }
        return jSONObject;
    }
}
