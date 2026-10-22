package com.igexin.push.g;

import android.text.TextUtils;
import android.util.Base64;
import java.io.RandomAccessFile;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38142a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzbMQ22qV6umuPXYWXEOGdlpJR\nBWMP68/ArS7XG8+7GmRbWMW1HOMLOOdwuIfPFp9QiwOshG0mYXlm1ecQ/fCXhRMW\nfh+OMCoBdl7vnCpoDYPmjYQBkm9fRW6oej33UhZtlnTZjECAsyC2Eybha7jg3Lft\ngYVnwaPShTmv5+Z9SQIDAQAB";
    private static final String b = "LOG-CryptoTool";

    private static byte a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    private static String a() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return a(keyGenerator.generateKey().getEncoded());
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void a(RandomAccessFile randomAccessFile) throws Exception {
        long length = (int) (randomAccessFile.length() % 16);
        if (length >= 16 || length <= 0) {
            return;
        }
        randomAccessFile.setLength(randomAccessFile.length() - length);
    }

    private static byte[] a(String str) throws Exception {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(f38142a, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        cipher.init(1, rSAPublicKey);
        byte[] bArrDoFinal = cipher.doFinal(str.getBytes("UTF-8"));
        a(bArrDoFinal);
        return bArrDoFinal;
    }

    private static RSAPublicKey b(String str) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    private static void b() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        com.igexin.push.core.e.aB = keyGenerator.generateKey().getEncoded();
        o.a(com.igexin.push.core.e.l, o.g, a(g.a(com.igexin.push.core.e.aB)));
        o.b(com.igexin.push.core.e.l, o.g, "");
    }

    private static byte[] c() {
        if (com.igexin.push.core.e.aB == null) {
            String str = (String) o.b(com.igexin.push.core.e.l, o.g, "");
            byte[] bArr = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str != null && !str.equals("")) {
                String upperCase = str.toUpperCase();
                int length = upperCase.length() / 2;
                char[] charArray = upperCase.toCharArray();
                bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
                }
            }
            com.igexin.push.core.e.aB = com.igexin.c.a.a.a.a(bArr, com.igexin.push.core.e.M);
        }
        return com.igexin.push.core.e.aB;
    }

    private static byte[] c(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
        }
        return bArr;
    }
}
