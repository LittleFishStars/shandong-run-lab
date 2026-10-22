package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ay implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c apx;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String aru;
    }

    private void aG(String str) {
        if (this.apx != null) {
            a aVar = new a();
            aVar.aru = str;
            this.apx.b(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.apx = cVar;
    }

    public final void bl(boolean z) {
        if (z) {
            aG("windowFocusGet");
        } else {
            aG("windowFocusLost");
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
    }
}
