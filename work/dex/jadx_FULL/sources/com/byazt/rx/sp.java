package com.byazt.rx;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 91})
public class sp {
    public static volatile HandlerThread c;
    public static volatile Handler tt;
    public static volatile Handler ve;

    public static HandlerThread c() {
        if (c == null) {
            synchronized (sp.class) {
                if (c == null) {
                    HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                    c = handlerThread;
                    handlerThread.start();
                    tt = new Handler(c.getLooper());
                }
            }
        }
        return c;
    }

    public static Handler tt() {
        if (tt == null) {
            c();
        }
        return tt;
    }
}
