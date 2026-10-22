package com.ipd.dsp.internal.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C0929a<?>> f38605a = new ArrayList();

    /* JADX INFO: renamed from: com.ipd.dsp.internal.y.a$a, reason: collision with other inner class name */
    public static final class C0929a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f38606a;
        public final com.ipd.dsp.internal.f.d<T> b;

        public C0929a(@NonNull Class<T> cls, @NonNull com.ipd.dsp.internal.f.d<T> dVar) {
            this.f38606a = cls;
            this.b = dVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f38606a.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.ipd.dsp.internal.f.d<T> a(@NonNull Class<T> cls) {
        for (C0929a<?> c0929a : this.f38605a) {
            if (c0929a.a(cls)) {
                return (com.ipd.dsp.internal.f.d<T>) c0929a.b;
            }
        }
        return null;
    }

    public synchronized <T> void b(@NonNull Class<T> cls, @NonNull com.ipd.dsp.internal.f.d<T> dVar) {
        this.f38605a.add(0, new C0929a<>(cls, dVar));
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.ipd.dsp.internal.f.d<T> dVar) {
        this.f38605a.add(new C0929a<>(cls, dVar));
    }
}
