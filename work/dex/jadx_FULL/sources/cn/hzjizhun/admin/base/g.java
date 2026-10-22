package cn.hzjizhun.admin.base;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f22700a = StandardCharsets.UTF_8;

    public static String a(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            Charset charset = f22700a;
            cipher.init(2, new SecretKeySpec("aeskeyisverygood".getBytes(charset), "AES"));
            return new String(cipher.doFinal(bArrDecode), charset);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            for (int i = 0; i < bArrDigest.length; i++) {
                if (Integer.toHexString(bArrDigest[i] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return stringBuffer.toString();
    }

    public static String c(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            Charset charset = f22700a;
            cipher.init(1, new SecretKeySpec("aeskeyisverygood".getBytes(charset), "AES"));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(charset)), 2);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }
}
