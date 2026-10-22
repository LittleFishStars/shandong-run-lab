package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class i4b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f42282a = 6;

    public static byte[] a() {
        try {
            return b("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
        } catch (Throwable th) {
            a7b.m(th, "AMU", "grk");
            return null;
        }
    }

    public static byte[] b(String str) {
        try {
            String[] strArrSplit = new StringBuffer(str).reverse().toString().split(",");
            int length = strArrSplit.length;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = Byte.parseByte(strArrSplit[i]);
            }
            String[] strArrSplit2 = new StringBuffer(new String(u4b.c(new String(bArr)), "UTF-8")).reverse().toString().split(",");
            byte[] bArr2 = new byte[strArrSplit2.length];
            for (int i2 = 0; i2 < strArrSplit2.length; i2++) {
                bArr2[i2] = Byte.parseByte(strArrSplit2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            a7b.m(th, "AMU", "rcs");
            return null;
        }
    }

    public static byte[] c(byte[] bArr) {
        try {
            return m4b.h(a(), bArr, d());
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] d() {
        try {
            return b("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
        } catch (Throwable th) {
            a7b.m(th, "AMU", "giv");
            return null;
        }
    }

    public static byte[] e(byte[] bArr) {
        try {
            return m4b.e(a(), bArr, d());
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
