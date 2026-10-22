package com.acse.ottn.io.reactivex.functions;

import rx.functions.Action0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Action extends Action0 {
    default void call() {
        run();
    }

    void run();
}
