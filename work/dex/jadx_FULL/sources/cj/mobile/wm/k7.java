package cj.mobile.wm;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k7 implements q7 {
    public final Set<r7> dexa = Collections.newSetFromMap(new WeakHashMap());
    public boolean dexb;
    public boolean dexc;

    public void dexa() {
        this.dexc = true;
        Iterator it = e9.dexa(this.dexa).iterator();
        while (it.hasNext()) {
            ((r7) it.next()).d();
        }
    }

    @Override // cj.mobile.wm.q7
    public void dexa(r7 r7Var) {
        this.dexa.add(r7Var);
        if (this.dexc) {
            r7Var.d();
        } else if (this.dexb) {
            r7Var.a();
        } else {
            r7Var.b();
        }
    }

    public void dexb() {
        this.dexb = true;
        Iterator it = e9.dexa(this.dexa).iterator();
        while (it.hasNext()) {
            ((r7) it.next()).a();
        }
    }

    public void dexc() {
        this.dexb = false;
        Iterator it = e9.dexa(this.dexa).iterator();
        while (it.hasNext()) {
            ((r7) it.next()).b();
        }
    }
}
