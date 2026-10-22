package com.alibaba.alibclinkpartner.smartlink.util;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23583a = "g";

    public static String a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String strEncode : map.keySet()) {
            String strEncode2 = map.get(strEncode);
            if (strEncode2 != null) {
                try {
                    strEncode2 = URLEncoder.encode(strEncode2, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    Log.e(f23583a, e.toString());
                }
            }
            strEncode = URLEncoder.encode(strEncode, "utf-8");
            if (strEncode2 != null) {
                stringBuffer.append("&");
                stringBuffer.append(strEncode);
                stringBuffer.append("=");
                stringBuffer.append(strEncode2);
            }
        }
        return stringBuffer.toString().substring(1);
    }

    public static boolean a(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(String str) {
        if (a(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean c(String str) {
        if (a(str)) {
            return false;
        }
        return Pattern.compile("^(http://|https://)?((?:[A-Za-z0-9]+-[A-Za-z0-9]+|[A-Za-z0-9]+)\\.)+([A-Za-z]+)[/\\?\\:]?.*$").matcher(str).matches();
    }

    public static String d(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
