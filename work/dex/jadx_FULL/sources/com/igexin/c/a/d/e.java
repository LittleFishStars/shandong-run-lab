package com.igexin.c.a.d;

import com.igexin.c.a.d.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e<E extends f> {
    static final /* synthetic */ boolean h = true;
    private static final String i = "ScheduleQueue";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final transient ReentrantLock f37842a;
    final transient Condition b;
    final TreeSet<E> c;
    final AtomicInteger d;
    int e;
    g f;
    public final AtomicLong g;
    private long j;

    public e(Comparator<? super E> comparator, g gVar) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f37842a = reentrantLock;
        this.b = reentrantLock.newCondition();
        this.d = new AtomicInteger(0);
        this.g = new AtomicLong(-1L);
        this.c = new TreeSet<>(comparator);
        this.f = gVar;
    }

    private E b() {
        try {
            return this.c.first();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    private E c() {
        E e = (E) b();
        if (e == null) {
            return null;
        }
        if (this.c.remove(e)) {
            return e;
        }
        com.igexin.c.a.c.a.a(i, "Queue Poll Error@");
        return null;
    }

    private E d() {
        ReentrantLock reentrantLock = this.f37842a;
        reentrantLock.lock();
        try {
            f fVarB = b();
            if (fVarB != null) {
                if (fVarB.a(TimeUnit.MILLISECONDS) > 0) {
                    fVarB.N |= 134217728;
                } else {
                    fVarB.N &= 1090519038;
                }
                if (fVarB.N >= 0) {
                    E e = (E) c();
                    if (!h && e == null) {
                        throw new AssertionError();
                    }
                    if (!e()) {
                        this.b.signalAll();
                    }
                    reentrantLock.unlock();
                    return e;
                }
            }
            reentrantLock.unlock();
            return null;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private boolean e() {
        ReentrantLock reentrantLock = this.f37842a;
        reentrantLock.lock();
        try {
            return this.c.isEmpty();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void f() {
        this.c.clear();
    }

    public final int a(E e, long j, TimeUnit timeUnit) {
        ReentrantLock reentrantLock = this.f37842a;
        reentrantLock.lock();
        try {
            if (!this.c.contains(e)) {
                return -1;
            }
            this.c.remove(e);
            e.w = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
            e.hashCode();
            e.a(TimeUnit.SECONDS);
            return a(e) ? 1 : -2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final E a() throws InterruptedException {
        ReentrantLock reentrantLock = this.f37842a;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                f fVarB = b();
                boolean z = true;
                if (fVarB != null) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long jA = fVarB.a(timeUnit);
                    if (!fVarB.m && !fVarB.n) {
                        z = false;
                    }
                    if (jA <= 0 || z) {
                        break;
                        break;
                    }
                    fVarB.hashCode();
                    TimeUnit.SECONDS.convert(jA, timeUnit);
                    this.g.set(fVarB.w);
                    com.igexin.c.a.c.a.a("schedule take|needAlarm = " + this.f.D + "|" + fVarB.getClass().getName() + "@" + fVarB.hashCode(), new Object[0]);
                    if (this.f.D) {
                        this.f.a(fVarB.w);
                    }
                    this.b.awaitNanos(jA);
                } else {
                    this.d.set(1);
                    this.e = 0;
                    this.b.await();
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E e = (E) c();
        if (!h && e == null) {
            throw new AssertionError();
        }
        if (!e()) {
            this.b.signalAll();
        }
        if (this.j > 0) {
            System.currentTimeMillis();
        }
        this.g.set(-1L);
        reentrantLock.unlock();
        return e;
    }

    public final boolean a(E e) {
        if (e == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f37842a;
        reentrantLock.lock();
        try {
            f fVarB = b();
            int i2 = this.e + 1;
            this.e = i2;
            e.x = i2;
            if (!this.c.add(e)) {
                e.x--;
                return false;
            }
            e.N = (e.N + 1) & 1090519038;
            if (fVarB == null || this.c.comparator().compare(e, fVarB) < 0) {
                this.b.signalAll();
            }
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("ScheduleQueue|offer|error", new Object[0]);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean a(Class cls) {
        if (cls == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f37842a;
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            for (E e : this.c) {
                if (e.getClass() == cls) {
                    arrayList.add(e);
                }
            }
            arrayList.size();
            this.c.removeAll(arrayList);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean b(E e) {
        ReentrantLock reentrantLock = this.f37842a;
        reentrantLock.lock();
        try {
            if (this.c.contains(e) && this.c.remove(e)) {
                return a(e);
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean c(E e) {
        if (e == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f37842a;
        reentrantLock.lock();
        try {
            if (!this.c.contains(e) || !this.c.remove(e)) {
                return false;
            }
            e.hashCode();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }
}
