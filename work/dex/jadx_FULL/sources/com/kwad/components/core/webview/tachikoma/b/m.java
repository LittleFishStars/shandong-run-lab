package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class m extends w {
    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
    }

    public final void ci(int i) {
        com.kwad.components.core.webview.tachikoma.c.v vVar = new com.kwad.components.core.webview.tachikoma.c.v();
        vVar.rq = i;
        super.a(vVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerSplashProgressListener";
    }
}
