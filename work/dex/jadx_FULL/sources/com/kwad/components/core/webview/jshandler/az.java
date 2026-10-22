package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class az extends com.kwad.components.core.webview.tachikoma.b.w {
    private boolean arv;

    public static final class a implements com.kwad.sdk.core.b {
        private String arw;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lifeStatus", this.arw);
            return jSONObject;
        }
    }

    public az() {
        this(false);
    }

    private void aG(String str) {
        a aVar = new a();
        aVar.arw = str;
        a(aVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w
    public final void a(com.kwad.sdk.core.b bVar) {
        if (!this.arv) {
            super.a(bVar);
            return;
        }
        com.kwad.sdk.core.webview.c.c cVar = this.atX;
        if (cVar != null) {
            cVar.b(bVar);
        } else {
            this.atY.add(bVar);
        }
    }

    public final void bm(boolean z) {
        this.arv = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public final void yA() {
        aG("hideEnd");
    }

    public final void yB() {
        aG("pageVisiable");
    }

    public final void yC() {
        aG("pageInvisiable");
    }

    public final void yx() {
        aG("showStart");
    }

    public final void yy() {
        aG("showEnd");
    }

    public final void yz() {
        aG("hideStart");
    }

    private az(boolean z) {
        this.arv = false;
    }
}
