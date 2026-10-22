package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class JNIInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f26479a;

    public static Context getCachedContext() {
        return f26479a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f26479a == null) {
            f26479a = application;
        }
        VIContext.init(application);
    }
}
