package com.byazt.iu;

import com.byazt.ete.ic;
import com.byazt.ete.x;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 127, 13})
public class tt {
    public int c;
    public com.byazt.dx.c n;
    public com.byazt.nhd.n tt;
    public com.byazt.dx.c uj;
    public int ve = -2;

    public tt(int i) {
        this.c = i;
        uj();
    }

    private void uj() {
        int i = this.c;
        if (i == 1) {
            this.n = new com.byazt.vvt.uj(this, i);
            this.uj = new com.byazt.sg.tt(this);
            return;
        }
        switch (i) {
            case 5:
                this.n = new com.byazt.vvt.uj(this, i);
                this.uj = new com.byazt.pro.tt(this);
                break;
            case 6:
                this.uj = new com.byazt.ob.tt(this);
                break;
            case 7:
                this.uj = new com.byazt.cf.a(this);
                break;
            case 8:
                this.uj = new com.byazt.cf.c(this);
                break;
            case 9:
                this.n = new com.byazt.vvt.uj(this, i);
                this.uj = new com.byazt.wb.tt(this);
                break;
        }
    }

    private int ve() {
        x.ve veVarC = c();
        if (veVarC == null) {
            return -2;
        }
        if (veVarC.sp() && gt.tt().br()) {
            return veVarC.uj();
        }
        return -1;
    }

    public boolean c(ic icVar) {
        return com.byazt.apd.tt.c().ve(icVar) != 3;
    }

    public com.byazt.nhd.n tt() {
        int iVe = ve();
        com.byazt.nhd.n nVar = this.tt;
        if (nVar != null && iVe == this.ve) {
            return nVar;
        }
        if (iVe == -1) {
            this.tt = new com.byazt.nhd.tt(this.c);
        } else if (iVe == 0) {
            this.tt = new com.byazt.nhd.c(this.c);
        } else if (iVe == 1) {
            this.tt = new com.byazt.nhd.uj(this.c);
        } else if (iVe != 3) {
            this.tt = c.tt(this.c);
        } else {
            this.tt = new com.byazt.nhd.ve(this.c);
        }
        this.ve = iVe;
        return this.tt;
    }

    public x.ve c() {
        return x.c(this.c);
    }

    public com.byazt.dx.c c(boolean z) {
        com.byazt.dx.c cVar;
        return (!z || (cVar = this.n) == null) ? this.uj : cVar;
    }
}
