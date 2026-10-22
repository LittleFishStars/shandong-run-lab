package com.alibaba.baichuan.log;

import android.text.TextUtils;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.v39;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TLog {
    private static String getExceptionMsg(String str, Throwable th) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String message = th.getMessage();
        String name = th.getClass().getName();
        sb.append("\t");
        sb.append(str + "\t");
        sb.append(name);
        sb.append(q.a.i);
        sb.append(message);
        sb.append("\r\n");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (message == null || message.length() == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (sb.length() >= 30720) {
                sb.append(v39.f20173a);
                sb.append(String.format("\tTotal count %d. Ignore by overflow\r\n", Integer.valueOf(stackTrace.length)));
                break;
            }
            sb.append("\tat  ");
            sb.append(stackTraceElement);
            sb.append("\r\n");
        }
        return sb.toString();
    }

    private static void log(LogLevel logLevel, String str, String str2, String str3, String str4, String str5, String str6) {
        TLogNative.dispatch(logLevel.getIndex(), str, str2, str3, str4, str5, str6);
    }

    public static void logd(String str, String str2, String str3) {
        log(LogLevel.D, str, str2, str3);
    }

    public static void loge(String str, String str2, String str3) {
        log(LogLevel.E, str, str2, str3);
    }

    public static void logi(String str, String str2, String str3) {
        log(LogLevel.I, str, str2, str3);
    }

    public static void logv(String str, String str2, String str3) {
        log(LogLevel.V, str, str2, str3);
    }

    public static void logw(String str, String str2, String str3) {
        log(LogLevel.W, str, str2, str3);
    }

    public static void traceLog(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        log(LogLevel.F, "", "Trace", "T", str, str2, "NULL == log");
    }

    private static void log(LogLevel logLevel, String str, String str2, String str3) {
        log(logLevel, str, str2, "C", "", "", str3);
    }

    @Deprecated
    public static void logd(String str, String str2) {
        logd("", str, str2);
    }

    @Deprecated
    public static void loge(String str, String str2) {
        loge("", str, str2);
    }

    @Deprecated
    public static void logi(String str, String str2) {
        logi("", str, str2);
    }

    @Deprecated
    public static void logv(String str, String str2) {
        logv("", str, str2);
    }

    @Deprecated
    public static void logw(String str, String str2) {
        logw("", str, str2);
    }

    @Deprecated
    public static void logd(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logd("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logd("", str, sb.toString());
        }
    }

    @Deprecated
    public static void loge(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                loge("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            loge("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logi(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logi("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logi("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logv(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logv("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logv("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logw(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logw("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logw("", str, sb.toString());
        }
    }

    public static void loge(String str, String str2, Throwable th) {
        String exceptionMsg;
        if (th == null) {
            exceptionMsg = str2 + "******* NULL == e *******";
        } else {
            exceptionMsg = getExceptionMsg(str2, th);
        }
        loge("", str, exceptionMsg);
    }

    public static void logw(String str, String str2, Throwable th) {
        String exceptionMsg;
        if (th == null) {
            exceptionMsg = str2 + "******* NULL == e *******";
        } else {
            exceptionMsg = getExceptionMsg(str2, th);
        }
        logw("", str, exceptionMsg);
    }
}
