package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.zj.adlib.f33;
import com.zj.adlib.lh9;
import com.zj.adlib.mz9;
import com.zj.adlib.t13;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Singleton
public class h implements TransportInternal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile TransportRuntimeComponent f30438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Scheduler f1945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f1946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lh9 f1947a;
    public final Clock b;

    @Inject
    public h(@WallTime Clock clock, @Monotonic Clock clock2, Scheduler scheduler, lh9 lh9Var, mz9 mz9Var) {
        this.f1946a = clock;
        this.b = clock2;
        this.f1945a = scheduler;
        this.f1947a = lh9Var;
        mz9Var.a();
    }

    public static h c() {
        TransportRuntimeComponent transportRuntimeComponent = f30438a;
        if (transportRuntimeComponent != null) {
            return transportRuntimeComponent.h();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set<f33> d(Destination destination) {
        return destination instanceof EncodedDestination ? Collections.unmodifiableSet(((EncodedDestination) destination).a()) : Collections.singleton(f33.b("proto"));
    }

    public static void f(Context context) {
        if (f30438a == null) {
            synchronized (h.class) {
                if (f30438a == null) {
                    f30438a = d.j().b(context).a();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public static void i(TransportRuntimeComponent transportRuntimeComponent, Callable<Void> callable) throws Throwable {
        TransportRuntimeComponent transportRuntimeComponent2;
        synchronized (h.class) {
            transportRuntimeComponent2 = f30438a;
            f30438a = transportRuntimeComponent;
        }
        try {
            callable.call();
            synchronized (h.class) {
                f30438a = transportRuntimeComponent2;
            }
        } catch (Throwable th) {
            synchronized (h.class) {
                f30438a = transportRuntimeComponent2;
                throw th;
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.TransportInternal
    public void a(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.f1945a.a(sendRequest.f().e(sendRequest.c().c()), b(sendRequest), transportScheduleCallback);
    }

    public final EventInternal b(SendRequest sendRequest) {
        return EventInternal.a().g(this.f1946a.getTime()).i(this.b.getTime()).h(sendRequest.g()).f(new t13(sendRequest.b(), sendRequest.d())).e(sendRequest.c().a()).d();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public lh9 e() {
        return this.f1947a;
    }

    public TransportFactory g(Destination destination) {
        return new f(d(destination), TransportContext.a().b(destination.getName()).c(destination.b()).a(), this);
    }

    @Deprecated
    public TransportFactory h(String str) {
        return new f(d(null), TransportContext.a().b(str).a(), this);
    }
}
