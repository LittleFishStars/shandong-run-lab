package com.alibaba.analytics.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static char[] f23746a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f23746a[(bArr[i] & 240) >>> 4]);
            sb.append(f23746a[bArr[i] & com.google.common.base.a.q]);
        }
        return sb.toString();
    }

    public static String d(byte[] bArr) {
        byte[] bArrM96c = m96c(bArr);
        return bArrM96c != null ? c(bArrM96c) : "0000000000000000";
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private static byte[] m96c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
