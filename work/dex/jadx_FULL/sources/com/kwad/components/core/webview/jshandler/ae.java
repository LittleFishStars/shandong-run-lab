package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ae implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b apJ;
    protected c aqn;
    private d qF;

    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.ac.putValue(jSONObject, "width", this.width);
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    public static class b extends a {
        public d aqp;
    }

    public interface c {
        void c(a aVar);
    }

    public interface d {
        void u(int i, int i2);
    }

    public ae(com.kwad.sdk.core.webview.b bVar) {
        this.apJ = bVar;
    }

    public final void a(c cVar) {
        this.aqn = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        b bVar = new b();
        if (this.qF == null) {
            this.qF = new d() { // from class: com.kwad.components.core.webview.jshandler.ae.1
                @Override // com.kwad.components.core.webview.jshandler.ae.d
                public final void u(int i, int i2) {
                    a aVar = new a();
                    aVar.width = i;
                    aVar.height = i2;
                    cVar.b(aVar);
                }
            };
        }
        bVar.aqp = this.qF;
        a aVar = new a();
        c cVar2 = this.aqn;
        if (cVar2 != null) {
            cVar2.c(bVar);
            aVar.height = bVar.height;
            aVar.width = bVar.width;
        } else {
            aVar.width = this.apJ.adW.getWidth();
            aVar.height = this.apJ.adW.getHeight();
        }
        cVar.b(aVar);
    }
}
