package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class iz implements com.kwad.sdk.core.d<NativeAdExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((NativeAdExtraDataImpl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((NativeAdExtraDataImpl) bVar, jSONObject);
    }

    private static void a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdExtraDataImpl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdExtraDataImpl.enableRotate = jSONObject.optBoolean("enableRotate");
        nativeAdExtraDataImpl.showLiveStatus = jSONObject.optInt("showLiveStatus");
        nativeAdExtraDataImpl.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    private static JSONObject b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = nativeAdExtraDataImpl.enableShake;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enableShake", z);
        }
        boolean z2 = nativeAdExtraDataImpl.enableRotate;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enableRotate", z2);
        }
        int i = nativeAdExtraDataImpl.showLiveStatus;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showLiveStatus", i);
        }
        int i2 = nativeAdExtraDataImpl.showLiveStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showLiveStyle", i2);
        }
        return jSONObject;
    }
}
