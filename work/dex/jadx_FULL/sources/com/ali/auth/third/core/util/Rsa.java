package com.ali.auth.third.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Rsa {
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    private static PublicKey a(String str, String str2) throws Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(Base64.decode(str2)));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0061: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x0061 */
    public static String encrypt(String str, String str2) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                PublicKey publicKeyA = a("RSA", str2);
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, publicKeyA);
                byte[] bytes = str.getBytes("UTF-8");
                int blockSize = cipher.getBlockSize();
                byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i = 0; i < bytes.length; i += blockSize) {
                    try {
                        byteArrayOutputStream.write(cipher.doFinal(bytes, i, bytes.length - i < blockSize ? bytes.length - i : blockSize));
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (byteArrayOutputStream == null) {
                            return null;
                        }
                        try {
                            byteArrayOutputStream.close();
                            return null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                }
                String str3 = new String(Base64.encode(byteArrayOutputStream.toByteArray()));
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return str3;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream3 != null) {
                byteArrayOutputStream3.close();
            }
            throw th;
        }
    }
}
