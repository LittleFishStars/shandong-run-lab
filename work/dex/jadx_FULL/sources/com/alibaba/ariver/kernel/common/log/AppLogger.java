package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.common.RVProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppLogger {
    private static AppLoggerProxy a() {
        return (AppLoggerProxy) RVProxy.get(AppLoggerProxy.class);
    }

    public static String getBizType() {
        return a().getBizType();
    }

    public static int getQosLevel() {
        return a().getQosLevel();
    }

    public static void log(BaseAppLog baseAppLog) {
        a().log(baseAppLog);
    }
}
