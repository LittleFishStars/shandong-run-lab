package com.aliyun.svideosdk.common.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static <T extends Comparable<T>> T a(T t, T t2, T t3) {
        if (t.compareTo(t2) < 0) {
            return t2;
        }
        return t.compareTo(t3) > 0 ? t3 : t;
    }
}
