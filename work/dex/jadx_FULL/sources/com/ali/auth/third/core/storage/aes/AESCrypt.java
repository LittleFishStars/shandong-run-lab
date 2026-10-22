package com.ali.auth.third.core.storage.aes;

import android.util.Base64;
import android.util.Log;
import com.ali.auth.third.core.util.CommonUtils;
import com.aliyun.openapiutil.Client;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class AESCrypt {
    public static boolean DEBUG_LOG_ENABLED = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f23437a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private AESCrypt() {
    }

    private static SecretKeySpec a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
        byte[] bytes = str.getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        byte[] bArrDigest = messageDigest.digest();
        a("SHA-256 key ", bArrDigest);
        return new SecretKeySpec(bArrDigest, "AES");
    }

    private static void a(String str, String str2) {
        if (DEBUG_LOG_ENABLED) {
            Log.d("AESCrypt", str + "[" + str2.length() + "] [" + str2 + "]");
        }
    }

    private static void a(String str, byte[] bArr) {
        if (DEBUG_LOG_ENABLED) {
            Log.d("AESCrypt", str + "[" + bArr.length + "] [" + CommonUtils.getHashString(bArr) + "]");
        }
    }

    public static String decrypt(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec secretKeySpecA = a(str);
            a("base64EncodedCipherText", str2);
            byte[] bArrDecode = Base64.decode(str2, 2);
            a("decodedCipherText", bArrDecode);
            byte[] bArrDecrypt = decrypt(secretKeySpecA, f23437a, bArrDecode);
            a("decryptedBytes", bArrDecrypt);
            String str3 = new String(bArrDecrypt, "UTF-8");
            a("message", str3);
            return str3;
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] decrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        a("decryptedBytes", bArrDoFinal);
        return bArrDoFinal;
    }

    public static String encrypt(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec secretKeySpecA = a(str);
            a("message", str2);
            String strEncodeToString = Base64.encodeToString(encrypt(secretKeySpecA, f23437a, str2.getBytes("UTF-8")), 2);
            a("Base64.NO_WRAP", strEncodeToString);
            return strEncodeToString;
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] encrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        a("cipherText", bArrDoFinal);
        return bArrDoFinal;
    }
}
