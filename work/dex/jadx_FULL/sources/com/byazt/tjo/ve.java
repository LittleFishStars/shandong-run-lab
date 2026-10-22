package com.byazt.tjo;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 54})
public class ve {
    public static com.byazt.yf.a c(com.byazt.je.ve veVar) {
        if (veVar == null) {
            return null;
        }
        com.byazt.yf.a aVar = new com.byazt.yf.a();
        aVar.c(veVar.tt());
        aVar.uj(veVar.a());
        aVar.tt(veVar.ve());
        aVar.ve(veVar.uj());
        aVar.c(veVar.n());
        aVar.n(veVar.sp());
        aVar.c(veVar.c());
        return aVar;
    }

    public static Map<String, String> c(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map2;
    }
}
