package com.kwad.components.offline.e.a;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h implements IOfflineTKRenderListener {
    private final s ayw;

    public h(s sVar) {
        this.ayw = sVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        s sVar = this.ayw;
        if (sVar != null) {
            sVar.onFailed(th);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        s sVar = this.ayw;
        if (sVar != null) {
            sVar.onSuccess();
        }
    }
}
