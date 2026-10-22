package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private a BV;

    public interface a {
        void ks();
    }

    public final void a(a aVar) {
        this.BV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.BV = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.BV;
        if (aVar != null) {
            aVar.ks();
        }
    }
}
