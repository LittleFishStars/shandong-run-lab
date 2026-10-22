package com.byazt.dl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 465, 46})
public class n extends tt {
    public static volatile n c;

    private n() {
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new n();
                }
            }
        }
        return c;
    }

    @Override // com.byazt.dl.tt
    public int tt() {
        return com.byazt.by.n.c().ve();
    }

    @Override // com.byazt.dl.tt
    public long ve() {
        return com.byazt.by.n.c().tt();
    }
}
