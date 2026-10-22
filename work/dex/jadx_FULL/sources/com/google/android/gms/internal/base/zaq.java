package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface zaq {
    ExecutorService a(ThreadFactory threadFactory, int i);

    ExecutorService b(int i, int i2);

    ExecutorService c(int i, ThreadFactory threadFactory, int i2);
}
