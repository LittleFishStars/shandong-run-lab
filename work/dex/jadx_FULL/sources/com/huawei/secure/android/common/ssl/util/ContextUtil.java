package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ContextUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f37745a;

    public static Context getInstance() {
        return f37745a;
    }

    public static void setContext(Context context) {
        if (context == null || f37745a != null) {
            return;
        }
        f37745a = context.getApplicationContext();
    }
}
