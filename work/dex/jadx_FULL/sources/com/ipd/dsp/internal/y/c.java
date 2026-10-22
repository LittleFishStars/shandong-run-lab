package com.ipd.dsp.internal.y;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.ipd.dsp.internal.d0.l;
import com.ipd.dsp.internal.i.i;
import com.ipd.dsp.internal.i.t;
import com.ipd.dsp.internal.v.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {
    public static final t<?, ?, ?> c = new t<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new g(), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap<l, t<?, ?, ?>> f38608a = new ArrayMap<>();
    public final AtomicReference<l> b = new AtomicReference<>();

    public boolean a(@Nullable t<?, ?, ?> tVar) {
        return c.equals(tVar);
    }

    public final l b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        l andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new l();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVar;
        l lVarB = b(cls, cls2, cls3);
        synchronized (this.f38608a) {
            tVar = (t) this.f38608a.get(lVarB);
        }
        this.b.set(lVarB);
        return tVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable t<?, ?, ?> tVar) {
        synchronized (this.f38608a) {
            ArrayMap<l, t<?, ?, ?>> arrayMap = this.f38608a;
            l lVar = new l(cls, cls2, cls3);
            if (tVar == null) {
                tVar = c;
            }
            arrayMap.put(lVar, tVar);
        }
    }
}
