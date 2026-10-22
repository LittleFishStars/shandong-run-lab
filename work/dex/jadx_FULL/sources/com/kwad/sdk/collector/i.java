package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i {
    public static void a(Context context, AppStatusRules.Strategy strategy, long j) {
        if (context == null || strategy == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(b(strategy), j).apply();
    }

    private static String b(AppStatusRules.Strategy strategy) {
        return "appstatus_strategy_pref_" + (strategy.getName() == null ? "defaultStrategy" : strategy.getName());
    }

    public static List<AppStatusRules.Strategy> c(@Nullable AppStatusRules appStatusRules) {
        return appStatusRules == null ? new ArrayList() : appStatusRules.obtainNamedStrategyList();
    }

    @NonNull
    public static AppStatusRules.Strategy d(@Nullable AppStatusRules appStatusRules) {
        return appStatusRules == null ? AppStatusRules.Strategy.LOCAL_DEFAULT : appStatusRules.obtainDefaultStrategy();
    }

    public static boolean a(Context context, @NonNull AppStatusRules.Strategy strategy) {
        if (context == null) {
            return false;
        }
        long j = context.getSharedPreferences("ksadsdk_pref", 0).getLong(b(strategy), -1L);
        if (j < 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long minLaunchIntervalWithMS = strategy.getMinLaunchIntervalWithMS();
        return minLaunchIntervalWithMS <= 0 || j + minLaunchIntervalWithMS < jCurrentTimeMillis;
    }
}
