package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class l extends p {
    private long blY;
    private long blZ;
    private int bma;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long jG = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.blY = jG;
        if (jG < 0) {
            this.blY = jG + 4294967296L;
        }
        long jG2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.blZ = jG2;
        if (jG2 < 0) {
            this.blZ = jG2 + 4294967296L;
        }
        this.bma = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
