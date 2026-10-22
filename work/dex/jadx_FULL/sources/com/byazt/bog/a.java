package com.byazt.bog;

import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 935, 34})
public class a {
    public static boolean c = false;
    public static int tt = 4;

    public static void c(int i) {
        tt = i;
    }

    public static void c(String str, String str2) {
    }

    public static void c(String str, String str2, Throwable th) {
    }

    public static void n(String str, String str2) {
        if (c && str2 != null && tt <= 6) {
            m.uj(str, str2);
        }
    }

    public static void tt(String str, String str2) {
    }

    public static void tt(String str, String str2, Throwable th) {
    }

    public static void tt(String str, Object... objArr) {
        if (c && objArr != null && tt <= 5) {
            c(objArr);
        }
    }

    public static void uj(String str, String str2) {
        if (c && str2 != null && tt <= 5) {
            m.tt(str, str2);
        }
    }

    public static void ve(String str, String str2) {
        if (c && str2 != null && tt <= 4) {
            m.c(str, str2);
        }
    }

    public static void c() {
        c = true;
        c(3);
    }

    public static void c(String str, Object... objArr) {
        if (c && objArr != null && tt <= 3) {
            c(objArr);
        }
    }

    public static void n(String str, String str2, Throwable th) {
        if (c) {
            if (!(str2 == null && th == null) && tt <= 6) {
                m.ve(str, str2, th);
            }
        }
    }

    public static void tt(String str) {
        if (c) {
            n("TTLogger", str);
        }
    }

    public static void uj(String str, String str2, Throwable th) {
        if (c) {
            if (!(str2 == null && th == null) && tt <= 5) {
                m.tt(str, str2, th);
            }
        }
    }

    public static void ve(String str, String str2, Throwable th) {
        if (c) {
            if (!(str2 == null && th == null) && tt <= 4) {
                m.c(str, str2, th);
            }
        }
    }

    public static void c(String str) {
        if (c) {
            ve("TTLogger", str);
        }
    }

    public static void c(Throwable th) {
        uj("TTLogger", "", th);
    }

    private static String c(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
