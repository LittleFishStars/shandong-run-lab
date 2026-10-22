package com.huawei.hms.hatool;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a1 {
    public static void a(String str, String str2, long j) {
        s0 s0VarH = h(str, str2);
        if (s0VarH != null) {
            s0VarH.a(j);
        }
    }

    public static boolean a(String str, String str2) {
        s0 s0VarH = h(str, str2);
        if (s0VarH != null) {
            return s0VarH.a();
        }
        return true;
    }

    public static int b(String str, String str2) {
        s0 s0VarH = h(str, str2);
        if (s0VarH != null) {
            return s0VarH.d();
        }
        return 7;
    }

    public static boolean c(String str, String str2) {
        s0 s0VarH = h(str, str2);
        if (s0VarH != null) {
            return s0VarH.g();
        }
        return true;
    }

    public static String d(String str, String str2) {
        s0 s0VarH = h(str, str2);
        return s0VarH != null ? s0VarH.f() : "";
    }

    public static boolean e(String str, String str2) {
        s0 s0VarH = h(str, str2);
        if (s0VarH != null) {
            return s0VarH.i();
        }
        return false;
    }

    public static String f(String str, String str2) {
        s0 s0VarH = h(str, str2);
        return s0VarH != null ? s0VarH.h() : "";
    }

    public static String g(String str, String str2) {
        s0 s0VarH = h(str, str2);
        return s0VarH != null ? s0VarH.n() : "";
    }

    private static s0 h(String str, String str2) {
        l1 l1VarA = s.c().a(str);
        if (l1VarA == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return l1VarA.a(str2);
        }
        s0 s0VarA = l1VarA.a("oper");
        return s0VarA == null ? l1VarA.a("maint") : s0VarA;
    }

    public static Map<String, String> i(String str, String str2) {
        s0 s0VarH = h(str, str2);
        if (s0VarH != null) {
            return s0VarH.k();
        }
        return null;
    }

    public static long j(String str, String str2) {
        s0 s0VarH = h(str, str2);
        if (s0VarH != null) {
            return s0VarH.l();
        }
        return 0L;
    }

    public static int k(String str, String str2) {
        s0 s0VarH = h(str, str2);
        if (s0VarH != null) {
            return s0VarH.b();
        }
        return 10;
    }

    public static String l(String str, String str2) {
        s0 s0VarH = h(str, str2);
        return s0VarH != null ? s0VarH.o() : "";
    }

    public static String m(String str, String str2) {
        s0 s0VarH = h(str, str2);
        return s0VarH != null ? s0VarH.q() : "";
    }

    public static String n(String str, String str2) {
        s0 s0VarH = h(str, str2);
        return s0VarH != null ? s0VarH.m() : "";
    }

    public static String o(String str, String str2) {
        s0 s0VarH = h(str, str2);
        return s0VarH != null ? s0VarH.p() : "";
    }
}
