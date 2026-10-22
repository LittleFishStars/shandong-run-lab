package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class i {
    private static volatile ExecutorService bot;
    private static volatile ScheduledExecutorService bou;

    public static void execute(Runnable runnable) {
        if (bot == null) {
            synchronized (i.class) {
                if (bot == null) {
                    bot = GlobalThreadPools.Oi();
                }
            }
        }
        if (bot == null || bot.isShutdown() || bot.isTerminated()) {
            return;
        }
        bot.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (bou == null) {
            synchronized (i.class) {
                if (bou == null) {
                    bou = GlobalThreadPools.Oj();
                }
            }
        }
        bou.schedule(runnable, j, timeUnit);
    }
}
