package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.by;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class x implements com.kwad.sdk.core.webview.c.a {
    public void a(com.kwad.components.core.webview.tachikoma.c.y yVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.components.core.webview.tachikoma.c.y yVar = new com.kwad.components.core.webview.tachikoma.c.y();
        try {
            yVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        by.runOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.x.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (yVar.zr()) {
                    x.this.b(yVar);
                    return;
                }
                if (yVar.zt()) {
                    x.this.d(yVar);
                } else if (yVar.zs()) {
                    x.this.c(yVar);
                } else if (yVar.isFailed()) {
                    x.this.a(yVar);
                }
            }
        });
    }

    public void b(com.kwad.components.core.webview.tachikoma.c.y yVar) {
    }

    public void c(com.kwad.components.core.webview.tachikoma.c.y yVar) {
    }

    public void d(com.kwad.components.core.webview.tachikoma.c.y yVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateVideoPlayStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
