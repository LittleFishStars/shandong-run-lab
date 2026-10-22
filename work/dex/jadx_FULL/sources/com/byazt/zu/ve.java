package com.byazt.zu;

import com.byazt.cv.yp;
import com.byazt.hz.i;
import com.byazt.vx.t;
import com.byazt.vx.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 919, 54})
public class ve implements yp {
    public com.byazt.yl.ve c;
    public com.byazt.ll.tt tt;
    public i ve;

    public ve(i iVar, com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar) {
        this.c = veVar;
        this.tt = ttVar;
        this.ve = iVar;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt a() {
        com.byazt.yl.ve veVar = this.c;
        return (veVar == null || !veVar.isHasShowCallback() || z.c()) ? new com.byazt.cv.n() : new com.byazt.cv.a(t.c(this.tt, this.c, true));
    }

    @Override // com.byazt.oh.ve
    public boolean c() {
        if (this.tt == null || this.c == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c);
        com.byazt.ng.a.c(arrayList, (List<com.byazt.yl.ve>) null, (List<com.byazt.yl.ve>) null, this.tt, 0);
        return this.c.isReady(this.tt.gt());
    }

    @Override // com.byazt.cv.yp
    public void da() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            veVar.onPause();
        }
    }

    @Override // com.byazt.cv.yp
    public void i() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            veVar.onResume();
        }
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> n() {
        List<com.byazt.pp.ve> listT;
        ArrayList arrayList = new ArrayList();
        i iVar = this.ve;
        if (iVar != null && (listT = iVar.t()) != null) {
            for (com.byazt.pp.ve veVar : listT) {
                if (veVar != null) {
                    arrayList.add(new com.byazt.cv.a(veVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.cv.yp
    public boolean sp() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.hasDislike();
        }
        return false;
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.uj> tt() {
        List<com.byazt.pp.tt> listDa;
        ArrayList arrayList = new ArrayList();
        i iVar = this.ve;
        if (iVar != null && (listDa = iVar.da()) != null) {
            for (com.byazt.pp.tt ttVar : listDa) {
                if (ttVar != null) {
                    arrayList.add(new com.byazt.cv.c(ttVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt uj() {
        com.byazt.ll.tt ttVar;
        if (this.c == null || (ttVar = this.tt) == null) {
            return new com.byazt.cv.n();
        }
        return (ttVar.tk() || com.byazt.bp.tt.tt().or()) ? new com.byazt.cv.a(t.c(this.tt, this.c, false)) : new com.byazt.cv.n();
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> ve() {
        List<com.byazt.pp.ve> listSl;
        ArrayList arrayList = new ArrayList();
        i iVar = this.ve;
        if (iVar != null && (listSl = iVar.sl()) != null) {
            for (com.byazt.pp.ve veVar : listSl) {
                if (veVar != null) {
                    arrayList.add(new com.byazt.cv.a(veVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.cv.yp
    public boolean x() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.isExpressAd();
        }
        return false;
    }

    @Override // com.byazt.cv.yp
    public void c(boolean z) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            veVar.setUseCustomVideo(z);
        }
    }

    @Override // com.byazt.cv.yp
    public void c(final com.byazt.cv.z zVar) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            veVar.setGmShakeViewListener(new com.byazt.zh.n() { // from class: com.byazt.zu.ve.1
                @Override // com.byazt.zh.n
                public void c() {
                    com.byazt.cv.z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.c();
                    }
                }
            });
        }
    }
}
