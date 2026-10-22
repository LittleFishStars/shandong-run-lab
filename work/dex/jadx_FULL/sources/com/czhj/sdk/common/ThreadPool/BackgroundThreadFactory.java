package com.czhj.sdk.common.ThreadPool;

import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BackgroundThreadFactory implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        SigmobLog.d("ThreadFactor create ,current thread num :" + Thread.activeCount());
        return new Thread(runnable) { // from class: com.czhj.sdk.common.ThreadPool.BackgroundThreadFactory.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
            }
        };
    }
}
