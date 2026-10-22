package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private List<AdTemplate> apT;
    private com.kwad.sdk.core.webview.b fi;
    private b st;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    public interface b {
        void aa(AdTemplate adTemplate);
    }

    public y(List<AdTemplate> list) {
        this.apT = list;
    }

    private List<AdTemplate> yt() {
        List<AdTemplate> list = this.apT;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.fi;
        if (bVar != null) {
            return bVar.Pu();
        }
        return null;
    }

    public final void a(b bVar) {
        this.st = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate adTemplateA = com.kwad.sdk.core.response.helper.e.a(yt(), aVar.creativeId, aVar.adStyle);
            b bVar = this.st;
            if (bVar != null) {
                bVar.aa(adTemplateA);
            }
        } catch (JSONException unused) {
        }
    }

    public y(com.kwad.sdk.core.webview.b bVar) {
        this.fi = bVar;
    }
}
