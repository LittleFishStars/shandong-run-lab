package com.google.android.gms.internal.mlkit_vision_barcode;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.zj.adlib.klc;
import com.zj.adlib.zbc;
import java.util.Locale;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzec<V> extends zzez implements zzev<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zza f31368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f5783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f5784a;
    public static final Object b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public volatile a0 f5785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public volatile f0 f5786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public volatile Object f5787a;

    abstract class zza {
        public /* synthetic */ zza(klc klcVar) {
        }

        public abstract a0 a(zzec zzecVar, a0 a0Var);

        public abstract f0 b(zzec zzecVar, f0 f0Var);

        public abstract void c(f0 f0Var, @CheckForNull f0 f0Var2);

        public abstract void d(f0 f0Var, Thread thread);

        public abstract boolean e(zzec zzecVar, @CheckForNull a0 a0Var, a0 a0Var2);

        public abstract boolean f(zzec zzecVar, @CheckForNull Object obj, Object obj2);

        public abstract boolean g(zzec zzecVar, @CheckForNull f0 f0Var, @CheckForNull f0 f0Var2);
    }

    public final class zzc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final zzc f31369a = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Throwable f5788a;

        public zzc(Throwable th) {
            th.getClass();
            this.f5788a = th;
        }
    }

    interface zzh<V> extends zzev<V> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza d0Var;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        } catch (SecurityException unused) {
            z = false;
        }
        f5784a = z;
        f5783a = Logger.getLogger(zzec.class.getName());
        Object[] objArr = 0;
        try {
            d0Var = new e0(null);
            th2 = null;
            th = null;
        } catch (Error | RuntimeException e) {
            try {
                th = null;
                th2 = e;
                d0Var = new b0(AtomicReferenceFieldUpdater.newUpdater(f0.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(f0.class, f0.class, "a"), AtomicReferenceFieldUpdater.newUpdater(zzec.class, f0.class, "a"), AtomicReferenceFieldUpdater.newUpdater(zzec.class, a0.class, "a"), AtomicReferenceFieldUpdater.newUpdater(zzec.class, Object.class, "a"));
            } catch (Error | RuntimeException e2) {
                th = e2;
                th2 = e;
                d0Var = new d0(objArr == true ? 1 : 0);
            }
        }
        f31368a = d0Var;
        if (th != null) {
            Logger logger = f5783a;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        b = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object j(zzev zzevVar) {
        Throwable thZzf;
        if (zzevVar instanceof zzh) {
            Object zVar = ((zzec) zzevVar).f5787a;
            if (zVar instanceof z) {
                z zVar2 = (z) zVar;
                if (zVar2.f5778a) {
                    Throwable th = zVar2.f5777a;
                    zVar = th != null ? new z(false, th) : z.b;
                }
            }
            zVar.getClass();
            return zVar;
        }
        if ((zzevVar instanceof zzez) && (thZzf = ((zzez) zzevVar).zzf()) != null) {
            return new zzc(thZzf);
        }
        boolean zIsCancelled = zzevVar.isCancelled();
        if ((!f5784a) && zIsCancelled) {
            z zVar3 = z.b;
            zVar3.getClass();
            return zVar3;
        }
        try {
            Object objK = k(zzevVar);
            if (!zIsCancelled) {
                return objK == null ? b : objK;
            }
            return new z(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(zzevVar)));
        } catch (Error e) {
            e = e;
            return new zzc(e);
        } catch (CancellationException e2) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(zzevVar)), e2)) : new z(false, e2);
        } catch (RuntimeException e3) {
            e = e3;
            return new zzc(e);
        } catch (ExecutionException e4) {
            return zIsCancelled ? new z(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zzevVar)), e4)) : new zzc(e4.getCause());
        }
    }

    public static Object k(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
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
        return obj;
    }

    public static void o(zzec zzecVar, boolean z) {
        a0 a0Var = null;
        while (true) {
            for (f0 f0VarB = f31368a.b(zzecVar, f0.b); f0VarB != null; f0VarB = f0VarB.f31347a) {
                Thread thread = f0VarB.f5750a;
                if (thread != null) {
                    f0VarB.f5750a = null;
                    LockSupport.unpark(thread);
                }
            }
            zzecVar.zzk();
            a0 a0Var2 = a0Var;
            a0 a0VarA = f31368a.a(zzecVar, a0.b);
            a0 a0Var3 = a0Var2;
            while (a0VarA != null) {
                a0 a0Var4 = a0VarA.f31338a;
                a0VarA.f31338a = a0Var3;
                a0Var3 = a0VarA;
                a0VarA = a0Var4;
            }
            while (a0Var3 != null) {
                a0Var = a0Var3.f31338a;
                Runnable runnable = a0Var3.f5741a;
                runnable.getClass();
                if (runnable instanceof c0) {
                    c0 c0Var = (c0) runnable;
                    zzecVar = c0Var.f31342a;
                    if (zzecVar.f5787a == c0Var) {
                        if (f31368a.f(zzecVar, c0Var, j(c0Var.f5745a))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = a0Var3.f5742a;
                    executor.getClass();
                    p(runnable, executor);
                }
                a0Var3 = a0Var;
            }
            return;
        }
    }

    public static void p(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            f5783a.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    public static final Object r(Object obj) throws ExecutionException {
        if (obj instanceof z) {
            Throwable th = ((z) obj).f5777a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).f5788a);
        }
        if (obj == b) {
            return null;
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzev
    public final void b(Runnable runnable, Executor executor) {
        a0 a0Var;
        if (executor == null) {
            throw new NullPointerException("Executor was null.");
        }
        if (!isDone() && (a0Var = this.f5785a) != a0.b) {
            a0 a0Var2 = new a0(runnable, executor);
            do {
                a0Var2.f31338a = a0Var;
                if (f31368a.e(this, a0Var, a0Var2)) {
                    return;
                } else {
                    a0Var = this.f5785a;
                }
            } while (a0Var != a0.b);
        }
        p(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        z zVar;
        Object obj = this.f5787a;
        if (!(obj instanceof c0) && !(obj == null)) {
            return false;
        }
        if (f5784a) {
            zVar = new z(z, new CancellationException("Future.cancel() was called."));
        } else {
            zVar = z ? z.f31362a : z.b;
            zVar.getClass();
        }
        zzec<V> zzecVar = this;
        boolean z2 = false;
        while (true) {
            if (f31368a.f(zzecVar, obj, zVar)) {
                o(zzecVar, z);
                if (obj instanceof c0) {
                    zzev<? extends V> zzevVar = ((c0) obj).f5745a;
                    if (zzevVar instanceof zzh) {
                        zzecVar = (zzec) zzevVar;
                        obj = zzecVar.f5787a;
                        if ((obj == null) | (obj instanceof c0)) {
                            z2 = true;
                        }
                    } else {
                        zzevVar.cancel(z);
                    }
                }
                return true;
            }
            obj = zzecVar.f5787a;
            if (!(obj instanceof c0)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f5787a;
        if ((obj2 != null) && (!(obj2 instanceof c0))) {
            return r(obj2);
        }
        f0 f0Var = this.f5786a;
        if (f0Var != f0.b) {
            f0 f0Var2 = new f0();
            do {
                zza zzaVar = f31368a;
                zzaVar.c(f0Var2, f0Var);
                if (zzaVar.g(this, f0Var, f0Var2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            q(f0Var2);
                            throw new InterruptedException();
                        }
                        obj = this.f5787a;
                    } while (!((obj != null) & (!(obj instanceof c0))));
                    return r(obj);
                }
                f0Var = this.f5786a;
            } while (f0Var != f0.b);
        }
        Object obj3 = this.f5787a;
        obj3.getClass();
        return r(obj3);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f5787a instanceof z;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f5787a;
        return (obj != null) & (!(obj instanceof c0));
    }

    public final void l(StringBuilder sb) {
        try {
            Object objK = k(this);
            sb.append("SUCCESS, result=[");
            if (objK == null) {
                sb.append("null");
            } else if (objK == this) {
                sb.append("this future");
            } else {
                sb.append(objK.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objK)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    public final void m(StringBuilder sb) {
        String strConcat;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.f5787a;
        if (obj instanceof c0) {
            sb.append(", setFuture=[");
            n(sb, ((c0) obj).f5745a);
            sb.append("]");
        } else {
            try {
                strConcat = zbc.a(zze());
            } catch (RuntimeException | StackOverflowError e) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e.getClass()));
            }
            if (strConcat != null) {
                sb.append(", info=[");
                sb.append(strConcat);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            l(sb);
        }
    }

    public final void n(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    public final void q(f0 f0Var) {
        f0Var.f5750a = null;
        while (true) {
            f0 f0Var2 = this.f5786a;
            if (f0Var2 != f0.b) {
                f0 f0Var3 = null;
                while (f0Var2 != null) {
                    f0 f0Var4 = f0Var2.f31347a;
                    if (f0Var2.f5750a != null) {
                        f0Var3 = f0Var2;
                    } else if (f0Var3 != null) {
                        f0Var3.f31347a = f0Var4;
                        if (f0Var3.f5750a == null) {
                        }
                    } else if (!f31368a.g(this, f0Var2, f0Var4)) {
                    }
                    f0Var2 = f0Var4;
                }
                return;
            }
            return;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.f5787a instanceof z) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            l(sb);
        } else {
            m(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public String zze() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzez
    @CheckForNull
    public final Throwable zzf() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.f5787a;
        if (obj instanceof zzc) {
            return ((zzc) obj).f5788a;
        }
        return null;
    }

    public void zzk() {
    }

    public final boolean zzl(Throwable th) {
        if (!f31368a.f(this, null, new zzc(th))) {
            return false;
        }
        o(this, false);
        return true;
    }

    public final boolean zzm(zzev zzevVar) {
        zzevVar.getClass();
        Object obj = this.f5787a;
        if (obj != null) {
            if (obj instanceof z) {
            }
            return false;
        }
        if (!f31368a.f(this, null, j(zzevVar))) {
            return false;
        }
        o(this, false);
        return true;
    }

    public final boolean zzn() {
        Object obj = this.f5787a;
        return (obj instanceof z) && ((z) obj).f5778a;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.f5787a;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof c0))) {
                return r(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                f0 f0Var = this.f5786a;
                if (f0Var != f0.b) {
                    f0 f0Var2 = new f0();
                    while (true) {
                        zza zzaVar = f31368a;
                        zzaVar.c(f0Var2, f0Var);
                        if (zzaVar.g(this, f0Var, f0Var2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, com.google.common.util.concurrent.l.f32437a));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f5787a;
                                    if ((obj2 != null) & (!(obj2 instanceof c0))) {
                                        return r(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    q(f0Var2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            q(f0Var2);
                            break;
                        }
                        f0Var = this.f5786a;
                        if (f0Var == f0.b) {
                        }
                    }
                }
                Object obj3 = this.f5787a;
                obj3.getClass();
                return r(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.f5787a;
                if ((obj4 != null) & (!(obj4 instanceof c0))) {
                    return r(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = jNanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            String strConcat = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j2 = -nanos;
                long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                    if (z) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(" ");
                }
                if (z) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(strConcat + " for " + string);
        }
        throw new InterruptedException();
    }
}
