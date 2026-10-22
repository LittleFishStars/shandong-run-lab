package com.zj.adlib;

import android.os.Build;
import com.aliyun.openapiutil.Client;
import com.blankj.utilcode.util.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class i33 {
    public i33() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(byte[] bArr, byte[] bArr2) {
        return i.k(y(bArr, bArr2));
    }

    public static byte[] B(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA224");
    }

    public static String C(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : D(str.getBytes(), str2.getBytes());
    }

    public static String D(byte[] bArr, byte[] bArr2) {
        return i.k(B(bArr, bArr2));
    }

    public static byte[] E(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA256");
    }

    public static String F(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : G(str.getBytes(), str2.getBytes());
    }

    public static String G(byte[] bArr, byte[] bArr2) {
        return i.k(E(bArr, bArr2));
    }

    public static byte[] H(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA384");
    }

    public static String I(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : J(str.getBytes(), str2.getBytes());
    }

    public static String J(byte[] bArr, byte[] bArr2) {
        return i.k(H(bArr, bArr2));
    }

    public static byte[] K(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA512");
    }

    public static String L(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : M(str.getBytes(), str2.getBytes());
    }

    public static String M(byte[] bArr, byte[] bArr2) {
        return i.k(K(bArr, bArr2));
    }

    public static byte[] N(byte[] bArr) {
        return r0(bArr, "MD2");
    }

    public static String O(String str) {
        return (str == null || str.length() == 0) ? "" : P(str.getBytes());
    }

    public static String P(byte[] bArr) {
        return i.k(N(bArr));
    }

    public static byte[] Q(byte[] bArr) {
        return r0(bArr, "MD5");
    }

    /* JADX WARN: Code duplicated, block: B:43:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:33:0x0048 */
    public static byte[] R(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                fileInputStream2 = new FileInputStream(file);
                try {
                    DigestInputStream digestInputStream = new DigestInputStream(fileInputStream2, MessageDigest.getInstance("MD5"));
                    while (digestInputStream.read(new byte[262144]) > 0) {
                    }
                    byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return bArrDigest;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                fileInputStream2 = null;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return null;
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                fileInputStream2 = null;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream3 = fileInputStream;
        }
    }

    public static byte[] S(String str) {
        return R(i.C0(str) ? null : new File(str));
    }

    public static String T(File file) {
        return i.k(R(file));
    }

    public static String U(String str) {
        return T(i.C0(str) ? null : new File(str));
    }

    public static String V(String str) {
        return (str == null || str.length() == 0) ? "" : X(str.getBytes());
    }

    public static String W(String str, String str2) {
        if (str == null && str2 == null) {
            return "";
        }
        if (str2 == null) {
            return i.k(Q(str.getBytes()));
        }
        if (str == null) {
            return i.k(Q(str2.getBytes()));
        }
        return i.k(Q((str + str2).getBytes()));
    }

    public static String X(byte[] bArr) {
        return i.k(Q(bArr));
    }

    public static String Y(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return "";
        }
        if (bArr2 == null) {
            return i.k(Q(bArr));
        }
        if (bArr == null) {
            return i.k(Q(bArr2));
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return i.k(Q(bArr3));
    }

    public static byte[] Z(byte[] bArr, byte[] bArr2, int i, String str) {
        return v0(bArr, bArr2, i, str, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "DESede", str, bArr3, false);
    }

    public static byte[] a0(byte[] bArr, byte[] bArr2, int i, String str) {
        return i.d(Z(bArr, bArr2, i, str));
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "AES", str, bArr3, false);
    }

    public static String b0(byte[] bArr, byte[] bArr2, int i, String str) {
        return i.k(Z(bArr, bArr2, i, str));
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return b(i.c(bArr), bArr2, str, bArr3);
    }

    public static byte[] c0(byte[] bArr) {
        return r0(bArr, "SHA-1");
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return g(i.c(bArr), bArr2, str, bArr3);
    }

    public static String d0(String str) {
        return (str == null || str.length() == 0) ? "" : e0(str.getBytes());
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, int i, String str) {
        return l(i.c(bArr), bArr2, i, str);
    }

    public static String e0(byte[] bArr) {
        return i.k(c0(bArr));
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return a(i.c(bArr), bArr2, str, bArr3);
    }

    public static byte[] f0(byte[] bArr) {
        return r0(bArr, "SHA224");
    }

    public static byte[] g(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "DES", str, bArr3, false);
    }

    public static String g0(String str) {
        return (str == null || str.length() == 0) ? "" : h0(str.getBytes());
    }

    public static byte[] h(String str, byte[] bArr, String str2, byte[] bArr2) {
        return a(i.j0(str), bArr, str2, bArr2);
    }

    public static String h0(byte[] bArr) {
        return i.k(f0(bArr));
    }

    public static byte[] i(String str, byte[] bArr, String str2, byte[] bArr2) {
        return b(i.j0(str), bArr, str2, bArr2);
    }

    public static byte[] i0(byte[] bArr) {
        return r0(bArr, Client.HASH_SHA256);
    }

    public static byte[] j(String str, byte[] bArr, String str2, byte[] bArr2) {
        return g(i.j0(str), bArr, str2, bArr2);
    }

    public static String j0(String str) {
        return (str == null || str.length() == 0) ? "" : k0(str.getBytes());
    }

    public static byte[] k(String str, byte[] bArr, int i, String str2) {
        return l(i.j0(str), bArr, i, str2);
    }

    public static String k0(byte[] bArr) {
        return i.k(i0(bArr));
    }

    public static byte[] l(byte[] bArr, byte[] bArr2, int i, String str) {
        return v0(bArr, bArr2, i, str, false);
    }

    public static byte[] l0(byte[] bArr) {
        return r0(bArr, "SHA-384");
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "DESede", str, bArr3, true);
    }

    public static String m0(String str) {
        return (str == null || str.length() == 0) ? "" : n0(str.getBytes());
    }

    public static byte[] n(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return i.d(m(bArr, bArr2, str, bArr3));
    }

    public static String n0(byte[] bArr) {
        return i.k(l0(bArr));
    }

    public static String o(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return i.k(m(bArr, bArr2, str, bArr3));
    }

    public static byte[] o0(byte[] bArr) {
        return r0(bArr, "SHA-512");
    }

    public static byte[] p(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "AES", str, bArr3, true);
    }

    public static String p0(String str) {
        return (str == null || str.length() == 0) ? "" : q0(str.getBytes());
    }

    public static byte[] q(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return i.d(p(bArr, bArr2, str, bArr3));
    }

    public static String q0(byte[] bArr) {
        return i.k(o0(bArr));
    }

    public static String r(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return i.k(p(bArr, bArr2, str, bArr3));
    }

    public static byte[] r0(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] s(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "DES", str, bArr3, true);
    }

    public static byte[] s0(byte[] bArr, byte[] bArr2, String str) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, str);
                Mac mac = Mac.getInstance(str);
                mac.init(secretKeySpec);
                return mac.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] t(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return i.d(s(bArr, bArr2, str, bArr3));
    }

    public static byte[] t0(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String u(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return i.k(s(bArr, bArr2, str, bArr3));
    }

    public static byte[] u0(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null) {
            return null;
        }
        if (bArr2.length < 1 || bArr2.length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        byte[] bArr3 = new byte[256];
        byte[] bArr4 = new byte[256];
        int length = bArr2.length;
        for (int i = 0; i < 256; i++) {
            bArr3[i] = (byte) i;
            bArr4[i] = bArr2[i % length];
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            byte b = bArr3[i3];
            i2 = (i2 + b + bArr4[i3]) & 255;
            byte b2 = bArr3[i2];
            bArr3[i2] = b;
            bArr3[i3] = b2;
        }
        byte[] bArr5 = new byte[bArr.length];
        int i4 = 0;
        for (int i5 = 0; i5 < bArr.length; i5++) {
            i4 = (i4 + 1) & 255;
            byte b3 = bArr3[i4];
            i2 = (i2 + b3) & 255;
            byte b4 = bArr3[i2];
            bArr3[i2] = b3;
            bArr3[i4] = b4;
            bArr5[i5] = (byte) (bArr3[(b4 + bArr3[i2]) & 255] ^ bArr[i5]);
        }
        return bArr5;
    }

    public static byte[] v(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacMD5");
    }

    public static byte[] v0(byte[] bArr, byte[] bArr2, int i, String str, boolean z) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                KeyFactory keyFactory = Build.VERSION.SDK_INT < 28 ? KeyFactory.getInstance("RSA", "BC") : KeyFactory.getInstance("RSA");
                Key keyGeneratePublic = z ? keyFactory.generatePublic(new X509EncodedKeySpec(bArr2)) : keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
                if (keyGeneratePublic == null) {
                    return null;
                }
                Cipher cipher = Cipher.getInstance(str);
                cipher.init(z ? 1 : 2, keyGeneratePublic);
                int length = bArr.length;
                int i2 = i / 8;
                if (z && str.toLowerCase().endsWith("pkcs1padding")) {
                    i2 -= 11;
                }
                int i3 = length / i2;
                if (i3 <= 0) {
                    return cipher.doFinal(bArr);
                }
                byte[] bArrT0 = new byte[0];
                byte[] bArr3 = new byte[i2];
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    System.arraycopy(bArr, i4, bArr3, 0, i2);
                    bArrT0 = t0(bArrT0, cipher.doFinal(bArr3));
                    i4 += i2;
                }
                if (i4 == length) {
                    return bArrT0;
                }
                int i6 = length - i4;
                byte[] bArr4 = new byte[i6];
                System.arraycopy(bArr, i4, bArr4, 0, i6);
                return t0(bArrT0, cipher.doFinal(bArr4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String w(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : x(str.getBytes(), str2.getBytes());
    }

    public static byte[] w0(byte[] bArr, byte[] bArr2, String str, String str2, byte[] bArr3, boolean z) {
        SecretKey secretKeySpec;
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                if ("DES".equals(str)) {
                    secretKeySpec = SecretKeyFactory.getInstance(str).generateSecret(new DESKeySpec(bArr2));
                } else {
                    secretKeySpec = new SecretKeySpec(bArr2, str);
                }
                Cipher cipher = Cipher.getInstance(str2);
                int i = 1;
                if (bArr3 == null || bArr3.length == 0) {
                    if (!z) {
                        i = 2;
                    }
                    cipher.init(i, secretKeySpec);
                } else {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                    if (!z) {
                        i = 2;
                    }
                    cipher.init(i, secretKeySpec, ivParameterSpec);
                }
                return cipher.doFinal(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static String x(byte[] bArr, byte[] bArr2) {
        return i.k(v(bArr, bArr2));
    }

    public static byte[] y(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA1");
    }

    public static String z(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : A(str.getBytes(), str2.getBytes());
    }
}
