package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ResolutionFlagUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ResolutionFlagUtil f37696a;
    private static final Map<String, Long> b = new ConcurrentHashMap();
    private static final Object c = new Object();

    private ResolutionFlagUtil() {
    }

    private void a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String str : b.keySet()) {
            Map<String, Long> map = b;
            Long l = map.get(str);
            if (l == null || l.longValue() == 0) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + str);
            } else if (time >= l.longValue()) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because aging time: " + str);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f37696a != null) {
            return f37696a;
        }
        synchronized (c) {
            if (f37696a == null) {
                f37696a = new ResolutionFlagUtil();
            }
        }
        return f37696a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return 0L;
        }
        Map<String, Long> map = b;
        if (map.get(str) != null) {
            return map.get(str).longValue();
        }
        return 0L;
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
        } else {
            b.remove(str);
            HMSLog.i("ResolutionFlagUtil", "remove resolution flag");
        }
    }

    public void saveResolutionFlag(String str, long j) {
        if (!TextUtils.isEmpty(str) && j != 0) {
            a(str, j);
            return;
        }
        HMSLog.e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j);
    }

    private void a(String str, long j) {
        Map<String, Long> map = b;
        synchronized (map) {
            a();
            map.put(str, Long.valueOf(j));
            HMSLog.i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
