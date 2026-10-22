package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.multi.MultipleBarcodeReader;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class qh6 implements Reader, MultipleBarcodeReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ug7[] f44209a = new ug7[0];

    public static ug7[] e(jv0 jv0Var, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException, ChecksumException, FormatException {
        ArrayList arrayList = new ArrayList();
        mh6 mh6VarB = sl2.b(jv0Var, map, z);
        for (xg7[] xg7VarArr : mh6VarB.b()) {
            q82 q82VarI = sh6.i(mh6VarB.a(), xg7VarArr[4], xg7VarArr[5], xg7VarArr[6], xg7VarArr[7], h(xg7VarArr), f(xg7VarArr));
            ug7 ug7Var = new ug7(q82VarI.k(), q82VarI.g(), xg7VarArr, BarcodeFormat.PDF_417);
            ug7Var.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, q82VarI.b());
            rh6 rh6Var = (rh6) q82VarI.f();
            if (rh6Var != null) {
                ug7Var.j(ResultMetadataType.PDF417_EXTRA_METADATA, rh6Var);
            }
            ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]L" + q82VarI.j());
            arrayList.add(ug7Var);
        }
        return (ug7[]) arrayList.toArray(f44209a);
    }

    public static int f(xg7[] xg7VarArr) {
        return Math.max(Math.max(g(xg7VarArr[0], xg7VarArr[4]), (g(xg7VarArr[6], xg7VarArr[2]) * 17) / 18), Math.max(g(xg7VarArr[1], xg7VarArr[5]), (g(xg7VarArr[7], xg7VarArr[3]) * 17) / 18));
    }

    public static int g(xg7 xg7Var, xg7 xg7Var2) {
        if (xg7Var == null || xg7Var2 == null) {
            return 0;
        }
        return (int) Math.abs(xg7Var.c() - xg7Var2.c());
    }

    public static int h(xg7[] xg7VarArr) {
        return Math.min(Math.min(i(xg7VarArr[0], xg7VarArr[4]), (i(xg7VarArr[6], xg7VarArr[2]) * 17) / 18), Math.min(i(xg7VarArr[1], xg7VarArr[5]), (i(xg7VarArr[7], xg7VarArr[3]) * 17) / 18));
    }

    public static int i(xg7 xg7Var, xg7 xg7Var2) {
        if (xg7Var == null || xg7Var2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(xg7Var.c() - xg7Var2.c());
    }

    @Override // com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException, ChecksumException, FormatException {
        return d(jv0Var, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public ug7[] b(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return e(jv0Var, map, true);
        } catch (ChecksumException | FormatException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public ug7[] c(jv0 jv0Var) throws NotFoundException {
        return b(jv0Var, null);
    }

    @Override // com.google.zxing.Reader
    public ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        ug7 ug7Var;
        ug7[] ug7VarArrE = e(jv0Var, map, false);
        if (ug7VarArrE.length == 0 || (ug7Var = ug7VarArrE[0]) == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        return ug7Var;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
