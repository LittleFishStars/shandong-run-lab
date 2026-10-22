package cj.mobile.wm.common.runnable;

import android.util.Log;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SafeRunnable implements Runnable {
    public final String TAG = dexc.dexa("XN`DPNNPO`") + SafeRunnable.class.getSimpleName();
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
            Log.w(this.TAG, dexc.dexa("uisfbe!fodpvoufsfe!bo!fydfqujpo)Dpnnpo.TbgfSvoobcmf*!") + stackTraceString);
        }
    }
}
