package com.byazt.pm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1355, 15})
public class uj {
    public static Map<String, tt> c = new HashMap();

    public static void c(List<tt> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (tt ttVar : list) {
            if (ttVar != null) {
                c.put(ttVar.c(), ttVar);
            }
        }
    }

    public static tt c(String str) {
        return c.get(str);
    }
}
