package com.byazt.ete;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 957})
public class r {
    public int c;
    public int tt;
    public int ve;

    private int uj() {
        return com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext(), com.byazt.aas.pf.n(com.byazt.omf.gt.getContext()));
    }

    public int c() {
        return this.c;
    }

    public int tt() {
        return this.tt;
    }

    public int ve() {
        return this.ve;
    }

    public void c(int i) {
        if (i != 1 && i != 2) {
            i = 0;
        }
        this.c = i;
    }

    public void tt(int i) {
        if (i > 0 && i < uj()) {
            this.tt = i;
            return;
        }
        int i2 = this.c;
        if (i2 == 1) {
            this.tt = 90;
        } else if (i2 == 2) {
            this.tt = 150;
        }
    }

    public void ve(int i) {
        if (i > 0 && i < uj()) {
            this.ve = i;
            return;
        }
        int i2 = this.c;
        if (i2 == 1) {
            this.ve = 90;
        } else if (i2 == 2) {
            this.ve = 150;
        }
    }
}
