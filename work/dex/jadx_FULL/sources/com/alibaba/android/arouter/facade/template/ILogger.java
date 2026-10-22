package com.alibaba.android.arouter.facade.template;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ILogger {
    public static final String defaultTag = "ARouter::";
    public static final boolean isShowLog = false;
    public static final boolean isShowStackTrace = false;

    void debug(String str, String str2);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th);

    String getDefaultTag();

    void info(String str, String str2);

    boolean isMonitorMode();

    void monitor(String str);

    void showLog(boolean z);

    void showStackTrace(boolean z);

    void warning(String str, String str2);
}
