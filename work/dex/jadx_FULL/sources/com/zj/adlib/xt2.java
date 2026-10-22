package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.UPCEANReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class xt2 extends UPCEANReader {
    public static final int[] e = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    public final int[] d = new int[4];

    public static void m(StringBuilder sb, int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == e[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(qv0 qv0Var, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.d;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iS = qv0Var.s();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 6 && i < iS; i3++) {
            int iF = UPCEANReader.f(qv0Var, iArr2, i, UPCEANReader.f6759b);
            sb.append((char) ((iF % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (iF >= 10) {
                i2 |= 1 << (5 - i3);
            }
        }
        m(sb, i2);
        int i5 = UPCEANReader.h(qv0Var, i, true, UPCEANReader.f6758b)[1];
        for (int i6 = 0; i6 < 6 && i5 < iS; i6++) {
            sb.append((char) (UPCEANReader.f(qv0Var, iArr2, i5, UPCEANReader.f6757a) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat k() {
        return BarcodeFormat.EAN_13;
    }
}
