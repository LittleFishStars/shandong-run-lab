package com.byazt.xn;

import android.text.TextUtils;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 873, 54})
public final class ve extends t {
    public uj t;

    public ve(t.c cVar) {
        super(cVar);
        this.t = new uj();
    }

    @Override // com.byazt.gqp.t
    public com.byazt.gqp.uj c() {
        return this.t;
    }

    @Override // com.byazt.gqp.t
    public com.byazt.gqp.tt c(yp ypVar) {
        ypVar.c(this);
        if (ypVar.tt() == null || ypVar.tt().c() == null || TextUtils.isEmpty(ypVar.tt().c().toString())) {
            return null;
        }
        return new c(ypVar, this.t);
    }
}
