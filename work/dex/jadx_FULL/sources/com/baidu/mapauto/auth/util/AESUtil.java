package com.baidu.mapauto.auth.util;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class AESUtil {
    private static final String ALGORITHM_NAME = "AES";
    private static final String TRANSFORMATION = "AES/ECB/NoPadding";

    private AESUtil() {
    }

    public static byte[] decrypt(String str, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(StandardCharsets.UTF_8), ALGORITHM_NAME);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] encrypt(String str, byte[] bArr) throws Exception {
        if (str == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), ALGORITHM_NAME);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr);
    }
}
