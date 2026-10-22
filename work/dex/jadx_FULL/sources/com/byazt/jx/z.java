package com.byazt.jx;

import android.graphics.Path;
import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 133})
public class z implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f28709a;
    public final boolean c;
    public final com.byazt.kd.uj n;
    public final Path.FillType tt;
    public final com.byazt.kd.c uj;
    public final String ve;

    public z(String str, boolean z, Path.FillType fillType, com.byazt.kd.c cVar, com.byazt.kd.uj ujVar, boolean z2) {
        this.ve = str;
        this.c = z;
        this.tt = fillType;
        this.uj = cVar;
        this.n = ujVar;
        this.f28709a = z2;
    }

    public String c() {
        return this.ve;
    }

    public boolean n() {
        return this.f28709a;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.c + '}';
    }

    public com.byazt.kd.c tt() {
        return this.uj;
    }

    public Path.FillType uj() {
        return this.tt;
    }

    public com.byazt.kd.uj ve() {
        return this.n;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.sp(xVar, veVar, this);
    }
}
