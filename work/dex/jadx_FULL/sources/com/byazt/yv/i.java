package com.byazt.yv;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 499, 42})
public class i {
    public static final x c = new x();
    public static final Map<String, String> tt = new ConcurrentHashMap();

    public static String c(String str) throws IllegalArgumentException {
        Map<String, String> map = tt;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strC = c.c(str);
        if (strC != null) {
            map.put(str, strC);
        }
        return strC;
    }
}
