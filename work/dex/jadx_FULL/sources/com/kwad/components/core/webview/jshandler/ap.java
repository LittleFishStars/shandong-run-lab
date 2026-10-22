package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ap implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b fi;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String aqZ;
    }

    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public double arg;
        public double arh;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    private KsAppDownloadListener bH(String str) {
        return new com.kwad.sdk.core.download.a.a(str) { // from class: com.kwad.components.core.webview.jshandler.ap.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (ap.this.fi.bbW != null) {
                    ap.this.a(1, 0.0f, ap.this.fi.bbW.hR(qo()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (ap.this.fi.bbW != null) {
                    ap.this.a(5, 1.0f, ap.this.fi.bbW.hR(qo()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (ap.this.fi.bbW != null) {
                    ap.this.a(1, 0.0f, ap.this.fi.bbW.hR(qo()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (ap.this.fi.bbW != null) {
                    ap.this.a(6, 1.0f, ap.this.fi.bbW.hR(qo()));
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                if (ap.this.fi.bbW != null) {
                    ap.this.a(3, (i * 1.0f) / 100.0f, ap.this.fi.bbW.hR(qo()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (ap.this.fi.bbW != null) {
                    ap.this.a(2, (i * 1.0f) / 100.0f, ap.this.fi.bbW.hR(qo()));
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.ap apVar = this.fi.bbW;
        if (apVar != null) {
            apVar.release();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.aqZ));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            adTemplate = null;
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.helper.e.eG(adTemplate) || this.fi.bbW == null) {
            return;
        }
        com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(adTemplate);
        String strQo = dVar.qo();
        dVar.b(bH(strQo));
        this.fi.bbW.a(strQo, dVar);
        this.fi.bbW.b(strQo, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.c.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.arg = f;
            bVar.status = i;
            bVar.totalBytes = com.kwad.sdk.core.response.helper.e.eO(this.fi.getAdTemplate()).totalBytes;
            long j = com.kwad.sdk.core.response.helper.e.eO(this.fi.getAdTemplate()).soFarBytes;
            bVar.soFarBytes = j;
            long j2 = bVar.totalBytes;
            if (j2 > 0) {
                bVar.arh = (j * 1.0d) / j2;
            } else {
                bVar.arh = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            cVar.b(bVar);
        }
    }
}
