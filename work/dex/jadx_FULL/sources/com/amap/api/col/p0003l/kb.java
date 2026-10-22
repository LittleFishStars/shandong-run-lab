package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class kb extends ka implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public kb() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // com.amap.api.col.p0003l.ka
    /* JADX INFO: renamed from: a */
    public final ka clone() {
        kb kbVar = new kb(this.h, this.i);
        kbVar.a(this);
        kbVar.j = this.j;
        kbVar.k = this.k;
        kbVar.l = this.l;
        kbVar.m = this.m;
        kbVar.n = this.n;
        return kbVar;
    }

    @Override // com.amap.api.col.p0003l.ka
    public final String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + ", mcc='" + this.f25983a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }

    public kb(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }
}
