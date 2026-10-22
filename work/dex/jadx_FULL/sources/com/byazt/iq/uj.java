package com.byazt.iq;

import com.byazt.eg.eo;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 179, 15})
public final class uj {
    public final Set<eo> c = new LinkedHashSet();

    public synchronized void c(eo eoVar) {
        this.c.add(eoVar);
    }

    public synchronized void tt(eo eoVar) {
        this.c.remove(eoVar);
    }

    public synchronized boolean ve(eo eoVar) {
        return this.c.contains(eoVar);
    }
}
