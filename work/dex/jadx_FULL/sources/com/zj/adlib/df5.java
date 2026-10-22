package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ResultMetadataType;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class df5 implements Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41170a = 30;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final xg7[] f15985a = new xg7[0];
    public static final int b = 33;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final m82 f15986a = new m82();

    public static tv0 b(tv0 tv0Var) throws NotFoundException {
        int[] iArrM = tv0Var.m();
        if (iArrM == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = iArrM[0];
        int i2 = iArrM[1];
        int i3 = iArrM[2];
        int i4 = iArrM[3];
        tv0 tv0Var2 = new tv0(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int iMin = Math.min((((i5 * i4) + (i4 / 2)) / 33) + i2, i4 - 1);
            for (int i6 = 0; i6 < 30; i6++) {
                if (tv0Var.k(Math.min((((i6 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30, i3 - 1) + i, iMin)) {
                    tv0Var2.z(i6, i5);
                }
            }
        }
        return tv0Var2;
    }

    @Override // com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException, ChecksumException, FormatException {
        return d(jv0Var, null);
    }

    @Override // com.google.zxing.Reader
    public ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        q82 q82VarC = this.f15986a.c(b(jv0Var.b()), map);
        ug7 ug7Var = new ug7(q82VarC.k(), q82VarC.g(), f15985a, BarcodeFormat.MAXICODE);
        String strB = q82VarC.b();
        if (strB != null) {
            ug7Var.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        return ug7Var;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
