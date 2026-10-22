package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC1252a> aAo = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.e
    public final void Bi() {
        w wVarBJ = r.BG().BJ();
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.aAo) {
            List<a.InterfaceC1252a> list = (List) this.aAo.clone();
            this.aAo.clear();
            ArrayList arrayList = new ArrayList(wVarBJ.BN());
            for (a.InterfaceC1252a interfaceC1252a : list) {
                int iAR = interfaceC1252a.AR();
                if (wVarBJ.cz(iAR)) {
                    interfaceC1252a.AP().Aw().AX();
                    if (!arrayList.contains(Integer.valueOf(iAR))) {
                        arrayList.add(Integer.valueOf(iAR));
                    }
                } else {
                    interfaceC1252a.AV();
                }
            }
            wVarBJ.w(arrayList);
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void Bj() {
        if (Bk() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (h.Bn().size() > 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.Bn().size()));
                return;
            }
            return;
        }
        w wVarBJ = r.BG().BJ();
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.Bn().size()));
        }
        if (h.Bn().size() > 0) {
            synchronized (this.aAo) {
                h.Bn().v(this.aAo);
                Iterator<a.InterfaceC1252a> it = this.aAo.iterator();
                while (it.hasNext()) {
                    it.next().free();
                }
                wVarBJ.BM();
            }
            r.BG().BH();
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC1252a interfaceC1252a) {
        return !this.aAo.isEmpty() && this.aAo.contains(interfaceC1252a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC1252a interfaceC1252a) {
        if (this.aAo.isEmpty()) {
            return;
        }
        synchronized (this.aAo) {
            this.aAo.remove(interfaceC1252a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC1252a interfaceC1252a) {
        r.BG();
        if (!r.BI()) {
            synchronized (this.aAo) {
                r.BG();
                if (!r.BI()) {
                    if (com.kwad.framework.filedownloader.f.d.aDr) {
                        com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC1252a.AP().getId()));
                    }
                    n.By().aW(com.kwad.framework.filedownloader.f.c.Dx());
                    if (!this.aAo.contains(interfaceC1252a)) {
                        interfaceC1252a.free();
                        this.aAo.add(interfaceC1252a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC1252a);
        return false;
    }
}
