package com.byazt.jb;

import com.byazt.eg.d;
import com.byazt.eg.gr;
import com.byazt.eg.gt;
import com.byazt.eg.gu;
import com.byazt.eg.h;
import com.byazt.eg.yv;
import com.byazt.mk.my;
import com.byazt.mk.rh;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 34})
public final class a implements com.byazt.yx.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.byazt.mk.a f28683a;
    public static final List<com.byazt.mk.a> da;
    public static final com.byazt.mk.a i;
    public static final com.byazt.mk.a n;
    public static final List<com.byazt.mk.a> sl;
    public static final com.byazt.mk.a sp;
    public static final com.byazt.mk.a tt;
    public static final com.byazt.mk.a uj;
    public static final com.byazt.mk.a ve;
    public static final com.byazt.mk.a x;
    public final com.byazt.iq.sp c;
    public final gu t;
    public final gt.c u;
    public final sp yp;
    public i z;

    static {
        com.byazt.mk.a aVarC = com.byazt.mk.a.c("connection");
        tt = aVarC;
        com.byazt.mk.a aVarC2 = com.byazt.mk.a.c(com.alipay.sdk.m.n.c.f);
        ve = aVarC2;
        com.byazt.mk.a aVarC3 = com.byazt.mk.a.c("keep-alive");
        uj = aVarC3;
        com.byazt.mk.a aVarC4 = com.byazt.mk.a.c("proxy-connection");
        n = aVarC4;
        com.byazt.mk.a aVarC5 = com.byazt.mk.a.c("transfer-encoding");
        f28683a = aVarC5;
        com.byazt.mk.a aVarC6 = com.byazt.mk.a.c("te");
        sp = aVarC6;
        com.byazt.mk.a aVarC7 = com.byazt.mk.a.c("encoding");
        x = aVarC7;
        com.byazt.mk.a aVarC8 = com.byazt.mk.a.c("upgrade");
        i = aVarC8;
        da = com.byazt.kh.ve.c(aVarC, aVarC2, aVarC3, aVarC4, aVarC6, aVarC5, aVarC7, aVarC8, ve.ve, ve.uj, ve.n, ve.f28695a);
        sl = com.byazt.kh.ve.c(aVarC, aVarC2, aVarC3, aVarC4, aVarC6, aVarC5, aVarC7, aVarC8);
    }

    public a(gu guVar, gt.c cVar, com.byazt.iq.sp spVar, sp spVar2) {
        this.t = guVar;
        this.u = cVar;
        this.c = spVar;
        this.yp = spVar2;
    }

    @Override // com.byazt.yx.ve
    public rh c(yv yvVar, long j) {
        return this.z.x();
    }

    @Override // com.byazt.yx.ve
    public void tt() throws IOException {
        this.z.x().close();
    }

    @Override // com.byazt.yx.ve
    public void ve() {
        i iVar = this.z;
        if (iVar != null) {
            iVar.tt(tt.CANCEL);
        }
    }

    public static List<ve> tt(yv yvVar) {
        com.byazt.eg.rh rhVarVe = yvVar.ve();
        ArrayList arrayList = new ArrayList(rhVarVe.c() + 4);
        arrayList.add(new ve(ve.ve, yvVar.tt()));
        arrayList.add(new ve(ve.uj, com.byazt.yx.i.c(yvVar.c())));
        String strC = yvVar.c("Host");
        if (strC != null) {
            arrayList.add(new ve(ve.f28695a, strC));
        }
        arrayList.add(new ve(ve.n, yvVar.c().ve()));
        int iC = rhVarVe.c();
        for (int i2 = 0; i2 < iC; i2++) {
            com.byazt.mk.a aVarC = com.byazt.mk.a.c(rhVarVe.c(i2).toLowerCase(Locale.US));
            if (!da.contains(aVarC)) {
                arrayList.add(new ve(aVarC, rhVarVe.tt(i2)));
            }
        }
        return arrayList;
    }

    @Override // com.byazt.yx.ve
    public void c(yv yvVar) throws IOException {
        if (this.z != null) {
            return;
        }
        i iVarC = this.yp.c(tt(yvVar), yvVar.uj() != null);
        this.z = iVarC;
        com.byazt.mk.gt gtVarN = iVarC.n();
        long jVe = this.u.ve();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        gtVarN.c(jVe, timeUnit);
        this.z.a().c(this.u.uj(), timeUnit);
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 464})
    public class c extends com.byazt.mk.x {
        public boolean c;
        public long tt;

        public c(my myVar) {
            super(myVar);
            this.c = false;
            this.tt = 0L;
        }

        @Override // com.byazt.mk.x, com.byazt.mk.my
        public long c(com.byazt.mk.ve veVar, long j) throws IOException {
            try {
                long jC = tt().c(veVar, j);
                if (jC > 0) {
                    this.tt += jC;
                }
                return jC;
            } catch (IOException e) {
                c(e);
                throw e;
            }
        }

        @Override // com.byazt.mk.x, com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            c(null);
        }

        private void c(IOException iOException) {
            if (this.c) {
                return;
            }
            this.c = true;
            a aVar = a.this;
            aVar.c.c(false, (com.byazt.yx.ve) aVar, this.tt, iOException);
        }
    }

    @Override // com.byazt.yx.ve
    public void c() throws IOException {
        this.yp.tt();
    }

    @Override // com.byazt.yx.ve
    public h.c c(boolean z) throws IOException {
        h.c cVarC = c(this.z.uj());
        if (z && com.byazt.kh.c.c.c(cVarC) == 100) {
            return null;
        }
        return cVarC;
    }

    public static h.c c(List<ve> list) throws IOException {
        com.byazt.eg.rh.c cVar = new com.byazt.eg.rh.c();
        int size = list.size();
        com.byazt.yx.sl slVarC = null;
        for (int i2 = 0; i2 < size; i2++) {
            ve veVar = list.get(i2);
            if (veVar == null) {
                if (slVarC != null && slVarC.tt == 100) {
                    cVar = new com.byazt.eg.rh.c();
                    slVarC = null;
                }
            } else {
                com.byazt.mk.a aVar = veVar.sp;
                String strC = veVar.x.c();
                if (aVar.equals(ve.tt)) {
                    slVarC = com.byazt.yx.sl.c("HTTP/1.1 ".concat(String.valueOf(strC)));
                } else if (!sl.contains(aVar)) {
                    com.byazt.kh.c.c.c(cVar, aVar.c(), strC);
                }
            }
        }
        if (slVarC != null) {
            return new h.c().c(gr.HTTP_2).c(slVarC.tt).c(slVarC.ve).c(cVar.c());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.byazt.yx.ve
    public d c(h hVar) throws IOException {
        return new com.byazt.yx.x(hVar.c("Content-Type"), com.byazt.yx.n.c(hVar), com.byazt.mk.t.c(new c(this.z.sp())));
    }
}
