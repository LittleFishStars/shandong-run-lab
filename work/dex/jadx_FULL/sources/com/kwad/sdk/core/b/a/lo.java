package com.kwad.sdk.core.b.a;

import com.aliyun.credentials.utils.AuthConstant;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lo implements com.kwad.sdk.core.d<AdMatrixInfo.ShakeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.ShakeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.ShakeInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shakeInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(shakeInfo.title)) {
            shakeInfo.title = "";
        }
        shakeInfo.subtitle = jSONObject.optString(MediaFormat.KEY_SUBTITLE);
        if (JSONObject.NULL.toString().equals(shakeInfo.subtitle)) {
            shakeInfo.subtitle = "";
        }
        shakeInfo.acceleration = jSONObject.optInt("acceleration");
        shakeInfo.clickDisabled = jSONObject.optBoolean("clickDisabled");
        shakeInfo.componentIndex = jSONObject.optInt("componentIndex");
        shakeInfo.enable = jSONObject.optBoolean(AuthConstant.INI_ENABLE);
        shakeInfo.bidirectionalSwitch = jSONObject.optBoolean("bidirectionalSwitch");
    }

    private static JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = shakeInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", shakeInfo.title);
        }
        String str2 = shakeInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediaFormat.KEY_SUBTITLE, shakeInfo.subtitle);
        }
        int i = shakeInfo.acceleration;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "acceleration", i);
        }
        boolean z = shakeInfo.clickDisabled;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clickDisabled", z);
        }
        int i2 = shakeInfo.componentIndex;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "componentIndex", i2);
        }
        boolean z2 = shakeInfo.enable;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, AuthConstant.INI_ENABLE, z2);
        }
        boolean z3 = shakeInfo.bidirectionalSwitch;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bidirectionalSwitch", z3);
        }
        return jSONObject;
    }
}
