package com.aliyun.vod.common.logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface Printer {
    void clear();

    void d(String str, Object... objArr);

    void e(String str, Object... objArr);

    void e(Throwable th);

    void e(Throwable th, String str, Object... objArr);

    Settings getSettings();

    void i(String str, Object... objArr);

    void json(String str);

    Printer t(String str, int i);

    void v(String str, Object... objArr);

    void w(String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void xml(String str);
}
