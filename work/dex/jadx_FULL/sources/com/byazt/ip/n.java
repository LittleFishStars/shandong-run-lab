package com.byazt.ip;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1363, 46})
public class n {
    public static final Map<Integer, uj<?, ?>> c = new ConcurrentHashMap();

    public static uj<?, ?> c(int i) {
        Map<Integer, uj<?, ?>> map = c;
        uj<?, ?> ttVar = map.get(Integer.valueOf(i));
        if (ttVar != null) {
            return ttVar;
        }
        switch (i) {
            case 0:
                ttVar = new com.byazt.lh.tt();
                break;
            case 1:
                ttVar = new com.byazt.lh.ve();
                break;
            case 2:
                ttVar = new com.byazt.lh.uj();
                break;
            case 3:
                ttVar = new com.byazt.lh.c();
                break;
            case 4:
                ttVar = new com.byazt.lh.a();
                break;
            case 5:
                ttVar = new com.byazt.lh.n();
                break;
            case 6:
                ttVar = new com.byazt.lh.sp();
                break;
        }
        if (ttVar != null) {
            map.put(Integer.valueOf(i), ttVar);
        }
        return ttVar;
    }
}
