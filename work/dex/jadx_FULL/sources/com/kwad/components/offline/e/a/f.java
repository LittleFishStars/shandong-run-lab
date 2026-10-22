package com.kwad.components.offline.e.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.c.g ayu;

    public f(com.kwad.sdk.core.webview.c.g gVar) {
        this.ayu = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.c.g gVar = this.ayu;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
