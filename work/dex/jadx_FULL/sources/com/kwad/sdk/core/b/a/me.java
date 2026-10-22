package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class me implements com.kwad.sdk.core.d<SplashExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashExtraDataImpl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashExtraDataImpl) bVar, jSONObject);
    }

    private static void a(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashExtraDataImpl.disableShake = jSONObject.optBoolean("disableShake");
        splashExtraDataImpl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashExtraDataImpl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    private static JSONObject b(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = splashExtraDataImpl.disableShake;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableShake", z);
        }
        boolean z2 = splashExtraDataImpl.disableRotate;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableRotate", z2);
        }
        boolean z3 = splashExtraDataImpl.disableSlide;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableSlide", z3);
        }
        return jSONObject;
    }
}
