package com.kwad.components.ad.h.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.c.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private c re;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        this.re = cVar;
    }

    public final void ga() {
        c cVar = this.re;
        if (cVar != null) {
            cVar.b(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.re = null;
    }
}
