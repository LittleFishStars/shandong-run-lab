package com.byazt.gk;

import com.byazt.omf.gu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 148, 20})
public class c implements gu.tt {
    public gu.tt c;
    public int tt;

    public c(gu.tt ttVar) {
        this.c = ttVar;
    }

    public void c(int i) {
        this.tt = i;
    }

    @Override // com.byazt.omf.gu.tt
    public void c(int i, String str, com.byazt.ete.tt ttVar) {
        gu.tt ttVar2 = this.c;
        if (ttVar2 != null) {
            ttVar2.c(i, str, ttVar);
        }
    }

    @Override // com.byazt.omf.gu.tt
    public void c(final com.byazt.ete.c cVar, final com.byazt.ete.tt ttVar) {
        com.byazt.yih.c.c(cVar);
        int i = this.tt;
        boolean z = true;
        boolean z2 = i == 3 || i == 4;
        if (z2) {
            z = (com.byazt.by.n.c().t() & 1) != 1;
        }
        if (z) {
            if (this.c != null) {
                Runnable runnable = new Runnable() { // from class: com.byazt.gk.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c.c(cVar, ttVar);
                    }
                };
                if (z2) {
                    com.byazt.bzd.x.c(runnable);
                    return;
                } else {
                    com.byazt.bzd.x.ve(runnable);
                    return;
                }
            }
            return;
        }
        gu.tt ttVar2 = this.c;
        if (ttVar2 != null) {
            ttVar2.c(cVar, ttVar);
        }
    }
}
