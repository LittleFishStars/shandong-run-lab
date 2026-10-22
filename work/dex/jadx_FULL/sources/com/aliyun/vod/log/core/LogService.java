package com.aliyun.vod.log.core;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LogService {
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    public LogService(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    public void quit() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }
}
