package com.baidu.mshield.b.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrC = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArrC = a.c(bArr2, bArr)) != null && bArrC.length > 0) {
                    return bArrC;
                }
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
        }
        return bArrC;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArrD = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArrD = a.d(bArr2, bArr)) != null && bArrD.length > 0) {
                    return bArrD;
                }
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
        }
        return bArrD;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArrA = f.a(bArr, bArr2)) != null && bArrA.length > 0) {
                    return bArrA;
                }
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
        }
        return bArrA;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArrB = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArrB = f.b(bArr, bArr2)) != null && bArrB.length > 0) {
                    return bArrB;
                }
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
        }
        return bArrB;
    }
}
