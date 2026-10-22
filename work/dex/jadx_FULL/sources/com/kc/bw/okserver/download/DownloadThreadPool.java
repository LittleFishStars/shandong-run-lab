package com.kc.bw.okserver.download;

import com.kc.bw.okserver.task.PriorityBlockingQueue;
import com.kc.bw.okserver.task.XExecutor;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DownloadThreadPool {
    public static final int KEEP_ALIVE_TIME = 1;
    public static final int MAX_POOL_SIZE = 5;
    public static final TimeUnit UNIT = TimeUnit.HOURS;
    public int corePoolSize = 3;
    public XExecutor executor;

    public void execute(Runnable runnable) {
        if (runnable != null) {
            getExecutor().execute(runnable);
        }
    }

    public XExecutor getExecutor() {
        if (this.executor == null) {
            synchronized (DownloadThreadPool.class) {
                try {
                    if (this.executor == null) {
                        this.executor = new XExecutor(this.corePoolSize, 5, 1L, UNIT, new PriorityBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.executor;
    }

    public void remove(Runnable runnable) {
        if (runnable != null) {
            getExecutor().remove(runnable);
        }
    }

    public void setCorePoolSize(int i) {
        if (i <= 0) {
            i = 1;
        }
        if (i > 5) {
            i = 5;
        }
        this.corePoolSize = i;
    }
}
