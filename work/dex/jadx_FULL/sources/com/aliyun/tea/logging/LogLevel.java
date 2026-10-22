package com.aliyun.tea.logging;

import androidx.core.app.NotificationCompat;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum LogLevel {
    VERBOSE(1, "1", "verbose", AliyunLogCommon.LogLevel.DEBUG),
    INFORMATIONAL(2, "2", AliyunLogCommon.LogLevel.INFO, "information", "informational"),
    WARNING(3, "3", AliyunLogCommon.LogLevel.WARN, "warning"),
    ERROR(4, "4", NotificationCompat.CATEGORY_ERROR, "error"),
    NOT_SET(5, "5");

    private static final HashMap<String, LogLevel> LOG_LEVEL_STRING_MAPPER = new HashMap<>();
    private final String[] allowedLogLevelVariables;
    private final int numericValue;

    static {
        for (LogLevel logLevel : values()) {
            for (String str : logLevel.allowedLogLevelVariables) {
                LOG_LEVEL_STRING_MAPPER.put(str, logLevel);
            }
        }
    }

    LogLevel(int i, String... strArr) {
        this.numericValue = i;
        this.allowedLogLevelVariables = strArr;
    }

    public static LogLevel fromString(String str) {
        if (str == null) {
            return NOT_SET;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        HashMap<String, LogLevel> map = LOG_LEVEL_STRING_MAPPER;
        if (map.containsKey(lowerCase)) {
            return map.get(lowerCase);
        }
        throw new IllegalArgumentException("We currently do not support the log level you set. LogLevel: " + str);
    }

    public int getLogLevel() {
        return this.numericValue;
    }
}
