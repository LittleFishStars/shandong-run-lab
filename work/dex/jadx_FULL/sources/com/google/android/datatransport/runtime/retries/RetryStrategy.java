package com.google.android.datatransport.runtime.retries;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface RetryStrategy<TInput, TResult> {
    @Nullable
    TInput a(TInput tinput, TResult tresult);
}
