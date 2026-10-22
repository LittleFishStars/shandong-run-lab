package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class m extends p {
    private int bmb;
    private int[] bmc;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.bmb = 0;
    }

    private void c(int i, int i2, int i3, int i4) {
        this.bmc[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    private void fC(int i) {
        this.bmb = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.bmb);
        }
        int[] iArr = this.bmc;
        if (iArr == null || iArr.length != i) {
            this.bmc = new int[i];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        fC(dVar.len / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.bmb) {
            byte[] bArr = dVar.data;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            c(i, bArr[i2] & 255, bArr[i3] & 255, bArr[i4] & 255);
            i++;
            i2 = i4 + 1;
        }
    }
}
