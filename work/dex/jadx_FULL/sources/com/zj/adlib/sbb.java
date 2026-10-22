package com.zj.adlib;

import com.amap.api.col.p0003l.ij;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class sbb extends ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f44656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19562a;

    public sbb() {
        this.f44656a = new StringBuilder();
        this.f19562a = true;
    }

    @Override // com.amap.api.col.p0003l.ij
    public final byte[] a(byte[] bArr) {
        byte[] bArrP = s4b.p(this.f44656a.toString());
        ((ij) this).f928a = bArrP;
        this.f19562a = true;
        StringBuilder sb = this.f44656a;
        sb.delete(0, sb.length());
        return bArrP;
    }

    @Override // com.amap.api.col.p0003l.ij
    public final void b(byte[] bArr) {
        String strG = s4b.g(bArr);
        if (this.f19562a) {
            this.f19562a = false;
        } else {
            this.f44656a.append(",");
        }
        StringBuilder sb = this.f44656a;
        sb.append("{\"log\":\"");
        sb.append(strG);
        sb.append("\"}");
    }

    public sbb(ij ijVar) {
        super(ijVar);
        this.f44656a = new StringBuilder();
        this.f19562a = true;
    }
}
