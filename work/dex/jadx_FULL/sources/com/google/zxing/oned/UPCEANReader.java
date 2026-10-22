package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPointCallback;
import com.zj.adlib.bu2;
import com.zj.adlib.hf9;
import com.zj.adlib.qv0;
import com.zj.adlib.ug7;
import com.zj.adlib.xg7;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class UPCEANReader extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f32519a = 0.48f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f6757a;
    public static final float b = 0.7f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[][] f6759b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f6756a = {1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f6758b = {1, 1, 1, 1, 1};
    public static final int[] c = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f6762a = new StringBuilder(20);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hf9 f6761a = new hf9();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final bu2 f6760a = new bu2();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f6757a = iArr;
        int[][] iArr2 = new int[20][];
        f6759b = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = f6757a[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            f6759b[i] = iArr4;
        }
    }

    public static boolean e(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return l(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    public static int f(qv0 qv0Var, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        OneDReader.recordPattern(qv0Var, i, iArr);
        int length = iArr2.length;
        float f = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fPatternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i3], 0.7f);
            if (fPatternMatchVariance < f) {
                i2 = i3;
                f = fPatternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] h(qv0 qv0Var, int i, boolean z, int[] iArr) throws NotFoundException {
        return i(qv0Var, i, z, iArr, new int[iArr.length]);
    }

    public static int[] i(qv0 qv0Var, int i, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int iS = qv0Var.s();
        int iR = z ? qv0Var.r(i) : qv0Var.p(i);
        int length = iArr.length;
        boolean z2 = z;
        int i2 = 0;
        int i3 = iR;
        while (iR < iS) {
            if (qv0Var.m(iR) != z2) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (OneDReader.patternMatchVariance(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i3, iR};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i4 = i2 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i2] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            iR++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] j(qv0 qv0Var) throws NotFoundException {
        int[] iArr = new int[f6756a.length];
        int[] iArrI = null;
        boolean zU = false;
        int i = 0;
        while (!zU) {
            int[] iArr2 = f6756a;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrI = i(qv0Var, i, false, iArr2, iArr);
            int i2 = iArrI[0];
            int i3 = iArrI[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zU = qv0Var.u(i4, i2, false);
            }
            i = i3;
        }
        return iArrI;
    }

    public static int l(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i3 += iCharAt2;
        }
        return (1000 - i3) % 10;
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return g(i, qv0Var, j(qv0Var), map);
    }

    public boolean checkChecksum(String str) throws FormatException {
        return e(str);
    }

    public int[] decodeEnd(qv0 qv0Var, int i) throws NotFoundException {
        return h(qv0Var, i, false, f6756a);
    }

    public abstract int decodeMiddle(qv0 qv0Var, int[] iArr, StringBuilder sb) throws NotFoundException;

    public ug7 g(int i, qv0 qv0Var, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        String strC;
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (resultPointCallback != null) {
            resultPointCallback.a(new xg7((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.f6762a;
        sb.setLength(0);
        int iDecodeMiddle = decodeMiddle(qv0Var, iArr, sb);
        if (resultPointCallback != null) {
            resultPointCallback.a(new xg7(iDecodeMiddle, i));
        }
        int[] iArrDecodeEnd = decodeEnd(qv0Var, iDecodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.a(new xg7((iArrDecodeEnd[0] + iArrDecodeEnd[1]) / 2.0f, i));
        }
        int i2 = iArrDecodeEnd[1];
        int i3 = (i2 - iArrDecodeEnd[0]) + i2;
        if (i3 >= qv0Var.s() || !qv0Var.u(i2, i3, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!checkChecksum(string)) {
            throw ChecksumException.getChecksumInstance();
        }
        float f = (iArr[1] + iArr[0]) / 2.0f;
        float f2 = (iArrDecodeEnd[1] + iArrDecodeEnd[0]) / 2.0f;
        BarcodeFormat barcodeFormatK = k();
        float f3 = i;
        ug7 ug7Var = new ug7(string, null, new xg7[]{new xg7(f, f3), new xg7(f2, f3)}, barcodeFormatK);
        try {
            ug7 ug7VarA = this.f6761a.a(i, qv0Var, iArrDecodeEnd[1]);
            ug7Var.j(ResultMetadataType.UPC_EAN_EXTENSION, ug7VarA.g());
            ug7Var.i(ug7VarA.e());
            ug7Var.a(ug7VarA.f());
            length = ug7VarA.g().length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    z = false;
                    break;
                }
                if (length == iArr2[i4]) {
                    break;
                }
                i4++;
            }
            if (!z) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if ((barcodeFormatK == BarcodeFormat.EAN_13 || barcodeFormatK == BarcodeFormat.UPC_A) && (strC = this.f6760a.c(string)) != null) {
            ug7Var.j(ResultMetadataType.POSSIBLE_COUNTRY, strC);
        }
        int i5 = barcodeFormatK == BarcodeFormat.EAN_8 ? 4 : 0;
        ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]E" + i5);
        return ug7Var;
    }

    public abstract BarcodeFormat k();
}
