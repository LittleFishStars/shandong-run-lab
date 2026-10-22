package com.baidu.location.b;

import android.os.HandlerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f26399a;

    public static synchronized HandlerThread a() {
        if (f26399a == null) {
            try {
                HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
                f26399a = handlerThread;
                handlerThread.start();
            } catch (Throwable th) {
                th.printStackTrace();
                f26399a = null;
            }
        }
        return f26399a;
    }
}
