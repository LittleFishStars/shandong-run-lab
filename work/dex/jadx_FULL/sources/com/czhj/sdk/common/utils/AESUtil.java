package com.czhj.sdk.common.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.b0.a;
import com.czhj.sdk.common.Constants;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AESUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29426a = 12;
    private static final int b = 128;
    private static volatile byte[] c;

    public static byte[] DeOREncrypt(byte[] bArr, String str, int i, String str2) throws Exception {
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
            return bArr;
        }
        byte[] bArrDecode = !TextUtils.isEmpty(str2) ? Base64.decode(str2, 2) : generateNonce();
        Cipher cipher = Cipher.getInstance(a.f);
        cipher.init(i, new SecretKeySpec(str.getBytes("UTF-8"), "AES"), new GCMParameterSpec(128, bArrDecode));
        return cipher.doFinal(bArr);
    }

    public static String DecryptString(String str, String str2) {
        return DecryptString(str, str2, Constants.GCMNONCE);
    }

    public static String DecryptString(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            return new String(DeOREncrypt(Base64.decode(str.getBytes("UTF-8"), 2), str2, 2, str3), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String DecryptStringServer(String str, String str2) {
        return DecryptString(str, str2, null);
    }

    public static byte[] Encrypt(byte[] bArr, String str) {
        return Encrypt(bArr, str, null);
    }

    public static byte[] Encrypt(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
            return bArr;
        }
        try {
            return DeOREncrypt(bArr, str, 1, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String EncryptString(String str, String str2) {
        return EncryptString(str, str2, Constants.GCMNONCE);
    }

    public static String EncryptString(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            return Base64.encodeToString(Encrypt(str.getBytes("UTF-8"), str2, str3), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String EncryptStringServer(String str, String str2) {
        return EncryptString(str, str2, null);
    }

    public static byte[] decrypt(byte[] bArr, String str) {
        try {
            return DeOREncrypt(bArr, str, 2, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static synchronized byte[] generateNonce() {
        if (c == null) {
            c = new byte[12];
            new SecureRandom().nextBytes(c);
        }
        return c;
    }
}
