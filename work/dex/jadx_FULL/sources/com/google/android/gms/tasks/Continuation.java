package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult a(@NonNull Task<TResult> task) throws Exception;
}
