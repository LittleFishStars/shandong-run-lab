package com.acse.ottn.io.reactivex.schedulers;

import java.util.concurrent.Executor;
import rx.Scheduler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Schedulers {
    public static Scheduler computation() {
        return rx.schedulers.Schedulers.computation();
    }

    public static Scheduler from(Executor executor) {
        return rx.schedulers.Schedulers.from(executor);
    }

    public static Scheduler immediate() {
        return rx.schedulers.Schedulers.immediate();
    }

    public static Scheduler io() {
        return rx.schedulers.Schedulers.io();
    }

    public static Scheduler newThread() {
        return rx.schedulers.Schedulers.newThread();
    }

    public static Scheduler trampoline() {
        return rx.schedulers.Schedulers.trampoline();
    }
}
