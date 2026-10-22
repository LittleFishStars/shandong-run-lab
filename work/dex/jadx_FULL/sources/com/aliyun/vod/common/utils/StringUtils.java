package com.aliyun.vod.common.utils;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.webkit.URLUtil;
import com.ali.auth.third.login.LoginConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StringUtils {
    public static String capitalizeFirstLetter(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLetter(cCharAt) || Character.isUpperCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(Character.toUpperCase(cCharAt));
        sb.append(str.substring(1));
        return sb.toString();
    }

    public static String fullWidthToHalfWidth(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 12288) {
                charArray[i] = ' ';
            } else if (c < 65281 || c > 65374) {
                charArray[i] = c;
            } else {
                charArray[i] = (char) (c - 65248);
            }
        }
        return new String(charArray);
    }

    public static String getHrefInnerHtml(String str) {
        if (isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*", 2).matcher(str);
        return matcher.matches() ? matcher.group(1) : str;
    }

    public static String halfWidthToFullWidth(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if (c < '!' || c > '~') {
                charArray[i] = c;
            } else {
                charArray[i] = (char) (c + 65248);
            }
        }
        return new String(charArray);
    }

    public static String htmlEscapeCharsToString(String str) {
        return isEmpty(str) ? str : str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0) && isBlank(str);
    }

    public static boolean isUriPath(String str) {
        return URLUtil.isValidUrl(str);
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String nullStrToEmpty(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj instanceof String ? (String) obj : obj.toString();
    }

    public static String sqliteEscape(String str) {
        return str.replace(WVNativeCallbackUtil.SEPERATER, "//").replace("'", "''").replace("[", "/[").replace("]", "/]").replace("%", "/%").replace("&", "/&").replace(LoginConstants.UNDER_LINE, "/_").replace("(", "/(").replace(")", "/)");
    }

    public static String subString(String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        return iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : str;
    }

    public static String utf8Encode(String str) {
        if (isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    public static String utf8Encode(String str, String str2) {
        if (isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str2;
        }
    }
}
