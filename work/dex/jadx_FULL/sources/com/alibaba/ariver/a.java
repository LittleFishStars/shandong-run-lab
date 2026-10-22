package com.alibaba.ariver;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f23809a;

    public static synchronized Handler a() {
        if (f23809a == null) {
            HandlerThread handlerThread = new HandlerThread("H5EvenDispatchHandler");
            handlerThread.start();
            f23809a = new Handler(handlerThread.getLooper());
        }
        return f23809a;
    }
}
