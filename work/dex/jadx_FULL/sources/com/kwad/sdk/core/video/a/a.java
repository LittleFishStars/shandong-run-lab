package com.kwad.sdk.core.video.a;

import android.media.TimedText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a implements c {
    private c.f aZg;
    private c.g aZh;
    private c.h aZi;
    private c.e amN;
    private c.i amO;
    private c.b amP;
    private c.InterfaceC1289c amQ;
    private c.d amR;
    private c.a amS;

    public static void o(float f) {
        if (f == 0.0f) {
            com.kwad.sdk.core.video.a.a.a.fs("autoMute");
        } else {
            com.kwad.sdk.core.video.a.a.a.fs("autoVoice");
        }
    }

    public final void D(int i, int i2) {
        c.i iVar = this.amO;
        if (iVar != null) {
            iVar.n(i, i2);
        }
    }

    public final void OF() {
        c.f fVar = this.aZg;
        if (fVar != null) {
            fVar.xt();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.aZg = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.amN = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.amR = dVar;
    }

    public final void notifyOnBufferingUpdate(int i) {
        c.a aVar = this.amS;
        if (aVar != null) {
            aVar.br(i);
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.amP;
        if (bVar != null) {
            bVar.tK();
        }
    }

    public final boolean notifyOnError(int i, int i2) {
        com.kwad.sdk.core.video.a.a.a.fs("videoPlayError");
        c.InterfaceC1289c interfaceC1289c = this.amQ;
        return interfaceC1289c != null && interfaceC1289c.o(i, i2);
    }

    public final boolean notifyOnInfo(int i, int i2) {
        c.d dVar = this.amR;
        return dVar != null && dVar.m(i, i2);
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.amN;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnSeekComplete() {
        c.g gVar = this.aZh;
        if (gVar != null) {
            gVar.tL();
        }
    }

    public final void resetListeners() {
        this.aZg = null;
        this.amN = null;
        this.amS = null;
        this.amP = null;
        this.aZh = null;
        this.amO = null;
        this.amQ = null;
        this.amR = null;
        this.aZi = null;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.amP = bVar;
    }

    public final void b(TimedText timedText) {
        c.h hVar = this.aZi;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.amS = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.aZh = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.amO = iVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC1289c interfaceC1289c) {
        this.amQ = interfaceC1289c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.aZi = hVar;
    }
}
