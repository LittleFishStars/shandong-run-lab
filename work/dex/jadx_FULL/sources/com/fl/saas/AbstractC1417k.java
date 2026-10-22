package com.fl.saas;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: com.fl.saas.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1417k {
    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String strReplaceAll = str.replaceAll("\\s+", "");
        int length = strReplaceAll.length() % 8;
        int i = 0;
        if (length != 0) {
            strReplaceAll = String.format("%-" + ((strReplaceAll.length() + 8) - length) + "s", strReplaceAll).replace(' ', '0');
        }
        int length2 = strReplaceAll.length() / 8;
        byte[] bArr = new byte[length2];
        while (i < length2) {
            int i2 = i + 1;
            bArr[i] = (byte) Integer.parseInt(strReplaceAll.substring(i * 8, i2 * 8), 2);
            i = i2;
        }
        return AbstractC1421m.a(bArr);
    }

    public static String b(String str) {
        return a(str, "!@#_123_sda_12!_", "ABCDEF1234567890", "AES/CBC/PKCS5Padding");
    }

    public static byte[] c(String str) {
        return AbstractC1421m.a(a(f(str), "!@#_123_sda_12!_", "AES/ECB/PKCS5Padding"));
    }

    public static String d(String str) {
        return a(f(str), "!@#_123_sda_12!_", "AES/ECB/PKCS5Padding");
    }

    public static String e(String str) {
        return b(str, "!@#_123_sda_12!_", "ABCDEF1234567890", "AES/CBC/PKCS5Padding");
    }

    public static String f(String str) {
        try {
            String strReplace = str.replace("0x", "").replace(" ", "");
            String string = new BigInteger(strReplace, 16).toString(2);
            int length = strReplace.length() * 4;
            if (string.length() < length) {
                string = String.format("%" + length + "s", string).replace(' ', '0');
            }
            return a(string);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        return a(str, str2, (String) null, str3);
    }

    public static String b(String str, String str2, String str3, String str4) {
        byte[] bytes = str3 != null ? str3.getBytes(StandardCharsets.UTF_8) : null;
        Charset charset = StandardCharsets.UTF_8;
        return b(str.getBytes(charset), str2.getBytes(charset), bytes, str4);
    }

    public static String a(String str, String str2, String str3, String str4) {
        byte[] bytes = str3 != null ? str3.getBytes(StandardCharsets.UTF_8) : null;
        try {
            byte[] bArrB = AbstractC1421m.b(str);
            Charset charset = StandardCharsets.UTF_8;
            byte[] bArrA = a(bArrB, str2.getBytes(charset), bytes, str4);
            Objects.requireNonNull(bArrA);
            return new String(bArrA, charset);
        } catch (UnsupportedEncodingException | NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(str);
            if (bArr3 != null) {
                cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            } else {
                cipher.init(1, secretKeySpec);
            }
            return AbstractC1421m.b(cipher.doFinal(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(str);
            if (bArr3 != null) {
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            } else {
                cipher.init(2, secretKeySpec);
            }
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
