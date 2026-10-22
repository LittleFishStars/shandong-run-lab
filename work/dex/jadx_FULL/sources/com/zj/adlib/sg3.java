package com.zj.adlib;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class sg3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NullableDecl
    public static final Constructor<Thread> f44686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NullableDecl
    public static final Field f19571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f19572a = Logger.getLogger(sg3.class.getName());
    public static final String f = "com.google.common.base.FinalizableReference";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PhantomReference<Object> f19573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ReferenceQueue<Object> f19574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference<Class<?>> f19575a;

    static {
        Constructor<Thread> constructorB = b();
        f44686a = constructorB;
        f19571a = constructorB == null ? d() : null;
    }

    public sg3(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.f19574a = referenceQueue;
        this.f19575a = new WeakReference<>(cls);
        this.f19573a = phantomReference;
    }

    @NullableDecl
    public static Constructor<Thread> b() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    public static Field d() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            f19572a.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    public static void e(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        Thread thread;
        if (!cls.getName().equals(f)) {
            throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
        }
        sg3 sg3Var = new sg3(cls, referenceQueue, phantomReference);
        String name = sg3.class.getName();
        Constructor<Thread> constructor = f44686a;
        if (constructor != null) {
            try {
                thread = constructor.newInstance(null, sg3Var, name, 0L, Boolean.FALSE);
            } catch (Throwable th) {
                f19572a.log(Level.INFO, "Failed to create a thread without inherited thread-local values", th);
                thread = null;
            }
        } else {
            thread = null;
        }
        if (thread == null) {
            thread = new Thread(null, sg3Var, name);
        }
        thread.setDaemon(true);
        try {
            Field field = f19571a;
            if (field != null) {
                field.set(thread, null);
            }
        } catch (Throwable th2) {
            f19572a.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", th2);
        }
        thread.start();
    }

    public final boolean a(Reference<?> reference) {
        Method methodC = c();
        if (methodC == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.f19573a) {
                return false;
            }
            try {
                methodC.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                f19572a.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.f19574a.poll();
        } while (reference != null);
        return true;
    }

    @NullableDecl
    public final Method c() {
        Class<?> cls = this.f19575a.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.f19574a.remove())) {
        }
    }
}
