package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.a;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class e57 implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41350a = 4;

    public static tv0 c(b57 b57Var, int i, int i2, int i3) {
        r51 r51VarC = b57Var.c();
        if (r51VarC == null) {
            throw new IllegalStateException();
        }
        int iE = r51VarC.e();
        int iD = r51VarC.d();
        int i4 = i3 * 2;
        int i5 = iE + i4;
        int i6 = i4 + iD;
        int iMax = Math.max(i, i5);
        int iMax2 = Math.max(i2, i6);
        int iMin = Math.min(iMax / i5, iMax2 / i6);
        int i7 = (iMax - (iE * iMin)) / 2;
        int i8 = (iMax2 - (iD * iMin)) / 2;
        tv0 tv0Var = new tv0(iMax, iMax2);
        int i9 = 0;
        while (i9 < iD) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < iE) {
                if (r51VarC.b(i10, i9) == 1) {
                    tv0Var.A(i11, i8, iMin, iMin);
                }
                i10++;
                i11 += iMin;
            }
            i9++;
            i8 += iMin;
        }
        return tv0Var;
    }

    @Override // com.google.zxing.Writer
    public tv0 a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        ErrorCorrectionLevel errorCorrectionLevelValueOf = ErrorCorrectionLevel.L;
        int i3 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevelValueOf = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i3 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return c(a.p(str, errorCorrectionLevelValueOf, map), i, i2, i3);
    }

    @Override // com.google.zxing.Writer
    public tv0 b(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return a(str, barcodeFormat, i, i2, null);
    }
}
