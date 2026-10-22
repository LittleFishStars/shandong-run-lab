package com.zj.adlib;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class mz9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkScheduler f43416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventStore f18328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SynchronizationGuard f18329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f18330a;

    @Inject
    public mz9(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f18330a = executor;
        this.f18328a = eventStore;
        this.f43416a = workScheduler;
        this.f18329a = synchronizationGuard;
    }

    public static /* synthetic */ Object b(mz9 mz9Var) {
        Iterator<TransportContext> it = mz9Var.f18328a.l0().iterator();
        while (it.hasNext()) {
            mz9Var.f43416a.b(it.next(), 1);
        }
        return null;
    }

    public void a() {
        this.f18330a.execute(kz9.a(this));
    }
}
