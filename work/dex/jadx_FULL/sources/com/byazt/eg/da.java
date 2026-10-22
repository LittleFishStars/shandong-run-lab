package com.byazt.eg;

import android.os.Bundle;
import android.text.TextUtils;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 72})
public final class da {
    public static final Executor uj = new com.byazt.jtc.uj(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.kh.ve.c("OkHttp ConnectionPool", true));
    public static final /* synthetic */ boolean ve = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28445a;
    public final com.byazt.iq.uj c;
    public final Deque<com.byazt.iq.ve> da;
    public final Runnable i;
    public int n;
    public List<String> sp;
    public boolean tt;
    public long x;

    public da() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private boolean ve(com.byazt.iq.ve veVar) {
        try {
            List<String> list = this.sp;
            if (list != null && !list.isEmpty() && veVar.c() != null && veVar.c().c() != null && veVar.c().c().c() != null && veVar.c().c().c().sp() != null) {
                String strSp = veVar.c().c().c().sp();
                if (!TextUtils.isEmpty(strSp) && this.sp.contains(strSp)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i = bundle.getInt("max_idle_cnt");
                    if (i <= 5) {
                        i = this.n;
                    }
                    this.n = i;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j = bundle.getLong("max_idle_time");
                    this.f28445a = j > 5 ? TimeUnit.MINUTES.toNanos(j) : this.f28445a;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.sp = bundle.getStringArrayList("white_hosts");
                    long j2 = bundle.getLong("white_extra_idle_time");
                    this.x = j2 > 0 ? TimeUnit.MINUTES.toNanos(j2) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean tt(com.byazt.iq.ve veVar) {
        if (!ve && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (veVar.c || this.n == 0) {
            this.da.remove(veVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public da(int i, long j, TimeUnit timeUnit) {
        this.i = new Runnable() { // from class: com.byazt.eg.da.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jC = da.this.c(System.nanoTime());
                    if (jC == -1) {
                        return;
                    }
                    if (jC > 0) {
                        long j2 = jC / 1000000;
                        long j3 = jC - (1000000 * j2);
                        synchronized (da.this) {
                            try {
                                da.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.da = new ArrayDeque();
        this.c = new com.byazt.iq.uj();
        this.n = i;
        this.f28445a = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j)));
        }
    }

    public com.byazt.iq.ve c(c cVar, com.byazt.iq.sp spVar, eo eoVar) {
        if (!ve && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.byazt.iq.ve veVar : this.da) {
            if (veVar.c(cVar, eoVar)) {
                if (spVar != null) {
                    spVar.c(veVar, true);
                }
                return veVar;
            }
        }
        return null;
    }

    public Socket c(c cVar, com.byazt.iq.sp spVar) {
        if (!ve && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.byazt.iq.ve veVar : this.da) {
            if (veVar.c(cVar, null) && veVar.n() && veVar != spVar.tt()) {
                return spVar.c(veVar);
            }
        }
        return null;
    }

    public void c(com.byazt.iq.ve veVar) {
        if (!ve && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.tt) {
            this.tt = true;
            uj.execute(this.i);
        }
        this.da.add(veVar);
    }

    public long c(long j) {
        try {
            synchronized (this) {
                com.byazt.iq.ve veVar = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (com.byazt.iq.ve veVar2 : this.da) {
                    if (c(veVar2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - veVar2.n;
                        com.byazt.iq.ve veVar3 = veVar;
                        if (this.x > 0 && ve(veVar2)) {
                            j3 -= this.x;
                        }
                        if (j3 > j2) {
                            veVar = veVar2;
                            j2 = j3;
                        } else {
                            veVar = veVar3;
                        }
                    }
                }
                com.byazt.iq.ve veVar4 = veVar;
                long j4 = this.f28445a;
                if (j2 < j4 && i <= this.n) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.tt = false;
                    com.byazt.nr.m.c("ConnectionPool", "cleanup: ");
                    return -1L;
                }
                this.da.remove(veVar4);
                com.byazt.kh.ve.c(veVar4.ve());
                return 0L;
            }
        } catch (OutOfMemoryError unused) {
            return this.f28445a;
        }
    }

    private int c(com.byazt.iq.ve veVar, long j) {
        List<Reference<com.byazt.iq.sp>> list = veVar.uj;
        int i = 0;
        while (i < list.size()) {
            Reference<com.byazt.iq.sp> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.byazt.xb.n.tt().c("A connection to " + veVar.c().c().c() + " was leaked. Did you forget to close a response body?", ((com.byazt.iq.sp.c) reference).c);
                list.remove(i);
                veVar.c = true;
                if (list.isEmpty()) {
                    veVar.n = j - this.f28445a;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
