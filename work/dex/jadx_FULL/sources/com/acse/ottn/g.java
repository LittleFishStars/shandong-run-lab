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
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23009a = "AES/ECB/PKCS5Padding";
    public static g b;

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g();
                }
            }
        }
        return b;
    }

    public static byte[] c(String str, String str2) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
        return cipher.doFinal(str.getBytes("utf-8"));
    }

    public final Object b() throws ObjectStreamException {
        return b;
    }

    public String b(String str, boolean z) {
        String strA = l0.a(z);
        if (TextUtils.isEmpty(strA)) {
            return str;
        }
        try {
            return b(str, strA);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String b(String str, String str2) throws Exception {
        return a(c(str, str2));
    }

    public String a(String str, boolean z) {
        String strA = l0.a(z);
        if (TextUtils.isEmpty(strA)) {
            return str;
        }
        try {
            return a(str, strA);
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

    public static byte[] a(String str) throws Exception {
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

    public String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(a(jSONObject.getString("content")), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
