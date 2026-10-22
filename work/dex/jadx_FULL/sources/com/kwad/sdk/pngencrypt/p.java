package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class p {
    public final e bjO;
    int bkA;
    public final k bkK;
    int bku;
    int bkx;
    int bky;
    int bkz;
    public final boolean blm;
    int bln;
    int blo;
    int blp;
    int blq;
    int blr;
    int bls;
    int blt;
    byte[] buf;

    public p(k kVar, e eVar) {
        this.bkK = kVar;
        this.bjO = eVar;
        this.blm = eVar != null;
    }

    public final void h(byte[] bArr, int i) {
        this.buf = bArr;
        this.blt = i;
    }

    public final void update(int i) {
        this.bln = i;
        if (!this.blm) {
            this.bku = 1;
            this.bkx = 1;
            this.bky = 1;
            this.bkz = 0;
            this.bkA = 0;
            this.blp = i;
            this.blo = i;
            k kVar = this.bkK;
            this.blq = kVar.bkv;
            this.blr = kVar.bkw;
            this.bls = kVar.bkW;
            return;
        }
        this.bku = this.bjO.SX();
        e eVar = this.bjO;
        this.bky = eVar.bky;
        this.bkx = eVar.bkx;
        this.bkA = eVar.bkA;
        this.bkz = eVar.bkz;
        this.blo = eVar.SW();
        this.blp = this.bjO.SV();
        this.blq = this.bjO.SY();
        int iSZ = this.bjO.SZ();
        this.blr = iSZ;
        this.bls = ((this.bkK.bkU * iSZ) + 7) / 8;
    }
}
