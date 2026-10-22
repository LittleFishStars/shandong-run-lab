package com.huawei.hms.aaid.threads;

import android.util.Log;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.o;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class AsyncExec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f37412a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("SeqIO"), new ThreadPoolExecutor.AbortPolicy());

    public static void submitSeqIO(Runnable runnable) {
        try {
            f37412a.execute(new o(runnable));
        } catch (Exception e) {
            Log.e("HmsPushThreads", "submit seq io task failed, Exception:" + e);
        }
    }
}
