package com.byazt.gv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 46})
public class n {
    public static final int c;
    public static final PriorityBlockingQueue<Runnable> n;
    public static final int tt;
    public static final PriorityBlockingQueue<Runnable> uj;
    public static final int ve;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        c = iAvailableProcessors;
        tt = (iAvailableProcessors / 2) + 1 < 4 ? 4 : (iAvailableProcessors / 2) + 1;
        ve = (iAvailableProcessors / 2) + 1 >= 4 ? (iAvailableProcessors / 2) + 1 : 4;
        uj = new PriorityBlockingQueue<>();
        n = new PriorityBlockingQueue<>();
    }

    public static ThreadPoolExecutor c() {
        int i = tt;
        return new com.byazt.jtc.uj(i, i, 1L, TimeUnit.SECONDS, uj, new uj(tt.c.NORMAL, "tt-api-thread-"));
    }

    public static ThreadPoolExecutor tt() {
        int i = ve;
        return new com.byazt.jtc.uj(i, i, 1L, TimeUnit.SECONDS, n, new uj(tt.c.NORMAL, "tt-default-thread-"));
    }

    public static ScheduledExecutorService ve() {
        return com.byazt.bwm.tt.ve(new uj(tt.c.LOW, "tt-delay-thread-"));
    }
}
