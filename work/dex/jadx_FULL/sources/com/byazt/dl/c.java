package com.byazt.dl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 465, 20})
public class c extends tt {
    public static volatile c c;

    private c() {
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    @Override // com.byazt.dl.tt
    public synchronized int tt() {
        int iVe = com.byazt.by.n.c().ve();
        float fUj = com.byazt.by.n.c().uj();
        if (fUj <= 0.0f) {
            return iVe;
        }
        return (int) Math.ceil(fUj * iVe);
    }

    @Override // com.byazt.dl.tt
    public synchronized long ve() {
        return com.byazt.by.n.c().tt();
    }
}
