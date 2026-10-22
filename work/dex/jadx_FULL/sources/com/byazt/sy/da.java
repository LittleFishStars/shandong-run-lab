package com.byazt.sy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.byazt.ete.lr;
import com.byazt.ete.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 72})
public class da {
    public ic c;
    public List<com.byazt.ma.a> n;
    public com.byazt.dj.tt tt;
    public Context uj;
    public c ve;

    public da(ic icVar, c cVar) {
        this.c = icVar;
        this.ve = cVar;
        this.n = new ArrayList();
        if (icVar == null || !lr.tt(icVar)) {
            return;
        }
        com.byazt.rgb.a.c(icVar, String.valueOf(nb.t(icVar)), nb.sl(icVar), 3, com.byazt.ip.sp.c(icVar));
        final int iUj = p.uj(this.c);
        com.byazt.rgb.a.c().c(com.byazt.ip.sp.c(icVar), new com.byazt.ip.uj.c() { // from class: com.byazt.sy.da.1
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar) {
                if (ttVar instanceof com.byazt.ha.x) {
                    ((com.byazt.ha.x) ttVar).ve = iUj;
                }
            }
        });
    }

    private void tt(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("overlay_tag".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("overlay_tag".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                }
            }
        }
    }

    public void c(ViewGroup viewGroup, View view) {
        final List<ir> listC;
        tt(viewGroup, view);
        if (!lr.tt(this.c) || (listC = lr.c(this.c)) == null || listC.isEmpty()) {
            return;
        }
        com.byazt.rgb.a.tt(com.byazt.ip.sp.c(this.c));
        if (listC.get(0) != null) {
            com.byazt.rgb.a.c().c(com.byazt.ip.sp.c(this.c), new com.byazt.ip.uj.c() { // from class: com.byazt.sy.da.2
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar) {
                    if (ttVar instanceof com.byazt.ha.x) {
                        com.byazt.ha.x xVar = (com.byazt.ha.x) ttVar;
                        xVar.tt = ((ir) listC.get(0)).n();
                        xVar.n = ((ir) listC.get(0)).uj();
                    }
                }
            });
        }
        for (ir irVar : listC) {
            if (irVar != null) {
                ve.c(this.c, irVar);
                com.byazt.ma.a aVar = new com.byazt.ma.a(this.c, this.ve, irVar);
                aVar.c(this.tt);
                aVar.c(this.uj);
                aVar.tt(viewGroup, irVar.uj() == 0 ? viewGroup : view);
                this.n.add(aVar);
            }
        }
    }

    public da(ic icVar, c cVar, com.byazt.dj.tt ttVar, Context context) {
        this(icVar, cVar);
        this.tt = ttVar;
        this.uj = context;
    }

    public void c() {
        for (com.byazt.ma.a aVar : this.n) {
            if (aVar != null) {
                aVar.c((com.byazt.dj.tt) null);
                aVar.c((Context) null);
                aVar.n();
            }
        }
        this.n.clear();
    }
}
