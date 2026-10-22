package com.kc.bw.okhttp.utils;

import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SafeRunnable implements Runnable {
    public final String TAG = dexg.dexa("XN`OFU`") + SafeRunnable.class.getSimpleName();
    public final Runnable originalRunnable;

    public SafeRunnable(Runnable runnable) {
        this.originalRunnable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnable = this.originalRunnable;
            if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            Log.w(this.TAG, dexg.dexa("uisfbe!fodpvoufsfe!bo!fydfqujpo)Ofu.TbgfSvoobcmf*!") + stackTraceString);
        }
    }
}
