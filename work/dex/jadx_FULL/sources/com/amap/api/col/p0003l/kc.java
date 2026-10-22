package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class kc extends ka implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public kc() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ka
    /* JADX INFO: renamed from: a */
    public final ka clone() {
        kc kcVar = new kc(this.h, this.i);
        kcVar.a(this);
        kcVar.j = this.j;
        kcVar.k = this.k;
        kcVar.l = this.l;
        kcVar.m = this.m;
        kcVar.n = this.n;
        kcVar.o = this.o;
        return kcVar;
    }

    @Override // com.amap.api.col.p0003l.ka
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + ", mcc='" + this.f25983a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }

    public kc(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }
}
