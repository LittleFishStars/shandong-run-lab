package cj.mobile.wm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class w7 {
    public final Set<f8> dexa = Collections.newSetFromMap(new WeakHashMap());
    public final List<f8> dexb = new ArrayList();
    public boolean dexc;

    public void dexa() {
        Iterator it = e9.dexa(this.dexa).iterator();
        while (it.hasNext()) {
            ((f8) it.next()).clear();
        }
        this.dexb.clear();
    }

    public void dexa(f8 f8Var) {
        this.dexa.remove(f8Var);
        this.dexb.remove(f8Var);
    }

    public void dexb() {
        this.dexc = true;
        for (f8 f8Var : e9.dexa(this.dexa)) {
            if (f8Var.isRunning()) {
                f8Var.a();
                this.dexb.add(f8Var);
            }
        }
    }

    public void dexb(f8 f8Var) {
        this.dexa.add(f8Var);
        if (this.dexc) {
            this.dexb.add(f8Var);
        } else {
            f8Var.e();
        }
    }

    public void dexc() {
        for (f8 f8Var : e9.dexa(this.dexa)) {
            if (!f8Var.d() && !f8Var.isCancelled()) {
                f8Var.a();
                if (this.dexc) {
                    this.dexb.add(f8Var);
                } else {
                    f8Var.e();
                }
            }
        }
    }

    public void dexd() {
        this.dexc = false;
        for (f8 f8Var : e9.dexa(this.dexa)) {
            if (!f8Var.d() && !f8Var.isCancelled() && !f8Var.isRunning()) {
                f8Var.e();
            }
        }
        this.dexb.clear();
    }
}
