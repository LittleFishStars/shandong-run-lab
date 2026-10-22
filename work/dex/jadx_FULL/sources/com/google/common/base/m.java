package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @GwtIncompatible
    public static final Object f31606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GwtIncompatible
    public static final String f5956a = "sun.misc.JavaLangAccess";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    @GwtIncompatible
    public static final Method f5957a;

    @VisibleForTesting
    @GwtIncompatible
    public static final String b = "sun.misc.SharedSecrets";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @CheckForNull
    @GwtIncompatible
    public static final Method f5958b;

    public class a extends AbstractList<StackTraceElement> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f31607a;

        public a(Throwable th) {
            this.f31607a = th;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StackTraceElement get(int i) {
            Method method = m.f5957a;
            Objects.requireNonNull(method);
            Object obj = m.f31606a;
            Objects.requireNonNull(obj);
            return (StackTraceElement) m.m(method, obj, this.f31607a, Integer.valueOf(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            Method method = m.f5958b;
            Objects.requireNonNull(method);
            Object obj = m.f31606a;
            Objects.requireNonNull(obj);
            return ((Integer) m.m(method, obj, this.f31607a)).intValue();
        }
    }

    static {
        Object objH = h();
        f31606a = objH;
        f5957a = objH == null ? null : g();
        f5958b = objH != null ? k(objH) : null;
    }

    @Beta
    public static List<Throwable> e(Throwable th) {
        i.E(th);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(th);
        boolean z = false;
        Throwable cause = th;
        while (true) {
            th = th.getCause();
            if (th == null) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(th);
            if (th == cause) {
                throw new IllegalArgumentException("Loop in causal chain detected.", th);
            }
            if (z) {
                cause = cause.getCause();
            }
            z = !z;
        }
    }

    @Beta
    @CheckForNull
    @GwtIncompatible
    public static <X extends Throwable> X f(Throwable th, Class<X> cls) {
        try {
            return cls.cast(th.getCause());
        } catch (ClassCastException e) {
            e.initCause(th);
            throw e;
        }
    }

    @CheckForNull
    @GwtIncompatible
    public static Method g() {
        return i("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @CheckForNull
    @GwtIncompatible
    public static Object h() {
        try {
            return Class.forName(b, false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    @GwtIncompatible
    public static Method i(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName(f5956a, false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Throwable j(Throwable th) {
        boolean z = false;
        Throwable cause = th;
        while (true) {
            Throwable cause2 = th.getCause();
            if (cause2 == null) {
                return th;
            }
            if (cause2 == cause) {
                throw new IllegalArgumentException("Loop in causal chain detected.", cause2);
            }
            if (z) {
                cause = cause.getCause();
            }
            z = !z;
            th = cause2;
        }
    }

    @CheckForNull
    @GwtIncompatible
    public static Method k(Object obj) {
        try {
            Method methodI = i("getStackTraceDepth", Throwable.class);
            if (methodI == null) {
                return null;
            }
            methodI.invoke(obj, new Throwable());
            return methodI;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @GwtIncompatible
    public static String l(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @GwtIncompatible
    public static Object m(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw q(e2.getCause());
        }
    }

    @GwtIncompatible
    public static List<StackTraceElement> n(Throwable th) {
        i.E(th);
        return new a(th);
    }

    @Beta
    @GwtIncompatible
    public static List<StackTraceElement> o(Throwable th) {
        return p() ? n(th) : Collections.unmodifiableList(Arrays.asList(th.getStackTrace()));
    }

    @Beta
    @GwtIncompatible
    public static boolean p() {
        return (f5957a == null || f5958b == null) ? false : true;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public static RuntimeException q(Throwable th) {
        w(th);
        throw new RuntimeException(th);
    }

    @GwtIncompatible
    @Deprecated
    public static <X extends Throwable> void r(@CheckForNull Throwable th, Class<X> cls) throws Throwable {
        if (th != null) {
            v(th, cls);
        }
    }

    @GwtIncompatible
    @Deprecated
    public static void s(@CheckForNull Throwable th) {
        if (th != null) {
            w(th);
        }
    }

    @GwtIncompatible
    public static <X extends Throwable> void t(@CheckForNull Throwable th, Class<X> cls) throws Throwable {
        r(th, cls);
        s(th);
    }

    @GwtIncompatible
    public static <X1 extends Throwable, X2 extends Throwable> void u(@CheckForNull Throwable th, Class<X1> cls, Class<X2> cls2) throws Throwable {
        i.E(cls2);
        r(th, cls);
        t(th, cls2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    @GwtIncompatible
    public static <X extends Throwable> void v(Throwable th, Class<X> cls) throws Throwable {
        i.E(th);
        if (cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void w(Throwable th) {
        i.E(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
