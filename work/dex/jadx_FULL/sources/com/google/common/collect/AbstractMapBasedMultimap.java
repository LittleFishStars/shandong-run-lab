package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    public abstract class Itr<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Iterator<Map.Entry<K, Collection<V>>> f6038a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public K f6036a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Collection<V> f6037a = null;
        public Iterator<V> b = Iterators.w();

        public Itr() {
            this.f6038a = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public abstract T a(@ParametricNullness K k, @ParametricNullness V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6038a.hasNext() || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.b.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f6038a.next();
                this.f6036a = next.getKey();
                Collection<V> value = next.getValue();
                this.f6037a = value;
                this.b = value.iterator();
            }
            return a(q.a(this.f6036a), this.b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.b.remove();
            Collection<V> collection = this.f6037a;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f6038a.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    public class a extends AbstractMapBasedMultimap<K, V>.Itr<V> {
        public a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
        @ParametricNullness
        public V a(@ParametricNullness K k, @ParametricNullness V v) {
            return v;
        }
    }

    public class b extends AbstractMapBasedMultimap<K, V>.Itr<Map.Entry<K, V>> {
        public b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(@ParametricNullness K k, @ParametricNullness V v) {
            return Maps.O(k, v);
        }
    }

    public class c extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final transient Map<K, Collection<V>> f6039a;

        public class a extends Maps.EntrySet<K, Collection<V>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public Map<K, Collection<V>> b() {
                return c.this;
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return com.google.common.collect.b.j(c.this.f6039a.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return c.this.new b();
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.removeValuesForKey(entry.getKey());
                return true;
            }
        }

        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @CheckForNull
            public Collection<V> f6040a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Iterator<Map.Entry<K, Collection<V>>> f6041a;

            public b() {
                this.f6041a = c.this.f6039a.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f6041a.next();
                this.f6040a = next.getValue();
                return c.this.f(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6041a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.base.i.h0(this.f6040a != null, "no calls to next() since the last call to remove()");
                this.f6041a.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.f6040a.size());
                this.f6040a.clear();
                this.f6040a = null;
            }
        }

        public c(Map<K, Collection<V>> map) {
            this.f6039a = map;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f6039a == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.h(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return Maps.o0(this.f6039a, obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> collection = (Collection) Maps.p0(this.f6039a, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection<V> collectionRemove = this.f6039a.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionCreateCollection = AbstractMapBasedMultimap.this.createCollection();
            collectionCreateCollection.addAll(collectionRemove);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collectionRemove.size());
            collectionRemove.clear();
            return collectionCreateCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@CheckForNull Object obj) {
            return this == obj || this.f6039a.equals(obj);
        }

        public Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.O(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f6039a.hashCode();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<K> h() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f6039a.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f6039a.toString();
        }
    }

    public class d extends Maps.u<K, Collection<V>> {

        public class a implements Iterator<K> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6042a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @CheckForNull
            public Map.Entry<K, Collection<V>> f6043a;

            public a(Iterator it) {
                this.f6042a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6042a.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f6042a.next();
                this.f6043a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.base.i.h0(this.f6043a != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f6043a.getValue();
                this.f6042a.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, value.size());
                value.clear();
                this.f6043a = null;
            }
        }

        public d(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.h(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return c().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return this == obj || c().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return c().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(c().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int size;
            Collection<V> collectionRemove = c().remove(obj);
            if (collectionRemove != null) {
                size = collectionRemove.size();
                collectionRemove.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    public class e extends AbstractMapBasedMultimap<K, V>.h implements NavigableMap<K, Collection<V>> {
        public e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> ceilingEntry(@ParametricNullness K k) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = i().ceilingEntry(k);
            if (entryCeilingEntry == null) {
                return null;
            }
            return f(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@ParametricNullness K k) {
            return i().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new e(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = i().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return f(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> floorEntry(@ParametricNullness K k) {
            Map.Entry<K, Collection<V>> entryFloorEntry = i().floorEntry(k);
            if (entryFloorEntry == null) {
                return null;
            }
            return f(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@ParametricNullness K k) {
            return i().floorKey(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> higherEntry(@ParametricNullness K k) {
            Map.Entry<K, Collection<V>> entryHigherEntry = i().higherEntry(k);
            if (entryHigherEntry == null) {
                return null;
            }
            return f(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@ParametricNullness K k) {
            return i().higherKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> g() {
            return new f(i());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K k) {
            return headMap(k, false);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> l(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> collectionCreateCollection = AbstractMapBasedMultimap.this.createCollection();
            collectionCreateCollection.addAll(next.getValue());
            it.remove();
            return Maps.O(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(collectionCreateCollection));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = i().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return f(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lowerEntry(@ParametricNullness K k) {
            Map.Entry<K, Collection<V>> entryLowerEntry = i().lowerEntry(k);
            if (entryLowerEntry == null) {
                return null;
            }
            return f(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@ParametricNullness K k) {
            return i().lowerKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) super.i();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return h();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return l(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return l(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K k, boolean z) {
            return new e(i().headMap(k, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.h, com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> h() {
            return (NavigableSet) super.h();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return new e(i().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K k, boolean z) {
            return new e(i().tailMap(k, z));
        }
    }

    public class f extends AbstractMapBasedMultimap<K, V>.i implements NavigableSet<K> {
        public f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K ceiling(@ParametricNullness K k) {
            return c().ceilingKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> headSet(@ParametricNullness K k) {
            return headSet(k, false);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new f(c().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> c() {
            return (NavigableMap) super.c();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K floor(@ParametricNullness K k) {
            return c().floorKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> tailSet(@ParametricNullness K k) {
            return tailSet(k, true);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K higher(@ParametricNullness K k) {
            return c().higherKey(k);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K lower(@ParametricNullness K k) {
            return c().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollFirst() {
            return (K) Iterators.U(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollLast() {
            return (K) Iterators.U(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(@ParametricNullness K k, boolean z) {
            return new f(c().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return new f(c().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(@ParametricNullness K k, boolean z) {
            return new f(c().tailMap(k, z));
        }
    }

    public class g extends AbstractMapBasedMultimap<K, V>.k implements RandomAccess {
        public g(@ParametricNullness AbstractMapBasedMultimap abstractMapBasedMultimap, K k, @CheckForNull List<V> list, AbstractMapBasedMultimap<K, V>.j jVar) {
            super(k, list, jVar);
        }
    }

    public class h extends AbstractMapBasedMultimap<K, V>.c implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public SortedSet<K> f31662a;

        public h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K firstKey() {
            return i().firstKey();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public SortedSet<K> g() {
            return new i(i());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<K> h() {
            SortedSet<K> sortedSet = this.f31662a;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetG = g();
            this.f31662a = sortedSetG;
            return sortedSetG;
        }

        public SortedMap<K, Collection<V>> headMap(@ParametricNullness K k) {
            return new h(i().headMap(k));
        }

        public SortedMap<K, Collection<V>> i() {
            return (SortedMap) ((c) this).f6039a;
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K lastKey() {
            return i().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return new h(i().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(@ParametricNullness K k) {
            return new h(i().tailMap(k));
        }
    }

    public class i extends AbstractMapBasedMultimap<K, V>.d implements SortedSet<K> {
        public i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedMap<K, Collection<V>> c() {
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
            return new i(c().headMap(k));
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
            return new i(c().subMap(k, k2));
        }

        public SortedSet<K> tailSet(@ParametricNullness K k) {
            return new i(c().tailMap(k));
        }
    }

    public class l extends AbstractMapBasedMultimap<K, V>.n implements NavigableSet<V> {
        public l(K k, @CheckForNull NavigableSet<V> navigableSet, AbstractMapBasedMultimap<K, V>.j jVar) {
            super(k, navigableSet, jVar);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V ceiling(@ParametricNullness V v) {
            return h().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new j.a(h().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return j(h().descendingSet());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V floor(@ParametricNullness V v) {
            return h().floor(v);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(@ParametricNullness V v, boolean z) {
            return j(h().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V higher(@ParametricNullness V v) {
            return h().higher(v);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.n
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableSet<V> h() {
            return (NavigableSet) super.h();
        }

        public final NavigableSet<V> j(NavigableSet<V> navigableSet) {
            return new l(((j) this).f6045a, navigableSet, c() == null ? this : c());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V lower(@ParametricNullness V v) {
            return h().lower(v);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V pollFirst() {
            return (V) Iterators.U(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V pollLast() {
            return (V) Iterators.U(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(@ParametricNullness V v, boolean z, @ParametricNullness V v2, boolean z2) {
            return j(h().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(@ParametricNullness V v, boolean z) {
            return j(h().tailSet(v, z));
        }
    }

    public class m extends AbstractMapBasedMultimap<K, V>.j implements Set<V> {
        public m(K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zI = Sets.I((Set) ((j) this).f6046a, collection);
            if (zI) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, ((j) this).f6046a.size() - size);
                g();
            }
            return zI;
        }
    }

    public class n extends AbstractMapBasedMultimap<K, V>.j implements SortedSet<V> {
        public n(K k, @CheckForNull SortedSet<V> sortedSet, AbstractMapBasedMultimap<K, V>.j jVar) {
            super(k, sortedSet, jVar);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super V> comparator() {
            return h().comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public V first() {
            f();
            return h().first();
        }

        public SortedSet<V> h() {
            return (SortedSet) d();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(@ParametricNullness V v) {
            f();
            return new n(e(), h().headSet(v), c() == null ? this : c());
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public V last() {
            f();
            return h().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(@ParametricNullness V v, @ParametricNullness V v2) {
            f();
            return new n(e(), h().subSet(v, v2), c() == null ? this : c());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(@ParametricNullness V v) {
            f();
            return new n(e(), h().tailSet(v), c() == null ? this : c());
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        com.google.common.base.i.d(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.totalSize + i2;
        abstractMapBasedMultimap.totalSize = i3;
        return i3;
    }

    public static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.totalSize - i2;
        abstractMapBasedMultimap.totalSize = i3;
        return i3;
    }

    private Collection<V> getOrCreateCollection(@ParametricNullness K k2) {
        Collection<V> collection = this.map.get(k2);
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateCollection = createCollection(k2);
        this.map.put(k2, collectionCreateCollection);
        return collectionCreateCollection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(@CheckForNull Object obj) {
        Collection collection = (Collection) Maps.q0(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Iterator<Collection<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return new c(this.map);
    }

    public abstract Collection<V> createCollection();

    public Collection<V> createCollection(@ParametricNullness K k2) {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<Map.Entry<K, V>> createEntries() {
        return this instanceof SetMultimap ? new AbstractMultimap.b(this) : new AbstractMultimap.a();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return new d(this.map);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return new Multimaps.b(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new e((NavigableMap) this.map);
        }
        return map instanceof SortedMap ? new h((SortedMap) this.map) : new c(this.map);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.map);
        }
        return map instanceof SortedMap ? new i((SortedMap) this.map) : new d(this.map);
    }

    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<V> createValues() {
        return new AbstractMultimap.c();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new b(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> get(@ParametricNullness K k2) {
        Collection<V> collectionCreateCollection = this.map.get(k2);
        if (collectionCreateCollection == null) {
            collectionCreateCollection = createCollection(k2);
        }
        return wrapCollection(k2, collectionCreateCollection);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
        Collection<V> collection = this.map.get(k2);
        if (collection != null) {
            if (!collection.add(v)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        Collection<V> collectionCreateCollection = createCollection(k2);
        if (!collectionCreateCollection.add(v)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(k2, collectionCreateCollection);
        return true;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> removeAll(@CheckForNull Object obj) {
        Collection<V> collectionRemove = this.map.remove(obj);
        if (collectionRemove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(collectionRemove);
        this.totalSize -= collectionRemove.size();
        collectionRemove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> replaceValues(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k2);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k2);
        Collection<V> collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            com.google.common.base.i.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.totalSize;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<V> valueIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public Collection<V> wrapCollection(@ParametricNullness K k2, Collection<V> collection) {
        return new j(k2, collection, null);
    }

    public final List<V> wrapList(@ParametricNullness K k2, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.j jVar) {
        return list instanceof RandomAccess ? new g(this, k2, list, jVar) : new k(k2, list, jVar);
    }

    public class j extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public final AbstractMapBasedMultimap<K, V>.j f31663a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @ParametricNullness
        public final K f6045a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Collection<V> f6046a;

        @CheckForNull
        public final Collection<V> b;

        public j(K k, @CheckForNull Collection<V> collection, AbstractMapBasedMultimap<K, V>.j jVar) {
            this.f6045a = k;
            this.f6046a = collection;
            this.f31663a = jVar;
            this.b = jVar == null ? null : jVar.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@ParametricNullness V v) {
            f();
            boolean zIsEmpty = this.f6046a.isEmpty();
            boolean zAdd = this.f6046a.add(v);
            if (zAdd) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (zIsEmpty) {
                    b();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f6046a.addAll(collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f6046a.size() - size);
                if (size == 0) {
                    b();
                }
            }
            return zAddAll;
        }

        public void b() {
            AbstractMapBasedMultimap<K, V>.j jVar = this.f31663a;
            if (jVar != null) {
                jVar.b();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.f6045a, this.f6046a);
            }
        }

        @CheckForNull
        public AbstractMapBasedMultimap<K, V>.j c() {
            return this.f31663a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f6046a.clear();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            f();
            return this.f6046a.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            f();
            return this.f6046a.containsAll(collection);
        }

        public Collection<V> d() {
            return this.f6046a;
        }

        @ParametricNullness
        K e() {
            return this.f6045a;
        }

        @Override // java.util.Collection
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            f();
            return this.f6046a.equals(obj);
        }

        public void f() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.j jVar = this.f31663a;
            if (jVar != null) {
                jVar.f();
                if (this.f31663a.d() != this.b) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f6046a.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.f6045a)) == null) {
                    return;
                }
                this.f6046a = collection;
            }
        }

        public void g() {
            AbstractMapBasedMultimap<K, V>.j jVar = this.f31663a;
            if (jVar != null) {
                jVar.g();
            } else if (this.f6046a.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.f6045a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.f6046a.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            f();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            f();
            boolean zRemove = this.f6046a.remove(obj);
            if (zRemove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                g();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f6046a.removeAll(collection);
            if (zRemoveAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f6046a.size() - size);
                g();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.i.E(collection);
            int size = size();
            boolean zRetainAll = this.f6046a.retainAll(collection);
            if (zRetainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f6046a.size() - size);
                g();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.f6046a.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.f6046a.toString();
        }

        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Collection<V> f6047a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Iterator<V> f6048a;

            public a() {
                Collection<V> collection = j.this.f6046a;
                this.f6047a = collection;
                this.f6048a = AbstractMapBasedMultimap.iteratorOrListIterator(collection);
            }

            public Iterator<V> a() {
                b();
                return this.f6048a;
            }

            public void b() {
                j.this.f();
                if (j.this.f6046a != this.f6047a) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f6048a.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public V next() {
                b();
                return this.f6048a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f6048a.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                j.this.g();
            }

            public a(Iterator<V> it) {
                this.f6047a = j.this.f6046a;
                this.f6048a = it;
            }
        }
    }

    public class k extends AbstractMapBasedMultimap<K, V>.j implements List<V> {

        public class a extends AbstractMapBasedMultimap<K, V>.j.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(@ParametricNullness V v) {
                boolean zIsEmpty = k.this.isEmpty();
                c().add(v);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (zIsEmpty) {
                    k.this.b();
                }
            }

            public final ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            @ParametricNullness
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(@ParametricNullness V v) {
                c().set(v);
            }

            public a(int i) {
                super(k.this.h().listIterator(i));
            }
        }

        public k(K k, @CheckForNull List<V> list, AbstractMapBasedMultimap<K, V>.j jVar) {
            super(k, list, jVar);
        }

        @Override // java.util.List
        public void add(int i, @ParametricNullness V v) {
            f();
            boolean zIsEmpty = d().isEmpty();
            h().add(i, v);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (zIsEmpty) {
                b();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = h().addAll(i, collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, d().size() - size);
                if (size == 0) {
                    b();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        @ParametricNullness
        public V get(int i) {
            f();
            return h().get(i);
        }

        public List<V> h() {
            return (List) d();
        }

        @Override // java.util.List
        public int indexOf(@CheckForNull Object obj) {
            f();
            return h().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            f();
            return h().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            f();
            return new a();
        }

        @Override // java.util.List
        @ParametricNullness
        public V remove(int i) {
            f();
            V vRemove = h().remove(i);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            g();
            return vRemove;
        }

        @Override // java.util.List
        @ParametricNullness
        public V set(int i, @ParametricNullness V v) {
            f();
            return h().set(i, v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            f();
            return AbstractMapBasedMultimap.this.wrapList(e(), h().subList(i, i2), c() == null ? this : c());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            f();
            return new a(i);
        }
    }
}
