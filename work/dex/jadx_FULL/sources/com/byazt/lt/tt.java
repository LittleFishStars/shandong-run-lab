package com.byazt.lt;

import android.text.TextUtils;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 438, 13})
public class tt {
    public static boolean c = false;
    public static int tt = 4;
    public static String ve = "";

    public static void c(int i) {
        tt = i;
    }

    public static boolean tt() {
        return c;
    }

    public static void ve(String str, String str2) {
        if (c && str2 != null && tt <= 6) {
            m.uj(ve(str), str2);
        }
    }

    public static void c() {
        c = true;
        c(3);
    }

    public static void tt(String str, String str2) {
        if (c && str2 != null && tt <= 5) {
            m.tt(ve(str), str2);
        }
    }

    public static void c(String str) {
        if (c) {
            c("Logger", str);
        }
    }

    public static void ve(String str, String str2, Throwable th) {
        if (c) {
            if (!(str2 == null && th == null) && tt <= 6) {
                m.ve(ve(str), str2, th);
            }
        }
    }

    public static void tt(String str, String str2, Throwable th) {
        if (c) {
            if (!(str2 == null && th == null) && tt <= 5) {
                m.tt(ve(str), str2, th);
            }
        }
    }

    public static void c(String str, String str2) {
        if (c && str2 != null && tt <= 4) {
            m.c(ve(str), str2);
        }
    }

    private static String ve(String str) {
        if (TextUtils.isEmpty(ve)) {
            return str;
        }
        return c("[" + ve + "]-[" + str + "]");
    }

    public static void tt(String str, Object... objArr) {
        if (c && objArr != null && tt <= 5) {
            ve(str);
            c(objArr);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (c) {
            if (!(str2 == null && th == null) && tt <= 4) {
                m.c(ve(str), str2, th);
            }
        }
    }

    public static void tt(String str) {
        if (c) {
            ve("Logger", str);
        }
    }

    public static void c(String str, Object... objArr) {
        if (c && objArr != null && tt <= 4) {
            ve(str);
            c(objArr);
        }
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
