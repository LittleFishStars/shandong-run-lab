package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Consumer<T> {
    void a();

    void b(float f);

    void c(T t, boolean z);

    void onFailure(Throwable th);
}
