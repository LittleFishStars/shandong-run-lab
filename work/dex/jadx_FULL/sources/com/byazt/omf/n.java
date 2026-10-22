package com.byazt.omf;

import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 46})
public class n implements com.byazt.aas.c.tt {
    public final Map<Integer, WeakReference<com.byazt.aas.c.tt>> c = new HashMap();

    public void c(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        function.apply(com.byazt.yxi.uj.c().c(9).c(Boolean.class).c(0, new com.byazt.fb.c() { // from class: com.byazt.omf.n.1
            @Override // com.byazt.fb.c
            public void onAppBackground() {
                n.this.onAppBackground();
            }

            @Override // com.byazt.fb.c
            public void onAppForeground() {
                n.this.onAppForeground();
            }
        }).tt());
    }

    @Override // com.byazt.aas.c.tt
    public void onAppBackground() {
        Iterator<Map.Entry<Integer, WeakReference<com.byazt.aas.c.tt>>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<com.byazt.aas.c.tt> value = it.next().getValue();
            if (value != null) {
                com.byazt.aas.c.tt ttVar = value.get();
                if (ttVar != null) {
                    ttVar.onAppBackground();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    @Override // com.byazt.aas.c.tt
    public void onAppExit() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppForeground() {
        Iterator<Map.Entry<Integer, WeakReference<com.byazt.aas.c.tt>>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<com.byazt.aas.c.tt> value = it.next().getValue();
            if (value != null) {
                com.byazt.aas.c.tt ttVar = value.get();
                if (ttVar != null) {
                    ttVar.onAppForeground();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    @Override // com.byazt.aas.c.tt
    public void onAppStart() {
    }

    public void c(com.byazt.aas.c.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        this.c.put(Integer.valueOf(ttVar.hashCode()), new WeakReference<>(ttVar));
    }
}
