package com.alibaba.ariver.commonability.file;

import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24025a = "H5UrlHelper";
    private static LruCache<String, Uri> b = new LruCache<>(20);
    private static LruCache<String, String> c = new LruCache<>(20);

    public static String a(String str) {
        String strSubstring;
        String str2 = c.get(str);
        if (str2 != null) {
            return str2;
        }
        try {
            int iIndexOf = str.indexOf("#");
            strSubstring = iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
            try {
                if (strSubstring.contains("??")) {
                    c.put(str, strSubstring);
                    return strSubstring;
                }
                int iIndexOf2 = strSubstring.indexOf("?");
                if (iIndexOf2 != -1) {
                    strSubstring = strSubstring.substring(0, iIndexOf2);
                }
                c.put(str, strSubstring);
                return strSubstring;
            } catch (Throwable unused) {
                c.put(str, strSubstring);
                return strSubstring;
            }
        } catch (Throwable unused2) {
            strSubstring = str;
        }
    }

    public static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = b.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            b.put(str, uri);
            return uri;
        } catch (Exception e) {
            RVLogger.e(f24025a, "parse url exception.", e);
            return uri;
        }
    }

    public static String c(String str) {
        Uri uriB = b(str);
        if (uriB != null) {
            return uriB.getHost();
        }
        return null;
    }

    public static String d(String str) {
        Uri uriB = b(str);
        if (uriB != null) {
            return uriB.getScheme();
        }
        return null;
    }

    public static String e(String str) {
        Uri uriB = b(str);
        if (uriB != null) {
            return uriB.getPath();
        }
        return null;
    }

    public static final String f(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            RVLogger.e(f24025a, "Exception", e);
            return null;
        }
    }

    public static final String g(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            RVLogger.e(f24025a, "Exception", e);
            return null;
        }
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("file:///") || str.startsWith("data:")) {
            return null;
        }
        return c(str);
    }

    public static String i(String str) {
        int iIndexOf = str.indexOf(35);
        if (iIndexOf == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iIndexOf);
        RVLogger.d(f24025a, "stripAnchor url:" + str + " afterUrl:" + strSubstring);
        return strSubstring;
    }

    public static String a(Uri uri, String str, String str2) {
        String queryParameter;
        if (uri == null) {
            return str2;
        }
        try {
            queryParameter = uri.getQueryParameter(str);
        } catch (Exception e) {
            RVLogger.e(f24025a, "Exception", e);
            queryParameter = null;
        }
        return TextUtils.isEmpty(queryParameter) ? str2 : queryParameter;
    }

    public static boolean a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return false;
        }
        Uri uriB = b(str);
        if (uriB == null) {
            RVLogger.d(f24025a, "parse auto url failed!");
            return false;
        }
        String host = uriB.getHost();
        if (TextUtils.isEmpty(host)) {
            RVLogger.d(f24025a, "can't get url host");
            return false;
        }
        String lowerCase = host.toLowerCase();
        try {
            for (String str2 : strArr) {
                if (!str2.equalsIgnoreCase(lowerCase)) {
                    if (!lowerCase.endsWith(Consts.DOT + str2)) {
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            RVLogger.e(f24025a, "match auto login exception.", e);
            return false;
        }
    }
}
