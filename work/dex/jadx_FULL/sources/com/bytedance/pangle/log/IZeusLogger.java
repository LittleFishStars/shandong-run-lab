package com.bytedance.pangle.log;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public interface IZeusLogger {
    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);
}
