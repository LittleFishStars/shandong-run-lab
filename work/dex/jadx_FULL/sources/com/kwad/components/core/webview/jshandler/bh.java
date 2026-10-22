package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class bh implements com.kwad.sdk.core.webview.c.a {
    private a arM;

    public interface a {
        void yg();
    }

    public bh(a aVar) {
        this.arM = aVar;
    }

    private void yD() {
        if (com.kwad.components.core.e.c.b.pG()) {
            return;
        }
        by.runOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.bh.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (bh.this.arM != null) {
                    bh.this.arM.yg();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        yD();
    }
}
