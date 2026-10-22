package com.aliyun.vod.common.logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LoggerFactory {
    public static LoggerPrinter getFactory(String str, boolean z) {
        LoggerPrinter loggerPrinter = new LoggerPrinter();
        loggerPrinter.init(str);
        LogLevel logLevel = LogLevel.NONE;
        if (z) {
            logLevel = LogLevel.FULL;
        }
        loggerPrinter.getSettings().methodCount(3).logLevel(logLevel);
        return loggerPrinter;
    }
}
