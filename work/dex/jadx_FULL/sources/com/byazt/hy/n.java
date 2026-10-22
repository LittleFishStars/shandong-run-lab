package com.byazt.hy;

import android.annotation.SuppressLint;
import android.content.Context;
import com.byazt.ete.cu;
import com.byazt.omf.gt;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 604, 46})
public class n {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile n c;
    public Context tt;
    public final com.byazt.hm.c uj;
    public com.byazt.re.c ve;

    private n(Context context) {
        this.tt = context == null ? gt.getContext() : context.getApplicationContext();
        com.byazt.hm.c.C0422c c0422c = new com.byazt.hm.c.C0422c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.byazt.hm.c cVarC = c0422c.c(10000L, timeUnit).tt(10000L, timeUnit).ve(10000L, timeUnit).c(new c.C0431c()).c(cu.c()).c(cu.tt()).c(true).c();
        this.uj = cVarC;
        com.byazt.gqp.uj ujVarC = cVarC.a().c();
        if (ujVarC != null) {
            ujVarC.c(32);
            ujVarC.tt(com.byazt.by.ve.c().n());
        }
    }

    public static n c() {
        if (c == null) {
            synchronized (n.class) {
                if (c == null) {
                    com.byazt.yr.c.c().c(com.byazt.by.ve.c().a() != 2);
                    c = new n(gt.getContext());
                }
            }
        }
        return c;
    }

    private void uj() {
        if (this.ve == null) {
            this.ve = new com.byazt.re.c();
        }
    }

    public com.byazt.hm.c tt() {
        return this.uj;
    }

    public com.byazt.re.c ve() {
        uj();
        return this.ve;
    }
}
