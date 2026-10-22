package com.acse.ottn.io.reactivex.functions;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import rx.functions.Func3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Function3<T1, T2, T3, R> extends Func3<T1, T2, T3, R> {
    @NonNull
    R apply(@NonNull T1 t1, @NonNull T2 t2, @NonNull T3 t3) throws Exception;

    default R call(T1 t1, T2 t2, T3 t3) {
        try {
            return apply(t1, t2, t3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
