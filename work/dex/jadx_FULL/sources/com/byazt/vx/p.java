package com.byazt.vx;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 350})
public class p {
    public static <T> boolean c(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean tt(List<T> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }
}
