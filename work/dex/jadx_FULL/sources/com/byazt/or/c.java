package com.byazt.or;

import com.byazt.nr.m;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 579, 20})
public class c {
    public static final byte[] c = {-119, 80, 78, 71, 13, 10, com.google.common.base.a.D, 10};
    public static final byte[] tt = {97, 99, 84, 76};

    public static boolean c(byte[] bArr) {
        try {
            if (!c(bArr, c)) {
                return false;
            }
            int i = 8;
            while (i >= 0 && i + 12 <= bArr.length) {
                int iC = c(bArr, i);
                int i2 = i + 4;
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i2, bArr2, 0, 4);
                int i3 = i2 + 4;
                if (Arrays.equals(bArr2, tt)) {
                    return true;
                }
                i = i3 + iC + 4;
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return false;
    }

    private static boolean c(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int c(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
