package com.huawei.secure.android.common.util;

import android.webkit.URLUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class UrlUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f37767a = "file:///android_res/";

    public static boolean isAboutUrl(String str) {
        return URLUtil.isAboutUrl(str);
    }

    public static boolean isAssetUrl(String str) {
        return URLUtil.isAssetUrl(str);
    }

    public static boolean isContentUrl(String str) {
        return URLUtil.isContentUrl(str);
    }

    public static boolean isDataUrl(String str) {
        return URLUtil.isDataUrl(str);
    }

    public static boolean isFileUrl(String str) {
        return URLUtil.isFileUrl(str);
    }

    public static boolean isHttpUrl(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public static boolean isHttpsUrl(String str) {
        return URLUtil.isHttpsUrl(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        return URLUtil.isJavaScriptUrl(str);
    }

    public static boolean isNetworkUrl(String str) {
        return URLUtil.isNetworkUrl(str);
    }

    public static boolean isResourceUrl(String str) {
        return str != null && str.startsWith(f37767a);
    }

    public static boolean isValidUrl(String str) {
        return URLUtil.isValidUrl(str);
    }
}
