package com.kwad.components.core.innerEc.live.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ac;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    /* JADX INFO: renamed from: com.kwad.components.core.innerEc.live.a.a$a, reason: collision with other inner class name */
    @KsJson
    public static final class C1206a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String TB;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            Map<String, String> mapRj = com.kwad.components.core.innerEc.f.rj();
            C1206a c1206a = new C1206a();
            if (mapRj == null) {
                c1206a.TB = "";
            } else {
                c1206a.TB = ac.parseMap2JSON(mapRj).toString();
            }
            cVar.b(c1206a);
        } catch (Exception e) {
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getMerchantCookie";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
