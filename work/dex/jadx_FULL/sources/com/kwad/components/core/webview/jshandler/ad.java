package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.byazt.dyf.tt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b apJ;
    private a aql;
    private Handler jk = new Handler(Looper.getMainLooper());

    public interface a {
        void cQ();
    }

    public ad(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.apJ = bVar;
        this.aql = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return tt.AD_TAG_DISLIKE;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.jk.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.jk.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ad.this.aql.cQ();
            }
        });
        cVar.b(null);
    }
}
