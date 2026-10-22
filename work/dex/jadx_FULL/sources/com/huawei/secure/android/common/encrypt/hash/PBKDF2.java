package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class PBKDF2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37710a = "PBKDF2";
    private static final String b = "PBKDF2WithHmacSHA1";
    private static final String c = "PBKDF2WithHmacSHA256";
    private static final String d = "";
    private static final int e = 8;
    private static final int f = 16;
    private static final int g = 32;
    private static final int h = 10000;
    private static final int i = 1000;

    private static byte[] a(char[] cArr, byte[] bArr, int i2, int i3, boolean z) {
        try {
            return (z ? SecretKeyFactory.getInstance(c) : SecretKeyFactory.getInstance(b)).generateSecret(new PBEKeySpec(cArr, bArr, i2, i3)).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            b.b(f37710a, "pbkdf exception : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i2, int i3) {
        return a(cArr, bArr, i2, i3, false);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str) {
        return pbkdf2Encrypt(str, 10000);
    }

    public static String pbkdf2EncryptNew(String str) {
        return pbkdf2EncryptNew(str, 10000);
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i2, int i3) {
        return a(cArr, bArr, i2, i3, true);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2) {
        return validatePassword(str, str2, 10000);
    }

    public static boolean validatePasswordNew(String str, String str2) {
        return validatePasswordNew(str, str2, 10000);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, int i2) {
        return pbkdf2Encrypt(str, EncryptUtil.generateSecureRandom(8), i2, 32);
    }

    public static String pbkdf2EncryptNew(String str, int i2) {
        return pbkdf2EncryptNew(str, EncryptUtil.generateSecureRandom(16), i2, 32);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return a(pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(str2.substring(0, 16)), i2, 256), HexUtil.hexStr2ByteArray(str2.substring(16)));
    }

    public static boolean validatePasswordNew(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        return a(pbkdf2SHA256(str.toCharArray(), HexUtil.hexStr2ByteArray(str2.substring(0, 32)), i2, 256), HexUtil.hexStr2ByteArray(str2.substring(32)));
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, byte[] bArr, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            b.b(f37710a, "pwd is null.");
            return "";
        }
        if (i2 < 1000) {
            b.b(f37710a, "iterations times is not enough.");
            return "";
        }
        if (bArr == null || bArr.length < 8) {
            b.b(f37710a, "salt parameter is null or length is not enough");
            return "";
        }
        if (i3 < 32) {
            b.b(f37710a, "cipherLen length is not enough");
            return "";
        }
        return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2(str.toCharArray(), bArr, i2, i3 * 8));
    }

    public static String pbkdf2EncryptNew(String str, byte[] bArr, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            b.b(f37710a, "pwd is null.");
            return "";
        }
        if (i2 < 1000) {
            b.b(f37710a, "iterations times is not enough.");
            return "";
        }
        if (bArr == null || bArr.length < 16) {
            b.b(f37710a, "salt parameter is null or length is not enough");
            return "";
        }
        if (i3 < 32) {
            b.b(f37710a, "cipherLen length is not enough");
            return "";
        }
        b.c(f37710a, "sha 256");
        return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2SHA256(str.toCharArray(), bArr, i2, i3 * 8));
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        int length = bArr.length ^ bArr2.length;
        for (int i2 = 0; i2 < bArr.length && i2 < bArr2.length; i2++) {
            length |= bArr[i2] ^ bArr2[i2];
        }
        return length == 0;
    }
}
