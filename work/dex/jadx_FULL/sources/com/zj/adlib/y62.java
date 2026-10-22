package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.datamatrix.encoder.MinimalEncoder;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.e;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class y62 implements Writer {
    public static tv0 c(r51 r51Var, int i, int i2) {
        tv0 tv0Var;
        int iE = r51Var.e();
        int iD = r51Var.d();
        int iMax = Math.max(i, iE);
        int iMax2 = Math.max(i2, iD);
        int iMin = Math.min(iMax / iE, iMax2 / iD);
        int i3 = (iMax - (iE * iMin)) / 2;
        int i4 = (iMax2 - (iD * iMin)) / 2;
        if (i2 < iD || i < iE) {
            tv0Var = new tv0(iE, iD);
            i3 = 0;
            i4 = 0;
        } else {
            tv0Var = new tv0(i, i2);
        }
        tv0Var.b();
        int i5 = 0;
        while (i5 < iD) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < iE) {
                if (r51Var.b(i7, i5) == 1) {
                    tv0Var.A(i6, i4, iMin, iMin);
                }
                i7++;
                i6 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return tv0Var;
    }

    public static tv0 d(oh2 oh2Var, dy8 dy8Var, int i, int i2) {
        int i3 = dy8Var.i();
        int iH = dy8Var.h();
        r51 r51Var = new r51(dy8Var.k(), dy8Var.j());
        int i4 = 0;
        for (int i5 = 0; i5 < iH; i5++) {
            if (i5 % dy8Var.d == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < dy8Var.k(); i7++) {
                    r51Var.h(i6, i4, i7 % 2 == 0);
                    i6++;
                }
                i4++;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < i3; i9++) {
                if (i9 % dy8Var.c == 0) {
                    r51Var.h(i8, i4, true);
                    i8++;
                }
                r51Var.h(i8, i4, oh2Var.e(i9, i5));
                i8++;
                int i10 = dy8Var.c;
                if (i9 % i10 == i10 - 1) {
                    r51Var.h(i8, i4, i5 % 2 == 0);
                    i8++;
                }
            }
            i4++;
            int i11 = dy8Var.d;
            if (i5 % i11 == i11 - 1) {
                int i12 = 0;
                for (int i13 = 0; i13 < dy8Var.k(); i13++) {
                    r51Var.h(i12, i4, true);
                    i12++;
                }
                i4++;
            }
        }
        return c(r51Var, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    @Override // com.google.zxing.Writer
    public tv0 a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        tn2 tn2Var;
        tn2 tn2Var2;
        boolean z;
        String strD;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            tn2Var = (tn2) map.get(EncodeHintType.MIN_SIZE);
            if (tn2Var == null) {
                tn2Var = null;
            }
            tn2Var2 = (tn2) map.get(EncodeHintType.MAX_SIZE);
            if (tn2Var2 == null) {
                tn2Var2 = null;
            }
        } else {
            tn2Var = null;
            tn2Var2 = null;
        }
        boolean z2 = false;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.DATA_MATRIX_COMPACT;
            if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            EncodeHintType encodeHintType2 = EncodeHintType.GS1_FORMAT;
            if (map.containsKey(encodeHintType2) && Boolean.parseBoolean(map.get(encodeHintType2).toString())) {
                z2 = true;
            }
            EncodeHintType encodeHintType3 = EncodeHintType.CHARACTER_SET;
            strD = MinimalEncoder.i(str, map.containsKey(encodeHintType3) ? Charset.forName(map.get(encodeHintType3).toString()) : null, z2 ? 29 : -1, symbolShapeHint);
        } else {
            if (map != null) {
                EncodeHintType encodeHintType4 = EncodeHintType.FORCE_C40;
                if (map.containsKey(encodeHintType4) && Boolean.parseBoolean(map.get(encodeHintType4).toString())) {
                    z2 = true;
                }
            }
            strD = e.d(str, symbolShapeHint, tn2Var, tn2Var2, z2);
        }
        dy8 dy8VarO = dy8.o(strD.length(), symbolShapeHint, tn2Var, tn2Var2, true);
        oh2 oh2Var = new oh2(y43.b(strD, dy8VarO), dy8VarO.i(), dy8VarO.h());
        oh2Var.k();
        return d(oh2Var, dy8VarO, i, i2);
    }

    @Override // com.google.zxing.Writer
    public tv0 b(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return a(str, barcodeFormat, i, i2, null);
    }
}
