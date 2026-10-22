package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o extends w {
    private a atS;

    public interface a {
        boolean isMuted();
    }

    public final void a(a aVar) {
        this.atS = aVar;
    }

    public final void c(com.kwad.components.core.webview.tachikoma.c.n nVar) {
        super.a(nVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMuteStateListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        if (this.atS != null) {
            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
            nVar.aut = this.atS.isMuted();
            cVar.b(nVar);
        }
    }
}
