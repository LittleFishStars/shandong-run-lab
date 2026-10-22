package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class s implements com.kwad.sdk.core.webview.c.a {
    private a atT;

    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.c.t tVar);
    }

    public final void a(a aVar) {
        this.atT = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showToast";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.atT = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.atT != null) {
            com.kwad.components.core.webview.tachikoma.c.t tVar = new com.kwad.components.core.webview.tachikoma.c.t();
            try {
                tVar.parseJson(new JSONObject(str));
                this.atT.a(tVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
