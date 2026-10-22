package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class AbstractIdleService implements Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Supplier<String> f32294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Service f6473a;

    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            j.n((String) AbstractIdleService.this.f32294a.get(), runnable).start();
        }
    }

    public final class b extends AbstractService {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractIdleService.this.startUp();
                    b.this.notifyStarted();
                } catch (Throwable th) {
                    b.this.notifyFailed(th);
                }
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractIdleService$b$b, reason: collision with other inner class name */
        public class RunnableC0757b implements Runnable {
            public RunnableC0757b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractIdleService.this.shutDown();
                    b.this.notifyStopped();
                } catch (Throwable th) {
                    b.this.notifyFailed(th);
                }
            }
        }

        public b() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            j.q(AbstractIdleService.this.executor(), AbstractIdleService.this.f32294a).execute(new a());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            j.q(AbstractIdleService.this.executor(), AbstractIdleService.this.f32294a).execute(new RunnableC0757b());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractIdleService.this.toString();
        }

        public /* synthetic */ b(AbstractIdleService abstractIdleService, a aVar) {
            this();
        }
    }

    public final class c implements Supplier<String> {
        public c() {
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get() {
            String strServiceName = AbstractIdleService.this.serviceName();
            String strValueOf = String.valueOf(AbstractIdleService.this.i());
            StringBuilder sb = new StringBuilder(String.valueOf(strServiceName).length() + 1 + strValueOf.length());
            sb.append(strServiceName);
            sb.append(" ");
            sb.append(strValueOf);
            return sb.toString();
        }

        public /* synthetic */ c(AbstractIdleService abstractIdleService, a aVar) {
            this();
        }
    }

    public AbstractIdleService() {
        a aVar = null;
        this.f32294a = new c(this, aVar);
        this.f6473a = new b(this, aVar);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void a() {
        this.f6473a.a();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void b(Service.Listener listener, Executor executor) {
        this.f6473a.b(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service c() {
        this.f6473a.c();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service d() {
        this.f6473a.d();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable e() {
        return this.f6473a.e();
    }

    public Executor executor() {
        return new a();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void f(long j, TimeUnit timeUnit) throws TimeoutException {
        this.f6473a.f(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void g() {
        this.f6473a.g();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void h(long j, TimeUnit timeUnit) throws TimeoutException {
        this.f6473a.h(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State i() {
        return this.f6473a.i();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f6473a.isRunning();
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public abstract void shutDown() throws Exception;

    public abstract void startUp() throws Exception;

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
}
