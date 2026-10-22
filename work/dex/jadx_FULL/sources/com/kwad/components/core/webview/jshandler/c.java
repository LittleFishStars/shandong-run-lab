package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c apx;
    private com.kwad.components.core.proxy.launchdialog.b apy = ys();
    private final com.kwad.sdk.core.webview.b fi;

    public static final class a implements com.kwad.sdk.core.b {
        String PC;
        int status;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", this.PC);
            return jSONObject;
        }
    }

    public c(com.kwad.sdk.core.webview.b bVar) {
        this.fi = bVar;
        com.kwad.components.core.proxy.launchdialog.e.vJ().a(this.apy);
    }

    private com.kwad.components.core.proxy.launchdialog.b ys() {
        return new com.kwad.components.core.proxy.launchdialog.b() { // from class: com.kwad.components.core.webview.jshandler.c.1
            @Override // com.kwad.components.core.proxy.launchdialog.b
            public final void b(long j, int i) {
                try {
                    String strValueOf = String.valueOf(j);
                    AdTemplate adTemplateDU = c.this.fi.dU(strValueOf);
                    if (c.this.apx == null || adTemplateDU == null) {
                        return;
                    }
                    a aVar = new a();
                    aVar.status = i;
                    aVar.PC = strValueOf;
                    c.this.apx.b(aVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "dpInterceptPopupListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
        com.kwad.components.core.proxy.launchdialog.e.vJ().b(this.apy);
        this.apy = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.apx = cVar;
    }
}
