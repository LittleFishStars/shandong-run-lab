package com.kwad.sdk.core.b.a;

import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class fp implements com.kwad.sdk.core.d<com.kwad.sdk.m.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.b.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.b.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.key = jSONObject.optString(CachedContentIndex.a.e);
        if (JSONObject.NULL.toString().equals(bVar.key)) {
            bVar.key = "";
        }
        bVar.value = jSONObject.optInt("value");
    }

    private static JSONObject b(com.kwad.sdk.m.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.key;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, CachedContentIndex.a.e, bVar.key);
        }
        int i = bVar.value;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "value", i);
        }
        return jSONObject;
    }
}
