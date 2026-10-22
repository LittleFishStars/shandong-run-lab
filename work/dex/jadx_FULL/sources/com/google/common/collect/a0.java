package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class a0<K extends Comparable, V> implements RangeMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RangeMap<Comparable<?>, Object> f31954a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NavigableMap<Cut<K>, c<K, V>> f6191a = Maps.f0();

    public class a implements RangeMap<Comparable<?>, Object> {
        @Override // com.google.common.collect.RangeMap
        public Map<Range<Comparable<?>>, Object> asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<Comparable<?>>, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Object get(Comparable<?> comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Map.Entry<Range<Comparable<?>>, Object> getEntry(Comparable<?> comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<Comparable<?>> range, Object obj) {
            com.google.common.base.i.E(range);
            String strValueOf = String.valueOf(range);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 46);
            sb.append("Cannot insert range ");
            sb.append(strValueOf);
            sb.append(" into an empty subRangeMap");
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<Comparable<?>, Object> rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range<Comparable<?>> range, Object obj) {
            com.google.common.base.i.E(range);
            String strValueOf = String.valueOf(range);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 46);
            sb.append("Cannot insert range ");
            sb.append(strValueOf);
            sb.append(" into an empty subRangeMap");
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(Range<Comparable<?>> range) {
            com.google.common.base.i.E(range);
        }

        @Override // com.google.common.collect.RangeMap
        public Range<Comparable<?>> span() {
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public RangeMap<Comparable<?>, Object> subRangeMap(Range<Comparable<?>> range) {
            com.google.common.base.i.E(range);
            return this;
        }
    }

    public final class b extends Maps.IteratorBasedAbstractMap<Range<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Iterable<Map.Entry<Range<K>, V>> f6192a;

        public b(Iterable<c<K, V>> iterable) {
            this.f6192a = iterable;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Range<K>, V>> b() {
            return this.f6192a.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            c cVar = (c) a0.this.f6191a.get(range.lowerBound);
            if (cVar == null || !cVar.getKey().equals(range)) {
                return null;
            }
            return (V) cVar.getValue();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return a0.this.f6191a.size();
        }
    }

    public static final class c<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<K> f31956a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final V f6193a;

        public c(Cut<K> cut, Cut<K> cut2, V v) {
            this(Range.create(cut, cut2), v);
        }

        public boolean a(K k) {
            return this.f31956a.contains(k);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Range<K> getKey() {
            return this.f31956a;
        }

        public Cut<K> g() {
            return (Cut<K>) this.f31956a.lowerBound;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.f6193a;
        }

        public Cut<K> h() {
            return (Cut<K>) this.f31956a.upperBound;
        }

        public c(Range<K> range, V v) {
            this.f31956a = range;
            this.f6193a = v;
        }
    }

    public class d implements RangeMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<K> f31957a;

        public class a extends a0<K, V>.d.b {

            /* JADX INFO: renamed from: com.google.common.collect.a0$d$a$a, reason: collision with other inner class name */
            public class C0733a extends AbstractIterator<Map.Entry<Range<K>, V>> {

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Iterator f6195a;

                public C0733a(Iterator it) {
                    this.f6195a = it;
                }

                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                public Map.Entry<Range<K>, V> computeNext() {
                    if (!this.f6195a.hasNext()) {
                        return (Map.Entry) endOfData();
                    }
                    c cVar = (c) this.f6195a.next();
                    return cVar.h().compareTo((Cut) d.this.f31957a.lowerBound) <= 0 ? (Map.Entry) endOfData() : Maps.O(cVar.getKey().intersection(d.this.f31957a), cVar.getValue());
                }
            }

            public a() {
                super();
            }

            @Override // com.google.common.collect.a0.d.b
            public Iterator<Map.Entry<Range<K>, V>> c() {
                return d.this.f31957a.isEmpty() ? Iterators.u() : new C0733a(a0.this.f6191a.headMap(d.this.f31957a.upperBound, false).descendingMap().values().iterator());
            }
        }

        public class b extends AbstractMap<Range<K>, V> {

            public class a extends Maps.u<Range<K>, V> {
                public a(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.u, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(@CheckForNull Object obj) {
                    return b.this.remove(obj) != null;
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return b.this.d(Predicates.h(Predicates.q(Predicates.n(collection)), Maps.R()));
                }
            }

            /* JADX INFO: renamed from: com.google.common.collect.a0$d$b$b, reason: collision with other inner class name */
            public class C0734b extends Maps.EntrySet<Range<K>, V> {
                public C0734b() {
                }

                @Override // com.google.common.collect.Maps.EntrySet
                public Map<Range<K>, V> b() {
                    return b.this;
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return !iterator().hasNext();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Map.Entry<Range<K>, V>> iterator() {
                    return b.this.c();
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return b.this.d(Predicates.q(Predicates.n(collection)));
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Iterators.Z(iterator());
                }
            }

            public class c extends AbstractIterator<Map.Entry<Range<K>, V>> {

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Iterator f6196a;

                public c(Iterator it) {
                    this.f6196a = it;
                }

                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                public Map.Entry<Range<K>, V> computeNext() {
                    while (this.f6196a.hasNext()) {
                        c cVar = (c) this.f6196a.next();
                        if (cVar.g().compareTo((Cut) d.this.f31957a.upperBound) >= 0) {
                            return (Map.Entry) endOfData();
                        }
                        if (cVar.h().compareTo((Cut) d.this.f31957a.lowerBound) > 0) {
                            return Maps.O(cVar.getKey().intersection(d.this.f31957a), cVar.getValue());
                        }
                    }
                    return (Map.Entry) endOfData();
                }
            }

            /* JADX INFO: renamed from: com.google.common.collect.a0$d$b$d, reason: collision with other inner class name */
            public class C0735d extends Maps.h0<Range<K>, V> {
                public C0735d(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection<?> collection) {
                    return b.this.d(Predicates.h(Predicates.n(collection), Maps.N0()));
                }

                @Override // com.google.common.collect.Maps.h0, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection<?> collection) {
                    return b.this.d(Predicates.h(Predicates.q(Predicates.n(collection)), Maps.N0()));
                }
            }

            public b() {
            }

            public Iterator<Map.Entry<Range<K>, V>> c() {
                if (d.this.f31957a.isEmpty()) {
                    return Iterators.u();
                }
                return new c(a0.this.f6191a.tailMap((Cut) com.google.common.base.e.a((Cut) a0.this.f6191a.floorKey(d.this.f31957a.lowerBound), d.this.f31957a.lowerBound), true).values().iterator());
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                d.this.clear();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(@CheckForNull Object obj) {
                return get(obj) != null;
            }

            public final boolean d(Predicate<? super Map.Entry<Range<K>, V>> predicate) {
                ArrayList arrayListQ = Lists.q();
                for (Map.Entry<Range<K>, V> entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        arrayListQ.add(entry.getKey());
                    }
                }
                Iterator it = arrayListQ.iterator();
                while (it.hasNext()) {
                    a0.this.remove((Range) it.next());
                }
                return !arrayListQ.isEmpty();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new C0734b();
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.AbstractMap, java.util.Map
            @CheckForNull
            public V get(@CheckForNull Object obj) {
                c cVar;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (d.this.f31957a.encloses(range) && !range.isEmpty()) {
                            if (range.lowerBound.compareTo((Cut) d.this.f31957a.lowerBound) == 0) {
                                Map.Entry entryFloorEntry = a0.this.f6191a.floorEntry(range.lowerBound);
                                cVar = entryFloorEntry != null ? (c) entryFloorEntry.getValue() : null;
                            } else {
                                cVar = (c) a0.this.f6191a.get(range.lowerBound);
                            }
                            if (cVar != null && cVar.getKey().isConnected(d.this.f31957a) && cVar.getKey().intersection(d.this.f31957a).equals(range)) {
                                return (V) cVar.getValue();
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Range<K>> keySet() {
                return new a(this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            @CheckForNull
            public V remove(@CheckForNull Object obj) {
                V v = (V) get(obj);
                if (v == null) {
                    return null;
                }
                Objects.requireNonNull(obj);
                a0.this.remove((Range) obj);
                return v;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new C0735d(this);
            }
        }

        public d(Range<K> range) {
            this.f31957a = range;
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asDescendingMapOfRanges() {
            return new a();
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asMapOfRanges() {
            return new b();
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
            a0.this.remove(this.f31957a);
        }

        @Override // com.google.common.collect.RangeMap
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof RangeMap) {
                return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
            }
            return false;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public V get(K k) {
            if (this.f31957a.contains(k)) {
                return (V) a0.this.get(k);
            }
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Map.Entry<Range<K>, V> getEntry(K k) {
            Map.Entry<Range<K>, V> entry;
            if (!this.f31957a.contains(k) || (entry = a0.this.getEntry(k)) == null) {
                return null;
            }
            return Maps.O(entry.getKey().intersection(this.f31957a), entry.getValue());
        }

        @Override // com.google.common.collect.RangeMap
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<K> range, V v) {
            com.google.common.base.i.y(this.f31957a.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.f31957a);
            a0.this.put(range, v);
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<K, V> rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            Range<K> rangeSpan = rangeMap.span();
            com.google.common.base.i.y(this.f31957a.encloses(rangeSpan), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", rangeSpan, this.f31957a);
            a0.this.putAll(rangeMap);
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range<K> range, V v) {
            if (a0.this.f6191a.isEmpty() || !this.f31957a.encloses(range)) {
                put(range, v);
            } else {
                put(a0.this.e(range, com.google.common.base.i.E(v)).intersection(this.f31957a), v);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.RangeMap
        public void remove(Range<K> range) {
            if (range.isConnected(this.f31957a)) {
                a0.this.remove(range.intersection(this.f31957a));
            }
        }

        @Override // com.google.common.collect.RangeMap
        public Range<K> span() {
            Cut cut;
            Map.Entry entryFloorEntry = a0.this.f6191a.floorEntry(this.f31957a.lowerBound);
            if (entryFloorEntry == null || ((c) entryFloorEntry.getValue()).h().compareTo((Cut) this.f31957a.lowerBound) <= 0) {
                cut = (Cut) a0.this.f6191a.ceilingKey(this.f31957a.lowerBound);
                if (cut == null || cut.compareTo((Cut) this.f31957a.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                cut = this.f31957a.lowerBound;
            }
            Map.Entry entryLowerEntry = a0.this.f6191a.lowerEntry(this.f31957a.upperBound);
            if (entryLowerEntry != null) {
                return Range.create(cut, ((c) entryLowerEntry.getValue()).h().compareTo((Cut) this.f31957a.upperBound) >= 0 ? this.f31957a.upperBound : ((c) entryLowerEntry.getValue()).h());
            }
            throw new NoSuchElementException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.RangeMap
        public RangeMap<K, V> subRangeMap(Range<K> range) {
            return !range.isConnected(this.f31957a) ? a0.this.g() : a0.this.subRangeMap(range.intersection(this.f31957a));
        }

        @Override // com.google.common.collect.RangeMap
        public String toString() {
            return asMapOfRanges().toString();
        }
    }

    public static <K extends Comparable, V> Range<K> d(Range<K> range, V v, @CheckForNull Map.Entry<Cut<K>, c<K, V>> entry) {
        return (entry != null && entry.getValue().getKey().isConnected(range) && entry.getValue().getValue().equals(v)) ? (Range<K>) range.span(entry.getValue().getKey()) : range;
    }

    public static <K extends Comparable, V> a0<K, V> f() {
        return new a0<>();
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new b(this.f6191a.descendingMap().values());
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new b(this.f6191a.values());
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.f6191a.clear();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Range<K> e(Range<K> range, V v) {
        return d(d(range, v, this.f6191a.lowerEntry((Cut<K>) range.lowerBound)), v, this.f6191a.floorEntry((Cut<K>) range.upperBound));
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    public final RangeMap<K, V> g() {
        return f31954a;
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public V get(K k) {
        Map.Entry<Range<K>, V> entry = getEntry(k);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K k) {
        Map.Entry<Cut<K>, c<K, V>> entryFloorEntry = this.f6191a.floorEntry(Cut.belowValue(k));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().a(k)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    public final void h(Cut<K> cut, Cut<K> cut2, V v) {
        this.f6191a.put(cut, new c<>(cut, cut2, v));
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> range, V v) {
        if (range.isEmpty()) {
            return;
        }
        com.google.common.base.i.E(v);
        remove(range);
        this.f6191a.put((Cut<K>) range.lowerBound, new c<>(range, v));
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, V> rangeMap) {
        for (Map.Entry<Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public void putCoalescing(Range<K> range, V v) {
        if (this.f6191a.isEmpty()) {
            put(range, v);
        } else {
            put(e(range, com.google.common.base.i.E(v)), v);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<K>, c<K, V>> entryLowerEntry = this.f6191a.lowerEntry((Cut<K>) range.lowerBound);
        if (entryLowerEntry != null) {
            c<K, V> value = entryLowerEntry.getValue();
            if (value.h().compareTo((Cut) range.lowerBound) > 0) {
                if (value.h().compareTo((Cut) range.upperBound) > 0) {
                    h(range.upperBound, value.h(), entryLowerEntry.getValue().getValue());
                }
                h(value.g(), range.lowerBound, entryLowerEntry.getValue().getValue());
            }
        }
        Map.Entry<Cut<K>, c<K, V>> entryLowerEntry2 = this.f6191a.lowerEntry((Cut<K>) range.upperBound);
        if (entryLowerEntry2 != null) {
            c<K, V> value2 = entryLowerEntry2.getValue();
            if (value2.h().compareTo((Cut) range.upperBound) > 0) {
                h(range.upperBound, value2.h(), entryLowerEntry2.getValue().getValue());
            }
        }
        this.f6191a.subMap((Cut<K>) range.lowerBound, (Cut<K>) range.upperBound).clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        Map.Entry<Cut<K>, c<K, V>> entryFirstEntry = this.f6191a.firstEntry();
        Map.Entry<Cut<K>, c<K, V>> entryLastEntry = this.f6191a.lastEntry();
        if (entryFirstEntry == null || entryLastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(entryFirstEntry.getValue().getKey().lowerBound, entryLastEntry.getValue().getKey().upperBound);
    }

    @Override // com.google.common.collect.RangeMap
    public RangeMap<K, V> subRangeMap(Range<K> range) {
        return range.equals(Range.all()) ? this : new d(range);
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return this.f6191a.values().toString();
    }
}
