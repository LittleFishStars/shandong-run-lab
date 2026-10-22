package com.acse.ottn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q4 extends t4 {
    public a N;
    public long O = -1;

    public interface a {
        void a(q4 q4Var, long j, long j2);
    }

    @Override // com.acse.ottn.t4
    public void D() {
    }

    @Override // com.acse.ottn.t4
    public void a(float f) {
    }

    public void a(a aVar) {
        this.N = aVar;
    }

    @Override // com.acse.ottn.t4
    public boolean c(long j) {
        if (this.i == 0) {
            this.i = 1;
            long j2 = this.c;
            if (j2 < 0) {
                this.b = j;
            } else {
                this.b = j - j2;
                this.c = -1L;
            }
        }
        a aVar = this.N;
        if (aVar == null) {
            return false;
        }
        long j3 = j - this.b;
        long j4 = this.O;
        long j5 = j4 >= 0 ? j - j4 : 0L;
        this.O = j;
        aVar.a(this, j3, j5);
        return false;
    }
}
