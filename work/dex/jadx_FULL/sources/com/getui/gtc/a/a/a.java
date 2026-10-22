package com.getui.gtc.a.a;

import android.os.Build;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f30242a;

    /* JADX INFO: renamed from: com.getui.gtc.a.a.a$a, reason: collision with other inner class name */
    public static class C0643a extends Provider {
        public C0643a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    public static String a() {
        try {
            byte[] bArr = new byte[20];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return b(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return b(b(bArr, bArr2, bArr3));
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & com.google.common.base.a.q));
    }

    public static byte[] a(byte[] bArr) {
        SecureRandom secureRandom;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                byte[] bArr2 = f30242a;
                if (bArr2 != null) {
                    return bArr2;
                }
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } else {
                secureRandom = SecureRandom.getInstance("SHA1PRNG", new C0643a());
            }
            secureRandom.setSeed(bArr);
            keyGenerator.init(128, secureRandom);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            if (i >= 28 && f30242a == null) {
                f30242a = encoded;
            }
            return encoded;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return null;
        }
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            a(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(bArr), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr2);
        } catch (Throwable unused) {
            return null;
        }
    }
}
