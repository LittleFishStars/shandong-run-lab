package com.byazt.eg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 215})
public final class yp {
    public ExecutorService n;
    public String uj;
    public Runnable ve;
    public int c = 64;
    public int tt = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<zm.c> f28463a = new ArrayDeque();
    public final Deque<zm.c> sp = new ArrayDeque();
    public final Deque<zm> x = new ArrayDeque();

    public yp() {
    }

    private void ve() {
        if (this.sp.size() < this.c && !this.f28463a.isEmpty()) {
            Iterator<zm.c> it = this.f28463a.iterator();
            while (it.hasNext()) {
                zm.c next = it.next();
                if (ve(next) < this.tt) {
                    it.remove();
                    this.sp.add(next);
                    if (next != null) {
                        next.tt();
                    }
                    c().execute(next);
                }
                if (this.sp.size() >= this.c) {
                    return;
                }
            }
        }
    }

    public synchronized ExecutorService c() {
        if (this.n == null) {
            String str = this.uj;
            this.n = new com.byazt.jtc.uj(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.kh.ve.c((str == null || str.isEmpty()) ? "net" : this.uj, false));
        }
        return this.n;
    }

    public synchronized void tt(int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.tt = i;
            ve();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void tt(zm.c cVar) {
        c(this.sp, cVar, true);
    }

    public synchronized void c(int i) {
        try {
            if (i > 0) {
                this.c = i;
                ve();
            } else {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void tt(zm zmVar) {
        c(this.x, zmVar, false);
    }

    public yp(String str) {
        this.uj = str;
    }

    public synchronized int tt() {
        return this.sp.size() + this.x.size();
    }

    public synchronized void c(zm.c cVar) {
        try {
            if (this.sp.size() < this.c && ve(cVar) < this.tt) {
                this.sp.add(cVar);
                if (cVar != null) {
                    cVar.tt();
                }
                c().execute(cVar);
                return;
            }
            this.f28463a.add(cVar);
        } catch (Throwable unused) {
        }
    }

    private int ve(zm.c cVar) {
        Iterator<zm.c> it = this.sp.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().c().equals(cVar.c())) {
                i++;
            }
        }
        return i;
    }

    public synchronized void c(zm zmVar) {
        this.x.add(zmVar);
    }

    private <T> void c(Deque<T> deque, T t, boolean z) {
        int iTt;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    ve();
                }
                iTt = tt();
                runnable = this.ve;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (iTt != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
