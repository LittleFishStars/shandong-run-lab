package com.baidu.vi;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class VIContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Context f26822a;

    public static Context getContext() {
        return f26822a;
    }

    public static void init(Context context) {
        f26822a = context;
    }
}
