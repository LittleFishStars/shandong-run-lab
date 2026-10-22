package com.kwad.components.offline.api.core.api;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IAsync {
    void execute(Runnable runnable);

    void runOnDefaultExecutor(Runnable runnable);

    void runOnUiThread(Runnable runnable);

    void runOnUiThreadDelay(Runnable runnable, long j);

    void schedule(Runnable runnable, long j, TimeUnit timeUnit);
}
