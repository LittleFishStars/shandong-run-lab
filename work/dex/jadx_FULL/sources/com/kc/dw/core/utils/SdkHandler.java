package com.kc.dw.core.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkHandler {
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final String TAG = "SdkHandler";
    private Handler mHandler;

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SdkHandler f39344a = new SdkHandler();
    }

    private SdkHandler() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public static SdkHandler getInstance() {
        return b.f39344a;
    }

    public static void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        Message messageObtain = Message.obtain(MAIN_HANDLER, runnable);
        try {
            messageObtain.setAsynchronous(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageObtain.sendToTarget();
    }

    public void postDelay(Runnable runnable, long j) {
        this.mHandler.postDelayed(runnable, j);
    }

    public void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }
}
