package com.byazt.jx;

import android.graphics.PointF;
import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 158})
public class sl implements ve {
    public final String c;
    public final boolean n;
    public final com.byazt.kd.u<PointF, PointF> tt;
    public final com.byazt.kd.tt uj;
    public final com.byazt.kd.u<PointF, PointF> ve;

    public sl(String str, com.byazt.kd.u<PointF, PointF> uVar, com.byazt.kd.u<PointF, PointF> uVar2, com.byazt.kd.tt ttVar, boolean z) {
        this.c = str;
        this.tt = uVar;
        this.ve = uVar2;
        this.uj = ttVar;
        this.n = z;
    }

    public String c() {
        return this.c;
    }

    public boolean n() {
        return this.n;
    }

    public String toString() {
        return "RectangleShape{position=" + this.tt + ", size=" + this.ve + '}';
    }

    public com.byazt.kd.tt tt() {
        return this.uj;
    }

    public com.byazt.kd.u<PointF, PointF> uj() {
        return this.tt;
    }

    public com.byazt.kd.u<PointF, PointF> ve() {
        return this.ve;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.z(xVar, veVar, this);
    }
}
