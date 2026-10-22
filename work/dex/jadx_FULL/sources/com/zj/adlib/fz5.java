package com.zj.adlib;

import android.content.Context;
import huachenjie.sdk.storage.core.IEncrypt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class fz5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41784a = "NoEncrptConfigStorage";
    public static final String b = "key_env";
    public static final String c = "key_base_url";
    public static final String d = "key_base_web";
    public static final String e = "ket_net_cert_open";

    public static String a() {
        return (String) zr8.c(f41784a).h(c, "");
    }

    public static String b() {
        return (String) zr8.c(f41784a).h(d, "");
    }

    public static int c() {
        return ((Integer) zr8.c(f41784a).h(b, 0)).intValue();
    }

    public static boolean d() {
        return ((Boolean) zr8.c(f41784a).h(e, Boolean.FALSE)).booleanValue();
    }

    public static void e(Context context) {
        zr8.f(f41784a, new p55(context, f41784a), (IEncrypt) null);
    }

    public static void f(String baseUrl) {
        zr8.c(f41784a).j(c, baseUrl);
    }

    public static void g(String baseWeb) {
        zr8.c(f41784a).j(d, baseWeb);
    }

    public static void h(int env) {
        zr8.c(f41784a).j(b, Integer.valueOf(env));
    }

    public static void i(boolean netCertOpen) {
        zr8.c(f41784a).j(e, Boolean.valueOf(netCertOpen));
    }
}
