package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class pp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f27660a = ".AD_CLK_PT_DOWN_X.";
    public static String b = ".AD_CLK_PT_DOWN_Y.";
    public static String c = ".AD_CLK_PT_UP_X.";
    public static String d = ".AD_CLK_PT_UP_Y.";
    public static String e = ".SCRN_CLK_PT_DOWN_X.";
    public static String f = ".SCRN_CLK_PT_DOWN_Y.";
    public static String g = ".SCRN_CLK_PT_UP_X.";
    public static String h = ".SCRN_CLK_PT_UP_Y.";
    public static String i = ".UTC_TS.";
    public static String j = ".AD_CLK_PT_DOWN_X_DP.";
    public static String k = ".AD_CLK_PT_DOWN_Y_DP.";
    public static String l = ".AD_CLK_PT_UP_X_DP.";
    public static String m = ".AD_CLK_PT_UP_Y_DP.";
    public static String n = ".SCRN_CLK_PT_DOWN_X_DP.";
    public static String o = ".SCRN_CLK_PT_DOWN_Y_DP.";
    public static String p = ".SCRN_CLK_PT_UP_X_DP.";
    public static String q = ".SCRN_CLK_PT_UP_Y_DP.";
    public static String r = ".EVENT_TS_START.";
    public static String s = ".EVENT_TS_END.";
    public static String t = ".VIDEO_DURATION.";
    public static String u = "__CLT__";
    public static String v = "__CLT-999__";
    public static String w = "__CALL_BACK_TYPE__";

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("url must no null");
        }
        if (str.contains(f27660a)) {
            str = str.replace(f27660a, str2);
        }
        if (str.contains(b)) {
            str = str.replace(b, str3);
        }
        if (str.contains(c)) {
            str = str.replace(c, str2);
        }
        if (str.contains(d)) {
            str = str.replace(d, str3);
        }
        if (str.contains(e)) {
            str = str.replace(e, str4);
        }
        if (str.contains(f)) {
            str = str.replace(f, str5);
        }
        if (str.contains(g)) {
            str = str.replace(g, str4);
        }
        if (str.contains(h)) {
            str = str.replace(h, str5);
        }
        if (str.contains(i)) {
            str = str.replace(i, String.valueOf(System.currentTimeMillis()));
        }
        if (str.contains(r)) {
            str = str.replace(r, str6);
        }
        if (str.contains(s)) {
            str = str.replace(s, str7);
        }
        return str.contains(t) ? str.replace(t, str8) : str;
    }

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, int i3) {
        if (!TextUtils.isEmpty(str)) {
            if (i2 == 2) {
                if (str.contains(u)) {
                    str2 = "0";
                    str3 = "0";
                    str4 = str3;
                    str5 = str4;
                }
                if (str.contains(v)) {
                    str2 = "-999";
                    str3 = "-999";
                    str4 = str3;
                    str5 = str4;
                }
            }
            if (str.contains(f27660a)) {
                str = str.replace(f27660a, str2);
            }
            if (str.contains(b)) {
                str = str.replace(b, str3);
            }
            if (str.contains(c)) {
                str = str.replace(c, str2);
            }
            if (str.contains(d)) {
                str = str.replace(d, str3);
            }
            if (str.contains(e)) {
                str = str.replace(e, str4);
            }
            if (str.contains(f)) {
                str = str.replace(f, str5);
            }
            if (str.contains(g)) {
                str = str.replace(g, str4);
            }
            if (str.contains(h)) {
                str = str.replace(h, str5);
            }
            if (str.contains(j)) {
                str = str.replace(j, a(a4.j().u, str2));
            }
            if (str.contains(k)) {
                str = str.replace(k, a(a4.j().u, str3));
            }
            if (str.contains(l)) {
                str = str.replace(l, a(a4.j().u, str2));
            }
            if (str.contains(m)) {
                str = str.replace(m, a(a4.j().u, str3));
            }
            if (str.contains(n)) {
                str = str.replace(n, a(a4.j().u, str4));
            }
            if (str.contains(o)) {
                str = str.replace(o, a(a4.j().u, str5));
            }
            if (str.contains(p)) {
                str = str.replace(p, a(a4.j().u, str4));
            }
            if (str.contains(q)) {
                str = str.replace(q, a(a4.j().u, str5));
            }
            if (str.contains(u)) {
                str = str.replace(u, String.valueOf(i2));
            }
            if (str.contains(v)) {
                str = str.replace(v, String.valueOf(i2));
            }
            if (str.contains(i)) {
                str = str.replace(i, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(r)) {
                str = str.replace(r, str6);
            }
            if (str.contains(s)) {
                str = str.replace(s, str7);
            }
            if (str.contains(t)) {
                str = str.replace(t, str8);
            }
            return str.contains(w) ? str.replace(w, String.valueOf(i3)) : str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static String a(String str, g5 g5Var, String str2, String str3, String str4) {
        if (str.contains(f27660a) && !TextUtils.isEmpty(g5Var.h())) {
            str = str.replace(f27660a, g5Var.h());
        }
        if (str.contains(b) && !TextUtils.isEmpty(g5Var.i())) {
            str = str.replace(b, g5Var.i());
        }
        if (str.contains(c) && !TextUtils.isEmpty(g5Var.d())) {
            str = str.replace(c, g5Var.d());
        }
        if (str.contains(d) && !TextUtils.isEmpty(g5Var.e())) {
            str = str.replace(d, g5Var.e());
        }
        if (str.contains(e) && !TextUtils.isEmpty(g5Var.f())) {
            str = str.replace(e, g5Var.f());
        }
        if (str.contains(f) && !TextUtils.isEmpty(g5Var.g())) {
            str = str.replace(f, g5Var.g());
        }
        if (str.contains(g) && !TextUtils.isEmpty(g5Var.b())) {
            str = str.replace(g, g5Var.b());
        }
        if (str.contains(h) && !TextUtils.isEmpty(g5Var.c())) {
            str = str.replace(h, g5Var.c());
        }
        if (str.contains(j) && !TextUtils.isEmpty(g5Var.h())) {
            str = str.replace(j, a(a4.j().u, g5Var.h()));
        }
        if (str.contains(k) && !TextUtils.isEmpty(g5Var.i())) {
            str = str.replace(k, a(a4.j().u, g5Var.i()));
        }
        if (str.contains(l) && !TextUtils.isEmpty(g5Var.d())) {
            str = str.replace(l, a(a4.j().u, g5Var.d()));
        }
        if (str.contains(m) && !TextUtils.isEmpty(g5Var.e())) {
            str = str.replace(m, a(a4.j().u, g5Var.e()));
        }
        if (str.contains(n) && !TextUtils.isEmpty(g5Var.f())) {
            str = str.replace(n, a(a4.j().u, g5Var.f()));
        }
        if (str.contains(o) && !TextUtils.isEmpty(g5Var.g())) {
            str = str.replace(o, a(a4.j().u, g5Var.g()));
        }
        if (str.contains(p) && !TextUtils.isEmpty(g5Var.b())) {
            str = str.replace(p, a(a4.j().u, g5Var.b()));
        }
        return (!str.contains(q) || TextUtils.isEmpty(g5Var.c())) ? str : str.replace(q, a(a4.j().u, g5Var.c()));
    }

    public static String a(String str, g5 g5Var, String str2, String str3, String str4, int i2) {
        if (!TextUtils.isEmpty(str)) {
            if (i2 != 2 && i2 != 5) {
                str = a(str, g5Var, str2, str3, str4);
            } else {
                g5 g5Var2 = new g5();
                if (str.contains(u)) {
                    g5Var2.g("0");
                    g5Var2.h("0");
                    g5Var2.e("0");
                    g5Var2.f("0");
                    g5Var2.c("0");
                    g5Var2.d("0");
                    g5Var2.a("0");
                    g5Var2.b("0");
                    str = a(str, g5Var2, str2, str3, str4);
                }
                if (str.contains(v)) {
                    g5Var2.g("-999");
                    g5Var2.h("-999");
                    g5Var2.e("-999");
                    g5Var2.f("-999");
                    g5Var2.c("-999");
                    g5Var2.d("-999");
                    g5Var2.a("-999");
                    g5Var2.b("-999");
                    str = a(str, g5Var2, str2, str3, str4);
                }
            }
            if (str.contains(u)) {
                str = str.replace(u, String.valueOf(i2));
            }
            if (str.contains(v)) {
                str = str.replace(v, String.valueOf(i2));
            }
            if (str.contains(i)) {
                str = str.replace(i, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(r)) {
                str = str.replace(r, str2);
            }
            if (str.contains(s)) {
                str = str.replace(s, str3);
            }
            if (str.contains(t)) {
                str = str.replace(t, str4);
            }
            if (!str.contains(w) || g5Var == null) {
                return str;
            }
            return str.replace(w, String.valueOf(g5Var.a()));
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static String a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && !str.equals("-999") && !str.equals("0")) {
                return String.valueOf((int) ((((long) Double.parseDouble(str)) / context.getResources().getDisplayMetrics().density) + 0.5f));
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }
}
