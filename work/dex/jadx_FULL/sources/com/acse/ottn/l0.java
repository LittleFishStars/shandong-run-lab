package com.acse.ottn;

import com.acse.ottn.util.HelpShopAppUtil;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.zj.adlib.c31;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l0 {
    public static String A;
    public static p0 c;
    public static String y;
    public static String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f23074a = o1.c().b();
    public static String b = a("");
    public static boolean d = false;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = true;
    public static boolean i = false;
    public static boolean j = false;
    public static String k = "1";
    public static String l = "0";
    public static String m = "18";
    public static String n = "1";
    public static int o = 13;
    public static int p = 20;
    public static String q = "com.acse.oozk";
    public static String r = "0";
    public static String s = "1";
    public static String t = "com.zjwh.android_wh_physicalfitness";
    public static String u = c31.f15724a;
    public static String v = "com.huachenjie.shandong_school_pro";
    public static String w = "com.bxkj.student";
    public static String x = "com.lptiyu.tanke";

    static {
        y = HelpShopAppUtil.getContext() != null ? HelpShopAppUtil.getContext().getPackageName() : "";
        z = p4.r();
        A = p4.q();
    }

    public static String a(String str) {
        return "程序";
    }

    public static String a(boolean z2) {
        return z2 ? "QVbZFjAoPF6LCCQm6RgDs1g13mnJ8nA0" : n3.a().e(LiteEncryptUtils.KEY_AES);
    }

    public static void b(boolean z2) {
        if (n3.a() != null) {
            q2.b().a("battery_permission");
            n3.a().a("open_battery_white", Boolean.valueOf(z2));
        }
    }

    public static void c(boolean z2) {
        h2.a("MyService", "setServiceHightButteryState come on");
        if (n3.a() != null) {
            n3.a().a("background_battery_hignt", Boolean.valueOf(z2));
        }
        q2.b().a("vivo_battery_permission");
    }

    public static void a(p0 p0Var) {
        c = p0Var;
    }

    public static p0 a() {
        return c;
    }
}
