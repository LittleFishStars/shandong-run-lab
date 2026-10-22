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
public class d57 implements Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xg7[] f41109a = new xg7[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final n82 f15928a = new n82();

    public static tv0 e(tv0 tv0Var) throws NotFoundException {
        int[] iArrS = tv0Var.s();
        int[] iArrL = tv0Var.l();
        if (iArrS == null || iArrL == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float f = f(iArrS, tv0Var);
        int i = iArrS[1];
        int i2 = iArrL[1];
        int i3 = iArrS[0];
        int i4 = iArrL[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3 && (i4 = i3 + i5) >= tv0Var.t()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iRound = Math.round(((i4 - i3) + 1) / f);
        int iRound2 = Math.round((i5 + 1) / f);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = (int) (f / 2.0f);
        int i7 = i + i6;
        int i8 = i3 + i6;
        int i9 = (((int) ((iRound - 1) * f)) + i8) - i4;
        if (i9 > 0) {
            if (i9 > i6) {
                throw NotFoundException.getNotFoundInstance();
            }
            i8 -= i9;
        }
        int i10 = (((int) ((iRound2 - 1) * f)) + i7) - i2;
        if (i10 > 0) {
            if (i10 > i6) {
                throw NotFoundException.getNotFoundInstance();
            }
            i7 -= i10;
        }
        tv0 tv0Var2 = new tv0(iRound, iRound2);
        for (int i11 = 0; i11 < iRound2; i11++) {
            int i12 = ((int) (i11 * f)) + i7;
            for (int i13 = 0; i13 < iRound; i13++) {
                if (tv0Var.k(((int) (i13 * f)) + i8, i12)) {
                    tv0Var2.z(i13, i11);
                }
            }
        }
        return tv0Var2;
    }

    public static float f(int[] iArr, tv0 tv0Var) throws NotFoundException {
        int iO = tv0Var.o();
        int iT = tv0Var.t();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < iT && i2 < iO) {
            if (z != tv0Var.k(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i == iT || i2 == iO) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i - iArr[0]) / 7.0f;
    }

    @Override // com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException, ChecksumException, FormatException {
        return d(jv0Var, null);
    }

    @Override // com.google.zxing.Reader
    public final ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        xg7[] xg7VarArrB;
        q82 q82VarD;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            ul2 ul2VarE = new tl2(jv0Var.b()).e(map);
            q82 q82VarD2 = this.f15928a.d(ul2VarE.a(), map);
            xg7VarArrB = ul2VarE.b();
            q82VarD = q82VarD2;
        } else {
            q82VarD = this.f15928a.d(e(jv0Var.b()), map);
            xg7VarArrB = f41109a;
        }
        if (q82VarD.f() instanceof c57) {
            ((c57) q82VarD.f()).a(xg7VarArrB);
        }
        ug7 ug7Var = new ug7(q82VarD.k(), q82VarD.g(), xg7VarArrB, BarcodeFormat.QR_CODE);
        List<byte[]> listA = q82VarD.a();
        if (listA != null) {
            ug7Var.j(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = q82VarD.b();
        if (strB != null) {
            ug7Var.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        if (q82VarD.l()) {
            ug7Var.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(q82VarD.i()));
            ug7Var.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(q82VarD.h()));
        }
        ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]Q" + q82VarD.j());
        return ug7Var;
    }

    public final n82 getDecoder() {
        return this.f15928a;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
