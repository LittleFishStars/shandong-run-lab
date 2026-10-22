package com.alibaba.ariver.kernel.common.service.executor;

import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVExecutorService extends Proxiable {
    String getCurrentScheduleType();

    Executor getExecutor(ExecutorType executorType);

    ScheduledThreadPoolExecutor getScheduledExecutor();
}
