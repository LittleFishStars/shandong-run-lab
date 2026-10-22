package com.kwad.framework.filedownloader.services;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    private final b aCV;

    public interface a {
        com.kwad.framework.filedownloader.f.c.b Cg();
    }

    public static class b {
        com.kwad.framework.filedownloader.f.c.InterfaceC1258c aCW;
        Integer aCX;
        com.kwad.framework.filedownloader.f.c.e aCY;
        com.kwad.framework.filedownloader.f.c.b aCZ;
        a aDa;
        com.kwad.framework.filedownloader.f.c.a aDb;
        com.kwad.framework.filedownloader.f.c.d aDc;

        public final b a(com.kwad.framework.filedownloader.f.c.b bVar) {
            this.aCZ = bVar;
            return this;
        }

        public final b cZ(int i) {
            this.aCX = Integer.MAX_VALUE;
            return this;
        }

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.c("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.aCW, this.aCX, this.aCY, this.aCZ, this.aDb);
        }

        public final b a(a aVar) {
            this.aDa = aVar;
            return this;
        }
    }

    public c() {
        this.aCV = null;
    }

    private static com.kwad.framework.filedownloader.f.c.d Di() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    private static int Dj() {
        return com.kwad.framework.filedownloader.f.e.Dz().aDw;
    }

    private static com.kwad.framework.filedownloader.f.c.e Dk() {
        return new com.kwad.framework.filedownloader.e.b.a();
    }

    private static com.kwad.framework.filedownloader.f.c.b Dl() {
        return new com.kwad.framework.filedownloader.a.c.b();
    }

    private static com.kwad.framework.filedownloader.f.c.a Dm() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    public final int Cd() {
        Integer num;
        b bVar = this.aCV;
        if (bVar != null && (num = bVar.aCX) != null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwad.framework.filedownloader.f.e.dd(num.intValue());
        }
        return Dj();
    }

    public final com.kwad.framework.filedownloader.b.a Dd() {
        com.kwad.framework.filedownloader.f.c.InterfaceC1258c interfaceC1258c;
        b bVar = this.aCV;
        if (bVar == null || (interfaceC1258c = bVar.aCW) == null) {
            return new com.kwad.framework.filedownloader.b.c();
        }
        com.kwad.framework.filedownloader.b.a aVarDy = interfaceC1258c.Dy();
        return aVarDy != null ? aVarDy : new com.kwad.framework.filedownloader.b.c();
    }

    public final com.kwad.framework.filedownloader.f.c.e De() {
        com.kwad.framework.filedownloader.f.c.e eVar;
        b bVar = this.aCV;
        if (bVar != null && (eVar = bVar.aCY) != null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return Dk();
    }

    public final com.kwad.framework.filedownloader.f.c.b Df() {
        com.kwad.framework.filedownloader.f.c.b bVarCg;
        b bVar = this.aCV;
        if (bVar == null) {
            return Dl();
        }
        a aVar = bVar.aDa;
        return (aVar == null || (bVarCg = aVar.Cg()) == null) ? Dl() : bVarCg;
    }

    public final com.kwad.framework.filedownloader.f.c.a Dg() {
        com.kwad.framework.filedownloader.f.c.a aVar;
        b bVar = this.aCV;
        if (bVar != null && (aVar = bVar.aDb) != null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return Dm();
    }

    public final com.kwad.framework.filedownloader.f.c.d Dh() {
        com.kwad.framework.filedownloader.f.c.d dVar;
        b bVar = this.aCV;
        if (bVar != null && (dVar = bVar.aDc) != null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return Di();
    }

    public c(b bVar) {
        this.aCV = bVar;
    }
}
