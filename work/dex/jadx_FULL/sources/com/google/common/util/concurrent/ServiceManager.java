package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class ServiceManager implements ServiceManagerBridge {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<Service> f6556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e f6557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f6555a = Logger.getLogger(ServiceManager.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ListenerCallQueue.Event<Listener> f32385a = new a();
    public static final ListenerCallQueue.Event<Listener> b = new b();

    public static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }

        public /* synthetic */ EmptyServiceManagerWarning(a aVar) {
            this();
        }
    }

    public static abstract class Listener {
        public void a(Service service) {
        }

        public void b() {
        }

        public void c() {
        }
    }

    public class a implements ListenerCallQueue.Event<Listener> {
        public String toString() {
            return "healthy()";
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Listener listener) {
            listener.b();
        }
    }

    public class b implements ListenerCallQueue.Event<Listener> {
        public String toString() {
            return "stopped()";
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Listener listener) {
            listener.c();
        }
    }

    public static final class c extends AbstractService {
        public c() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStart() {
            notifyStarted();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            notifyStopped();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static final class d extends Service.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Service f32386a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final WeakReference<e> f6558a;

        public d(Service service, WeakReference<e> weakReference) {
            this.f32386a = service;
            this.f6558a = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void a(Service.State state, Throwable th) {
            e eVar = this.f6558a.get();
            if (eVar != null) {
                if (!(this.f32386a instanceof c)) {
                    Logger logger = ServiceManager.f6555a;
                    Level level = Level.SEVERE;
                    String strValueOf = String.valueOf(this.f32386a);
                    String strValueOf2 = String.valueOf(state);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 34 + strValueOf2.length());
                    sb.append("Service ");
                    sb.append(strValueOf);
                    sb.append(" has failed in the ");
                    sb.append(strValueOf2);
                    sb.append(" state.");
                    logger.log(level, sb.toString(), th);
                }
                eVar.n(this.f32386a, state, Service.State.FAILED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void b() {
            e eVar = this.f6558a.get();
            if (eVar != null) {
                eVar.n(this.f32386a, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void c() {
            e eVar = this.f6558a.get();
            if (eVar != null) {
                eVar.n(this.f32386a, Service.State.NEW, Service.State.STARTING);
                if (this.f32386a instanceof c) {
                    return;
                }
                ServiceManager.f6555a.log(Level.FINE, "Starting {0}.", this.f32386a);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void d(Service.State state) {
            e eVar = this.f6558a.get();
            if (eVar != null) {
                eVar.n(this.f32386a, state, Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void e(Service.State state) {
            e eVar = this.f6558a.get();
            if (eVar != null) {
                if (!(this.f32386a instanceof c)) {
                    ServiceManager.f6555a.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.f32386a, state});
                }
                eVar.n(this.f32386a, state, Service.State.TERMINATED);
            }
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32387a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy(android.taobao.windvane.base.b.b)
        public final Multiset<Service.State> f6559a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy(android.taobao.windvane.base.b.b)
        public final SetMultimap<Service.State, Service> f6560a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ListenerCallQueue<Listener> f6561a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Monitor.Guard f6562a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Monitor f6563a = new Monitor();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy(android.taobao.windvane.base.b.b)
        public final Map<Service, com.google.common.base.k> f6564a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy(android.taobao.windvane.base.b.b)
        public boolean f6565a;
        public final Monitor.Guard b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @GuardedBy(android.taobao.windvane.base.b.b)
        public boolean f6566b;

        public class a implements Function<Map.Entry<Service, Long>, Long> {
            public a(e eVar) {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long apply(Map.Entry<Service, Long> entry) {
                return entry.getValue();
            }
        }

        public class b implements ListenerCallQueue.Event<Listener> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Service f32388a;

            public b(e eVar, Service service) {
                this.f32388a = service;
            }

            public String toString() {
                String strValueOf = String.valueOf(this.f32388a);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                sb.append("failed({service=");
                sb.append(strValueOf);
                sb.append("})");
                return sb.toString();
            }

            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Listener listener) {
                listener.a(this.f32388a);
            }
        }

        public final class c extends Monitor.Guard {
            public c() {
                super(e.this.f6563a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean a() {
                int iCount = e.this.f6559a.count(Service.State.RUNNING);
                e eVar = e.this;
                return iCount == eVar.f32387a || eVar.f6559a.contains(Service.State.STOPPING) || e.this.f6559a.contains(Service.State.TERMINATED) || e.this.f6559a.contains(Service.State.FAILED);
            }
        }

        public final class d extends Monitor.Guard {
            public d() {
                super(e.this.f6563a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean a() {
                return e.this.f6559a.count(Service.State.TERMINATED) + e.this.f6559a.count(Service.State.FAILED) == e.this.f32387a;
            }
        }

        public e(ImmutableCollection<Service> immutableCollection) {
            SetMultimap<Service.State, Service> setMultimapA = MultimapBuilder.c(Service.State.class).g().a();
            this.f6560a = setMultimapA;
            this.f6559a = setMultimapA.keys();
            this.f6564a = Maps.b0();
            this.f6562a = new c();
            this.b = new d();
            this.f6561a = new ListenerCallQueue<>();
            this.f32387a = immutableCollection.size();
            setMultimapA.putAll(Service.State.NEW, immutableCollection);
        }

        public void a(Listener listener, Executor executor) {
            this.f6561a.b(listener, executor);
        }

        public void b() {
            this.f6563a.q(this.f6562a);
            try {
                f();
            } finally {
                this.f6563a.D();
            }
        }

        public void c(long j, TimeUnit timeUnit) throws TimeoutException {
            this.f6563a.g();
            try {
                if (this.f6563a.N(this.f6562a, j, timeUnit)) {
                    f();
                    this.f6563a.D();
                } else {
                    String strValueOf = String.valueOf(Multimaps.n(this.f6560a, Predicates.n(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 93);
                    sb.append("Timeout waiting for the services to become healthy. The following services have not started: ");
                    sb.append(strValueOf);
                    throw new TimeoutException(sb.toString());
                }
            } catch (Throwable th) {
                this.f6563a.D();
                throw th;
            }
        }

        public void d() {
            this.f6563a.q(this.b);
            this.f6563a.D();
        }

        public void e(long j, TimeUnit timeUnit) throws TimeoutException {
            this.f6563a.g();
            try {
                if (this.f6563a.N(this.b, j, timeUnit)) {
                    this.f6563a.D();
                    return;
                }
                String strValueOf = String.valueOf(Multimaps.n(this.f6560a, Predicates.q(Predicates.n(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                StringBuilder sb = new StringBuilder(strValueOf.length() + 83);
                sb.append("Timeout waiting for the services to stop. The following services have not stopped: ");
                sb.append(strValueOf);
                throw new TimeoutException(sb.toString());
            } catch (Throwable th) {
                this.f6563a.D();
                throw th;
            }
        }

        @GuardedBy(android.taobao.windvane.base.b.b)
        public void f() {
            Multiset<Service.State> multiset = this.f6559a;
            Service.State state = Service.State.RUNNING;
            if (multiset.count(state) == this.f32387a) {
                return;
            }
            String strValueOf = String.valueOf(Multimaps.n(this.f6560a, Predicates.q(Predicates.m(state))));
            StringBuilder sb = new StringBuilder(strValueOf.length() + 79);
            sb.append("Expected to be healthy after starting. The following services are not running: ");
            sb.append(strValueOf);
            throw new IllegalStateException(sb.toString());
        }

        public void g() {
            com.google.common.base.i.h0(!this.f6563a.B(), "It is incorrect to execute listeners with the monitor held.");
            this.f6561a.c();
        }

        public void h(Service service) {
            this.f6561a.d(new b(this, service));
        }

        public void i() {
            this.f6561a.d(ServiceManager.f32385a);
        }

        public void j() {
            this.f6561a.d(ServiceManager.b);
        }

        public void k() {
            this.f6563a.g();
            try {
                if (!this.f6566b) {
                    this.f6565a = true;
                    this.f6563a.D();
                    return;
                }
                ArrayList arrayListQ = Lists.q();
                UnmodifiableIterator<Service> it = l().values().iterator();
                while (it.hasNext()) {
                    Service next = it.next();
                    if (next.i() != Service.State.NEW) {
                        arrayListQ.add(next);
                    }
                }
                String strValueOf = String.valueOf(arrayListQ);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 89);
                sb.append("Services started transitioning asynchronously before the ServiceManager was constructed: ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            } catch (Throwable th) {
                this.f6563a.D();
                throw th;
            }
        }

        public ImmutableSetMultimap<Service.State, Service> l() {
            ImmutableSetMultimap.a aVarBuilder = ImmutableSetMultimap.builder();
            this.f6563a.g();
            try {
                for (Map.Entry<Service.State, Service> entry : this.f6560a.entries()) {
                    if (!(entry.getValue() instanceof c)) {
                        aVarBuilder.g(entry);
                    }
                }
                this.f6563a.D();
                return aVarBuilder.a();
            } catch (Throwable th) {
                this.f6563a.D();
                throw th;
            }
        }

        public ImmutableMap<Service, Long> m() {
            this.f6563a.g();
            try {
                ArrayList arrayListU = Lists.u(this.f6564a.size());
                for (Map.Entry<Service, com.google.common.base.k> entry : this.f6564a.entrySet()) {
                    Service key = entry.getKey();
                    com.google.common.base.k value = entry.getValue();
                    if (!value.i() && !(key instanceof c)) {
                        arrayListU.add(Maps.O(key, Long.valueOf(value.g(TimeUnit.MILLISECONDS))));
                    }
                }
                this.f6563a.D();
                Collections.sort(arrayListU, Ordering.natural().onResultOf(new a(this)));
                return ImmutableMap.copyOf(arrayListU);
            } catch (Throwable th) {
                this.f6563a.D();
                throw th;
            }
        }

        public void n(Service service, Service.State state, Service.State state2) {
            com.google.common.base.i.E(service);
            com.google.common.base.i.d(state != state2);
            this.f6563a.g();
            try {
                this.f6566b = true;
                if (this.f6565a) {
                    com.google.common.base.i.B0(this.f6560a.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                    com.google.common.base.i.B0(this.f6560a.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                    com.google.common.base.k kVarC = this.f6564a.get(service);
                    if (kVarC == null) {
                        kVarC = com.google.common.base.k.c();
                        this.f6564a.put(service, kVarC);
                    }
                    Service.State state3 = Service.State.RUNNING;
                    if (state2.compareTo(state3) >= 0 && kVarC.i()) {
                        kVarC.l();
                        if (!(service instanceof c)) {
                            ServiceManager.f6555a.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, kVarC});
                        }
                    }
                    Service.State state4 = Service.State.FAILED;
                    if (state2 == state4) {
                        h(service);
                    }
                    if (this.f6559a.count(state3) == this.f32387a) {
                        i();
                    } else if (this.f6559a.count(Service.State.TERMINATED) + this.f6559a.count(state4) == this.f32387a) {
                        j();
                    }
                }
            } finally {
                this.f6563a.D();
                g();
            }
        }

        public void o(Service service) {
            this.f6563a.g();
            try {
                if (this.f6564a.get(service) == null) {
                    this.f6564a.put(service, com.google.common.base.k.c());
                }
            } finally {
                this.f6563a.D();
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList<Service> immutableListCopyOf = ImmutableList.copyOf(iterable);
        if (immutableListCopyOf.isEmpty()) {
            a aVar = null;
            f6555a.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new EmptyServiceManagerWarning(aVar));
            immutableListCopyOf = ImmutableList.of(new c(aVar));
        }
        e eVar = new e(immutableListCopyOf);
        this.f6557a = eVar;
        this.f6556a = immutableListCopyOf;
        WeakReference weakReference = new WeakReference(eVar);
        UnmodifiableIterator<Service> it = immutableListCopyOf.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            next.b(new d(next, weakReference), j.c());
            com.google.common.base.i.u(next.i() == Service.State.NEW, "Can only manage NEW services, %s", next);
        }
        this.f6557a.k();
    }

    public void e(Listener listener, Executor executor) {
        this.f6557a.a(listener, executor);
    }

    public void f() {
        this.f6557a.b();
    }

    public void g(long j, TimeUnit timeUnit) throws TimeoutException {
        this.f6557a.c(j, timeUnit);
    }

    public void h() {
        this.f6557a.d();
    }

    public void i(long j, TimeUnit timeUnit) throws TimeoutException {
        this.f6557a.e(j, timeUnit);
    }

    public boolean j() {
        UnmodifiableIterator<Service> it = this.f6556a.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.util.concurrent.ServiceManagerBridge
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ImmutableSetMultimap<Service.State, Service> a() {
        return this.f6557a.l();
    }

    @CanIgnoreReturnValue
    public ServiceManager l() {
        UnmodifiableIterator<Service> it = this.f6556a.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            Service.State stateI = next.i();
            com.google.common.base.i.B0(stateI == Service.State.NEW, "Service %s is %s, cannot start it.", next, stateI);
        }
        UnmodifiableIterator<Service> it2 = this.f6556a.iterator();
        while (it2.hasNext()) {
            Service next2 = it2.next();
            try {
                this.f6557a.o(next2);
                next2.d();
            } catch (IllegalStateException e2) {
                Logger logger = f6555a;
                Level level = Level.WARNING;
                String strValueOf = String.valueOf(next2);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                sb.append("Unable to start Service ");
                sb.append(strValueOf);
                logger.log(level, sb.toString(), (Throwable) e2);
            }
        }
        return this;
    }

    public ImmutableMap<Service, Long> m() {
        return this.f6557a.m();
    }

    @CanIgnoreReturnValue
    public ServiceManager n() {
        UnmodifiableIterator<Service> it = this.f6556a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        return this;
    }

    public String toString() {
        return com.google.common.base.e.b(ServiceManager.class).f("services", com.google.common.collect.b.d(this.f6556a, Predicates.q(Predicates.o(c.class)))).toString();
    }
}
