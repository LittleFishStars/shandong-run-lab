package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public a<K, V> makeBuilder(int i) {
            return new a<>(i);
        }
    }

    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> a() {
            return b();
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> b() {
            if (((ImmutableMap.b) this).f31727a == 0) {
                return ImmutableBiMap.of();
            }
            j();
            ((ImmutableMap.b) this).f6061a = true;
            return new RegularImmutableBiMap(((ImmutableMap.b) this).f6062a, ((ImmutableMap.b) this).f31727a);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<K, V> c(ImmutableMap.b<K, V> bVar) {
            super.c(bVar);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        @Beta
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public a<K, V> e(Comparator<? super V> comparator) {
            super.e(comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<K, V> f(K k, V v) {
            super.f(k, v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            super.g(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        @Beta
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.h(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<K, V> i(Map<? extends K, ? extends V> map) {
            super.i(map);
            return this;
        }

        public a(int i) {
            super(i);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    @Beta
    public static <K, V> a<K, V> builderWithExpectedSize(int i) {
        com.google.common.collect.a.b(i, "expectedSize");
        return new a<>(i);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf((Iterable) Arrays.asList(entryArr));
    }

    @Override // com.google.common.collect.BiMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        com.google.common.collect.a.a(k, v);
        return new RegularImmutableBiMap(new Object[]{k, v}, 1);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4).h(iterable).a();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, 5);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6}, 6);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        com.google.common.collect.a.a(k7, v7);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7}, 7);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        com.google.common.collect.a.a(k7, v7);
        com.google.common.collect.a.a(k8, v8);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8}, 8);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        com.google.common.collect.a.a(k7, v7);
        com.google.common.collect.a.a(k8, v8);
        com.google.common.collect.a.a(k9, v9);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9}, 9);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        com.google.common.collect.a.a(k7, v7);
        com.google.common.collect.a.a(k8, v8);
        com.google.common.collect.a.a(k9, v9);
        com.google.common.collect.a.a(k10, v10);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10}, 10);
    }
}
