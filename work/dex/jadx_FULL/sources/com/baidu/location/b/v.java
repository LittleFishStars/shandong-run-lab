package com.baidu.location.b;

import android.location.Location;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f26398a;
    private static com.baidu.location.c.a b;
    private static Location c;
    private static String d;
    private static String e;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        f26398a = j;
    }

    public static void a(Location location) {
        c = location;
    }

    public static void a(com.baidu.location.c.a aVar) {
        b = aVar;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return f26398a;
    }

    public static void b(String str) {
        e = str;
    }

    public static com.baidu.location.c.a c() {
        return b;
    }

    public static Location d() {
        return c;
    }

    public static String e() {
        return e;
    }
}
