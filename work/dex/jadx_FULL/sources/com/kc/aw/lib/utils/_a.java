package com.kc.aw.lib.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.kc.aw._c9;
import com.kc.aw._cc;
import com.kc.aw._jf;
import com.kc.aw._jw;
import com.kc.aw._m4;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.PtgSDKConfig;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a {
    public static Random _a = new Random();
    public static final Random _b = new Random();
    public static long _c = 0;
    public static String _d;
    public static String _e;

    public static int _a() {
        if (ScreenUtils.GUBED) {
            return 11;
        }
        _cc._c();
        if (_cc._e) {
            return 12;
        }
        _cc._c();
        if (_cc._f) {
            return 13;
        }
        _cc._c();
        return _cc._g ? 14 : 10;
    }

    public static String _a(String str) {
        return new String(Base64.decode(str, 2));
    }

    public static String _a(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes = str2.getBytes("ASCII");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bytes));
        return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 2);
    }

    public static String _a(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes = str.getBytes("ASCII");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bytes));
        return new String(cipher.doFinal(bArr), "UTF-8");
    }

    public static boolean _a(long j) {
        return j == 0 || System.currentTimeMillis() - j > 60000;
    }

    public static boolean _a(List<String> list) {
        boolean zContains;
        _c9 _c9Var;
        if (ScreenUtils.GUBED) {
            return true;
        }
        if (list == null || list.isEmpty() || (_c9Var = _m4._a) == null) {
            zContains = false;
        } else {
            zContains = list.contains(_c9Var._a) ? true : list.contains(_m4._a._d);
        }
        if (zContains) {
            return true;
        }
        _cc._c();
        if (!_cc._e) {
            _cc._c();
            if (!_cc._f) {
                _cc._c();
                if (!_cc._g) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int _b() {
        String str;
        String str2;
        try {
            str = Build.BRAND;
            str2 = Build.MANUFACTURER;
        } catch (Exception unused) {
        }
        if (!((str != null && str.equalsIgnoreCase("HONOR")) || (str2 != null && str2.equalsIgnoreCase("HONOR"))) || PtgAdSdk.getContext() == null) {
            return -1;
        }
        try {
            return ((Integer) Class.forName(new String(Base64.decode("YW5kcm9pZC5wcm92aWRlci5TZXR0aW5ncyRTeXN0ZW0=", 2))).getMethod("getInt", ContentResolver.class, String.class, Integer.TYPE).invoke(null, PtgAdSdk.getContext().getContentResolver(), new String(Base64.decode("YXBwbGljYXRpb25fYXV0b19qdW1wX3N3aXRjaA==", 2)), -1)).intValue();
        } catch (Exception unused2) {
            return -1;
        }
    }

    public static String _b(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String _c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                str = new BigInteger(1, messageDigest.digest()).toString(16);
                while (str.length() < 32) {
                    str = "0" + str;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static boolean _c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - _c <= 600;
        _c = jCurrentTimeMillis;
        return z;
    }

    public static String _d(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            StringBuilder sb_a = _jf._a("urlEncode error: ");
            sb_a.append(e.getMessage());
            Logger.e(sb_a.toString());
            return str;
        }
    }

    public static boolean _d() {
        int i = Build.VERSION.SDK_INT;
        PtgSDKConfig config = PtgAdSdk.getConfig();
        if (config._I == null) {
            try {
                Context context = PtgAdSdk.getContext();
                if (context != null) {
                    String str_c = _jw._c(context, "sdk_local_less_than");
                    if (!TextUtils.isEmpty(str_c) && TextUtils.isDigitsOnly(str_c)) {
                        config._I = Integer.valueOf(Integer.parseInt(str_c));
                    }
                }
            } catch (Exception unused) {
            }
            if (config._I == null) {
                config._I = 24;
            }
        }
        return i < config._I.intValue();
    }

    public static boolean _e() {
        return true;
    }
}
