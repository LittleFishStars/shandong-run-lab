package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hu implements com.kwad.sdk.core.d<com.kwad.components.core.page.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.page.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.page.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.page.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adStyle = jSONObject.optInt("ad_style");
        aVar.adJ = jSONObject.optInt("neo_tk_render_type");
    }

    private static JSONObject b(com.kwad.components.core.page.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_style", i);
        }
        int i2 = aVar.adJ;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "neo_tk_render_type", i2);
        }
        return jSONObject;
    }
}
