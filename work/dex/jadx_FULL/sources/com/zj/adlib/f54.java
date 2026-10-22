package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.oned.OneDimensionalCodeWriter;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class f54 extends OneDimensionalCodeWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41600a = 3;
    public static final int b = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f16471a = {1, 1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f16473b = {3, 1, 1};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f16472a = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        OneDimensionalCodeWriter.checkNumeric(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iAppendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, f16471a, true);
        for (int i = 0; i < length; i += 2) {
            int iDigit = Character.digit(str.charAt(i), 10);
            int iDigit2 = Character.digit(str.charAt(i + 1), 10);
            int[] iArr = new int[10];
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = i2 * 2;
                int[][] iArr2 = f16472a;
                iArr[i3] = iArr2[iDigit][i2];
                iArr[i3 + 1] = iArr2[iDigit2][i2];
            }
            iAppendPattern += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, iArr, true);
        }
        OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, f16473b, true);
        return zArr;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}
