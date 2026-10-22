package com.kwad.components.offline.e.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.q;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g implements IOfflineTKCallHandler {
    private final q ayv;

    public g(q qVar) {
        this.ayv = qVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        q qVar = this.ayv;
        if (qVar != null) {
            qVar.callJS(str);
        }
    }
}
