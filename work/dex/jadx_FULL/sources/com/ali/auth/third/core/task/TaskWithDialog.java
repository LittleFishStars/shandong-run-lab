package com.ali.auth.third.core.task;

import android.app.Activity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class TaskWithDialog<Params, Progress, Result> extends AbsAsyncTask<Params, Progress, Result> {
    protected Activity activity;

    public TaskWithDialog(Activity activity) {
        this.activity = activity;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doFinally() {
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
