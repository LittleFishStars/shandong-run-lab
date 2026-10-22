package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    private OfflineOnAudioConflictListener CH = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.b.x.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.cj(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.cj(3);
        }
    };
    private com.kwad.sdk.core.webview.c.c aqe;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean auc;
        public int aud;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(int i) {
        a aVar = new a();
        aVar.auc = com.kwad.components.core.t.a.aO(ServiceProvider.getContext()).wD();
        aVar.aud = i;
        com.kwad.sdk.core.webview.c.c cVar = this.aqe;
        if (cVar != null) {
            cVar.b(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.t.a.aO(ServiceProvider.getContext()).b(this.CH);
        this.aqe = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.aqe = cVar;
        com.kwad.components.core.t.a.aO(ServiceProvider.getContext()).a(this.CH);
        cj(1);
    }
}
