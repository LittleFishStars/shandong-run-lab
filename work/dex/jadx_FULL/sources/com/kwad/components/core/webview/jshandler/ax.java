package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ax implements com.kwad.sdk.core.webview.c.a {
    private a arq;
    private b arr;

    public interface a {
        void c(com.kwad.components.core.webview.tachikoma.f.d dVar);

        void d(com.kwad.components.core.webview.tachikoma.f.d dVar);

        void e(com.kwad.components.core.webview.tachikoma.f.d dVar);
    }

    public interface b {
        void a(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.ShakeInfo shakeInfo, AdMatrixInfo.RotateInfo rotateInfo);

        void b(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.RotateInfo rotateInfo);

        void b(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.ShakeInfo shakeInfo);
    }

    public ax(a aVar) {
        this.arq = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final com.kwad.components.core.webview.tachikoma.c.i iVar = new com.kwad.components.core.webview.tachikoma.c.i();
        try {
            iVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        com.kwad.components.core.webview.tachikoma.f.d dVar = new com.kwad.components.core.webview.tachikoma.f.d() { // from class: com.kwad.components.core.webview.jshandler.ax.1
            @Override // com.kwad.components.core.webview.tachikoma.f.d
            public final void u(int i, String str2) {
                com.kwad.components.core.webview.tachikoma.c.i iVar2 = iVar;
                iVar2.auo = str2;
                iVar2.convertType = i;
                cVar.b(iVar2);
            }
        };
        a aVar = this.arq;
        if (aVar != null) {
            int i = iVar.aun;
            if (i == 1) {
                aVar.d(dVar);
            } else if (i == 2) {
                aVar.c(dVar);
            } else if (i == 3) {
                aVar.e(dVar);
            }
        }
        b bVar = this.arr;
        if (bVar != null) {
            int i2 = iVar.aun;
            if (i2 == 1) {
                bVar.b(dVar, iVar.interactionInfo.rotateInfo);
                return;
            }
            if (i2 == 2) {
                bVar.b(dVar, iVar.interactionInfo.shakeInfo);
            } else {
                if (i2 != 3) {
                    return;
                }
                AdMatrixInfo.AdInteractionInfo adInteractionInfo = iVar.interactionInfo;
                bVar.a(dVar, adInteractionInfo.shakeInfo, adInteractionInfo.rotateInfo);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerFeedMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public ax(b bVar) {
        this.arr = bVar;
    }
}
