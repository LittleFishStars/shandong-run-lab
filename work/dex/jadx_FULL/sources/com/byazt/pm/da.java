package com.byazt.pm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1355, 72})
public class da {
    public static Map<String, sp> c = new HashMap();

    public static void c(List<sp> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (sp spVar : list) {
            if (spVar != null) {
                c.put(spVar.c(), spVar);
            }
        }
    }

    public static sp c(String str) {
        return c.get(str);
    }
}
