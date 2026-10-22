package com.byazt.ha;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 992, 91})
public abstract class sp {
    public com.byazt.lh.tt c;
    public String tt;

    public void c() {
        com.byazt.lh.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(this.tt, com.byazt.hi.tt.STARTED);
        }
    }

    public void tt() {
        com.byazt.lh.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(this.tt, com.byazt.hi.tt.REQED);
        }
    }

    public void c(final boolean z) {
        com.byazt.lh.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(this.tt, new com.byazt.ip.uj.c() { // from class: com.byazt.ha.sp.1
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar2) {
                    if (ttVar2 instanceof tt) {
                        ((tt) ttVar2).tt = z;
                    }
                }
            });
            this.c.c(this.tt, com.byazt.hi.tt.RECEIVED);
        }
    }

    public void c(final String str, final boolean z, final com.byazt.lq.ve veVar) {
        com.byazt.lh.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(this.tt, new com.byazt.ip.uj.c() { // from class: com.byazt.ha.sp.2
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar2) {
                    if (ttVar2 instanceof tt) {
                        tt ttVar3 = (tt) ttVar2;
                        ttVar3.ve = z;
                        ttVar3.uj = veVar;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        ttVar3.n.add(str);
                    }
                }
            });
            if (!TextUtils.isEmpty(str)) {
                ((com.byazt.lh.ve) com.byazt.ip.n.c(1)).c(str, new com.byazt.ip.uj.c() { // from class: com.byazt.ha.sp.3
                    @Override // com.byazt.ip.uj.c
                    public void c(com.byazt.ip.tt ttVar2) {
                        if (ttVar2 instanceof ve) {
                            ((ve) ttVar2).c = sp.this.tt;
                        }
                    }
                });
            }
            this.c.c(this.tt, com.byazt.hi.tt.LOADED);
        }
    }
}
