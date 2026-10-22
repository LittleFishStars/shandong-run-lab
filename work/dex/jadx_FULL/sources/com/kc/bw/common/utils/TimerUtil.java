package com.kc.bw.common.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TimerUtil {
    public static volatile TimerUtil timerUtil;
    public Timer timer = new Timer();

    public static TimerUtil getInstance() {
        if (timerUtil == null) {
            synchronized (TimerUtil.class) {
                try {
                    if (timerUtil == null) {
                        timerUtil = new TimerUtil();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return timerUtil;
    }

    public void cancel() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    public void cancelTask(TimerTask timerTask) {
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    public void schedule(long j, long j2, TimerTask timerTask) {
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.schedule(timerTask, j, j2);
    }

    public void schedule(long j, TimerTask timerTask) {
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.schedule(timerTask, j);
    }
}
