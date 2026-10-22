package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.UPCEANReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class zt2 extends UPCEANReader {
    public final int[] d = new int[4];

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(qv0 qv0Var, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.d;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iS = qv0Var.s();
        int i = iArr[1];
        for (int i2 = 0; i2 < 4 && i < iS; i2++) {
            sb.append((char) (UPCEANReader.f(qv0Var, iArr2, i, UPCEANReader.f6757a) + 48));
            for (int i3 : iArr2) {
                i += i3;
            }
        }
        int i4 = UPCEANReader.h(qv0Var, i, true, UPCEANReader.f6758b)[1];
        for (int i5 = 0; i5 < 4 && i4 < iS; i5++) {
            sb.append((char) (UPCEANReader.f(qv0Var, iArr2, i4, UPCEANReader.f6757a) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        return i4;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat k() {
        return BarcodeFormat.EAN_8;
    }
}
