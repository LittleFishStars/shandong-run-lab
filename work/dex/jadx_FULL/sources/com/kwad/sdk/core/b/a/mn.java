package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mn implements com.kwad.sdk.core.d<StatusInfo.SplashStyleControl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.SplashStyleControl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.SplashStyleControl) bVar, jSONObject);
    }

    private static void a(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashStyleControl.disableShake = jSONObject.optBoolean("disableShake");
        splashStyleControl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashStyleControl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    private static JSONObject b(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = splashStyleControl.disableShake;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableShake", z);
        }
        boolean z2 = splashStyleControl.disableRotate;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableRotate", z2);
        }
        boolean z3 = splashStyleControl.disableSlide;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableSlide", z3);
        }
        return jSONObject;
    }
}
