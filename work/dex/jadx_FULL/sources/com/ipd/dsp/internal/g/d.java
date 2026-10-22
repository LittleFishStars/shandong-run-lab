package com.ipd.dsp.internal.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface d<T> {

    public interface a<T> {
        void a(@Nullable T t);

        void onLoadFailed(@NonNull Exception exc);
    }

    @NonNull
    Class<T> a();

    void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull a<? super T> aVar);

    void b();

    @NonNull
    com.ipd.dsp.internal.f.a c();

    void cancel();
}
