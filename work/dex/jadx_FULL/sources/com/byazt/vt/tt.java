package com.byazt.vt;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1282, 13})
public class tt implements ve {
    public List<uj> c = new CopyOnWriteArrayList();

    @Override // com.byazt.vt.ve
    public void c(uj ujVar) {
        this.c.add(ujVar);
    }

    @Override // com.byazt.vt.ve
    public void c(String str) {
        if (this.c.isEmpty()) {
            return;
        }
        Iterator<uj> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().c(str);
        }
    }
}
