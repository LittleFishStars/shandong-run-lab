package com.byazt.vvt;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.bzd.sl;
import com.byazt.bzd.x;
import com.byazt.ete.dz;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.ete.xd;
import com.byazt.ete.zb;
import com.byazt.nc.yp;
import com.byazt.nr.da;
import com.byazt.omf.gt;
import com.byazt.ouz.gr;
import com.byazt.ouz.gu;
import com.byazt.ouz.zm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 210, 15})
public class uj extends tt<List<yp>> {
    public List<Long> tt;
    public final int ve;

    public uj(com.byazt.iu.tt ttVar, int i) {
        super(ttVar);
        this.tt = new CopyOnWriteArrayList();
        this.ve = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final com.byazt.dj.tt ttVar, final List<ic> list, final tt.c<List<yp>> cVar) {
        x.ve(new Runnable() { // from class: com.byazt.vvt.uj.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    yp ypVarC = uj.this.c(ttVar, (ic) it.next());
                    if (ypVarC != null) {
                        arrayList.add(ypVarC);
                    }
                }
                tt.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(arrayList);
                }
            }
        });
    }

    @Override // com.byazt.vvt.tt
    public /* bridge */ /* synthetic */ void c(com.byazt.dj.tt ttVar, List list, List<yp> list2) {
        c2(ttVar, (List<ic>) list, list2);
    }

    @Override // com.byazt.vvt.tt
    public void c(final com.byazt.dj.tt ttVar, final List<ic> list, final tt.c<List<yp>> cVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.tt.add(Long.valueOf(jCurrentTimeMillis));
        final int[] iArr = {0};
        final int[] iArr2 = {list.size()};
        if (gt.tt().up() > 0) {
            da.c().postDelayed(new Runnable() { // from class: com.byazt.vvt.uj.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (this) {
                        if (uj.this.tt.contains(Long.valueOf(jCurrentTimeMillis))) {
                            uj.this.tt.remove(Long.valueOf(jCurrentTimeMillis));
                            uj.this.tt(ttVar, list, cVar);
                        }
                    }
                }
            }, gt.tt().up());
        }
        Iterator<ic> it = list.iterator();
        while (it.hasNext()) {
            final long j = jCurrentTimeMillis;
            c(it.next(), new com.byazt.xs.ve() { // from class: com.byazt.vvt.uj.2
                @Override // com.byazt.xs.ve
                public void c(String str) {
                    synchronized (this) {
                        int[] iArr3 = iArr;
                        int i = iArr3[0] + 1;
                        iArr3[0] = i;
                        uj.this.c(j, ttVar, (List<ic>) list, (tt.c<List<yp>>) cVar, i, iArr2[0]);
                    }
                }

                @Override // com.byazt.xs.ve
                public void c() {
                    synchronized (this) {
                        int[] iArr3 = iArr2;
                        int i = iArr3[0] - 1;
                        iArr3[0] = i;
                        uj.this.c(j, ttVar, (List<ic>) list, (tt.c<List<yp>>) cVar, iArr[0], i);
                    }
                }
            });
            jCurrentTimeMillis = jCurrentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, com.byazt.dj.tt ttVar, List<ic> list, tt.c<List<yp>> cVar, int i, int i2) {
        if (this.tt.contains(Long.valueOf(j))) {
            if (gt.tt().xg() != 1 || i == i2) {
                this.tt.remove(Long.valueOf(j));
                tt(ttVar, list, cVar);
            }
        }
    }

    private void c(ic icVar, com.byazt.xs.ve veVar) {
        if (pu.sl(icVar)) {
            com.byazt.lc.c.c(icVar, veVar);
            return;
        }
        if (pu.da(icVar)) {
            dz dzVarA = pu.a(icVar);
            if (dzVarA != null) {
                com.byazt.xs.da.c(dzVarA.i(), dzVarA.da(), veVar);
                return;
            }
            return;
        }
        veVar.c(null);
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    public void c2(com.byazt.dj.tt ttVar, List<ic> list, List<yp> list2) {
        for (int i = 0; i < list2.size(); i++) {
            yp ypVar = list2.get(i);
            ic icVar = list.get(i);
            com.byazt.iu.tt ttVar2 = this.c;
            if (ttVar2 != null) {
                ttVar2.tt().c(ttVar, icVar, (Object) ypVar, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public yp c(com.byazt.dj.tt ttVar, ic icVar) {
        boolean z = xd.z(icVar) != null;
        int i = this.ve;
        if (i == 1) {
            if (z) {
                return new com.byazt.tp.ve(gt.getContext(), icVar, ttVar);
            }
            return new com.byazt.tp.tt(gt.getContext(), icVar, ttVar);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new gr(gt.getContext(), icVar, ttVar, this.ve);
        }
        if (z) {
            return new zm(gt.getContext(), icVar, ttVar, this.ve);
        }
        return new gu(gt.getContext(), icVar, ttVar, this.ve);
    }

    @Override // com.byazt.vvt.tt, com.byazt.dx.c
    public void c(int i, com.byazt.dj.tt ttVar, ic icVar) {
        int i2;
        if (icVar == null) {
            return;
        }
        String strN = (ttVar == null || !((i2 = this.ve) == 3 || i2 == 4)) ? null : sl.n();
        com.byazt.ex.c.tt(icVar);
        if (icVar.qt() && icVar.pa() != null && !icVar.pa().isEmpty()) {
            for (zb zbVar : icVar.pa()) {
                if (!TextUtils.isEmpty(zbVar.c())) {
                    com.byazt.hy.n.c().ve().c(new com.byazt.sml.tt(zbVar.c(), zbVar.sp()), com.byazt.uph.c.tt(), zbVar.tt(), zbVar.ve(), strN);
                }
            }
        }
        if (TextUtils.isEmpty(xd.c(icVar))) {
            return;
        }
        if (gt.tt().uj(String.valueOf(nb.t(icVar))) && gt.tt().sf()) {
            com.byazt.jzl.a aVarC = xd.c(4, icVar);
            aVarC.putExtra("material_meta", icVar);
            aVarC.putExtra("ad_slot", Integer.valueOf(i));
            com.byazt.btt.ve.c(aVarC, (com.byazt.fk.da.c) null);
        }
    }
}
