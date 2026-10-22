package com.kwad.components.core.webview.jshandler.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.core.webview.jshandler.e {

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a.a$a, reason: collision with other inner class name */
    @KsJson
    public static class C1236a extends com.kwad.sdk.core.response.a.a {
        public String arX;
    }

    @Override // com.kwad.components.core.webview.jshandler.e
    public final String bC(String str) {
        try {
            C1236a c1236a = new C1236a();
            c1236a.parseJson(new JSONObject(str));
            return c1236a.arX;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.e, com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "checkAppInstalled";
    }
}
