package com.aliyun.common.utils;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f25576a;

    public static Context a() {
        return f25576a;
    }

    public static void a(Context context) {
        f25576a = context.getApplicationContext();
    }
}
