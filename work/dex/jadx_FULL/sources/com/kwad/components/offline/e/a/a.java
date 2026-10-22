package com.kwad.components.offline.e.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements com.kwad.sdk.core.webview.c.c {
    private final IOfflineCompoCallBackFunction ayi;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.ayi = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void b(final com.kwad.sdk.core.b bVar) {
        if (com.kwad.sdk.core.config.e.JN()) {
            GlobalThreadPools.Oi().submit(new Runnable() { // from class: com.kwad.components.offline.e.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    final String string = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
                    by.runOnUiThread(new Runnable() { // from class: com.kwad.components.offline.e.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.ayi != null) {
                                a.this.ayi.onSuccess(string);
                            }
                        }
                    });
                }
            });
            return;
        }
        String string = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.ayi;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(string);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void onError(int i, String str) {
        String string = new com.kwad.sdk.core.webview.c.e(i, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.ayi;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(string);
        }
    }
}
