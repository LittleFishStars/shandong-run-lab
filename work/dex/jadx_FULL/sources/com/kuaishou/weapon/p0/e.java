package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40123a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = -1;
    public static int f = -1;
    static ThreadLocal<StringBuilder> g = new ThreadLocal<>();
    private static int h;

    private static void a(int i, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            if (i == 0) {
                Log.i("WeaponSDK", str);
                return;
            } else if (i == 1) {
                Log.d("WeaponSDK", str);
                return;
            } else {
                if (i != 2) {
                    return;
                }
                Log.e("WeaponSDK", str);
                return;
            }
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb = g.get();
        if (sb == null) {
            sb = new StringBuilder();
            g.set(sb);
        }
        synchronized (sb) {
            sb.setLength(0);
            sb.append("[");
            sb.append(h);
            sb.append("][");
            sb.append(fileName);
            sb.append(com.google.common.net.c.b);
            sb.append(lineNumber);
            sb.append('.');
            sb.append(methodName);
            sb.append("] ");
            sb.append(str);
            string = sb.toString();
            h++;
        }
        if (i == 0) {
            Log.i("WeaponSDK", string);
        } else if (i == 1) {
            Log.d("WeaponSDK", string);
        } else {
            if (i != 2) {
                return;
            }
            Log.e("WeaponSDK", string);
        }
    }

    public static void b(String str) {
        int i = f;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i = f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str);
        }
    }

    public static void d(String str) {
    }

    public static void b(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str + "\n" + a(th));
        }
    }

    public static void c(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str + "\n" + a(th));
        }
    }

    public static void a(String str) {
        int i = f;
        if (i == -1 || i == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0) {
            a(0, str + "\n" + a(th));
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
