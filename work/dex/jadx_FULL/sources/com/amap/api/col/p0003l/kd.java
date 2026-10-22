package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class kd extends ka implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public kd() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ka
    /* JADX INFO: renamed from: a */
    public final ka clone() {
        kd kdVar = new kd(this.h);
        kdVar.a(this);
        kdVar.j = this.j;
        kdVar.k = this.k;
        kdVar.l = this.l;
        kdVar.m = this.m;
        kdVar.n = this.n;
        return kdVar;
    }

    @Override // com.amap.api.col.p0003l.ka
    public final String toString() {
        return "AmapCellLte{tac=" + this.j + ", ci=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + ", mcc='" + this.f25983a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }

    public kd(boolean z) {
        super(z, true);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }
}
