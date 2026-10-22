package com.zj.adlib;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ejd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f41453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Throwable f16328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Field f16329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Method f16330a;
    public static final Field b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Method f16331b;
    public static final Field c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final Method f16332c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.reflect.AccessibleObject, java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.reflect.AccessibleObject, java.lang.reflect.Field] */
    static {
        Throwable th;
        Object obj;
        Field field;
        Method declaredMethod;
        Method declaredMethod2;
        Method declaredMethod3;
        ?? field2;
        ?? field3;
        try {
            Class<?> cls = Class.forName("libcore.io.Libcore");
            Class<?> cls2 = Class.forName("libcore.io.StructStat");
            Class<?> cls3 = Class.forName("libcore.io.OsConstants");
            Class<?> cls4 = Class.forName("libcore.io.ForwardingOs");
            declaredMethod = cls3.getDeclaredMethod("S_ISLNK", Integer.TYPE);
            try {
                declaredMethod.setAccessible(true);
                declaredMethod3 = cls4.getDeclaredMethod("lstat", String.class);
                try {
                    declaredMethod2 = cls4.getDeclaredMethod("fstat", FileDescriptor.class);
                    try {
                        Field declaredField = cls.getDeclaredField("os");
                        declaredField.setAccessible(true);
                        obj = declaredField.get(cls);
                        try {
                            field2 = cls2.getField("st_dev");
                            try {
                                field3 = cls2.getField("st_ino");
                                try {
                                    field = cls2.getField("st_mode");
                                    try {
                                        field2.setAccessible(true);
                                        field3.setAccessible(true);
                                        field.setAccessible(true);
                                        f16330a = declaredMethod;
                                        f16331b = declaredMethod3;
                                        f16332c = declaredMethod2;
                                        f16329a = field2;
                                        b = field3;
                                        c = field;
                                        f41453a = obj;
                                        f16328a = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Log.d("StructStatHelper", "Reflection failed", th);
                                            f16330a = declaredMethod;
                                            f16331b = declaredMethod3;
                                            f16332c = declaredMethod2;
                                            f16329a = field2;
                                            b = field3;
                                            c = field;
                                            f41453a = obj;
                                            f16328a = th;
                                        } catch (Throwable th3) {
                                            f16330a = declaredMethod;
                                            f16331b = declaredMethod3;
                                            f16332c = declaredMethod2;
                                            f16329a = field2;
                                            b = field3;
                                            c = field;
                                            f41453a = obj;
                                            f16328a = null;
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    field = null;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                field = null;
                                field3 = 0;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            field = null;
                            field2 = field;
                            field3 = field2;
                            Log.d("StructStatHelper", "Reflection failed", th);
                            f16330a = declaredMethod;
                            f16331b = declaredMethod3;
                            f16332c = declaredMethod2;
                            f16329a = field2;
                            b = field3;
                            c = field;
                            f41453a = obj;
                            f16328a = th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        obj = null;
                        field = null;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    obj = null;
                    field = null;
                    declaredMethod2 = null;
                    field2 = 0;
                }
            } catch (Throwable th9) {
                th = th9;
                obj = null;
                field = null;
                declaredMethod2 = null;
                declaredMethod3 = declaredMethod2;
                field2 = declaredMethod3;
                field3 = field2;
                Log.d("StructStatHelper", "Reflection failed", th);
                f16330a = declaredMethod;
                f16331b = declaredMethod3;
                f16332c = declaredMethod2;
                f16329a = field2;
                b = field3;
                c = field;
                f41453a = obj;
                f16328a = th;
            }
        } catch (Throwable th10) {
            th = th10;
            obj = null;
            field = null;
            declaredMethod = null;
            declaredMethod2 = null;
        }
    }

    public static jnd a(final FileDescriptor fileDescriptor) throws IOException {
        return (jnd) f(new Callable() { // from class: com.zj.adlib.xgd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ejd.e(ejd.f16332c.invoke(ejd.f41453a, fileDescriptor));
            }
        });
    }

    public static jnd d(final String str) throws IOException {
        return (jnd) f(new Callable() { // from class: com.zj.adlib.vdd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ejd.e(ejd.f16331b.invoke(ejd.f41453a, str));
            }
        });
    }

    public static jnd e(Object obj) throws Exception {
        return new jnd(((Long) f16329a.get(obj)).longValue(), ((Long) b.get(obj)).longValue(), ((Boolean) f16330a.invoke(null, Integer.valueOf(((Integer) c.get(obj)).intValue()))).booleanValue());
    }

    public static Object f(Callable callable) throws IOException {
        try {
            Throwable th = f16328a;
            if (th == null) {
                return callable.call();
            }
            throw new IOException(th);
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }
}
