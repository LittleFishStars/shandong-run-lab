package com.igexin.push.g;

import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.base.crypt.CryptTools;
import java.security.MessageDigest;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f38146a = "MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAJp1rROuvBF7sBSnvLaesj2iFhMcY8aXyLvpnNLKs2wjL3JmEnyr++SlVa35liUlzi83tnAFkn3A9GB7pHBNzawyUkBh8WUhq5bnFIkk2RaDa6+5MpG84DEv52p7RR+aWwIDAQAB";
    public static String b = "69d747c4b9f641baf4004be4297e9f3b";
    public static String c = "";
    public static String d = "";
    private static final String e = "com.igexin.push.g.g";
    private static boolean f = false;
    private static int g = 0;
    private static byte[] h = null;
    private static byte[] i = null;
    private static final int j = 200;

    static {
        try {
            h = h();
            byte[] bArrG = g();
            i = bArrG;
            f = (h == null || bArrG == null || b.getBytes() == null) ? false : true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "|load key error = " + th.toString(), new Object[0]);
            f = false;
            d = th.getMessage();
        }
        if (f) {
            String str = e;
            com.igexin.c.a.c.a.a(str, "load Encrypt key success ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "|load  Encrypt key success ~~~~~~~", new Object[0]);
            return;
        }
        String str2 = e;
        com.igexin.c.a.c.a.a(str2, "load key error ++++++++");
        com.igexin.c.a.c.a.a(str2 + "|load key error ++++++++", new Object[0]);
        if (TextUtils.isEmpty(d)) {
            d = "value = null, normal error";
        }
    }

    public static String a(String str, byte[] bArr) throws Exception {
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[bytes.length + bArr.length];
        int iA = com.igexin.c.a.b.g.a(bytes, bArr2, 0, bytes.length);
        if (bArr.length > 0) {
            com.igexin.c.a.b.g.a(bArr, bArr2, iA, bArr.length);
        }
        return Base64.encodeToString(d(bArr2), 2);
    }

    public static boolean a() {
        return f;
    }

    public static byte[] a(com.igexin.push.d.c.a aVar, int i2, int i3) {
        byte[] bArr = new byte[aVar.f38096a + 11];
        com.igexin.c.a.b.g.a(i2, bArr, 0);
        com.igexin.c.a.b.g.a(i3, bArr, 4);
        com.igexin.c.a.b.g.b((short) aVar.f38096a, bArr, 8);
        bArr[10] = aVar.b;
        com.igexin.c.a.b.g.a(aVar.e, bArr, 11, aVar.f38096a);
        return d(bArr);
    }

    public static byte[] a(byte[] bArr) {
        return com.igexin.c.a.a.a.b(bArr, com.igexin.push.core.e.M);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return CryptTools.encrypt("AES/CFB/NoPadding", new SecretKeySpec(i, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable unused) {
            String str = e;
            com.igexin.c.a.c.a.a(str, " httpId encrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "| httpId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] b() {
        if (!f) {
            return new byte[0];
        }
        try {
            byte[] bArr = h;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", CryptTools.parsePublicKey("RSA", f38146a), bArr2);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| getSocketAESKey  fail ~~~~~~~" + th.getMessage(), new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr) {
        return c(bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            return CryptTools.decrypt("AES/CFB/NoPadding", new SecretKeySpec(i, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable unused) {
            String str = e;
            com.igexin.c.a.c.a.a(str, " httpId decrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "| httpId decrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] c() {
        return b.getBytes();
    }

    public static byte[] c(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        try {
            return CryptTools.encrypt("AES/CFB/NoPadding", new SecretKeySpec(h, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable unused) {
            String str = e;
            com.igexin.c.a.c.a.a(str, " sockeId encrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "| sockeId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static boolean d() {
        try {
            h = h();
            byte[] bArrG = g();
            i = bArrG;
            f = (h == null || bArrG == null || b.getBytes() == null) ? false : true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "|load key error = " + th.toString(), new Object[0]);
            f = false;
        }
        if (f) {
            String str = e;
            com.igexin.c.a.c.a.a(str, "load key success ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "|load key success ~~~~~~~", new Object[0]);
        } else {
            String str2 = e;
            com.igexin.c.a.c.a.a(str2, "load key error ++++++++");
            com.igexin.c.a.c.a.a(str2 + "|load key error ++++++++", new Object[0]);
        }
        return f;
    }

    private static byte[] d(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return CryptTools.decrypt("AES/CFB/NoPadding", new SecretKeySpec(h, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| sockeId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static int e() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bytes = c.getBytes();
            byte[] bArr3 = new byte[bytes.length];
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bArr3[i2] = (byte) (~(bytes[(bytes.length - i2) - 1] & 255));
            }
            return CryptTools.decrypt("AES/CFB/NoPadding", new SecretKeySpec(c(bArr3), "AES"), new IvParameterSpec(c(bArr2)), bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| altAesDecSocket  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static String f() {
        byte[] bArrJ = j();
        byte[] bytes = p.b().getBytes();
        byte[] bArr = new byte[bytes.length + bArrJ.length];
        com.igexin.c.a.b.g.a(bArrJ, bArr, com.igexin.c.a.b.g.a(bytes, bArr, 0, bytes.length), bArrJ.length);
        return Base64.encodeToString(bArr, 2);
    }

    private static byte[] f(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bytes = c.getBytes();
            byte[] bArr3 = new byte[bytes.length];
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bArr3[i2] = (byte) (~(bytes[(bytes.length - i2) - 1] & 255));
            }
            return CryptTools.encrypt("AES/CFB/NoPadding", new SecretKeySpec(c(bArr3), "AES"), new IvParameterSpec(c(bArr2)), bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| altAesEncSocket  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    private static byte[] g() {
        try {
            return CryptTools.generateKey("AES", 128).getEncoded();
        } catch (Throwable unused) {
            String str = e;
            com.igexin.c.a.c.a.a(str, "generate  http key fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "|generate  http key fail ~~~~~~~", new Object[0]);
            return null;
        }
    }

    private static byte[] h() {
        try {
            return CryptTools.generateKey("AES", 128).getEncoded();
        } catch (Throwable unused) {
            String str = e;
            com.igexin.c.a.c.a.a(str, "generate  socket key fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "|generate  socket key fail ~~~~~~~", new Object[0]);
            return null;
        }
    }

    private static byte[] i() {
        return new byte[0];
    }

    private static byte[] j() {
        try {
            byte[] bArr = i;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", CryptTools.parsePublicKey("RSA", f38146a), bArr2);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| getHttpAESKey  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }
}
