package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.encoder.Compaction;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class th6 implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44925a = 30;
    public static final int b = 2;

    public static tv0 c(byte[][] bArr, int i) {
        int i2 = i * 2;
        tv0 tv0Var = new tv0(bArr[0].length + i2, bArr.length + i2);
        tv0Var.b();
        int iO = (tv0Var.o() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    tv0Var.z(i4 + i, iO);
                }
            }
            i3++;
            iO--;
        }
        return tv0Var;
    }

    public static tv0 d(jh6 jh6Var, String str, int i, int i2, int i3, int i4, boolean z) throws WriterException {
        boolean z2;
        jh6Var.f(str, i, z);
        byte[][] bArrC = jh6Var.g().c(1, 4);
        if ((i3 > i2) != (bArrC[0].length < bArrC.length)) {
            bArrC = e(bArrC);
            z2 = true;
        } else {
            z2 = false;
        }
        int iMin = Math.min(i2 / bArrC[0].length, i3 / bArrC.length);
        if (iMin <= 1) {
            return c(bArrC, i4);
        }
        byte[][] bArrC2 = jh6Var.g().c(iMin, iMin * 4);
        if (z2) {
            bArrC2 = e(bArrC2);
        }
        return c(bArrC2, i4);
    }

    public static byte[][] e(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.Writer
    public tv0 a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        jh6 jh6Var = new jh6();
        boolean z = false;
        int i3 = 30;
        int i4 = 2;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                jh6Var.i(Boolean.parseBoolean(map.get(encodeHintType).toString()));
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                jh6Var.j(Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                wn2 wn2Var = (wn2) map.get(encodeHintType3);
                jh6Var.k(wn2Var.a(), wn2Var.c(), wn2Var.b(), wn2Var.d());
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            i3 = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            i4 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                jh6Var.l(Charset.forName(map.get(encodeHintType6).toString()));
            }
            EncodeHintType encodeHintType7 = EncodeHintType.PDF417_AUTO_ECI;
            if (map.containsKey(encodeHintType7) && Boolean.parseBoolean(map.get(encodeHintType7).toString())) {
                z = true;
            }
        }
        return d(jh6Var, str, i4, i, i2, i3, z);
    }

    @Override // com.google.zxing.Writer
    public tv0 b(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return a(str, barcodeFormat, i, i2, null);
    }
}
