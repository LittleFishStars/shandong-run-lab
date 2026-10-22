package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true, serializable = true)
@DoNotMock("Use ImmutableMap.of or another implementation")
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<K> keySet;

    @CheckForNull
    @LazyInit
    private transient ImmutableSetMultimap<K, V> multimapView;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableCollection<V> values;

    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
                public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract UnmodifiableIterator<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        public class a extends UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f31724a;

            /* JADX INFO: renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a, reason: collision with other inner class name */
            public class C0717a extends AbstractMapEntry<K, ImmutableSet<V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f31725a;

                public C0717a(a aVar, Map.Entry entry) {
                    this.f31725a = entry;
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.f31725a.getValue());
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f31725a.getKey();
                }
            }

            public a(MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
                this.f31724a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0717a(this, (Map.Entry) this.f31724a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f31724a.hasNext();
            }
        }

        private MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(this, ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        public ImmutableSet<V> get(@CheckForNull Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }
    }

    public static class SerializedForm<K, V> implements Serializable {
        private static final boolean USE_LEGACY_SERIALIZATION = true;
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        public SerializedForm(ImmutableMap<K, V> immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            UnmodifiableIterator<Map.Entry<K, V>> it = immutableMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i] = next.getKey();
                objArr2[i] = next.getValue();
                i++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object legacyReadResolve() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            b<K, V> bVarMakeBuilder = makeBuilder(objArr.length);
            for (int i = 0; i < objArr.length; i++) {
                bVarMakeBuilder.f(objArr[i], objArr2[i]);
            }
            return bVarMakeBuilder.a();
        }

        public b<K, V> makeBuilder(int i) {
            return new b<>(i);
        }

        public final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof ImmutableSet)) {
                return legacyReadResolve();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            ImmutableCollection immutableCollection = (ImmutableCollection) this.values;
            b<K, V> bVarMakeBuilder = makeBuilder(immutableSet.size());
            UnmodifiableIterator it = immutableSet.iterator();
            UnmodifiableIterator it2 = immutableCollection.iterator();
            while (it.hasNext()) {
                bVarMakeBuilder.f(it.next(), it2.next());
            }
            return bVarMakeBuilder.a();
        }
    }

    public class a extends UnmodifiableIterator<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UnmodifiableIterator f31726a;

        public a(ImmutableMap immutableMap, UnmodifiableIterator unmodifiableIterator) {
            this.f31726a = unmodifiableIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31726a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f31726a.next()).getKey();
        }
    }

    @DoNotMock
    public static class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31727a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Comparator<? super V> f6060a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6061a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object[] f6062a;

        public b() {
            this(4);
        }

        public ImmutableMap<K, V> a() {
            return b();
        }

        public ImmutableMap<K, V> b() {
            j();
            this.f6061a = true;
            return RegularImmutableMap.create(this.f31727a, this.f6062a);
        }

        @CanIgnoreReturnValue
        public b<K, V> c(b<K, V> bVar) {
            com.google.common.base.i.E(bVar);
            d(this.f31727a + bVar.f31727a);
            System.arraycopy(bVar.f6062a, 0, this.f6062a, this.f31727a * 2, bVar.f31727a * 2);
            this.f31727a += bVar.f31727a;
            return this;
        }

        public final void d(int i) {
            int i2 = i * 2;
            Object[] objArr = this.f6062a;
            if (i2 > objArr.length) {
                this.f6062a = Arrays.copyOf(objArr, ImmutableCollection.Builder.f(objArr.length, i2));
                this.f6061a = false;
            }
        }

        @CanIgnoreReturnValue
        @Beta
        public b<K, V> e(Comparator<? super V> comparator) {
            com.google.common.base.i.h0(this.f6060a == null, "valueComparator was already set");
            this.f6060a = (Comparator) com.google.common.base.i.F(comparator, "valueComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public b<K, V> f(K k, V v) {
            d(this.f31727a + 1);
            com.google.common.collect.a.a(k, v);
            Object[] objArr = this.f6062a;
            int i = this.f31727a;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.f31727a = i + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public b<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        @Beta
        public b<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                d(this.f31727a + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<K, V> i(Map<? extends K, ? extends V> map) {
            return h(map.entrySet());
        }

        public void j() {
            int i;
            if (this.f6060a != null) {
                if (this.f6061a) {
                    this.f6062a = Arrays.copyOf(this.f6062a, this.f31727a * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f31727a];
                int i2 = 0;
                while (true) {
                    i = this.f31727a;
                    if (i2 >= i) {
                        break;
                    }
                    int i3 = i2 * 2;
                    Object obj = this.f6062a[i3];
                    Objects.requireNonNull(obj);
                    Object obj2 = this.f6062a[i3 + 1];
                    Objects.requireNonNull(obj2);
                    entryArr[i2] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
                    i2++;
                }
                Arrays.sort(entryArr, 0, i, Ordering.from(this.f6060a).onResultOf(Maps.N0()));
                for (int i4 = 0; i4 < this.f31727a; i4++) {
                    int i5 = i4 * 2;
                    this.f6062a[i5] = entryArr[i4].getKey();
                    this.f6062a[i5 + 1] = entryArr[i4].getValue();
                }
            }
        }

        public b(int i) {
            this.f6062a = new Object[i * 2];
            this.f31727a = 0;
            this.f6061a = false;
        }
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    @Beta
    public static <K, V> b<K, V> builderWithExpectedSize(int i) {
        com.google.common.collect.a.b(i, "expectedSize");
        return new b<>(i);
    }

    static void checkNoConflict(boolean z, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z) {
            throw conflictException(str, entry, entry2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + strValueOf.length() + strValueOf2.length());
        sb.append("Multiple entries with same ");
        sb.append(str);
        sb.append(": ");
        sb.append(strValueOf);
        sb.append(" and ");
        sb.append(strValueOf2);
        return new IllegalArgumentException(sb.toString());
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k, V v) {
        com.google.common.collect.a.a(k, v);
        return new AbstractMap.SimpleImmutableEntry(k, v);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf(Arrays.asList(entryArr));
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        return Maps.w(this, obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.k(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    boolean isHashCodeFast() {
        return false;
    }

    abstract boolean isPartialView();

    public UnmodifiableIterator<K> keyIterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // java.util.Map
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.w0(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        com.google.common.collect.a.a(k, v);
        return RegularImmutableMap.create(1, new Object[]{k, v});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> immutableSetCreateEntrySet = createEntrySet();
        this.entrySet = immutableSetCreateEntrySet;
        return immutableSetCreateEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> immutableSetCreateKeySet = createKeySet();
        this.keySet = immutableSetCreateKeySet;
        return immutableSetCreateKeySet;
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> immutableCollectionCreateValues = createValues();
        this.values = immutableCollectionCreateValues;
        return immutableCollectionCreateValues;
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        return RegularImmutableMap.create(2, new Object[]{k, v, k2, v2});
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        bVar.h(iterable);
        return bVar.a();
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        return RegularImmutableMap.create(3, new Object[]{k, v, k2, v2, k3, v3});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        return RegularImmutableMap.create(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        return RegularImmutableMap.create(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        return RegularImmutableMap.create(6, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        com.google.common.collect.a.a(k7, v7);
        return RegularImmutableMap.create(7, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        com.google.common.collect.a.a(k7, v7);
        com.google.common.collect.a.a(k8, v8);
        return RegularImmutableMap.create(8, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        com.google.common.collect.a.a(k, v);
        com.google.common.collect.a.a(k2, v2);
        com.google.common.collect.a.a(k3, v3);
        com.google.common.collect.a.a(k4, v4);
        com.google.common.collect.a.a(k5, v5);
        com.google.common.collect.a.a(k6, v6);
        com.google.common.collect.a.a(k7, v7);
        com.google.common.collect.a.a(k8, v8);
        com.google.common.collect.a.a(k9, v9);
        return RegularImmutableMap.create(9, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
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
        return RegularImmutableMap.create(10, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10});
    }
}
