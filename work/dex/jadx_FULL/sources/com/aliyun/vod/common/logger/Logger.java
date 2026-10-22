package com.aliyun.vod.common.logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Logger {
    public static final String DEFAULT_TAG = "QuLogger";
    private static boolean debug = false;
    private static LoggerPrinter loggerPrinter;

    public static LoggerPrinter getDefaultLogger() {
        if (loggerPrinter == null) {
            loggerPrinter = LoggerFactory.getFactory(DEFAULT_TAG, debug);
        }
        return loggerPrinter;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }
}
