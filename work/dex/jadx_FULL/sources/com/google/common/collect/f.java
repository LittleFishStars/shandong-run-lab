package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public class f<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Predicate<? super Map.Entry<K, V>> f31972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Multimap<K, V> f6203a;

    public class a extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* JADX INFO: renamed from: com.google.common.collect.f$a$a, reason: collision with other inner class name */
        public class C0737a extends Maps.EntrySet<K, Collection<V>> {

            /* JADX INFO: renamed from: com.google.common.collect.f$a$a$a, reason: collision with other inner class name */
            public class C0738a extends AbstractIterator<Map.Entry<K, Collection<V>>> {

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final Iterator<Map.Entry<K, Collection<V>>> f6204a;

                public C0738a() {
                    this.f6204a = f.this.f6203a.asMap().entrySet().iterator();
                }

                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                public Map.Entry<K, Collection<V>> computeNext() {
                    while (this.f6204a.hasNext()) {
                        Map.Entry<K, Collection<V>> next = this.f6204a.next();
                        K key = next.getKey();
                        Collection collectionB = f.b(next.getValue(), new c(key));
                        if (!collectionB.isEmpty()) {
                            return Maps.O(key, collectionB);
                        }
                    }
                    return endOfData();
                }
            }

            public C0737a() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public Map<K, Collection<V>> b() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C0738a();
            }

            @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return f.this.c(Predicates.n(collection));
            }

            @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return f.this.c(Predicates.q(Predicates.n(collection)));
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Iterators.Z(iterator());
            }
        }

        public class b extends Maps.u<K, Collection<V>> {
            public b() {
                super(a.this);
            }

            @Override // com.google.common.collect.Maps.u, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                return a.this.remove(obj) != null;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return f.this.c(Maps.U(Predicates.n(collection)));
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return f.this.c(Maps.U(Predicates.q(Predicates.n(collection))));
            }
        }

        public class c extends Maps.h0<K, Collection<V>> {
            public c() {
                super(a.this);
            }

            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Collection)) {
                    return false;
                }
                Collection collection = (Collection) obj;
                Iterator<Map.Entry<K, Collection<V>>> it = f.this.f6203a.asMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<K, Collection<V>> next = it.next();
                    Collection collectionB = f.b(next.getValue(), new c(next.getKey()));
                    if (!collectionB.isEmpty() && collection.equals(collectionB)) {
                        if (collectionB.size() == next.getValue().size()) {
                            it.remove();
                            return true;
                        }
                        collectionB.clear();
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return f.this.c(Maps.Q0(Predicates.n(collection)));
            }

            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return f.this.c(Maps.Q0(Predicates.q(Predicates.n(collection))));
            }
        }

        public a() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        public Set<K> g() {
            return new b();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<Collection<V>> c() {
            return new c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new C0737a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> collection = f.this.f6203a.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> collectionB = f.b(collection, new c(obj));
            if (collectionB.isEmpty()) {
                return null;
            }
            return collectionB;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection<V> collection = f.this.f6203a.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList arrayListQ = Lists.q();
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                V next = it.next();
                if (f.this.d(obj, next)) {
                    it.remove();
                    arrayListQ.add(next);
                }
            }
            if (arrayListQ.isEmpty()) {
                return null;
            }
            return f.this.f6203a instanceof SetMultimap ? Collections.unmodifiableSet(Sets.B(arrayListQ)) : Collections.unmodifiableList(arrayListQ);
        }
    }

    public class b extends Multimaps.b<K, V> {

        public class a extends Multisets.EntrySet<K> {

            /* JADX INFO: renamed from: com.google.common.collect.f$b$a$a, reason: collision with other inner class name */
            public class C0739a implements Predicate<Map.Entry<K, Collection<V>>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Predicate f31980a;

                public C0739a(a aVar, Predicate predicate) {
                    this.f31980a = predicate;
                }

                @Override // com.google.common.base.Predicate
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean apply(Map.Entry<K, Collection<V>> entry) {
                    return this.f31980a.apply(Multisets.k(entry.getKey(), entry.getValue().size()));
                }
            }

            public a() {
            }

            @Override // com.google.common.collect.Multisets.EntrySet
            public Multiset<K> b() {
                return b.this;
            }

            public final boolean c(Predicate<? super Multiset.Entry<K>> predicate) {
                return f.this.c(new C0739a(this, predicate));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Multiset.Entry<K>> iterator() {
                return b.this.entryIterator();
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return c(Predicates.n(collection));
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c(Predicates.q(Predicates.n(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return f.this.keySet().size();
            }
        }

        public b() {
            super(f.this);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<K>> entrySet() {
            return new a();
        }

        @Override // com.google.common.collect.Multimaps.b, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object obj, int i) {
            com.google.common.collect.a.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection<V> collection = f.this.f6203a.asMap().get(obj);
            int i2 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                if (f.this.d(obj, it.next()) && (i2 = i2 + 1) <= i) {
                    it.remove();
                }
            }
            return i2;
        }
    }

    public final class c implements Predicate<V> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @ParametricNullness
        public final K f6205a;

        public c(K k) {
            this.f6205a = k;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness V v) {
            return f.this.d(this.f6205a, v);
        }
    }

    public f(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        this.f6203a = (Multimap) com.google.common.base.i.E(multimap);
        this.f31972a = (Predicate) com.google.common.base.i.E(predicate);
    }

    public static <E> Collection<E> b(Collection<E> collection, Predicate<? super E> predicate) {
        return collection instanceof Set ? Sets.i((Set) collection, predicate) : com.google.common.collect.b.d(collection, predicate);
    }

    public boolean c(Predicate<? super Map.Entry<K, Collection<V>>> predicate) {
        Iterator<Map.Entry<K, Collection<V>>> it = this.f6203a.asMap().entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry<K, Collection<V>> next = it.next();
            K key = next.getKey();
            Collection collectionB = b(next.getValue(), new c(key));
            if (!collectionB.isEmpty() && predicate.apply(Maps.O(key, collectionB))) {
                if (collectionB.size() == next.getValue().size()) {
                    it.remove();
                } else {
                    collectionB.clear();
                }
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return asMap().get(obj) != null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<Map.Entry<K, V>> createEntries() {
        return b(this.f6203a.entries(), this.f31972a);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return new b();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<V> createValues() {
        return new k(this);
    }

    public final boolean d(@ParametricNullness K k, @ParametricNullness V v) {
        return this.f31972a.apply(Maps.O(k, v));
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Multimap<K, V> f() {
        return this.f6203a;
    }

    public Collection<V> g() {
        return this.f6203a instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> get(@ParametricNullness K k) {
        return b(this.f6203a.get(k), new c(k));
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> i() {
        return this.f31972a;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> removeAll(@CheckForNull Object obj) {
        return (Collection) com.google.common.base.e.a(asMap().remove(obj), g());
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return entries().size();
    }
}
