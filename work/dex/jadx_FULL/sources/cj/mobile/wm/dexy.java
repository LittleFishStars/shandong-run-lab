package cj.mobile.wm;

import android.content.Context;
import android.os.Process;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexy implements Thread.UncaughtExceptionHandler {
    public static volatile dexy dexb;
    public Thread.UncaughtExceptionHandler dexa;

    public static synchronized dexy dexa() {
        if (dexb == null) {
            synchronized (dexy.class) {
                if (dexb == null) {
                    dexb = new dexy();
                }
            }
        }
        return dexb;
    }

    public void dexa(Context context) {
        this.dexa = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        f1.dexb("CrashHandler", "exception !" + Arrays.toString(th.getStackTrace()));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.dexa;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
