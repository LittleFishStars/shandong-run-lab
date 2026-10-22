package com.alipay.sdk.m.l;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f25456a = false;
    public static volatile String b;

    public static void a(String str) {
        b = str;
    }

    public static String b() {
        c cVarA = c.a(c.DOUBLE_REQUEST.c());
        return a(cVarA.c(), cVarA.b(), "");
    }

    public static boolean c() {
        return f25456a;
    }

    public static String d() {
        return b;
    }

    public static String e() {
        c cVarA = c.a(c.PARAMS_ERROR.c());
        return a(cVarA.c(), cVarA.b(), "");
    }

    public static void a(boolean z) {
        f25456a = z;
    }

    public static String a() {
        c cVarA = c.a(c.CANCELED.c());
        return a(cVarA.c(), cVarA.b(), "");
    }

    public static String a(int i, String str, String str2) {
        return "resultStatus={" + i + "};memo={" + str + "};result={" + str2 + "}";
    }
}
