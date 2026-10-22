package com.byazt.ete;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 127})
public class iu {
    public int c;
    public int tt;
    public int ve;
    public int uj = 1;
    public int n = 0;

    private int a() {
        return com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext(), com.byazt.aas.pf.n(com.byazt.omf.gt.getContext()));
    }

    private int sp() {
        return com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext(), com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext()));
    }

    public int c() {
        return this.c;
    }

    public int n() {
        return this.n;
    }

    public int tt() {
        return this.tt;
    }

    public int uj() {
        return this.uj == 2 ? 2 : 1;
    }

    public int ve() {
        return this.ve;
    }

    public void c(int i) {
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            this.c = i;
        } else {
            this.c = 2;
        }
    }

    public void n(int i) {
        this.n = i;
    }

    public void tt(int i) {
        if (i <= 0 || i >= sp()) {
            this.tt = 16;
        } else {
            this.tt = i;
        }
    }

    public void uj(int i) {
        this.uj = i;
    }

    public void ve(int i) {
        if (i > 0 && i < a()) {
            this.ve = i;
            return;
        }
        int i2 = this.c;
        if (i2 == 3 || i2 == 4) {
            this.ve = 30;
        } else {
            this.ve = 16;
        }
    }

    public static boolean c(ic icVar) {
        return (icVar == null || icVar.cg() == null || icVar.cg().n() != 1) ? false : true;
    }
}
