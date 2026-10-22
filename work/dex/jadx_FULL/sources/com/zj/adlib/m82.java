package com.zj.adlib;

import com.google.common.base.a;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class m82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43244a = 0;
    public static final int b = 1;
    public static final int c = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final dd7 f18151a = new dd7(it3.h);

    public final void a(byte[] bArr, int i, int i2, int i3, int i4) throws ChecksumException {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            this.f18151a.a(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public q82 b(tv0 tv0Var) throws ChecksumException, FormatException {
        return c(tv0Var, null);
    }

    public q82 c(tv0 tv0Var, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        byte[] bArr;
        byte[] bArrA = new uv0(tv0Var).a();
        a(bArrA, 0, 10, 10, 0);
        int i = bArrA[0] & a.q;
        if (i == 2 || i == 3 || i == 4) {
            a(bArrA, 20, 84, 40, 1);
            a(bArrA, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i != 5) {
                throw FormatException.getFormatInstance();
            }
            a(bArrA, 20, 68, 56, 1);
            a(bArrA, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArrA, 0, bArr, 0, 10);
        System.arraycopy(bArrA, 20, bArr, 10, bArr.length - 10);
        return l82.a(bArr, i);
    }
}
