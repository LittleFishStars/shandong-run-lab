package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CancellationToken {
    public abstract boolean a();

    @NonNull
    public abstract CancellationToken b(@NonNull OnTokenCanceledListener onTokenCanceledListener);
}
