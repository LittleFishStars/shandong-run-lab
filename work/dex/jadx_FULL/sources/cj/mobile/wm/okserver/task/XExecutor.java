package cj.mobile.wm.okserver.task;

import cj.mobile.wm.okhttp.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class XExecutor extends ThreadPoolExecutor {
    public List<OnAllTaskEndListener> allTaskEndListenerList;
    public List<OnTaskEndListener> taskEndListenerList;

    public interface OnAllTaskEndListener {
        void onAllTaskEnd();
    }

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
    public void afterExecute(final Runnable runnable, Throwable th) {
        List<OnAllTaskEndListener> list;
        super.afterExecute(runnable, th);
        List<OnTaskEndListener> list2 = this.taskEndListenerList;
        if (list2 != null && list2.size() > 0) {
            for (final OnTaskEndListener onTaskEndListener : this.taskEndListenerList) {
                ThreadUtils.mMainHandler.post(new Runnable() { // from class: cj.mobile.wm.okserver.task.XExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onTaskEndListener.onTaskEnd(runnable);
                    }
                });
            }
        }
        if (getActiveCount() != 1 || getQueue().size() != 0 || (list = this.allTaskEndListenerList) == null || list.size() <= 0) {
            return;
        }
        for (final OnAllTaskEndListener onAllTaskEndListener : this.allTaskEndListenerList) {
            ThreadUtils.mMainHandler.post(new Runnable() { // from class: cj.mobile.wm.okserver.task.XExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    onAllTaskEndListener.onAllTaskEnd();
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
