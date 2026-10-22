package com.byazt.gu;

import com.byazt.eg.gt;
import com.byazt.gqp.m;
import com.byazt.gqp.yp;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 17, 46})
public class n implements com.byazt.gqp.i.c {
    public gt.c c;

    public n(gt.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.gqp.i.c
    public yp c() {
        return new x(this.c.c());
    }

    @Override // com.byazt.gqp.i.c
    public m c(yp ypVar) throws IOException {
        return new i(this.c.c(this.c.c().a().c(ypVar.tt().c()).c()));
    }
}
