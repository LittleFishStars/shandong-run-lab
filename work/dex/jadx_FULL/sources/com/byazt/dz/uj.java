package com.byazt.dz;

import com.byazt.ete.ic;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 106, 15})
public class uj {
    public static uj n = new uj();
    public ic c;
    public int tt;
    public volatile com.byazt.ak.c uj;
    public int ve;

    public static uj c() {
        return n;
    }

    private boolean tt() {
        this.uj = com.byazt.zlb.tt.c;
        return this.uj != null;
    }

    private String ve() {
        ic icVar = this.c;
        return icVar != null ? com.byazt.nr.c.c(icVar.yg()).toString() : "";
    }

    public uj c(ic icVar) {
        if (tt()) {
            this.c = icVar;
        }
        return this;
    }

    public uj tt(int i) {
        if (tt()) {
            this.ve = i;
        }
        return this;
    }

    public uj c(int i) {
        if (tt()) {
            this.tt = i;
        }
        return this;
    }

    public void c(Thread thread, Throwable th) {
        String str;
        if (tt()) {
            if (thread != null) {
                str = thread.getName() + c49.f40900a + thread.getId();
            } else {
                str = "";
            }
            this.uj.c(str, "-------fatal----------");
            this.uj.c(str, "last show rit:" + this.ve);
            this.uj.c(str, "last show adtype:" + this.tt);
            this.uj.c(str, ve());
            this.uj.c(str, th);
            this.uj.c(str, "-------finish----------");
            com.byazt.zlb.tt.c.c().c();
        }
    }
}
