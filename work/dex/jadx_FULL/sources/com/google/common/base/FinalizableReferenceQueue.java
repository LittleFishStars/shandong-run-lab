package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public class FinalizableReferenceQueue implements Closeable {
    public static final String f = "com.google.common.base.internal.Finalizer";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PhantomReference<Object> f5927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ReferenceQueue<Object> f5928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f5926a = Logger.getLogger(FinalizableReferenceQueue.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f31573a = j(k(new c(), new a(), new b()));

    public interface FinalizerLoader {
        @CheckForNull
        Class<?> a();
    }

    public static class a implements FinalizerLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f31574a = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @CheckForNull
        public Class<?> a() {
            try {
                return c(b()).loadClass(FinalizableReferenceQueue.f);
            } catch (Exception e) {
                FinalizableReferenceQueue.f5926a.log(Level.WARNING, f31574a, (Throwable) e);
                return null;
            }
        }

        public URL b() throws IOException {
            String strConcat = String.valueOf(FinalizableReferenceQueue.f.replace('.', '/')).concat(com.google.common.reflect.a.f6446a);
            URL resource = getClass().getClassLoader().getResource(strConcat);
            if (resource == null) {
                throw new FileNotFoundException(strConcat);
            }
            String string = resource.toString();
            if (string.endsWith(strConcat)) {
                return new URL(resource, string.substring(0, string.length() - strConcat.length()));
            }
            throw new IOException(string.length() != 0 ? "Unsupported path style: ".concat(string) : new String("Unsupported path style: "));
        }

        public URLClassLoader c(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }
    }

    public static class b implements FinalizerLoader {
        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public Class<?> a() {
            try {
                return Class.forName("com.zj.adlib.sg3");
            } catch (ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static class c implements FinalizerLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        public static boolean f31575a;

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @CheckForNull
        public Class<?> a() {
            if (f31575a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass(FinalizableReferenceQueue.f);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.f5926a.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public FinalizableReferenceQueue() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f5928a = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.f5927a = phantomReference;
        boolean z = false;
        try {
            f31573a.invoke(null, FinalizableReference.class, referenceQueue, phantomReference);
            z = true;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (Throwable th) {
            f5926a.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
        }
        this.f5929a = z;
    }

    public static Method j(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public static Class<?> k(FinalizerLoader... finalizerLoaderArr) {
        for (FinalizerLoader finalizerLoader : finalizerLoaderArr) {
            Class<?> clsA = finalizerLoader.a();
            if (clsA != null) {
                return clsA;
            }
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5927a.enqueue();
        h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        if (this.f5929a) {
            return;
        }
        while (true) {
            Reference<? extends Object> referencePoll = this.f5928a.poll();
            if (referencePoll == 0) {
                return;
            }
            referencePoll.clear();
            try {
                ((FinalizableReference) referencePoll).a();
            } catch (Throwable th) {
                f5926a.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
        }
    }
}
