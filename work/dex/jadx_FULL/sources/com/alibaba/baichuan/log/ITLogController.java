package com.alibaba.baichuan.log;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ITLogController {
    boolean checkLogLength(String str);

    String compress(String str);

    void destroyLog(boolean z);

    byte[] ecrypted(byte[] bArr);

    byte[] ecrypted(byte[] bArr, int i, int i2);

    LogLevel getLogLevel(String str);

    boolean isFilter(LogLevel logLevel, String str);

    boolean isOpenLog();

    void openLog(boolean z);

    void setEndTime(long j);

    void setLogLevel(String str);

    void setModuleFilter(Map<String, LogLevel> map);
}
