package com.ipd.dsp.internal.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.ipd.dsp.internal.d0.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<l> f38609a = new AtomicReference<>();
    public final ArrayMap<l, List<Class<?>>> b = new ArrayMap<>();

    @Nullable
    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        l andSet = this.f38609a.getAndSet(null);
        if (andSet == null) {
            andSet = new l(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.b) {
            list = this.b.get(andSet);
        }
        this.f38609a.set(andSet);
        return list;
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new l(cls, cls2, cls3), list);
        }
    }

    public void a() {
        synchronized (this.b) {
            this.b.clear();
        }
    }
}
