package com.bykv.vk.component.ttvideo.utils;

import com.byazt.bwm.x;
import com.byazt.jtc.uj;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class EngineThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f29292a;

    public static ExecutorService a() {
        if (f29292a == null) {
            synchronized (EngineThreadPool.class) {
                if (f29292a == null) {
                    uj ujVar = new uj(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new x("EngineThreadPool"));
                    f29292a = ujVar;
                    ujVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29292a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            f29292a = threadPoolExecutor;
        }
    }
}
