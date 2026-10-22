package com.igexin.base.scheduler;

import com.igexin.base.scheduler.BaseTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface c<T extends BaseTask> {
    void execute(T t);

    void submit(T t);
}
