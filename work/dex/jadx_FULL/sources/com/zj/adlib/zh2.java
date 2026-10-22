package com.zj.adlib;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.h;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class zh2 implements Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f46261a = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BackendRegistry f21051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WorkScheduler f21052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventStore f21053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SynchronizationGuard f21054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f21055a;

    @Inject
    public zh2(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f21055a = executor;
        this.f21051a = backendRegistry;
        this.f21052a = workScheduler;
        this.f21053a = eventStore;
        this.f21054a = synchronizationGuard;
    }

    public static /* synthetic */ Object b(zh2 zh2Var, TransportContext transportContext, EventInternal eventInternal) {
        zh2Var.f21053a.I(transportContext, eventInternal);
        zh2Var.f21052a.b(transportContext, 1);
        return null;
    }

    public static /* synthetic */ void c(zh2 zh2Var, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackendA = zh2Var.f21051a.a(transportContext.b());
            if (transportBackendA != null) {
                zh2Var.f21054a.a(xh2.b(zh2Var, transportContext, transportBackendA.b(eventInternal)));
                transportScheduleCallback.a(null);
            } else {
                String str = String.format("Transport backend '%s' is not registered", transportContext.b());
                f46261a.warning(str);
                transportScheduleCallback.a(new IllegalArgumentException(str));
            }
        } catch (Exception e) {
            f46261a.warning("Error scheduling event " + e.getMessage());
            transportScheduleCallback.a(e);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public void a(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.f21055a.execute(wh2.a(this, transportContext, transportScheduleCallback, eventInternal));
    }
}
