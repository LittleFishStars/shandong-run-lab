package com.czhj.sdk.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SharedPreferencesUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f29452a = "com.sigmob.Settings";

    private SharedPreferencesUtil(String str) {
        f29452a = str;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        Preconditions.NoThrow.checkNotNull(context);
        return context.getSharedPreferences(f29452a, 4);
    }

    public static SharedPreferences getSharedPreferences(Context context, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(str);
        return context.getSharedPreferences(str, 4);
    }
}
