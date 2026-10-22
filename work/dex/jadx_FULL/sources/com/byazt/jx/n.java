package com.byazt.jx;

import android.graphics.Path;
import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 46})
public class n implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.kd.a f28707a;
    public final sp c;
    public final boolean da;
    public final com.byazt.kd.tt i;
    public final com.byazt.kd.a n;
    public final String sp;
    public final Path.FillType tt;
    public final com.byazt.kd.uj uj;
    public final com.byazt.kd.ve ve;
    public final com.byazt.kd.tt x;

    public n(String str, sp spVar, Path.FillType fillType, com.byazt.kd.ve veVar, com.byazt.kd.uj ujVar, com.byazt.kd.a aVar, com.byazt.kd.a aVar2, com.byazt.kd.tt ttVar, com.byazt.kd.tt ttVar2, boolean z) {
        this.c = spVar;
        this.tt = fillType;
        this.ve = veVar;
        this.uj = ujVar;
        this.n = aVar;
        this.f28707a = aVar2;
        this.sp = str;
        this.x = ttVar;
        this.i = ttVar2;
        this.da = z;
    }

    public com.byazt.kd.a a() {
        return this.n;
    }

    public String c() {
        return this.sp;
    }

    public com.byazt.kd.uj n() {
        return this.uj;
    }

    public com.byazt.kd.a sp() {
        return this.f28707a;
    }

    public sp tt() {
        return this.c;
    }

    public com.byazt.kd.ve uj() {
        return this.ve;
    }

    public Path.FillType ve() {
        return this.tt;
    }

    public boolean x() {
        return this.da;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.x(xVar, aVar, veVar, this);
    }
}
