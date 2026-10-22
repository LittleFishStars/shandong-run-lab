package com.czhj.sdk.logger;

import android.util.Log;
import com.google.common.net.c;
import com.ipd.dsp.internal.i.q;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SigmobLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29456a = "SigmobLogger";
    private static final boolean b = true;
    private static boolean c = false;
    private static final int d = 1;
    private static final int e = 1;
    private static final int f = 4;
    private static final Set<String> g = new HashSet();

    private static int a(StackTraceElement[] stackTraceElementArr) {
        for (int i = 1; i < stackTraceElementArr.length; i++) {
            if (!stackTraceElementArr[i].getClassName().split("\\$")[0].equals(SigmobLogger.class.getName())) {
                return i;
            }
        }
        return -1;
    }

    private static String a() {
        return Thread.currentThread().getName();
    }

    private static String a(StackTraceElement stackTraceElement) {
        return "(" + stackTraceElement.getFileName() + c.b + stackTraceElement.getLineNumber() + ')';
    }

    private static String a(String str) {
        return str + " [" + a() + "] " + b();
    }

    public static void addCloseClass(Class<?> cls) {
        g.add(cls.getSimpleName());
    }

    private static String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int iA = a(stackTrace);
        int length = iA + 4;
        int length2 = iA + 1 + 4;
        if (length >= stackTrace.length) {
            length = stackTrace.length - 1;
        }
        if (length2 > stackTrace.length) {
            length2 = stackTrace.length;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = length2 - 1; i >= length; i--) {
            String strA = a(stackTrace[i]);
            sb.append((CharSequence) sb2);
            sb.append(strA);
            sb.append('\n');
            sb2.append(q.a.i);
        }
        return sb.toString();
    }

    private static String b(String str) {
        return "SigmobLogger#" + str;
    }

    public static void d(String str, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.d(b(str), a(format(str2, objArr)));
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.d(b(str), a(format(str2, objArr)), th);
    }

    public static void dL(String str, String str2, Object... objArr) {
        if (!c) {
            g.contains(str);
            return;
        }
        String str3 = format(str2, objArr);
        if (str3.length() < 3000) {
            Log.d(b(str), str3);
            return;
        }
        synchronized (SigmobLogger.class) {
            int length = str3.length();
            int i = 0;
            int i2 = 0;
            do {
                i += 3000;
                if (i >= length) {
                    i = length - 1;
                }
                Log.d(b(str), str3.substring(i2, i));
                i2 = i + 1;
            } while (i != length - 1);
        }
    }

    public static void debug(boolean z) {
        c = z;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.e(b(str), a(format(str2, objArr)));
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.e(b(str), a(format(str2, objArr)), th);
    }

    public static String format(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.i(b(str), a(format(str2, objArr)));
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.i(b(str), a(format(str2, objArr)), th);
    }

    public static void w(String str, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.w(b(str), a(format(str2, objArr)));
    }

    public static void w(String str, Throwable th) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.w(b(str), th);
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        if (!c || g.contains(str)) {
            return;
        }
        Log.w(b(str), a(format(str2, objArr)), th);
    }
}
