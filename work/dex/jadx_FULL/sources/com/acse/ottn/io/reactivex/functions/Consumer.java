package com.acse.ottn.io.reactivex.functions;

import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Consumer<T> extends Action1<T> {
    void accept(T t) throws Exception;

    default void call(T t) {
        try {
            accept(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
