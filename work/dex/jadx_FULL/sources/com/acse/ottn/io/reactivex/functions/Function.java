package com.acse.ottn.io.reactivex.functions;

import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Function<T, R> extends Func1<T, R> {
    R apply(T t);

    default R call(T t) {
        return apply(t);
    }
}
