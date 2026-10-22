package com.getui.gtc.a.a;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f30259a = "RSA";
    private static String b = "RSA/NONE/OAEPWithSHA1AndMGF1Padding";

    public static PublicKey a(byte[] bArr) {
        try {
            return KeyFactory.getInstance(f30259a).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(b);
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
