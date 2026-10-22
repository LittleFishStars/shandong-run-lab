package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class AbstractScheduledService implements Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f32300a = Logger.getLogger(AbstractScheduledService.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AbstractService f6474a = new d(this, null);

    public interface Cancellable {
        void a(boolean z);

        boolean isCancelled();
    }

    public static abstract class CustomScheduler extends Scheduler {

        public final class a implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @CheckForNull
            @GuardedBy("lock")
            public c f32301a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final AbstractService f6476a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Runnable f6477a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final ScheduledExecutorService f6478a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final ReentrantLock f6479a = new ReentrantLock();

            public a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.f6477a = runnable;
                this.f6478a = scheduledExecutorService;
                this.f6476a = abstractService;
            }

            @GuardedBy("lock")
            public final Cancellable a(b bVar) {
                c cVar = this.f32301a;
                if (cVar == null) {
                    c cVar2 = new c(this.f6479a, c(bVar));
                    this.f32301a = cVar2;
                    return cVar2;
                }
                if (!cVar.f32303a.isCancelled()) {
                    this.f32301a.f32303a = c(bVar);
                }
                return this.f32301a;
            }

            @CanIgnoreReturnValue
            public Cancellable b() {
                Cancellable cVar;
                try {
                    b nextSchedule = CustomScheduler.this.getNextSchedule();
                    this.f6479a.lock();
                    try {
                        cVar = a(nextSchedule);
                        this.f6479a.unlock();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            cVar = new c(f.k());
                            this.f6479a.unlock();
                        } catch (Throwable th2) {
                            this.f6479a.unlock();
                            throw th2;
                        }
                    }
                    if (th != null) {
                        this.f6476a.notifyFailed(th);
                    }
                    return cVar;
                } catch (Throwable th3) {
                    this.f6476a.notifyFailed(th3);
                    return new c(f.k());
                }
            }

            public final ScheduledFuture<Void> c(b bVar) {
                return this.f6478a.schedule(this, bVar.f32302a, bVar.f6480a);
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public Void call() throws Exception {
                this.f6477a.run();
                b();
                return null;
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f32302a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final TimeUnit f6480a;

            public b(long j, TimeUnit timeUnit) {
                this.f32302a = j;
                this.f6480a = (TimeUnit) com.google.common.base.i.E(timeUnit);
            }
        }

        public static final class c implements Cancellable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @GuardedBy("lock")
            public Future<Void> f32303a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final ReentrantLock f6481a;

            public c(ReentrantLock reentrantLock, Future<Void> future) {
                this.f6481a = reentrantLock;
                this.f32303a = future;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public void a(boolean z) {
                this.f6481a.lock();
                try {
                    this.f32303a.cancel(z);
                } finally {
                    this.f6481a.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public boolean isCancelled() {
                this.f6481a.lock();
                try {
                    return this.f32303a.isCancelled();
                } finally {
                    this.f6481a.unlock();
                }
            }
        }

        public CustomScheduler() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        public final Cancellable c(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            return new a(abstractService, scheduledExecutorService, runnable).b();
        }

        public abstract b getNextSchedule() throws Exception;
    }

    public static abstract class Scheduler {

        public class a extends Scheduler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f32304a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ TimeUnit f6482a;
            public final /* synthetic */ long b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, long j2, TimeUnit timeUnit) {
                super(null);
                this.f32304a = j;
                this.b = j2;
                this.f6482a = timeUnit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public Cancellable c(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return new c(scheduledExecutorService.scheduleWithFixedDelay(runnable, this.f32304a, this.b, this.f6482a));
            }
        }

        public class b extends Scheduler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f32305a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ TimeUnit f6483a;
            public final /* synthetic */ long b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j, long j2, TimeUnit timeUnit) {
                super(null);
                this.f32305a = j;
                this.b = j2;
                this.f6483a = timeUnit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public Cancellable c(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return new c(scheduledExecutorService.scheduleAtFixedRate(runnable, this.f32305a, this.b, this.f6483a));
            }
        }

        public /* synthetic */ Scheduler(a aVar) {
            this();
        }

        public static Scheduler a(long j, long j2, TimeUnit timeUnit) {
            com.google.common.base.i.E(timeUnit);
            com.google.common.base.i.p(j2 > 0, "delay must be > 0, found %s", j2);
            return new a(j, j2, timeUnit);
        }

        public static Scheduler b(long j, long j2, TimeUnit timeUnit) {
            com.google.common.base.i.E(timeUnit);
            com.google.common.base.i.p(j2 > 0, "period must be > 0, found %s", j2);
            return new b(j, j2, timeUnit);
        }

        public abstract Cancellable c(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public Scheduler() {
        }
    }

    public class a extends Service.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScheduledExecutorService f32306a;

        public a(AbstractScheduledService abstractScheduledService, ScheduledExecutorService scheduledExecutorService) {
            this.f32306a = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void a(Service.State state, Throwable th) {
            this.f32306a.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void e(Service.State state) {
            this.f32306a.shutdown();
        }
    }

    public class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return j.n(AbstractScheduledService.this.serviceName(), runnable);
        }
    }

    public static final class c implements Cancellable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<?> f32308a;

        public c(Future<?> future) {
            this.f32308a = future;
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public void a(boolean z) {
            this.f32308a.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public boolean isCancelled() {
            return this.f32308a.isCancelled();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void a() {
        this.f6474a.a();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void b(Service.Listener listener, Executor executor) {
        this.f6474a.b(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service c() {
        this.f6474a.c();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service d() {
        this.f6474a.d();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable e() {
        return this.f6474a.e();
    }

    public ScheduledExecutorService executor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new b());
        b(new a(this, scheduledExecutorServiceNewSingleThreadScheduledExecutor), j.c());
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void f(long j, TimeUnit timeUnit) throws TimeoutException {
        this.f6474a.f(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void g() {
        this.f6474a.g();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void h(long j, TimeUnit timeUnit) throws TimeoutException {
        this.f6474a.h(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State i() {
        return this.f6474a.i();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f6474a.isRunning();
    }

    public abstract void runOneIteration() throws Exception;

    public abstract Scheduler scheduler();

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

    public final class d extends AbstractService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public volatile Cancellable f32309a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Runnable f6485a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public volatile ScheduledExecutorService f6486a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ReentrantLock f6487a;

        public class a implements Supplier<String> {
            public a() {
            }

            @Override // com.google.common.base.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get() {
                String strServiceName = AbstractScheduledService.this.serviceName();
                String strValueOf = String.valueOf(d.this.i());
                StringBuilder sb = new StringBuilder(String.valueOf(strServiceName).length() + 1 + strValueOf.length());
                sb.append(strServiceName);
                sb.append(" ");
                sb.append(strValueOf);
                return sb.toString();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f6487a.lock();
                try {
                    AbstractScheduledService.this.startUp();
                    d dVar = d.this;
                    dVar.f32309a = AbstractScheduledService.this.scheduler().c(AbstractScheduledService.this.f6474a, d.this.f6486a, d.this.f6485a);
                    d.this.notifyStarted();
                } catch (Throwable th) {
                    try {
                        d.this.notifyFailed(th);
                        if (d.this.f32309a != null) {
                            d.this.f32309a.a(false);
                        }
                    } finally {
                        d.this.f6487a.unlock();
                    }
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.f6487a.lock();
                    try {
                        if (d.this.i() != Service.State.STOPPING) {
                            d.this.f6487a.unlock();
                            return;
                        }
                        AbstractScheduledService.this.shutDown();
                        d.this.f6487a.unlock();
                        d.this.notifyStopped();
                    } catch (Throwable th) {
                        d.this.f6487a.unlock();
                        throw th;
                    }
                } catch (Throwable th2) {
                    d.this.notifyFailed(th2);
                }
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$d$d, reason: collision with other inner class name */
        public class RunnableC0758d implements Runnable {
            public RunnableC0758d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f6487a.lock();
                try {
                    Cancellable cancellable = d.this.f32309a;
                    Objects.requireNonNull(cancellable);
                    if (cancellable.isCancelled()) {
                        d.this.f6487a.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                } catch (Throwable th) {
                    try {
                        try {
                            AbstractScheduledService.this.shutDown();
                        } catch (Exception e) {
                            AbstractScheduledService.f32300a.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                        }
                        d.this.notifyFailed(th);
                        Cancellable cancellable2 = d.this.f32309a;
                        Objects.requireNonNull(cancellable2);
                        cancellable2.a(false);
                    } finally {
                        d.this.f6487a.unlock();
                    }
                }
            }
        }

        public d() {
            this.f6487a = new ReentrantLock();
            this.f6485a = new RunnableC0758d();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            this.f6486a = j.s(AbstractScheduledService.this.executor(), new a());
            this.f6486a.execute(new b());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            Objects.requireNonNull(this.f32309a);
            Objects.requireNonNull(this.f6486a);
            this.f32309a.a(false);
            this.f6486a.execute(new c());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }

        public /* synthetic */ d(AbstractScheduledService abstractScheduledService, a aVar) {
            this();
        }
    }
}
