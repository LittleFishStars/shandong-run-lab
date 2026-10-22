package com.baidu.mshield.b.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f26702a = -1;

    static {
        new ThreadLocal();
    }

    public static void a(int i, String str) {
    }

    public static void a(String str) {
        b(str);
    }

    public static void a(Throwable th) {
    }

    public static void b(String str) {
        int i = f26702a;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i = f26702a;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str);
        }
    }
}
