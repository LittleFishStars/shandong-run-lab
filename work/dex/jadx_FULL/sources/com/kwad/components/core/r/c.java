package com.kwad.components.core.r;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.c.x;
import com.kwad.components.core.webview.tachikoma.d;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.d.c {
    private d wu() {
        return new d() { // from class: com.kwad.components.core.r.c.1
            @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                x xVar = new x();
                xVar.auz = a.wm().wt() + 1;
                cVar.b(xVar);
            }
        };
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        tVar.c(wu());
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.c, com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        if (!webCloseStatus.interactSuccess) {
            this.auC.mActivity.finish();
            return;
        }
        e eVar = this.auC.asx;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
    }
}
