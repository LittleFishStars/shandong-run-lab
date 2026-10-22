package com.byazt.zlb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 568, 13})
public class tt implements com.byazt.ak.c {
    public static tt c;
    public com.byazt.sq.ve.c tt;

    private tt() {
    }

    public com.byazt.sq.ve.c c() {
        return this.tt;
    }

    @Override // com.byazt.ak.c
    public void tt(String str, String str2) {
        com.byazt.sq.ve.c cVar = this.tt;
        if (cVar != null) {
            cVar.uj(str, str2);
        }
    }

    public void uj(String str, String str2) {
        com.byazt.sq.ve.c cVar = this.tt;
        if (cVar != null) {
            cVar.tt(str, str2);
        }
    }

    @Override // com.byazt.ak.c
    public void ve(String str, String str2) {
        com.byazt.sq.ve.c cVar = this.tt;
        if (cVar != null) {
            cVar.n(str, str2);
        }
    }

    public static void c(com.byazt.sq.ve.c cVar, boolean z) {
        tt ttVar = new tt();
        c = ttVar;
        if (z) {
            ttVar.tt = new c(cVar);
        } else {
            ttVar.tt = cVar;
        }
    }

    @Override // com.byazt.ak.c
    public void tt(String str, String str2, Throwable th) {
        com.byazt.sq.ve.c cVar = this.tt;
        if (cVar != null) {
            cVar.tt(str, str2, th);
        }
    }

    @Override // com.byazt.ak.c
    public void c(String str, String str2) {
        com.byazt.sq.ve.c cVar = this.tt;
        if (cVar != null) {
            cVar.ve(str, str2);
        }
    }

    @Override // com.byazt.ak.c
    public void c(String str, String str2, Throwable th) {
        com.byazt.sq.ve.c cVar = this.tt;
        if (cVar != null) {
            cVar.c(str, str2, th);
        }
    }

    @Override // com.byazt.ak.c
    public void c(String str, Throwable th) {
        com.byazt.sq.ve.c cVar = this.tt;
        if (cVar != null) {
            cVar.c(str, th);
        }
    }
}
