package com.kwad.components.core.innerEc.live.a;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class n implements com.kwad.sdk.core.webview.c.a {
    private final a TL;

    public interface a {
        void rx();
    }

    public n(a aVar) {
        this.TL = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.TL;
        if (aVar != null) {
            aVar.rx();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showSoftInput";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
