package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.UPCEANReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class if9 extends UPCEANReader {
    public final int[] d = new int[4];
    public static final int[] e = {1, 1, 1, 1, 1, 1};
    public static final int[][] c = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    public static String m(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    public static void n(StringBuilder sb, int i) throws NotFoundException {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == c[i2][i3]) {
                    sb.insert(0, (char) (i2 + 48));
                    sb.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public boolean checkChecksum(String str) throws FormatException {
        return super.checkChecksum(m(str));
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int[] decodeEnd(qv0 qv0Var, int i) throws NotFoundException {
        return UPCEANReader.h(qv0Var, i, true, e);
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
        n(sb, i2);
        return i;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat k() {
        return BarcodeFormat.UPC_E;
    }
}
