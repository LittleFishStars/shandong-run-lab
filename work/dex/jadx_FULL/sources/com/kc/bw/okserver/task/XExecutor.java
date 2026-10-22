package com.kc.bw.okserver.task;

import com.kc.bw.okhttp.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class XExecutor extends ThreadPoolExecutor {
    public List<OnAllTaskEndListener> allTaskEndListenerList;
    public List<OnTaskEndListener> taskEndListenerList;

    @Keep
    public interface OnAllTaskEndListener {
        void onAllTaskEnd();
    }

    @Keep
    public interface OnTaskEndListener {
        void onTaskEnd(Runnable runnable);
    }

    public XExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
    }

    public XExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, rejectedExecutionHandler);
    }

    public XExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    public XExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    public void addOnAllTaskEndListener(OnAllTaskEndListener onAllTaskEndListener) {
        if (this.allTaskEndListenerList == null) {
            this.allTaskEndListenerList = new ArrayList();
        }
        this.allTaskEndListenerList.add(onAllTaskEndListener);
    }

    public void addOnTaskEndListener(OnTaskEndListener onTaskEndListener) {
        if (this.taskEndListenerList == null) {
            this.taskEndListenerList = new ArrayList();
        }
        this.taskEndListenerList.add(onTaskEndListener);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        List<OnAllTaskEndListener> list;
        super.afterExecute(runnable, th);
        List<OnTaskEndListener> list2 = this.taskEndListenerList;
        if (list2 != null && list2.size() > 0) {
            Iterator<OnTaskEndListener> it = this.taskEndListenerList.iterator();
            while (it.hasNext()) {
                ThreadUtils.mMainHandler.post(new Runnable(this, it.next(), runnable) { // from class: com.kc.bw.okserver.task.XExecutor.1
                    public final XExecutor this$0;
                    public final OnTaskEndListener val$listener;
                    public final Runnable val$r;

                    {
                        this.this$0 = this;
                        this.val$listener = onTaskEndListener;
                        this.val$r = runnable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.val$listener.onTaskEnd(this.val$r);
                    }
                });
            }
        }
        if (getActiveCount() != 1 || getQueue().size() != 0 || (list = this.allTaskEndListenerList) == null || list.size() <= 0) {
            return;
        }
        Iterator<OnAllTaskEndListener> it2 = this.allTaskEndListenerList.iterator();
        while (it2.hasNext()) {
            ThreadUtils.mMainHandler.post(new Runnable(this, it2.next()) { // from class: com.kc.bw.okserver.task.XExecutor.2
                public final XExecutor this$0;
                public final OnAllTaskEndListener val$listener;

                {
                    this.this$0 = this;
                    this.val$listener = onAllTaskEndListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.val$listener.onAllTaskEnd();
                }
            });
        }
    }

    public void removeOnAllTaskEndListener(OnAllTaskEndListener onAllTaskEndListener) {
        this.allTaskEndListenerList.remove(onAllTaskEndListener);
    }

    public void removeOnTaskEndListener(OnTaskEndListener onTaskEndListener) {
        this.taskEndListenerList.remove(onTaskEndListener);
    }
}
