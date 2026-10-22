package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {

    @CheckForNull
    private transient Set<Range<C>> asDescendingSetOfRanges;

    @CheckForNull
    private transient Set<Range<C>> asRanges;

    @CheckForNull
    private transient RangeSet<C> complement;

    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    public final class Complement extends TreeRangeSet<C> {
        public Complement() {
            super(new c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C c) {
            return !TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    public final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        /* JADX WARN: Illegal instructions before constructor call */
        public SubRangeSet(Range<C> range) {
            super(new e(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            com.google.common.base.i.y(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C c) {
            return this.restriction.contains(c) && TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean encloses(Range<C> range) {
            Range rangeRangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeRangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeRangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        @CheckForNull
        public Range<C> rangeContaining(C c) {
            Range<C> rangeRangeContaining;
            if (this.restriction.contains(c) && (rangeRangeContaining = TreeRangeSet.this.rangeContaining(c)) != null) {
                return rangeRangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            return range.isConnected(this.restriction) ? new SubRangeSet(this.restriction.intersection(range)) : ImmutableRangeSet.of();
        }
    }

    public final class b extends ForwardingCollection<Range<C>> implements Set<Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<Range<C>> f31936a;

        public b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.f31936a = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.k(this);
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Range<C>> delegate() {
            return this.f31936a;
        }
    }

    public static final class c<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<Cut<C>> f31937a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final NavigableMap<Cut<C>, Range<C>> f6171a;
        public final NavigableMap<Cut<C>, Range<C>> b;

        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Cut<C> f31938a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ PeekingIterator f6172a;
            public final /* synthetic */ Cut b;

            public a(Cut cut, PeekingIterator peekingIterator) {
                this.b = cut;
                this.f6172a = peekingIterator;
                this.f31938a = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Map.Entry<Cut<C>, Range<C>> computeNext() {
                Range rangeCreate;
                if (c.this.f31937a.upperBound.isLessThan(this.f31938a) || this.f31938a == Cut.aboveAll()) {
                    return (Map.Entry) endOfData();
                }
                if (this.f6172a.hasNext()) {
                    Range range = (Range) this.f6172a.next();
                    rangeCreate = Range.create(this.f31938a, range.lowerBound);
                    this.f31938a = range.upperBound;
                } else {
                    rangeCreate = Range.create(this.f31938a, Cut.aboveAll());
                    this.f31938a = Cut.aboveAll();
                }
                return Maps.O(rangeCreate.lowerBound, rangeCreate);
            }
        }

        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Cut<C> f31939a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ PeekingIterator f6174a;
            public final /* synthetic */ Cut b;

            public b(Cut cut, PeekingIterator peekingIterator) {
                this.b = cut;
                this.f6174a = peekingIterator;
                this.f31939a = cut;
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
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Map.Entry<Cut<C>, Range<C>> computeNext() {
                if (this.f31939a == Cut.belowAll()) {
                    return (Map.Entry) endOfData();
                }
                if (this.f6174a.hasNext()) {
                    Range range = (Range) this.f6174a.next();
                    Range rangeCreate = Range.create(range.upperBound, this.f31939a);
                    this.f31939a = range.lowerBound;
                    if (c.this.f31937a.lowerBound.isLessThan(rangeCreate.lowerBound)) {
                        return Maps.O(rangeCreate.lowerBound, rangeCreate);
                    }
                } else if (c.this.f31937a.lowerBound.isLessThan(Cut.belowAll())) {
                    Range rangeCreate2 = Range.create(Cut.belowAll(), this.f31939a);
                    this.f31939a = Cut.belowAll();
                    return Maps.O(Cut.belowAll(), rangeCreate2);
                }
                return (Map.Entry) endOfData();
            }
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Collection<Range<C>> collectionValues;
            Cut cutBelowAll;
            if (this.f31937a.hasLowerBound()) {
                collectionValues = this.b.tailMap((Cut) this.f31937a.lowerEndpoint(), this.f31937a.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collectionValues = this.b.values();
            }
            PeekingIterator peekingIteratorT = Iterators.T(collectionValues.iterator());
            if (this.f31937a.contains(Cut.belowAll()) && (!peekingIteratorT.hasNext() || ((Range) peekingIteratorT.peek()).lowerBound != Cut.belowAll())) {
                cutBelowAll = Cut.belowAll();
            } else {
                if (!peekingIteratorT.hasNext()) {
                    return Iterators.u();
                }
                cutBelowAll = ((Range) peekingIteratorT.next()).upperBound;
            }
            return new a(cutBelowAll, peekingIteratorT);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            Cut<C> cutHigherKey;
            PeekingIterator peekingIteratorT = Iterators.T(this.b.headMap(this.f31937a.hasUpperBound() ? (Cut) this.f31937a.upperEndpoint() : Cut.aboveAll(), this.f31937a.hasUpperBound() && this.f31937a.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (peekingIteratorT.hasNext()) {
                cutHigherKey = ((Range) peekingIteratorT.peek()).upperBound == Cut.aboveAll() ? ((Range) peekingIteratorT.next()).lowerBound : this.f6171a.higherKey(((Range) peekingIteratorT.peek()).upperBound);
            } else {
                if (!this.f31937a.contains(Cut.belowAll()) || this.f6171a.containsKey(Cut.belowAll())) {
                    return Iterators.u();
                }
                cutHigherKey = this.f6171a.higherKey(Cut.belowAll());
            }
            return new b((Cut) com.google.common.base.e.a(cutHigherKey, Cut.aboveAll()), peekingIteratorT);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range<C> get(@CheckForNull Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> entryFirstEntry = tailMap(cut, true).firstEntry();
                    if (entryFirstEntry != null && entryFirstEntry.getKey().equals(cut)) {
                        return entryFirstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return h(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return h(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            if (!this.f31937a.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new c(this.f6171a, range.intersection(this.f31937a));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return h(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.Z(b());
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f6171a = navigableMap;
            this.b = new d(navigableMap);
            this.f31937a = range;
        }
    }

    public static final class e<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<Cut<C>> f31943a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final NavigableMap<Cut<C>, Range<C>> f6179a;
        public final Range<C> b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final NavigableMap<Cut<C>, Range<C>> f6180b;

        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Cut f31944a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6182a;

            public a(Iterator it, Cut cut) {
                this.f6182a = it;
                this.f31944a = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Map.Entry<Cut<C>, Range<C>> computeNext() {
                if (!this.f6182a.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.f6182a.next();
                if (this.f31944a.isLessThan(range.lowerBound)) {
                    return (Map.Entry) endOfData();
                }
                Range rangeIntersection = range.intersection(e.this.b);
                return Maps.O(rangeIntersection.lowerBound, rangeIntersection);
            }
        }

        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6183a;

            public b(Iterator it) {
                this.f6183a = it;
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
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Map.Entry<Cut<C>, Range<C>> computeNext() {
                if (!this.f6183a.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.f6183a.next();
                if (e.this.b.lowerBound.compareTo((Cut) range.upperBound) >= 0) {
                    return (Map.Entry) endOfData();
                }
                Range rangeIntersection = range.intersection(e.this.b);
                return e.this.f31943a.contains(rangeIntersection.lowerBound) ? Maps.O(rangeIntersection.lowerBound, rangeIntersection) : (Map.Entry) endOfData();
            }
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
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Iterator<Range<C>> it;
            if (!this.b.isEmpty() && !this.f31943a.upperBound.isLessThan(this.b.lowerBound)) {
                if (this.f31943a.lowerBound.isLessThan(this.b.lowerBound)) {
                    it = this.f6180b.tailMap(this.b.lowerBound, false).values().iterator();
                } else {
                    it = this.f6179a.tailMap((Cut) this.f31943a.lowerBound.endpoint(), this.f31943a.lowerBoundType() == BoundType.CLOSED).values().iterator();
                }
                return new a(it, (Cut) Ordering.natural().min(this.f31943a.upperBound, Cut.belowValue(this.b.upperBound)));
            }
            return Iterators.u();
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            if (this.b.isEmpty()) {
                return Iterators.u();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f31943a.upperBound, Cut.belowValue(this.b.upperBound));
            return new b(this.f6179a.headMap((Cut) cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
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
        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Range<C> get(@CheckForNull Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f31943a.contains(cut) && cut.compareTo((Cut) this.b.lowerBound) >= 0 && cut.compareTo((Cut) this.b.upperBound) < 0) {
                        if (cut.equals(this.b.lowerBound)) {
                            Range range = (Range) Maps.P0(this.f6179a.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.b.lowerBound) > 0) {
                                return range.intersection(this.b);
                            }
                        } else {
                            Range<C> range2 = this.f6179a.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return i(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return i(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<Cut<C>, Range<C>> i(Range<Cut<C>> range) {
            return !range.isConnected(this.f31943a) ? ImmutableSortedMap.of() : new e(this.f31943a.intersection(range), this.b, this.f6179a);
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return i(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.Z(b());
        }

        public e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f31943a = (Range) com.google.common.base.i.E(range);
            this.b = (Range) com.google.common.base.i.E(range2);
            this.f6179a = (NavigableMap) com.google.common.base.i.E(navigableMap);
            this.f6180b = new d(navigableMap);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public Range<C> rangeEnclosing(Range<C> range) {
        com.google.common.base.i.E(range);
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (entryFloorEntry == null || !entryFloorEntry.getValue().encloses(range)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void add(Range<C> range) {
        com.google.common.base.i.E(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (entryLowerEntry != null) {
            Range<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo((Cut) cut) >= 0) {
                if (value.upperBound.compareTo((Cut) cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (entryFloorEntry != null) {
            Range<C> value2 = entryFloorEntry.getValue();
            if (value2.upperBound.compareTo((Cut) cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> rangeSet = this.complement;
        if (rangeSet != null) {
            return rangeSet;
        }
        Complement complement = new Complement();
        this.complement = complement;
        return complement;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        com.google.common.base.i.E(range);
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return entryFloorEntry != null && entryFloorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        com.google.common.base.i.E(range);
        Map.Entry<Cut<C>, Range<C>> entryCeilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (entryCeilingEntry != null && entryCeilingEntry.getValue().isConnected(range) && !entryCeilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (entryLowerEntry == null || !entryLowerEntry.getValue().isConnected(range) || entryLowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @CheckForNull
    public Range<C> rangeContaining(C c2) {
        com.google.common.base.i.E(c2);
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c2));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().contains(c2)) {
            return null;
        }
        return entryFloorEntry.getValue();
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
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void remove(Range<C> range) {
        com.google.common.base.i.E(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (entryLowerEntry != null) {
            Range<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo((Cut) range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo((Cut) range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (entryFloorEntry != null) {
            Range<C> value2 = entryFloorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo((Cut) range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> entryFirstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> entryLastEntry = this.rangesByLowerBound.lastEntry();
        if (entryFirstEntry == null || entryLastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(entryFirstEntry.getValue().lowerBound, entryLastEntry.getValue().upperBound);
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(range);
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> rangeSet) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(rangeSet);
        return treeRangeSetCreate;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    @VisibleForTesting
    public static final class d<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<Cut<C>> f31940a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final NavigableMap<Cut<C>, Range<C>> f6176a;

        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6177a;

            public a(Iterator it) {
                this.f6177a = it;
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
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Map.Entry<Cut<C>, Range<C>> computeNext() {
                if (!this.f6177a.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.f6177a.next();
                return d.this.f31940a.upperBound.isLessThan(range.upperBound) ? (Map.Entry) endOfData() : Maps.O(range.upperBound, range);
            }
        }

        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PeekingIterator f31942a;

            public b(PeekingIterator peekingIterator) {
                this.f31942a = peekingIterator;
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
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Map.Entry<Cut<C>, Range<C>> computeNext() {
                if (!this.f31942a.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.f31942a.next();
                return d.this.f31940a.lowerBound.isLessThan(range.upperBound) ? Maps.O(range.upperBound, range) : (Map.Entry) endOfData();
            }
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f6176a = navigableMap;
            this.f31940a = Range.all();
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
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Map.Entry<Cut<C>, Range<C>> entryLowerEntry;
            Iterator<Range<C>> it;
            if (this.f31940a.hasLowerBound() && (entryLowerEntry = this.f6176a.lowerEntry((Cut) this.f31940a.lowerEndpoint())) != null) {
                it = this.f31940a.lowerBound.isLessThan(entryLowerEntry.getValue().upperBound) ? this.f6176a.tailMap(entryLowerEntry.getKey(), true).values().iterator() : this.f6176a.tailMap((Cut) this.f31940a.lowerEndpoint(), true).values().iterator();
            } else {
                it = this.f6176a.values().iterator();
            }
            return new a(it);
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
        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            PeekingIterator peekingIteratorT = Iterators.T((this.f31940a.hasUpperBound() ? this.f6176a.headMap((Cut) this.f31940a.upperEndpoint(), false).descendingMap().values() : this.f6176a.descendingMap().values()).iterator());
            if (peekingIteratorT.hasNext() && this.f31940a.upperBound.isLessThan(((Range) peekingIteratorT.peek()).upperBound)) {
                peekingIteratorT.next();
            }
            return new b(peekingIteratorT);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range<C> get(@CheckForNull Object obj) {
            Map.Entry<Cut<C>, Range<C>> entryLowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f31940a.contains(cut) && (entryLowerEntry = this.f6176a.lowerEntry(cut)) != null && entryLowerEntry.getValue().upperBound.equals(cut)) {
                        return entryLowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return h(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return h(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            return range.isConnected(this.f31940a) ? new d(this.f6176a, range.intersection(this.f31940a)) : ImmutableSortedMap.of();
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return h(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f31940a.equals(Range.all())) {
                return this.f6176a.isEmpty();
            }
            return !b().hasNext();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f31940a.equals(Range.all()) ? this.f6176a.size() : Iterators.Z(b());
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f6176a = navigableMap;
            this.f31940a = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(iterable);
        return treeRangeSetCreate;
    }
}
