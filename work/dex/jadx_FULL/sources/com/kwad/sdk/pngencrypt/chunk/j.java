package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j extends t {
    private boolean blV;
    private String blW;
    private String blX;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.blV = false;
        this.blW = "";
        this.blX = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i >= bArr.length) {
                break;
            }
            if (bArr[i] == 0) {
                iArr[i2] = i;
                i2++;
                if (i2 == 1) {
                    i += 2;
                }
                if (i2 == 3) {
                    break;
                }
            }
            i++;
        }
        if (i2 != 3) {
            new PngjException("Bad formed PngChunkITXT chunk");
        }
        this.key = b.c(dVar.data, 0, iArr[0]);
        int i3 = iArr[0] + 1;
        byte[] bArr2 = dVar.data;
        boolean z = bArr2[i3] != 0;
        this.blV = z;
        int i4 = i3 + 1;
        if (z && bArr2[i4] != 0) {
            new PngjException("Bad formed PngChunkITXT chunk - bad compression method ");
        }
        this.blW = b.c(dVar.data, i4, iArr[1] - i4);
        byte[] bArr3 = dVar.data;
        int i5 = iArr[1];
        this.blX = b.d(bArr3, i5 + 1, (iArr[2] - i5) - 1);
        int i6 = iArr[2] + 1;
        if (this.blV) {
            byte[] bArr4 = dVar.data;
            this.bmp = b.n(b.b(bArr4, i6, bArr4.length - i6, false));
        } else {
            byte[] bArr5 = dVar.data;
            this.bmp = b.d(bArr5, i6, bArr5.length - i6);
        }
    }
}
