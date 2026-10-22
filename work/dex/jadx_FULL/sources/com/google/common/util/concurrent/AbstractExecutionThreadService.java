package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class AbstractExecutionThreadService implements Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f32281a = Logger.getLogger(AbstractExecutionThreadService.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Service f6458a = new a();

    public class a extends AbstractService {

        /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$a$a, reason: collision with other inner class name */
        public class C0756a implements Supplier<String> {
            public C0756a() {
            }

            @Override // com.google.common.base.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get() {
                return AbstractExecutionThreadService.this.serviceName();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractExecutionThreadService.this.startUp();
                    a.this.notifyStarted();
                    if (a.this.isRunning()) {
                        try {
                            AbstractExecutionThreadService.this.run();
                        } catch (Throwable th) {
                            try {
                                AbstractExecutionThreadService.this.shutDown();
                            } catch (Exception e) {
                                AbstractExecutionThreadService.f32281a.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                            }
                            a.this.notifyFailed(th);
                            return;
                        }
                    }
                    AbstractExecutionThreadService.this.shutDown();
                    a.this.notifyStopped();
                } catch (Throwable th2) {
                    a.this.notifyFailed(th2);
                }
            }
        }

        public a() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            j.q(AbstractExecutionThreadService.this.executor(), new C0756a()).execute(new b());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    }

    public class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            j.n(AbstractExecutionThreadService.this.serviceName(), runnable).start();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void a() {
        this.f6458a.a();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void b(Service.Listener listener, Executor executor) {
        this.f6458a.b(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service c() {
        this.f6458a.c();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service d() {
        this.f6458a.d();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable e() {
        return this.f6458a.e();
    }

    public Executor executor() {
        return new b();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void f(long j, TimeUnit timeUnit) throws TimeoutException {
        this.f6458a.f(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void g() {
        this.f6458a.g();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void h(long j, TimeUnit timeUnit) throws TimeoutException {
        this.f6458a.h(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State i() {
        return this.f6458a.i();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f6458a.isRunning();
    }

    public abstract void run() throws Exception;

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() throws Exception {
    }

    public void startUp() throws Exception {
    }

    public String toString() {
        String strServiceName = serviceName();
        String strValueOf = String.valueOf(i());
        StringBuilder sb = new StringBuilder(String.valueOf(strServiceName).length() + 3 + strValueOf.length());
        sb.append(strServiceName);
        sb.append(" [");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Beta
    public void triggerShutdown() {
    }
}
