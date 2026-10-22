package com.byazt.jx;

import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 67})
public class u implements ve {
    public final String c;
    public final com.byazt.kd.u<Float, Float> tt;

    public u(String str, com.byazt.kd.u<Float, Float> uVar) {
        this.c = str;
        this.tt = uVar;
    }

    public String c() {
        return this.c;
    }

    public com.byazt.kd.u<Float, Float> tt() {
        return this.tt;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.nu(xVar, veVar, this);
    }
}
