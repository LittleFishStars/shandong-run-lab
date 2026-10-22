package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ke extends ka implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;

    public ke() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ka
    /* JADX INFO: renamed from: a */
    public final ka clone() {
        ke keVar = new ke(this.h, this.i);
        keVar.a(this);
        keVar.j = this.j;
        keVar.k = this.k;
        keVar.l = this.l;
        keVar.m = this.m;
        return keVar;
    }

    @Override // com.amap.api.col.p0003l.ka
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + ", mcc='" + this.f25983a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }

    public ke(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }
}
