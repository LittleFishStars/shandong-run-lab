package com.igexin.base.scheduler.task;

import com.igexin.base.api.GTSchedulerManager;
import com.igexin.base.scheduler.BaseTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class SimpleTask extends BaseTask {
    public SimpleTask() {
        super(0L, TimeUnit.MILLISECONDS);
        setTaskLevel(GTSchedulerManager.TASKLEVEL.LEVEL_DEFAULT);
    }
}
