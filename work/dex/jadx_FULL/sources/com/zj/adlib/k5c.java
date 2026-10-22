package com.zj.adlib;

import com.google.android.gms.internal.base.zaq;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k5c implements zaq {
    public k5c() {
    }

    public /* synthetic */ k5c(i5c i5cVar) {
    }

    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService a(ThreadFactory threadFactory, int i) {
        return c(1, threadFactory, 1);
    }

    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService b(int i, int i2) {
        return c(4, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService c(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
