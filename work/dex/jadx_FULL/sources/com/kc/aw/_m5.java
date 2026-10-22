package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _m5 {
    public static String _a(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr;
        SecretKeySpec secretKeySpec = new SecretKeySpec("Fm57wPihoyIdroH1".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec("Fm57wPihoyIdroH1".getBytes()));
        if (str.length() < 1) {
            bArr = null;
        } else {
            byte[] bArr2 = new byte[str.length() / 2];
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                int i3 = i2 + 1;
                bArr2[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
            }
            bArr = bArr2;
        }
        return new String(cipher.doFinal(bArr), "utf-8");
    }
}
