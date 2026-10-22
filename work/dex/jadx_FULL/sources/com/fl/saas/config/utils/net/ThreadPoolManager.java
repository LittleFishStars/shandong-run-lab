package com.fl.saas.config.utils.net;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ThreadPoolManager {
    private static final int CORE_POOL_SIZE;
    private static final long KEEP_ALIVE_TIME = 60;
    private static final int MAX_POOL_SIZE;
    private static final int WORK_QUEUE_CAPACITY = 128;
    public Runnable coreThread;
    private final LinkedBlockingQueue<Runnable> mQueue;
    private final ScheduledExecutorService mScheduledExecutorService;
    private final ThreadPoolExecutor mThreadPoolExecutor;

    public static final class Holder {
        private static final ThreadPoolManager INSTANCE = new ThreadPoolManager();

        private Holder() {
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CORE_POOL_SIZE = iAvailableProcessors;
        MAX_POOL_SIZE = (iAvailableProcessors * 2) + 1;
    }

    private ThreadPoolManager() {
        this.mQueue = new LinkedBlockingQueue<>();
        this.coreThread = new Runnable() { // from class: com.fl.saas.config.utils.net.ThreadPoolManager.1
            Runnable run = null;

            /* JADX INFO: Infinite loop detected, blocks: 13, insns: 0 */
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        this.run = null;
                        this.run = (Runnable) ThreadPoolManager.this.mQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (this.run != null) {
                        ThreadPoolManager.this.mThreadPoolExecutor.execute(this.run);
                    }
                }
            }
        };
        int i = CORE_POOL_SIZE;
        this.mScheduledExecutorService = Executors.newScheduledThreadPool(i);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new RejectedExecutionHandler() { // from class: com.zj.adlib.s59
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                this.f44614a.lambda$new$0(runnable, threadPoolExecutor2);
            }
        });
        this.mThreadPoolExecutor = threadPoolExecutor;
        threadPoolExecutor.execute(this.coreThread);
    }

    private void addRejectedTask(Runnable runnable) {
        if (runnable != null) {
            try {
                this.mQueue.put(runnable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ThreadPoolManager getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        addRejectedTask(runnable);
    }

    public void addTask(Runnable runnable) {
        if (runnable != null) {
            try {
                this.mThreadPoolExecutor.execute(runnable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeTask(Runnable runnable) {
        if (runnable != null) {
            try {
                this.mThreadPoolExecutor.remove(runnable);
                this.mQueue.remove(runnable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        this.mScheduledExecutorService.schedule(runnable, j, timeUnit);
    }
}
