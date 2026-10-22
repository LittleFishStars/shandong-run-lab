package com.kwad.sdk.core.a;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g {
    private static byte[] a(byte[] bArr, Cipher cipher, int i) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int length = bArr.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = length - i2;
                    if (i4 <= 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byte[] bArrDoFinal = cipher.doFinal(bArr, i2, Math.min(i4, i));
                    byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                    i3++;
                    i2 = i3 * i;
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    return new byte[0];
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return new byte[0];
        }
    }

    public static byte[] e(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (str == null || str.isEmpty()) {
            return null;
        }
        RSAPublicKey rSAPublicKeyEH = eH(str);
        Cipher cipher = Cipher.getInstance(com.alipay.sdk.m.b0.a.e);
        cipher.init(1, rSAPublicKeyEH);
        return a(bArr, cipher, (rSAPublicKeyEH.getModulus().bitLength() / 8) - 66);
    }

    private static RSAPublicKey eH(String str) {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(c.LP().decode(str)));
    }
}
