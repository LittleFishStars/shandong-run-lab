package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @GwtTransient
    final Map<R, Map<C, V>> backingMap;

    @CheckForNull
    private transient Set<C> columnKeySet;

    @CheckForNull
    private transient StandardTable<R, C, V>.f columnMap;

    @GwtTransient
    final Supplier<? extends Map<C, V>> factory;

    @CheckForNull
    private transient Map<R, Map<C, V>> rowMap;

    public abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
        public TableSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    public class b implements Iterator<Table.Cell<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f6146a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Map.Entry<R, Map<C, V>> f6147a;
        public Iterator<Map.Entry<C, V>> b;

        public b() {
            this.f6146a = StandardTable.this.backingMap.entrySet().iterator();
            this.b = Iterators.w();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Table.Cell<R, C, V> next() {
            if (!this.b.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f6146a.next();
                this.f6147a = next;
                this.b = next.getValue().entrySet().iterator();
            }
            Objects.requireNonNull(this.f6147a);
            Map.Entry<C, V> next2 = this.b.next();
            return Tables.c(this.f6147a.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6146a.hasNext() || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.b.remove();
            Map.Entry<R, Map<C, V>> entry = this.f6147a;
            Objects.requireNonNull(entry);
            if (entry.getValue().isEmpty()) {
                this.f6146a.remove();
                this.f6147a = null;
            }
        }
    }

    public class c extends Maps.ViewCachingAbstractMap<R, V> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final C f6148a;

        public class a extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.d(Predicates.c());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.containsMapping(entry.getKey(), c.this.f6148a, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !StandardTable.this.containsColumn(cVar.f6148a);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.removeMapping(entry.getKey(), c.this.f6148a, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Predicates.q(Predicates.n(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(c.this.f6148a)) {
                        i++;
                    }
                }
                return i;
            }
        }

        public class b extends AbstractIterator<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Iterator<Map.Entry<R, Map<C, V>>> f6149a;

            public class a extends AbstractMapEntry<R, V> {

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Map.Entry f6150a;

                public a(Map.Entry entry) {
                    this.f6150a = entry;
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f6150a.getKey();
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f6150a.getValue()).get(c.this.f6148a);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V setValue(V v) {
                    return (V) q.a(((Map) this.f6150a.getValue()).put(c.this.f6148a, com.google.common.base.i.E(v)));
                }
            }

            public b() {
                this.f6149a = StandardTable.this.backingMap.entrySet().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Map.Entry<R, V> computeNext() {
                while (this.f6149a.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f6149a.next();
                    if (next.getValue().containsKey(c.this.f6148a)) {
                        return new a(next);
                    }
                }
                return endOfData();
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.StandardTable$c$c, reason: collision with other inner class name */
        public class C0728c extends Maps.u<R, V> {
            public C0728c() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.u, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                c cVar = c.this;
                return StandardTable.this.contains(obj, cVar.f6148a);
            }

            @Override // com.google.common.collect.Maps.u, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                c cVar = c.this;
                return StandardTable.this.remove(obj, cVar.f6148a) != null;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Maps.U(Predicates.q(Predicates.n(collection))));
            }
        }

        public class d extends Maps.h0<R, V> {
            public d() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object obj) {
                return obj != null && c.this.d(Maps.Q0(Predicates.m(obj)));
            }

            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.d(Maps.Q0(Predicates.n(collection)));
            }

            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Maps.Q0(Predicates.q(Predicates.n(collection))));
            }
        }

        public c(C c) {
            this.f6148a = (C) com.google.common.base.i.E(c);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        public Set<R> g() {
            return new C0728c();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<V> c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.contains(obj, this.f6148a);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<R, V>> createEntrySet() {
            return new a();
        }

        @CanIgnoreReturnValue
        public boolean d(Predicate<? super Map.Entry<R, V>> predicate) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v = value.get(this.f6148a);
                if (v != null && predicate.apply(Maps.O(next.getKey(), v))) {
                    value.remove(this.f6148a);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            return (V) StandardTable.this.get(obj, this.f6148a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(R r, V v) {
            return (V) StandardTable.this.put(r, this.f6148a, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            return (V) StandardTable.this.remove(obj, this.f6148a);
        }
    }

    public class d extends AbstractIterator<C> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Iterator<Map<C, V>> f6151a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<C, V> f6152a;
        public Iterator<Map.Entry<C, V>> b;

        public d() {
            this.f6152a = StandardTable.this.factory.get();
            this.f6151a = StandardTable.this.backingMap.values().iterator();
            this.b = Iterators.u();
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public C computeNext() {
            while (true) {
                if (this.b.hasNext()) {
                    Map.Entry<C, V> next = this.b.next();
                    if (!this.f6152a.containsKey(next.getKey())) {
                        this.f6152a.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else {
                    if (!this.f6151a.hasNext()) {
                        return endOfData();
                    }
                    this.b = this.f6151a.next().entrySet().iterator();
                }
            }
        }
    }

    public class e extends StandardTable<R, C, V>.TableSet<C> {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            com.google.common.base.i.E(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.V(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.i.E(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.Z(iterator());
        }
    }

    public class f extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {

        public class a extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.StandardTable$f$a$a, reason: collision with other inner class name */
            public class C0729a implements Function<C, Map<R, V>> {
                public C0729a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<R, V> apply(C c) {
                    return StandardTable.this.column(c);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!StandardTable.this.containsColumn(entry.getKey())) {
                    return false;
                }
                Map<R, V> map = f.this.get(entry.getKey());
                Objects.requireNonNull(map);
                return map.equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.m(StandardTable.this.columnKeySet(), new C0729a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                com.google.common.base.i.E(collection);
                return Sets.J(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                com.google.common.base.i.E(collection);
                boolean z = false;
                for (Object obj : Lists.s(StandardTable.this.columnKeySet().iterator())) {
                    if (!collection.contains(Maps.O(obj, StandardTable.this.column(obj)))) {
                        StandardTable.this.removeColumn(obj);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        public class b extends Maps.h0<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                com.google.common.base.i.E(collection);
                boolean z = false;
                for (Object obj : Lists.s(StandardTable.this.columnKeySet().iterator())) {
                    if (collection.contains(StandardTable.this.column(obj))) {
                        StandardTable.this.removeColumn(obj);
                        z = true;
                    }
                }
                return z;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                com.google.common.base.i.E(collection);
                boolean z = false;
                for (Object obj : Lists.s(StandardTable.this.columnKeySet().iterator())) {
                    if (!collection.contains(StandardTable.this.column(obj))) {
                        StandardTable.this.removeColumn(obj);
                        z = true;
                    }
                }
                return z;
            }
        }

        public f() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<Map<R, V>> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<C, Map<R, V>>> createEntrySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map<R, V> get(@CheckForNull Object obj) {
            if (!StandardTable.this.containsColumn(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.column(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<R, V> remove(@CheckForNull Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<C> h() {
            return StandardTable.this.columnKeySet();
        }
    }

    public class g extends Maps.IteratorBasedAbstractMap<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final R f6153a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Map<C, V> f6154a;

        public class a implements Iterator<Map.Entry<C, V>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6155a;

            public a(Iterator it) {
                this.f6155a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<C, V> next() {
                return g.this.f((Map.Entry) this.f6155a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6155a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f6155a.remove();
                g.this.d();
            }
        }

        public class b extends ForwardingMapEntry<C, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map.Entry f31912a;

            public b(g gVar, Map.Entry entry) {
                this.f31912a = entry;
            }

            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
            public boolean equals(@CheckForNull Object obj) {
                return standardEquals(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
            public V setValue(V v) {
                return (V) super.setValue(com.google.common.base.i.E(v));
            }

            @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
            public Map.Entry<C, V> delegate() {
                return this.f31912a;
            }
        }

        public g(R r) {
            this.f6153a = (R) com.google.common.base.i.E(r);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<C, V>> b() {
            e();
            Map<C, V> map = this.f6154a;
            return map == null ? Iterators.w() : new a(map.entrySet().iterator());
        }

        @CheckForNull
        public Map<C, V> c() {
            return StandardTable.this.backingMap.get(this.f6153a);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            e();
            Map<C, V> map = this.f6154a;
            if (map != null) {
                map.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            Map<C, V> map;
            e();
            return (obj == null || (map = this.f6154a) == null || !Maps.o0(map, obj)) ? false : true;
        }

        public void d() {
            e();
            Map<C, V> map = this.f6154a;
            if (map == null || !map.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.f6153a);
            this.f6154a = null;
        }

        public final void e() {
            Map<C, V> map = this.f6154a;
            if (map == null || (map.isEmpty() && StandardTable.this.backingMap.containsKey(this.f6153a))) {
                this.f6154a = c();
            }
        }

        public Map.Entry<C, V> f(Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Map<C, V> map;
            e();
            if (obj == null || (map = this.f6154a) == null) {
                return null;
            }
            return (V) Maps.p0(map, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(C c, V v) {
            com.google.common.base.i.E(c);
            com.google.common.base.i.E(v);
            Map<C, V> map = this.f6154a;
            return (map == null || map.isEmpty()) ? (V) StandardTable.this.put(this.f6153a, c, v) : this.f6154a.put(c, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            e();
            Map<C, V> map = this.f6154a;
            if (map == null) {
                return null;
            }
            V v = (V) Maps.q0(map, obj);
            d();
            return v;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            e();
            Map<C, V> map = this.f6154a;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    public class h extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {

        public class a extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.StandardTable$h$a$a, reason: collision with other inner class name */
            public class C0730a implements Function<R, Map<C, V>> {
                public C0730a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<C, V> apply(R r) {
                    return StandardTable.this.row(r);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && com.google.common.collect.b.j(StandardTable.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.m(StandardTable.this.backingMap.keySet(), new C0730a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        public h() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<R, Map<C, V>>> createEntrySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get(@CheckForNull Object obj) {
            if (!StandardTable.this.containsRow(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.row(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<C, V> remove(@CheckForNull Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    public StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(@CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.factory.get();
        this.backingMap.put(r, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Map<R, V> removeColumn(@CheckForNull Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V vRemove = next.getValue().remove(obj);
            if (vRemove != null) {
                linkedHashMap.put(next.getKey(), vRemove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(@CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!containsMapping(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.AbstractTable
    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c2) {
        return new c(c2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        StandardTable<R, C, V>.f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (Maps.o0(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object obj) {
        return obj != null && Maps.o0(this.backingMap, obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(R r, C c2, V v) {
        com.google.common.base.i.E(r);
        com.google.common.base.i.E(c2);
        com.google.common.base.i.E(v);
        return getOrCreate(r).put(c2, v);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.p0(this.backingMap, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        return new g(r);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> mapCreateRowMap = createRowMap();
        this.rowMap = mapCreateRowMap;
        return mapCreateRowMap;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }
}
