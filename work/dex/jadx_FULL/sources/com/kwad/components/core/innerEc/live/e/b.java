package com.kwad.components.core.innerEc.live.e;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ILiveLongConnection;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.LiveLongConnectionServerException;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {

    @NonNull
    private final ILiveLongConnection UH;

    @NonNull
    private final c Xp;
    private boolean Xq = true;
    private final LongConnectStatusListener Xr;

    public b(@NonNull ILiveLongConnection iLiveLongConnection, @NonNull c cVar) {
        d dVar = new d() { // from class: com.kwad.components.core.innerEc.live.e.b.1
            @Override // com.kwad.components.core.innerEc.live.e.d, com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
            public final void onServerException(LiveLongConnectionServerException liveLongConnectionServerException) {
                com.kwad.sdk.core.d.c.e("LiveLongConnectHelper", "onServerException errorCode: " + liveLongConnectionServerException.errorCode + " ,subCode:" + liveLongConnectionServerException.subCode + " ,errorMessage:" + liveLongConnectionServerException.errorMessage);
                if (b.this.Xp.rP()) {
                    if (a.ba(liveLongConnectionServerException.errorCode) || a.bb(liveLongConnectionServerException.errorCode)) {
                        b.a(b.this, false);
                    } else {
                        com.kwad.sdk.core.d.c.e("LiveLongConnectHelper", "onServerException", liveLongConnectionServerException);
                    }
                    b.this.Xp.a(liveLongConnectionServerException);
                }
            }
        };
        this.Xr = dVar;
        this.UH = iLiveLongConnection;
        this.Xp = cVar;
        iLiveLongConnection.registerLongConnectStatusListener(dVar);
    }

    public final void destroy() {
        this.UH.unregisterLongConnectStatusListener(this.Xr);
        this.Xq = true;
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.Xq = false;
        return false;
    }
}
