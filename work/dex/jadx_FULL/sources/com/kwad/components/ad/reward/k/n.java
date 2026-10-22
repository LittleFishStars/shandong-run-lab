package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class n extends w {

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int status;
    }

    public final void ab(boolean z) {
        a aVar = new a();
        aVar.status = z ? 1 : 0;
        a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerNeoStatusListener";
    }
}
