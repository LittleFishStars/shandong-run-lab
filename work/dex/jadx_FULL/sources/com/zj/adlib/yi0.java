package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class yi0 implements Writer {
    public static tv0 c(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return d(u13.f(str, i3, i4, charset), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    public static tv0 d(vi0 vi0Var, int i, int i2) {
        tv0 tv0VarC = vi0Var.c();
        if (tv0VarC == null) {
            throw new IllegalStateException();
        }
        int iT = tv0VarC.t();
        int iO = tv0VarC.o();
        int iMax = Math.max(i, iT);
        int iMax2 = Math.max(i2, iO);
        int iMin = Math.min(iMax / iT, iMax2 / iO);
        int i3 = (iMax - (iT * iMin)) / 2;
        int i4 = (iMax2 - (iO * iMin)) / 2;
        tv0 tv0Var = new tv0(iMax, iMax2);
        int i5 = 0;
        while (i5 < iO) {
            int i6 = 0;
            int i7 = i3;
            while (i6 < iT) {
                if (tv0VarC.k(i6, i5)) {
                    tv0Var.A(i7, i4, iMin, iMin);
                }
                i6++;
                i7 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return tv0Var;
    }

    @Override // com.google.zxing.Writer
    public tv0 a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Charset charsetForName = null;
        int i3 = 33;
        int i4 = 0;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            charsetForName = map.containsKey(encodeHintType) ? Charset.forName(map.get(encodeHintType).toString()) : null;
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            i3 = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                i4 = Integer.parseInt(map.get(encodeHintType3).toString());
            }
        }
        return c(str, barcodeFormat, i, i2, charsetForName, i3, i4);
    }

    @Override // com.google.zxing.Writer
    public tv0 b(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return a(str, barcodeFormat, i, i2, null);
    }
}
