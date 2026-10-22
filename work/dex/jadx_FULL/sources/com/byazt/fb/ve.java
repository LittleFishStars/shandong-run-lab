package com.byazt.fb;

import android.util.SparseArray;
import com.byazt.omf.p;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1053, 54})
public class ve {
    public final Function<SparseArray<Object>, Object> c;
    public tt tt;

    public ve(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    public void c(tt ttVar) {
        this.tt = ttVar;
    }

    public void c(int i, SparseArray<Object> sparseArray) {
        tt ttVar;
        if (com.byazt.rl.c.c(sparseArray).tt().booleanValue(-999903) && i == 8001 && (ttVar = this.tt) != null) {
            ttVar.c(true);
        } else if (this.c != null) {
            this.c.apply(com.byazt.lq.uj.c(p.uj) ? com.byazt.yxi.uj.c(sparseArray).c(i).c(Void.class).tt() : com.byazt.yxi.uj.c().c(i).c(Void.class).c(-99999979, sparseArray).tt());
        }
    }
}
