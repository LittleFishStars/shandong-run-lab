package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.zj.adlib.tv0;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class OneDimensionalCodeWriter implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f32518a = Pattern.compile("[0-9]+");

    public static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    public static void checkNumeric(String str) {
        if (!f32518a.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    public static tv0 e(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int iMax = Math.max(i, i4);
        int iMax2 = Math.max(1, i2);
        int i5 = iMax / i4;
        int i6 = (iMax - (length * i5)) / 2;
        tv0 tv0Var = new tv0(iMax, iMax2);
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                tv0Var.A(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return tv0Var;
    }

    @Override // com.google.zxing.Writer
    public tv0 a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        }
        Collection<BarcodeFormat> supportedWriteFormats = getSupportedWriteFormats();
        if (supportedWriteFormats == null || supportedWriteFormats.contains(barcodeFormat)) {
            int iD = d();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    iD = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return e(encode(str, map), i, i2, iD);
        }
        throw new IllegalArgumentException("Can only encode " + supportedWriteFormats + ", but got " + barcodeFormat);
    }

    @Override // com.google.zxing.Writer
    public final tv0 b(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return a(str, barcodeFormat, i, i2, null);
    }

    public abstract boolean[] c(String str);

    public int d() {
        return 10;
    }

    public boolean[] encode(String str, Map<EncodeHintType, ?> map) {
        return c(str);
    }

    public Collection<BarcodeFormat> getSupportedWriteFormats() {
        return null;
    }
}
