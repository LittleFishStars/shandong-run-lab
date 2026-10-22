package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h {
    private static volatile h aTu;
    private List<a> aTt = new CopyOnWriteArrayList();

    public interface a {
        void a(f fVar, int i);
    }

    private h() {
    }

    public static h Mg() {
        if (aTu == null) {
            synchronized (h.class) {
                if (aTu == null) {
                    aTu = new h();
                }
            }
        }
        return aTu;
    }

    public final void a(a aVar) {
        this.aTt.add(aVar);
    }

    public final void b(f fVar, int i) {
        Iterator<a> it = this.aTt.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i);
        }
    }
}
