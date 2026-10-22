package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import com.kwad.framework.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class g implements y {
    private final h aDg = new h(com.kwad.framework.filedownloader.download.b.Ca().Cd());

    private static com.kwad.framework.filedownloader.b.a Dp() {
        return com.kwad.framework.filedownloader.download.b.Ca().Cc();
    }

    private boolean da(int i) {
        return a(Dp().cC(i));
    }

    public final boolean B(String str, String str2) {
        return da(com.kwad.framework.filedownloader.f.f.D(str, str2));
    }

    public final void CH() {
        Dp().clear();
    }

    public final void Dq() {
        List<Integer> listDt = this.aDg.Dt();
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(listDt.size()));
        }
        Iterator<Integer> it = listDt.iterator();
        while (it.hasNext()) {
            cv(it.next().intValue());
        }
    }

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean zDc = this.aDg.dc(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.cX(cVar.AH())) {
            if (!zDc) {
                return false;
            }
        } else if (!zDc) {
            com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.AH()));
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0178 A[Catch: all -> 0x01c1, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0033, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0062, B:21:0x0070, B:23:0x0076, B:25:0x007a, B:29:0x008b, B:31:0x0094, B:33:0x009d, B:35:0x00a1, B:40:0x00b4, B:43:0x00bd, B:45:0x00c6, B:47:0x00d5, B:49:0x00d9, B:51:0x00ea, B:55:0x00f4, B:57:0x00fb, B:59:0x0102, B:61:0x0108, B:63:0x010f, B:65:0x0115, B:67:0x011b, B:69:0x0131, B:70:0x0135, B:72:0x013b, B:81:0x0178, B:82:0x017b, B:73:0x0148, B:75:0x0152, B:77:0x0158, B:78:0x015e, B:44:0x00c2, B:30:0x0090), top: B:88:0x0009 }] */
    public final synchronized void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        com.kwad.framework.filedownloader.d.c cVar;
        List<com.kwad.framework.filedownloader.d.a> listCD;
        boolean z4 = false;
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
        }
        int iG = com.kwad.framework.filedownloader.f.f.g(str, str2, z);
        com.kwad.framework.filedownloader.b.a aVarDp = Dp();
        com.kwad.framework.filedownloader.d.c cVarCC = aVarDp.cC(iG);
        if (z || cVarCC != null) {
            cVar = cVarCC;
            listCD = null;
        } else {
            int iG2 = com.kwad.framework.filedownloader.f.f.g(str, com.kwad.framework.filedownloader.f.f.co(str2), true);
            com.kwad.framework.filedownloader.d.c cVarCC2 = aVarDp.cC(iG2);
            if (cVarCC2 == null || !str2.equals(cVarCC2.getTargetFilePath())) {
                listCD = null;
            } else {
                if (com.kwad.framework.filedownloader.f.d.aDr) {
                    com.kwad.framework.filedownloader.f.d.c(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(iG), Integer.valueOf(iG2));
                }
                listCD = aVarDp.cD(iG2);
            }
            cVar = cVarCC2;
        }
        if (com.kwad.framework.filedownloader.f.c.a(iG, cVar, (y) this, true)) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "has already started download %d", Integer.valueOf(iG));
            }
            return;
        }
        String targetFilePath = cVar != null ? cVar.getTargetFilePath() : com.kwad.framework.filedownloader.f.f.a(str2, z, (String) null);
        if (com.kwad.framework.filedownloader.f.c.a(iG, targetFilePath, z2, true)) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "has already completed downloading %d", Integer.valueOf(iG));
            }
            return;
        }
        if (com.kwad.framework.filedownloader.f.c.a(iG, cVar != null ? cVar.CX() : 0L, cVar != null ? cVar.Cp() : com.kwad.framework.filedownloader.f.f.cm(targetFilePath), targetFilePath, this)) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(iG), targetFilePath);
                if (cVar != null) {
                    aVarDp.cF(iG);
                    aVarDp.cE(iG);
                }
            }
            return;
        }
        if (cVar == null || !(cVar.AH() == -2 || cVar.AH() == -1 || cVar.AH() == 1 || cVar.AH() == 6 || cVar.AH() == 2)) {
            if (cVar == null) {
                cVar = new com.kwad.framework.filedownloader.d.c();
            }
            cVar.setUrl(str);
            cVar.d(str2, z);
            cVar.setId(iG);
            cVar.af(0L);
            cVar.ah(0L);
            cVar.d((byte) 1);
            cVar.cV(1);
        } else {
            if (cVar.getId() == iG) {
                if (!TextUtils.equals(str, cVar.getUrl())) {
                    cVar.setUrl(str);
                }
                if (z4) {
                    aVarDp.b(cVar);
                }
                this.aDg.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).f(Integer.valueOf(i2)).g(Integer.valueOf(i)).b(Boolean.valueOf(z2)).c(Boolean.valueOf(z3)).h(Integer.valueOf(i3)).Cq());
            }
            aVarDp.cF(cVar.getId());
            aVarDp.cE(cVar.getId());
            cVar.setId(iG);
            cVar.d(str2, z);
            if (listCD != null) {
                for (com.kwad.framework.filedownloader.d.a aVar : listCD) {
                    aVar.setId(iG);
                    aVarDp.a(aVar);
                }
            }
        }
        z4 = true;
        if (z4) {
            aVarDp.b(cVar);
        }
        this.aDg.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).f(Integer.valueOf(i2)).g(Integer.valueOf(i)).b(Boolean.valueOf(z2)).c(Boolean.valueOf(z3)).h(Integer.valueOf(i3)).Cq());
    }

    public final synchronized boolean cP(int i) {
        return this.aDg.cP(i);
    }

    public final long cR(int i) {
        com.kwad.framework.filedownloader.d.c cVarCC = Dp().cC(i);
        if (cVarCC == null) {
            return 0L;
        }
        return cVarCC.getTotal();
    }

    public final boolean cv(int i) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i));
        }
        com.kwad.framework.filedownloader.d.c cVarCC = Dp().cC(i);
        if (cVarCC == null) {
            return false;
        }
        cVarCC.d((byte) -2);
        this.aDg.cancel(i);
        return true;
    }

    public final byte cw(int i) {
        com.kwad.framework.filedownloader.d.c cVarCC = Dp().cC(i);
        if (cVarCC == null) {
            return (byte) 0;
        }
        return cVarCC.AH();
    }

    public final boolean cx(int i) {
        if (i == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        }
        if (da(i)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        }
        com.kwad.framework.filedownloader.b.a aVarDp = Dp();
        aVarDp.cF(i);
        aVarDp.cE(i);
        return true;
    }

    public final long db(int i) {
        com.kwad.framework.filedownloader.b.a aVarDp = Dp();
        com.kwad.framework.filedownloader.d.c cVarCC = aVarDp.cC(i);
        if (cVarCC == null) {
            return 0L;
        }
        int iDa = cVarCC.Da();
        if (iDa <= 1) {
            return cVarCC.CX();
        }
        List<com.kwad.framework.filedownloader.d.a> listCD = aVarDp.cD(i);
        if (listCD == null || listCD.size() != iDa) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.y(listCD);
    }

    public final boolean isIdle() {
        return this.aDg.Ds() <= 0;
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int p(String str, int i) {
        return this.aDg.p(str, i);
    }
}
