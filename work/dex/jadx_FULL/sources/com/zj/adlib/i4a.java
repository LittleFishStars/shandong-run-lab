package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class i4a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f42281a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f17145a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f17146a = "XLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Pattern f17147a;
    public static Boolean b;

    public static int a(String msg) {
        if (j()) {
            return Log.d(e(), q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static int b(@NonNull String tag, String msg) {
        if (j()) {
            return Log.d(tag, q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static int c(String msg) {
        if (j()) {
            return Log.e(e(), q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static int d(@NonNull String tag, String msg) {
        if (j()) {
            return Log.e(tag, q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static String e() {
        String str = f17146a;
        return str == null ? "XLog" : str;
    }

    public static int f(String msg) {
        if (j()) {
            return Log.i(e(), q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static int g(@NonNull String tag, String msg) {
        if (j()) {
            return Log.i(tag, q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static void h(Context context) {
        if (context != null) {
            f42281a = context.getApplicationContext();
        }
    }

    public static void i(Context context, @Nullable String tag, boolean debug, boolean stackTrace) {
        if (context != null) {
            f42281a = context.getApplicationContext();
        }
        if (!TextUtils.isEmpty(tag)) {
            f17146a = tag;
        }
        f17145a = Boolean.valueOf(debug);
        b = Boolean.valueOf(stackTrace);
        Context context2 = f42281a;
        if (context2 != null) {
            SharedPreferences.Editor editorEdit = context2.getSharedPreferences("xlog_config", 0).edit();
            editorEdit.putInt("xlog_debug", debug ? 1 : 2);
            editorEdit.putInt("xlog_trace", stackTrace ? 1 : 2);
            editorEdit.apply();
        }
    }

    public static boolean j() {
        if (f17145a == null) {
            Context context = f42281a;
            if (context != null) {
                boolean z = false;
                int i = context.getSharedPreferences("xlog_config", 0).getInt("xlog_debug", 0);
                if (i == 1 || i == 2) {
                    f17145a = Boolean.valueOf(i == 1);
                } else {
                    ApplicationInfo applicationInfo = f42281a.getApplicationInfo();
                    if (applicationInfo != null && (applicationInfo.flags & 2) != 0) {
                        z = true;
                    }
                    f17145a = Boolean.valueOf(z);
                }
            } else {
                f17145a = Boolean.FALSE;
            }
        }
        return f17145a.booleanValue();
    }

    public static boolean k() {
        if (b == null) {
            Context context = f42281a;
            if (context != null) {
                int i = context.getSharedPreferences("xlog_config", 0).getInt("xlog_trace", 0);
                if (i == 1 || i == 2) {
                    b = Boolean.valueOf(i == 1);
                } else {
                    b = Boolean.TRUE;
                }
            } else {
                b = Boolean.FALSE;
            }
        }
        return b.booleanValue();
    }

    public static void l(String message) {
        try {
            throw new IllegalAccessException(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int m(String msg) {
        if (j()) {
            return Log.v(e(), q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static int n(@NonNull String tag, String msg) {
        if (j()) {
            return Log.v(tag, q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static int o(String msg) {
        if (j()) {
            return Log.w(e(), q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static int p(@NonNull String tag, String msg) {
        if (j()) {
            return Log.w(tag, q(k() ? 2 : -1, msg));
        }
        return -1;
    }

    public static String q(int stackIndex, String msg) {
        StackTraceElement[] stackTrace;
        if (msg == null) {
            msg = "打印内容是 null";
        } else if (TextUtils.isEmpty(msg)) {
            msg = "打印内容是 空字符串";
        }
        if (stackIndex < 0 || (stackTrace = new Throwable().getStackTrace()) == null || stackTrace.length <= stackIndex) {
            return msg;
        }
        String className = stackTrace[stackIndex].getClassName();
        if (f17147a == null) {
            f17147a = Pattern.compile("(\\$\\d+)+$");
        }
        Matcher matcher = f17147a.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        return ".(" + className.substring(className.lastIndexOf(46) + 1) + ".java:" + stackTrace[stackIndex].getLineNumber() + ") - " + msg;
    }
}
