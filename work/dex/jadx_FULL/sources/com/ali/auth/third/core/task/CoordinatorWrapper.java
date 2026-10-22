package com.ali.auth.third.core.task;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CoordinatorWrapper<Params> {
    public void execute(AsyncTask asyncTask, Params... paramsArr) {
        if (asyncTask != null) {
            try {
                asyncTask.execute(paramsArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @TargetApi(11)
    public void execute(Runnable runnable) {
        if (runnable != null) {
            Coordinator.execute(runnable);
        }
    }
}
