package com.kwad.library.b.a;

import android.app.Activity;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends PathClassLoader {
    private static final List<ClassLoader> aDJ = new CopyOnWriteArrayList();
    private final BaseDexClassLoader aDI;

    public a(BaseDexClassLoader baseDexClassLoader) {
        super("", baseDexClassLoader);
        this.aDI = baseDexClassLoader;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> cls = null;
        try {
            Class<?> clsLoadClass = this.aDI.loadClass(str);
            if (Activity.class.isAssignableFrom(clsLoadClass)) {
                return clsLoadClass;
            }
            th = null;
            cls = clsLoadClass;
            if (cls != null) {
                return cls;
            }
            Iterator<ClassLoader> it = aDJ.iterator();
            while (it.hasNext()) {
                Class<?> clsLoadClass2 = it.next().loadClass(str);
                if (clsLoadClass2 != null) {
                    return clsLoadClass2;
                }
            }
            if (th instanceof ClassNotFoundException) {
                throw th;
            }
            throw new ClassNotFoundException(str, th);
        } catch (Throwable th) {
            th = th;
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        return this.aDI.findLibrary(str);
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        return this.aDI.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public final InputStream getResourceAsStream(String str) {
        return this.aDI.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public final Enumeration<URL> getResources(String str) {
        return this.aDI.getResources(str);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str) {
        return findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        return this.aDI.toString();
    }
}
