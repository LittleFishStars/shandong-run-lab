package com.kwad.sdk.core.b.a;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class md implements com.kwad.sdk.core.d<AdMatrixInfo.SplashEndCardTKInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.SplashEndCardTKInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.SplashEndCardTKInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashEndCardTKInfo.endCardCountDaily = jSONObject.optInt("endCardCountDaily", new Integer("5").intValue());
        splashEndCardTKInfo.endCardShowSecond = jSONObject.optInt("endCardShowSecond", new Integer("5").intValue());
        splashEndCardTKInfo.endCardFullScreenClick = jSONObject.optBoolean("endCardFullScreenClick", new Boolean("true").booleanValue());
        splashEndCardTKInfo.endCardShowCountDown = jSONObject.optBoolean("endCardShowCountDown", new Boolean(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).booleanValue());
    }

    private static JSONObject b(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "endCardCountDaily", splashEndCardTKInfo.endCardCountDaily);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "endCardShowSecond", splashEndCardTKInfo.endCardShowSecond);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "endCardFullScreenClick", splashEndCardTKInfo.endCardFullScreenClick);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "endCardShowCountDown", splashEndCardTKInfo.endCardShowCountDown);
        return jSONObject;
    }
}
