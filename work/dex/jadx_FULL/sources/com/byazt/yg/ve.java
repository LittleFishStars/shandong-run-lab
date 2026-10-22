package com.byazt.yg;

import android.content.Context;
import com.byazt.ia.n;
import com.byazt.mg.uj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 192, 54})
public class ve implements tt {
    public Context c;

    public ve(Context context) {
        this.c = context;
    }

    @Override // com.byazt.yg.tt
    public void c(long j, Thread thread, Throwable th) throws Throwable {
        com.byazt.xz.c cVarC = com.byazt.xz.c.c(j, this.c, thread, th);
        Context context = this.c;
        com.byazt.uy.ve veVar = com.byazt.uy.ve.JAVA;
        uj.c(context, veVar.c(), Thread.currentThread().getName());
        com.byazt.jz.c.c().c(n.c().c(veVar, cVarC).c());
    }

    @Override // com.byazt.yg.tt
    public boolean c(Throwable th) {
        return true;
    }
}
