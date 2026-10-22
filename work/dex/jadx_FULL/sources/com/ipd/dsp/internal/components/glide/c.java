package com.ipd.dsp.internal.components.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.internal.a0.k;
import com.ipd.dsp.internal.a0.r;
import com.ipd.dsp.internal.b.f;
import com.ipd.dsp.internal.b.i;
import com.ipd.dsp.internal.d0.h;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends ContextWrapper {

    @VisibleForTesting
    public static final i<?, ?> j = new com.ipd.dsp.internal.b.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.j.b f38244a;
    public final h.b<f> b;
    public final k c;
    public final a.InterfaceC0867a d;
    public final List<com.ipd.dsp.internal.z.h<Object>> e;
    public final Map<Class<?>, i<?, ?>> f;
    public final com.ipd.dsp.internal.i.k g;
    public final d h;

    @Nullable
    @GuardedBy("this")
    public com.ipd.dsp.internal.z.i i;

    public c(@NonNull Context context, @NonNull com.ipd.dsp.internal.j.b bVar, @NonNull h.b<f> bVar2, @NonNull k kVar, @NonNull a.InterfaceC0867a interfaceC0867a, @NonNull Map<Class<?>, i<?, ?>> map, @NonNull List<com.ipd.dsp.internal.z.h<Object>> list, @NonNull com.ipd.dsp.internal.i.k kVar2, @NonNull d dVar) {
        super(context.getApplicationContext());
        this.f38244a = bVar;
        this.c = kVar;
        this.d = interfaceC0867a;
        this.e = list;
        this.f = map;
        this.g = kVar2;
        this.h = dVar;
        this.b = h.a(bVar2);
    }

    @NonNull
    public <T> i<?, T> a(@NonNull Class<T> cls) {
        i<?, T> iVar = (i) this.f.get(cls);
        if (iVar == null) {
            for (Map.Entry<Class<?>, i<?, ?>> entry : this.f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    iVar = (i) entry.getValue();
                }
            }
        }
        return iVar == null ? (i<?, T>) j : iVar;
    }

    public List<com.ipd.dsp.internal.z.h<Object>> b() {
        return this.e;
    }

    public synchronized com.ipd.dsp.internal.z.i c() {
        if (this.i == null) {
            this.i = this.d.build().M();
        }
        return this.i;
    }

    @NonNull
    public com.ipd.dsp.internal.i.k d() {
        return this.g;
    }

    public d e() {
        return this.h;
    }

    @NonNull
    public f f() {
        return this.b.get();
    }

    @NonNull
    public <X> r<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.c.a(imageView, cls);
    }

    @NonNull
    public com.ipd.dsp.internal.j.b a() {
        return this.f38244a;
    }
}
