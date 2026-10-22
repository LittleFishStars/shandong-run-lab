package com.ipd.dsp.internal.d0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile T f38276a;
        public final /* synthetic */ b b;

        public a(b bVar) {
            this.b = bVar;
        }

        @Override // com.ipd.dsp.internal.d0.h.b
        public T get() {
            if (this.f38276a == null) {
                synchronized (this) {
                    if (this.f38276a == null) {
                        this.f38276a = (T) m.a(this.b.get());
                    }
                }
            }
            return this.f38276a;
        }
    }

    public interface b<T> {
        T get();
    }

    public static <T> b<T> a(b<T> bVar) {
        return new a(bVar);
    }
}
