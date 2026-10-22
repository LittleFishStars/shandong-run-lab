package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import com.google.j2objc.annotations.RetainedWith;
import com.zj.adlib.ay6;
import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
public final class ClosingFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f32330a = Logger.getLogger(ClosingFuture.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CloseableList f6503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FluentFuture<V> f6504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicReference<State> f6505a;

    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> call(m mVar) throws Exception;
    }

    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> a(m mVar, @ParametricNullness T t) throws Exception;
    }

    public interface ClosingCallable<V> {
        @ParametricNullness
        V call(m mVar) throws Exception;
    }

    public interface ClosingFunction<T, U> {
        @ParametricNullness
        U a(m mVar, @ParametricNullness T t) throws Exception;
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    public static class Combiner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Function<ClosingFuture<?>, FluentFuture<?>> f32331a = new c();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ImmutableList<ClosingFuture<?>> f6506a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CloseableList f6507a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f6508a;

        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> call(m mVar, n nVar) throws Exception;
        }

        public interface CombiningCallable<V> {
            @ParametricNullness
            V call(m mVar, n nVar) throws Exception;
        }

        public class a implements Callable<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CombiningCallable f32332a;

            public a(CombiningCallable combiningCallable) {
                this.f32332a = combiningCallable;
            }

            @Override // java.util.concurrent.Callable
            @ParametricNullness
            public V call() throws Exception {
                return (V) new n(Combiner.this.f6506a, null).call(this.f32332a, Combiner.this.f6507a);
            }

            public String toString() {
                return this.f32332a.toString();
            }
        }

        public class b implements AsyncCallable<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AsyncCombiningCallable f32333a;

            public b(AsyncCombiningCallable asyncCombiningCallable) {
                this.f32333a = asyncCombiningCallable;
            }

            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<V> call() throws Exception {
                return new n(Combiner.this.f6506a, null).c(this.f32333a, Combiner.this.f6507a);
            }

            public String toString() {
                return this.f32333a.toString();
            }
        }

        public class c implements Function<ClosingFuture<?>, FluentFuture<?>> {
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FluentFuture<?> apply(ClosingFuture<?> closingFuture) {
                return closingFuture.f6504a;
            }
        }

        public /* synthetic */ Combiner(boolean z, Iterable iterable, d dVar) {
            this(z, iterable);
        }

        public <V> ClosingFuture<V> b(AsyncCombiningCallable<V> asyncCombiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(c().a(new b(asyncCombiningCallable), executor), (d) null);
            closingFuture.f6503a.add(this.f6507a, com.google.common.util.concurrent.j.c());
            return closingFuture;
        }

        public final com.google.common.util.concurrent.f.e<Object> c() {
            return this.f6508a ? com.google.common.util.concurrent.f.B(d()) : com.google.common.util.concurrent.f.z(d());
        }

        public <V> ClosingFuture<V> call(CombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(c().call(new a(combiningCallable), executor), (d) null);
            closingFuture.f6503a.add(this.f6507a, com.google.common.util.concurrent.j.c());
            return closingFuture;
        }

        public final ImmutableList<FluentFuture<?>> d() {
            return FluentIterable.x(this.f6506a).T(f32331a).L();
        }

        public Combiner(boolean z, Iterable<? extends ClosingFuture<?>> iterable) {
            this.f6507a = new CloseableList(null);
            this.f6508a = z;
            this.f6506a = ImmutableList.copyOf(iterable);
            Iterator<? extends ClosingFuture<?>> it = iterable.iterator();
            while (it.hasNext()) {
                it.next().i(this.f6507a);
            }
        }
    }

    public static final class Combiner2<V1, V2> extends Combiner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClosingFuture<V1> f32334a;
        public final ClosingFuture<V2> b;

        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> a(m mVar, @ParametricNullness V1 v1, @ParametricNullness V2 v2) throws Exception;
        }

        public interface ClosingFunction2<V1, V2, U> {
            @ParametricNullness
            U a(m mVar, @ParametricNullness V1 v1, @ParametricNullness V2 v2) throws Exception;
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class a<U> implements Combiner.CombiningCallable<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ClosingFunction2 f32335a;

            public a(ClosingFunction2 closingFunction2) {
                this.f32335a = closingFunction2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            @ParametricNullness
            public U call(m mVar, n nVar) throws Exception {
                return (U) this.f32335a.a(mVar, nVar.d(Combiner2.this.f32334a), nVar.d(Combiner2.this.b));
            }

            public String toString() {
                return this.f32335a.toString();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class b<U> implements Combiner.AsyncCombiningCallable<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AsyncClosingFunction2 f32336a;

            public b(AsyncClosingFunction2 asyncClosingFunction2) {
                this.f32336a = asyncClosingFunction2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture<U> call(m mVar, n nVar) throws Exception {
                return this.f32336a.a(mVar, nVar.d(Combiner2.this.f32334a), nVar.d(Combiner2.this.b));
            }

            public String toString() {
                return this.f32336a.toString();
            }
        }

        public /* synthetic */ Combiner2(ClosingFuture closingFuture, ClosingFuture closingFuture2, d dVar) {
            this(closingFuture, closingFuture2);
        }

        public <U> ClosingFuture<U> call(ClosingFunction2<V1, V2, U> closingFunction2, Executor executor) {
            return call(new a(closingFunction2), executor);
        }

        public <U> ClosingFuture<U> g(AsyncClosingFunction2<V1, V2, U> asyncClosingFunction2, Executor executor) {
            return b(new b(asyncClosingFunction2), executor);
        }

        public Combiner2(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
            super(true, ImmutableList.of((ClosingFuture<V2>) closingFuture, closingFuture2), null);
            this.f32334a = closingFuture;
            this.b = closingFuture2;
        }
    }

    public static final class Combiner3<V1, V2, V3> extends Combiner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClosingFuture<V1> f32337a;
        public final ClosingFuture<V2> b;
        public final ClosingFuture<V3> c;

        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> a(m mVar, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3) throws Exception;
        }

        public interface ClosingFunction3<V1, V2, V3, U> {
            @ParametricNullness
            U a(m mVar, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3) throws Exception;
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class a<U> implements Combiner.CombiningCallable<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ClosingFunction3 f32338a;

            public a(ClosingFunction3 closingFunction3) {
                this.f32338a = closingFunction3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            @ParametricNullness
            public U call(m mVar, n nVar) throws Exception {
                return (U) this.f32338a.a(mVar, nVar.d(Combiner3.this.f32337a), nVar.d(Combiner3.this.b), nVar.d(Combiner3.this.c));
            }

            public String toString() {
                return this.f32338a.toString();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class b<U> implements Combiner.AsyncCombiningCallable<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AsyncClosingFunction3 f32339a;

            public b(AsyncClosingFunction3 asyncClosingFunction3) {
                this.f32339a = asyncClosingFunction3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture<U> call(m mVar, n nVar) throws Exception {
                return this.f32339a.a(mVar, nVar.d(Combiner3.this.f32337a), nVar.d(Combiner3.this.b), nVar.d(Combiner3.this.c));
            }

            public String toString() {
                return this.f32339a.toString();
            }
        }

        public /* synthetic */ Combiner3(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3);
        }

        public <U> ClosingFuture<U> call(ClosingFunction3<V1, V2, V3, U> closingFunction3, Executor executor) {
            return call(new a(closingFunction3), executor);
        }

        public <U> ClosingFuture<U> h(AsyncClosingFunction3<V1, V2, V3, U> asyncClosingFunction3, Executor executor) {
            return b(new b(asyncClosingFunction3), executor);
        }

        public Combiner3(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
            super(true, ImmutableList.of((ClosingFuture<V3>) closingFuture, (ClosingFuture<V3>) closingFuture2, closingFuture3), null);
            this.f32337a = closingFuture;
            this.b = closingFuture2;
            this.c = closingFuture3;
        }
    }

    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClosingFuture<V1> f32340a;
        public final ClosingFuture<V2> b;
        public final ClosingFuture<V3> c;
        public final ClosingFuture<V4> d;

        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> a(m mVar, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3, @ParametricNullness V4 v4) throws Exception;
        }

        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            @ParametricNullness
            U a(m mVar, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3, @ParametricNullness V4 v4) throws Exception;
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class a<U> implements Combiner.CombiningCallable<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ClosingFunction4 f32341a;

            public a(ClosingFunction4 closingFunction4) {
                this.f32341a = closingFunction4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            @ParametricNullness
            public U call(m mVar, n nVar) throws Exception {
                return (U) this.f32341a.a(mVar, nVar.d(Combiner4.this.f32340a), nVar.d(Combiner4.this.b), nVar.d(Combiner4.this.c), nVar.d(Combiner4.this.d));
            }

            public String toString() {
                return this.f32341a.toString();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class b<U> implements Combiner.AsyncCombiningCallable<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AsyncClosingFunction4 f32342a;

            public b(AsyncClosingFunction4 asyncClosingFunction4) {
                this.f32342a = asyncClosingFunction4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture<U> call(m mVar, n nVar) throws Exception {
                return this.f32342a.a(mVar, nVar.d(Combiner4.this.f32340a), nVar.d(Combiner4.this.b), nVar.d(Combiner4.this.c), nVar.d(Combiner4.this.d));
            }

            public String toString() {
                return this.f32342a.toString();
            }
        }

        public /* synthetic */ Combiner4(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3, closingFuture4);
        }

        public <U> ClosingFuture<U> call(ClosingFunction4<V1, V2, V3, V4, U> closingFunction4, Executor executor) {
            return call(new a(closingFunction4), executor);
        }

        public <U> ClosingFuture<U> i(AsyncClosingFunction4<V1, V2, V3, V4, U> asyncClosingFunction4, Executor executor) {
            return b(new b(asyncClosingFunction4), executor);
        }

        public Combiner4(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
            super(true, ImmutableList.of((ClosingFuture<V4>) closingFuture, (ClosingFuture<V4>) closingFuture2, (ClosingFuture<V4>) closingFuture3, closingFuture4), null);
            this.f32340a = closingFuture;
            this.b = closingFuture2;
            this.c = closingFuture3;
            this.d = closingFuture4;
        }
    }

    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClosingFuture<V1> f32343a;
        public final ClosingFuture<V2> b;
        public final ClosingFuture<V3> c;
        public final ClosingFuture<V4> d;
        public final ClosingFuture<V5> e;

        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> a(m mVar, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3, @ParametricNullness V4 v4, @ParametricNullness V5 v5) throws Exception;
        }

        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            @ParametricNullness
            U a(m mVar, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3, @ParametricNullness V4 v4, @ParametricNullness V5 v5) throws Exception;
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class a<U> implements Combiner.CombiningCallable<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ClosingFunction5 f32344a;

            public a(ClosingFunction5 closingFunction5) {
                this.f32344a = closingFunction5;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            @ParametricNullness
            public U call(m mVar, n nVar) throws Exception {
                return (U) this.f32344a.a(mVar, nVar.d(Combiner5.this.f32343a), nVar.d(Combiner5.this.b), nVar.d(Combiner5.this.c), nVar.d(Combiner5.this.d), nVar.d(Combiner5.this.e));
            }

            public String toString() {
                return this.f32344a.toString();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class b<U> implements Combiner.AsyncCombiningCallable<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AsyncClosingFunction5 f32345a;

            public b(AsyncClosingFunction5 asyncClosingFunction5) {
                this.f32345a = asyncClosingFunction5;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture<U> call(m mVar, n nVar) throws Exception {
                return this.f32345a.a(mVar, nVar.d(Combiner5.this.f32343a), nVar.d(Combiner5.this.b), nVar.d(Combiner5.this.c), nVar.d(Combiner5.this.d), nVar.d(Combiner5.this.e));
            }

            public String toString() {
                return this.f32345a.toString();
            }
        }

        public /* synthetic */ Combiner5(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, ClosingFuture closingFuture5, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5);
        }

        public <U> ClosingFuture<U> call(ClosingFunction5<V1, V2, V3, V4, V5, U> closingFunction5, Executor executor) {
            return call(new a(closingFunction5), executor);
        }

        public <U> ClosingFuture<U> j(AsyncClosingFunction5<V1, V2, V3, V4, V5, U> asyncClosingFunction5, Executor executor) {
            return b(new b(asyncClosingFunction5), executor);
        }

        public Combiner5(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
            super(true, ImmutableList.of((ClosingFuture<V5>) closingFuture, (ClosingFuture<V5>) closingFuture2, (ClosingFuture<V5>) closingFuture3, (ClosingFuture<V5>) closingFuture4, closingFuture5), null);
            this.f32343a = closingFuture;
            this.b = closingFuture2;
            this.c = closingFuture3;
            this.d = closingFuture4;
            this.e = closingFuture5;
        }
    }

    public enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    public interface ValueAndCloserConsumer<V> {
        void a(o<V> oVar);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAndCloserConsumer f32346a;

        public a(ValueAndCloserConsumer valueAndCloserConsumer) {
            this.f32346a = valueAndCloserConsumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture.x(this.f32346a, ClosingFuture.this);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Closeable f32347a;

        public b(Closeable closeable) {
            this.f32347a = closeable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f32347a.close();
            } catch (IOException | RuntimeException e) {
                ClosingFuture.f32330a.log(Level.WARNING, "thrown by close()", e);
            }
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32348a;

        static {
            int[] iArr = new int[State.values().length];
            f32348a = iArr;
            try {
                iArr[State.SUBSUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32348a[State.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32348a[State.WILL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32348a[State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32348a[State.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32348a[State.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class d implements FutureCallback<Closeable> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Executor f6520a;

        public d(Executor executor) {
            this.f6520a = executor;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@CheckForNull Closeable closeable) {
            ClosingFuture.this.f6503a.closer.a(closeable, this.f6520a);
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
        }
    }

    public class e implements Callable<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClosingCallable f32350a;

        public e(ClosingCallable closingCallable) {
            this.f32350a = closingCallable;
        }

        @Override // java.util.concurrent.Callable
        @ParametricNullness
        public V call() throws Exception {
            return (V) this.f32350a.call(ClosingFuture.this.f6503a.closer);
        }

        public String toString() {
            return this.f32350a.toString();
        }
    }

    public class f implements AsyncCallable<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncClosingCallable f32351a;

        public f(AsyncClosingCallable asyncClosingCallable) {
            this.f32351a = asyncClosingCallable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<V> call() throws Exception {
            CloseableList closeableList = new CloseableList(null);
            try {
                ClosingFuture<V> closingFutureCall = this.f32351a.call(closeableList.closer);
                closingFutureCall.i(ClosingFuture.this.f6503a);
                return closingFutureCall.f6504a;
            } finally {
                ClosingFuture.this.f6503a.add(closeableList, com.google.common.util.concurrent.j.c());
            }
        }

        public String toString() {
            return this.f32351a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    public class g<U> implements AsyncFunction<V, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClosingFunction f32352a;

        public g(ClosingFunction closingFunction) {
            this.f32352a = closingFunction;
        }

        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture<U> apply(V v) throws Exception {
            return ClosingFuture.this.f6503a.applyClosingFunction(this.f32352a, v);
        }

        public String toString() {
            return this.f32352a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    public class h<U> implements AsyncFunction<V, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncClosingFunction f32353a;

        public h(AsyncClosingFunction asyncClosingFunction) {
            this.f32353a = asyncClosingFunction;
        }

        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture<U> apply(V v) throws Exception {
            return ClosingFuture.this.f6503a.applyAsyncClosingFunction(this.f32353a, v);
        }

        public String toString() {
            return this.f32353a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    public class i<U> implements AsyncClosingFunction<V, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncFunction f32354a;

        public i(AsyncFunction asyncFunction) {
            this.f32354a = asyncFunction;
        }

        @Override // com.google.common.util.concurrent.ClosingFuture.AsyncClosingFunction
        public ClosingFuture<U> a(m mVar, V v) throws Exception {
            return ClosingFuture.w(this.f32354a.apply(v));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [W, X] */
    public class j<W, X> implements AsyncFunction<X, W> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClosingFunction f32355a;

        public j(ClosingFunction closingFunction) {
            this.f32355a = closingFunction;
        }

        /* JADX WARN: Incorrect types in method signature: (TX;)Lcom/google/common/util/concurrent/ListenableFuture<TW;>; */
        @Override // com.google.common.util.concurrent.AsyncFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListenableFuture apply(Throwable th) throws Exception {
            return ClosingFuture.this.f6503a.applyClosingFunction(this.f32355a, th);
        }

        public String toString() {
            return this.f32355a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [W, X] */
    public class k<W, X> implements AsyncFunction<X, W> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncClosingFunction f32356a;

        public k(AsyncClosingFunction asyncClosingFunction) {
            this.f32356a = asyncClosingFunction;
        }

        /* JADX WARN: Incorrect types in method signature: (TX;)Lcom/google/common/util/concurrent/ListenableFuture<TW;>; */
        @Override // com.google.common.util.concurrent.AsyncFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListenableFuture apply(Throwable th) throws Exception {
            return ClosingFuture.this.f6503a.applyAsyncClosingFunction(this.f32356a, th);
        }

        public String toString() {
            return this.f32356a.toString();
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture closingFuture = ClosingFuture.this;
            State state = State.WILL_CLOSE;
            State state2 = State.CLOSING;
            closingFuture.o(state, state2);
            ClosingFuture.this.p();
            ClosingFuture.this.o(state2, State.CLOSED);
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @RetainedWith
        public final CloseableList f32358a;

        public m(CloseableList closeableList) {
            this.f32358a = closeableList;
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public <C extends Closeable> C a(@ParametricNullness C c, Executor executor) {
            com.google.common.base.i.E(executor);
            if (c != null) {
                this.f32358a.add(c, executor);
            }
            return c;
        }
    }

    public static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList<ClosingFuture<?>> f32359a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile boolean f6527a;

        public /* synthetic */ n(ImmutableList immutableList, d dVar) {
            this(immutableList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @ParametricNullness
        public <V> V call(Combiner.CombiningCallable<V> combiningCallable, CloseableList closeableList) throws Exception {
            this.f6527a = true;
            CloseableList closeableList2 = new CloseableList(null);
            try {
                return combiningCallable.call(closeableList2.closer, this);
            } finally {
                closeableList.add(closeableList2, com.google.common.util.concurrent.j.c());
                this.f6527a = false;
            }
        }

        public final <V> FluentFuture<V> c(Combiner.AsyncCombiningCallable<V> asyncCombiningCallable, CloseableList closeableList) throws Exception {
            this.f6527a = true;
            CloseableList closeableList2 = new CloseableList(null);
            try {
                ClosingFuture<V> closingFutureCall = asyncCombiningCallable.call(closeableList2.closer, this);
                closingFutureCall.i(closeableList);
                return closingFutureCall.f6504a;
            } finally {
                closeableList.add(closeableList2, com.google.common.util.concurrent.j.c());
                this.f6527a = false;
            }
        }

        @ParametricNullness
        public final <D> D d(ClosingFuture<D> closingFuture) throws ExecutionException {
            com.google.common.base.i.g0(this.f6527a);
            com.google.common.base.i.d(this.f32359a.contains(closingFuture));
            return (D) com.google.common.util.concurrent.f.h(closingFuture.f6504a);
        }

        public n(ImmutableList<ClosingFuture<?>> immutableList) {
            this.f32359a = (ImmutableList) com.google.common.base.i.E(immutableList);
        }
    }

    public static final class o<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClosingFuture<? extends V> f32360a;

        public o(ClosingFuture<? extends V> closingFuture) {
            this.f32360a = (ClosingFuture) com.google.common.base.i.E(closingFuture);
        }

        public void a() {
            this.f32360a.p();
        }

        @ParametricNullness
        public V b() throws ExecutionException {
            return (V) com.google.common.util.concurrent.f.h(this.f32360a.f6504a);
        }
    }

    public /* synthetic */ ClosingFuture(ListenableFuture listenableFuture, d dVar) {
        this(listenableFuture);
    }

    public static <V> ClosingFuture<V> A(AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        return new ClosingFuture<>(asyncClosingCallable, executor);
    }

    public static Combiner D(ClosingFuture<?> closingFuture, ClosingFuture<?>... closingFutureArr) {
        return E(Lists.c(closingFuture, closingFutureArr));
    }

    public static Combiner E(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(false, iterable, null);
    }

    public static <V1, V2> Combiner2<V1, V2> F(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
        return new Combiner2<>(closingFuture, closingFuture2, null);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> G(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
        return new Combiner3<>(closingFuture, closingFuture2, closingFuture3, null);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> H(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
        return new Combiner4<>(closingFuture, closingFuture2, closingFuture3, closingFuture4, null);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> I(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
        return new Combiner5<>(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, null);
    }

    public static Combiner J(ClosingFuture<?> closingFuture, ClosingFuture<?> closingFuture2, ClosingFuture<?> closingFuture3, ClosingFuture<?> closingFuture4, ClosingFuture<?> closingFuture5, ClosingFuture<?> closingFuture6, ClosingFuture<?>... closingFutureArr) {
        return K(FluentIterable.I(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, closingFuture6).d(closingFutureArr));
    }

    public static Combiner K(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(true, iterable, null);
    }

    public static <V, U> AsyncClosingFunction<V, U> M(AsyncFunction<V, U> asyncFunction) {
        com.google.common.base.i.E(asyncFunction);
        return new i(asyncFunction);
    }

    public static void q(@CheckForNull Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new b(closeable));
        } catch (RejectedExecutionException e2) {
            Logger logger = f32330a;
            Level level = Level.WARNING;
            if (logger.isLoggable(level)) {
                logger.log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e2);
            }
            q(closeable, com.google.common.util.concurrent.j.c());
        }
    }

    @Deprecated
    public static <C extends Closeable> ClosingFuture<C> t(ListenableFuture<C> listenableFuture, Executor executor) {
        com.google.common.base.i.E(executor);
        ClosingFuture<C> closingFuture = new ClosingFuture<>(com.google.common.util.concurrent.f.q(listenableFuture));
        com.google.common.util.concurrent.f.a(listenableFuture, new d(executor), com.google.common.util.concurrent.j.c());
        return closingFuture;
    }

    public static <V> ClosingFuture<V> w(ListenableFuture<V> listenableFuture) {
        return new ClosingFuture<>(listenableFuture);
    }

    public static <C, V extends C> void x(ValueAndCloserConsumer<C> valueAndCloserConsumer, ClosingFuture<V> closingFuture) {
        valueAndCloserConsumer.a(new o<>(closingFuture));
    }

    public static <V> ClosingFuture<V> z(ClosingCallable<V> closingCallable, Executor executor) {
        return new ClosingFuture<>(closingCallable, executor);
    }

    public <U> ClosingFuture<U> B(ClosingFunction<? super V, U> closingFunction, Executor executor) {
        com.google.common.base.i.E(closingFunction);
        return s(this.f6504a.G(new g(closingFunction), executor));
    }

    public <U> ClosingFuture<U> C(AsyncClosingFunction<? super V, U> asyncClosingFunction, Executor executor) {
        com.google.common.base.i.E(asyncClosingFunction);
        return s(this.f6504a.G(new h(asyncClosingFunction), executor));
    }

    @VisibleForTesting
    public CountDownLatch L() {
        return this.f6503a.whenClosedCountDown();
    }

    public void finalize() {
        if (this.f6505a.get().equals(State.OPEN)) {
            f32330a.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            u();
        }
    }

    public final void i(CloseableList closeableList) {
        o(State.OPEN, State.SUBSUMED);
        closeableList.add(this.f6503a, com.google.common.util.concurrent.j.c());
    }

    @CanIgnoreReturnValue
    public boolean j(boolean z) {
        f32330a.log(Level.FINER, "cancelling {0}", this);
        boolean zCancel = this.f6504a.cancel(z);
        if (zCancel) {
            p();
        }
        return zCancel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> k(Class<X> cls, ClosingFunction<? super X, ? extends V> closingFunction, Executor executor) {
        return n(cls, closingFunction, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> l(Class<X> cls, AsyncClosingFunction<? super X, ? extends V> asyncClosingFunction, Executor executor) {
        return m(cls, asyncClosingFunction, executor);
    }

    public final <X extends Throwable, W extends V> ClosingFuture<V> m(Class<X> cls, AsyncClosingFunction<? super X, W> asyncClosingFunction, Executor executor) {
        com.google.common.base.i.E(asyncClosingFunction);
        return (ClosingFuture<V>) s(this.f6504a.C(cls, new k(asyncClosingFunction), executor));
    }

    public final <X extends Throwable, W extends V> ClosingFuture<V> n(Class<X> cls, ClosingFunction<? super X, W> closingFunction, Executor executor) {
        com.google.common.base.i.E(closingFunction);
        return (ClosingFuture<V>) s(this.f6504a.C(cls, new j(closingFunction), executor));
    }

    public final void o(State state, State state2) {
        com.google.common.base.i.B0(r(state, state2), "Expected state to be %s, but it was %s", state, state2);
    }

    public final void p() {
        f32330a.log(Level.FINER, "closing {0}", this);
        this.f6503a.close();
    }

    public final boolean r(State state, State state2) {
        return ay6.a(this.f6505a, state, state2);
    }

    public final <U> ClosingFuture<U> s(FluentFuture<U> fluentFuture) {
        ClosingFuture<U> closingFuture = new ClosingFuture<>(fluentFuture);
        i(closingFuture.f6503a);
        return closingFuture;
    }

    public String toString() {
        return com.google.common.base.e.c(this).f("state", this.f6505a.get()).s(this.f6504a).toString();
    }

    public FluentFuture<V> u() {
        if (!r(State.OPEN, State.WILL_CLOSE)) {
            switch (c.f32348a[this.f6505a.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        f32330a.log(Level.FINER, "will close {0}", this);
        this.f6504a.addListener(new l(), com.google.common.util.concurrent.j.c());
        return this.f6504a;
    }

    public void v(ValueAndCloserConsumer<? super V> valueAndCloserConsumer, Executor executor) {
        com.google.common.base.i.E(valueAndCloserConsumer);
        if (r(State.OPEN, State.WILL_CREATE_VALUE_AND_CLOSER)) {
            this.f6504a.addListener(new a(valueAndCloserConsumer), executor);
            return;
        }
        int i2 = c.f32348a[this.f6505a.get().ordinal()];
        if (i2 == 1) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
        }
        if (i2 == 2) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
        }
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            throw new AssertionError(this.f6505a);
        }
        throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
    }

    public ListenableFuture<?> y() {
        return com.google.common.util.concurrent.f.q(this.f6504a.F(Functions.b(null), com.google.common.util.concurrent.j.c()));
    }

    public static final class CloseableList extends IdentityHashMap<Closeable, Executor> implements Closeable {
        private volatile boolean closed;
        private final m closer;

        @CheckForNull
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new m(this);
        }

        public void add(@CheckForNull Closeable closeable, Executor executor) {
            com.google.common.base.i.E(executor);
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    ClosingFuture.q(closeable, executor);
                } else {
                    put(closeable, executor);
                }
            }
        }

        public <V, U> FluentFuture<U> applyAsyncClosingFunction(AsyncClosingFunction<V, U> asyncClosingFunction, @ParametricNullness V v) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> closingFutureA = asyncClosingFunction.a(closeableList.closer, v);
                closingFutureA.i(closeableList);
                return closingFutureA.f6504a;
            } finally {
                add(closeableList, com.google.common.util.concurrent.j.c());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <V, U> ListenableFuture<U> applyClosingFunction(ClosingFunction<? super V, U> closingFunction, @ParametricNullness V v) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return com.google.common.util.concurrent.f.m(closingFunction.a(closeableList.closer, v));
            } finally {
                add(closeableList, com.google.common.util.concurrent.j.c());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                for (Map.Entry<Closeable, Executor> entry : entrySet()) {
                    ClosingFuture.q(entry.getKey(), entry.getValue());
                }
                clear();
                if (this.whenClosed != null) {
                    this.whenClosed.countDown();
                }
            }
        }

        public CountDownLatch whenClosedCountDown() {
            if (this.closed) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                if (this.closed) {
                    return new CountDownLatch(0);
                }
                com.google.common.base.i.g0(this.whenClosed == null);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.whenClosed = countDownLatch;
                return countDownLatch;
            }
        }

        public /* synthetic */ CloseableList(d dVar) {
            this();
        }
    }

    public ClosingFuture(ListenableFuture<V> listenableFuture) {
        this.f6505a = new AtomicReference<>(State.OPEN);
        this.f6503a = new CloseableList(null);
        this.f6504a = FluentFuture.E(listenableFuture);
    }

    public ClosingFuture(ClosingCallable<V> closingCallable, Executor executor) {
        this.f6505a = new AtomicReference<>(State.OPEN);
        this.f6503a = new CloseableList(null);
        com.google.common.base.i.E(closingCallable);
        TrustedListenableFutureTask trustedListenableFutureTaskK = TrustedListenableFutureTask.K(new e(closingCallable));
        executor.execute(trustedListenableFutureTaskK);
        this.f6504a = trustedListenableFutureTaskK;
    }

    public ClosingFuture(AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        this.f6505a = new AtomicReference<>(State.OPEN);
        this.f6503a = new CloseableList(null);
        com.google.common.base.i.E(asyncClosingCallable);
        TrustedListenableFutureTask trustedListenableFutureTaskI = TrustedListenableFutureTask.I(new f(asyncClosingCallable));
        executor.execute(trustedListenableFutureTaskI);
        this.f6504a = trustedListenableFutureTaskI;
    }
}
