package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class s extends p {
    private int bmk;
    private int bml;
    private int bmm;
    private int bmn;
    private int[] bmo;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.bmo = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.bkK;
        if (kVar.bkR) {
            this.bmk = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (!kVar.bkS) {
            this.bml = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.bmm = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.bmn = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        } else {
            int length = dVar.data.length;
            this.bmo = new int[length];
            for (int i = 0; i < length; i++) {
                this.bmo[i] = dVar.data[i] & 255;
            }
        }
    }
}
