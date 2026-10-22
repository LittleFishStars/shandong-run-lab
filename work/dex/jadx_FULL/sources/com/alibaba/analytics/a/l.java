package com.alibaba.analytics.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l {
    public static Map<String, String> a(Properties properties) {
        if (properties == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (Object obj : properties.keySet()) {
            if (obj instanceof String) {
                String strA = u.a(obj);
                String strA2 = u.a(properties.get(obj));
                if (!u.isEmpty(strA) && !u.isEmpty(strA2)) {
                    map.put(strA, strA2);
                }
            }
        }
        return map;
    }

    public static Map<String, String> b(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        if (map == null || map.size() <= 0 || (r1 = map.keySet().iterator()) == null) {
            return null;
        }
        for (String str : map.keySet()) {
            String strA = u.a(map.get(str));
            if (str != null) {
                map2.put(str, strA);
            }
        }
        return map2;
    }

    public static Map<String, String> c(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (str instanceof String) {
                String str2 = map.get(str);
                if (!u.isEmpty(str) && !u.isEmpty(str2)) {
                    try {
                        map2.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return map2;
    }
}
