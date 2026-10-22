package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class AbstractService implements Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ListenerCallQueue.Event<Service.Listener> f32314a = new a();
    public static final ListenerCallQueue.Event<Service.Listener> b = new b();
    public static final ListenerCallQueue.Event<Service.Listener> c;
    public static final ListenerCallQueue.Event<Service.Listener> d;
    public static final ListenerCallQueue.Event<Service.Listener> e;
    public static final ListenerCallQueue.Event<Service.Listener> f;
    public static final ListenerCallQueue.Event<Service.Listener> g;
    public static final ListenerCallQueue.Event<Service.Listener> h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Monitor f6491a = new Monitor();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Monitor.Guard f6490a = new h();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Monitor.Guard f6492b = new i();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Monitor.Guard f6493c = new g();

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Monitor.Guard f6494d = new j();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ListenerCallQueue<Service.Listener> f6489a = new ListenerCallQueue<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile k f6488a = new k(Service.State.NEW);

    public class a implements ListenerCallQueue.Event<Service.Listener> {
        public String toString() {
            return "starting()";
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Service.Listener listener) {
            listener.c();
        }
    }

    public class b implements ListenerCallQueue.Event<Service.Listener> {
        public String toString() {
            return "running()";
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Service.Listener listener) {
            listener.b();
        }
    }

    public class c implements ListenerCallQueue.Event<Service.Listener> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service.State f32315a;

        public c(Service.State state) {
            this.f32315a = state;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f32315a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 21);
            sb.append("terminated({from = ");
            sb.append(strValueOf);
            sb.append("})");
            return sb.toString();
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Service.Listener listener) {
            listener.e(this.f32315a);
        }
    }

    public class d implements ListenerCallQueue.Event<Service.Listener> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service.State f32316a;

        public d(Service.State state) {
            this.f32316a = state;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f32316a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 19);
            sb.append("stopping({from = ");
            sb.append(strValueOf);
            sb.append("})");
            return sb.toString();
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Service.Listener listener) {
            listener.d(this.f32316a);
        }
    }

    public class e implements ListenerCallQueue.Event<Service.Listener> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service.State f32317a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Throwable f6495a;

        public e(AbstractService abstractService, Service.State state, Throwable th) {
            this.f32317a = state;
            this.f6495a = th;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f32317a);
            String strValueOf2 = String.valueOf(this.f6495a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 27 + strValueOf2.length());
            sb.append("failed({from = ");
            sb.append(strValueOf);
            sb.append(", cause = ");
            sb.append(strValueOf2);
            sb.append("})");
            return sb.toString();
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Service.Listener listener) {
            listener.a(this.f32317a, this.f6495a);
        }
    }

    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32318a;

        static {
            int[] iArr = new int[Service.State.values().length];
            f32318a = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32318a[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32318a[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32318a[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32318a[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32318a[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final class g extends Monitor.Guard {
        public g() {
            super(AbstractService.this.f6491a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return AbstractService.this.i().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    public final class h extends Monitor.Guard {
        public h() {
            super(AbstractService.this.f6491a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return AbstractService.this.i() == Service.State.NEW;
        }
    }

    public final class i extends Monitor.Guard {
        public i() {
            super(AbstractService.this.f6491a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return AbstractService.this.i().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    public final class j extends Monitor.Guard {
        public j() {
            super(AbstractService.this.f6491a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return AbstractService.this.i().compareTo(Service.State.TERMINATED) >= 0;
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Service.State f32323a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public final Throwable f6496a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f6497a;

        public k(Service.State state) {
            this(state, false, null);
        }

        public Service.State a() {
            return (this.f6497a && this.f32323a == Service.State.STARTING) ? Service.State.STOPPING : this.f32323a;
        }

        public Throwable b() {
            Service.State state = this.f32323a;
            com.google.common.base.i.x0(state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", state);
            Throwable th = this.f6496a;
            Objects.requireNonNull(th);
            return th;
        }

        public k(Service.State state, boolean z, @CheckForNull Throwable th) {
            com.google.common.base.i.u(!z || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            com.google.common.base.i.y((th != null) == (state == Service.State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.f32323a = state;
            this.f6497a = z;
            this.f6496a = th;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        c = r(state);
        Service.State state2 = Service.State.RUNNING;
        d = r(state2);
        e = s(Service.State.NEW);
        f = s(state);
        g = s(state2);
        h = s(Service.State.STOPPING);
    }

    public static ListenerCallQueue.Event<Service.Listener> r(Service.State state) {
        return new d(state);
    }

    public static ListenerCallQueue.Event<Service.Listener> s(Service.State state) {
        return new c(state);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void a() {
        this.f6491a.q(this.f6493c);
        try {
            k(Service.State.RUNNING);
        } finally {
            this.f6491a.D();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void b(Service.Listener listener, Executor executor) {
        this.f6489a.b(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service c() {
        if (this.f6491a.i(this.f6492b)) {
            try {
                Service.State stateI = i();
                switch (f.f32318a[stateI.ordinal()]) {
                    case 1:
                        this.f6488a = new k(Service.State.TERMINATED);
                        q(Service.State.NEW);
                        break;
                    case 2:
                        Service.State state = Service.State.STARTING;
                        this.f6488a = new k(state, true, null);
                        p(state);
                        doCancelStart();
                        break;
                    case 3:
                        this.f6488a = new k(Service.State.STOPPING);
                        p(Service.State.RUNNING);
                        doStop();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        String strValueOf = String.valueOf(stateI);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 45);
                        sb.append("isStoppable is incorrectly implemented, saw: ");
                        sb.append(strValueOf);
                        throw new AssertionError(sb.toString());
                }
            } catch (Throwable th) {
                try {
                    notifyFailed(th);
                } finally {
                    this.f6491a.D();
                    l();
                }
            }
        }
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service d() {
        if (!this.f6491a.i(this.f6490a)) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 33);
            sb.append("Service ");
            sb.append(strValueOf);
            sb.append(" has already been started");
            throw new IllegalStateException(sb.toString());
        }
        try {
            this.f6488a = new k(Service.State.STARTING);
            o();
            doStart();
        } catch (Throwable th) {
            try {
                notifyFailed(th);
            } finally {
                this.f6491a.D();
                l();
            }
        }
        return this;
    }

    @Beta
    @ForOverride
    public void doCancelStart() {
    }

    @ForOverride
    public abstract void doStart();

    @ForOverride
    public abstract void doStop();

    @Override // com.google.common.util.concurrent.Service
    public final Throwable e() {
        return this.f6488a.b();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void f(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.f6491a.r(this.f6493c, j2, timeUnit)) {
            try {
                k(Service.State.RUNNING);
            } finally {
                this.f6491a.D();
            }
        } else {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 50);
            sb.append("Timed out waiting for ");
            sb.append(strValueOf);
            sb.append(" to reach the RUNNING state.");
            throw new TimeoutException(sb.toString());
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void g() {
        this.f6491a.q(this.f6494d);
        try {
            k(Service.State.TERMINATED);
        } finally {
            this.f6491a.D();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void h(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.f6491a.r(this.f6494d, j2, timeUnit)) {
            try {
                k(Service.State.TERMINATED);
                return;
            } finally {
                this.f6491a.D();
            }
        }
        String strValueOf = String.valueOf(this);
        String strValueOf2 = String.valueOf(i());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 65 + strValueOf2.length());
        sb.append("Timed out waiting for ");
        sb.append(strValueOf);
        sb.append(" to reach a terminal state. Current state: ");
        sb.append(strValueOf2);
        throw new TimeoutException(sb.toString());
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State i() {
        return this.f6488a.a();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return i() == Service.State.RUNNING;
    }

    @GuardedBy(android.taobao.windvane.base.b.b)
    public final void k(Service.State state) {
        Service.State stateI = i();
        if (stateI != state) {
            if (stateI == Service.State.FAILED) {
                String strValueOf = String.valueOf(this);
                String strValueOf2 = String.valueOf(state);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 56 + strValueOf2.length());
                sb.append("Expected the service ");
                sb.append(strValueOf);
                sb.append(" to be ");
                sb.append(strValueOf2);
                sb.append(", but the service has FAILED");
                throw new IllegalStateException(sb.toString(), e());
            }
            String strValueOf3 = String.valueOf(this);
            String strValueOf4 = String.valueOf(state);
            String strValueOf5 = String.valueOf(stateI);
            StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 38 + strValueOf4.length() + strValueOf5.length());
            sb2.append("Expected the service ");
            sb2.append(strValueOf3);
            sb2.append(" to be ");
            sb2.append(strValueOf4);
            sb2.append(", but was ");
            sb2.append(strValueOf5);
            throw new IllegalStateException(sb2.toString());
        }
    }

    public final void l() {
        if (this.f6491a.B()) {
            return;
        }
        this.f6489a.c();
    }

    public final void m(Service.State state, Throwable th) {
        this.f6489a.d(new e(this, state, th));
    }

    public final void n() {
        this.f6489a.d(b);
    }

    public final void notifyFailed(Throwable th) {
        com.google.common.base.i.E(th);
        this.f6491a.g();
        try {
            Service.State stateI = i();
            int i2 = f.f32318a[stateI.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3 || i2 == 4) {
                    this.f6488a = new k(Service.State.FAILED, false, th);
                    m(stateI, th);
                } else if (i2 != 5) {
                }
                this.f6491a.D();
                l();
                return;
            }
            String strValueOf = String.valueOf(stateI);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
            sb.append("Failed while in state:");
            sb.append(strValueOf);
            throw new IllegalStateException(sb.toString(), th);
        } catch (Throwable th2) {
            this.f6491a.D();
            l();
            throw th2;
        }
    }

    public final void notifyStarted() {
        this.f6491a.g();
        try {
            if (this.f6488a.f32323a != Service.State.STARTING) {
                String strValueOf = String.valueOf(this.f6488a.f32323a);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 43);
                sb.append("Cannot notifyStarted() when the service is ");
                sb.append(strValueOf);
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                notifyFailed(illegalStateException);
                throw illegalStateException;
            }
            if (this.f6488a.f6497a) {
                this.f6488a = new k(Service.State.STOPPING);
                doStop();
            } else {
                this.f6488a = new k(Service.State.RUNNING);
                n();
            }
            this.f6491a.D();
            l();
        } catch (Throwable th) {
            this.f6491a.D();
            l();
            throw th;
        }
    }

    public final void notifyStopped() {
        this.f6491a.g();
        try {
            Service.State stateI = i();
            switch (f.f32318a[stateI.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    String strValueOf = String.valueOf(stateI);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 43);
                    sb.append("Cannot notifyStopped() when the service is ");
                    sb.append(strValueOf);
                    throw new IllegalStateException(sb.toString());
                case 2:
                case 3:
                case 4:
                    this.f6488a = new k(Service.State.TERMINATED);
                    q(stateI);
                    break;
            }
            this.f6491a.D();
            l();
        } catch (Throwable th) {
            this.f6491a.D();
            l();
            throw th;
        }
    }

    public final void o() {
        this.f6489a.d(f32314a);
    }

    public final void p(Service.State state) {
        if (state == Service.State.STARTING) {
            this.f6489a.d(c);
        } else {
            if (state != Service.State.RUNNING) {
                throw new AssertionError();
            }
            this.f6489a.d(d);
        }
    }

    public final void q(Service.State state) {
        switch (f.f32318a[state.ordinal()]) {
            case 1:
                this.f6489a.d(e);
                return;
            case 2:
                this.f6489a.d(f);
                return;
            case 3:
                this.f6489a.d(g);
                return;
            case 4:
                this.f6489a.d(h);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        String strValueOf = String.valueOf(i());
        StringBuilder sb = new StringBuilder(simpleName.length() + 3 + strValueOf.length());
        sb.append(simpleName);
        sb.append(" [");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }
}
