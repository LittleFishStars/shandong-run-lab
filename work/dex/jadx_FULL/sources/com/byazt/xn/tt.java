package com.byazt.xn;

import com.byazt.gqp.i;
import com.byazt.gqp.m;
import com.byazt.gqp.yp;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 873, 13})
public class tt implements i.c {
    public List<i> c;
    public yp tt;
    public int ve = 0;

    public tt(List<i> list, yp ypVar) {
        this.c = list;
        this.tt = ypVar;
    }

    @Override // com.byazt.gqp.i.c
    public yp c() {
        return this.tt;
    }

    @Override // com.byazt.gqp.i.c
    public m c(yp ypVar) throws IOException {
        this.tt = ypVar;
        int i = this.ve + 1;
        this.ve = i;
        return this.c.get(i).c(this);
    }
}
