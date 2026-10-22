package com.byazt.rv;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1194, 20})
public class c {
    public static volatile c c;
    public static Map<String, Map<String, Object>> tt = new HashMap();

    private c() {
    }

    public static c c() {
        if (c != null) {
            return c;
        }
        synchronized (c.class) {
            if (c != null) {
                return c;
            }
            c cVar = new c();
            c = cVar;
            return cVar;
        }
    }

    public Map<String, Object> c(String str) {
        Map<String, Object> map = tt.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        tt.put(str, map2);
        return map2;
    }
}
