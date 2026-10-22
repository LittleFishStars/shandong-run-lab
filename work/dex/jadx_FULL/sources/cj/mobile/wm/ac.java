package cj.mobile.wm;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ac implements bc {
    public static final Executor dexa = new ThreadPoolExecutor(10, 12, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    @Override // cj.mobile.wm.bc
    public void dexa(String str, Runnable runnable) {
        dexa.execute(runnable);
    }
}
