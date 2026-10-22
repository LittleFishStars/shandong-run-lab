package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h {
    private final ArrayList<com.kwad.framework.filedownloader.a.InterfaceC1252a> azI;

    public static final class a {
        private static final h azJ = new h(0);
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h Bn() {
        return a.azJ;
    }

    public final boolean a(com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252a) {
        return this.azI.isEmpty() || !this.azI.contains(interfaceC1252a);
    }

    public final void b(com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252a) {
        if (!interfaceC1252a.AP().Ay()) {
            interfaceC1252a.AS();
        }
        if (interfaceC1252a.AQ().Bf().Bs()) {
            c(interfaceC1252a);
        }
    }

    public final void c(com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252a) {
        if (interfaceC1252a.AT()) {
            return;
        }
        synchronized (this.azI) {
            if (this.azI.contains(interfaceC1252a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC1252a);
            } else {
                interfaceC1252a.AU();
                this.azI.add(interfaceC1252a);
                if (com.kwad.framework.filedownloader.f.d.aDr) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC1252a, Byte.valueOf(interfaceC1252a.AP().AH()), Integer.valueOf(this.azI.size()));
                }
            }
        }
    }

    public final int cr(int i) {
        int i2;
        synchronized (this.azI) {
            Iterator<com.kwad.framework.filedownloader.a.InterfaceC1252a> it = this.azI.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().cq(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public final List<com.kwad.framework.filedownloader.a.InterfaceC1252a> cs(int i) {
        byte bAH;
        ArrayList arrayList = new ArrayList();
        synchronized (this.azI) {
            for (com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252a : this.azI) {
                if (interfaceC1252a.cq(i) && !interfaceC1252a.isOver() && (bAH = interfaceC1252a.AP().AH()) != 0 && bAH != 10) {
                    arrayList.add(interfaceC1252a);
                }
            }
        }
        return arrayList;
    }

    public final List<com.kwad.framework.filedownloader.a.InterfaceC1252a> ct(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.azI) {
            for (com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252a : this.azI) {
                if (interfaceC1252a.cq(i) && !interfaceC1252a.isOver()) {
                    arrayList.add(interfaceC1252a);
                }
            }
        }
        return arrayList;
    }

    public final int size() {
        return this.azI.size();
    }

    public final void v(List<com.kwad.framework.filedownloader.a.InterfaceC1252a> list) {
        synchronized (this.azI) {
            for (com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252a : this.azI) {
                if (!list.contains(interfaceC1252a)) {
                    list.add(interfaceC1252a);
                }
            }
            this.azI.clear();
        }
    }

    private h() {
        this.azI = new ArrayList<>();
    }

    public final boolean a(com.kwad.framework.filedownloader.a.InterfaceC1252a interfaceC1252a, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bAH = messageSnapshot.AH();
        synchronized (this.azI) {
            zRemove = this.azI.remove(interfaceC1252a);
        }
        if (com.kwad.framework.filedownloader.f.d.aDr && this.azI.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC1252a, Byte.valueOf(bAH), Integer.valueOf(this.azI.size()));
        }
        if (zRemove) {
            t tVarBf = interfaceC1252a.AQ().Bf();
            if (bAH == -4) {
                tVarBf.l(messageSnapshot);
            } else if (bAH == -3) {
                tVarBf.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (bAH == -2) {
                tVarBf.n(messageSnapshot);
            } else if (bAH == -1) {
                tVarBf.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC1252a, Byte.valueOf(bAH));
        }
        return zRemove;
    }
}
