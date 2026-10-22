package com.acse.ottn.io.reactivex.functions;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import rx.functions.Func2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface BiFunction<T1, T2, R> extends Func2<T1, T2, R> {
    @NonNull
    R apply(@NonNull T1 t1, @NonNull T2 t2) throws Exception;

    default R call(T1 t1, T2 t2) {
        try {
            return apply(t1, t2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
