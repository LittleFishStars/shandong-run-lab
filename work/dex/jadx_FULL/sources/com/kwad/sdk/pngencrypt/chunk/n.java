package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class n extends k {
    private String bmd;
    private int bme;
    private int[] bmf;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String Tz() {
        return this.bmd;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i;
        int iE;
        int iE2;
        int iE3;
        int iE4;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            bArr = dVar.data;
            if (i3 >= bArr.length) {
                i3 = -1;
                break;
            } else if (bArr[i3] == 0) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 <= 0 || i3 > bArr.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.bmd = b.c(bArr, 0, i3);
        int iE5 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i3 + 1);
        this.bme = iE5;
        int i4 = i3 + 2;
        int length = (dVar.data.length - i4) / (iE5 == 8 ? 6 : 10);
        this.bmf = new int[length * 5];
        int i5 = i4;
        int i6 = 0;
        while (i2 < length) {
            if (this.bme == 8) {
                int i7 = i5 + 1;
                iE = com.kwad.sdk.pngencrypt.n.e(dVar.data, i5);
                int i8 = i7 + 1;
                iE2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i7);
                int i9 = i8 + 1;
                iE3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i8);
                i = i9 + 1;
                iE4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i9);
            } else {
                int iF = com.kwad.sdk.pngencrypt.n.f(dVar.data, i5);
                int i10 = i5 + 2;
                int iF2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i10);
                int i11 = i10 + 2;
                int iF3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i11);
                int i12 = i11 + 2;
                int iF4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i12);
                i = i12 + 2;
                iE = iF;
                iE2 = iF2;
                iE3 = iF3;
                iE4 = iF4;
            }
            int iF5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i);
            int[] iArr = this.bmf;
            int i13 = i6 + 1;
            iArr[i6] = iE;
            int i14 = i13 + 1;
            iArr[i13] = iE2;
            int i15 = i14 + 1;
            iArr[i14] = iE3;
            int i16 = i15 + 1;
            iArr[i15] = iE4;
            iArr[i16] = iF5;
            i2++;
            i6 = i16 + 1;
            i5 = i + 2;
        }
    }
}
