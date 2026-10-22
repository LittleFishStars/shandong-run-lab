package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bp implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.x.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.b.x.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.b.x.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.b.x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.auc = jSONObject.optBoolean("hasLoseAudioFocus");
        aVar.aud = jSONObject.optInt("audioFocusStatus");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.b.x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.auc;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "hasLoseAudioFocus", z);
        }
        int i = aVar.aud;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "audioFocusStatus", i);
        }
        return jSONObject;
    }
}
