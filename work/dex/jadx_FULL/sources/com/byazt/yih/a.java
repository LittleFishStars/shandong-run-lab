package com.byazt.yih;

import com.byazt.omf.gt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 34})
public class a implements uj {
    public List<uj> c = new ArrayList();
    public ve tt;

    public a() {
        ve veVar = new ve(gt.tt().vp());
        this.tt = veVar;
        this.c.add(new n(veVar));
        this.c.add(new sp(this.tt));
    }

    @Override // com.byazt.yih.uj
    public boolean c(com.byazt.qt.c cVar) {
        Iterator<uj> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().c(cVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.yih.uj
    public boolean tt(com.byazt.qt.c cVar) {
        Iterator<uj> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().tt(cVar)) {
                return true;
            }
        }
        return false;
    }
}
