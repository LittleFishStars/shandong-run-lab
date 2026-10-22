package com.zj.adlib;

import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bh7 {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) throws Throwable {
        TResult tresultApply;
        if (i < 1) {
            return function.apply(tinput);
        }
        do {
            tresultApply = function.apply(tinput);
            tinput = retryStrategy.a(tinput, tresultApply);
            if (tinput == null) {
                break;
            }
            i--;
        } while (i >= 1);
        return tresultApply;
    }
}
