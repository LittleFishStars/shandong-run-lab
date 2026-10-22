package com.byazt.jx;

import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 66})
public class t implements ve {
    public final String c;
    public final boolean n;
    public final com.byazt.kd.tt tt;
    public final com.byazt.kd.t uj;
    public final com.byazt.kd.tt ve;

    public t(String str, com.byazt.kd.tt ttVar, com.byazt.kd.tt ttVar2, com.byazt.kd.t tVar, boolean z) {
        this.c = str;
        this.tt = ttVar;
        this.ve = ttVar2;
        this.uj = tVar;
        this.n = z;
    }

    public String c() {
        return this.c;
    }

    public boolean n() {
        return this.n;
    }

    public com.byazt.kd.tt tt() {
        return this.tt;
    }

    public com.byazt.kd.t uj() {
        return this.uj;
    }

    public com.byazt.kd.tt ve() {
        return this.ve;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.m(xVar, veVar, this);
    }
}
