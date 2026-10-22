package com.google.common.util.concurrent;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import com.zj.adlib.fd4;
import com.zj.adlib.fr;
import com.zj.adlib.xlc;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f32286a = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicHelper f6459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f6460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f6461a;
    public static final Object b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public volatile c f6462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public volatile h f6463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public volatile Object f6464a;

    public static abstract class AtomicHelper {
        public AtomicHelper() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, @CheckForNull c cVar, c cVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, @CheckForNull h hVar, @CheckForNull h hVar2);

        public abstract void d(h hVar, @CheckForNull h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    public static final class Failure {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Failure f32287a = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Throwable f6465a;

        public Failure(Throwable th) {
            this.f6465a = (Throwable) com.google.common.base.i.E(th);
        }
    }

    public interface Trusted<V> extends ListenableFuture<V> {
    }

    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        @ParametricNullness
        public V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        @ParametricNullness
        public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public static final b f32288a;

        @CheckForNull
        public static final b b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public final Throwable f6466a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f6467a;

        static {
            if (AbstractFuture.f6461a) {
                b = null;
                f32288a = null;
            } else {
                b = new b(false, null);
                f32288a = new b(true, null);
            }
        }

        public b(boolean z, @CheckForNull Throwable th) {
            this.f6467a = z;
            this.f6466a = th;
        }
    }

    public static final class d extends AtomicHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f32290a;
        public final AtomicReferenceFieldUpdater<h, h> b;
        public final AtomicReferenceFieldUpdater<AbstractFuture, h> c;
        public final AtomicReferenceFieldUpdater<AbstractFuture, c> d;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> e;

        public d(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, c> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f32290a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull c cVar, c cVar2) {
            return fr.a(this.d, abstractFuture, cVar, cVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return fr.a(this.e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull h hVar, @CheckForNull h hVar2) {
            return fr.a(this.c, abstractFuture, hVar, hVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void d(h hVar, @CheckForNull h hVar2) {
            this.b.lazySet(hVar, hVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void e(h hVar, Thread thread) {
            this.f32290a.lazySet(hVar, thread);
        }
    }

    public static final class e<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractFuture<V> f32291a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ListenableFuture<? extends V> f6470a;

        public e(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f32291a = abstractFuture;
            this.f6470a = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f32291a.f6464a != this) {
                return;
            }
            if (AbstractFuture.f6459a.b(this.f32291a, this, AbstractFuture.v(this.f6470a))) {
                AbstractFuture.s(this.f32291a);
            }
        }
    }

    public static final class f extends AtomicHelper {
        public f() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull c cVar, c cVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f6462a != cVar) {
                    return false;
                }
                abstractFuture.f6462a = cVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f6464a != obj) {
                    return false;
                }
                abstractFuture.f6464a = obj2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull h hVar, @CheckForNull h hVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f6463a != hVar) {
                    return false;
                }
                abstractFuture.f6463a = hVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void d(h hVar, @CheckForNull h hVar2) {
            hVar.f32293a = hVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void e(h hVar, Thread thread) {
            hVar.f6472a = thread;
        }
    }

    public static final class g extends AtomicHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long f32292a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final Unsafe f6471a;
        public static final long b;
        public static final long c;
        public static final long d;
        public static final long e;

        public class a implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("a"));
                f32292a = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("a"));
                c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("a"));
                d = unsafe.objectFieldOffset(h.class.getDeclaredField("a"));
                e = unsafe.objectFieldOffset(h.class.getDeclaredField("a"));
                f6471a = unsafe;
            } catch (Exception e3) {
                com.google.common.base.m.w(e3);
                throw new RuntimeException(e3);
            }
        }

        public g() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull c cVar, c cVar2) {
            return xlc.a(f6471a, abstractFuture, f32292a, cVar, cVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return xlc.a(f6471a, abstractFuture, c, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull h hVar, @CheckForNull h hVar2) {
            return xlc.a(f6471a, abstractFuture, b, hVar, hVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void d(h hVar, @CheckForNull h hVar2) {
            f6471a.putObject(hVar, e, hVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void e(h hVar, Thread thread) {
            f6471a.putObject(hVar, d, thread);
        }
    }

    public static final class h {
        public static final h b = new h(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public volatile h f32293a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public volatile Thread f6472a;

        public h(boolean z) {
        }

        public void a(@CheckForNull h hVar) {
            AbstractFuture.f6459a.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f6472a;
            if (thread != null) {
                this.f6472a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            AbstractFuture.f6459a.e(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.common.util.concurrent.AbstractFuture$a] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    static {
        boolean z;
        AtomicHelper fVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        } catch (SecurityException unused) {
            z = false;
        }
        f6461a = z;
        f6460a = Logger.getLogger(AbstractFuture.class.getName());
        ?? r2 = 0;
        r2 = 0;
        try {
            fVar = new g();
            th = null;
        } catch (Throwable th) {
            th = th;
            try {
                fVar = new d(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "a"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, h.class, "a"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, c.class, "a"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            } catch (Throwable th2) {
                fVar = new f();
                r2 = th2;
            }
        }
        f6459a = fVar;
        if (r2 != 0) {
            ?? r0 = f6460a;
            Level level = Level.SEVERE;
            r0.log(level, "UnsafeAtomicHelper is broken!", th);
            r0.log(level, "SafeAtomicHelper is broken!", r2);
        }
        b = new Object();
    }

    public static CancellationException q(String str, @CheckForNull Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
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
    public static void s(AbstractFuture<?> abstractFuture) {
        c cVar = null;
        while (true) {
            abstractFuture.y();
            abstractFuture.afterDone();
            c cVarR = abstractFuture.r(cVar);
            while (cVarR != null) {
                cVar = cVarR.f32289a;
                Runnable runnable = cVarR.f6468a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof e) {
                    e eVar = (e) runnable2;
                    abstractFuture = eVar.f32291a;
                    if (abstractFuture.f6464a == eVar) {
                        if (f6459a.b(abstractFuture, eVar, v(eVar.f6470a))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = cVarR.f6469a;
                    Objects.requireNonNull(executor);
                    t(runnable2, executor);
                }
                cVarR = cVar;
            }
            return;
        }
    }

    public static void t(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f6460a;
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 57 + strValueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            logger.log(level, sb.toString(), (Throwable) e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object v(ListenableFuture<?> listenableFuture) {
        Throwable thA;
        if (listenableFuture instanceof Trusted) {
            Object bVar = ((AbstractFuture) listenableFuture).f6464a;
            if (bVar instanceof b) {
                b bVar2 = (b) bVar;
                if (bVar2.f6467a) {
                    bVar = bVar2.f6466a != null ? new b(false, bVar2.f6466a) : b.b;
                }
            }
            Objects.requireNonNull(bVar);
            return bVar;
        }
        if ((listenableFuture instanceof InternalFutureFailureAccess) && (thA = fd4.a((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(thA);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!f6461a) && zIsCancelled) {
            b bVar3 = b.b;
            Objects.requireNonNull(bVar3);
            return bVar3;
        }
        try {
            Object objW = w(listenableFuture);
            if (!zIsCancelled) {
                return objW == null ? b : objW;
            }
            String strValueOf = String.valueOf(listenableFuture);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 84);
            sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb.append(strValueOf);
            return new b(false, new IllegalArgumentException(sb.toString()));
        } catch (CancellationException e2) {
            if (zIsCancelled) {
                return new b(false, e2);
            }
            String strValueOf2 = String.valueOf(listenableFuture);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 77);
            sb2.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
            sb2.append(strValueOf2);
            return new Failure(new IllegalArgumentException(sb2.toString(), e2));
        } catch (ExecutionException e3) {
            if (!zIsCancelled) {
                return new Failure(e3.getCause());
            }
            String strValueOf3 = String.valueOf(listenableFuture);
            StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 84);
            sb3.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb3.append(strValueOf3);
            return new b(false, new IllegalArgumentException(sb3.toString(), e3));
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    @ParametricNullness
    public static <V> V w(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        c cVar;
        com.google.common.base.i.F(runnable, "Runnable was null.");
        com.google.common.base.i.F(executor, "Executor was null.");
        if (!isDone() && (cVar = this.f6462a) != c.b) {
            c cVar2 = new c(runnable, executor);
            do {
                cVar2.f32289a = cVar;
                if (f6459a.a(this, cVar, cVar2)) {
                    return;
                } else {
                    cVar = this.f6462a;
                }
            } while (cVar != c.b);
        }
        t(runnable, executor);
    }

    @Beta
    @ForOverride
    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        b bVar;
        Object obj = this.f6464a;
        if (!(obj == null) && !(obj instanceof e)) {
            return false;
        }
        if (f6461a) {
            bVar = new b(z, new CancellationException("Future.cancel() was called."));
        } else {
            bVar = z ? b.f32288a : b.b;
            Objects.requireNonNull(bVar);
        }
        AbstractFuture<V> abstractFuture = this;
        boolean z2 = false;
        while (true) {
            if (f6459a.b(abstractFuture, obj, bVar)) {
                if (z) {
                    abstractFuture.interruptTask();
                }
                s(abstractFuture);
                if (!(obj instanceof e)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((e) obj).f6470a;
                if (!(listenableFuture instanceof Trusted)) {
                    listenableFuture.cancel(z);
                    return true;
                }
                abstractFuture = (AbstractFuture) listenableFuture;
                obj = abstractFuture.f6464a;
                if (!(obj == null) && !(obj instanceof e)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = abstractFuture.f6464a;
                if (!(obj instanceof e)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    @ParametricNullness
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f6464a;
        if ((obj != null) && (!(obj instanceof e))) {
            return u(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f6463a;
            if (hVar != h.b) {
                h hVar2 = new h();
                while (true) {
                    hVar2.a(hVar);
                    if (f6459a.c(this, hVar, hVar2)) {
                        do {
                            l.a(this, nanos);
                            if (Thread.interrupted()) {
                                z(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f6464a;
                            if ((obj2 != null) && (!(obj2 instanceof e))) {
                                return u(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        z(hVar2);
                        break;
                    }
                    hVar = this.f6463a;
                    if (hVar == h.b) {
                    }
                }
            }
            Object obj3 = this.f6464a;
            Objects.requireNonNull(obj3);
            return u(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f6464a;
            if ((obj4 != null) && (!(obj4 instanceof e))) {
                return u(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String lowerCase2 = timeUnit.toString().toLowerCase(locale);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
        sb.append("Waited ");
        sb.append(j);
        sb.append(" ");
        sb.append(lowerCase2);
        String string3 = sb.toString();
        if (nanos + 1000 < 0) {
            String strConcat = String.valueOf(string3).concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strValueOf = String.valueOf(strConcat);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 21 + String.valueOf(lowerCase).length());
                sb2.append(strValueOf);
                sb2.append(jConvert);
                sb2.append(" ");
                sb2.append(lowerCase);
                String string4 = sb2.toString();
                if (z) {
                    string4 = String.valueOf(string4).concat(",");
                }
                strConcat = String.valueOf(string4).concat(" ");
            }
            if (z) {
                String strValueOf2 = String.valueOf(strConcat);
                StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 33);
                sb3.append(strValueOf2);
                sb3.append(nanos2);
                sb3.append(" nanoseconds ");
                strConcat = sb3.toString();
            }
            string3 = String.valueOf(strConcat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(string3).concat(" but future completed as timeout expired"));
        }
        StringBuilder sb4 = new StringBuilder(String.valueOf(string3).length() + 5 + String.valueOf(string).length());
        sb4.append(string3);
        sb4.append(" for ");
        sb4.append(string);
        throw new TimeoutException(sb4.toString());
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f6464a instanceof b;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.f6464a;
        return (!(obj instanceof e)) & (obj != null);
    }

    public final void m(StringBuilder sb) {
        try {
            Object objW = w(this);
            sb.append("SUCCESS, result=[");
            o(sb, objW);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    public final void n(StringBuilder sb) {
        String string;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.f6464a;
        if (obj instanceof e) {
            sb.append(", setFuture=[");
            p(sb, ((e) obj).f6470a);
            sb.append("]");
        } else {
            try {
                string = com.google.common.base.l.c(pendingToString());
            } catch (RuntimeException | StackOverflowError e2) {
                String strValueOf = String.valueOf(e2.getClass());
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 38);
                sb2.append("Exception thrown from implementation: ");
                sb2.append(strValueOf);
                string = sb2.toString();
            }
            if (string != null) {
                sb.append(", info=[");
                sb.append(string);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            m(sb);
        }
    }

    public final void o(StringBuilder sb, @CheckForNull Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    public final void p(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e2) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e2.getClass());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    @CheckForNull
    public final c r(@CheckForNull c cVar) {
        c cVar2;
        do {
            cVar2 = this.f6462a;
        } while (!f6459a.a(this, cVar2, c.b));
        c cVar3 = cVar;
        c cVar4 = cVar2;
        while (cVar4 != null) {
            c cVar5 = cVar4.f32289a;
            cVar4.f32289a = cVar3;
            cVar3 = cVar4;
            cVar4 = cVar5;
        }
        return cVar3;
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
    @CanIgnoreReturnValue
    public boolean set(@ParametricNullness V v) {
        if (v == null) {
            v = (V) b;
        }
        if (!f6459a.b(this, null, v)) {
            return false;
        }
        s(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setException(Throwable th) {
        if (!f6459a.b(this, null, new Failure((Throwable) com.google.common.base.i.E(th)))) {
            return false;
        }
        s(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        com.google.common.base.i.E(listenableFuture);
        Object obj = this.f6464a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f6459a.b(this, null, v(listenableFuture))) {
                    return false;
                }
                s(this);
                return true;
            }
            e eVar = new e(this, listenableFuture);
            if (f6459a.b(this, null, eVar)) {
                try {
                    listenableFuture.addListener(eVar, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.f32287a;
                    }
                    f6459a.b(this, eVar, failure);
                }
                return true;
            }
            obj = this.f6464a;
        }
        if (obj instanceof b) {
            listenableFuture.cancel(((b) obj).f6467a);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m(sb);
        } else {
            n(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    @CheckForNull
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.f6464a;
        if (obj instanceof Failure) {
            return ((Failure) obj).f6465a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    public final V u(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            throw q("Task was cancelled.", ((b) obj).f6466a);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f6465a);
        }
        return obj == b ? (V) k.b() : obj;
    }

    public final boolean wasInterrupted() {
        Object obj = this.f6464a;
        return (obj instanceof b) && ((b) obj).f6467a;
    }

    final void x(@CheckForNull Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public final void y() {
        h hVar;
        do {
            hVar = this.f6463a;
        } while (!f6459a.c(this, hVar, h.b));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f32293a;
        }
    }

    public final void z(h hVar) {
        hVar.f6472a = null;
        while (true) {
            h hVar2 = this.f6463a;
            if (hVar2 == h.b) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f32293a;
                if (hVar2.f6472a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f32293a = hVar4;
                    if (hVar3.f6472a == null) {
                    }
                } else if (!f6459a.c(this, hVar2, hVar4)) {
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public static final class c {
        public static final c b = new c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public c f32289a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public final Runnable f6468a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public final Executor f6469a;

        public c(Runnable runnable, Executor executor) {
            this.f6468a = runnable;
            this.f6469a = executor;
        }

        public c() {
            this.f6468a = null;
            this.f6469a = null;
        }
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    @ParametricNullness
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f6464a;
            if ((obj2 != null) & (!(obj2 instanceof e))) {
                return u(obj2);
            }
            h hVar = this.f6463a;
            if (hVar != h.b) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f6459a.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f6464a;
                            } else {
                                z(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof e))));
                        return u(obj);
                    }
                    hVar = this.f6463a;
                } while (hVar != h.b);
            }
            Object obj3 = this.f6464a;
            Objects.requireNonNull(obj3);
            return u(obj3);
        }
        throw new InterruptedException();
    }
}
