package com.getui.gtc.a.a;

import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f30262a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static String a(String str) {
        MessageDigest messageDigest;
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            com.getui.gtc.i.c.a.c(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bytes);
        byte[] bArrDigest = messageDigest.digest();
        char[] cArr2 = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArrDigest[i2];
            int i3 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i3 + 1;
            cArr2[i3] = cArr[b & com.google.common.base.a.q];
        }
        return new String(cArr2);
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArrA;
        if (bArr == null || (bArrA = g.a(bArr)) == null) {
            return null;
        }
        String strA = a(String.valueOf(System.currentTimeMillis()));
        int length = bArrA.length;
        byte[] bArr2 = new byte[length + 16];
        byte[] bytes = strA.substring(0, 8).getBytes();
        byte[] bytes2 = strA.substring(24, 32).getBytes();
        System.arraycopy(bytes, 0, bArr2, 0, 8);
        System.arraycopy(bArrA, 0, bArr2, 8, length);
        System.arraycopy(bytes2, 0, bArr2, length + 8, 8);
        return bArr2;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 8, bArr2, 0, bArr.length - 16);
        return g.b(bArr2);
    }
}
