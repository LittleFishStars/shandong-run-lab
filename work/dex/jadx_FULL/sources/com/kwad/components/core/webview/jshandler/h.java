package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private int HJ;
    private com.kwad.sdk.core.webview.c.c apx;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int loadType;
    }

    public h(int i) {
        this.HJ = i;
    }

    private void cc(int i) {
        if (this.apx == null) {
            return;
        }
        a aVar = new a();
        aVar.loadType = i;
        this.apx.b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.apx = cVar;
        cc(this.HJ);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getLoadInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
    }
}
