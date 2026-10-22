package cj.mobile.wm.common.utils;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TimerUtil {
    public static volatile TimerUtil timerUtil;
    public Timer timer = new Timer();

    public static TimerUtil getInstance() {
        if (timerUtil == null) {
            synchronized (TimerUtil.class) {
                if (timerUtil == null) {
                    timerUtil = new TimerUtil();
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

    public void schedule(long j, TimerTask timerTask) {
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.schedule(timerTask, j);
    }

    public void schedule(long j, long j2, TimerTask timerTask) {
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.schedule(timerTask, j, j2);
    }
}
