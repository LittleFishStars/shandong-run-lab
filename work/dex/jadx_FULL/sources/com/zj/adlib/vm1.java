package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.OneDReader;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class vm1 extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f45384a = 2.0f;
    public static final float b = 1.5f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f20250b = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20248a = "0123456789-$:/.+ABCD";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f20249a = f20248a.toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f20252b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final char[] f20251b = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f20254a = new StringBuilder(20);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f20255a = new int[80];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f20253a = 0;

    public static boolean e(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.f20255a, 0);
        h(qv0Var);
        int iG = g();
        this.f20254a.setLength(0);
        int i2 = iG;
        do {
            int i3 = i(i2);
            if (i3 == -1) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.f20254a.append((char) i3);
            i2 += 8;
            if (this.f20254a.length() > 1 && e(f20251b, f20249a[i3])) {
                break;
            }
        } while (i2 < this.f20253a);
        int i4 = i2 - 1;
        int i5 = this.f20255a[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.f20255a[i2 + i7];
        }
        if (i2 < this.f20253a && i5 < i6 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        j(iG);
        for (int i8 = 0; i8 < this.f20254a.length(); i8++) {
            StringBuilder sb = this.f20254a;
            sb.setCharAt(i8, f20249a[sb.charAt(i8)]);
        }
        char cCharAt = this.f20254a.charAt(0);
        char[] cArr = f20251b;
        if (!e(cArr, cCharAt)) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = this.f20254a;
        if (!e(cArr, sb2.charAt(sb2.length() - 1))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.f20254a.length() <= 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f20254a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f20254a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < iG; i10++) {
            i9 += this.f20255a[i10];
        }
        float f = i9;
        while (iG < i4) {
            i9 += this.f20255a[iG];
            iG++;
        }
        float f2 = i;
        ug7 ug7Var = new ug7(this.f20254a.toString(), null, new xg7[]{new xg7(f, f2), new xg7(i9, f2)}, BarcodeFormat.CODABAR);
        ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]F0");
        return ug7Var;
    }

    public final void f(int i) {
        int[] iArr = this.f20255a;
        int i2 = this.f20253a;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.f20253a = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f20255a = iArr2;
        }
    }

    public final int g() throws NotFoundException {
        for (int i = 1; i < this.f20253a; i += 2) {
            int i2 = i(i);
            if (i2 != -1 && e(f20251b, f20249a[i2])) {
                int i3 = 0;
                for (int i4 = i; i4 < i + 7; i4++) {
                    i3 += this.f20255a[i4];
                }
                if (i == 1 || this.f20255a[i - 1] >= i3 / 2) {
                    return i;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void h(qv0 qv0Var) throws NotFoundException {
        int i = 0;
        this.f20253a = 0;
        int iR = qv0Var.r(0);
        int iS = qv0Var.s();
        if (iR >= iS) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = true;
        while (iR < iS) {
            if (qv0Var.m(iR) != z) {
                i++;
            } else {
                f(i);
                z = !z;
                i = 1;
            }
            iR++;
        }
        f(i);
    }

    public final int i(int i) {
        int i2 = i + 7;
        if (i2 >= this.f20253a) {
            return -1;
        }
        int[] iArr = this.f20255a;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = f20252b;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }

    public final void j(int i) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f20254a.length() - 1;
        int i2 = i;
        int i3 = 0;
        while (true) {
            if (i3 > length) {
                break;
            }
            int i4 = f20252b[this.f20254a.charAt(i3)];
            for (int i5 = 6; i5 >= 0; i5--) {
                int i6 = (i5 & 1) + ((i4 & 1) * 2);
                iArr[i6] = iArr[i6] + this.f20255a[i2 + i5];
                iArr2[i6] = iArr2[i6] + 1;
                i4 >>= 1;
            }
            i2 += 8;
            i3++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i7 = 0; i7 < 2; i7++) {
            fArr2[i7] = 0.0f;
            int i8 = i7 + 2;
            float f = iArr[i7] / iArr2[i7];
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            float f2 = (f + (i9 / i10)) / 2.0f;
            fArr2[i8] = f2;
            fArr[i7] = f2;
            fArr[i8] = ((i9 * 2.0f) + 1.5f) / i10;
        }
        int i11 = i;
        for (int i12 = 0; i12 <= length; i12++) {
            int i13 = f20252b[this.f20254a.charAt(i12)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) * 2);
                float f3 = this.f20255a[i11 + i14];
                if (f3 < fArr2[i15] || f3 > fArr[i15]) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i13 >>= 1;
            }
            i11 += 8;
        }
    }
}
