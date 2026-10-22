package com.igexin.c.a.d;

import android.os.PowerManager;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class f extends b implements com.igexin.c.a.d.a.a, com.igexin.c.a.d.a.f {
    protected static g H;
    public int A;
    public int B;
    public int C;
    public int D;
    public Exception E;
    public Object F;
    public com.igexin.c.a.d.a.g G;
    protected final ReentrantLock I;
    protected final Condition J;
    protected Thread K;
    protected volatile boolean L;
    PowerManager.WakeLock M;
    int N;
    protected com.igexin.c.a.d.a.d O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f37843a;
    protected volatile boolean m;
    protected volatile boolean n;
    protected volatile boolean o;
    protected volatile boolean p;
    protected volatile boolean q;
    protected volatile boolean r;
    protected volatile boolean s;
    protected volatile boolean t;
    protected volatile boolean u;
    protected volatile boolean v;
    protected volatile long w;
    volatile int x;
    public long z;

    public f(int i) {
        this(i, (byte) 0);
    }

    private f(int i, byte b) {
        this.C = i;
        this.O = null;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.I = reentrantLock;
        this.J = reentrantLock.newCondition();
    }

    private int A() {
        return this.f37843a & com.google.common.base.a.q;
    }

    private boolean B() {
        byte b = this.f37843a;
        return (b >> 4) > (b & com.google.common.base.a.q);
    }

    private Thread C() {
        return this.K;
    }

    private static void D() throws Exception {
    }

    private void E() {
        this.n = true;
    }

    private Object F() {
        return this.F;
    }

    private com.igexin.c.a.d.a.d G() {
        return this.O;
    }

    private void a(int i, TimeUnit timeUnit) {
        this.v = false;
        this.E = null;
        this.w = 0L;
        byte b = this.f37843a;
        this.f37843a = (byte) (b + ((b & com.google.common.base.a.q) < 15 ? (byte) 1 : (byte) 0));
        this.m = false;
        this.q = false;
        this.t = false;
        a(i, timeUnit);
    }

    private void a(long j) {
        this.z = j;
    }

    private void a(PowerManager.WakeLock wakeLock) {
        this.M = wakeLock;
    }

    private boolean a(Object obj) {
        if (!this.m) {
            return false;
        }
        this.q = false;
        this.n = false;
        this.m = false;
        this.F = obj;
        return true;
    }

    private void b(int i) {
        if (i != this.D) {
            this.D = i;
            H.s.b(this);
        }
    }

    private void b(Object obj) {
        this.F = obj;
    }

    private ReentrantLock g() {
        ReentrantLock reentrantLock = this.I;
        reentrantLock.getClass();
        return reentrantLock;
    }

    private PowerManager.WakeLock h() {
        return this.M;
    }

    private void i() {
        this.z = System.currentTimeMillis();
    }

    private boolean q() {
        return this.v;
    }

    private int r() {
        this.N = a(TimeUnit.MILLISECONDS) > 0 ? this.N | 134217728 : this.N & 1090519038;
        return this.N;
    }

    private void s() {
        this.N = (this.N + 1) & 1090519038;
    }

    private long t() {
        return this.w - System.currentTimeMillis();
    }

    private boolean u() {
        return this.q;
    }

    private boolean v() {
        return this.u;
    }

    private boolean w() {
        return this.m;
    }

    private boolean x() {
        return this.s;
    }

    private boolean y() {
        return this.t;
    }

    private void z() {
        this.v = false;
        this.E = null;
        this.w = 0L;
        byte b = this.f37843a;
        this.f37843a = (byte) (b + ((b & com.google.common.base.a.q) < 15 ? (byte) 1 : (byte) 0));
        this.m = false;
        this.q = false;
        this.t = false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0026  */
    public final int a(long j, TimeUnit timeUnit) {
        int i;
        if (j > 0) {
            int iA = H.s.a(this, j, timeUnit);
            i = -2;
            if (iA != -2) {
                i = -1;
                if (iA != -1) {
                    i = 1;
                    if (iA != 1) {
                        i = 0;
                    }
                } else {
                    this.w = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
                }
            }
        } else {
            i = 0;
        }
        hashCode();
        TimeUnit.SECONDS.convert(j, timeUnit);
        return i;
    }

    public final long a(TimeUnit timeUnit) {
        return timeUnit.convert(t(), TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.c.a.d.a.a
    public void a() {
        this.F = null;
        this.E = null;
        this.K = null;
    }

    public final void a(int i) {
        this.f37843a = (byte) (((i & 15) << 4) | ((byte) (this.f37843a & com.google.common.base.a.q)));
    }

    public final void a(int i, com.igexin.c.a.d.a.g gVar) {
        if (i < 0) {
            throw new IllegalArgumentException("second must > 0");
        }
        this.B = i;
        this.G = gVar;
    }

    public final void a(com.igexin.c.a.d.a.d dVar) {
        this.O = dVar;
    }

    public final void a(f fVar) {
        this.C = fVar.C;
        this.f37843a = (byte) (fVar.f37843a & 240);
        this.A = fVar.A;
        this.D = fVar.D;
        this.O = fVar.O;
        this.B = fVar.B;
        this.G = fVar.G;
    }

    public void b_() throws Exception {
        this.K = Thread.currentThread();
        this.q = true;
        hashCode();
        this.K.getName();
    }

    public void d() {
        this.t = true;
    }

    @Override // com.igexin.c.a.d.a.f
    public void d_() {
        if (this.m || this.n) {
            a();
        }
    }

    public abstract void e();

    public abstract void f();

    public final void l() {
        this.m = true;
    }

    public final boolean m() {
        return this.o;
    }

    public final boolean n() {
        return this.n;
    }

    public final void o() {
        if (!this.p && !this.r && !this.s) {
            this.m = true;
            this.q = false;
        } else if (this.r && !this.m) {
            this.q = false;
        } else {
            if (!this.p || this.o || this.m) {
                return;
            }
            this.q = false;
        }
    }

    public final void p() {
        if (this.O != null) {
            int i = com.igexin.c.a.d.a.d.a.f37838a;
        }
    }
}
