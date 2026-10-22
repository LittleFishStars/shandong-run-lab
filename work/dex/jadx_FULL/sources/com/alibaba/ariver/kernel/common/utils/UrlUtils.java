package com.alibaba.ariver.kernel.common.utils;

import android.net.Uri;
import android.os.Bundle;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.core.util.Pair;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.zj.adlib.u15;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UrlUtils {
    public static final String TAG = "AriverKernel:UrlUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LruCache<String, Uri> f24287a = new LruCache<>(20);
    private static LruCache<String, String> b = new LruCache<>(20);
    private static final String c = "_ariver_appid";
    private static final String d = "_ap_ariver_appid";

    public static final String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            RVLogger.e(TAG, "Exception", e);
            return null;
        }
    }

    public static final String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            RVLogger.e(TAG, "Exception", e);
            return null;
        }
    }

    public static final String encodeOffilineUrlForAuth(String str) {
        String fragment;
        try {
            Uri url = parseUrl(str);
            if (url != null) {
                fragment = url.getFragment();
                if (!str.contains(fragment)) {
                    fragment = url.getEncodedFragment();
                }
            } else {
                fragment = null;
            }
            if (fragment == null) {
                return str;
            }
            String strEncode = URLEncoder.encode(fragment, "utf-8");
            try {
                return str.replace(fragment, strEncode);
            } catch (Exception e) {
                e = e;
                str = strEncode;
            }
        } catch (Exception e2) {
            e = e2;
        }
        RVLogger.e(TAG, "Exception", e);
        return str;
    }

    public static String getAbsoluteUrlWithURLLib(String str, String str2) {
        Uri url = parseUrl(str2);
        if (url == null || !TextUtils.isEmpty(url.getScheme())) {
            return str2;
        }
        try {
            return new URL(new URL(str), str2).toString();
        } catch (MalformedURLException e) {
            RVLogger.e(TAG, "getAbsoluteUrlWithURLLib fatal error ", e);
            return null;
        }
    }

    public static String getCORSUrl(String str) {
        try {
            Uri url = parseUrl(str);
            if (url == null) {
                return "";
            }
            String str2 = url.getScheme() + "://" + url.getHost();
            if (url.getPort() == -1) {
                return str2;
            }
            return str2 + u15.f19942b + url.getPort();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getHash(String str) {
        int iIndexOf;
        Uri url = parseUrl(str);
        String fragment = url != null ? url.getFragment() : null;
        if (fragment != null && (iIndexOf = fragment.indexOf("?")) > 0) {
            fragment = fragment.substring(0, iIndexOf);
        }
        return (fragment == null || !fragment.startsWith(WVNativeCallbackUtil.SEPERATER)) ? fragment : fragment.substring(1);
    }

    public static String getHost(String str) {
        Uri url = parseUrl(str);
        if (url != null) {
            return url.getHost();
        }
        return null;
    }

    public static String getOnlineHost(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("file:///") || str.startsWith("data:")) {
            return null;
        }
        return getHost(str);
    }

    public static String getParam(Uri uri, String str, String str2) {
        String queryParameter;
        if (uri == null) {
            return str2;
        }
        try {
            queryParameter = uri.getQueryParameter(str);
        } catch (Exception e) {
            RVLogger.e(TAG, "Exception", e);
            queryParameter = null;
        }
        return TextUtils.isEmpty(queryParameter) ? str2 : queryParameter;
    }

    public static String getPath(String str) {
        Uri url = parseUrl(str);
        if (url != null) {
            return url.getPath();
        }
        return null;
    }

    public static String getPathAndHash(String str) {
        return getPath(str) + "#" + getHash(str);
    }

    public static boolean isUrlInDomainArray(String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return false;
        }
        Uri url = parseUrl(str);
        if (url == null) {
            RVLogger.d(TAG, "parse auto url failed!");
            return false;
        }
        String host = url.getHost();
        if (TextUtils.isEmpty(host)) {
            RVLogger.d(TAG, "can't get url host");
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
            RVLogger.e(TAG, "match auto login exception.", e);
            return false;
        }
    }

    public static boolean isValidUrl(String str) {
        return !TextUtils.isEmpty(str) && URLUtil.isValidUrl(str) && Patterns.WEB_URL.matcher(str).matches();
    }

    public static String matchAppIdRaw(String str) {
        String str2;
        String host = getHost(str);
        if (host != null && (host.contains("h5app") || host.contains("hybrid"))) {
            if (host.contains("h5app")) {
                str2 = "\\d+\\.h5app\\.(alipay|m\\.taobao)\\.(net|com)";
            } else {
                str2 = host.contains("hybrid") ? "^\\d+[.]hybrid[.]alipay-eco[.](com|net)$" : "";
            }
            Pattern patternCompile = PatternUtils.compile(str2);
            if (patternCompile != null && !TextUtils.isEmpty(host)) {
                Matcher matcher = patternCompile.matcher(host);
                if (matcher.find()) {
                    String strGroup = matcher.group();
                    if (!TextUtils.isEmpty(strGroup)) {
                        return strGroup.substring(0, strGroup.indexOf(Consts.DOT));
                    }
                }
            }
        }
        return null;
    }

    public static String mergeUrl(String str, String str2) {
        String strPurifyUrl;
        int iLastIndexOf;
        Uri url = parseUrl(str2);
        if (url == null || !TextUtils.isEmpty(url.getScheme())) {
            return str2;
        }
        String str3 = null;
        if (str2.startsWith("//")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri url2 = parseUrl(str);
            if (url2 != null && !TextUtils.isEmpty(url2.getScheme())) {
                str3 = url2.getScheme() + u15.f19942b + str2;
            }
            RVLogger.d(TAG, "getAbsoluteUrl // " + str3);
            return str3;
        }
        if (!str2.startsWith(WVNativeCallbackUtil.SEPERATER)) {
            if (TextUtils.isEmpty(str2) || (iLastIndexOf = (strPurifyUrl = purifyUrl(str)).lastIndexOf(WVNativeCallbackUtil.SEPERATER)) == -1) {
                return null;
            }
            String str4 = strPurifyUrl.substring(0, iLastIndexOf) + WVNativeCallbackUtil.SEPERATER + str2;
            RVLogger.d(TAG, "getAbsoluteUrl else " + str4);
            return str4;
        }
        Uri url3 = parseUrl(str);
        if (url3 == null) {
            return null;
        }
        String scheme = url3.getScheme();
        String authority = url3.getAuthority();
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority)) {
            str3 = scheme + "://" + authority + str2;
        }
        RVLogger.d(TAG, "getAbsoluteUrl / " + str3);
        return str3;
    }

    @Nullable
    public static Pair<String, Bundle> parseAriverCodeUrl(String str) {
        return parseAriverCodeUrl(parseUrl(str));
    }

    public static Uri parseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = f24287a.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            f24287a.put(str, uri);
            return uri;
        } catch (Exception e) {
            RVLogger.e(TAG, "parse url exception.", e);
            return uri;
        }
    }

    public static String purifyUrl(String str) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = b.get(str);
        if (str2 != null) {
            return str2;
        }
        try {
            int iIndexOf = str.indexOf("#");
            strSubstring = iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
            try {
                if (strSubstring.contains("??")) {
                    b.put(str, strSubstring);
                    return strSubstring;
                }
                int iIndexOf2 = strSubstring.indexOf("?");
                if (iIndexOf2 != -1) {
                    strSubstring = strSubstring.substring(0, iIndexOf2);
                }
                b.put(str, strSubstring);
                return strSubstring;
            } catch (Throwable unused) {
                b.put(str, strSubstring);
                return strSubstring;
            }
        } catch (Throwable unused2) {
            strSubstring = str;
        }
    }

    public static String stripAnchor(String str) {
        int iIndexOf = str.indexOf(35);
        if (iIndexOf == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iIndexOf);
        RVLogger.d(TAG, "stripAnchor url:" + str + " afterUrl:" + strSubstring);
        return strSubstring;
    }

    @Nullable
    public static Pair<String, Bundle> parseAriverCodeUrl(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            String queryParameter = (rVEnvironmentService == null || !"AP".equals(rVEnvironmentService.defaultPlatform())) ? null : uri.getQueryParameter(d);
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = uri.getQueryParameter("_ariver_appid");
            }
            if (TextUtils.isEmpty(queryParameter)) {
                return null;
            }
            Bundle bundle = new Bundle();
            for (String str : uri.getQueryParameterNames()) {
                if (!"_ariver_appid".equals(str) && !d.equals(str)) {
                    bundle.putString(str, uri.getQueryParameter(str));
                }
            }
            return new Pair<>(queryParameter, bundle);
        } catch (Throwable th) {
            RVLogger.e(TAG, "parseAriverCodeUrl exception!", th);
            return null;
        }
    }
}
