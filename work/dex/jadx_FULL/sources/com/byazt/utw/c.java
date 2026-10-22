package com.byazt.utw;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 450, 20})
public abstract class c implements sp {
    public static final AtomicLong t = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile List<a.tt> f29111a;
    public volatile com.byazt.byh.c c;
    public volatile x i;
    public com.byazt.hsq.c n;
    public volatile String sp;
    public final com.byazt.emg.ve tt;
    public volatile String x;
    public final AtomicInteger ve = new AtomicInteger();
    public final AtomicLong uj = new AtomicLong();
    public volatile boolean da = false;
    public final long sl = t.incrementAndGet();
    public final AtomicInteger u = new AtomicInteger(0);
    public int yp = -1;

    public c(com.byazt.byh.c cVar, com.byazt.emg.ve veVar) {
        this.c = cVar;
        this.tt = veVar;
    }

    public boolean a() {
        return n() == 1;
    }

    public int n() {
        return this.c instanceof com.byazt.byh.tt ? 1 : 0;
    }

    public boolean tt() {
        return this.u.get() == 1;
    }

    public void uj() throws com.byazt.ju.c {
        if (tt()) {
            throw new com.byazt.ju.c();
        }
    }

    public void ve() {
        this.u.compareAndSet(0, 2);
    }

    public void c() {
        this.u.compareAndSet(0, 1);
    }

    public com.byazt.ydv.c c(x.c cVar, int i, int i2, String str) throws IOException {
        com.byazt.ydv.tt ttVarTt = com.byazt.ydv.ve.c().tt();
        com.byazt.ydv.n nVar = new com.byazt.ydv.n();
        HashMap map = new HashMap();
        nVar.tt = cVar.c;
        nVar.c = 0;
        if (com.ipd.dsp.internal.g0.c.f38307a.equalsIgnoreCase(str)) {
            nVar.c = 4;
        }
        List<a.tt> list = this.f29111a;
        if (list != null && !list.isEmpty()) {
            for (a.tt ttVar : list) {
                if (!"Range".equalsIgnoreCase(ttVar.c) && !"Connection".equalsIgnoreCase(ttVar.c) && !"Proxy-Connection".equalsIgnoreCase(ttVar.c) && !"Host".equalsIgnoreCase(ttVar.c)) {
                    map.put(ttVar.c, ttVar.tt);
                }
            }
        }
        String strC = com.byazt.nxx.c.c(i, i2);
        if (strC != null) {
            map.put("Range", strC);
        }
        if (uj.x) {
            map.put("Cache-Control", "no-cache");
        }
        nVar.n = map;
        if (this.da) {
            this.da = false;
            return null;
        }
        return ttVarTt.c(nVar);
    }

    public void c(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = uj.i;
        int iN = n();
        if (i3 == 1 || (i3 == 2 && iN == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.yp) {
                    return;
                }
                this.yp = i4;
                com.byazt.nxx.c.tt(new Runnable() { // from class: com.byazt.utw.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        if (cVar.n != null) {
                            x xVar = cVar.i;
                            int unused = c.this.yp;
                        }
                    }
                });
            }
        }
    }
}
