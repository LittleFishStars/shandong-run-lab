package com.alibaba.triver.trace;

import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IRemoteLogProxy extends Proxiable {

    public enum LogLevel {
        Verbose,
        Info,
        Warn,
        Debug,
        Error
    }

    void eventLog(String str, LogLevel logLevel, String str2, String str3, String str4, String str5, Map<String, Object> map);

    void eventLogWithError(String str, LogLevel logLevel, String str2, String str3, String str4, String str5, int i, String str6, Map<String, Object> map);

    void pointLog(String str, LogLevel logLevel, String str2, String str3, String str4, String str5, Map<String, Object> map);

    void pointLogWithError(String str, LogLevel logLevel, String str2, String str3, String str4, String str5, int i, String str6, Map<String, Object> map);
}
