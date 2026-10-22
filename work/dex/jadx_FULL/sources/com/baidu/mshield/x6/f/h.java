package com.baidu.mshield.x6.f;

import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h {
    public static String a(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArrB = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArrB = com.baidu.mshield.b.f.a.b(bArr, bArr2)) != null && bArrB.length > 0) {
                    return bArrB;
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return bArrB;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArrA = com.baidu.mshield.b.f.f.a(bArr, bArr2)) != null && bArrA.length > 0) {
                    return bArrA;
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return bArrA;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArrB = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArrB = com.baidu.mshield.b.f.f.b(bArr, bArr2)) != null && bArrB.length > 0) {
                    return bArrB;
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return bArrB;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArrA = com.baidu.mshield.b.f.a.a(bArr, bArr2)) != null && bArrA.length > 0) {
                    return bArrA;
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return bArrA;
    }
}
