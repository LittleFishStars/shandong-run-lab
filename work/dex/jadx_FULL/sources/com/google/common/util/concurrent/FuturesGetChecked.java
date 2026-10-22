package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class FuturesGetChecked {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Ordering<Constructor<?>> f32374a = Ordering.natural().onResultOf(new a()).reverse();

    @VisibleForTesting
    public interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> cls);
    }

    @VisibleForTesting
    public static class GetCheckedTypeValidatorHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GetCheckedTypeValidator f32375a = a();

        public enum WeakSetValidator implements GetCheckedTypeValidator {
            INSTANCE;

            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> cls) {
                Iterator<WeakReference<Class<? extends Exception>>> it = validClasses.iterator();
                while (it.hasNext()) {
                    if (cls.equals(it.next().get())) {
                        return;
                    }
                }
                FuturesGetChecked.b(cls);
                Set<WeakReference<Class<? extends Exception>>> set = validClasses;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(cls));
            }
        }

        public static GetCheckedTypeValidator a() {
            return FuturesGetChecked.k();
        }
    }

    public class a implements Function<Constructor<?>, Boolean> {
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    public static GetCheckedTypeValidator a() {
        return GetCheckedTypeValidatorHolder.f32375a;
    }

    @VisibleForTesting
    public static void b(Class<? extends Exception> cls) {
        com.google.common.base.i.u(g(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        com.google.common.base.i.u(f(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V c(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) throws Exception {
        getCheckedTypeValidator.validateClass(cls);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw i(cls, e);
        } catch (ExecutionException e2) {
            l(e2.getCause(), cls);
            throw new AssertionError();
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V d(Future<V> future, Class<X> cls) throws Exception {
        return (V) c(a(), future, cls);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V e(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) throws Exception {
        a().validateClass(cls);
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw i(cls, e);
        } catch (ExecutionException e2) {
            l(e2.getCause(), cls);
            throw new AssertionError();
        } catch (TimeoutException e3) {
            throw i(cls, e3);
        }
    }

    public static boolean f(Class<? extends Exception> cls) {
        try {
            i(cls, new Exception());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @VisibleForTesting
    public static boolean g(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    @CheckForNull
    public static <X> X h(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static <X extends Exception> X i(Class<X> cls, Throwable th) {
        Iterator it = j(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            X x = (X) h((Constructor) it.next(), th);
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        String strValueOf = String.valueOf(cls);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 82);
        sb.append("No appropriate constructor for exception of type ");
        sb.append(strValueOf);
        sb.append(" in response to chained exception");
        throw new IllegalArgumentException(sb.toString(), th);
    }

    public static <X extends Exception> List<Constructor<X>> j(List<Constructor<X>> list) {
        return (List<Constructor<X>>) f32374a.sortedCopy(list);
    }

    @VisibleForTesting
    public static GetCheckedTypeValidator k() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    public static <X extends Exception> void l(Throwable th, Class<X> cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw i(cls, th);
        }
        throw new UncheckedExecutionException(th);
    }
}
