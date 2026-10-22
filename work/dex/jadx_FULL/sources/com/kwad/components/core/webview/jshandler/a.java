package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b app;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    @KsJson
    public static class C1235a extends com.kwad.sdk.core.response.a.a {
        public String PC;
        public String aps;
        public String apt;
    }

    public interface b {
        void c(C1235a c1235a);
    }

    @KsJson
    public static class c extends com.kwad.sdk.core.response.a.a {
        public int apu;
        public long apv;
        public boolean apw;
        public int errorCode;
    }

    public a(b bVar) {
        this.app = bVar;
    }

    private void b(final C1235a c1235a) {
        by.postOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.this.app != null) {
                    a.this.app.c(c1235a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C1235a c1235a = new C1235a();
            c1235a.parseJson(new JSONObject(str));
            b(c1235a);
        } catch (Throwable unused) {
        }
    }
}
