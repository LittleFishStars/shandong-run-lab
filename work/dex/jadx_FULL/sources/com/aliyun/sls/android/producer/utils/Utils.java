package com.aliyun.sls.android.producer.utils;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class Utils {

    @SuppressLint({"StaticFieldLeak"})
    private static Context context;

    private Utils() {
    }

    public static Context getContext() {
        if (context == null) {
            context = ContextUtils.getApplication();
        }
        return context;
    }

    public static void setContext(Context context2) {
        context = context2 != null ? context2.getApplicationContext() : null;
    }
}
