package android.taobao.windvane.util;

import android.taobao.windvane.base.ILogService;
import android.taobao.windvane.base.m;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class TaoLog {
    public static Map<String, Integer> LogLevel = new HashMap();
    private static boolean enabled = false;
    private static ILogService impl = null;
    private static final String tagPre = "WindVane.";

    static {
        for (ILogService.LogLevelEnum logLevelEnum : ILogService.LogLevelEnum.values()) {
            LogLevel.put(logLevelEnum.getLogLevelName(), Integer.valueOf(logLevelEnum.getLogLevel()));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (shouldPrintDebug()) {
            ILogService iLogService = impl;
            if (iLogService == null) {
                Log.d(tagPre, format(str2, objArr));
                return;
            }
            iLogService.a(tagPre + str, format(str2, objArr));
        }
    }

    public static void e(String str, String str2) {
        if (shouldPrintError()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.b(tagPre + str, str2);
                return;
            }
            Log.e(tagPre + str, str2);
        }
    }

    private static String format(String str, Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    public static boolean getLogStatus() {
        return enabled;
    }

    public static void i(String str, String str2) {
        if (shouldPrintInfo()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.c(tagPre + str, str2);
                return;
            }
            Log.i(tagPre + str, str2);
        }
    }

    @Deprecated
    public static void setImpl(ILogService iLogService) {
        if (EnvUtil.isAppDebug()) {
            w("TaoLog", "Ignore set log impl on debug mode");
        } else {
            impl = iLogService;
        }
    }

    public static void setLogSwitcher(boolean z) {
        enabled = z;
    }

    public static boolean shouldPrintDebug() {
        ILogService iLogService;
        impl = (ILogService) m.a().b(ILogService.class);
        return getLogStatus() && ((iLogService = impl) == null || iLogService.a(ILogService.LogLevelEnum.DEBUG.getLogLevel()));
    }

    public static boolean shouldPrintError() {
        ILogService iLogService;
        impl = (ILogService) m.a().b(ILogService.class);
        return getLogStatus() && ((iLogService = impl) == null || iLogService.a(ILogService.LogLevelEnum.ERROR.getLogLevel()));
    }

    public static boolean shouldPrintInfo() {
        ILogService iLogService;
        impl = (ILogService) m.a().b(ILogService.class);
        return getLogStatus() && ((iLogService = impl) == null || iLogService.a(ILogService.LogLevelEnum.INFO.getLogLevel()));
    }

    public static boolean shouldPrintVerbose() {
        ILogService iLogService;
        impl = (ILogService) m.a().b(ILogService.class);
        return getLogStatus() && ((iLogService = impl) == null || iLogService.a(ILogService.LogLevelEnum.VERBOSE.getLogLevel()));
    }

    public static boolean shouldPrintWarn() {
        ILogService iLogService;
        impl = (ILogService) m.a().b(ILogService.class);
        return getLogStatus() && ((iLogService = impl) == null || iLogService.a(ILogService.LogLevelEnum.WARNING.getLogLevel()));
    }

    public static void v(String str, String str2) {
        if (shouldPrintVerbose()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.d(tagPre + str, str2);
                return;
            }
            Log.v(tagPre + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (shouldPrintWarn()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.e(tagPre + str, str2);
                return;
            }
            Log.w(tagPre + str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th, Object... objArr) {
        ILogService iLogService;
        if (!shouldPrintDebug() || (iLogService = impl) == null) {
            return;
        }
        iLogService.a(tagPre + str, format(str2, objArr), th);
    }

    public static void e(String str, String str2, Object... objArr) {
        if (shouldPrintError()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.b(tagPre + str, format(str2, objArr));
                return;
            }
            Log.e(tagPre + str, format(str2, objArr));
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (shouldPrintError()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.c(tagPre + str, format(str2, objArr));
                return;
            }
            Log.i(tagPre + str, format(str2, objArr));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (shouldPrintError()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.d(tagPre + str, format(str2, objArr));
                return;
            }
            Log.v(tagPre + str, format(str2, objArr));
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (shouldPrintError()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.e(tagPre + str, format(str2, objArr));
                return;
            }
            Log.w(tagPre + str, format(str2, objArr));
        }
    }

    public static void d(String str, String str2) {
        if (shouldPrintDebug()) {
            ILogService iLogService = impl;
            if (iLogService != null) {
                iLogService.a(tagPre + str, str2);
                return;
            }
            Log.d(tagPre + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        ILogService iLogService;
        if (!shouldPrintError() || (iLogService = impl) == null) {
            return;
        }
        iLogService.b(tagPre + str, format(str2, objArr), th);
    }

    public static void i(String str, String str2, Throwable th, Object... objArr) {
        ILogService iLogService;
        if (!shouldPrintInfo() || (iLogService = impl) == null) {
            return;
        }
        iLogService.c(tagPre + str, format(str2, objArr), th);
    }

    public static void v(String str, String str2, Throwable th, Object... objArr) {
        ILogService iLogService;
        if (!shouldPrintVerbose() || (iLogService = impl) == null) {
            return;
        }
        iLogService.d(tagPre + str, format(str2, objArr), th);
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        ILogService iLogService;
        if (!shouldPrintWarn() || (iLogService = impl) == null) {
            return;
        }
        iLogService.e(tagPre + str, format(str2, objArr), th);
    }
}
