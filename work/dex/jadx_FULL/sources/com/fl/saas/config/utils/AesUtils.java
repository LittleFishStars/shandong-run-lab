package com.fl.saas.config.utils;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SuppressLint({"NewApi"})
public class AesUtils {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM2 = "AES/ECB/PKCS5Padding";
    private static final String IV = "ABCDEF1234567890";
    private static final String KEY = "!@#_123_sda_12!_";

    public static String binaryToString(String str) {
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
        return Base64Utils.encode(bArr);
    }

    public static String decrypt(String str) {
        return decrypt(str, KEY, IV, ALGORITHM);
    }

    public static String decrypt(String str, String str2) {
        return decrypt(str, str2, ALGORITHM);
    }

    public static String decrypt(String str, String str2, String str3) {
        return decrypt(str, str2, (String) null, str3);
    }

    public static String decrypt(String str, String str2, String str3, String str4) {
        try {
            byte[] bArrDecrypt = decrypt(Base64Utils.safeUrlBase64Decode(str), str2.getBytes(StandardCharsets.UTF_8), str3 != null ? str3.getBytes(StandardCharsets.UTF_8) : null, str4);
            Objects.requireNonNull(bArrDecrypt);
            return new String(bArrDecrypt, StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException | NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr, String str2) {
        try {
            return new String(decrypt(Base64Utils.safeUrlBase64Decode(str), bArr, (byte[]) null, str2), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
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

    public static byte[] decryptBytes(String str) {
        return Base64Utils.decode(decrypt(hexToBinary(str), KEY, "AES/ECB/PKCS5Padding"));
    }

    public static String decryptHex(String str) {
        return decryptHex(str, KEY, IV, ALGORITHM);
    }

    public static String decryptHex(String str, String str2) {
        return decryptHex(str, str2, ALGORITHM);
    }

    public static String decryptHex(String str, String str2, String str3) {
        return decryptHex(str, str2, null, str3);
    }

    public static String decryptHex(String str, String str2, String str3, String str4) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance(str4);
            if (str3 != null) {
                cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes(StandardCharsets.UTF_8)));
            } else {
                cipher.init(2, secretKeySpec);
            }
            return new String(cipher.doFinal(parseHexStr2Byte(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptJson(String str) {
        return decrypt(hexToBinary(str), KEY, "AES/ECB/PKCS5Padding");
    }

    public static String encrypt(String str) {
        return encrypt(str, KEY, IV, ALGORITHM);
    }

    public static String encrypt(String str, String str2) {
        return encrypt(str, str2, ALGORITHM);
    }

    public static String encrypt(String str, String str2, String str3) {
        return encrypt(str, str2, (String) null, str3);
    }

    public static String encrypt(String str, String str2, String str3, String str4) {
        return encrypt(str.getBytes(StandardCharsets.UTF_8), str2.getBytes(StandardCharsets.UTF_8), str3 != null ? str3.getBytes(StandardCharsets.UTF_8) : null, str4);
    }

    public static String encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(str);
            if (bArr3 != null) {
                cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            } else {
                cipher.init(1, secretKeySpec);
            }
            return Base64Utils.safeUrlBase64Encode(cipher.doFinal(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt2(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            return Base64Utils.safeUrlBase64Encode(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8))).replace('+', '-').replace('/', '_').replaceAll("=", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encryptHex(String str) {
        return encryptHex(str, KEY, IV, ALGORITHM);
    }

    public static String encryptHex(String str, String str2) {
        return encryptHex(str, str2, ALGORITHM);
    }

    public static String encryptHex(String str, String str2, String str3) {
        return encryptHex(str, str2, null, ALGORITHM);
    }

    public static String encryptHex(String str, String str2, String str3, String str4) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance(str4);
            if (str3 != null) {
                cipher.init(1, secretKeySpec, new IvParameterSpec(str3.getBytes(StandardCharsets.UTF_8)));
            } else {
                cipher.init(1, secretKeySpec);
            }
            return parseByte2HexStr(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String hexToBinary(String str) {
        try {
            String strReplace = str.replace("0x", "").replace(" ", "");
            String string = new BigInteger(strReplace, 16).toString(2);
            int length = strReplace.length() * 4;
            if (string.length() < length) {
                string = String.format("%" + length + "s", string).replace(' ', '0');
            }
            return binaryToString(string);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }
}
