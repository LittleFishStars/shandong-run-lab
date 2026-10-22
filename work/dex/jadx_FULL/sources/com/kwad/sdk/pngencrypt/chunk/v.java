package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class v extends t {
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i = 0;
        while (true) {
            bArr = dVar.data;
            if (i >= bArr.length) {
                i = -1;
                break;
            } else if (bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0 || i > bArr.length - 2) {
            new PngjException("bad zTXt chunk: no separator found");
        }
        this.key = b.c(dVar.data, 0, i);
        if (dVar.data[i + 1] != 0) {
            new PngjException("bad zTXt chunk: unknown compression method");
        }
        byte[] bArr2 = dVar.data;
        this.bmp = b.m(b.b(bArr2, i + 2, (bArr2.length - i) - 2, false));
    }
}
