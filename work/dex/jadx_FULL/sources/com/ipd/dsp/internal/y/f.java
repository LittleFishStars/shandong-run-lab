package com.ipd.dsp.internal.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<?>> f38612a = new ArrayList();

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f38613a;
        public final l<T> b;

        public a(@NonNull Class<T> cls, @NonNull l<T> lVar) {
            this.f38613a = cls;
            this.b = lVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f38613a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull l<Z> lVar) {
        this.f38612a.add(new a<>(cls, lVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull l<Z> lVar) {
        this.f38612a.add(0, new a<>(cls, lVar));
    }

    @Nullable
    public synchronized <Z> l<Z> a(@NonNull Class<Z> cls) {
        int size = this.f38612a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.f38612a.get(i);
            if (aVar.a(cls)) {
                return (l<Z>) aVar.b;
            }
        }
        return null;
    }
}
