package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {

    @NonNull
    private List<b> aaZ = new CopyOnWriteArrayList();
    private boolean aba = false;
    private boolean abb = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.aaZ.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.aaZ.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.abb);
        if (this.abb) {
            return;
        }
        Iterator<b> it = this.aaZ.iterator();
        while (it.hasNext()) {
            it.next().c(aVar);
        }
        this.abb = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.aba);
        if (this.aba) {
            return;
        }
        Iterator<b> it = this.aaZ.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        this.aba = true;
    }
}
