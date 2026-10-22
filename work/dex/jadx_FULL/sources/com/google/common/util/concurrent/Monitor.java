package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class Monitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @GuardedBy("lock")
    public Guard f32378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ReentrantLock f6543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6544a;

    @Beta
    public static abstract class Guard {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("monitor.lock")
        public int f32379a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        @GuardedBy("monitor.lock")
        public Guard f6545a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Weak
        public final Monitor f6546a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Condition f6547a;

        public Guard(Monitor monitor) {
            this.f6546a = (Monitor) com.google.common.base.i.F(monitor, android.taobao.windvane.base.b.b);
            this.f6547a = monitor.f6543a.newCondition();
        }

        public abstract boolean a();
    }

    public Monitor() {
        this(false);
    }

    public static long E(long j, long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 - (System.nanoTime() - j);
    }

    public static long H(long j, TimeUnit timeUnit) {
        return Longs.f(timeUnit.toNanos(j), 0L, 6917529027641081853L);
    }

    public static long y(long j) {
        if (j <= 0) {
            return 0L;
        }
        long jNanoTime = System.nanoTime();
        if (jNanoTime == 0) {
            return 1L;
        }
        return jNanoTime;
    }

    public boolean A() {
        return this.f6543a.isLocked();
    }

    public boolean B() {
        return this.f6543a.isHeldByCurrentThread();
    }

    @GuardedBy("lock")
    public final boolean C(Guard guard) {
        try {
            return guard.a();
        } catch (Throwable th) {
            F();
            throw th;
        }
    }

    public void D() {
        ReentrantLock reentrantLock = this.f6543a;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                G();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @GuardedBy("lock")
    public final void F() {
        for (Guard guard = this.f32378a; guard != null; guard = guard.f6545a) {
            guard.f6547a.signalAll();
        }
    }

    @GuardedBy("lock")
    public final void G() {
        for (Guard guard = this.f32378a; guard != null; guard = guard.f6545a) {
            if (C(guard)) {
                guard.f6547a.signal();
                return;
            }
        }
    }

    public boolean I() {
        return this.f6543a.tryLock();
    }

    public boolean J(Guard guard) {
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f6543a;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            boolean zA = guard.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void K(Guard guard) throws InterruptedException {
        if (!(guard.f6546a == this) || !this.f6543a.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.a()) {
            return;
        }
        b(guard, true);
    }

    public boolean L(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long jH = H(j, timeUnit);
        if (!(guard.f6546a == this) || !this.f6543a.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.a()) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return c(guard, jH, true);
    }

    public void M(Guard guard) {
        if (!(guard.f6546a == this) || !this.f6543a.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.a()) {
            return;
        }
        d(guard, true);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    public boolean N(Guard guard, long j, TimeUnit timeUnit) throws Throwable {
        long jH = H(j, timeUnit);
        boolean z = true;
        if (!(guard.f6546a == this) || !this.f6543a.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.a()) {
            return true;
        }
        long jY = y(jH);
        boolean zInterrupted = Thread.interrupted();
        long jE = jH;
        boolean z2 = true;
        while (true) {
            try {
                try {
                    boolean zC = c(guard, jE, z2);
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return zC;
                } catch (Throwable th) {
                    th = th;
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (InterruptedException unused) {
                if (guard.a()) {
                    Thread.currentThread().interrupt();
                    return true;
                }
                jE = E(jY, jH);
                z2 = false;
                zInterrupted = true;
            } catch (Throwable th2) {
                th = th2;
                z = zInterrupted;
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
    }

    @GuardedBy("lock")
    public final void b(Guard guard, boolean z) throws InterruptedException {
        if (z) {
            G();
        }
        e(guard);
        do {
            try {
                guard.f6547a.await();
            } finally {
                f(guard);
            }
        } while (!guard.a());
    }

    @GuardedBy("lock")
    public final boolean c(Guard guard, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        G();
                    } catch (Throwable th) {
                        if (!z2) {
                            f(guard);
                        }
                        throw th;
                    }
                }
                e(guard);
                z2 = false;
            }
            j = guard.f6547a.awaitNanos(j);
            if (guard.a()) {
                if (!z2) {
                    f(guard);
                }
                return true;
            }
        }
        if (!z2) {
            f(guard);
        }
        return false;
    }

    @GuardedBy("lock")
    public final void d(Guard guard, boolean z) {
        if (z) {
            G();
        }
        e(guard);
        do {
            try {
                guard.f6547a.awaitUninterruptibly();
            } finally {
                f(guard);
            }
        } while (!guard.a());
    }

    @GuardedBy("lock")
    public final void e(Guard guard) {
        int i = guard.f32379a;
        guard.f32379a = i + 1;
        if (i == 0) {
            guard.f6545a = this.f32378a;
            this.f32378a = guard;
        }
    }

    @GuardedBy("lock")
    public final void f(Guard guard) {
        int i = guard.f32379a - 1;
        guard.f32379a = i;
        if (i == 0) {
            Guard guard2 = this.f32378a;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.f6545a;
            }
            if (guard3 == null) {
                this.f32378a = guard2.f6545a;
            } else {
                guard3.f6545a = guard2.f6545a;
            }
            guard2.f6545a = null;
        }
    }

    public void g() {
        this.f6543a.lock();
    }

    public boolean h(long j, TimeUnit timeUnit) throws Throwable {
        boolean zTryLock;
        long jH = H(j, timeUnit);
        ReentrantLock reentrantLock = this.f6543a;
        boolean z = true;
        if (!this.f6544a && reentrantLock.tryLock()) {
            return true;
        }
        boolean zInterrupted = Thread.interrupted();
        try {
            long jNanoTime = System.nanoTime();
            long jE = jH;
            while (true) {
                try {
                    try {
                        zTryLock = reentrantLock.tryLock(jE, TimeUnit.NANOSECONDS);
                        break;
                    } catch (Throwable th) {
                        th = th;
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    jE = E(jNanoTime, jH);
                    zInterrupted = true;
                }
            }
            if (zInterrupted) {
                Thread.currentThread().interrupt();
            }
            return zTryLock;
        } catch (Throwable th2) {
            th = th2;
            z = zInterrupted;
        }
    }

    public boolean i(Guard guard) {
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f6543a;
        reentrantLock.lock();
        try {
            boolean zA = guard.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean j(Guard guard, long j, TimeUnit timeUnit) {
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        if (!h(j, timeUnit)) {
            return false;
        }
        try {
            boolean zA = guard.a();
            if (!zA) {
                this.f6543a.unlock();
            }
            return zA;
        } catch (Throwable th) {
            this.f6543a.unlock();
            throw th;
        }
    }

    public boolean k(Guard guard) throws InterruptedException {
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f6543a;
        reentrantLock.lockInterruptibly();
        try {
            boolean zA = guard.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean l(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f6543a;
        if (!reentrantLock.tryLock(j, timeUnit)) {
            return false;
        }
        try {
            boolean zA = guard.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void m() throws InterruptedException {
        this.f6543a.lockInterruptibly();
    }

    public boolean n(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f6543a.tryLock(j, timeUnit);
    }

    public void o(Guard guard) throws InterruptedException {
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f6543a;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        try {
            if (guard.a()) {
                return;
            }
            b(guard, zIsHeldByCurrentThread);
        } catch (Throwable th) {
            D();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    public boolean p(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long jY;
        boolean z;
        long jH = H(j, timeUnit);
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f6543a;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        if (this.f6544a) {
            jY = y(jH);
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
        } else {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (reentrantLock.tryLock()) {
                jY = 0;
            } else {
                jY = y(jH);
                if (!reentrantLock.tryLock(j, timeUnit)) {
                    return false;
                }
            }
        }
        try {
            if (!guard.a()) {
                if (jY != 0) {
                    jH = E(jY, jH);
                }
                z = c(guard, jH, zIsHeldByCurrentThread);
            }
            if (!z) {
                reentrantLock.unlock();
            }
            return z;
        } catch (Throwable th) {
            if (!zIsHeldByCurrentThread) {
                try {
                    G();
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw th;
        }
    }

    public void q(Guard guard) {
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f6543a;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            if (guard.a()) {
                return;
            }
            d(guard, zIsHeldByCurrentThread);
        } catch (Throwable th) {
            D();
            throw th;
        }
    }

    public boolean r(Guard guard, long j, TimeUnit timeUnit) throws Throwable {
        long jY;
        long jE;
        long jH = H(j, timeUnit);
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f6543a;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        boolean zInterrupted = Thread.interrupted();
        try {
            boolean zC = true;
            if (this.f6544a || !reentrantLock.tryLock()) {
                jY = y(jH);
                long jE2 = jH;
                while (true) {
                    try {
                        try {
                            break;
                        } catch (Throwable th) {
                            th = th;
                            zInterrupted = true;
                            if (zInterrupted) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (InterruptedException unused) {
                        jE2 = E(jY, jH);
                        zInterrupted = true;
                    }
                }
                if (!reentrantLock.tryLock(jE2, TimeUnit.NANOSECONDS)) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
            } else {
                jY = 0;
            }
            while (!guard.a()) {
                try {
                    if (jY == 0) {
                        jY = y(jH);
                        jE = jH;
                    } else {
                        jE = E(jY, jH);
                    }
                    zC = c(guard, jE, zIsHeldByCurrentThread);
                } catch (InterruptedException unused2) {
                    zIsHeldByCurrentThread = false;
                    zInterrupted = zC;
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            }
            if (!zC) {
                reentrantLock.unlock();
            }
            if (zInterrupted) {
                Thread.currentThread().interrupt();
            }
            return zC;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public int s() {
        return this.f6543a.getHoldCount();
    }

    public int t() {
        return this.f6543a.getQueueLength();
    }

    public int u(Guard guard) {
        if (guard.f6546a != this) {
            throw new IllegalMonitorStateException();
        }
        this.f6543a.lock();
        try {
            return guard.f32379a;
        } finally {
            this.f6543a.unlock();
        }
    }

    public boolean v(Thread thread) {
        return this.f6543a.hasQueuedThread(thread);
    }

    public boolean w() {
        return this.f6543a.hasQueuedThreads();
    }

    public boolean x(Guard guard) {
        return u(guard) > 0;
    }

    public boolean z() {
        return this.f6544a;
    }

    public Monitor(boolean z) {
        this.f32378a = null;
        this.f6544a = z;
        this.f6543a = new ReentrantLock(z);
    }
}
