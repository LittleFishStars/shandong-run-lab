package com.ipd.dsp.internal.p;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.i.v;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b<T> implements v<T> {
    public final T f;

    public b(@NonNull T t) {
        this.f = (T) m.a(t);
    }

    @Override // com.ipd.dsp.internal.i.v
    public final int c() {
        return 1;
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<T> d() {
        return (Class<T>) this.f.getClass();
    }

    @Override // com.ipd.dsp.internal.i.v
    public void e() {
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public final T get() {
        return this.f;
    }
}
