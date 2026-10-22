package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.i;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Weak
    public c f32034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Object f6248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Method f6249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f6250a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6251a;

        public a(Object obj) {
            this.f6251a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.f(this.f6251a);
            } catch (InvocationTargetException e) {
                d.this.f32034a.b(e.getCause(), d.this.c(this.f6251a));
            }
        }
    }

    @VisibleForTesting
    public static final class b extends d {
        public /* synthetic */ b(c cVar, Object obj, Method method, a aVar) {
            this(cVar, obj, method);
        }

        @Override // com.google.common.eventbus.d
        public void f(Object obj) throws InvocationTargetException {
            synchronized (this) {
                super.f(obj);
            }
        }

        public b(c cVar, Object obj, Method method) {
            super(cVar, obj, method, null);
        }
    }

    public /* synthetic */ d(c cVar, Object obj, Method method, a aVar) {
        this(cVar, obj, method);
    }

    public static d d(c cVar, Object obj, Method method) {
        return g(method) ? new d(cVar, obj, method) : new b(cVar, obj, method, null);
    }

    public static boolean g(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    public final e c(Object obj) {
        return new e(this.f32034a, obj, this.f6248a, this.f6249a);
    }

    public final void e(Object obj) {
        this.f6250a.execute(new a(obj));
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f6248a == dVar.f6248a && this.f6249a.equals(dVar.f6249a);
    }

    @VisibleForTesting
    public void f(Object obj) throws InvocationTargetException {
        try {
            this.f6249a.invoke(this.f6248a, i.E(obj));
        } catch (IllegalAccessException e) {
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
            sb.append("Method became inaccessible: ");
            sb.append(strValueOf);
            throw new Error(sb.toString(), e);
        } catch (IllegalArgumentException e2) {
            String strValueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 33);
            sb2.append("Method rejected target/argument: ");
            sb2.append(strValueOf2);
            throw new Error(sb2.toString(), e2);
        } catch (InvocationTargetException e3) {
            if (!(e3.getCause() instanceof Error)) {
                throw e3;
            }
            throw ((Error) e3.getCause());
        }
    }

    public final int hashCode() {
        return ((this.f6249a.hashCode() + 31) * 31) + System.identityHashCode(this.f6248a);
    }

    public d(c cVar, Object obj, Method method) {
        this.f32034a = cVar;
        this.f6248a = i.E(obj);
        this.f6249a = method;
        method.setAccessible(true);
        this.f6250a = cVar.a();
    }
}
