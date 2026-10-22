package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i = 0;
        while (true) {
            bArr = dVar.data;
            if (i >= bArr.length || bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        this.key = b.c(bArr, 0, i);
        int i2 = i + 1;
        byte[] bArr2 = dVar.data;
        this.bmp = i2 < bArr2.length ? b.c(bArr2, i2, bArr2.length - i2) : "";
    }
}
