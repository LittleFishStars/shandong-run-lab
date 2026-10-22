package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.oned.OneDimensionalCodeWriter;
import com.google.zxing.oned.UPCEANReader;
import com.google.zxing.oned.UPCEANWriter;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class yt2 extends UPCEANWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46114a = 95;

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + UPCEANReader.l(str);
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
            }
            try {
                if (!UPCEANReader.e(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        OneDimensionalCodeWriter.checkNumeric(str);
        int i = xt2.e[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iAppendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.f6756a, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                iDigit += 10;
            }
            iAppendPattern += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, UPCEANReader.f6759b[iDigit], false);
        }
        int iAppendPattern2 = iAppendPattern + OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, UPCEANReader.f6758b, false);
        for (int i3 = 7; i3 <= 12; i3++) {
            iAppendPattern2 += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, UPCEANReader.f6757a[Character.digit(str.charAt(i3), 10)], true);
        }
        OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, UPCEANReader.f6756a, true);
        return zArr;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
