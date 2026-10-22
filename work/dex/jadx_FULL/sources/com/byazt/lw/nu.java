package com.byazt.lw;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 137})
public abstract class nu implements com.byazt.dr.c {
    public com.byazt.dr.c c;
    public com.byazt.dr.c tt;
    public com.byazt.zg.ve ve;

    public nu(com.byazt.zg.ve veVar) {
        this.ve = veVar;
    }

    public void c(com.byazt.dr.c cVar) {
        this.c = cVar;
    }

    public String toString() {
        return tt();
    }

    public void tt(com.byazt.dr.c cVar) {
        this.tt = cVar;
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.OPERATOR_RESULT;
    }

    @Override // com.byazt.dr.c
    public String tt() {
        return this.c.tt() + this.ve.c() + this.tt.tt();
    }
}
