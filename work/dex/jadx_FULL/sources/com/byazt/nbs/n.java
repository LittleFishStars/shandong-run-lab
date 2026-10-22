package com.byazt.nbs;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1871, 46})
public class n implements Comparable<n> {
    public String c;
    public double tt;
    public int uj;
    public int ve;

    public n(String str, double d, int i, int i2) {
        this.c = str;
        this.tt = d;
        this.ve = i;
        this.uj = i2;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        return "{mCsjRitId:" + this.c + ",mEcpm:" + this.tt + ",mLoadSort:" + this.ve + ",mShowSort:" + this.uj + "}";
    }

    public double tt() {
        return this.tt;
    }

    public int uj() {
        return this.uj;
    }

    public int ve() {
        return this.ve;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(n nVar) {
        if (nVar == null) {
            return 1;
        }
        if (this.tt > nVar.tt()) {
            return -1;
        }
        if (this.tt < nVar.tt() || this.ve > nVar.ve()) {
            return 1;
        }
        if (this.ve < nVar.ve()) {
            return -1;
        }
        if (this.uj > nVar.uj()) {
            return 1;
        }
        return this.uj < nVar.uj() ? -1 : 0;
    }
}
