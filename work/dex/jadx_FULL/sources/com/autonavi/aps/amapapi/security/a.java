package com.autonavi.aps.amapapi.security;

import com.alibaba.ariver.resource.parser.a.e;
import com.amap.api.col.p0003l.ko;
import com.autonavi.aps.amapapi.utils.b;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import com.zj.adlib.p4b;
import com.zj.adlib.s4b;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f26190a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] b = {61, 61, 81, 65, 65, 69, 119, 65, 67, e.i, 74, 80, 115, 116, e.o, 75, 104, 76, 122, 97, 88, 99, e.n, 71, e.j, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, e.o, 65, 66, 87, e.n, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, e.l, 66, 75, 75, 69, 98, e.p, 84, 108, 115, 122, e.l, 106, 76, e.p, 88, 122, 70, 121, 73, 75, e.m, e.k, com.google.android.exoplayer2.text.cea.a.l, 101, 70, 121, MaterialProgressDrawable.d, 105, 115, 105, 89, aq6.f40585a, 117, 112, e.n, e.i, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};
    private static final byte[] c;
    private static final IvParameterSpec d;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        c = bArr;
        d = new IvParameterSpec(bArr);
    }

    public static byte[] a(byte[] bArr) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(ko.a(new StringBuilder(new String(b)).reverse().toString().getBytes())));
        Cipher cipher = Cipher.getInstance(s4b.v("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        cipher.init(1, publicKeyGeneratePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpecB = b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpecB, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    private static String c(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            char[] cArr = f26190a;
            sb.append(cArr[(bArr[i] >> 4) & 15]);
            sb.append(cArr[bArr[i] & com.google.common.base.a.q]);
        }
        return sb.toString();
    }

    private static SecretKeySpec b(String str) {
        byte[] bytes;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bytes = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            b.a(th, "Encrypt", "createKey");
            bytes = null;
        }
        return new SecretKeySpec(bytes, "AES");
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpecB = b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpecB, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return a("MD5", a("SHA1", str) + str);
                }
            } catch (Throwable th) {
                b.a(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(s4b.w()));
            return cipher.doFinal(bArr3);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(bArr != null ? bArr.length : 0)));
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return c(p4b.c(str2.getBytes("UTF-8"), str));
        } catch (Throwable th) {
            b.a(th, "Encrypt", "encode");
            return null;
        }
    }

    private static byte[] a() {
        return s4b.w();
    }
}
