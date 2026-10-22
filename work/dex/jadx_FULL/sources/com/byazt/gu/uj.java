package com.byazt.gu;

import com.byazt.eg.h;
import com.byazt.gqp.m;
import com.byazt.gqp.yp;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 17, 15})
public class uj implements com.byazt.gqp.tt {
    public com.byazt.eg.n c;

    public uj(com.byazt.eg.n nVar) {
        this.c = nVar;
    }

    @Override // com.byazt.gqp.tt
    public yp c() {
        return new x(this.c.c());
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.byazt.gqp.tt clone() {
        return new uj(this.c.n());
    }

    @Override // com.byazt.gqp.tt
    public m tt() throws IOException {
        return new i(this.c.tt());
    }

    @Override // com.byazt.gqp.tt
    public boolean uj() {
        return this.c.uj();
    }

    @Override // com.byazt.gqp.tt
    public void ve() {
        this.c.ve();
    }

    @Override // com.byazt.gqp.tt
    public void c(final com.byazt.gqp.ve veVar) {
        this.c.c(new com.byazt.eg.a() { // from class: com.byazt.gu.uj.1
            @Override // com.byazt.eg.a
            public void c(com.byazt.eg.n nVar, IOException iOException) {
                veVar.onFailure(new uj(nVar), iOException);
            }

            @Override // com.byazt.eg.a
            public void c(com.byazt.eg.n nVar, h hVar) throws IOException {
                veVar.onResponse(new uj(nVar), new i(hVar));
            }
        });
    }
}
