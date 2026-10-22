package com.alipay.sdk.m.y;

import com.alipay.sdk.interior.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Log.ISdkLogCallback f25529a = null;
    public static final String b = "alipaysdk";

    public static void a(Log.ISdkLogCallback iSdkLogCallback) {
        f25529a = iSdkLogCallback;
    }

    public static void b(String str, String str2) {
        a(a(str, str2));
    }

    public static void c(String str, String str2) {
        a(a(str, str2));
    }

    public static void d(String str, String str2) {
        a(a(str, str2));
    }

    public static void e(String str, String str2) {
        a(a(str, str2));
    }

    public static void a(String str) {
        try {
            Log.ISdkLogCallback iSdkLogCallback = f25529a;
            if (iSdkLogCallback != null) {
                if (com.alipay.sdk.m.o.b.i().h(null)) {
                    iSdkLogCallback.onLogLine("[AlipaySDK] " + str);
                } else {
                    iSdkLogCallback.onLogLine(String.format("[AlipaySDK] %s %s", new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(new Date()), str));
                }
            }
        } catch (Throwable unused) {
            android.util.Log.w("alipaySdkLog", "writeLog error");
        }
    }

    public static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void a(String str, String str2, Throwable th) {
        a(a(str, str2) + " " + b(th));
    }

    public static void a(Throwable th) {
        if (th == null) {
            return;
        }
        try {
            a(b(th));
        } catch (Throwable unused) {
        }
    }

    public static String a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!com.alipay.sdk.m.o.b.i().h(null)) {
            return "[" + str + "][" + str2 + "]";
        }
        return String.format("[%s][%s]", str, str2);
    }
}
