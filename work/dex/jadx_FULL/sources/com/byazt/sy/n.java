package com.byazt.sy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.p;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 46})
public class n {
    public ic c;
    public com.byazt.ma.tt tt;
    public com.byazt.ma.ve ve;

    public n(ic icVar, c cVar) {
        this.c = icVar;
        this.tt = new com.byazt.ma.tt(icVar, cVar);
        this.ve = new com.byazt.ma.ve(this.c, cVar);
        if (icVar == null || !p.c(icVar)) {
            return;
        }
        com.byazt.rgb.a.c(icVar, String.valueOf(nb.t(icVar)), nb.sl(icVar), p.tt(icVar) ? 1 : 2, com.byazt.ip.sp.c(icVar));
        final int iUj = p.uj(this.c);
        com.byazt.rgb.a.c().c(com.byazt.ip.sp.c(icVar), new com.byazt.ip.uj.c() { // from class: com.byazt.sy.n.1
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar) {
                if (ttVar instanceof com.byazt.ha.x) {
                    ((com.byazt.ha.x) ttVar).ve = iUj;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("easy_play_tag".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("easy_play_tag".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                }
            }
        }
    }

    public void c(final ViewGroup viewGroup, final View view) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new Runnable() { // from class: com.byazt.sy.n.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                n.this.tt(viewGroup, view);
                if (p.tt(n.this.c)) {
                    com.byazt.rgb.a.tt(com.byazt.ip.sp.c(n.this.c));
                    com.byazt.rgb.a.c().c(com.byazt.ip.sp.c(n.this.c), new com.byazt.ip.uj.c() { // from class: com.byazt.sy.n.2.1
                        @Override // com.byazt.ip.uj.c
                        public void c(com.byazt.ip.tt ttVar) {
                            if (ttVar instanceof com.byazt.ha.x) {
                                com.byazt.ha.x xVar = (com.byazt.ha.x) ttVar;
                                xVar.tt = p.x(n.this.c).n();
                                xVar.n = p.x(n.this.c).uj();
                            }
                        }
                    });
                    ic icVar = n.this.c;
                    ve.c(icVar, p.x(icVar));
                    z = p.x(n.this.c).uj() == 0;
                    com.byazt.ma.tt ttVar = n.this.tt;
                    ViewGroup viewGroup2 = viewGroup;
                    ttVar.tt(viewGroup2, z ? viewGroup2 : view);
                    return;
                }
                if (p.ve(n.this.c)) {
                    com.byazt.rgb.a.tt(com.byazt.ip.sp.c(n.this.c));
                    com.byazt.rgb.a.c().c(com.byazt.ip.sp.c(n.this.c), new com.byazt.ip.uj.c() { // from class: com.byazt.sy.n.2.2
                        @Override // com.byazt.ip.uj.c
                        public void c(com.byazt.ip.tt ttVar2) {
                            if (ttVar2 instanceof com.byazt.ha.x) {
                                com.byazt.ha.x xVar = (com.byazt.ha.x) ttVar2;
                                xVar.tt = p.sp(n.this.c).n();
                                xVar.n = p.sp(n.this.c).uj();
                            }
                        }
                    });
                    ic icVar2 = n.this.c;
                    ve.c(icVar2, p.sp(icVar2));
                    z = p.sp(n.this.c).uj() == 0;
                    com.byazt.ma.ve veVar = n.this.ve;
                    ViewGroup viewGroup3 = viewGroup;
                    veVar.tt(viewGroup3, z ? viewGroup3 : view);
                }
            }
        });
    }

    public sp c() {
        if (p.tt(this.c)) {
            return this.tt.c();
        }
        if (p.ve(this.c)) {
            return this.ve.c();
        }
        return new sp() { // from class: com.byazt.sy.n.3
            @Override // com.byazt.sy.sp
            public void c() {
            }

            @Override // com.byazt.sy.sp
            public void c(int i) {
            }

            @Override // com.byazt.sy.sp
            public void c(boolean z) {
            }

            @Override // com.byazt.sy.sp
            public void n() {
            }

            @Override // com.byazt.sy.sp
            public void tt() {
            }

            @Override // com.byazt.sy.sp
            public void uj() {
            }

            @Override // com.byazt.sy.sp
            public void ve() {
            }
        };
    }

    public void c(com.byazt.lsp.tt ttVar) {
        com.byazt.ma.ve veVar = this.ve;
        if (veVar != null) {
            veVar.c(ttVar);
        }
        com.byazt.ma.tt ttVar2 = this.tt;
        if (ttVar2 != null) {
            ttVar2.c(ttVar);
        }
    }

    public n(ic icVar, c cVar, com.byazt.dj.tt ttVar, Context context) {
        this(icVar, cVar);
        this.tt.c(ttVar);
        this.tt.c(context);
    }

    public void tt() {
        com.byazt.ma.tt ttVar = this.tt;
        if (ttVar != null) {
            ttVar.n();
        }
        com.byazt.ma.ve veVar = this.ve;
        if (veVar != null) {
            veVar.ve();
        }
    }
}
