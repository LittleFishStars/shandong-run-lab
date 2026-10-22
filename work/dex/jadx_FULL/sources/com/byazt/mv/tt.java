package com.byazt.mv;

import android.os.Handler;
import android.os.Looper;
import com.byazt.lph.ve;
import com.byazt.nr.m;
import com.byazt.vb.i;
import com.byazt.vb.n;
import com.byazt.vb.uj;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 659, 13})
public class tt implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Handler f28801a;
    public volatile ve n;
    public n sp;
    public volatile int tt = 0;
    public final Comparator<com.byazt.vb.tt> x = new Comparator<com.byazt.vb.tt>() { // from class: com.byazt.mv.tt.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(com.byazt.vb.tt ttVar, com.byazt.vb.tt ttVar2) {
            return tt.this.c(ttVar, ttVar2);
        }
    };
    public static final com.byazt.sl.c c = new com.byazt.sl.c();
    public static final long ve = System.currentTimeMillis();
    public static long uj = 0;

    public tt(n nVar) {
        this.sp = nVar;
    }

    public boolean tt() {
        return this.tt == 1;
    }

    public ve uj() {
        return this.n;
    }

    public boolean ve() {
        return this.tt == 2;
    }

    public void c(int i) {
        this.tt = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.byazt.vb.tt ttVar, com.byazt.vb.tt ttVar2) {
        long jC;
        long jTt;
        long jTt2;
        long jC2;
        if (ttVar == null) {
            return ttVar2 == null ? 0 : -1;
        }
        if (ttVar2 == null) {
            return 1;
        }
        if (ttVar.n() == ttVar2.n()) {
            if (ttVar.c() != null) {
                jC = ttVar.c().c();
                jTt = ttVar.c().tt();
            } else {
                jC = 0;
                jTt = 0;
            }
            if (ttVar2.c() != null) {
                jC2 = ttVar2.c().c();
                jTt2 = ttVar2.c().tt();
            } else {
                jTt2 = 0;
                jC2 = 0;
            }
            if (jC == 0 || jC2 == 0) {
                return 0;
            }
            long j = jC - jC2;
            if (Math.abs(j) > 2147483647L) {
                return 0;
            }
            if (j != 0) {
                return (int) j;
            }
            if (jTt == 0 || jTt2 == 0) {
                return 0;
            }
            return (int) (jTt - jTt2);
        }
        return ttVar.n() - ttVar2.n();
    }

    @Override // com.byazt.vb.i
    public void c(boolean z) {
        n nVar = this.sp;
        if (nVar == null) {
            return;
        }
        c(nVar.n());
        if (z) {
            c();
        }
    }

    public void c(Handler handler) {
        this.f28801a = handler;
    }

    public boolean c(String str) {
        try {
            if (this.n != null || com.byazt.epi.c.c(str) || this.sp == null) {
                return false;
            }
            synchronized (this) {
                if (this.n != null) {
                    return false;
                }
                this.n = new ve(this.sp, this);
                this.n.a();
                return true;
            }
        } catch (Throwable th) {
            com.byazt.ml.ve.ve(th.getMessage(), this.sp);
            return false;
        }
    }

    @Override // com.byazt.vb.i
    public void c(com.byazt.vb.tt ttVar) {
        n nVar;
        if (ttVar != null && (nVar = this.sp) != null) {
            String strN = nVar.n();
            ttVar.c(System.currentTimeMillis());
            c(strN);
            uj ujVarUj = this.sp.uj();
            ve veVar = this.n;
            if (veVar != null) {
                c(ujVarUj, ttVar);
                veVar.c(ttVar, ttVar.n() == 4);
                return;
            }
            return;
        }
        com.byazt.ml.ve.uj("error : log config is null", this.sp);
    }

    private void c(final uj ujVar, com.byazt.vb.tt ttVar) {
        if (ujVar != null) {
            try {
                if (ujVar.ve()) {
                    final long jTt = (ttVar == null || ttVar.c() == null) ? 0L : ttVar.c().tt();
                    if (jTt == 1) {
                        uj = System.currentTimeMillis();
                    }
                    com.byazt.sl.c cVar = c;
                    AtomicLong atomicLongNu = cVar.nu();
                    com.byazt.ml.tt.c(atomicLongNu, 1, this.sp);
                    if (com.byazt.ml.c.c(ttVar)) {
                        cVar.rh().incrementAndGet();
                    } else if (com.byazt.ml.c.tt(ttVar)) {
                        cVar.gt().incrementAndGet();
                    }
                    if (atomicLongNu.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor executorX = ujVar.x();
                            if (executorX == null) {
                                executorX = ujVar.i();
                            }
                            if (executorX != null) {
                                executorX.execute(new com.byazt.ke.tt("report") { // from class: com.byazt.mv.tt.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        tt.this.c(ujVar, jTt);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        c(ujVar, jTt);
                    }
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(uj ujVar, long j) {
        ve veVar = this.n;
        if (ujVar == null || veVar == null) {
            return;
        }
        com.byazt.sl.c cVar = c;
        veVar.c(ujVar.c(cVar.c(j, this.sp)), true);
        cVar.a();
    }

    @Override // com.byazt.vb.i
    public void c() {
        n nVar = this.sp;
        if (nVar != null && nVar.uj() != null) {
            com.byazt.ml.ve.tt("flushMemoryAndDB", nVar);
            uj ujVarUj = nVar.uj();
            final ve veVar = this.n;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (veVar != null) {
                    veVar.c(72, "start_child2");
                    return;
                }
                return;
            }
            Executor executorX = ujVarUj.x();
            if (executorX == null) {
                executorX = ujVarUj.i();
            }
            if (executorX == null) {
                com.byazt.ml.ve.tt("discard flush executor is null", nVar);
                return;
            } else {
                executorX.execute(new com.byazt.ke.tt("flush") { // from class: com.byazt.mv.tt.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ve veVar2 = veVar;
                        if (veVar2 != null) {
                            veVar2.c(72, "start_child1");
                        }
                    }
                });
                return;
            }
        }
        com.byazt.ml.ve.tt("discard flush config is null", nVar);
    }
}
