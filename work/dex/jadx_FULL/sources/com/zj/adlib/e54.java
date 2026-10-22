package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.OneDReader;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class e54 extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f41349a = 0.38f;
    public static final float b = 0.5f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f16199b = 3;
    public static final int c = 2;
    public static final int d = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16202a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f16197a = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f16200b = {1, 1, 1, 1};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f16198a = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[][] f16201b = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    public static int e(int[] iArr) throws NotFoundException {
        int length = f16201b.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fPatternMatchVariance = OneDReader.patternMatchVariance(iArr, f16201b[i2], 0.5f);
            if (fPatternMatchVariance < f) {
                i = i2;
                f = fPatternMatchVariance;
            } else if (fPatternMatchVariance == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static void g(qv0 qv0Var, int i, int i2, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            OneDReader.recordPattern(qv0Var, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (e(iArr2) + 48));
            sb.append((char) (e(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    public static int[] i(qv0 qv0Var, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iS = qv0Var.s();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < iS) {
            if (qv0Var.m(i) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (OneDReader.patternMatchVariance(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i2, i};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int j(qv0 qv0Var) throws NotFoundException {
        int iS = qv0Var.s();
        int iP = qv0Var.p(0);
        if (iP != iS) {
            return iP;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        boolean z;
        int[] iArrH = h(qv0Var);
        int[] iArrF = f(qv0Var);
        StringBuilder sb = new StringBuilder(20);
        g(qv0Var, iArrH[1], iArrF[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f16197a;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (!z) {
            throw FormatException.getFormatInstance();
        }
        float f = i;
        ug7 ug7Var = new ug7(string, null, new xg7[]{new xg7(iArrH[1], f), new xg7(iArrF[0], f)}, BarcodeFormat.ITF);
        ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]I0");
        return ug7Var;
    }

    public final int[] f(qv0 qv0Var) throws NotFoundException {
        int[] iArrI;
        qv0Var.x();
        try {
            int iJ = j(qv0Var);
            try {
                iArrI = i(qv0Var, iJ, f16198a[0]);
            } catch (NotFoundException unused) {
                iArrI = i(qv0Var, iJ, f16198a[1]);
            }
            k(qv0Var, iArrI[0]);
            int i = iArrI[0];
            iArrI[0] = qv0Var.s() - iArrI[1];
            iArrI[1] = qv0Var.s() - i;
            qv0Var.x();
            return iArrI;
        } catch (Throwable th) {
            qv0Var.x();
            throw th;
        }
    }

    public final int[] h(qv0 qv0Var) throws NotFoundException {
        int[] iArrI = i(qv0Var, j(qv0Var), f16200b);
        int i = iArrI[1];
        int i2 = iArrI[0];
        this.f16202a = (i - i2) / 4;
        k(qv0Var, i2);
        return iArrI;
    }

    public final void k(qv0 qv0Var, int i) throws NotFoundException {
        int iMin = Math.min(this.f16202a * 10, i);
        for (int i2 = i - 1; iMin > 0 && i2 >= 0 && !qv0Var.m(i2); i2--) {
            iMin--;
        }
        if (iMin != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
