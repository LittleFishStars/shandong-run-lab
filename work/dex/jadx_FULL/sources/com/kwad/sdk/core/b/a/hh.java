package com.kwad.sdk.core.b.a;

import androidx.camera.video.AudioStats;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ap.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ap.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ap.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.arg = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.arh = jSONObject.optDouble("realProgress");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = bVar.arg;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "progress", d);
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        long j = bVar.totalBytes;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "totalBytes", j);
        }
        long j2 = bVar.soFarBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "soFarBytes", j2);
        }
        double d2 = bVar.arh;
        if (d2 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "realProgress", d2);
        }
        return jSONObject;
    }
}
