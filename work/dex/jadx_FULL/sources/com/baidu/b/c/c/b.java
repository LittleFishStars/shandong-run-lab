package com.baidu.b.c.c;

import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f26287a;
    private static byte[] b;

    public static byte[] a() {
        byte[] bArr = f26287a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f26286a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
        f26287a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        b = byteArray;
        return byteArray;
    }
}
