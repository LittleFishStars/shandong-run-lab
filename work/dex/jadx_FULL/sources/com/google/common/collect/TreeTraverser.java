package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible
@Deprecated
@ElementTypesAreNonnullByDefault
public abstract class TreeTraverser<T> {

    public class a extends TreeTraverser<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f31946a;

        public a(Function function) {
            this.f31946a = function;
        }

        @Override // com.google.common.collect.TreeTraverser
        public Iterable<T> b(T t) {
            return (Iterable) this.f31946a.apply(t);
        }
    }

    public class b extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6184a;

        public b(Object obj) {
            this.f6184a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<T> iterator() {
            return TreeTraverser.this.e(this.f6184a);
        }
    }

    public class c extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6185a;

        public c(Object obj) {
            this.f6185a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<T> iterator() {
            return TreeTraverser.this.c(this.f6185a);
        }
    }

    public class d extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6186a;

        public d(Object obj) {
            this.f6186a = obj;
        }

        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<T> iterator() {
            return new e(this.f6186a);
        }
    }

    public final class e extends UnmodifiableIterator<T> implements PeekingIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Queue<T> f6187a;

        public e(T t) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f6187a = arrayDeque;
            arrayDeque.add(t);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f6187a.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T tRemove = this.f6187a.remove();
            o.a(this.f6187a, TreeTraverser.this.b(tRemove));
            return tRemove;
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.f6187a.element();
        }
    }

    public final class f extends AbstractIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ArrayDeque<g<T>> f6188a;

        public f(T t) {
            ArrayDeque<g<T>> arrayDeque = new ArrayDeque<>();
            this.f6188a = arrayDeque;
            arrayDeque.addLast(b(t));
        }

        public final g<T> b(T t) {
            return new g<>(t, TreeTraverser.this.b(t).iterator());
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public T computeNext() {
            while (!this.f6188a.isEmpty()) {
                g<T> last = this.f6188a.getLast();
                if (!last.f6189a.hasNext()) {
                    this.f6188a.removeLast();
                    return last.f31952a;
                }
                this.f6188a.addLast(b(last.f6189a.next()));
            }
            return endOfData();
        }
    }

    public static final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f31952a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Iterator<T> f6189a;

        public g(T t, Iterator<T> it) {
            this.f31952a = (T) com.google.common.base.i.E(t);
            this.f6189a = (Iterator) com.google.common.base.i.E(it);
        }
    }

    public final class h extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Deque<Iterator<T>> f6190a;

        public h(T t) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f6190a = arrayDeque;
            arrayDeque.addLast(Iterators.Y(com.google.common.base.i.E(t)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f6190a.isEmpty();
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
        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.f6190a.getLast();
            T t = (T) com.google.common.base.i.E(last.next());
            if (!last.hasNext()) {
                this.f6190a.removeLast();
            }
            Iterator<T> it = TreeTraverser.this.b(t).iterator();
            if (it.hasNext()) {
                this.f6190a.addLast(it);
            }
            return t;
        }
    }

    @Deprecated
    public static <T> TreeTraverser<T> g(Function<T, ? extends Iterable<T>> function) {
        com.google.common.base.i.E(function);
        return new a(function);
    }

    @Deprecated
    public final FluentIterable<T> a(T t) {
        com.google.common.base.i.E(t);
        return new d(t);
    }

    public abstract Iterable<T> b(T t);

    public UnmodifiableIterator<T> c(T t) {
        return new f(t);
    }

    @Deprecated
    public final FluentIterable<T> d(T t) {
        com.google.common.base.i.E(t);
        return new c(t);
    }

    public UnmodifiableIterator<T> e(T t) {
        return new h(t);
    }

    @Deprecated
    public final FluentIterable<T> f(T t) {
        com.google.common.base.i.E(t);
        return new b(t);
    }
}
