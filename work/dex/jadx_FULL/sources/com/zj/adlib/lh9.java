package com.zj.adlib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class lh9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43068a = "Uploader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f17945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BackendRegistry f17946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WorkScheduler f17947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventStore f17948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SynchronizationGuard f17949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f17950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f17951a;

    @Inject
    public lh9(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, @WallTime Clock clock) {
        this.f17945a = context;
        this.f17946a = backendRegistry;
        this.f17948a = eventStore;
        this.f17947a = workScheduler;
        this.f17951a = executor;
        this.f17949a = synchronizationGuard;
        this.f17950a = clock;
    }

    public static /* synthetic */ Object c(lh9 lh9Var, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        if (backendResponse.c() == BackendResponse.Status.TRANSIENT_ERROR) {
            lh9Var.f17948a.F0(iterable);
            lh9Var.f17947a.b(transportContext, i + 1);
            return null;
        }
        lh9Var.f17948a.e0(iterable);
        if (backendResponse.c() == BackendResponse.Status.OK) {
            lh9Var.f17948a.h0(transportContext, lh9Var.f17950a.getTime() + backendResponse.b());
        }
        if (!lh9Var.f17948a.n0(transportContext)) {
            return null;
        }
        lh9Var.f17947a.a(transportContext, 1, true);
        return null;
    }

    public static /* synthetic */ Object d(lh9 lh9Var, TransportContext transportContext, int i) {
        lh9Var.f17947a.b(transportContext, i + 1);
        return null;
    }

    public static /* synthetic */ void e(lh9 lh9Var, TransportContext transportContext, int i, Runnable runnable) {
        try {
            try {
                SynchronizationGuard synchronizationGuard = lh9Var.f17949a;
                EventStore eventStore = lh9Var.f17948a;
                eventStore.getClass();
                synchronizationGuard.a(jh9.b(eventStore));
                if (lh9Var.a()) {
                    lh9Var.f(transportContext, i);
                } else {
                    lh9Var.f17949a.a(kh9.b(lh9Var, transportContext, i));
                }
            } catch (SynchronizationException unused) {
                lh9Var.f17947a.b(transportContext, i + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f17945a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void f(TransportContext transportContext, int i) {
        BackendResponse backendResponseA;
        TransportBackend transportBackendA = this.f17946a.a(transportContext.b());
        Iterable iterable = (Iterable) this.f17949a.a(hh9.b(this, transportContext));
        if (iterable.iterator().hasNext()) {
            if (transportBackendA == null) {
                h25.b(f43068a, "Unknown backend for %s, deleting event batch for it...", transportContext);
                backendResponseA = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PersistedEvent) it.next()).b());
                }
                backendResponseA = transportBackendA.a(BackendRequest.a().b(arrayList).c(transportContext.c()).a());
            }
            this.f17949a.a(ih9.b(this, backendResponseA, iterable, transportContext, i));
        }
    }

    public void g(TransportContext transportContext, int i, Runnable runnable) {
        this.f17951a.execute(gh9.a(this, transportContext, i, runnable));
    }
}
