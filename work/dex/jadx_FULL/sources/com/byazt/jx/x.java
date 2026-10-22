package com.byazt.jx;

import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 71})
public class x {
    public final c c;
    public final com.byazt.kd.x tt;
    public final boolean uj;
    public final com.byazt.kd.uj ve;

    public enum c {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public x(c cVar, com.byazt.kd.x xVar, com.byazt.kd.uj ujVar, boolean z) {
        this.c = cVar;
        this.tt = xVar;
        this.ve = ujVar;
        this.uj = z;
    }

    public c c() {
        return this.c;
    }

    public com.byazt.kd.x tt() {
        return this.tt;
    }

    public boolean uj() {
        return this.uj;
    }

    public com.byazt.kd.uj ve() {
        return this.ve;
    }
}
