package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class m implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.e.d.d QS;
    private KsAppDownloadListener aph;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.sdk.core.webview.c.c re;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String apH;
        public String packageName;
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int apI;
        public int progress;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    public m(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    private synchronized void r(String str, String str2) {
        this.QS = new com.kwad.components.core.e.d.d(this.mAdTemplate, null, str, str2);
        if (this.aph == null) {
            KsAppDownloadListener ksAppDownloadListenerYr = yr();
            this.aph = ksAppDownloadListenerYr;
            this.QS.b(ksAppDownloadListenerYr);
        }
    }

    private static boolean s(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private KsAppDownloadListener yr() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.m.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                m.this.s(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                m.this.s(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                m.this.s(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                m.this.s(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                m.this.s(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    m.this.s(1, 0);
                } else {
                    m.this.s(2, i);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "installAppForDownload";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.re = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i, int i2) {
        if (this.re != null) {
            b bVar = new b();
            bVar.status = i;
            bVar.progress = i2;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                bVar.totalBytes = com.kwad.sdk.core.response.helper.e.eO(adTemplate).totalBytes;
                long j = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate).soFarBytes;
                bVar.soFarBytes = j;
                long j2 = bVar.totalBytes;
                if (j2 > 0) {
                    bVar.apI = (int) ((j * 100.0f) / j2);
                } else {
                    bVar.apI = 0;
                }
            }
            this.re.b(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.re = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (s(aVar.apH, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.QS == null) {
                r(aVar.apH, aVar.packageName);
            }
            com.kwad.components.core.e.d.a.C1201a c1201aAv = new com.kwad.components.core.e.d.a.C1201a(this.mContext).as(true).at(false).aJ(this.mAdTemplate).av(false);
            if (this.QS.w(c1201aAv)) {
                return;
            }
            this.QS.d(this.aph);
            this.QS.v(c1201aAv);
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }
}
