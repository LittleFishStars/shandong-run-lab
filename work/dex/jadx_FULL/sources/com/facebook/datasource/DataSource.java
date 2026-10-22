package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface DataSource<T> {
    boolean a();

    boolean b();

    @Nullable
    Throwable c();

    boolean d();

    void e(DataSubscriber<T> dataSubscriber, Executor executor);

    float getProgress();

    @Nullable
    T getResult();

    boolean isClosed();

    boolean isFinished();
}
