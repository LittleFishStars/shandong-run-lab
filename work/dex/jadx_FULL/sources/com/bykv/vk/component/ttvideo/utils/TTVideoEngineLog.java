package com.bykv.vk.component.ttvideo.utils;

import android.text.TextUtils;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class TTVideoEngineLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogNotifyLevel = 116;
    public static int LogTurnOn = 112;
    public static TTVideoEngineLogListener mListener;

    private static void a(String str, String str2) {
        if (mListener == null || TextUtils.isEmpty(str2)) {
            return;
        }
        TTVideoEngineLogListener tTVideoEngineLogListener = mListener;
        if (!TextUtils.isEmpty(str)) {
            str2 = "TTVideoEngine: tag = " + str + ";  " + str2 + "\n";
        }
        tTVideoEngineLogListener.consoleLog(str2);
    }

    public static final void d(String str, String str2) {
        if (((LogNotifyLevel >> 1) & 1) == 1) {
            a(str, str2);
        }
        if (((LogTurnOn >> 1) & 1) == 1) {
            String.format("<%s>%s", str, str2);
        }
    }

    public static void d(Throwable th) {
        if (((LogTurnOn >> 1) & 1) == 1) {
            m.c(th);
        }
    }

    public static void e(String str, String str2) {
        if (((LogNotifyLevel >> 6) & 1) == 1) {
            a(str, str2);
        }
        if (((LogTurnOn >> 6) & 1) == 1) {
            m.uj("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static final void i(String str, String str2) {
        if (((LogNotifyLevel >> 2) & 1) == 1) {
            a(str, str2);
        }
        if (((LogTurnOn >> 2) & 1) == 1) {
            m.c("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static final void k(String str, String str2) {
        if (((LogNotifyLevel >> 4) & 1) == 1) {
            a(str, str2);
        }
        if (((LogTurnOn >> 4) & 1) == 1) {
            m.c("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static final void setListener(TTVideoEngineLogListener tTVideoEngineLogListener) {
        mListener = tTVideoEngineLogListener;
    }

    public static final void setLogNotifyLevel(int i, int i2) {
        LogNotifyLevel = (i2 << i) | ((~(1 << i)) & LogNotifyLevel);
    }

    public static final void t(String str, String str2) {
        if (((LogNotifyLevel >> 3) & 1) == 1) {
            a(str, str2);
        }
        if (((LogTurnOn >> 3) & 1) == 1) {
            m.c("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static final void turnOn(int i, int i2) {
        int i3 = ((~(1 << i)) & LogTurnOn) | (i2 << i);
        LogTurnOn = i3;
        if (i == 1 && i2 == 1) {
            LogTurnOn = (i3 & (-5)) | (i2 << 2);
        }
    }

    public static final void w(String str, String str2) {
        if (((LogNotifyLevel >> 5) & 1) == 1) {
            a(str, str2);
        }
        if (((LogTurnOn >> 5) & 1) == 1) {
            m.tt("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }
}
