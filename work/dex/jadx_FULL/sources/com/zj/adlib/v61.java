package com.zj.adlib;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class v61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f45293a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f20181a = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f45294a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f20182a;
        public String b;
    }

    public static String a(a aVar, String str, Object... objArr) {
        return "[" + aVar.f20182a + Consts.DOT + aVar.b + "():" + aVar.f45294a + "]" + i(str, objArr);
    }

    public static String b(a aVar, String str, Object... objArr) {
        return "[" + aVar.b + "():" + aVar.f45294a + "]" + i(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        if (f20181a) {
            a aVarJ = j(new Throwable().getStackTrace());
            Log.d(aVarJ.f20182a, b(aVarJ, str, objArr));
        }
    }

    public static void d(Throwable th) {
        if (f20181a) {
            Log.d(j(th.getStackTrace()).f20182a, "", th);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (f20181a) {
            Log.d(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        if (f20181a) {
            a aVarJ = j(new Throwable().getStackTrace());
            Log.e(aVarJ.f20182a, b(aVarJ, str, objArr));
        }
    }

    public static void g(Throwable th) {
        if (f20181a) {
            Log.e(j(th.getStackTrace()).f20182a, "", th);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (f20181a) {
            Log.e(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static String i(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    public static a j(StackTraceElement[] stackTraceElementArr) {
        a aVar = new a();
        if (stackTraceElementArr.length > 1) {
            String fileName = stackTraceElementArr[1].getFileName();
            aVar.f20182a = fileName;
            if (fileName.endsWith(".java")) {
                String str = aVar.f20182a;
                aVar.f20182a = str.substring(0, str.length() - 5);
            }
            aVar.b = stackTraceElementArr[1].getMethodName();
            aVar.f45294a = stackTraceElementArr[1].getLineNumber();
        }
        return aVar;
    }

    public static void k(String str, Object... objArr) {
        if (f20181a) {
            a aVarJ = j(new Throwable().getStackTrace());
            Log.i(aVarJ.f20182a, b(aVarJ, str, objArr));
        }
    }

    public static void l(Throwable th) {
        if (f20181a) {
            Log.i(j(th.getStackTrace()).f20182a, "", th);
        }
    }

    public static boolean m() {
        return f20181a;
    }

    public static void n(String str, String str2, Object... objArr) {
        if (f20181a) {
            Log.i(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void o(String str) {
        if (f20181a) {
            Log.d(str, Log.getStackTraceString(new Throwable()));
        }
    }

    public static void p(boolean z) {
        int i = f45293a + 1;
        f45293a = i;
        if (i > 1) {
            Log.e("L", "setLogEnable() could only be called once");
        } else {
            f20181a = z;
        }
    }

    public static void q(String str, Object... objArr) {
        if (f20181a) {
            a aVarJ = j(new Throwable().getStackTrace());
            Log.v(aVarJ.f20182a, b(aVarJ, str, objArr));
        }
    }

    public static void r(Throwable th) {
        if (f20181a) {
            Log.v(j(th.getStackTrace()).f20182a, "", th);
        }
    }

    public static void s(String str, String str2, Object... objArr) {
        if (f20181a) {
            Log.v(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void t(String str, Object... objArr) {
        if (f20181a) {
            a aVarJ = j(new Throwable().getStackTrace());
            Log.w(aVarJ.f20182a, b(aVarJ, str, objArr));
        }
    }

    public static void u(Throwable th) {
        if (f20181a) {
            Log.v(j(th.getStackTrace()).f20182a, "", th);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (f20181a) {
            Log.w(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        if (f20181a) {
            a aVarJ = j(new Throwable().getStackTrace());
            Log.wtf(aVarJ.f20182a, b(aVarJ, str, objArr));
        }
    }
}
