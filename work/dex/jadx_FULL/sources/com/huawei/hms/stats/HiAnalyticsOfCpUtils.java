package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class HiAnalyticsOfCpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HiAnalyticsInstance f37641a;

    private static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f37641a = analyticsInstance;
        return analyticsInstance;
    }

    public static void onEvent(Context context, String str, String str2) {
        if (a(context) != null) {
            f37641a.onEvent(context, str, str2);
        }
    }

    public static void onReport(Context context, int i) {
        if (a(context) != null) {
            f37641a.onReport(i);
        }
    }

    public static void onStreamEvent(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f37641a.onStreamEvent(i, str, linkedHashMap);
        }
    }

    public static void onEvent(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f37641a.onEvent(i, str, linkedHashMap);
        }
    }
}
