package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    private List<c> bbT = new CopyOnWriteArrayList();

    private boolean c(c cVar) {
        if (cVar != null) {
            return this.bbT.contains(cVar);
        }
        return false;
    }

    public final void a(c cVar) {
        if (c(cVar)) {
            return;
        }
        this.bbT.add(cVar);
    }

    public final void b(c cVar) {
        this.bbT.remove(cVar);
    }

    public final void j(View view, boolean z) {
        Iterator<c> it = this.bbT.iterator();
        while (it.hasNext()) {
            it.next().i(view, z);
        }
    }
}
