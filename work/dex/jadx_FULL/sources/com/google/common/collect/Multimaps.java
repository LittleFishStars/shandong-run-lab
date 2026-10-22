package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Multimaps {

    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends List<V>> factory;

        public CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            this.factory = (Supplier) com.google.common.base.i.E(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }
    }

    public static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Collection<V>> factory;

        public CustomMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
            super(map);
            this.factory = (Supplier) com.google.common.base.i.E(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.O((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(@ParametricNullness K k, Collection<V> collection) {
            if (collection instanceof List) {
                return wrapList(k, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.l(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.n(k, (SortedSet) collection, null);
            }
            return collection instanceof Set ? new AbstractMapBasedMultimap.m(k, (Set) collection) : new AbstractMapBasedMultimap.j(k, collection, null);
        }
    }

    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Set<V>> factory;

        public CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            this.factory = (Supplier) com.google.common.base.i.E(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.O((NavigableSet) collection);
            }
            return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(@ParametricNullness K k, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.l(k, (NavigableSet) collection, null);
            }
            return collection instanceof SortedSet ? new AbstractMapBasedMultimap.n(k, (SortedSet) collection, null) : new AbstractMapBasedMultimap.m(k, (Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }
    }

    public static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract Multimap<K, V> b();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b().size();
        }
    }

    public static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        public class a extends Sets.ImprovedAbstractSet<V> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Object f6124a;

            /* JADX INFO: renamed from: com.google.common.collect.Multimaps$MapMultimap$a$a, reason: collision with other inner class name */
            public class C0720a implements Iterator<V> {
                public int K;

                public C0720a() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.K == 0) {
                        a aVar = a.this;
                        if (MapMultimap.this.map.containsKey(aVar.f6124a)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                @ParametricNullness
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.K++;
                    a aVar = a.this;
                    return (V) q.a(MapMultimap.this.map.get(aVar.f6124a));
                }

                @Override // java.util.Iterator
                public void remove() {
                    com.google.common.collect.a.e(this.K == 1);
                    this.K = -1;
                    a aVar = a.this;
                    MapMultimap.this.map.remove(aVar.f6124a);
                }
            }

            public a(Object obj) {
                this.f6124a = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new C0720a();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapMultimap.this.map.containsKey(this.f6124a) ? 1 : 0;
            }
        }

        public MapMultimap(Map<K, V> map) {
            this.map = (Map) com.google.common.base.i.E(map);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.map.entrySet().contains(Maps.O(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(@CheckForNull Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsValue(@CheckForNull Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return new a(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Multiset<K> createKeys() {
            return new b(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Collection<V> createValues() {
            return this.map.values();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(@ParametricNullness K k, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(@ParametricNullness K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.map.entrySet().remove(Maps.O(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> get(@ParametricNullness K k) {
            return new a(k);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> removeAll(@CheckForNull Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.map.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.map.remove(obj));
            return hashSet;
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
            super(listMultimap);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> get(@ParametricNullness K k) {
            return Collections.unmodifiableList(delegate().get((Object) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> removeAll(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }
    }

    public static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multimap<K, V> delegate;

        @CheckForNull
        @LazyInit
        transient Collection<Map.Entry<K, V>> entries;

        @CheckForNull
        @LazyInit
        transient Set<K> keySet;

        @CheckForNull
        @LazyInit
        transient Multiset<K> keys;

        @CheckForNull
        @LazyInit
        transient Map<K, Collection<V>> map;

        @CheckForNull
        @LazyInit
        transient Collection<V> values;

        public class a implements Function<Collection<V>, Collection<V>> {
            public a(UnmodifiableMultimap unmodifiableMultimap) {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<V> apply(Collection<V> collection) {
                return Multimaps.O(collection);
            }
        }

        public UnmodifiableMultimap(Multimap<K, V> multimap) {
            this.delegate = (Multimap) com.google.common.base.i.E(multimap);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map = this.map;
            if (map != null) {
                return map;
            }
            Map<K, Collection<V>> mapUnmodifiableMap = Collections.unmodifiableMap(Maps.B0(this.delegate.asMap(), new a(this)));
            this.map = mapUnmodifiableMap;
            return mapUnmodifiableMap;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection = this.entries;
            if (collection != null) {
                return collection;
            }
            Collection<Map.Entry<K, V>> collectionG = Multimaps.G(this.delegate.entries());
            this.entries = collectionG;
            return collectionG;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V> get(@ParametricNullness K k) {
            return Multimaps.O(this.delegate.get(k));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> setUnmodifiableSet = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> multiset = this.keys;
            if (multiset != null) {
                return multiset;
            }
            Multiset<K> multisetA = Multisets.A(this.delegate.keys());
            this.keys = multisetA;
            return multisetA;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean put(@ParametricNullness K k, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(@ParametricNullness K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V> removeAll(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.delegate.values());
            this.values = collectionUnmodifiableCollection;
            return collectionUnmodifiableCollection;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }
    }

    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
            super(setMultimap);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return Maps.J0(delegate().entries());
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> get(@ParametricNullness K k) {
            return Collections.unmodifiableSet(delegate().get((Object) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> removeAll(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }
    }

    public static final class a<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final Multimap<K, V> f31848a;

        /* JADX INFO: renamed from: com.google.common.collect.Multimaps$a$a, reason: collision with other inner class name */
        public class C0721a extends Maps.EntrySet<K, Collection<V>> {

            /* JADX INFO: renamed from: com.google.common.collect.Multimaps$a$a$a, reason: collision with other inner class name */
            public class C0722a implements Function<K, Collection<V>> {
                public C0722a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Collection<V> apply(@ParametricNullness K k) {
                    return a.this.f31848a.get(k);
                }
            }

            public C0721a() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public Map<K, Collection<V>> b() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.m(a.this.f31848a.keySet(), new C0722a());
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                a.this.g(entry.getKey());
                return true;
            }
        }

        public a(Multimap<K, V> multimap) {
            this.f31848a = (Multimap) com.google.common.base.i.E(multimap);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f31848a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f31848a.containsKey(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new C0721a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.f31848a.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.f31848a.removeAll(obj);
            }
            return null;
        }

        public void g(@CheckForNull Object obj) {
            this.f31848a.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f31848a.isEmpty();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<K> h() {
            return this.f31848a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f31848a.keySet().size();
        }
    }

    public static class b<K, V> extends AbstractMultiset<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final Multimap<K, V> f31851a;

        public class a extends TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>> {

            /* JADX INFO: renamed from: com.google.common.collect.Multimaps$b$a$a, reason: collision with other inner class name */
            public class C0723a extends Multisets.AbstractEntry<K> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f31852a;

                public C0723a(a aVar, Map.Entry entry) {
                    this.f31852a = entry;
                }

                @Override // com.google.common.collect.Multiset.Entry
                public int getCount() {
                    return ((Collection) this.f31852a.getValue()).size();
                }

                @Override // com.google.common.collect.Multiset.Entry
                @ParametricNullness
                public K getElement() {
                    return (K) this.f31852a.getKey();
                }
            }

            public a(b bVar, Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.TransformedIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0723a(this, entry);
            }
        }

        public b(Multimap<K, V> multimap) {
            this.f31851a = multimap;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f31851a.clear();
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@CheckForNull Object obj) {
            return this.f31851a.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object obj) {
            Collection collection = (Collection) Maps.p0(this.f31851a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public int distinctElements() {
            return this.f31851a.asMap().size();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set<K> elementSet() {
            return this.f31851a.keySet();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<Multiset.Entry<K>> entryIterator() {
            return new a(this, this.f31851a.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<K> iterator() {
            return Maps.S(this.f31851a.entries().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object obj, int i) {
            com.google.common.collect.a.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.p0(this.f31851a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.f31851a.size();
        }
    }

    public static final class c<K, V1, V2> extends d<K, V1, V2> implements ListMultimap<K, V2> {
        public c(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        @Override // com.google.common.collect.Multimaps.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<V2> a(@ParametricNullness K k, Collection<V1> collection) {
            return Lists.D((List) collection, Maps.n(((d) this).f31853a, k));
        }

        @Override // com.google.common.collect.Multimaps.d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V2> get(@ParametricNullness K k) {
            return a(k, ((d) this).f6125a.get(k));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V2> removeAll(@CheckForNull Object obj) {
            return a(obj, ((d) this).f6125a.removeAll(obj));
        }

        @Override // com.google.common.collect.Multimaps.d, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V2> replaceValues(@ParametricNullness K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static class d<K, V1, V2> extends AbstractMultimap<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Maps.EntryTransformer<? super K, ? super V1, V2> f31853a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Multimap<K, V1> f6125a;

        public class a implements Maps.EntryTransformer<K, Collection<V1>, Collection<V2>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.EntryTransformer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection<V2> a(@ParametricNullness K k, Collection<V1> collection) {
                return d.this.a(k, collection);
            }
        }

        public d(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.f6125a = (Multimap) com.google.common.base.i.E(multimap);
            this.f31853a = (Maps.EntryTransformer) com.google.common.base.i.E(entryTransformer);
        }

        public Collection<V2> a(@ParametricNullness K k, Collection<V1> collection) {
            Function functionN = Maps.n(this.f31853a, k);
            return collection instanceof List ? Lists.D((List) collection, functionN) : com.google.common.collect.b.m(collection, functionN);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.f6125a.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f6125a.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V2>> createAsMap() {
            return Maps.x0(this.f6125a.asMap(), new a());
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Collection<Map.Entry<K, V2>> createEntries() {
            return new AbstractMultimap.a();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return this.f6125a.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Multiset<K> createKeys() {
            return this.f6125a.keys();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Collection<V2> createValues() {
            return com.google.common.collect.b.m(this.f6125a.entries(), Maps.h(this.f31853a));
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.c0(this.f6125a.entries().iterator(), Maps.g(this.f31853a));
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V2> get(@ParametricNullness K k) {
            return a(k, this.f6125a.get(k));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.f6125a.isEmpty();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(@ParametricNullness K k, @ParametricNullness V2 v2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(@ParametricNullness K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return get(obj).remove(obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V2> removeAll(@CheckForNull Object obj) {
            return a(obj, this.f6125a.removeAll(obj));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection<V2> replaceValues(@ParametricNullness K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.f6125a.size();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K, V> SetMultimap<K, V> A(SetMultimap<K, V> setMultimap) {
        return Synchronized.v(setMultimap, null);
    }

    public static <K, V> SortedSetMultimap<K, V> B(SortedSetMultimap<K, V> sortedSetMultimap) {
        return Synchronized.y(sortedSetMultimap, null);
    }

    public static <K, V1, V2> ListMultimap<K, V2> C(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new c(listMultimap, entryTransformer);
    }

    public static <K, V1, V2> Multimap<K, V2> D(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new d(multimap, entryTransformer);
    }

    public static <K, V1, V2> ListMultimap<K, V2> E(ListMultimap<K, V1> listMultimap, Function<? super V1, V2> function) {
        com.google.common.base.i.E(function);
        return C(listMultimap, Maps.i(function));
    }

    public static <K, V1, V2> Multimap<K, V2> F(Multimap<K, V1> multimap, Function<? super V1, V2> function) {
        com.google.common.base.i.E(function);
        return D(multimap, Maps.i(function));
    }

    public static <K, V> Collection<Map.Entry<K, V>> G(Collection<Map.Entry<K, V>> collection) {
        return collection instanceof Set ? Maps.J0((Set) collection) : new Maps.e0(Collections.unmodifiableCollection(collection));
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> H(ImmutableListMultimap<K, V> immutableListMultimap) {
        return (ListMultimap) com.google.common.base.i.E(immutableListMultimap);
    }

    public static <K, V> ListMultimap<K, V> I(ListMultimap<K, V> listMultimap) {
        return ((listMultimap instanceof UnmodifiableListMultimap) || (listMultimap instanceof ImmutableListMultimap)) ? listMultimap : new UnmodifiableListMultimap(listMultimap);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> J(ImmutableMultimap<K, V> immutableMultimap) {
        return (Multimap) com.google.common.base.i.E(immutableMultimap);
    }

    public static <K, V> Multimap<K, V> K(Multimap<K, V> multimap) {
        return ((multimap instanceof UnmodifiableMultimap) || (multimap instanceof ImmutableMultimap)) ? multimap : new UnmodifiableMultimap(multimap);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> L(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return (SetMultimap) com.google.common.base.i.E(immutableSetMultimap);
    }

    public static <K, V> SetMultimap<K, V> M(SetMultimap<K, V> setMultimap) {
        return ((setMultimap instanceof UnmodifiableSetMultimap) || (setMultimap instanceof ImmutableSetMultimap)) ? setMultimap : new UnmodifiableSetMultimap(setMultimap);
    }

    public static <K, V> SortedSetMultimap<K, V> N(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap instanceof UnmodifiableSortedSetMultimap ? sortedSetMultimap : new UnmodifiableSortedSetMultimap(sortedSetMultimap);
    }

    public static <V> Collection<V> O(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    @Beta
    public static <K, V> Map<K, List<V>> c(ListMultimap<K, V> listMultimap) {
        return listMultimap.asMap();
    }

    @Beta
    public static <K, V> Map<K, Collection<V>> d(Multimap<K, V> multimap) {
        return multimap.asMap();
    }

    @Beta
    public static <K, V> Map<K, Set<V>> e(SetMultimap<K, V> setMultimap) {
        return setMultimap.asMap();
    }

    @Beta
    public static <K, V> Map<K, SortedSet<V>> f(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap.asMap();
    }

    public static boolean g(Multimap<?, ?> multimap, @CheckForNull Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }

    public static <K, V> Multimap<K, V> h(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        com.google.common.base.i.E(predicate);
        if (multimap instanceof SetMultimap) {
            return i((SetMultimap) multimap, predicate);
        }
        return multimap instanceof FilteredMultimap ? j((FilteredMultimap) multimap, predicate) : new f((Multimap) com.google.common.base.i.E(multimap), predicate);
    }

    public static <K, V> SetMultimap<K, V> i(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        com.google.common.base.i.E(predicate);
        return setMultimap instanceof FilteredSetMultimap ? k((FilteredSetMultimap) setMultimap, predicate) : new g((SetMultimap) com.google.common.base.i.E(setMultimap), predicate);
    }

    public static <K, V> Multimap<K, V> j(FilteredMultimap<K, V> filteredMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new f(filteredMultimap.f(), Predicates.d(filteredMultimap.i(), predicate));
    }

    public static <K, V> SetMultimap<K, V> k(FilteredSetMultimap<K, V> filteredSetMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new g(filteredSetMultimap.f(), Predicates.d(filteredSetMultimap.i(), predicate));
    }

    public static <K, V> ListMultimap<K, V> l(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        if (!(listMultimap instanceof h)) {
            return new h(listMultimap, predicate);
        }
        h hVar = (h) listMultimap;
        return new h(hVar.f(), Predicates.d(((i) hVar).f31982a, predicate));
    }

    public static <K, V> Multimap<K, V> m(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        if (multimap instanceof SetMultimap) {
            return n((SetMultimap) multimap, predicate);
        }
        if (multimap instanceof ListMultimap) {
            return l((ListMultimap) multimap, predicate);
        }
        if (!(multimap instanceof i)) {
            return multimap instanceof FilteredMultimap ? j((FilteredMultimap) multimap, Maps.U(predicate)) : new i(multimap, predicate);
        }
        i iVar = (i) multimap;
        return new i(iVar.f6206a, Predicates.d(iVar.f31982a, predicate));
    }

    public static <K, V> SetMultimap<K, V> n(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        if (!(setMultimap instanceof j)) {
            return setMultimap instanceof FilteredSetMultimap ? k((FilteredSetMultimap) setMultimap, Maps.U(predicate)) : new j(setMultimap, predicate);
        }
        j jVar = (j) setMultimap;
        return new j(jVar.f(), Predicates.d(((i) jVar).f31982a, predicate));
    }

    public static <K, V> Multimap<K, V> o(Multimap<K, V> multimap, Predicate<? super V> predicate) {
        return h(multimap, Maps.Q0(predicate));
    }

    public static <K, V> SetMultimap<K, V> p(SetMultimap<K, V> setMultimap, Predicate<? super V> predicate) {
        return i(setMultimap, Maps.Q0(predicate));
    }

    public static <K, V> SetMultimap<K, V> q(Map<K, V> map) {
        return new MapMultimap(map);
    }

    public static <K, V> ImmutableListMultimap<K, V> r(Iterable<V> iterable, Function<? super V, K> function) {
        return s(iterable.iterator(), function);
    }

    public static <K, V> ImmutableListMultimap<K, V> s(Iterator<V> it, Function<? super V, K> function) {
        com.google.common.base.i.E(function);
        ImmutableListMultimap.a aVarBuilder = ImmutableListMultimap.builder();
        while (it.hasNext()) {
            V next = it.next();
            com.google.common.base.i.F(next, it);
            aVarBuilder.f(function.apply(next), next);
        }
        return aVarBuilder.a();
    }

    @CanIgnoreReturnValue
    public static <K, V, M extends Multimap<K, V>> M t(Multimap<? extends V, ? extends K> multimap, M m) {
        com.google.common.base.i.E(m);
        for (Map.Entry<? extends V, ? extends K> entry : multimap.entries()) {
            m.put(entry.getValue(), entry.getKey());
        }
        return m;
    }

    public static <K, V> ListMultimap<K, V> u(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        return new CustomListMultimap(map, supplier);
    }

    public static <K, V> Multimap<K, V> v(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
        return new CustomMultimap(map, supplier);
    }

    public static <K, V> SetMultimap<K, V> w(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        return new CustomSetMultimap(map, supplier);
    }

    public static <K, V> SortedSetMultimap<K, V> x(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
        return new CustomSortedSetMultimap(map, supplier);
    }

    public static <K, V> ListMultimap<K, V> y(ListMultimap<K, V> listMultimap) {
        return Synchronized.k(listMultimap, null);
    }

    public static <K, V> Multimap<K, V> z(Multimap<K, V> multimap) {
        return Synchronized.m(multimap, null);
    }

    public static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends SortedSet<V>> factory;

        @CheckForNull
        transient Comparator<? super V> valueComparator;

        public CustomSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
            super(map);
            this.factory = (Supplier) com.google.common.base.i.E(supplier);
            this.valueComparator = supplier.get().comparator();
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Supplier<? extends SortedSet<V>> supplier = (Supplier) objectInputStream.readObject();
            this.factory = supplier;
            this.valueComparator = supplier.get().comparator();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public SortedSet<V> createCollection() {
            return this.factory.get();
        }
    }

    public static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
            super(sortedSetMultimap);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> get(@ParametricNullness K k) {
            return Collections.unmodifiableSortedSet(delegate().get((Object) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> removeAll(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }
    }
}
