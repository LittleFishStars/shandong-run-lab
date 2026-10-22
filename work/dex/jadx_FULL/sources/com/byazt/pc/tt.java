package com.byazt.pc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 13})
public class tt implements i {
    public byte[] c;
    public com.byazt.yj.sp tt;

    public tt(byte[] bArr, com.byazt.yj.sp spVar) {
        this.c = bArr;
        this.tt = spVar;
    }

    @Override // com.byazt.pc.i
    public String c() {
        return "image_type";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        i xVar;
        int iN = veVar.n();
        veVar.c(this.c.length);
        if (iN != 2) {
            if (iN != 3) {
                boolean zTt = com.byazt.as.c.tt(this.c);
                if (zTt) {
                    byte[] bArr = this.c;
                    xVar = new yp(bArr, bArr, this.tt, zTt);
                } else if (com.byazt.as.c.c(this.c)) {
                    xVar = new n(this.c, this.tt);
                } else {
                    byte[] bArr2 = this.c;
                    xVar = new yp(bArr2, bArr2, this.tt, zTt);
                }
            } else {
                byte[] bArr3 = this.c;
                xVar = new yp(bArr3, bArr3, this.tt, com.byazt.as.c.tt(bArr3));
            }
        } else if (com.byazt.as.c.c(this.c)) {
            xVar = new n(this.c, this.tt);
        } else {
            xVar = (this.tt != null || veVar.i()) ? new x(1001, "not image format", null) : new sl();
        }
        veVar.c(xVar);
    }
}
