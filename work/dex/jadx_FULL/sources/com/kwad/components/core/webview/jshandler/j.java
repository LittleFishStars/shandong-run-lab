package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j implements com.kwad.sdk.core.webview.c.a {
    private p apB;
    private com.kwad.sdk.core.webview.c.c apx;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String apC;

        public final String getTarget() {
            return this.apC;
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int aaV;
        public int apD;
        public int apE;
        public String apF;
        public int convertCount;
    }

    public j(p pVar) {
        this.apB = pVar;
    }

    public final void V(long j) {
        b bVar = new b();
        bVar.apF = Long.toString(j);
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.apx = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String target = aVar.getTarget();
            p pVar = this.apB;
            if (pVar != null) {
                pVar.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    public final void bk(boolean z) {
        b bVar = new b();
        bVar.apE = z ? 1 : 0;
        a(bVar);
    }

    public final void cc(int i) {
        b bVar = new b();
        bVar.aaV = i;
        a(bVar);
    }

    public final void cd(int i) {
        b bVar = new b();
        bVar.convertCount = i;
        a(bVar);
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        b bVar = new b();
        bVar.apD = playableSource.getCode();
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getNativeData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
    }

    public final void a(com.kwad.sdk.core.response.a.a aVar) {
        com.kwad.sdk.core.webview.c.c cVar = this.apx;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.b(aVar);
    }
}
