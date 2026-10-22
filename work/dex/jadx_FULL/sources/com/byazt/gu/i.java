package com.byazt.gu;

import com.byazt.eg.h;
import com.byazt.gqp.m;
import com.byazt.gqp.nu;
import com.byazt.gqp.sl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 17, 42})
public class i extends m {
    public h c;

    public i(h hVar) {
        this.c = hVar;
    }

    @Override // com.byazt.gqp.m
    public nu a() {
        return new da(this.c.x());
    }

    @Override // com.byazt.gqp.m
    public long c() {
        return this.c.yp();
    }

    @Override // com.byazt.gqp.m, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
    }

    @Override // com.byazt.gqp.m
    public String n() {
        return this.c.n();
    }

    @Override // com.byazt.gqp.m
    public com.byazt.gqp.a sp() {
        return new com.byazt.gqp.a(this.c.sp().c);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // com.byazt.gqp.m
    public long tt() {
        return this.c.u();
    }

    @Override // com.byazt.gqp.m
    public boolean uj() {
        return this.c.uj();
    }

    @Override // com.byazt.gqp.m
    public int ve() {
        h hVar = this.c;
        if (hVar != null) {
            return hVar.ve();
        }
        return 0;
    }

    @Override // com.byazt.gqp.m
    public sl x() {
        h hVar = this.c;
        if (hVar == null) {
            return null;
        }
        return new sl(hVar.z());
    }

    @Override // com.byazt.gqp.m
    public String c(String str) {
        return this.c.c(str);
    }

    @Override // com.byazt.gqp.m
    public String c(String str, String str2) {
        return this.c.c(str, str2);
    }
}
