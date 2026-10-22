package com.kc.dw.core.utils;

import android.util.Base64;
import com.google.gson.Gson;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f39393a = new Gson();

    public static String a(Map<String, Object> map) {
        String strA;
        if (map.containsKey("msec")) {
            try {
                strA = (String) map.get("msec");
                try {
                    strA = a(strA.getBytes());
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                strA = "";
            }
        } else {
            strA = "";
        }
        byte[] bArrA = a("884942f0e6454745814d5042ef23f4a6");
        byte[] bArrA2 = a(strA);
        try {
            String json = f39393a.toJson(map);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.getBlockSize();
            byte[] bytes = json.getBytes();
            cipher.init(1, new SecretKeySpec(bArrA, "AES"), new IvParameterSpec(bArrA2));
            byte[] bArrDoFinal = cipher.doFinal(bytes);
            byte[] bArr = new byte[bArrA2.length + bArrDoFinal.length];
            System.arraycopy(bArrA2, 0, bArr, 0, bArrA2.length);
            System.arraycopy(bArrDoFinal, 0, bArr, bArrA2.length, bArrDoFinal.length);
            Charset charset = d1.f39359a;
            return Base64.encodeToString(bArr, 2).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bArr);
        String string = new BigInteger(1, messageDigest.digest()).toString(16);
        return new String(new char[32 - string.length()]).replace("\u0000", "0") + string;
    }

    public static byte[] a(String str) {
        byte[] bArr;
        int length = str.length();
        if (length % 2 == 1) {
            length++;
            bArr = new byte[length / 2];
            str = com.kc.dw.ad.w.a("0", str);
        } else {
            bArr = new byte[length / 2];
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i, i3), 16);
            i2++;
            i = i3;
        }
        return bArr;
    }
}
