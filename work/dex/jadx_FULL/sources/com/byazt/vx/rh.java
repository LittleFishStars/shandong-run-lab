package com.byazt.vx;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 115})
public class rh {
    public static Map<Integer, Integer> c = new ConcurrentHashMap();

    public static Integer c(int i) {
        Integer num = c.get(Integer.valueOf(i));
        if (num != null) {
            return num;
        }
        Integer numValueOf = Integer.valueOf(i);
        c.put(Integer.valueOf(i), numValueOf);
        return numValueOf;
    }
}
