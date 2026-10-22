package com.kwad.sdk.core.b.a;

import androidx.camera.video.AudioStats;
import com.kwad.sdk.kgeo.KGeoInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hm implements com.kwad.sdk.core.d<KGeoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((KGeoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((KGeoInfo) bVar, jSONObject);
    }

    private static void a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kGeoInfo.latitude = jSONObject.optDouble("latitude");
        kGeoInfo.longitude = jSONObject.optDouble("longitude");
        kGeoInfo.range = jSONObject.optInt(com.google.android.exoplayer2.source.rtsp.i.m);
        kGeoInfo.rate = jSONObject.optInt("rate");
    }

    private static JSONObject b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = kGeoInfo.latitude;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "latitude", d);
        }
        double d2 = kGeoInfo.longitude;
        if (d2 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "longitude", d2);
        }
        int i = kGeoInfo.range;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.google.android.exoplayer2.source.rtsp.i.m, i);
        }
        int i2 = kGeoInfo.rate;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rate", i2);
        }
        return jSONObject;
    }
}
