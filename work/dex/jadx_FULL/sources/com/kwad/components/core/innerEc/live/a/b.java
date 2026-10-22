package com.kwad.components.core.innerEc.live.a;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private final a TC;

    public interface a {
        void aJ(boolean z);
    }

    public b(a aVar) {
        this.TC = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        boolean zOptBoolean;
        if (this.TC != null) {
            try {
                zOptBoolean = new JSONObject(str).optBoolean("isHide");
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
                zOptBoolean = false;
            }
            this.TC.aJ(zOptBoolean);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "explainCardHide";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
