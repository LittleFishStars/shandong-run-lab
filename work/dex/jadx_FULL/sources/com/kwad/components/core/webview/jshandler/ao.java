package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ao implements com.kwad.sdk.core.webview.c.a {
    private List<c> mHolders = new ArrayList();

    public static class a extends com.kwad.sdk.core.download.a.a {
        private c arc;

        public a(c cVar) {
            this.arc = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            ao.a(this.arc, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            ao.a(this.arc, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            ao.a(this.arc, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            ao.a(this.arc, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i) {
            ao.a(this.arc, 3, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            ao.a(this.arc, 2, (i * 1.0f) / 100.0f);
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
    }

    public static class c {
        private com.kwad.components.core.e.d.d ard;
        private a are;
        private AdTemplate mAdTemplate;
        private com.kwad.sdk.core.webview.c.c re;

        public c(com.kwad.components.core.e.d.d dVar, AdTemplate adTemplate) {
            this.ard = dVar;
            this.mAdTemplate = adTemplate;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.e.d.d dVar = this.ard;
            if (dVar == null || (aVar = this.are) == null) {
                return;
            }
            dVar.c(aVar);
        }

        public final long getCreativeId() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.helper.e.eY(adTemplate);
        }

        public final void a(a aVar) {
            this.ard.b(aVar);
            this.are = aVar;
        }
    }

    public ao(List<AdTemplate> list, List<com.kwad.components.core.e.d.d> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.mHolders.add(new c(list2.get(i), list.get(i)));
        }
    }

    private c X(long j) {
        if (j == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.getCreativeId() == j) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c cVarX = X(bVar.creativeId);
                if (cVarX != null) {
                    cVarX.re = cVar;
                    cVarX.a(new a(cVarX));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        Iterator<c> it = this.mHolders.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar, int i, float f) {
        if (cVar == null || cVar.re == null) {
            return;
        }
        com.kwad.sdk.core.d.c.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.re + f);
        com.kwad.sdk.core.webview.c.c cVar2 = cVar.re;
        bc.a aVar = new bc.a();
        aVar.arE = f;
        aVar.status = i;
        aVar.creativeId = cVar.getCreativeId();
        aVar.totalBytes = com.kwad.sdk.core.response.helper.e.eO(cVar.mAdTemplate).totalBytes;
        long j = com.kwad.sdk.core.response.helper.e.eO(cVar.mAdTemplate).soFarBytes;
        aVar.soFarBytes = j;
        long j2 = aVar.totalBytes;
        if (j2 > 0) {
            aVar.arF = (j * 1.0f) / j2;
        } else {
            aVar.arF = 0.0f;
        }
        cVar2.b(aVar);
    }
}
