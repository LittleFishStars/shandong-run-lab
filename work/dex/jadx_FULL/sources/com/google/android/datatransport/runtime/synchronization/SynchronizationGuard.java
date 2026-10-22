package com.google.android.datatransport.runtime.synchronization;

import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@WorkerThread
public interface SynchronizationGuard {

    public interface CriticalSection<T> {
        T a();
    }

    <T> T a(CriticalSection<T> criticalSection);
}
