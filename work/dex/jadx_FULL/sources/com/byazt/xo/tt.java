package com.byazt.xo;

import com.byazt.dna.zm;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.omf.x;
import com.byazt.ut.uj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1047, 13})
public class tt {
    public int c = 10000;
    public int tt;
    public Runnable uj;
    public long ve;

    public tt(int i) {
        this.tt = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(Runnable runnable) {
        zm zmVar = (zm) uj.getService("m_s");
        if (zmVar != null && zmVar.assertAndSetState(0, this.tt, true)) {
            tt(3);
            c();
        } else if (runnable != null) {
            tt(1);
            runnable.run();
        }
    }

    public tt c(int i) {
        this.c = i <= 0 ? 10000 : i * 1000;
        return this;
    }

    public void c(final Runnable runnable) {
        this.ve = System.currentTimeMillis();
        if (!c.a()) {
            tt(runnable);
            return;
        }
        if (x.m().d()) {
            tt(2);
            c();
        } else if (!c.c()) {
            tt(runnable);
        } else {
            da.c().postDelayed(new Runnable() { // from class: com.byazt.xo.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!x.m().d()) {
                        tt.this.tt(runnable);
                    } else {
                        tt.this.tt(2);
                        tt.this.c();
                    }
                }
            }, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(">> tk: ");
        sb.append(this.tt);
        if (i == 1) {
            str = " run";
        } else {
            str = i == 2 ? " cancel" : " runed";
        }
        sb.append(str);
        sb.append(", isBst: true, tmgap: ");
        sb.append((System.currentTimeMillis() - this.ve) / 1000);
        if (i == 1) {
            m.c("bstsdk", sb.toString());
        } else {
            m.tt("bstsdk", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Runnable runnable = this.uj;
        if (runnable != null) {
            runnable.run();
        }
    }
}
