package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class n {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MapMaker f31988a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6208a;

        public <E> Interner<E> a() {
            if (!this.f6208a) {
                this.f31988a.l();
            }
            return new d(this.f31988a);
        }

        public b b(int i) {
            this.f31988a.a(i);
            return this;
        }

        public b c() {
            this.f6208a = true;
            return this;
        }

        @GwtIncompatible("java.lang.ref.WeakReference")
        public b d() {
            this.f6208a = false;
            return this;
        }

        public b() {
            this.f31988a = new MapMaker();
            this.f6208a = true;
        }
    }

    public static class c<E> implements Function<E, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Interner<E> f31989a;

        public c(Interner<E> interner) {
            this.f31989a = interner;
        }

        @Override // com.google.common.base.Function
        public E apply(E e) {
            return this.f31989a.a(e);
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof c) {
                return this.f31989a.equals(((c) obj).f31989a);
            }
            return false;
        }

        public int hashCode() {
            return this.f31989a.hashCode();
        }
    }

    @VisibleForTesting
    public static final class d<E> implements Interner<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        public final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> f31990a;

        @Override // com.google.common.collect.Interner
        public E a(E e) {
            E e2;
            do {
                MapMakerInternalMap.InternalEntry entry = this.f31990a.getEntry(e);
                if (entry != null && (e2 = (E) entry.getKey()) != null) {
                    return e2;
                }
            } while (this.f31990a.putIfAbsent(e, MapMaker.Dummy.VALUE) != null);
            return e;
        }

        public d(MapMaker mapMaker) {
            this.f31990a = MapMakerInternalMap.createWithDummyValues(mapMaker.h(Equivalence.equals()));
        }
    }

    public static <E> Function<E, E> a(Interner<E> interner) {
        return new c((Interner) com.google.common.base.i.E(interner));
    }

    public static b b() {
        return new b();
    }

    public static <E> Interner<E> c() {
        return b().c().a();
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> d() {
        return b().d().a();
    }
}
