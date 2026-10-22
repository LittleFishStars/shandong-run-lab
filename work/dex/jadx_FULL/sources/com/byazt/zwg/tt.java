package com.byazt.zwg;

import com.byazt.cv.a;
import com.byazt.cv.n;
import com.byazt.hz.t;
import com.byazt.oh.uj;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1061, 13})
public class tt implements com.byazt.bz.ve {
    public t c;

    public tt(t tVar) {
        this.c = tVar;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt a() {
        t tVar = this.c;
        return tVar != null ? new a(tVar.f_()) : new n();
    }

    @Override // com.byazt.oh.ve
    public boolean c() {
        t tVar = this.c;
        if (tVar != null) {
            return tVar.p();
        }
        return false;
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> n() {
        List<com.byazt.pp.ve> listT;
        ArrayList arrayList = new ArrayList();
        t tVar = this.c;
        if (tVar != null && (listT = tVar.t()) != null) {
            for (com.byazt.pp.ve veVar : listT) {
                if (veVar != null) {
                    arrayList.add(new a(veVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.bz.ve
    public void sp() {
        t tVar = this.c;
        if (tVar != null) {
            tVar.ve();
        }
    }

    @Override // com.byazt.oh.ve
    public List<uj> tt() {
        List<com.byazt.pp.tt> listDa;
        ArrayList arrayList = new ArrayList();
        t tVar = this.c;
        if (tVar != null && (listDa = tVar.da()) != null) {
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
        t tVar = this.c;
        return tVar != null ? new a(tVar.z()) : new n();
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> ve() {
        List<com.byazt.pp.ve> listSl;
        ArrayList arrayList = new ArrayList();
        t tVar = this.c;
        if (tVar != null && (listSl = tVar.sl()) != null) {
            for (com.byazt.pp.ve veVar : listSl) {
                if (veVar != null) {
                    arrayList.add(new a(veVar));
                }
            }
        }
        return arrayList;
    }
}
