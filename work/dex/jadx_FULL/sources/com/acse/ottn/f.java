package com.acse.ottn;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ObjectStreamException;
import java.math.BigInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22989a = "AES/ECB/PKCS5Padding";
    public static final String b = "VbZFjAoPF6LCCQm6RgDs1g13mnJ8nAAA";
    public static f c;

    public static f b() {
        if (c == null) {
            synchronized (f.class) {
                if (c == null) {
                    c = new f();
                }
            }
        }
        return c;
    }

    public String a(String str, boolean z) {
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        try {
            return a(str, b);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final Object c() throws ObjectStreamException {
        return c;
    }

    public static byte[] c(String str, String str2) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
        return cipher.doFinal(str.getBytes("utf-8"));
    }

    public String a(String str) {
        try {
            return b(str, b);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(byte[] bArr, int i) {
        return new BigInteger(1, bArr).toString(i);
    }

    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 0));
    }

    public static byte[] b(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static String a(byte[] bArr, String str) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(str.getBytes(), "AES"));
        return new String(cipher.doFinal(bArr));
    }

    public String b(String str, String str2) throws Exception {
        return a(c(str, str2));
    }

    public String a(String str, String str2) {
        try {
            return a(b(new JSONObject(str).getJSONObject("data").getString("data")), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String a() {
        try {
            return a(b("HjXtKBoW7DcEoK3ea3il4OtHgf+gL9OSK5ocDH6/z6U="), b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
