package com.byazt.umr;

import com.byazt.eg.d;
import com.byazt.eg.gr;
import com.byazt.eg.gt;
import com.byazt.eg.h;
import com.byazt.eg.yv;
import com.byazt.mk.my;
import com.byazt.mk.rh;
import com.byazt.mk.t;
import com.byazt.yx.x;
import com.google.common.net.b;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1046, 20})
public final class c implements gt {
    public final a c;

    public c(a aVar) {
        this.c = aVar;
    }

    @Override // com.byazt.eg.gt
    public h c(gt.c cVar) throws IOException {
        a aVar = this.c;
        h hVarC = aVar != null ? aVar.c(cVar.c()) : null;
        ve veVarC = new ve.c(System.currentTimeMillis(), cVar.c(), hVarC).c();
        yv yvVar = veVarC.c;
        h hVar = veVarC.tt;
        if (hVarC != null && hVar == null) {
            com.byazt.kh.ve.c(hVarC.x());
        }
        if (yvVar == null && hVar == null) {
            return new h.c().c(cVar.c()).c(gr.HTTP_1_1).c(504).c("Unsatisfiable Request (only-if-cached)").c(com.byazt.kh.ve.ve).c(-1L).tt(System.currentTimeMillis()).c();
        }
        if (yvVar == null) {
            return hVar.i().tt(c(hVar)).c();
        }
        try {
            h hVarC2 = cVar.c(yvVar);
            if (hVarC2 == null && hVarC != null) {
                com.byazt.kh.ve.c(hVarC.x());
            }
            if (hVar != null) {
                if (hVarC2.ve() == 304) {
                    h hVarC3 = hVar.i().c(c(hVar.sp(), hVarC2.sp())).c(hVarC2.u()).tt(hVarC2.yp()).tt(c(hVar)).c(c(hVarC2)).c();
                    hVarC2.x().close();
                    this.c.update(hVar, hVarC3);
                    return hVarC3;
                }
                com.byazt.kh.ve.c(hVar.x());
            }
            h hVarC4 = hVarC2.i().tt(c(hVar)).c(c(hVarC2)).c();
            if (this.c != null) {
                if (com.byazt.yx.n.ve(hVarC4) && ve.c(hVarC4, yvVar)) {
                    return c(this.c.c(hVarC4), hVarC4);
                }
                com.byazt.yx.a.c(yvVar.tt());
            }
            return hVarC4;
        } catch (Throwable th) {
            if (hVarC != null) {
                com.byazt.kh.ve.c(hVarC.x());
            }
            throw th;
        }
    }

    private static h c(h hVar) {
        return (hVar == null || hVar.x() == null) ? hVar : hVar.i().c((d) null).c();
    }

    private h c(final tt ttVar, h hVar) throws IOException {
        rh rhVarC;
        if (ttVar == null || (rhVarC = ttVar.c()) == null) {
            return hVar;
        }
        final com.byazt.mk.n nVarVe = hVar.x().ve();
        final com.byazt.mk.uj ujVarC = t.c(rhVarC);
        return hVar.i().c(new x(hVar.c("Content-Type"), hVar.x().tt(), t.c(new my() { // from class: com.byazt.umr.c.1
            public boolean c;

            @Override // com.byazt.mk.my
            public long c(com.byazt.mk.ve veVar, long j) throws IOException {
                try {
                    long jC = nVarVe.c(veVar, j);
                    if (jC != -1) {
                        veVar.c(ujVarC.ve(), veVar.tt() - jC, jC);
                        ujVarC.rl();
                        return jC;
                    }
                    if (!this.c) {
                        this.c = true;
                        ujVarC.close();
                    }
                    return -1L;
                } catch (IOException e) {
                    if (!this.c) {
                        this.c = true;
                    }
                    throw e;
                }
            }

            @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.c && !com.byazt.kh.ve.c(this, 100, TimeUnit.MILLISECONDS)) {
                    this.c = true;
                }
                nVarVe.close();
            }

            @Override // com.byazt.mk.my
            public com.byazt.mk.gt c() {
                return nVarVe.c();
            }
        }))).c();
    }

    private static com.byazt.eg.rh c(com.byazt.eg.rh rhVar, com.byazt.eg.rh rhVar2) {
        com.byazt.eg.rh.c cVar = new com.byazt.eg.rh.c();
        int iC = rhVar.c();
        for (int i = 0; i < iC; i++) {
            String strC = rhVar.c(i);
            String strTt = rhVar.tt(i);
            if ((!b.g.equalsIgnoreCase(strC) || !strTt.startsWith("1")) && (!c(strC) || rhVar2.c(strC) == null)) {
                com.byazt.kh.c.c.c(cVar, strC, strTt);
            }
        }
        int iC2 = rhVar2.c();
        for (int i2 = 0; i2 < iC2; i2++) {
            String strC2 = rhVar2.c(i2);
            if (!"Content-Length".equalsIgnoreCase(strC2) && c(strC2)) {
                com.byazt.kh.c.c.c(cVar, strC2, rhVar2.tt(i2));
            }
        }
        return cVar.c();
    }

    public static boolean c(String str) {
        return ("Connection".equalsIgnoreCase(str) || b.t0.equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || b.H.equalsIgnoreCase(str) || b.M.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || b.N.equalsIgnoreCase(str)) ? false : true;
    }
}
