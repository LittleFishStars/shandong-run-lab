package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ResultMetadataType;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class w62 implements Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xg7[] f45528a = new xg7[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final o82 f20379a = new o82();

    public static tv0 b(tv0 tv0Var) throws NotFoundException {
        int[] iArrS = tv0Var.s();
        int[] iArrL = tv0Var.l();
        if (iArrS == null || iArrL == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iC = c(iArrS, tv0Var);
        int i = iArrS[1];
        int i2 = iArrL[1];
        int i3 = iArrS[0];
        int i4 = ((iArrL[0] - i3) + 1) / iC;
        int i5 = ((i2 - i) + 1) / iC;
        if (i4 <= 0 || i5 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = iC / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        tv0 tv0Var2 = new tv0(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * iC) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (tv0Var.k((i11 * iC) + i8, i10)) {
                    tv0Var2.z(i11, i9);
                }
            }
        }
        return tv0Var2;
    }

    public static int c(int[] iArr, tv0 tv0Var) throws NotFoundException {
        int iT = tv0Var.t();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < iT && tv0Var.k(i, i2)) {
            i++;
        }
        if (i == iT) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i3 = i - iArr[0];
        if (i3 != 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException, ChecksumException, FormatException {
        return d(jv0Var, null);
    }

    @Override // com.google.zxing.Reader
    public ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        xg7[] xg7VarArrB;
        q82 q82VarB;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            ul2 ul2VarB = new rl2(jv0Var.b()).b();
            q82 q82VarB2 = this.f20379a.b(ul2VarB.a());
            xg7VarArrB = ul2VarB.b();
            q82VarB = q82VarB2;
        } else {
            q82VarB = this.f20379a.b(b(jv0Var.b()));
            xg7VarArrB = f45528a;
        }
        ug7 ug7Var = new ug7(q82VarB.k(), q82VarB.g(), xg7VarArrB, BarcodeFormat.DATA_MATRIX);
        List<byte[]> listA = q82VarB.a();
        if (listA != null) {
            ug7Var.j(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = q82VarB.b();
        if (strB != null) {
            ug7Var.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]d" + q82VarB.j());
        return ug7Var;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
