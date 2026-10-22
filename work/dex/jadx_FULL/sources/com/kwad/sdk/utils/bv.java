package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bv {
    public static long C(@Nullable Context context, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!z) {
            return jCurrentTimeMillis;
        }
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return Math.abs(jCurrentTimeMillis);
            }
            long j = sharedPreferences.getLong("key_time_diff_s2c", 0L);
            if (j != 0) {
                return jCurrentTimeMillis + j;
            }
        }
        return Math.abs(jCurrentTimeMillis);
    }

    public static void a(long j, int i, @Nullable Context context) {
        if (j == 0 || context == null || i <= 0 || i > 100) {
            return;
        }
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return;
            }
            if (Math.abs(jCurrentTimeMillis) / 3600000 > i) {
                sharedPreferences.edit().putLong("key_time_diff_s2c", jCurrentTimeMillis).apply();
            } else {
                sharedPreferences.edit().remove("key_time_diff_s2c").apply();
            }
        } catch (Throwable unused) {
        }
    }
}
