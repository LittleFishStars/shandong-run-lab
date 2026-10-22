package com.byazt.tdq;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.aas.m;
import com.byazt.aas.nb;
import com.byazt.bzd.sl;
import com.byazt.ete.bm;
import com.byazt.ete.ic;
import com.byazt.ete.os;
import com.byazt.ete.xd;
import com.byazt.ete.y;
import com.byazt.ete.zb;
import com.byazt.im.a;
import com.byazt.im.i;
import com.byazt.im.sp;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.omf.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 708, 20})
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f29055a;
    public long c = 0;
    public long tt = 0;
    public AtomicBoolean ve = new AtomicBoolean(false);
    public AtomicBoolean uj = new AtomicBoolean(false);
    public AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.tdq.c$c, reason: collision with other inner class name */
    public interface InterfaceC0532c {
        void c();

        void c(a aVar);
    }

    public static c c() {
        return (com.byazt.by.n.c().sl() & 16) == 16 ? new ve() : new uj();
    }

    public abstract void c(os osVar, com.byazt.dj.tt ttVar, boolean z);

    public abstract void c(com.byazt.gat.uj<i, sp> ujVar, ic icVar, com.byazt.dj.tt ttVar, boolean z);

    public abstract void c(sp spVar, String str, InterfaceC0532c interfaceC0532c, n nVar);

    public abstract void c(String str, ic icVar);

    public abstract void c(String str, String str2, boolean z, boolean z2, Object obj);

    public abstract void tt();

    public void tt(com.byazt.dj.tt ttVar, bm bmVar) {
        if (gt.tt().tt(nb.tt(ttVar)) && ttVar != null && TextUtils.isEmpty(ttVar.rl())) {
            com.byazt.dz.c.c("lqmt", "preLoadSplashAd... ");
            bm bmVar2 = bmVar == null ? new bm() : bmVar.c();
            bmVar2.x = System.currentTimeMillis();
            bmVar2.sp = 2;
            bmVar2.yp = x.m().kp();
            bmVar2.tt = 2;
            c(ttVar, bmVar2);
        }
    }

    public abstract void ve();

    public void c(a aVar, com.byazt.dj.tt ttVar, boolean z, int i) {
        if (c(i) && com.byazt.eti.n.c(aVar.tt()) && !this.ve.get()) {
            this.ve.set(true);
            com.byazt.dz.c.c("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
            c(new os(aVar.uj(), aVar.tt(), null), ttVar, false);
            if (z) {
                c(aVar.uj(), aVar.tt(), ttVar);
            }
            com.byazt.dz.c.c("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
        }
    }

    public static boolean c(int i) {
        int iSl = com.byazt.by.n.c().sl();
        if (i == 2) {
            return (iSl & 2) == 2;
        }
        return (i == 3 || i == 1) && (iSl & 32) == 32;
    }

    public void c(final com.byazt.dj.tt ttVar, bm bmVar) {
        if (this.ve.get()) {
            com.byazt.dz.c.c("lqmt", "已经存储了一个实时广告");
            return;
        }
        if (this.uj.getAndSet(true)) {
            com.byazt.dz.c.c("lqmt", "已在预加载开屏广告....不再发出");
            return;
        }
        if (gt.tt().da(ttVar.uj()) && bmVar != null) {
            bmVar.sp = 2;
        }
        gt.c().c(ttVar, bmVar, 4, new gu.tt() { // from class: com.byazt.tdq.c.1
            @Override // com.byazt.omf.gu.tt
            public void c(int i, String str, com.byazt.ete.tt ttVar2) {
                c.this.uj.set(false);
                ttVar2.c(i);
                com.byazt.ete.tt.c(ttVar2);
            }

            @Override // com.byazt.omf.gu.tt
            public void c(com.byazt.ete.c cVar, com.byazt.ete.tt ttVar2) {
                if (com.byazt.cc.x.tt(cVar)) {
                    ic icVar = cVar.tt().get(0);
                    if (icVar.qt()) {
                        AtomicBoolean atomicBoolean = c.this.ve;
                        if ((atomicBoolean == null || !atomicBoolean.get()) && com.byazt.eti.n.c(icVar)) {
                            c.this.c(new os(cVar, icVar, null), ttVar, false);
                            c.this.c(cVar, icVar, ttVar);
                            return;
                        }
                        return;
                    }
                    ttVar2.c(-4);
                    com.byazt.ete.tt.c(ttVar2);
                    return;
                }
                c.this.uj.set(false);
            }
        });
    }

    public void c(final com.byazt.ete.c cVar, final ic icVar, com.byazt.dj.tt ttVar) {
        if (icVar.pa() == null || icVar.pa().size() <= 0) {
            return;
        }
        zb zbVar = icVar.pa().get(0);
        String strC = zbVar.c();
        int iTt = zbVar.tt();
        int iVe = zbVar.ve();
        this.c = System.currentTimeMillis();
        this.tt = SystemClock.elapsedRealtime();
        y yVarVe = com.byazt.hy.n.c().ve().ve();
        if (yVarVe != null) {
            yVarVe.c(false);
        }
        final boolean z = xd.z(icVar) != null;
        m.c(new com.byazt.sml.tt(strC, zbVar.sp()), iTt, iVe, new m.c() { // from class: com.byazt.tdq.c.2
            @Override // com.byazt.aas.m.c
            public void c(com.byazt.uph.tt ttVar2, com.byazt.yj.m mVar) {
                com.byazt.cc.x.c(cVar);
                if (!z) {
                    com.byazt.ddx.uj.c(icVar, "splash_ad", System.currentTimeMillis() - c.this.c);
                }
                c cVar2 = c.this;
                cVar2.c = 0L;
                if (z) {
                    com.byazt.cc.x.c(cVar2.tt, false, true, icVar, 0L, "preLoadImageSuccess");
                }
                c.this.uj.set(false);
            }

            @Override // com.byazt.aas.m.c
            public void c() {
                com.byazt.cc.x.c(cVar);
                if (z) {
                    com.byazt.cc.x.c(c.this.tt, false, false, icVar, -7L, "preLoadImageFailed");
                }
                c.this.uj.set(false);
            }
        }, sl.n(), 4, null, false);
    }
}
