package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class p implements TimeLimiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f32439a;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f32440a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6601a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Set f6602a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TimeUnit f6603a;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.p$a$a, reason: collision with other inner class name */
        public class CallableC0762a implements Callable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Method f6604a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Object[] f6605a;

            public CallableC0762a(Method method, Object[] objArr) {
                this.f6604a = method;
                this.f6605a = objArr;
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public Object call() throws Exception {
                try {
                    return this.f6604a.invoke(a.this.f6601a, this.f6605a);
                } catch (InvocationTargetException e) {
                    throw p.n(e, false);
                }
            }
        }

        public a(Object obj, long j, TimeUnit timeUnit, Set set) {
            this.f6601a = obj;
            this.f32440a = j;
            this.f6603a = timeUnit;
            this.f6602a = set;
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
            return p.this.h(new CallableC0762a(method, objArr), this.f32440a, this.f6603a, this.f6602a.contains(method));
        }
    }

    public p(ExecutorService executorService) {
        this.f32439a = (ExecutorService) com.google.common.base.i.E(executorService);
    }

    public static void i(long j) {
        com.google.common.base.i.p(j > 0, "timeout must be positive: %s", j);
    }

    public static p j(ExecutorService executorService) {
        return new p(executorService);
    }

    public static boolean k(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    public static Set<Method> l(Class<?> cls) {
        HashSet hashSetU = Sets.u();
        for (Method method : cls.getMethods()) {
            if (k(method)) {
                hashSetU.add(method);
            }
        }
        return hashSetU;
    }

    public static <T> T m(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static Exception n(Exception exc, boolean z) throws Exception {
        Throwable cause = exc.getCause();
        if (cause == null) {
            throw exc;
        }
        if (z) {
            cause.setStackTrace((StackTraceElement[]) com.google.common.collect.r.f(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw ((Exception) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        throw exc;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T a(Callable<T> callable, long j, TimeUnit timeUnit) throws Throwable {
        com.google.common.base.i.E(callable);
        com.google.common.base.i.E(timeUnit);
        i(j);
        Future<T> futureSubmit = this.f32439a.submit(callable);
        try {
            return futureSubmit.get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            futureSubmit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            o(e2.getCause());
            throw new AssertionError();
        } catch (TimeoutException e3) {
            e = e3;
            futureSubmit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void b(Runnable runnable, long j, TimeUnit timeUnit) throws TimeoutException {
        com.google.common.base.i.E(runnable);
        com.google.common.base.i.E(timeUnit);
        i(j);
        Future<?> futureSubmit = this.f32439a.submit(runnable);
        try {
            s.g(futureSubmit, j, timeUnit);
        } catch (ExecutionException e) {
            p(e.getCause());
            throw new AssertionError();
        } catch (TimeoutException e2) {
            futureSubmit.cancel(true);
            throw e2;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void c(Runnable runnable, long j, TimeUnit timeUnit) throws Throwable {
        com.google.common.base.i.E(runnable);
        com.google.common.base.i.E(timeUnit);
        i(j);
        Future<?> futureSubmit = this.f32439a.submit(runnable);
        try {
            futureSubmit.get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            futureSubmit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            p(e2.getCause());
            throw new AssertionError();
        } catch (TimeoutException e3) {
            e = e3;
            futureSubmit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T d(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        com.google.common.base.i.E(callable);
        com.google.common.base.i.E(timeUnit);
        i(j);
        Future<T> futureSubmit = this.f32439a.submit(callable);
        try {
            return (T) s.g(futureSubmit, j, timeUnit);
        } catch (ExecutionException e) {
            o(e.getCause());
            throw new AssertionError();
        } catch (TimeoutException e2) {
            futureSubmit.cancel(true);
            throw e2;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T e(T t, Class<T> cls, long j, TimeUnit timeUnit) {
        com.google.common.base.i.E(t);
        com.google.common.base.i.E(cls);
        com.google.common.base.i.E(timeUnit);
        i(j);
        com.google.common.base.i.e(cls.isInterface(), "interfaceType must be an interface type");
        return (T) m(cls, new a(t, j, timeUnit, l(cls)));
    }

    public final <T> T h(Callable<T> callable, long j, TimeUnit timeUnit, boolean z) throws Exception {
        com.google.common.base.i.E(callable);
        com.google.common.base.i.E(timeUnit);
        i(j);
        Future<T> futureSubmit = this.f32439a.submit(callable);
        try {
            if (!z) {
                return (T) s.g(futureSubmit, j, timeUnit);
            }
            try {
                return futureSubmit.get(j, timeUnit);
            } catch (InterruptedException e) {
                futureSubmit.cancel(true);
                throw e;
            }
        } catch (ExecutionException e2) {
            throw n(e2, true);
        } catch (TimeoutException e3) {
            futureSubmit.cancel(true);
            throw new UncheckedTimeoutException(e3);
        }
    }

    public final void o(Throwable th) throws ExecutionException {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw new ExecutionException(th);
        }
        throw new UncheckedExecutionException(th);
    }

    public final void p(Throwable th) {
        if (!(th instanceof Error)) {
            throw new UncheckedExecutionException(th);
        }
        throw new ExecutionError((Error) th);
    }
}
