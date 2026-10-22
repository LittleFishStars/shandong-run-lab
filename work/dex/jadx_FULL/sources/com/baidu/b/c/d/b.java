package com.baidu.b.c.d;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SecureRandom f26289a = new SecureRandom();

    public static int a(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) >> 3;
    }

    private static BigInteger a(byte[] bArr, BigInteger bigInteger) throws BadPaddingException {
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        if (bigInteger2.compareTo(bigInteger) < 0) {
            return bigInteger2;
        }
        throw new BadPaddingException("Message is larger than modulus");
    }

    private static byte[] a(BigInteger bigInteger, int i) {
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        if (length == i) {
            return byteArray;
        }
        if (length == i + 1 && byteArray[0] == 0) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, 1, bArr, 0, i);
            return bArr;
        }
        if (length >= i) {
            return null;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(byteArray, 0, bArr2, i - length, length);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        if (i == 0 && i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, d dVar) throws BadPaddingException {
        return a(bArr, dVar.a(), dVar.b());
    }

    private static byte[] a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws BadPaddingException {
        return a(a(bArr, bigInteger).modPow(bigInteger2, bigInteger), a(bigInteger));
    }
}
