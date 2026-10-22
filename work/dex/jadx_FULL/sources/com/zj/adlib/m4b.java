package com.zj.adlib;

import com.alibaba.ariver.resource.parser.a.e;
import com.google.common.base.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class m4b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f18134a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f43222a = new byte[128];

    static {
        for (int i = 0; i < 128; i++) {
            f43222a[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f43222a[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            f43222a[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f43222a[i4] = (byte) ((i4 - 48) + 52);
        }
        byte[] bArr = f43222a;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String a(String str) {
        return s4b.g(g(str));
    }

    public static byte[] b(byte[] bArr) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException, NullPointerException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(s4b.v("EQUVT"));
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey publicKeyY = s4b.y();
        if (publicKeyY == null) {
            return null;
        }
        byte[] bArrC = c(encoded, publicKeyY);
        byte[] bArrD = d(encoded, bArr);
        byte[] bArr2 = new byte[bArrC.length + bArrD.length];
        System.arraycopy(bArrC, 0, bArr2, 0, bArrC.length);
        System.arraycopy(bArrD, 0, bArr2, bArrC.length, bArrD.length);
        return bArr2;
    }

    public static byte[] c(byte[] bArr, Key key) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(s4b.v("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return j(bArr, bArr2, s4b.w());
        } catch (Throwable th) {
            v6b.b(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, s4b.v("EQUVT"));
        Cipher cipher = Cipher.getInstance(s4b.v("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static String f(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            v6b.b(th, "er", "e64");
            return null;
        }
    }

    public static byte[] g(String str) {
        int i;
        byte b;
        int i2;
        byte b2;
        int i3 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] bArrP = s4b.p(str);
        int length = bArrP.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i3 < length) {
            while (true) {
                i = i3 + 1;
                b = f43222a[bArrP[i3]];
                if (i >= length || b != -1) {
                    break;
                }
                i3 = i;
            }
            if (b == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b2 = f43222a[bArrP[i]];
                if (i2 >= length || b2 != -1) {
                    break;
                }
                i = i2;
            }
            if (b2 == -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & e.i) >>> 4));
            while (i2 != length) {
                int i4 = i2 + 1;
                byte b3 = bArrP[i2];
                if (b3 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b4 = f43222a[b3];
                if (i4 >= length || b4 != -1) {
                    if (b4 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(((b2 & a.q) << 4) | ((b4 & 60) >>> 2));
                    while (i4 != length) {
                        int i5 = i4 + 1;
                        byte b5 = bArrP[i4];
                        if (b5 == 61) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byte b6 = f43222a[b5];
                        if (i5 < length && b6 == -1) {
                            i4 = i5;
                        } else {
                            if (b6 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b6 | ((b4 & 3) << 6));
                            i3 = i5;
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                i2 = i4;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] h(byte[] bArr, byte[] bArr2, byte[] bArr3) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return j(bArr, bArr2, bArr3);
    }

    public static String i(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] j(byte[] bArr, byte[] bArr2, byte[] bArr3) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, s4b.v("EQUVT"));
        Cipher cipher = Cipher.getInstance(s4b.v("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    public static String k(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                char[] cArr = f18134a;
                stringBuffer.append(cArr[i3 >>> 2]);
                stringBuffer.append(cArr[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                char[] cArr2 = f18134a;
                stringBuffer.append(cArr2[i3 >>> 2]);
                stringBuffer.append(cArr2[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(i5 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            char[] cArr3 = f18134a;
            stringBuffer.append(cArr3[i3 >>> 2]);
            stringBuffer.append(cArr3[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(cArr3[i7 & 63]);
            i = i6;
        }
        return stringBuffer.toString();
    }
}
