package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static KeyPair f26318a;

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && f26318a != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, f26318a.getPrivate());
                return c.a(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8.name());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static KeyPair a() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048, new SecureRandom());
            if (f26318a == null) {
                f26318a = keyPairGenerator.generateKeyPair();
            }
            return f26318a;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() {
        PublicKey publicKey;
        KeyPair keyPair = f26318a;
        if (keyPair == null || (publicKey = keyPair.getPublic()) == null) {
            return null;
        }
        try {
            return c.a(publicKey.getEncoded(), StandardCharsets.UTF_8.name());
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str) {
        if (!TextUtils.isEmpty(str) && f26318a != null) {
            try {
                byte[] bArrA = c.a(str.getBytes(StandardCharsets.UTF_8));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, f26318a.getPrivate());
                return cipher.doFinal(bArrA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
