package cj.mobile.wm;

import android.content.Context;
import android.util.Base64;
import com.zj.adlib.u15;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ae {
    public static String dexa(Context context) {
        if (context == null) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(u15.f19942b);
            }
            return sb.length() > 1 ? sb.substring(0, sb.length() - 1) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dexa(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, dexb(str2));
            return new String(cipher.doFinal(dexa(str)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] dexa(String str) {
        try {
            return Base64.decode(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dexb(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] bytes = str.getBytes("UTF-8");
            cipher.init(1, dexb(str2));
            return Base64.encodeToString(cipher.doFinal(bytes), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SecretKeySpec dexb(String str) {
        return new SecretKeySpec(str.getBytes("UTF-8"), "AES");
    }
}
