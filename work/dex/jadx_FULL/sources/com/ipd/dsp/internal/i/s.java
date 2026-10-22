package com.ipd.dsp.internal.i;

import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<com.ipd.dsp.internal.f.f, l<?>> f38342a = new HashMap();
    public final Map<com.ipd.dsp.internal.f.f, l<?>> b = new HashMap();

    @VisibleForTesting
    public Map<com.ipd.dsp.internal.f.f, l<?>> a() {
        return Collections.unmodifiableMap(this.f38342a);
    }

    public void b(com.ipd.dsp.internal.f.f fVar, l<?> lVar) {
        Map<com.ipd.dsp.internal.f.f, l<?>> mapA = a(lVar.i());
        if (lVar.equals(mapA.get(fVar))) {
            mapA.remove(fVar);
        }
    }

    public l<?> a(com.ipd.dsp.internal.f.f fVar, boolean z) {
        return a(z).get(fVar);
    }

    public void a(com.ipd.dsp.internal.f.f fVar, l<?> lVar) {
        a(lVar.i()).put(fVar, lVar);
    }

    public final Map<com.ipd.dsp.internal.f.f, l<?>> a(boolean z) {
        return z ? this.b : this.f38342a;
    }
}
