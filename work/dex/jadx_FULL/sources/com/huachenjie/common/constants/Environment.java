package com.huachenjie.common.constants;

import com.zj.adlib.l43;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class Environment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f33657a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static String g = "";
    public static String h = "";
    public static String i = "";

    public interface ENV_VALUE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33658a = 1;
        public static final int b = 4;
        public static final int c = 7;
        public static final int d = 9;
        public static final int e = 10;
        public static final int f = 11;
    }

    public static void a() {
        l43.a(4);
    }

    public static void b(String baseGameWebUrl) {
        d = baseGameWebUrl;
    }

    public static void c(String baseUrl) {
        f33657a = baseUrl;
    }

    public static void d(String baseUrlFindJob) {
        i = baseUrlFindJob;
    }

    public static void e(String baseUrlH5) {
        b = baseUrlH5;
    }

    public static void f(String baseUrlSocket) {
        f = baseUrlSocket;
    }

    public static void g(String baseUrlWeb) {
        c = baseUrlWeb;
    }

    public static void h(String fileUrl) {
        e = fileUrl;
    }

    public static void i(String gameSocketUrl) {
        h = gameSocketUrl;
    }

    public static void j(String imAppKey) {
        g = imAppKey;
    }
}
