package com.alibaba.triver.open.prefetch.task;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.open.prefetch.PrefectchCallback;
import com.alibaba.triver.open.prefetch.context.PrefetchContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class c<T extends PrefetchContext> {
    private static final String c = "PrefetchTask";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    T f25075a;
    PrefectchCallback b;

    public c(T t, PrefectchCallback prefectchCallback) {
        this.f25075a = t;
        this.b = prefectchCallback;
    }

    public ExecutorType a() {
        return ExecutorType.NETWORK;
    }

    public abstract void a(String str, Object... objArr);

    public abstract boolean b(String str, Object... objArr);

    public final void c(final String str, final Object... objArr) {
        if (b(str, new Object[0])) {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(a()).execute(new Runnable() { // from class: com.alibaba.triver.open.prefetch.task.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        RVLogger.d(c.c, "start task, type=" + c.this.f25075a.type);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        c.this.a(str, objArr);
                        RVLogger.d(c.c, "end task, type=" + c.this.f25075a.type + str + ", executeTime=" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    } catch (Throwable th) {
                        RVLogger.e(c.c, "execute ScheduleTask error, type=" + c.this.f25075a.type, th);
                    }
                }
            });
        } else {
            RVLogger.d(c, "task valid failed, type=" + this.f25075a.type);
        }
    }
}
