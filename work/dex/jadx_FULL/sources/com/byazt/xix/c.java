package com.byazt.xix;

import android.util.Base64;
import com.byazt.nr.a;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 664, 20})
public class c {
    public static final byte[] c = "0000000000000000".getBytes();

    public static String c(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return a.c(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(byte[] bArr, String str) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            cipher.init(1, rSAPublicKey);
            return a.c(cipher.doFinal(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(boolean z, byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(c);
            if (z) {
                cipher.init(1, secretKeySpec, ivParameterSpec);
            } else {
                cipher.init(2, secretKeySpec, ivParameterSpec);
            }
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            if (z) {
                return a.c(bArrDoFinal);
            }
            return new String(bArrDoFinal);
        } catch (Exception unused) {
            return "";
        }
    }
}
