package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Multisets {

    public static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return getCount() == entry.getCount() && com.google.common.base.g.a(getElement(), entry.getElement());
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String strValueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
            sb.append(strValueOf);
            sb.append(" x ");
            sb.append(count);
            return sb.toString();
        }
    }

    public static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        public abstract Multiset<E> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return b().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return b().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract Iterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            return b().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().entrySet().size();
        }
    }

    public static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        public abstract Multiset<E> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && b().count(entry.getElement()) == entry.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                Object element = entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return b().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    public static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @ParametricNullness
        private final E element;

        public ImmutableEntry(@ParametricNullness E e, int i) {
            this.element = e;
            this.count = i;
            com.google.common.collect.a.b(i, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.Multiset.Entry
        @ParametricNullness
        public final E getElement() {
            return this.element;
        }

        @CheckForNull
        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    public static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multiset<? extends E> delegate;

        @CheckForNull
        transient Set<E> elementSet;

        @CheckForNull
        transient Set<Multiset.Entry<E>> entrySet;

        public UnmodifiableMultiset(Multiset<? extends E> multiset) {
            this.delegate = multiset;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness E e) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            Set<E> setCreateElementSet = createElementSet();
            this.elementSet = setCreateElementSet;
            return setCreateElementSet;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Multiset.Entry<E>> setUnmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.f0(this.delegate.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int setCount(@ParametricNullness E e, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int add(@ParametricNullness E e, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object obj, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean setCount(@ParametricNullness E e, int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Multiset<E> delegate() {
            return this.delegate;
        }
    }

    public static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
        public ViewMultiset() {
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public int distinctElements() {
            return elementSet().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<E> iterator() {
            return Multisets.n(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return Multisets.o(this);
        }

        public /* synthetic */ ViewMultiset(a aVar) {
            this();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class a<E> extends ViewMultiset<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Multiset f31855a;
        public final /* synthetic */ Multiset b;

        /* JADX INFO: renamed from: com.google.common.collect.Multisets$a$a, reason: collision with other inner class name */
        public class C0724a extends AbstractIterator<Multiset.Entry<E>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6126a;
            public final /* synthetic */ Iterator b;

            public C0724a(Iterator it, Iterator it2) {
                this.f6126a = it;
                this.b = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Multiset.Entry<E> computeNext() {
                if (this.f6126a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.f6126a.next();
                    Object element = entry.getElement();
                    return Multisets.k(element, Math.max(entry.getCount(), a.this.b.count(element)));
                }
                while (this.b.hasNext()) {
                    Multiset.Entry entry2 = (Multiset.Entry) this.b.next();
                    Object element2 = entry2.getElement();
                    if (!a.this.f31855a.contains(element2)) {
                        return Multisets.k(element2, entry2.getCount());
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Multiset multiset, Multiset multiset2) {
            super(null);
            this.f31855a = multiset;
            this.b = multiset2;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@CheckForNull Object obj) {
            return this.f31855a.contains(obj) || this.b.contains(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object obj) {
            return Math.max(this.f31855a.count(obj), this.b.count(obj));
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Set<E> createElementSet() {
            return Sets.N(this.f31855a.elementSet(), this.b.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<Multiset.Entry<E>> entryIterator() {
            return new C0724a(this.f31855a.entrySet().iterator(), this.b.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f31855a.isEmpty() && this.b.isEmpty();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class b<E> extends ViewMultiset<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Multiset f31857a;
        public final /* synthetic */ Multiset b;

        public class a extends AbstractIterator<Multiset.Entry<E>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6127a;

            public a(Iterator it) {
                this.f6127a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Multiset.Entry<E> computeNext() {
                while (this.f6127a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.f6127a.next();
                    Object element = entry.getElement();
                    int iMin = Math.min(entry.getCount(), b.this.b.count(element));
                    if (iMin > 0) {
                        return Multisets.k(element, iMin);
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Multiset multiset, Multiset multiset2) {
            super(null);
            this.f31857a = multiset;
            this.b = multiset2;
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object obj) {
            int iCount = this.f31857a.count(obj);
            if (iCount == 0) {
                return 0;
            }
            return Math.min(iCount, this.b.count(obj));
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Set<E> createElementSet() {
            return Sets.n(this.f31857a.elementSet(), this.b.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<Multiset.Entry<E>> entryIterator() {
            return new a(this.f31857a.entrySet().iterator());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class c<E> extends ViewMultiset<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Multiset f31859a;
        public final /* synthetic */ Multiset b;

        public class a extends AbstractIterator<Multiset.Entry<E>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6128a;
            public final /* synthetic */ Iterator b;

            public a(Iterator it, Iterator it2) {
                this.f6128a = it;
                this.b = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Multiset.Entry<E> computeNext() {
                if (this.f6128a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.f6128a.next();
                    Object element = entry.getElement();
                    return Multisets.k(element, entry.getCount() + c.this.b.count(element));
                }
                while (this.b.hasNext()) {
                    Multiset.Entry entry2 = (Multiset.Entry) this.b.next();
                    Object element2 = entry2.getElement();
                    if (!c.this.f31859a.contains(element2)) {
                        return Multisets.k(element2, entry2.getCount());
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Multiset multiset, Multiset multiset2) {
            super(null);
            this.f31859a = multiset;
            this.b = multiset2;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@CheckForNull Object obj) {
            return this.f31859a.contains(obj) || this.b.contains(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object obj) {
            return this.f31859a.count(obj) + this.b.count(obj);
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Set<E> createElementSet() {
            return Sets.N(this.f31859a.elementSet(), this.b.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<Multiset.Entry<E>> entryIterator() {
            return new a(this.f31859a.entrySet().iterator(), this.b.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f31859a.isEmpty() && this.b.isEmpty();
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return com.google.common.math.e.t(this.f31859a.size(), this.b.size());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class d<E> extends ViewMultiset<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Multiset f31861a;
        public final /* synthetic */ Multiset b;

        public class a extends AbstractIterator<E> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6129a;

            public a(Iterator it) {
                this.f6129a = it;
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
            public E computeNext() {
                while (this.f6129a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.f6129a.next();
                    E e = (E) entry.getElement();
                    if (entry.getCount() > d.this.b.count(e)) {
                        return e;
                    }
                }
                return endOfData();
            }
        }

        public class b extends AbstractIterator<Multiset.Entry<E>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6130a;

            public b(Iterator it) {
                this.f6130a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Multiset.Entry<E> computeNext() {
                while (this.f6130a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.f6130a.next();
                    Object element = entry.getElement();
                    int count = entry.getCount() - d.this.b.count(element);
                    if (count > 0) {
                        return Multisets.k(element, count);
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Multiset multiset, Multiset multiset2) {
            super(null);
            this.f31861a = multiset;
            this.b = multiset2;
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object obj) {
            int iCount = this.f31861a.count(obj);
            if (iCount == 0) {
                return 0;
            }
            return Math.max(0, iCount - this.b.count(obj));
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset
        public int distinctElements() {
            return Iterators.Z(entryIterator());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<E> elementIterator() {
            return new a(this.f31861a.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<Multiset.Entry<E>> entryIterator() {
            return new b(this.f31861a.entrySet().iterator());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class e<E> extends TransformedIterator<Multiset.Entry<E>, E> {
        public e(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.TransformedIterator
        @ParametricNullness
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(Multiset.Entry<E> entry) {
            return entry.getElement();
        }
    }

    public static final class f implements Comparator<Multiset.Entry<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f31864a = new f();

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Multiset.Entry<?> entry, Multiset.Entry<?> entry2) {
            return entry2.getCount() - entry.getCount();
        }
    }

    public static final class g<E> extends ViewMultiset<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Predicate<? super E> f31865a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Multiset<E> f6131a;

        public class a implements Predicate<Multiset.Entry<E>> {
            public a() {
            }

            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Multiset.Entry<E> entry) {
                return g.this.f31865a.apply(entry.getElement());
            }
        }

        public g(Multiset<E> multiset, Predicate<? super E> predicate) {
            super(null);
            this.f6131a = (Multiset) com.google.common.base.i.E(multiset);
            this.f31865a = (Predicate) com.google.common.base.i.E(predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int add(@ParametricNullness E e, int i) {
            com.google.common.base.i.y(this.f31865a.apply(e), "Element %s does not match predicate %s", e, this.f31865a);
            return this.f6131a.add(e, i);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object obj) {
            int iCount = this.f6131a.count(obj);
            if (iCount <= 0 || !this.f31865a.apply(obj)) {
                return 0;
            }
            return iCount;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Set<E> createElementSet() {
            return Sets.i(this.f6131a.elementSet(), this.f31865a);
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Set<Multiset.Entry<E>> createEntrySet() {
            return Sets.i(this.f6131a.entrySet(), new a());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<Multiset.Entry<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<E> iterator() {
            return Iterators.x(this.f6131a.iterator(), this.f31865a);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object obj, int i) {
            com.google.common.collect.a.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            if (contains(obj)) {
                return this.f6131a.remove(obj, i);
            }
            return 0;
        }
    }

    public static final class h<E> implements Iterator<E> {
        public int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public Multiset.Entry<E> f31867a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Multiset<E> f6132a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Iterator<Multiset.Entry<E>> f6133a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6134a;

        public h(Multiset<E> multiset, Iterator<Multiset.Entry<E>> it) {
            this.f6132a = multiset;
            this.f6133a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.K > 0 || this.f6133a.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.K == 0) {
                Multiset.Entry<E> next = this.f6133a.next();
                this.f31867a = next;
                int count = next.getCount();
                this.K = count;
                this.L = count;
            }
            this.K--;
            this.f6134a = true;
            Multiset.Entry<E> entry = this.f31867a;
            Objects.requireNonNull(entry);
            return entry.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.a.e(this.f6134a);
            if (this.L == 1) {
                this.f6133a.remove();
            } else {
                Multiset<E> multiset = this.f6132a;
                Multiset.Entry<E> entry = this.f31867a;
                Objects.requireNonNull(entry);
                multiset.remove(entry.getElement());
            }
            this.L--;
            this.f6134a = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> A(Multiset<? extends E> multiset) {
        return ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new UnmodifiableMultiset((Multiset) com.google.common.base.i.E(multiset));
    }

    @Beta
    public static <E> SortedMultiset<E> B(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset) com.google.common.base.i.E(sortedMultiset));
    }

    public static <E> boolean a(Multiset<E> multiset, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(multiset);
        return true;
    }

    public static <E> boolean b(Multiset<E> multiset, Multiset<? extends E> multiset2) {
        if (multiset2 instanceof AbstractMapBasedMultiset) {
            return a(multiset, (AbstractMapBasedMultiset) multiset2);
        }
        if (multiset2.isEmpty()) {
            return false;
        }
        for (Multiset.Entry<? extends E> entry : multiset2.entrySet()) {
            multiset.add(entry.getElement(), entry.getCount());
        }
        return true;
    }

    public static <E> boolean c(Multiset<E> multiset, Collection<? extends E> collection) {
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(collection);
        if (collection instanceof Multiset) {
            return b(multiset, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(multiset, collection.iterator());
    }

    public static <T> Multiset<T> d(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    @CanIgnoreReturnValue
    public static boolean e(Multiset<?> multiset, Multiset<?> multiset2) {
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(multiset2);
        for (Multiset.Entry<?> entry : multiset2.entrySet()) {
            if (multiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    @Beta
    public static <E> ImmutableMultiset<E> f(Multiset<E> multiset) {
        Multiset.Entry[] entryArr = (Multiset.Entry[]) multiset.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(entryArr, f.f31864a);
        return ImmutableMultiset.copyFromEntries(Arrays.asList(entryArr));
    }

    @Beta
    public static <E> Multiset<E> g(Multiset<E> multiset, Multiset<?> multiset2) {
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(multiset2);
        return new d(multiset, multiset2);
    }

    public static <E> Iterator<E> h(Iterator<Multiset.Entry<E>> it) {
        return new e(it);
    }

    public static boolean i(Multiset<?> multiset, @CheckForNull Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Beta
    public static <E> Multiset<E> j(Multiset<E> multiset, Predicate<? super E> predicate) {
        if (!(multiset instanceof g)) {
            return new g(multiset, predicate);
        }
        g gVar = (g) multiset;
        return new g(gVar.f6131a, Predicates.d(gVar.f31865a, predicate));
    }

    public static <E> Multiset.Entry<E> k(@ParametricNullness E e2, int i) {
        return new ImmutableEntry(e2, i);
    }

    public static int l(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> Multiset<E> m(Multiset<E> multiset, Multiset<?> multiset2) {
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(multiset2);
        return new b(multiset, multiset2);
    }

    public static <E> Iterator<E> n(Multiset<E> multiset) {
        return new h(multiset, multiset.entrySet().iterator());
    }

    public static int o(Multiset<?> multiset) {
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        long count = 0;
        while (it.hasNext()) {
            count += (long) it.next().getCount();
        }
        return Ints.x(count);
    }

    public static boolean p(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean q(Multiset<?> multiset, Multiset<?> multiset2) {
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(multiset2);
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<?> next = it.next();
            int iCount = multiset2.count(next.getElement());
            if (iCount >= next.getCount()) {
                it.remove();
            } else if (iCount > 0) {
                multiset.remove(next.getElement(), iCount);
            }
            z = true;
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean r(Multiset<?> multiset, Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return q(multiset, (Multiset) iterable);
        }
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(iterable);
        Iterator<?> it = iterable.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= multiset.remove(it.next());
        }
        return zRemove;
    }

    public static boolean s(Multiset<?> multiset, Collection<?> collection) {
        com.google.common.base.i.E(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean t(Multiset<?> multiset, Multiset<?> multiset2) {
        return u(multiset, multiset2);
    }

    public static <E> boolean u(Multiset<E> multiset, Multiset<?> multiset2) {
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(multiset2);
        Iterator<Multiset.Entry<E>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            int iCount = multiset2.count(next.getElement());
            if (iCount == 0) {
                it.remove();
            } else if (iCount < next.getCount()) {
                multiset.setCount(next.getElement(), iCount);
            }
            z = true;
        }
        return z;
    }

    public static <E> int v(Multiset<E> multiset, @ParametricNullness E e2, int i) {
        com.google.common.collect.a.b(i, "count");
        int iCount = multiset.count(e2);
        int i2 = i - iCount;
        if (i2 > 0) {
            multiset.add(e2, i2);
        } else if (i2 < 0) {
            multiset.remove(e2, -i2);
        }
        return iCount;
    }

    public static <E> boolean w(Multiset<E> multiset, @ParametricNullness E e2, int i, int i2) {
        com.google.common.collect.a.b(i, "oldCount");
        com.google.common.collect.a.b(i2, "newCount");
        if (multiset.count(e2) != i) {
            return false;
        }
        multiset.setCount(e2, i2);
        return true;
    }

    @Beta
    public static <E> Multiset<E> x(Multiset<? extends E> multiset, Multiset<? extends E> multiset2) {
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(multiset2);
        return new c(multiset, multiset2);
    }

    @Beta
    public static <E> Multiset<E> y(Multiset<? extends E> multiset, Multiset<? extends E> multiset2) {
        com.google.common.base.i.E(multiset);
        com.google.common.base.i.E(multiset2);
        return new a(multiset, multiset2);
    }

    @Deprecated
    public static <E> Multiset<E> z(ImmutableMultiset<E> immutableMultiset) {
        return (Multiset) com.google.common.base.i.E(immutableMultiset);
    }
}
