package com.alibaba.analytics.a;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.c49;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j {
    private static String TAG = "Analytics";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f23745a = null;
    private static boolean d = false;

    private static String a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    private static boolean c(int i) {
        g gVar = f23745a;
        return gVar != null && gVar.isValid() && i < f23745a.getLogLevel();
    }

    public static void d() {
        if (c(4)) {
            f23745a.i(y(), a((String) null, new Object[0]));
        } else if (v()) {
            Log.d(y(), a((String) null, new Object[0]));
        }
    }

    public static void e() {
        if (c(1)) {
            f23745a.l(y(), a((String) null, new Object[0]));
        } else if (v()) {
            Log.e(y(), a((String) null, new Object[0]));
        }
    }

    public static void i(String str, Object... objArr) {
        if (c(3)) {
            f23745a.k(y(), a(str, objArr));
        } else if (v()) {
            Log.i(y(), a(str, objArr));
        }
    }

    public static boolean isDebug() {
        return d;
    }

    public static void setDebug(boolean z) {
        d = z;
    }

    private static boolean v() {
        return d;
    }

    public static void w(String str, Object... objArr) {
        if (c(2)) {
            f23745a.j(y(), a(str, objArr));
        } else if (v()) {
            Log.w(y(), a(str, objArr));
        }
    }

    private static String y() {
        String methodName;
        if (!d) {
            return TAG;
        }
        StackTraceElement stackTraceElementA = a();
        String strSubstring = "";
        if (stackTraceElementA != null) {
            String className = stackTraceElementA.getClassName();
            strSubstring = TextUtils.isEmpty(className) ? "" : className.substring(className.lastIndexOf(46) + 1);
            methodName = stackTraceElementA.getMethodName();
        } else {
            methodName = "";
        }
        return "Analytics." + strSubstring + Consts.DOT + methodName;
    }

    private static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = c49.f40900a;
        }
        int i = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    public static void d(String str, Map<String, String> map) {
        if (c(4)) {
            f23745a.i(y(), a(str, map));
        } else if (v()) {
            Log.d(y(), a(str, map));
        }
    }

    public static void e(String str, Object... objArr) {
        if (c(1)) {
            f23745a.l(y(), a(str, objArr));
        } else if (v()) {
            Log.e(y(), a(str, objArr));
        }
    }

    public static void w(String str, Throwable th, Object... objArr) {
        if (c(2)) {
            f23745a.a(y(), a(str, objArr), th);
        } else if (v()) {
            Log.w(y(), a(str, objArr), th);
        }
    }

    public static void d(String str, Object... objArr) {
        if (c(4)) {
            f23745a.i(y(), a(str, objArr));
        } else if (v()) {
            Log.d(y(), a(str, objArr));
        }
    }

    public static void e(String str, Throwable th, Object... objArr) {
        if (c(1)) {
            f23745a.b(y(), a(str, objArr), th);
        } else if (v()) {
            Log.e(y(), a(str, objArr), th);
        }
    }

    private static String a(String str, Map<String, String> map) {
        if (str == null && map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        if (str == null) {
            str = c49.f40900a;
        }
        int i = 0;
        objArr[0] = str;
        sb.append(String.format("[%s] ", objArr));
        if (map != null) {
            int size = map.size();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey() + " : " + entry.getValue());
                i++;
                if (i < size) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static StackTraceElement a() {
        if (!d) {
            return null;
        }
        try {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(j.class.getName())) {
                    return stackTraceElement;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
