package com.kwad.components.core.innerEc.live.b.c;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ILiveLongConnection;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ServerException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.core.innerEc.live.b.a.a {
    private ILiveLongConnection UH;
    private com.kwad.components.core.innerEc.live.config.b UV;
    private com.kwad.components.core.innerEc.live.e.b UX;
    private boolean UW = false;
    private final com.kwad.components.core.innerEc.live.config.a UY = new com.kwad.components.core.innerEc.live.config.a() { // from class: com.kwad.components.core.innerEc.live.b.c.b.2
        @Override // com.kwad.components.core.innerEc.live.config.a
        public final void a(@NonNull com.kwad.components.core.innerEc.live.config.net.g gVar) {
        }

        @Override // com.kwad.components.core.innerEc.live.config.a
        public final void b(@NonNull com.kwad.components.core.innerEc.live.config.net.g gVar) {
            b.this.rO();
        }
    };

    private void aK(String str) {
        if (this.UW) {
            return;
        }
        this.UW = true;
        com.kwad.sdk.core.d.c.i("LiveAudienceLongConnectionPresenter", "destroyConnection , reason" + str);
        ILiveLongConnection iLiveLongConnection = this.UH;
        if (iLiveLongConnection != null) {
            iLiveLongConnection.release();
        }
        com.kwad.components.core.innerEc.live.e.b bVar = this.UX;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    private void rL() {
        this.UX = new com.kwad.components.core.innerEc.live.e.b(this.UH, new com.kwad.components.core.innerEc.live.e.c() { // from class: com.kwad.components.core.innerEc.live.b.c.b.1
            @Override // com.kwad.components.core.innerEc.live.e.c
            public final void a(ServerException serverException) {
                b.this.Ub.UJ.h(serverException);
            }

            @Override // com.kwad.components.core.innerEc.live.e.c
            public final boolean rP() {
                return b.this.Ub.UC.isAdded();
            }
        });
    }

    private void rM() {
        ILiveLongConnection iLiveLongConnection = this.UH;
        if (iLiveLongConnection != null) {
            iLiveLongConnection.attached();
        }
    }

    private void rN() {
        ILiveLongConnection iLiveLongConnection = this.UH;
        if (iLiveLongConnection != null) {
            iLiveLongConnection.detached();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO() {
        ILiveLongConnection iLiveLongConnection = this.UH;
        if (iLiveLongConnection != null) {
            iLiveLongConnection.resume();
            this.UW = false;
        }
    }

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.innerEc.live.b.a.b bVar = this.Ub;
        this.UH = bVar.UH;
        this.UV = bVar.UF;
        rL();
        this.UV.a(this.UY);
        rM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        rN();
        this.UV.b(this.UY);
        aK("onUnbind");
    }
}
