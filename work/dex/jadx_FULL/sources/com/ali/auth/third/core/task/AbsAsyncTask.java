package com.ali.auth.third.core.task;

import android.os.AsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AbsAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public abstract Result asyncExecute(Params... paramsArr);

    public abstract void doFinally();

    @Override // android.os.AsyncTask
    public Result doInBackground(Params... paramsArr) {
        try {
            Result resultAsyncExecute = asyncExecute(paramsArr);
            doFinally();
            return resultAsyncExecute;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                SDKLogger.e("kernel", th.getMessage(), th);
                doWhenException(th);
                return null;
            } finally {
                doFinally();
            }
        }
    }

    public abstract void doWhenException(Throwable th);
}
