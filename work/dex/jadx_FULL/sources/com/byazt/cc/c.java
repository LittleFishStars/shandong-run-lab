package com.byazt.cc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 20})
public class c {
    public com.byazt.vw.tt c;

    public void c(com.byazt.vw.tt ttVar) {
        this.c = ttVar;
    }

    public void tt() {
        com.byazt.vw.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    public boolean ve() {
        return this.c == null;
    }

    public void c() {
        com.byazt.vw.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.tt();
            this.c = null;
        }
    }

    public void c(com.byazt.nc.tt ttVar) {
        com.byazt.vw.tt ttVar2 = this.c;
        if (ttVar2 != null) {
            ttVar2.c(ttVar);
        }
    }
}
