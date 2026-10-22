package com.alibaba.ariver.resource.prepare.controller;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TimerExecutor {
    void postDelayed(Runnable runnable, long j);

    void removeCallbacks(Runnable runnable);
}
