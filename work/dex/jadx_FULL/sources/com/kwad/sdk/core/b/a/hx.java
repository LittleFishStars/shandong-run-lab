package com.kwad.sdk.core.b.a;

import com.zj.adlib.ze1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hx implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.config.net.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.config.net.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.config.net.d) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.config.net.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.Uk = jSONObject.optString("serverExpTag");
        if (JSONObject.NULL.toString().equals(dVar.Uk)) {
            dVar.Uk = "";
        }
        dVar.streamType = jSONObject.optInt("streamType");
        dVar.liveStreamId = jSONObject.optString("liveStreamId");
        if (JSONObject.NULL.toString().equals(dVar.liveStreamId)) {
            dVar.liveStreamId = "";
        }
        dVar.Ul = jSONObject.optBoolean("multiTabLive");
        dVar.Um = jSONObject.optString("attach");
        if (JSONObject.NULL.toString().equals(dVar.Um)) {
            dVar.Um = "";
        }
        dVar.Un = jSONObject.optString(ze1.r);
        if (JSONObject.NULL.toString().equals(dVar.Un)) {
            dVar.Un = "";
        }
        dVar.Uo = jSONObject.optBoolean("isAnonymousLive");
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.config.net.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.Uk;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serverExpTag", dVar.Uk);
        }
        int i = dVar.streamType;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "streamType", i);
        }
        String str2 = dVar.liveStreamId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStreamId", dVar.liveStreamId);
        }
        boolean z = dVar.Ul;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "multiTabLive", z);
        }
        String str3 = dVar.Um;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "attach", dVar.Um);
        }
        String str4 = dVar.Un;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ze1.r, dVar.Un);
        }
        boolean z2 = dVar.Uo;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isAnonymousLive", z2);
        }
        return jSONObject;
    }
}
