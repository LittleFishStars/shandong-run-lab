package com.kwad.sdk.core.b.a;

import androidx.camera.video.AudioStats;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ec implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.a.m.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.a.m.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.a.m.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.a.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.x = jSONObject.optDouble("x");
        aVar.y = jSONObject.optDouble("y");
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.a.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = aVar.x;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "x", d);
        }
        double d2 = aVar.y;
        if (d2 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "y", d2);
        }
        return jSONObject;
    }
}
