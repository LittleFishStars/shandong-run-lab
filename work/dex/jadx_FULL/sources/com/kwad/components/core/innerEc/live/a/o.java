package com.kwad.components.core.innerEc.live.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String TM;

        public a() {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.TM = String.valueOf(com.kwad.components.core.innerEc.e.rf().getUserId());
            cVar.b(aVar);
        } catch (Exception e) {
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKwaiUserID";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
