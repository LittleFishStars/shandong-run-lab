package com.byazt.dc;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2063, 15})
public class uj {
    public static Map<String, com.byazt.xiv.ve> c = new ConcurrentHashMap();

    public static com.byazt.xiv.ve c(String str) {
        if (!n.n(str)) {
            return null;
        }
        com.byazt.xiv.ve veVar = c.get(str);
        if (veVar != null) {
            return veVar;
        }
        ve veVar2 = new ve(str);
        c.put(str, veVar2);
        return veVar2;
    }

    public static Set<String> c() {
        return c.keySet();
    }
}
