package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class u extends w {
    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        com.kwad.sdk.core.d.c.w("jky", "UpdateRewardTopBarHandler handleJsCall " + cVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateRewardTopBar";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.core.d.c.w("jky", "UpdateRewardTopBarHandler destroy");
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w
    public final void a(com.kwad.sdk.core.b bVar) {
        super.a(bVar);
        com.kwad.sdk.core.d.c.w("jky", "UpdateRewardTopBarHandler setData " + bVar);
    }
}
