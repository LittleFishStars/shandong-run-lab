package com.byazt.hz;

import android.content.Context;
import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 54})
public class ve extends tt implements com.byazt.ix.tt {
    public ve(Context context) {
        super(context);
    }

    @Override // com.byazt.ix.tt
    public void c(Context context, com.byazt.ll.tt ttVar, com.byazt.ix.uj.ve veVar) {
        c(ttVar);
        this.ve.ve(true);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.ve.c(jCurrentThreadTimeMillis);
        this.ve.c(veVar);
        com.byazt.ix.uj.c().c(this.n, jCurrentThreadTimeMillis);
        i();
    }

    @Override // com.byazt.ix.tt
    public ConcurrentHashMap<String, com.byazt.pp.tt> e_() {
        com.byazt.iz.tt ttVar = this.ve;
        if (ttVar != null) {
            return ttVar.p();
        }
        return null;
    }

    @Override // com.byazt.ix.tt
    public com.byazt.iz.tt uj() {
        return this.ve;
    }

    @Override // com.byazt.ix.tt
    public int c() {
        com.byazt.iz.tt ttVar = this.ve;
        if (ttVar != null) {
            return ttVar.h();
        }
        return 0;
    }
}
