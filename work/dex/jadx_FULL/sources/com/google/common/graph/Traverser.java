package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotMock;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
public abstract class Traverser<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SuccessorsFunction<N> f32084a;

    public enum InsertionOrder {
        FRONT { // from class: com.google.common.graph.Traverser.InsertionOrder.1
            @Override // com.google.common.graph.Traverser.InsertionOrder
            public <T> void insertInto(Deque<T> deque, T t) {
                deque.addFirst(t);
            }
        },
        BACK { // from class: com.google.common.graph.Traverser.InsertionOrder.2
            @Override // com.google.common.graph.Traverser.InsertionOrder
            public <T> void insertInto(Deque<T> deque, T t) {
                deque.addLast(t);
            }
        };

        public abstract <T> void insertInto(Deque<T> deque, T t);

        /* synthetic */ InsertionOrder(a aVar) {
            this();
        }
    }

    public static abstract class Traversal<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SuccessorsFunction<N> f32085a;

        public class a extends Traversal<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Set f32086a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(SuccessorsFunction successorsFunction, Set set) {
                super(successorsFunction);
                this.f32086a = set;
            }

            @Override // com.google.common.graph.Traverser.Traversal
            @CheckForNull
            public N g(Deque<Iterator<? extends N>> deque) {
                Iterator<? extends N> first = deque.getFirst();
                while (first.hasNext()) {
                    N next = first.next();
                    Objects.requireNonNull(next);
                    if (this.f32086a.add(next)) {
                        return next;
                    }
                }
                deque.removeFirst();
                return null;
            }
        }

        public class b extends Traversal<N> {
            public b(SuccessorsFunction successorsFunction) {
                super(successorsFunction);
            }

            @Override // com.google.common.graph.Traverser.Traversal
            @CheckForNull
            public N g(Deque<Iterator<? extends N>> deque) {
                Iterator<? extends N> first = deque.getFirst();
                if (first.hasNext()) {
                    return (N) com.google.common.base.i.E(first.next());
                }
                deque.removeFirst();
                return null;
            }
        }

        public class c extends AbstractIterator<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InsertionOrder f32087a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Deque f6279a;

            public c(Deque deque, InsertionOrder insertionOrder) {
                this.f6279a = deque;
                this.f32087a = insertionOrder;
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
            public N computeNext() {
                do {
                    N n = (N) Traversal.this.g(this.f6279a);
                    if (n != null) {
                        Iterator<? extends N> it = Traversal.this.f32085a.b(n).iterator();
                        if (it.hasNext()) {
                            this.f32087a.insertInto(this.f6279a, it);
                        }
                        return n;
                    }
                } while (!this.f6279a.isEmpty());
                return endOfData();
            }
        }

        public class d extends AbstractIterator<N> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Deque f6280a;
            public final /* synthetic */ Deque b;

            public d(Deque deque, Deque deque2) {
                this.f6280a = deque;
                this.b = deque2;
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
            public N computeNext() {
                while (true) {
                    N n = (N) Traversal.this.g(this.f6280a);
                    if (n == null) {
                        return !this.b.isEmpty() ? (N) this.b.pop() : endOfData();
                    }
                    Iterator<? extends N> it = Traversal.this.f32085a.b(n).iterator();
                    if (!it.hasNext()) {
                        return n;
                    }
                    this.f6280a.addFirst(it);
                    this.b.push(n);
                }
            }
        }

        public Traversal(SuccessorsFunction<N> successorsFunction) {
            this.f32085a = successorsFunction;
        }

        public static <N> Traversal<N> b(SuccessorsFunction<N> successorsFunction) {
            return new a(successorsFunction, new HashSet());
        }

        public static <N> Traversal<N> c(SuccessorsFunction<N> successorsFunction) {
            return new b(successorsFunction);
        }

        public final Iterator<N> a(Iterator<? extends N> it) {
            return f(it, InsertionOrder.BACK);
        }

        public final Iterator<N> d(Iterator<? extends N> it) {
            ArrayDeque arrayDeque = new ArrayDeque();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(it);
            return new d(arrayDeque2, arrayDeque);
        }

        public final Iterator<N> e(Iterator<? extends N> it) {
            return f(it, InsertionOrder.FRONT);
        }

        public final Iterator<N> f(Iterator<? extends N> it, InsertionOrder insertionOrder) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(it);
            return new c(arrayDeque, insertionOrder);
        }

        @CheckForNull
        public abstract N g(Deque<Iterator<? extends N>> deque);
    }

    public class a extends Traverser<N> {
        public final /* synthetic */ SuccessorsFunction b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SuccessorsFunction successorsFunction, SuccessorsFunction successorsFunction2) {
            super(successorsFunction, null);
            this.b = successorsFunction2;
        }

        @Override // com.google.common.graph.Traverser
        public Traversal<N> i() {
            return Traversal.b(this.b);
        }
    }

    public class b extends Traverser<N> {
        public final /* synthetic */ SuccessorsFunction b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SuccessorsFunction successorsFunction, SuccessorsFunction successorsFunction2) {
            super(successorsFunction, null);
            this.b = successorsFunction2;
        }

        @Override // com.google.common.graph.Traverser
        public Traversal<N> i() {
            return Traversal.c(this.b);
        }
    }

    public class c implements Iterable<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmutableSet f32089a;

        public c(ImmutableSet immutableSet) {
            this.f32089a = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.i().a(this.f32089a.iterator());
        }
    }

    public class d implements Iterable<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmutableSet f32090a;

        public d(ImmutableSet immutableSet) {
            this.f32090a = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.i().e(this.f32090a.iterator());
        }
    }

    public class e implements Iterable<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmutableSet f32091a;

        public e(ImmutableSet immutableSet) {
            this.f32091a = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.i().d(this.f32091a.iterator());
        }
    }

    public /* synthetic */ Traverser(SuccessorsFunction successorsFunction, a aVar) {
        this(successorsFunction);
    }

    public static <N> Traverser<N> g(SuccessorsFunction<N> successorsFunction) {
        return new a(successorsFunction, successorsFunction);
    }

    public static <N> Traverser<N> h(SuccessorsFunction<N> successorsFunction) {
        if (successorsFunction instanceof BaseGraph) {
            com.google.common.base.i.e(((BaseGraph) successorsFunction).j(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            com.google.common.base.i.e(((Network) successorsFunction).j(), "Undirected networks can never be trees.");
        }
        return new b(successorsFunction, successorsFunction);
    }

    public final Iterable<N> a(Iterable<? extends N> iterable) {
        return new c(j(iterable));
    }

    public final Iterable<N> b(N n) {
        return a(ImmutableSet.of(n));
    }

    public final Iterable<N> c(Iterable<? extends N> iterable) {
        return new e(j(iterable));
    }

    public final Iterable<N> d(N n) {
        return c(ImmutableSet.of(n));
    }

    public final Iterable<N> e(Iterable<? extends N> iterable) {
        return new d(j(iterable));
    }

    public final Iterable<N> f(N n) {
        return e(ImmutableSet.of(n));
    }

    public abstract Traversal<N> i();

    public final ImmutableSet<N> j(Iterable<? extends N> iterable) {
        ImmutableSet<N> immutableSetCopyOf = ImmutableSet.copyOf(iterable);
        UnmodifiableIterator<N> it = immutableSetCopyOf.iterator();
        while (it.hasNext()) {
            this.f32084a.b(it.next());
        }
        return immutableSetCopyOf;
    }

    public Traverser(SuccessorsFunction<N> successorsFunction) {
        this.f32084a = (SuccessorsFunction) com.google.common.base.i.E(successorsFunction);
    }
}
