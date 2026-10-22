package com.aliyun.vod.log.core;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AliyunLoggerManager {
    private static Map<String, AliyunLogger> mLoggers = new HashMap();
    private static boolean sLoggerOpen = true;

    public static AliyunLogger createLogger(Context context, String str) {
        if (!sLoggerOpen) {
            return null;
        }
        AliyunLogger aliyunLogger = mLoggers.get(str);
        if (aliyunLogger != null) {
            return aliyunLogger;
        }
        AliyunLogger aliyunLogger2 = new AliyunLogger(new LogService(str));
        aliyunLogger2.init(context);
        mLoggers.put(str, aliyunLogger2);
        return aliyunLogger2;
    }

    public static void destroyLogger(String str) {
        AliyunLogger aliyunLoggerRemove = mLoggers.remove(str);
        if (aliyunLoggerRemove != null) {
            aliyunLoggerRemove.destroy();
        }
    }

    public static AliyunLogger getLogger(String str) {
        if (sLoggerOpen) {
            return mLoggers.get(str);
        }
        return null;
    }

    public static boolean isLoggerOpen() {
        return sLoggerOpen;
    }

    public static void toggleLogger(boolean z) {
        sLoggerOpen = z;
    }
}
