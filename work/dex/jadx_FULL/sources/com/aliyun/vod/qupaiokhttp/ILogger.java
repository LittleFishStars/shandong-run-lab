package com.aliyun.vod.qupaiokhttp;

import com.aliyun.vod.common.logger.LoggerFactory;
import com.aliyun.vod.common.logger.LoggerPrinter;
import com.aliyun.vod.common.logger.Printer;
import com.aliyun.vod.common.logger.Settings;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ILogger {
    protected static boolean DEBUG = false;
    public static final String DEFAULT_TAG = "OkHttpFinal";
    private static LoggerPrinter printer;

    private ILogger() {
        printer = LoggerFactory.getFactory(DEFAULT_TAG, DEBUG);
    }

    public static void clear() {
        createInstance();
        printer.clear();
    }

    private static void createInstance() {
        if (printer == null) {
            new ILogger();
        }
    }

    public static void d(String str, Object... objArr) {
        createInstance();
        printer.d(str, objArr);
    }

    public static void e(Throwable th) {
        createInstance();
        printer.e(th);
    }

    public static Settings getSettings() {
        createInstance();
        return printer.getSettings();
    }

    public static void i(String str, Object... objArr) {
        createInstance();
        printer.i(str, objArr);
    }

    public static void json(String str) {
        createInstance();
        printer.json(str);
    }

    public static Printer t(String str) {
        createInstance();
        LoggerPrinter loggerPrinter = printer;
        return loggerPrinter.t(str, loggerPrinter.getSettings().getMethodCount());
    }

    public static void v(String str, Object... objArr) {
        createInstance();
        printer.v(str, objArr);
    }

    public static void w(String str, Object... objArr) {
        createInstance();
        printer.w(str, objArr);
    }

    public static void wtf(String str, Object... objArr) {
        createInstance();
        printer.wtf(str, objArr);
    }

    public static void xml(String str) {
        createInstance();
        printer.xml(str);
    }

    public static void e(String str, Object... objArr) {
        createInstance();
        printer.e(null, str, objArr);
    }

    public static Printer t(int i) {
        createInstance();
        return printer.t(null, i);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        createInstance();
        printer.e(th, str, objArr);
    }

    public static Printer t(String str, int i) {
        createInstance();
        return printer.t(str, i);
    }
}
