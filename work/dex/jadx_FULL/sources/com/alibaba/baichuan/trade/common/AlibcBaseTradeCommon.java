package com.alibaba.baichuan.trade.common;

import android.app.Application;
import com.alibaba.baichuan.log.TLogInitializer;
import com.alibaba.baichuan.trade.common.model.Environment;
import com.alibaba.baichuan.trade.common.mtop.AlibcMtop;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcBaseTradeCommon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f24540a = true;
    protected static String appKey = null;
    private static boolean b = false;
    public static Application context = null;
    protected static Environment environment = Environment.ONLINE;
    public static String isvVersion = "1.0.0";
    public static final String sdkVersion = "5.0.2.5";
    public static String ttid;
    protected static String utdid;

    public static void closeErrorLog() {
        f24540a = false;
    }

    public static String getAppKey() {
        return appKey;
    }

    public static Environment getEnvironment() {
        return environment;
    }

    public static String getLogFilePath() {
        if (TLogInitializer.getInstance().getInitState() == 2) {
            return TLogInitializer.getInstance().getFileDir();
        }
        return null;
    }

    public static String getUtdid() {
        return utdid;
    }

    public static boolean isDebug() {
        return b;
    }

    public static void openErrorLog() {
        f24540a = true;
    }

    public static boolean printErrorLog() {
        return f24540a;
    }

    public static void setEnvironment(Environment environment2) {
        environment = environment2;
    }

    public static void setIsvVersion(String str) {
        isvVersion = str;
    }

    public static void turnOffDebug() {
        b = false;
        AlibcMtop.getInstance().turnOffDebug();
        AlibcUserTracker.getInstance().turnOffDebug();
    }

    public static void turnOnDebug() {
        b = true;
        AlibcMtop.getInstance().turnOnDebug();
        AlibcUserTracker.getInstance().turnOnDebug();
    }
}
