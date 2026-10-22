package com.aliyun.common.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    public static void a(int i, int i2) {
        if (i > i2) {
            return;
        }
        throw new AssertionError("unexpected " + i + " <= " + i2);
    }

    public static void a(Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            throw new AssertionError("expected " + obj + ", got " + obj2);
        }
    }

    public static void b(Object obj, Object obj2) {
        if (obj.equals(obj2)) {
            throw new AssertionError("unexpected equality: " + obj2);
        }
    }
}
