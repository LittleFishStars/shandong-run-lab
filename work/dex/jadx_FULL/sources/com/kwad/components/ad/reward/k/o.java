package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o extends w implements as.b {

    @Nullable
    private com.kwad.components.core.playable.a sA;

    public o(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar = gVar.sA;
        this.sA = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        a((com.kwad.sdk.core.b) aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.sA;
        if (aVar != null) {
            aVar.b(this);
            this.sA = null;
        }
    }
}
