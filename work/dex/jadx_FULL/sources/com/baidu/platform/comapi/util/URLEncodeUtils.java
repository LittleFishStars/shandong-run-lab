package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class URLEncodeUtils extends JNIBaseApi {
    public static String generateSign(int i, String str) {
        if (i == 1) {
            return nativeMD5Sign(str);
        }
        if (i == 2) {
            return nativeWebSign(str);
        }
        return i == 3 ? nativeOperSign(str) : "";
    }

    public static String getMD5String(String str) {
        return MD5.getMD5String(str);
    }

    public static String getUrlParamsSign(String str) {
        return nativeGetUrlParamsSign(str);
    }

    private static native String nativeGetUrlParamsSign(String str);

    private static native String nativeMD5Sign(String str);

    private static native String nativeOperSign(String str);

    private static native String nativeUrlEncode(String str);

    private static native String nativeWebSign(String str);

    public static String urlEncode(String str) {
        return nativeUrlEncode(str);
    }
}
