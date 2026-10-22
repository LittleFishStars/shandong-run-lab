package com.byazt.gy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2085, 46})
public class n {
    public String c;
    public int tt;
    public com.byazt.cda.c ve;

    public n(String str, int i) {
        this.c = str;
        this.tt = i;
    }

    public n(com.byazt.cda.c cVar) {
        if (cVar != null) {
            this.c = cVar.tt();
            this.tt = cVar.ve();
            this.ve = cVar;
        }
    }
}
