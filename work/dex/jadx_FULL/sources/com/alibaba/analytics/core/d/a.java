package com.alibaba.analytics.core.d;

import com.alibaba.analytics.a.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Pattern f23772a = Pattern.compile("(\\|\\||[\t\r\n]|\u0001|\u0000)+");

    private static String a(String str) {
        return (str == null || "".equals(str)) ? str : f23772a.matcher(str).replaceAll("");
    }

    private static String b(String str) {
        return a(str);
    }

    public static Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        Iterator<String> it = map.keySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                try {
                    String next = it.next();
                    if (next != null) {
                        map2.put(next, b(map.get(next)));
                    }
                } catch (Throwable th) {
                    j.e("[_checkMapFields]", th, new Object[0]);
                }
            }
        }
        return map2;
    }
}
