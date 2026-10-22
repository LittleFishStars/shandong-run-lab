package com.efs.sdk.base.core.util.secure;

import android.util.Base64;
import com.efs.sdk.base.core.util.Log;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class EncodeUtil {
    public static byte[] base64Decode(byte[] bArr) {
        return Base64.decode(bArr, 11);
    }

    public static String base64DecodeToStr(byte[] bArr) {
        try {
            return new String(base64Decode(bArr));
        } catch (Throwable th) {
            Log.e("efs.base", "decode error", th);
            return "";
        }
    }

    public static byte[] base64Encode(byte[] bArr) {
        return Base64.encode(bArr, 11);
    }

    public static String base64EncodeToStr(byte[] bArr) {
        return new String(base64Encode(bArr));
    }

    public static String md5(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        try {
            return String.format(Locale.CHINA, "%032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e) {
            Log.e("efs.base", "md5 error", e);
            return "";
        }
    }

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("efs.base", "urlEncode error", e);
            return "";
        }
    }
}
