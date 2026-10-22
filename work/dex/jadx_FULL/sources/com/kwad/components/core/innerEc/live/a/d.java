package com.kwad.components.core.innerEc.live.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends w {

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean TE;

        public static a rw() {
            return new a();
        }

        public final a aK(boolean z) {
            this.TE = true;
            return this;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveEndListener";
    }
}
