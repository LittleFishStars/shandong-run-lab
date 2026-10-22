package com.google.common.collect;

import XI.K0.XI.XI;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Maps {

    public static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Predicate<? super Map.Entry<K, V>> f31801a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<K, V> f6111a;

        public AbstractFilteredMap(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
            this.f6111a = map;
            this.f31801a = predicate;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<V> c() {
            return new t(this, this.f6111a, this.f31801a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f6111a.containsKey(obj) && d(obj, this.f6111a.get(obj));
        }

        public boolean d(@CheckForNull Object obj, @ParametricNullness V v) {
            return this.f31801a.apply(Maps.O(obj, v));
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            V v = this.f6111a.get(obj);
            if (v == null || !d(obj, v)) {
                return null;
            }
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(@ParametricNullness K k, @ParametricNullness V v) {
            com.google.common.base.i.d(d(k, v));
            return this.f6111a.put(k, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                com.google.common.base.i.d(d(entry.getKey(), entry.getValue()));
            }
            this.f6111a.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.f6111a.remove(obj);
            }
            return null;
        }
    }

    public static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final BiMap<A, B> bimap;

        public BiMapConverter(BiMap<A, B> biMap) {
            this.bimap = (BiMap) com.google.common.base.i.E(biMap);
        }

        private static <X, Y> Y convert(BiMap<X, Y> biMap, X x) {
            Y y = biMap.get(x);
            com.google.common.base.i.u(y != null, "No non-null mapping present for input: %s", x);
            return y;
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b) {
            return (A) convert(this.bimap.inverse(), b);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a2) {
            return (B) convert(this.bimap, a2);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) obj).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.bimap);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
            sb.append("Maps.asConverter(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    @GwtIncompatible
    public static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public transient Comparator<? super K> f31802a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public transient NavigableSet<K> f6112a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public transient Set<Map.Entry<K, V>> f6113a;

        public class a extends EntrySet<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public Map<K, V> b() {
                return DescendingMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return DescendingMap.this.entryIterator();
            }
        }

        public static <T> Ordering<T> u(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k) {
            return t().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@ParametricNullness K k) {
            return t().floorKey(k);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f31802a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = t().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering orderingU = u(comparator2);
            this.f31802a = orderingU;
            return orderingU;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return t().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return t();
        }

        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f6113a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setO = o();
            this.f6113a = setO;
            return setO;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return t().lastEntry();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K firstKey() {
            return t().lastKey();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> floorEntry(@ParametricNullness K k) {
            return t().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@ParametricNullness K k) {
            return t().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
            return t().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> higherEntry(@ParametricNullness K k) {
            return t().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@ParametricNullness K k) {
            return t().lowerKey(k);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return t().firstEntry();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K lastKey() {
            return t().firstKey();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@ParametricNullness K k) {
            return t().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@ParametricNullness K k) {
            return t().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f6112a;
            if (navigableSet != null) {
                return navigableSet;
            }
            x xVar = new x(this);
            this.f6112a = xVar;
            return xVar;
        }

        public Set<Map.Entry<K, V>> o() {
            return new a();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            return t().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            return t().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return t().subMap(k2, z2, k, z).descendingMap();
        }

        public abstract NavigableMap<K, V> t();

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
            return t().headMap(k, z).descendingMap();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Collection<V> values() {
            return new h0(this);
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Map<K, V> delegate() {
            return t();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(@ParametricNullness K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(@ParametricNullness K k) {
            return tailMap(k, true);
        }
    }

    public enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.base.Function
            @CheckForNull
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.base.Function
            @CheckForNull
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(e eVar) {
            this();
        }
    }

    public static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        public abstract Map<K, V> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object objP0 = Maps.p0(b(), key);
            if (com.google.common.base.g.a(objP0, entry.getValue())) {
                return objP0 != null || b().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return b().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.i.E(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.J(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.i.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetY = Sets.y(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetY.add(((Map.Entry) obj).getKey());
                    }
                }
                return b().keySet().retainAll(hashSetY);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        V2 a(@ParametricNullness K k, @ParametricNullness V1 v1);
    }

    public static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {

        public class a extends EntrySet<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public Map<K, V> b() {
                return IteratorBasedAbstractMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return IteratorBasedAbstractMap.this.b();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> b();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.h(b());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    public static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;

        @RetainedWith
        @CheckForNull
        BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;

        @CheckForNull
        transient Set<V> values;

        public UnmodifiableBiMap(BiMap<? extends K, ? extends V> biMap, @CheckForNull BiMap<V, K> biMap2) {
            this.unmodifiableMap = Collections.unmodifiableMap(biMap);
            this.delegate = biMap;
            this.inverse = biMap2;
        }

        @Override // com.google.common.collect.BiMap
        @CheckForNull
        public V forcePut(@ParametricNullness K k, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap = this.inverse;
            if (biMap != null) {
                return biMap;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            Set<V> setUnmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
            this.values = setUnmodifiableSet;
            return setUnmodifiableSet;
        }
    }

    @GwtIncompatible
    public static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, ? extends V> delegate;

        @CheckForNull
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k) {
            return Maps.M0(this.delegate.ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@ParametricNullness K k) {
            return this.delegate.ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.O(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return Maps.M0(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> floorEntry(@ParametricNullness K k) {
            return Maps.M0(this.delegate.floorEntry(k));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@ParametricNullness K k) {
            return this.delegate.floorKey(k);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> headMap(@ParametricNullness K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> higherEntry(@ParametricNullness K k) {
            return Maps.M0(this.delegate.higherEntry(k));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@ParametricNullness K k) {
            return this.delegate.higherKey(k);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return Maps.M0(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@ParametricNullness K k) {
            return Maps.M0(this.delegate.lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@ParametricNullness K k) {
            return this.delegate.lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.O(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(@ParametricNullness K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
            return Maps.L0(this.delegate.headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return Maps.L0(this.delegate.subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
            return Maps.L0(this.delegate.tailMap(k, z));
        }

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }
    }

    @GwtCompatible
    public static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public transient Collection<V> f31805a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public transient Set<Map.Entry<K, V>> f6114a;

        @CheckForNull
        public transient Set<K> b;

        /* JADX INFO: renamed from: b */
        public Set<K> g() {
            return new u(this);
        }

        public Collection<V> c() {
            return new h0(this);
        }

        public abstract Set<Map.Entry<K, V>> createEntrySet();

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f6114a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setCreateEntrySet = createEntrySet();
            this.f6114a = setCreateEntrySet;
            return setCreateEntrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<K> h() {
            Set<K> set = this.b;
            if (set != null) {
                return set;
            }
            Set<K> setG = g();
            this.b = setG;
            return setG;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f31805a;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionC = c();
            this.f31805a = collectionC;
            return collectionC;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V1, V2] */
    public class a<V1, V2> implements Function<V1, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EntryTransformer f31806a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6115a;

        public a(EntryTransformer entryTransformer, Object obj) {
            this.f31806a = entryTransformer;
            this.f6115a = obj;
        }

        @Override // com.google.common.base.Function
        @ParametricNullness
        public V2 apply(@ParametricNullness V1 v1) {
            return (V2) this.f31806a.a(this.f6115a, v1);
        }
    }

    public static class a0<K, V> extends v<K, V> implements SortedMapDifference<K, V> {
        public a0(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        @Override // com.google.common.collect.Maps.v, com.google.common.collect.MapDifference, com.google.common.collect.SortedMapDifference
        /* JADX INFO: renamed from: e */
        public SortedMap<K, V> b() {
            return (SortedMap) super.b();
        }

        @Override // com.google.common.collect.Maps.v, com.google.common.collect.MapDifference, com.google.common.collect.SortedMapDifference
        /* JADX INFO: renamed from: f */
        public SortedMap<K, V> c() {
            return (SortedMap) super.c();
        }

        @Override // com.google.common.collect.Maps.v, com.google.common.collect.MapDifference, com.google.common.collect.SortedMapDifference
        /* JADX INFO: renamed from: g */
        public SortedMap<K, MapDifference.ValueDifference<V>> a() {
            return (SortedMap) super.a();
        }

        @Override // com.google.common.collect.Maps.v, com.google.common.collect.MapDifference, com.google.common.collect.SortedMapDifference
        /* JADX INFO: renamed from: h */
        public SortedMap<K, V> d() {
            return (SortedMap) super.d();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    public class b<K, V1, V2> implements Function<Map.Entry<K, V1>, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EntryTransformer f31807a;

        public b(EntryTransformer entryTransformer) {
            this.f31807a = entryTransformer;
        }

        @Override // com.google.common.base.Function
        @ParametricNullness
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public V2 apply(Map.Entry<K, V1> entry) {
            return (V2) this.f31807a.a(entry.getKey(), entry.getValue());
        }
    }

    public static class b0<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EntryTransformer<? super K, ? super V1, V2> f31808a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<K, V1> f6116a;

        public b0(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.f6116a = (Map) com.google.common.base.i.E(map);
            this.f31808a = (EntryTransformer) com.google.common.base.i.E(entryTransformer);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V2>> b() {
            return Iterators.c0(this.f6116a.entrySet().iterator(), Maps.g(this.f31808a));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f6116a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f6116a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V2 get(@CheckForNull Object obj) {
            V1 v1 = this.f6116a.get(obj);
            if (v1 != null || this.f6116a.containsKey(obj)) {
                return this.f31808a.a(obj, (Object) com.google.common.collect.q.a(v1));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f6116a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V2 remove(@CheckForNull Object obj) {
            if (this.f6116a.containsKey(obj)) {
                return this.f31808a.a(obj, (Object) com.google.common.collect.q.a(this.f6116a.remove(obj)));
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f6116a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new h0(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V2] */
    public class c<K, V2> extends AbstractMapEntry<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EntryTransformer f31809a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map.Entry f6117a;

        public c(Map.Entry entry, EntryTransformer entryTransformer) {
            this.f6117a = entry;
            this.f31809a = entryTransformer;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return (K) this.f6117a.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V2 getValue() {
            return (V2) this.f31809a.a(this.f6117a.getKey(), this.f6117a.getValue());
        }
    }

    @GwtIncompatible
    public static class c0<K, V1, V2> extends d0<K, V1, V2> implements NavigableMap<K, V2> {
        public c0(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(navigableMap, entryTransformer);
        }

        @Override // com.google.common.collect.Maps.d0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> headMap(@ParametricNullness K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> ceilingEntry(@ParametricNullness K k) {
            return f(fromMap().ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@ParametricNullness K k) {
            return fromMap().ceilingKey(k);
        }

        @Override // com.google.common.collect.Maps.d0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return fromMap().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> descendingMap() {
            return Maps.y0(fromMap().descendingMap(), ((b0) this).f31808a);
        }

        @Override // com.google.common.collect.Maps.d0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> tailMap(@ParametricNullness K k) {
            return tailMap(k, true);
        }

        @CheckForNull
        public final Map.Entry<K, V2> f(@CheckForNull Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return Maps.A0(((b0) this).f31808a, entry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> firstEntry() {
            return f(fromMap().firstEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> floorEntry(@ParametricNullness K k) {
            return f(fromMap().floorEntry(k));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@ParametricNullness K k) {
            return fromMap().floorKey(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> higherEntry(@ParametricNullness K k) {
            return f(fromMap().higherEntry(k));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@ParametricNullness K k) {
            return fromMap().higherKey(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> lastEntry() {
            return f(fromMap().lastEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> lowerEntry(@ParametricNullness K k) {
            return f(fromMap().lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@ParametricNullness K k) {
            return fromMap().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return fromMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> pollFirstEntry() {
            return f(fromMap().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V2> pollLastEntry() {
            return f(fromMap().pollLastEntry());
        }

        @Override // com.google.common.collect.Maps.d0
        public NavigableMap<K, V1> fromMap() {
            return (NavigableMap) super.fromMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> headMap(@ParametricNullness K k, boolean z) {
            return Maps.y0(fromMap().headMap(k, z), ((b0) this).f31808a);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return Maps.y0(fromMap().subMap(k, z, k2, z2), ((b0) this).f31808a);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(@ParametricNullness K k, boolean z) {
            return Maps.y0(fromMap().tailMap(k, z), ((b0) this).f31808a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    public class d<K, V1, V2> implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EntryTransformer f31810a;

        public d(EntryTransformer entryTransformer) {
            this.f31810a = entryTransformer;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return Maps.A0(this.f31810a, entry);
        }
    }

    public static class d0<K, V1, V2> extends b0<K, V1, V2> implements SortedMap<K, V2> {
        public d0(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return fromMap().comparator();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K firstKey() {
            return fromMap().firstKey();
        }

        public SortedMap<K, V1> fromMap() {
            return (SortedMap) ((b0) this).f6116a;
        }

        public SortedMap<K, V2> headMap(@ParametricNullness K k) {
            return Maps.z0(fromMap().headMap(k), ((b0) this).f31808a);
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K lastKey() {
            return fromMap().lastKey();
        }

        public SortedMap<K, V2> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return Maps.z0(fromMap().subMap(k, k2), ((b0) this).f31808a);
        }

        public SortedMap<K, V2> tailMap(@ParametricNullness K k) {
            return Maps.z0(fromMap().tailMap(k), ((b0) this).f31808a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class e<K, V> extends TransformedIterator<Map.Entry<K, V>, K> {
        public e(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.TransformedIterator
        @ParametricNullness
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    public static class e0<K, V> extends ForwardingCollection<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<Map.Entry<K, V>> f31811a;

        public e0(Collection<Map.Entry<K, V>> collection) {
            this.f31811a = collection;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.I0(this.f31811a.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return this.f31811a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class f<K, V> extends TransformedIterator<Map.Entry<K, V>, V> {
        public f(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.TransformedIterator
        @ParametricNullness
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    public static class f0<K, V> extends e0<K, V> implements Set<Map.Entry<K, V>> {
        public f0(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.k(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class g<K, V> extends TransformedIterator<K, Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f31812a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Iterator it, Function function) {
            super(it);
            this.f31812a = function;
        }

        @Override // com.google.common.collect.TransformedIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(@ParametricNullness K k) {
            return Maps.O(k, this.f31812a.apply(k));
        }
    }

    public static class g0<V> implements MapDifference.ValueDifference<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final V f31813a;

        @ParametricNullness
        public final V b;

        public g0(@ParametricNullness V v, @ParametricNullness V v2) {
            this.f31813a = v;
            this.b = v2;
        }

        public static <V> MapDifference.ValueDifference<V> c(@ParametricNullness V v, @ParametricNullness V v2) {
            return new g0(v, v2);
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        @ParametricNullness
        public V a() {
            return this.f31813a;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        @ParametricNullness
        public V b() {
            return this.b;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof MapDifference.ValueDifference)) {
                return false;
            }
            MapDifference.ValueDifference valueDifference = (MapDifference.ValueDifference) obj;
            return com.google.common.base.g.a(this.f31813a, valueDifference.a()) && com.google.common.base.g.a(this.b, valueDifference.b());
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public int hashCode() {
            return com.google.common.base.g.b(this.f31813a, this.b);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f31813a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 4 + strValueOf2.length());
            sb.append("(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class h0<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final Map<K, V> f31815a;

        public h0(Map<K, V> map) {
            this.f31815a = (Map) com.google.common.base.i.E(map);
        }

        public final Map<K, V> b() {
            return this.f31815a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            return b().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.O0(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (com.google.common.base.g.a(obj, entry.getValue())) {
                        b().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.i.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetU = Sets.u();
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetU.add(entry.getKey());
                    }
                }
                return b().keySet().removeAll(hashSetU);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.i.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetU = Sets.u();
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetU.add(entry.getKey());
                    }
                }
                return b().keySet().retainAll(hashSetU);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b().size();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class j<E> extends ForwardingNavigableSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigableSet f31817a;

        public j(NavigableSet navigableSet) {
            this.f31817a = navigableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness E e) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Maps.l0(super.descendingSet());
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(@ParametricNullness E e) {
            return Maps.n0(super.headSet(e));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
            return Maps.n0(super.subSet(e, e2));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(@ParametricNullness E e) {
            return Maps.n0(super.tailSet(e));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E e, boolean z) {
            return Maps.l0(super.headSet(e, z));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
            return Maps.l0(super.subSet(e, z, e2, z2));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E e, boolean z) {
            return Maps.l0(super.tailSet(e, z));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public NavigableSet<E> delegate() {
            return this.f31817a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class k<K, V> extends AbstractMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f31818a;

        public k(Map.Entry entry) {
            this.f31818a = entry;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return (K) this.f31818a.getKey();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            return (V) this.f31818a.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class l<K, V> extends UnmodifiableIterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f31819a;

        public l(Iterator it) {
            this.f31819a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return Maps.H0((Map.Entry) this.f31819a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31819a.hasNext();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    public class m<K, V1, V2> implements EntryTransformer<K, V1, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f31820a;

        public m(Function function) {
            this.f31820a = function;
        }

        @Override // com.google.common.collect.Maps.EntryTransformer
        @ParametricNullness
        public V2 a(@ParametricNullness K k, @ParametricNullness V1 v1) {
            return (V2) this.f31820a.apply(v1);
        }
    }

    public static class n<K, V> extends ViewCachingAbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function<? super K, V> f31821a;
        public final Set<K> c;

        public class a extends EntrySet<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public Map<K, V> b() {
                return n.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return Maps.m(n.this.d(), n.this.f31821a);
            }
        }

        public n(Set<K> set, Function<? super K, V> function) {
            this.c = (Set) com.google.common.base.i.E(set);
            this.f31821a = (Function) com.google.common.base.i.E(function);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        public Set<K> g() {
            return Maps.m0(d());
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<V> c() {
            return com.google.common.collect.b.m(this.c, this.f31821a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return d().contains(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new a();
        }

        public Set<K> d() {
            return this.c;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (com.google.common.collect.b.j(d(), obj)) {
                return this.f31821a.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            if (d().remove(obj)) {
                return this.f31821a.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return d().size();
        }
    }

    public static final class o<K, V> extends p<K, V> implements BiMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @RetainedWith
        public final BiMap<V, K> f31823a;

        public class a implements Predicate<Map.Entry<V, K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Predicate f31824a;

            public a(Predicate predicate) {
                this.f31824a = predicate;
            }

            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Map.Entry<V, K> entry) {
                return this.f31824a.apply(Maps.O(entry.getValue(), entry.getKey()));
            }
        }

        public o(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(biMap, predicate);
            this.f31823a = new o(biMap.inverse(), g(predicate), this);
        }

        public static <K, V> Predicate<Map.Entry<V, K>> g(Predicate<? super Map.Entry<K, V>> predicate) {
            return new a(predicate);
        }

        @Override // com.google.common.collect.BiMap
        @CheckForNull
        public V forcePut(@ParametricNullness K k, @ParametricNullness V v) {
            com.google.common.base.i.d(d(k, v));
            return h().forcePut(k, v);
        }

        public BiMap<K, V> h() {
            return (BiMap) ((AbstractFilteredMap) this).f6111a;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            return this.f31823a;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<V> values() {
            return this.f31823a.keySet();
        }

        public o(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate, BiMap<V, K> biMap2) {
            super(biMap, predicate);
            this.f31823a = biMap2;
        }
    }

    public static class p<K, V> extends AbstractFilteredMap<K, V> {
        public final Set<Map.Entry<K, V>> c;

        public class a extends ForwardingSet<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: com.google.common.collect.Maps$p$a$a, reason: collision with other inner class name */
            public class C0718a extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>> {

                /* JADX INFO: renamed from: com.google.common.collect.Maps$p$a$a$a, reason: collision with other inner class name */
                public class C0719a extends ForwardingMapEntry<K, V> {

                    /* JADX INFO: renamed from: a, reason: collision with other field name */
                    public final /* synthetic */ Map.Entry f6118a;

                    public C0719a(Map.Entry entry) {
                        this.f6118a = entry;
                    }

                    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                    @ParametricNullness
                    public V setValue(@ParametricNullness V v) {
                        com.google.common.base.i.d(p.this.d(getKey(), v));
                        return (V) super.setValue(v);
                    }

                    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                    public Map.Entry<K, V> delegate() {
                        return this.f6118a;
                    }
                }

                public C0718a(Iterator it) {
                    super(it);
                }

                @Override // com.google.common.collect.TransformedIterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> a(Map.Entry<K, V> entry) {
                    return new C0719a(entry);
                }
            }

            public a() {
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new C0718a(p.this.c.iterator());
            }

            public /* synthetic */ a(p pVar, e eVar) {
                this();
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set<Map.Entry<K, V>> delegate() {
                return p.this.c;
            }
        }

        public class b extends u<K, V> {
            public b() {
                super(p.this);
            }

            @Override // com.google.common.collect.Maps.u, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!p.this.containsKey(obj)) {
                    return false;
                }
                ((AbstractFilteredMap) p.this).f6111a.remove(obj);
                return true;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                p pVar = p.this;
                return p.e(((AbstractFilteredMap) pVar).f6111a, ((AbstractFilteredMap) pVar).f31801a, collection);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                p pVar = p.this;
                return p.f(((AbstractFilteredMap) pVar).f6111a, ((AbstractFilteredMap) pVar).f31801a, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return Lists.s(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) Lists.s(iterator()).toArray(tArr);
            }
        }

        public p(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
            super(map, predicate);
            this.c = Sets.i(map.entrySet(), ((AbstractFilteredMap) this).f31801a);
        }

        public static <K, V> boolean e(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public static <K, V> boolean f(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        public Set<K> g() {
            return new b();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new a(this, null);
        }
    }

    @GwtIncompatible
    public static class q<K, V> extends AbstractNavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Predicate<? super Map.Entry<K, V>> f31829a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<K, V> f6119a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final NavigableMap<K, V> f6120a;

        public class a extends x<K, V> {
            public a(NavigableMap navigableMap) {
                super(navigableMap);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return p.e(q.this.f6120a, q.this.f31829a, collection);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return p.f(q.this.f6120a, q.this.f31829a, collection);
            }
        }

        public q(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
            this.f6120a = (NavigableMap) com.google.common.base.i.E(navigableMap);
            this.f31829a = predicate;
            this.f6119a = new p(navigableMap, predicate);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V>> b() {
            return Iterators.x(this.f6120a.entrySet().iterator(), this.f31829a);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<K, V>> c() {
            return Iterators.x(this.f6120a.descendingMap().entrySet().iterator(), this.f31829a);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f6119a.clear();
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return this.f6120a.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f6119a.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.z(this.f6120a.descendingMap(), this.f31829a);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return this.f6119a.entrySet();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            return this.f6119a.get(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
            return Maps.z(this.f6120a.headMap(k, z), this.f31829a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !com.google.common.collect.o.c(this.f6120a.entrySet(), this.f31829a);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new a(this);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) com.google.common.collect.o.I(this.f6120a.entrySet(), this.f31829a);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) com.google.common.collect.o.I(this.f6120a.descendingMap().entrySet(), this.f31829a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(@ParametricNullness K k, @ParametricNullness V v) {
            return this.f6119a.put(k, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f6119a.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            return this.f6119a.remove(obj);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f6119a.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return Maps.z(this.f6120a.subMap(k, z, k2, z2), this.f31829a);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
            return Maps.z(this.f6120a.tailMap(k, z), this.f31829a);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new t(this, this.f6120a, this.f31829a);
        }
    }

    public static class r<K, V> extends p<K, V> implements SortedMap<K, V> {

        public class a extends p<K, V>.b implements SortedSet<K> {
            public a() {
                super();
            }

            @Override // java.util.SortedSet
            @CheckForNull
            public Comparator<? super K> comparator() {
                return r.this.i().comparator();
            }

            @Override // java.util.SortedSet
            @ParametricNullness
            public K first() {
                return (K) r.this.firstKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> headSet(@ParametricNullness K k) {
                return (SortedSet) r.this.headMap(k).keySet();
            }

            @Override // java.util.SortedSet
            @ParametricNullness
            public K last() {
                return (K) r.this.lastKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
                return (SortedSet) r.this.subMap(k, k2).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> tailSet(@ParametricNullness K k) {
                return (SortedSet) r.this.tailMap(k).keySet();
            }
        }

        public r(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(sortedMap, predicate);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K firstKey() {
            return h().iterator().next();
        }

        @Override // com.google.common.collect.Maps.p, com.google.common.collect.Maps.ViewCachingAbstractMap
        public SortedSet<K> g() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<K> h() {
            return (SortedSet) super.h();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(@ParametricNullness K k) {
            return new r(i().headMap(k), ((AbstractFilteredMap) this).f31801a);
        }

        public SortedMap<K, V> i() {
            return (SortedMap) ((AbstractFilteredMap) this).f6111a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        @ParametricNullness
        public K lastKey() {
            SortedMap<K, V> sortedMapI = i();
            while (true) {
                K kLastKey = sortedMapI.lastKey();
                if (d(kLastKey, com.google.common.collect.q.a(((AbstractFilteredMap) this).f6111a.get(kLastKey)))) {
                    return kLastKey;
                }
                sortedMapI = i().headMap(kLastKey);
            }
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return new r(i().subMap(k, k2), ((AbstractFilteredMap) this).f31801a);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(@ParametricNullness K k) {
            return new r(i().tailMap(k), ((AbstractFilteredMap) this).f31801a);
        }
    }

    public static class s<K, V> extends AbstractFilteredMap<K, V> {
        public final Predicate<? super K> b;

        public s(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super Map.Entry<K, V>> predicate2) {
            super(map, predicate2);
            this.b = predicate;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        public Set<K> g() {
            return Sets.i(((AbstractFilteredMap) this).f6111a.keySet(), this.b);
        }

        @Override // com.google.common.collect.Maps.AbstractFilteredMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return ((AbstractFilteredMap) this).f6111a.containsKey(obj) && this.b.apply(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return Sets.i(((AbstractFilteredMap) this).f6111a.entrySet(), ((AbstractFilteredMap) this).f31801a);
        }
    }

    public static final class t<K, V> extends h0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Predicate<? super Map.Entry<K, V>> f31832a;
        public final Map<K, V> b;

        public t(Map<K, V> map, Map<K, V> map2, Predicate<? super Map.Entry<K, V>> predicate) {
            super(map);
            this.b = map2;
            this.f31832a = predicate;
        }

        @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            Iterator<Map.Entry<K, V>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f31832a.apply(next) && com.google.common.base.g.a(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.b.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f31832a.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.b.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f31832a.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.s(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.s(iterator()).toArray(tArr);
        }
    }

    public static class u<K, V> extends Sets.ImprovedAbstractSet<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final Map<K, V> f31833a;

        public u(Map<K, V> map) {
            this.f31833a = (Map) com.google.common.base.i.E(map);
        }

        /* JADX INFO: renamed from: b */
        public Map<K, V> c() {
            return this.f31833a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return c().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return c().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.S(c().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return false;
            }
            c().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c().size();
        }
    }

    public static class v<K, V> implements MapDifference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V> f31834a;
        public final Map<K, V> b;
        public final Map<K, V> c;
        public final Map<K, MapDifference.ValueDifference<V>> d;

        public v(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, MapDifference.ValueDifference<V>> map4) {
            this.f31834a = Maps.K0(map);
            this.b = Maps.K0(map2);
            this.c = Maps.K0(map3);
            this.d = Maps.K0(map4);
        }

        @Override // com.google.common.collect.MapDifference, com.google.common.collect.SortedMapDifference
        public Map<K, MapDifference.ValueDifference<V>> a() {
            return this.d;
        }

        @Override // com.google.common.collect.MapDifference, com.google.common.collect.SortedMapDifference
        public Map<K, V> b() {
            return this.b;
        }

        @Override // com.google.common.collect.MapDifference, com.google.common.collect.SortedMapDifference
        public Map<K, V> c() {
            return this.f31834a;
        }

        @Override // com.google.common.collect.MapDifference, com.google.common.collect.SortedMapDifference
        public Map<K, V> d() {
            return this.c;
        }

        @Override // com.google.common.collect.MapDifference
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MapDifference)) {
                return false;
            }
            MapDifference mapDifference = (MapDifference) obj;
            return c().equals(mapDifference.c()) && b().equals(mapDifference.b()) && d().equals(mapDifference.d()) && a().equals(mapDifference.a());
        }

        @Override // com.google.common.collect.MapDifference
        public int hashCode() {
            return com.google.common.base.g.b(c(), b(), d(), a());
        }

        @Override // com.google.common.collect.MapDifference
        public boolean i() {
            return this.f31834a.isEmpty() && this.b.isEmpty() && this.d.isEmpty();
        }

        public String toString() {
            if (i()) {
                return "equal";
            }
            StringBuilder sb = new StringBuilder("not equal");
            if (!this.f31834a.isEmpty()) {
                sb.append(": only on left=");
                sb.append(this.f31834a);
            }
            if (!this.b.isEmpty()) {
                sb.append(": only on right=");
                sb.append(this.b);
            }
            if (!this.d.isEmpty()) {
                sb.append(": value differences=");
                sb.append(this.d);
            }
            return sb.toString();
        }
    }

    @GwtIncompatible
    public static final class w<K, V> extends AbstractNavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function<? super K, V> f31835a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final NavigableSet<K> f6121a;

        public w(NavigableSet<K> navigableSet, Function<? super K, V> function) {
            this.f6121a = (NavigableSet) com.google.common.base.i.E(navigableSet);
            this.f31835a = (Function) com.google.common.base.i.E(function);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V>> b() {
            return Maps.m(this.f6121a, this.f31835a);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<K, V>> c() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f6121a.clear();
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return this.f6121a.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.k(this.f6121a.descendingSet(), this.f31835a);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (com.google.common.collect.b.j(this.f6121a, obj)) {
                return this.f31835a.apply(obj);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
            return Maps.k(this.f6121a.headSet(k, z), this.f31835a);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Maps.l0(this.f6121a);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f6121a.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return Maps.k(this.f6121a.subSet(k, z, k2, z2), this.f31835a);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
            return Maps.k(this.f6121a.tailSet(k, z), this.f31835a);
        }
    }

    @GwtIncompatible
    public static class x<K, V> extends z<K, V> implements NavigableSet<K> {
        public x(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K ceiling(@ParametricNullness K k) {
            return b().ceilingKey(k);
        }

        @Override // com.google.common.collect.Maps.z
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> c() {
            return (NavigableMap) this.f31833a;
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return b().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K floor(@ParametricNullness K k) {
            return b().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(@ParametricNullness K k, boolean z) {
            return b().headMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K higher(@ParametricNullness K k) {
            return b().higherKey(k);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K lower(@ParametricNullness K k) {
            return b().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollFirst() {
            return (K) Maps.T(b().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollLast() {
            return (K) Maps.T(b().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return b().subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(@ParametricNullness K k, boolean z) {
            return b().tailMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.z, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(@ParametricNullness K k) {
            return headSet(k, false);
        }

        @Override // com.google.common.collect.Maps.z, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.Maps.z, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(@ParametricNullness K k) {
            return tailSet(k, true);
        }
    }

    public static class y<K, V> extends n<K, V> implements SortedMap<K, V> {
        public y(SortedSet<K> sortedSet, Function<? super K, V> function) {
            super(sortedSet, function);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return d().comparator();
        }

        @Override // com.google.common.collect.Maps.n
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public SortedSet<K> d() {
            return (SortedSet) super.d();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K firstKey() {
            return d().first();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(@ParametricNullness K k) {
            return Maps.l(d().headSet(k), ((n) this).f31821a);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<K> h() {
            return Maps.n0(d());
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K lastKey() {
            return d().last();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return Maps.l(d().subSet(k, k2), ((n) this).f31821a);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(@ParametricNullness K k) {
            return Maps.l(d().tailSet(k), ((n) this).f31821a);
        }
    }

    public static class z<K, V> extends u<K, V> implements SortedSet<K> {
        public z(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // com.google.common.collect.Maps.u
        public SortedMap<K, V> c() {
            return (SortedMap) super.c();
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public K first() {
            return c().firstKey();
        }

        public SortedSet<K> headSet(@ParametricNullness K k) {
            return new z(c().headMap(k));
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
            return new z(c().subMap(k, k2));
        }

        public SortedSet<K> tailSet(@ParametricNullness K k) {
            return new z(c().tailMap(k));
        }
    }

    public static <K, V> SortedMap<K, V> A(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        com.google.common.base.i.E(predicate);
        return sortedMap instanceof r ? E((r) sortedMap, predicate) : new r((SortedMap) com.google.common.base.i.E(sortedMap), predicate);
    }

    public static <V2, K, V1> Map.Entry<K, V2> A0(EntryTransformer<? super K, ? super V1, V2> entryTransformer, Map.Entry<K, V1> entry) {
        com.google.common.base.i.E(entryTransformer);
        com.google.common.base.i.E(entry);
        return new c(entry, entryTransformer);
    }

    public static <K, V> BiMap<K, V> B(o<K, V> oVar, Predicate<? super Map.Entry<K, V>> predicate) {
        return new o(oVar.h(), Predicates.d(((AbstractFilteredMap) oVar).f31801a, predicate));
    }

    public static <K, V1, V2> Map<K, V2> B0(Map<K, V1> map, Function<? super V1, V2> function) {
        return x0(map, i(function));
    }

    public static <K, V> Map<K, V> C(AbstractFilteredMap<K, V> abstractFilteredMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new p(abstractFilteredMap.f6111a, Predicates.d(abstractFilteredMap.f31801a, predicate));
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> C0(NavigableMap<K, V1> navigableMap, Function<? super V1, V2> function) {
        return y0(navigableMap, i(function));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> D(q<K, V> qVar, Predicate<? super Map.Entry<K, V>> predicate) {
        return new q(qVar.f6120a, Predicates.d(qVar.f31829a, predicate));
    }

    public static <K, V1, V2> SortedMap<K, V2> D0(SortedMap<K, V1> sortedMap, Function<? super V1, V2> function) {
        return z0(sortedMap, i(function));
    }

    public static <K, V> SortedMap<K, V> E(r<K, V> rVar, Predicate<? super Map.Entry<K, V>> predicate) {
        return new r(rVar.i(), Predicates.d(((AbstractFilteredMap) rVar).f31801a, predicate));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> E0(Iterable<V> iterable, Function<? super V, K> function) {
        return F0(iterable.iterator(), function);
    }

    public static <K, V> BiMap<K, V> F(BiMap<K, V> biMap, Predicate<? super K> predicate) {
        com.google.common.base.i.E(predicate);
        return x(biMap, U(predicate));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> F0(Iterator<V> it, Function<? super V, K> function) {
        com.google.common.base.i.E(function);
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        while (it.hasNext()) {
            V next = it.next();
            bVarBuilder.f(function.apply(next), next);
        }
        try {
            return bVarBuilder.a();
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(String.valueOf(e2.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
        }
    }

    public static <K, V> Map<K, V> G(Map<K, V> map, Predicate<? super K> predicate) {
        com.google.common.base.i.E(predicate);
        Predicate predicateU = U(predicate);
        return map instanceof AbstractFilteredMap ? C((AbstractFilteredMap) map, predicateU) : new s((Map) com.google.common.base.i.E(map), predicate, predicateU);
    }

    public static <K, V> BiMap<K, V> G0(BiMap<? extends K, ? extends V> biMap) {
        return new UnmodifiableBiMap(biMap, null);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> H(NavigableMap<K, V> navigableMap, Predicate<? super K> predicate) {
        return z(navigableMap, U(predicate));
    }

    public static <K, V> Map.Entry<K, V> H0(Map.Entry<? extends K, ? extends V> entry) {
        com.google.common.base.i.E(entry);
        return new k(entry);
    }

    public static <K, V> SortedMap<K, V> I(SortedMap<K, V> sortedMap, Predicate<? super K> predicate) {
        return A(sortedMap, U(predicate));
    }

    public static <K, V> UnmodifiableIterator<Map.Entry<K, V>> I0(Iterator<Map.Entry<K, V>> it) {
        return new l(it);
    }

    public static <K, V> BiMap<K, V> J(BiMap<K, V> biMap, Predicate<? super V> predicate) {
        return x(biMap, Q0(predicate));
    }

    public static <K, V> Set<Map.Entry<K, V>> J0(Set<Map.Entry<K, V>> set) {
        return new f0(Collections.unmodifiableSet(set));
    }

    public static <K, V> Map<K, V> K(Map<K, V> map, Predicate<? super V> predicate) {
        return y(map, Q0(predicate));
    }

    public static <K, V> Map<K, V> K0(Map<K, ? extends V> map) {
        return map instanceof SortedMap ? Collections.unmodifiableSortedMap((SortedMap) map) : Collections.unmodifiableMap(map);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> L(NavigableMap<K, V> navigableMap, Predicate<? super V> predicate) {
        return z(navigableMap, Q0(predicate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> L0(NavigableMap<K, ? extends V> navigableMap) {
        com.google.common.base.i.E(navigableMap);
        return navigableMap instanceof UnmodifiableNavigableMap ? navigableMap : new UnmodifiableNavigableMap(navigableMap);
    }

    public static <K, V> SortedMap<K, V> M(SortedMap<K, V> sortedMap, Predicate<? super V> predicate) {
        return A(sortedMap, Q0(predicate));
    }

    @CheckForNull
    public static <K, V> Map.Entry<K, V> M0(@CheckForNull Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return H0(entry);
    }

    @GwtIncompatible
    public static ImmutableMap<String, String> N(Properties properties) {
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            Object objNextElement = enumerationPropertyNames.nextElement();
            Objects.requireNonNull(objNextElement);
            String str = (String) objNextElement;
            String property = properties.getProperty(str);
            Objects.requireNonNull(property);
            bVarBuilder.f(str, property);
        }
        return bVarBuilder.a();
    }

    public static <V> Function<Map.Entry<?, V>, V> N0() {
        return EntryFunction.VALUE;
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> O(@ParametricNullness K k2, @ParametricNullness V v2) {
        return new ImmutableEntry(k2, v2);
    }

    public static <K, V> Iterator<V> O0(Iterator<Map.Entry<K, V>> it) {
        return new f(it);
    }

    @GwtCompatible(serializable = true)
    public static <K extends Enum<K>, V> ImmutableMap<K, V> P(Map<K, ? extends V> map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return ImmutableMap.of();
        }
        Map.Entry<K, ? extends V> next = it.next();
        K key = next.getKey();
        V value = next.getValue();
        com.google.common.collect.a.a(key, value);
        EnumMap enumMap = new EnumMap(key.getDeclaringClass());
        enumMap.put((Enum) key, (Object) value);
        while (it.hasNext()) {
            Map.Entry<K, ? extends V> next2 = it.next();
            K key2 = next2.getKey();
            V value2 = next2.getValue();
            com.google.common.collect.a.a(key2, value2);
            enumMap.put((Enum) key2, (Object) value2);
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }

    @CheckForNull
    public static <V> V P0(@CheckForNull Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <E> ImmutableMap<E, Integer> Q(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        Iterator<E> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            bVar.f(it.next(), Integer.valueOf(i2));
            i2++;
        }
        return bVar.a();
    }

    public static <V> Predicate<Map.Entry<?, V>> Q0(Predicate<? super V> predicate) {
        return Predicates.h(predicate, N0());
    }

    public static <K> Function<Map.Entry<K, ?>, K> R() {
        return EntryFunction.KEY;
    }

    public static <K, V> Iterator<K> S(Iterator<Map.Entry<K, V>> it) {
        return new e(it);
    }

    @CheckForNull
    public static <K> K T(@CheckForNull Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> Predicate<Map.Entry<K, ?>> U(Predicate<? super K> predicate) {
        return Predicates.h(predicate, R());
    }

    public static <K, V> ConcurrentMap<K, V> V() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> W(Class<K> cls) {
        return new EnumMap<>((Class) com.google.common.base.i.E(cls));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> X(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> HashMap<K, V> Y() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> Z(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> HashMap<K, V> a0(int i2) {
        return new HashMap<>(o(i2));
    }

    public static <K, V> IdentityHashMap<K, V> b0() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> c0() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> d0(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> e0(int i2) {
        return new LinkedHashMap<>(o(i2));
    }

    public static <A, B> Converter<A, B> f(BiMap<A, B> biMap) {
        return new BiMapConverter(biMap);
    }

    public static <K extends Comparable, V> TreeMap<K, V> f0() {
        return new TreeMap<>();
    }

    public static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> g(EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        com.google.common.base.i.E(entryTransformer);
        return new d(entryTransformer);
    }

    public static <C, K extends C, V> TreeMap<K, V> g0(@CheckForNull Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    public static <K, V1, V2> Function<Map.Entry<K, V1>, V2> h(EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        com.google.common.base.i.E(entryTransformer);
        return new b(entryTransformer);
    }

    public static <K, V> TreeMap<K, V> h0(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>((SortedMap) sortedMap);
    }

    public static <K, V1, V2> EntryTransformer<K, V1, V2> i(Function<? super V1, V2> function) {
        com.google.common.base.i.E(function);
        return new m(function);
    }

    public static <E> Comparator<? super E> i0(@CheckForNull Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.natural();
    }

    public static <K, V> Map<K, V> j(Set<K> set, Function<? super K, V> function) {
        return new n(set, function);
    }

    public static <K, V> void j0(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> k(NavigableSet<K> navigableSet, Function<? super K, V> function) {
        return new w(navigableSet, function);
    }

    public static <K, V> boolean k0(Collection<Map.Entry<K, V>> collection, @CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(H0((Map.Entry) obj));
        }
        return false;
    }

    public static <K, V> SortedMap<K, V> l(SortedSet<K> sortedSet, Function<? super K, V> function) {
        return new y(sortedSet, function);
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> l0(NavigableSet<E> navigableSet) {
        return new j(navigableSet);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> m(Set<K> set, Function<? super K, V> function) {
        return new g(set.iterator(), function);
    }

    public static <E> Set<E> m0(Set<E> set) {
        return new h(set);
    }

    public static <K, V1, V2> Function<V1, V2> n(EntryTransformer<? super K, V1, V2> entryTransformer, @ParametricNullness K k2) {
        com.google.common.base.i.E(entryTransformer);
        return new a(entryTransformer, k2);
    }

    public static <E> SortedSet<E> n0(SortedSet<E> sortedSet) {
        return new i(sortedSet);
    }

    public static int o(int i2) {
        if (i2 < 3) {
            com.google.common.collect.a.b(i2, "expectedSize");
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean o0(Map<?, ?> map, @CheckForNull Object obj) {
        com.google.common.base.i.E(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <K, V> boolean p(Collection<Map.Entry<K, V>> collection, @CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(H0((Map.Entry) obj));
        }
        return false;
    }

    @CheckForNull
    public static <V> V p0(Map<?, V> map, @CheckForNull Object obj) {
        com.google.common.base.i.E(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static boolean q(Map<?, ?> map, @CheckForNull Object obj) {
        return Iterators.q(S(map.entrySet().iterator()), obj);
    }

    @CheckForNull
    public static <V> V q0(Map<?, V> map, @CheckForNull Object obj) {
        com.google.common.base.i.E(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static boolean r(Map<?, ?> map, @CheckForNull Object obj) {
        return Iterators.q(O0(map.entrySet().iterator()), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> r0(NavigableMap<K, V> navigableMap, Range<K> range) {
        if (navigableMap.comparator() != null && navigableMap.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            com.google.common.base.i.e(navigableMap.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            Comparable comparableLowerEndpoint = range.lowerEndpoint();
            BoundType boundTypeLowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            return navigableMap.subMap(comparableLowerEndpoint, boundTypeLowerBoundType == boundType, range.upperEndpoint(), range.upperBoundType() == boundType);
        }
        if (range.hasLowerBound()) {
            return navigableMap.tailMap(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED);
        }
        if (range.hasUpperBound()) {
            return navigableMap.headMap(range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        }
        return (NavigableMap) com.google.common.base.i.E(navigableMap);
    }

    public static <K, V> MapDifference<K, V> s(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        return map instanceof SortedMap ? u((SortedMap) map, map2) : t(map, map2, Equivalence.equals());
    }

    public static <K, V> BiMap<K, V> s0(BiMap<K, V> biMap) {
        return Synchronized.g(biMap, null);
    }

    public static <K, V> MapDifference<K, V> t(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence) {
        com.google.common.base.i.E(equivalence);
        LinkedHashMap linkedHashMapC0 = c0();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap linkedHashMapC1 = c0();
        LinkedHashMap linkedHashMapC2 = c0();
        v(map, map2, equivalence, linkedHashMapC0, linkedHashMap, linkedHashMapC1, linkedHashMapC2);
        return new v(linkedHashMapC0, linkedHashMap, linkedHashMapC1, linkedHashMapC2);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> t0(NavigableMap<K, V> navigableMap) {
        return Synchronized.o(navigableMap);
    }

    public static <K, V> SortedMapDifference<K, V> u(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        com.google.common.base.i.E(sortedMap);
        com.google.common.base.i.E(map);
        Comparator comparatorI0 = i0(sortedMap.comparator());
        TreeMap treeMapG0 = g0(comparatorI0);
        TreeMap treeMapG1 = g0(comparatorI0);
        treeMapG1.putAll(map);
        TreeMap treeMapG2 = g0(comparatorI0);
        TreeMap treeMapG3 = g0(comparatorI0);
        v(sortedMap, map, Equivalence.equals(), treeMapG0, treeMapG1, treeMapG2, treeMapG3);
        return new a0(treeMapG0, treeMapG1, treeMapG2, treeMapG3);
    }

    public static <K, V> ImmutableMap<K, V> u0(Iterable<K> iterable, Function<? super K, V> function) {
        return v0(iterable.iterator(), function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void v(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, MapDifference.ValueDifference<V>> map6) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (map2.containsKey(key)) {
                XI.K0 k0 = (Object) com.google.common.collect.q.a(map4.remove(key));
                if (equivalence.equivalent(value, k0)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, g0.c(value, k0));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    public static <K, V> ImmutableMap<K, V> v0(Iterator<K> it, Function<? super K, V> function) {
        com.google.common.base.i.E(function);
        LinkedHashMap linkedHashMapC0 = c0();
        while (it.hasNext()) {
            K next = it.next();
            linkedHashMapC0.put(next, function.apply(next));
        }
        return ImmutableMap.copyOf((Map) linkedHashMapC0);
    }

    public static boolean w(Map<?, ?> map, @CheckForNull Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static String w0(Map<?, ?> map) {
        StringBuilder sbF = com.google.common.collect.b.f(map.size());
        sbF.append('{');
        boolean z2 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z2) {
                sbF.append(", ");
            }
            sbF.append(entry.getKey());
            sbF.append(com.alipay.sdk.m.p.a.h);
            sbF.append(entry.getValue());
            z2 = false;
        }
        sbF.append('}');
        return sbF.toString();
    }

    public static <K, V> BiMap<K, V> x(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
        com.google.common.base.i.E(biMap);
        com.google.common.base.i.E(predicate);
        return biMap instanceof o ? B((o) biMap, predicate) : new o(biMap, predicate);
    }

    public static <K, V1, V2> Map<K, V2> x0(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new b0(map, entryTransformer);
    }

    public static <K, V> Map<K, V> y(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
        com.google.common.base.i.E(predicate);
        return map instanceof AbstractFilteredMap ? C((AbstractFilteredMap) map, predicate) : new p((Map) com.google.common.base.i.E(map), predicate);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> y0(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new c0(navigableMap, entryTransformer);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> z(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        com.google.common.base.i.E(predicate);
        return navigableMap instanceof q ? D((q) navigableMap, predicate) : new q((NavigableMap) com.google.common.base.i.E(navigableMap), predicate);
    }

    public static <K, V1, V2> SortedMap<K, V2> z0(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new d0(sortedMap, entryTransformer);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class h<E> extends ForwardingSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f31814a;

        public h(Set set) {
            this.f31814a = set;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness E e) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<E> delegate() {
            return this.f31814a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class i<E> extends ForwardingSortedSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortedSet f31816a;

        public i(SortedSet sortedSet) {
            this.f31816a = sortedSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness E e) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(@ParametricNullness E e) {
            return Maps.n0(super.headSet(e));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
            return Maps.n0(super.subSet(e, e2));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(@ParametricNullness E e) {
            return Maps.n0(super.tailSet(e));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public SortedSet<E> delegate() {
            return this.f31816a;
        }
    }
}
