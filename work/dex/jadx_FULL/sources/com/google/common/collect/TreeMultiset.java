package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private final transient e<E> header;
    private final transient GeneralRange<E> range;
    private final transient f<e<E>> rootReference;

    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return eVar.f31934a;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@CheckForNull e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f6166a;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@CheckForNull e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.b;
            }
        };

        public abstract int nodeAggregate(e<?> eVar);

        public abstract long treeAggregate(@CheckForNull e<?> eVar);

        /* synthetic */ Aggregate(a aVar) {
            this();
        }
    }

    public class a extends Multisets.AbstractEntry<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f31930a;

        public a(e eVar) {
            this.f31930a = eVar;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            int iW = this.f31930a.w();
            return iW == 0 ? TreeMultiset.this.count(getElement()) : iW;
        }

        @Override // com.google.common.collect.Multiset.Entry
        @ParametricNullness
        public E getElement() {
            return (E) this.f31930a.x();
        }
    }

    public class b implements Iterator<Multiset.Entry<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public Multiset.Entry<E> f31931a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public e<E> f6162a;

        public b() {
            this.f6162a = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Multiset.Entry<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeMultiset treeMultiset = TreeMultiset.this;
            e<E> eVar = this.f6162a;
            Objects.requireNonNull(eVar);
            Multiset.Entry<E> entryWrapEntry = treeMultiset.wrapEntry(eVar);
            this.f31931a = entryWrapEntry;
            if (this.f6162a.L() == TreeMultiset.this.header) {
                this.f6162a = null;
            } else {
                this.f6162a = this.f6162a.L();
            }
            return entryWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6162a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooHigh(this.f6162a.x())) {
                return true;
            }
            this.f6162a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.i.h0(this.f31931a != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f31931a.getElement(), 0);
            this.f31931a = null;
        }
    }

    public class c implements Iterator<Multiset.Entry<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public Multiset.Entry<E> f31932a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public e<E> f6164a;

        public c() {
            this.f6164a = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Multiset.Entry<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Objects.requireNonNull(this.f6164a);
            Multiset.Entry<E> entryWrapEntry = TreeMultiset.this.wrapEntry(this.f6164a);
            this.f31932a = entryWrapEntry;
            if (this.f6164a.z() == TreeMultiset.this.header) {
                this.f6164a = null;
            } else {
                this.f6164a = this.f6164a.z();
            }
            return entryWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6164a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooLow(this.f6164a.x())) {
                return true;
            }
            this.f6164a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.i.h0(this.f31932a != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f31932a.getElement(), 0);
            this.f31932a = null;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31933a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f31933a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31933a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public T f31935a;

        public f() {
        }

        public void a(@CheckForNull T t, @CheckForNull T t2) {
            if (this.f31935a != t) {
                throw new ConcurrentModificationException();
            }
            this.f31935a = t2;
        }

        public void b() {
            this.f31935a = null;
        }

        @CheckForNull
        public T c() {
            return this.f31935a;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public TreeMultiset(f<e<E>> fVar, GeneralRange<E> generalRange, e<E> eVar) {
        super(generalRange.comparator());
        this.rootReference = fVar;
        this.range = generalRange;
        this.header = eVar;
    }

    private long aggregateAboveRange(Aggregate aggregate, @CheckForNull e<E> eVar) {
        long jTreeAggregate;
        long jAggregateAboveRange;
        if (eVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(q.a(this.range.getUpperEndpoint()), eVar.x());
        if (iCompare > 0) {
            return aggregateAboveRange(aggregate, eVar.f6169b);
        }
        if (iCompare == 0) {
            int i = d.f31933a[this.range.getUpperBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(eVar.f6169b);
                }
                throw new AssertionError();
            }
            jTreeAggregate = aggregate.nodeAggregate(eVar);
            jAggregateAboveRange = aggregate.treeAggregate(eVar.f6169b);
        } else {
            jTreeAggregate = aggregate.treeAggregate(eVar.f6169b) + ((long) aggregate.nodeAggregate(eVar));
            jAggregateAboveRange = aggregateAboveRange(aggregate, eVar.f6167a);
        }
        return jTreeAggregate + jAggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, @CheckForNull e<E> eVar) {
        long jTreeAggregate;
        long jAggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(q.a(this.range.getLowerEndpoint()), eVar.x());
        if (iCompare < 0) {
            return aggregateBelowRange(aggregate, eVar.f6167a);
        }
        if (iCompare == 0) {
            int i = d.f31933a[this.range.getLowerBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(eVar.f6167a);
                }
                throw new AssertionError();
            }
            jTreeAggregate = aggregate.nodeAggregate(eVar);
            jAggregateBelowRange = aggregate.treeAggregate(eVar.f6167a);
        } else {
            jTreeAggregate = aggregate.treeAggregate(eVar.f6167a) + ((long) aggregate.nodeAggregate(eVar));
            jAggregateBelowRange = aggregateBelowRange(aggregate, eVar.f6169b);
        }
        return jTreeAggregate + jAggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        e<E> eVarC = this.rootReference.c();
        long jTreeAggregate = aggregate.treeAggregate(eVarC);
        if (this.range.hasLowerBound()) {
            jTreeAggregate -= aggregateBelowRange(aggregate, eVarC);
        }
        return this.range.hasUpperBound() ? jTreeAggregate - aggregateAboveRange(aggregate, eVarC) : jTreeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public e<E> firstNode() {
        e<E> eVarL;
        e<E> eVarC = this.rootReference.c();
        if (eVarC == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            Object objA = q.a(this.range.getLowerEndpoint());
            eVarL = eVarC.s(comparator(), objA);
            if (eVarL == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(objA, eVarL.x()) == 0) {
                eVarL = eVarL.L();
            }
        } else {
            eVarL = this.header.L();
        }
        if (eVarL == this.header || !this.range.contains(eVarL.x())) {
            return null;
        }
        return eVarL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public e<E> lastNode() {
        e<E> eVarZ;
        e<E> eVarC = this.rootReference.c();
        if (eVarC == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            Object objA = q.a(this.range.getUpperEndpoint());
            eVarZ = eVarC.v(comparator(), objA);
            if (eVarZ == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(objA, eVarZ.x()) == 0) {
                eVarZ = eVarZ.z();
            }
        } else {
            eVarZ = this.header.z();
        }
        if (eVarZ == this.header || !this.range.contains(eVarZ.x())) {
            return null;
        }
        return eVarZ;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        w.a(AbstractSortedMultiset.class, "comparator").b(this, comparator);
        w.a(TreeMultiset.class, com.google.android.exoplayer2.source.rtsp.i.m).b(this, GeneralRange.all(comparator));
        w.a(TreeMultiset.class, "rootReference").b(this, new f(null));
        e eVar = new e();
        w.a(TreeMultiset.class, "header").b(this, eVar);
        successor(eVar, eVar);
        w.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2) {
        eVar.d = eVar2;
        eVar2.f6170c = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(e<E> eVar) {
        return new a(eVar);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        w.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@ParametricNullness E e2, int i) {
        com.google.common.collect.a.b(i, "occurrences");
        if (i == 0) {
            return count(e2);
        }
        com.google.common.base.i.d(this.range.contains(e2));
        e<E> eVarC = this.rootReference.c();
        if (eVarC != null) {
            int[] iArr = new int[1];
            this.rootReference.a(eVarC, eVarC.o(comparator(), e2, i, iArr));
            return iArr[0];
        }
        comparator().compare(e2, e2);
        e<E> eVar = new e<>(e2, i);
        e<E> eVar2 = this.header;
        successor(eVar2, eVar, eVar2);
        this.rootReference.a(eVarC, eVar);
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.h(entryIterator());
            return;
        }
        e<E> eVarL = this.header.L();
        while (true) {
            e<E> eVar = this.header;
            if (eVarL == eVar) {
                successor(eVar, eVar);
                this.rootReference.b();
                return;
            }
            e<E> eVarL2 = eVarL.L();
            eVarL.f31934a = 0;
            eVarL.f6167a = null;
            eVarL.f6169b = null;
            eVarL.f6170c = null;
            eVarL.d = null;
            eVarL = eVarL2;
        }
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        try {
            e<E> eVarC = this.rootReference.c();
            if (this.range.contains(obj) && eVarC != null) {
                return eVarC.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    public Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public int distinctElements() {
        return Ints.x(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<E> elementIterator() {
        return Multisets.h(entryIterator());
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@ParametricNullness E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e2, boundType)), this.header);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i) {
        com.google.common.collect.a.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        e<E> eVarC = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && eVarC != null) {
                this.rootReference.a(eVarC, eVarC.E(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@ParametricNullness E e2, int i) {
        com.google.common.collect.a.b(i, "count");
        if (!this.range.contains(e2)) {
            com.google.common.base.i.d(i == 0);
            return 0;
        }
        e<E> eVarC = this.rootReference.c();
        if (eVarC == null) {
            if (i > 0) {
                add(e2, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(eVarC, eVarC.K(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.x(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@ParametricNullness Object obj, BoundType boundType, @ParametricNullness Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@ParametricNullness E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e2, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static int distinctElements(@CheckForNull e<?> eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2, e<T> eVar3) {
        successor(eVar, eVar2);
        successor(eVar2, eVar3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> treeMultisetCreate = create();
        o.a(treeMultisetCreate, iterable);
        return treeMultisetCreate;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        e<E> eVar = new e<>();
        this.header = eVar;
        successor(eVar, eVar);
        this.rootReference = new f<>(null);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@ParametricNullness E e2, int i, int i2) {
        com.google.common.collect.a.b(i2, "newCount");
        com.google.common.collect.a.b(i, "oldCount");
        com.google.common.base.i.d(this.range.contains(e2));
        e<E> eVarC = this.rootReference.c();
        if (eVarC != null) {
            int[] iArr = new int[1];
            this.rootReference.a(eVarC, eVarC.J(comparator(), e2, i, i2, iArr));
            return iArr[0] == i;
        }
        if (i != 0) {
            return false;
        }
        if (i2 > 0) {
            add(e2, i2);
        }
        return true;
    }

    public static final class e<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31934a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f6166a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public e<E> f6167a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public final E f6168a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @CheckForNull
        public e<E> f6169b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @CheckForNull
        public e<E> f6170c;

        @CheckForNull
        public e<E> d;

        public e(@ParametricNullness E e, int i) {
            com.google.common.base.i.d(i > 0);
            this.f6168a = e;
            this.f31934a = i;
            this.f6166a = i;
            this.b = 1;
            this.c = 1;
            this.f6167a = null;
            this.f6169b = null;
        }

        public static long M(@CheckForNull e<?> eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f6166a;
        }

        public static int y(@CheckForNull e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.c;
        }

        public final e<E> A() {
            int iR = r();
            if (iR == -2) {
                Objects.requireNonNull(this.f6169b);
                if (this.f6169b.r() > 0) {
                    this.f6169b = this.f6169b.I();
                }
                return H();
            }
            if (iR != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f6167a);
            if (this.f6167a.r() < 0) {
                this.f6167a = this.f6167a.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.c = Math.max(y(this.f6167a), y(this.f6169b)) + 1;
        }

        public final void D() {
            this.b = TreeMultiset.distinctElements(this.f6167a) + 1 + TreeMultiset.distinctElements(this.f6169b);
            this.f6166a = ((long) this.f31934a) + M(this.f6167a) + M(this.f6169b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public e<E> E(Comparator<? super E> comparator, @ParametricNullness E e, int i, int[] iArr) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                e<E> eVar = this.f6167a;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f6167a = eVar.E(comparator, e, i, iArr);
                int i2 = iArr[0];
                if (i2 > 0) {
                    if (i >= i2) {
                        this.b--;
                        this.f6166a -= (long) i2;
                    } else {
                        this.f6166a -= (long) i;
                    }
                }
                return i2 == 0 ? this : A();
            }
            if (iCompare <= 0) {
                int i3 = this.f31934a;
                iArr[0] = i3;
                if (i >= i3) {
                    return u();
                }
                this.f31934a = i3 - i;
                this.f6166a -= (long) i;
                return this;
            }
            e<E> eVar2 = this.f6169b;
            if (eVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f6169b = eVar2.E(comparator, e, i, iArr);
            int i4 = iArr[0];
            if (i4 > 0) {
                if (i >= i4) {
                    this.b--;
                    this.f6166a -= (long) i4;
                } else {
                    this.f6166a -= (long) i;
                }
            }
            return A();
        }

        @CheckForNull
        public final e<E> F(e<E> eVar) {
            e<E> eVar2 = this.f6169b;
            if (eVar2 == null) {
                return this.f6167a;
            }
            this.f6169b = eVar2.F(eVar);
            this.b--;
            this.f6166a -= (long) eVar.f31934a;
            return A();
        }

        @CheckForNull
        public final e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f6167a;
            if (eVar2 == null) {
                return this.f6169b;
            }
            this.f6167a = eVar2.G(eVar);
            this.b--;
            this.f6166a -= (long) eVar.f31934a;
            return A();
        }

        public final e<E> H() {
            com.google.common.base.i.g0(this.f6169b != null);
            e<E> eVar = this.f6169b;
            this.f6169b = eVar.f6167a;
            eVar.f6167a = this;
            eVar.f6166a = this.f6166a;
            eVar.b = this.b;
            B();
            eVar.C();
            return eVar;
        }

        public final e<E> I() {
            com.google.common.base.i.g0(this.f6167a != null);
            e<E> eVar = this.f6167a;
            this.f6167a = eVar.f6169b;
            eVar.f6169b = this;
            eVar.f6166a = this.f6166a;
            eVar.b = this.b;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public e<E> J(Comparator<? super E> comparator, @ParametricNullness E e, int i, int i2, int[] iArr) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                e<E> eVar = this.f6167a;
                if (eVar == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : p(e, i2);
                }
                this.f6167a = eVar.J(comparator, e, i, i2, iArr);
                int i3 = iArr[0];
                if (i3 == i) {
                    if (i2 == 0 && i3 != 0) {
                        this.b--;
                    } else if (i2 > 0 && i3 == 0) {
                        this.b++;
                    }
                    this.f6166a += (long) (i2 - i3);
                }
                return A();
            }
            if (iCompare <= 0) {
                int i4 = this.f31934a;
                iArr[0] = i4;
                if (i == i4) {
                    if (i2 == 0) {
                        return u();
                    }
                    this.f6166a += (long) (i2 - i4);
                    this.f31934a = i2;
                }
                return this;
            }
            e<E> eVar2 = this.f6169b;
            if (eVar2 == null) {
                iArr[0] = 0;
                return (i != 0 || i2 <= 0) ? this : q(e, i2);
            }
            this.f6169b = eVar2.J(comparator, e, i, i2, iArr);
            int i5 = iArr[0];
            if (i5 == i) {
                if (i2 == 0 && i5 != 0) {
                    this.b--;
                } else if (i2 > 0 && i5 == 0) {
                    this.b++;
                }
                this.f6166a += (long) (i2 - i5);
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public e<E> K(Comparator<? super E> comparator, @ParametricNullness E e, int i, int[] iArr) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                e<E> eVar = this.f6167a;
                if (eVar == null) {
                    iArr[0] = 0;
                    return i > 0 ? p(e, i) : this;
                }
                this.f6167a = eVar.K(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.b--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.b++;
                }
                this.f6166a += (long) (i - iArr[0]);
                return A();
            }
            if (iCompare <= 0) {
                int i2 = this.f31934a;
                iArr[0] = i2;
                if (i == 0) {
                    return u();
                }
                this.f6166a += (long) (i - i2);
                this.f31934a = i;
                return this;
            }
            e<E> eVar2 = this.f6169b;
            if (eVar2 == null) {
                iArr[0] = 0;
                return i > 0 ? q(e, i) : this;
            }
            this.f6169b = eVar2.K(comparator, e, i, iArr);
            if (i == 0 && iArr[0] != 0) {
                this.b--;
            } else if (i > 0 && iArr[0] == 0) {
                this.b++;
            }
            this.f6166a += (long) (i - iArr[0]);
            return A();
        }

        public final e<E> L() {
            e<E> eVar = this.d;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> o(Comparator<? super E> comparator, @ParametricNullness E e, int i, int[] iArr) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                e<E> eVar = this.f6167a;
                if (eVar == null) {
                    iArr[0] = 0;
                    return p(e, i);
                }
                int i2 = eVar.c;
                e<E> eVarO = eVar.o(comparator, e, i, iArr);
                this.f6167a = eVarO;
                if (iArr[0] == 0) {
                    this.b++;
                }
                this.f6166a += (long) i;
                return eVarO.c == i2 ? this : A();
            }
            if (iCompare <= 0) {
                int i3 = this.f31934a;
                iArr[0] = i3;
                long j = i;
                com.google.common.base.i.d(((long) i3) + j <= 2147483647L);
                this.f31934a += i;
                this.f6166a += j;
                return this;
            }
            e<E> eVar2 = this.f6169b;
            if (eVar2 == null) {
                iArr[0] = 0;
                return q(e, i);
            }
            int i4 = eVar2.c;
            e<E> eVarO2 = eVar2.o(comparator, e, i, iArr);
            this.f6169b = eVarO2;
            if (iArr[0] == 0) {
                this.b++;
            }
            this.f6166a += (long) i;
            return eVarO2.c == i4 ? this : A();
        }

        public final e<E> p(@ParametricNullness E e, int i) {
            this.f6167a = new e<>(e, i);
            TreeMultiset.successor(z(), this.f6167a, this);
            this.c = Math.max(2, this.c);
            this.b++;
            this.f6166a += (long) i;
            return this;
        }

        public final e<E> q(@ParametricNullness E e, int i) {
            e<E> eVar = new e<>(e, i);
            this.f6169b = eVar;
            TreeMultiset.successor(this, eVar, L());
            this.c = Math.max(2, this.c);
            this.b++;
            this.f6166a += (long) i;
            return this;
        }

        public final int r() {
            return y(this.f6167a) - y(this.f6169b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final e<E> s(Comparator<? super E> comparator, @ParametricNullness E e) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                e<E> eVar = this.f6167a;
                return eVar == null ? this : (e) com.google.common.base.e.a(eVar.s(comparator, e), this);
            }
            if (iCompare == 0) {
                return this;
            }
            e<E> eVar2 = this.f6169b;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.s(comparator, e);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int t(Comparator<? super E> comparator, @ParametricNullness E e) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                e<E> eVar = this.f6167a;
                if (eVar == null) {
                    return 0;
                }
                return eVar.t(comparator, e);
            }
            if (iCompare <= 0) {
                return this.f31934a;
            }
            e<E> eVar2 = this.f6169b;
            if (eVar2 == null) {
                return 0;
            }
            return eVar2.t(comparator, e);
        }

        public String toString() {
            return Multisets.k(x(), w()).toString();
        }

        @CheckForNull
        public final e<E> u() {
            int i = this.f31934a;
            this.f31934a = 0;
            TreeMultiset.successor(z(), L());
            e<E> eVar = this.f6167a;
            if (eVar == null) {
                return this.f6169b;
            }
            e<E> eVar2 = this.f6169b;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.c >= eVar2.c) {
                e<E> eVarZ = z();
                eVarZ.f6167a = this.f6167a.F(eVarZ);
                eVarZ.f6169b = this.f6169b;
                eVarZ.b = this.b - 1;
                eVarZ.f6166a = this.f6166a - ((long) i);
                return eVarZ.A();
            }
            e<E> eVarL = L();
            eVarL.f6169b = this.f6169b.G(eVarL);
            eVarL.f6167a = this.f6167a;
            eVarL.b = this.b - 1;
            eVarL.f6166a = this.f6166a - ((long) i);
            return eVarL.A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final e<E> v(Comparator<? super E> comparator, @ParametricNullness E e) {
            int iCompare = comparator.compare(e, x());
            if (iCompare > 0) {
                e<E> eVar = this.f6169b;
                return eVar == null ? this : (e) com.google.common.base.e.a(eVar.v(comparator, e), this);
            }
            if (iCompare == 0) {
                return this;
            }
            e<E> eVar2 = this.f6167a;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.v(comparator, e);
        }

        public int w() {
            return this.f31934a;
        }

        @ParametricNullness
        public E x() {
            return (E) q.a(this.f6168a);
        }

        public final e<E> z() {
            e<E> eVar = this.f6170c;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        public e() {
            this.f6168a = null;
            this.f31934a = 1;
        }
    }
}
