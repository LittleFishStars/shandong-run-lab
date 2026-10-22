package com.byazt.jx;

import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 137})
public class nu implements ve {
    public final String c;
    public final int tt;
    public final boolean uj;
    public final com.byazt.kd.x ve;

    public nu(String str, int i, com.byazt.kd.x xVar, boolean z) {
        this.c = str;
        this.tt = i;
        this.ve = xVar;
        this.uj = z;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        return "ShapePath{name=" + this.c + ", index=" + this.tt + '}';
    }

    public com.byazt.kd.x tt() {
        return this.ve;
    }

    public boolean ve() {
        return this.uj;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.rh(xVar, veVar, this);
    }
}
