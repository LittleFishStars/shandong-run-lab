package com.byazt.jtc;

import android.os.AsyncTask;
import com.byazt.bwm.x;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 728, 13})
public abstract class tt<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static final Executor c = new uj(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new x("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> c(Params... paramsArr) {
        return executeOnExecutor(c, paramsArr);
    }
}
