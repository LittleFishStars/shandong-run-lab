package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class in implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdMaterialInfo.MaterialFeature) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdMaterialInfo.MaterialFeature) bVar, jSONObject);
    }

    private static void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.materialUrl)) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.coverUrl)) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt("videoDuration");
        materialFeature.videoDurationMs = jSONObject.optLong("videoDurationMs");
        materialFeature.firstFrame = jSONObject.optString("firstFrame");
        if (JSONObject.NULL.toString().equals(materialFeature.firstFrame)) {
            materialFeature.firstFrame = "";
        }
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.blurBackgroundUrl)) {
            materialFeature.blurBackgroundUrl = "";
        }
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (JSONObject.NULL.toString().equals(materialFeature.webpCoverUrl)) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt("source");
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (JSONObject.NULL.toString().equals(materialFeature.ruleId)) {
            materialFeature.ruleId = "";
        }
    }

    private static JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = materialFeature.featureType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "featureType", i);
        }
        String str = materialFeature.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        long j = materialFeature.photoId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoId", j);
        }
        String str2 = materialFeature.coverUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        int i2 = materialFeature.videoDuration;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoDuration", i2);
        }
        long j2 = materialFeature.videoDurationMs;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoDurationMs", j2);
        }
        String str3 = materialFeature.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "firstFrame", materialFeature.firstFrame);
        }
        String str4 = materialFeature.blurBackgroundUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        String str5 = materialFeature.webpCoverUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        int i3 = materialFeature.videoWidth;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoWidth", i3);
        }
        int i4 = materialFeature.videoHeight;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "videoHeight", i4);
        }
        long j3 = materialFeature.likeCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "likeCount", j3);
        }
        long j4 = materialFeature.commentCount;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "commentCount", j4);
        }
        int i5 = materialFeature.source;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "source", i5);
        }
        String str6 = materialFeature.ruleId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }
}
