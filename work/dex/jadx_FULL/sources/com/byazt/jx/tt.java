package com.byazt.jx;

import android.graphics.PointF;
import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 13})
public class tt implements ve {
    public final String c;
    public final boolean n;
    public final com.byazt.kd.u<PointF, PointF> tt;
    public final boolean uj;
    public final com.byazt.kd.a ve;

    public tt(String str, com.byazt.kd.u<PointF, PointF> uVar, com.byazt.kd.a aVar, boolean z, boolean z2) {
        this.c = str;
        this.tt = uVar;
        this.ve = aVar;
        this.uj = z;
        this.n = z2;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.a(xVar, veVar, this);
    }

    public boolean n() {
        return this.n;
    }

    public com.byazt.kd.u<PointF, PointF> tt() {
        return this.tt;
    }

    public boolean uj() {
        return this.uj;
    }

    public com.byazt.kd.a ve() {
        return this.ve;
    }

    public String c() {
        return this.c;
    }
}
