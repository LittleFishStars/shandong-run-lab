package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ap {
    private Map<String, com.kwad.sdk.core.webview.a> bpG;
    private Map<String, com.kwad.sdk.core.webview.c.c> bpH;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.bpG.put(str, aVar);
    }

    public final void b(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.bpH.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a hQ(String str) {
        return this.bpG.get(str);
    }

    public final com.kwad.sdk.core.webview.c.c hR(String str) {
        return this.bpH.get(str);
    }

    public final void release() {
        Iterator<com.kwad.sdk.core.webview.a> it = this.bpG.values().iterator();
        while (it.hasNext()) {
            it.next().qC();
        }
        this.bpG.clear();
        this.bpH.clear();
    }
}
