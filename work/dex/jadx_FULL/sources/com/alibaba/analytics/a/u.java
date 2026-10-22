package com.alibaba.analytics.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u {
    public static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return "" + ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return "" + ((Long) obj).longValue();
        }
        if (obj instanceof Double) {
            return "" + ((Double) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return "" + ((Float) obj).floatValue();
        }
        if (obj instanceof Short) {
            return "" + ((int) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Byte)) {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).toString();
            }
            return obj instanceof Character ? ((Character) obj).toString() : obj.toString();
        }
        return "" + ((int) ((Byte) obj).byteValue());
    }

    public static Map<String, String> b(String str) {
        HashMap map = new HashMap();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "^");
        while (stringTokenizer.hasMoreTokens()) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "'");
            map.put(stringTokenizer2.nextToken(), stringTokenizer2.hasMoreTokens() ? stringTokenizer2.nextToken() : null);
        }
        return map;
    }

    public static String c(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        for (String str : map.keySet()) {
            String strA = a(map.get(str));
            String strA2 = a(str);
            if (strA != null && strA2 != null) {
                if (z) {
                    stringBuffer.append(strA2 + "=" + strA);
                    z = false;
                } else {
                    stringBuffer.append(",");
                    stringBuffer.append(strA2 + "=" + strA);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String d(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        for (String str : map.keySet()) {
            String strA = a(map.get(str));
            String strA2 = a(str);
            if (strA != null && strA2 != null) {
                if (z) {
                    try {
                        stringBuffer.append(URLEncoder.encode(strA2, "UTF-8") + "=" + URLEncoder.encode(strA, "UTF-8"));
                        z = false;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        stringBuffer.append(",");
                        stringBuffer.append(URLEncoder.encode(strA2, "UTF-8") + "=" + URLEncoder.encode(strA, "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String e(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            stringBuffer.append(next.getKey().toString());
            stringBuffer.append("'");
            String str = "";
            stringBuffer.append(next.getValue() == null ? "" : next.getValue().toString());
            if (it.hasNext()) {
                str = "^";
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static boolean f(String str) {
        return !isBlank(str);
    }

    public static boolean isBlank(String str) {
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

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }
}
