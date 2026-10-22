package com.ipd.dsp.internal.w;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class r implements k {
    public final Set<com.ipd.dsp.internal.a0.p<?>> f = Collections.newSetFromMap(new WeakHashMap());

    public void a(@NonNull com.ipd.dsp.internal.a0.p<?> pVar) {
        this.f.add(pVar);
    }

    public void b(@NonNull com.ipd.dsp.internal.a0.p<?> pVar) {
        this.f.remove(pVar);
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onDestroy() {
        Iterator it = com.ipd.dsp.internal.d0.o.a(this.f).iterator();
        while (it.hasNext()) {
            ((com.ipd.dsp.internal.a0.p) it.next()).onDestroy();
        }
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStart() {
        Iterator it = com.ipd.dsp.internal.d0.o.a(this.f).iterator();
        while (it.hasNext()) {
            ((com.ipd.dsp.internal.a0.p) it.next()).onStart();
        }
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStop() {
        Iterator it = com.ipd.dsp.internal.d0.o.a(this.f).iterator();
        while (it.hasNext()) {
            ((com.ipd.dsp.internal.a0.p) it.next()).onStop();
        }
    }

    public void a() {
        this.f.clear();
    }

    @NonNull
    public List<com.ipd.dsp.internal.a0.p<?>> b() {
        return com.ipd.dsp.internal.d0.o.a(this.f);
    }
}
