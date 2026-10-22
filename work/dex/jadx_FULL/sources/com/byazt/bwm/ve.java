package com.byazt.bwm;

import com.ali.auth.third.login.LoginConstants;
import com.byazt.nr.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 33, 54})
public final class ve {
    public static final ve c = new ve();
    public final List<WeakReference<ThreadPoolExecutor>> tt = new ArrayList();
    public c uj;
    public tt ve;

    public interface c {
    }

    public interface tt {
    }

    private ve() {
        tt().schedule(new Runnable() { // from class: com.byazt.bwm.ve.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }

    private ScheduledExecutorService tt() {
        return i.tt.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        List<ThreadPoolExecutor> listC = c(null, false, false);
        if (listC == null || listC.size() == 0) {
            return;
        }
        if (this.ve != null) {
            uj.c();
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : listC) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof x) {
                    map.put(((x) threadFactory).c + LoginConstants.UNDER_LINE + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.byazt.mc.uj) {
                    map.put(((com.byazt.mc.uj) threadFactory).c() + LoginConstants.UNDER_LINE + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + LoginConstants.UNDER_LINE + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                c(threadPoolExecutor);
            }
        }
        if (this.ve != null) {
            uj.c();
        }
    }

    private boolean tt(com.byazt.jtc.uj ujVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.tt.iterator();
        while (it.hasNext()) {
            WeakReference<ThreadPoolExecutor> next = it.next();
            if (next != null) {
                ThreadPoolExecutor threadPoolExecutor = next.get();
                if (threadPoolExecutor == null) {
                    it.remove();
                } else if (threadPoolExecutor == ujVar) {
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized void c(com.byazt.jtc.uj ujVar) {
        if (tt(ujVar)) {
            return;
        }
        this.tt.add(new WeakReference<>(ujVar));
    }

    public String c(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.byazt.mc.c) {
            return ((com.byazt.mc.c) blockingQueue).c();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor c(String str, String str2) {
        List<ThreadPoolExecutor> listC = c(str2, false, true);
        c(listC, str);
        ThreadPoolExecutor threadPoolExecutor = listC.size() > 0 ? listC.get(0) : null;
        c();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> c(String str, boolean z, boolean z2) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z3;
        arrayList = new ArrayList();
        for (WeakReference<ThreadPoolExecutor> weakReference : this.tt) {
            if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue instanceof com.byazt.mc.c) {
                    z3 = ((com.byazt.mc.c) queue).tt() instanceof PriorityBlockingQueue;
                } else {
                    z3 = queue instanceof PriorityBlockingQueue;
                }
                if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().isEmpty() && (str == null || !z3)) {
                    if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getPoolSize()) {
                        arrayList.add(threadPoolExecutor);
                        if (z) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (z2 && !z) {
            try {
                Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.byazt.bwm.ve.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                        int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                        int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                        if (poolSize2 > poolSize) {
                            return 1;
                        }
                        return poolSize > poolSize2 ? -1 : 0;
                    }
                });
            } catch (Exception e) {
                m.c(e);
            }
        }
        arrayList.size();
        this.tt.size();
        return arrayList;
    }

    public void c() {
        if (i.tt.c()) {
            tt().schedule(new Runnable() { // from class: com.byazt.bwm.ve.2
                @Override // java.lang.Runnable
                public void run() {
                    ve.this.ve();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    private void c(final ThreadPoolExecutor threadPoolExecutor) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(timeUnit);
        final boolean zAllowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, timeUnit);
        if (zAllowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        tt().schedule(new Runnable() { // from class: com.byazt.bwm.ve.3
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                long j = keepAliveTime;
                if (j == 0) {
                    j = 60;
                }
                threadPoolExecutor2.setKeepAliveTime(j, TimeUnit.NANOSECONDS);
                threadPoolExecutor.allowCoreThreadTimeOut(zAllowsCoreThreadTimeOut);
            }
        }, 10L, TimeUnit.MILLISECONDS);
    }

    private void c(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.uj == null) {
            return;
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof x) {
                    map.put(((x) threadFactory).c + LoginConstants.UNDER_LINE + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.byazt.mc.uj) {
                    map.put(((com.byazt.mc.uj) threadFactory).c() + LoginConstants.UNDER_LINE + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + LoginConstants.UNDER_LINE + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap map2 = new HashMap();
        ThreadGroup threadGroupTt = uj.tt();
        int iActiveCount = threadGroupTt.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroupTt.enumerate(threadArr);
        for (int i = 0; i < iEnumerate; i++) {
            Thread thread = threadArr[i];
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) {
                String strReplaceAll = thread.getName().replaceAll("[0-9]", "");
                Integer num = (Integer) map2.get(strReplaceAll);
                map2.put(strReplaceAll, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
    }

    public void c(String str) {
        List<ThreadPoolExecutor> listC = c(null, false, true);
        if (listC == null || listC.size() == 0) {
            return;
        }
        c(listC, str);
        listC.size();
        ThreadPoolExecutor threadPoolExecutor = listC.get(0);
        if (threadPoolExecutor != null) {
            c(threadPoolExecutor);
        }
        c();
    }
}
