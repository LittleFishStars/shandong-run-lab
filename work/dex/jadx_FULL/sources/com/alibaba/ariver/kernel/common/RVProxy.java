package com.alibaba.ariver.kernel.common;

import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVProxy {
    private static volatile Printer c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Object> f24229a = new ConcurrentHashMap();
    private static final Map<InstanceType, Map<Class<?>, Object>> b = new ConcurrentHashMap();
    public static boolean sHasSetupProxy = false;
    private static Initializer d = null;

    public static class EmptyPrinter implements Printer {
        @Override // com.alibaba.ariver.kernel.common.RVProxy.Printer
        public void print(String str) {
        }
    }

    public interface Initializer {
        void doInitialize();
    }

    public interface LazyGetter<T> {
        @Nullable
        T get();
    }

    public interface Printer {
        void print(String str);
    }

    private static <T> void a(@Nullable InstanceType instanceType, Class cls, Object obj) {
        Map<Class<?>, Object> concurrentHashMap;
        if (cls == null) {
            return;
        }
        if (instanceType != null) {
            Map<InstanceType, Map<Class<?>, Object>> map = b;
            concurrentHashMap = map.get(instanceType);
            if (concurrentHashMap == null) {
                synchronized (map) {
                    concurrentHashMap = map.get(instanceType);
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap<>();
                        map.put(instanceType, concurrentHashMap);
                    }
                }
            }
        } else {
            concurrentHashMap = f24229a;
        }
        if (obj == null) {
            concurrentHashMap.remove(cls);
            return;
        }
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("set proxy class must a Interface: " + cls);
        }
        if (!Proxiable.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("set proxy class must a Proxiable: " + cls);
        }
        if (!cls.isInstance(obj) && !(obj instanceof LazyGetter)) {
            throw new IllegalArgumentException(obj.getClass().getSimpleName() + " is not instance of " + cls.getSimpleName() + " and not instance of LazyGetter");
        }
        getPrinter().print(cls.getSimpleName() + " >>> " + obj.getClass() + " instance: " + instanceType);
        synchronized (f24229a) {
            concurrentHashMap.put(cls, obj);
        }
    }

    public static <T> T get(Class<T> cls) {
        return (T) get((Class) cls, false);
    }

    public static synchronized Printer getPrinter() {
        if (c == null) {
            c = new EmptyPrinter();
        }
        return c;
    }

    public static <T> void set(Class<? super T> cls, T t) {
        a(null, cls, t);
    }

    public static <T> void setLazy(Class<T> cls, LazyGetter<T> lazyGetter) {
        a(null, cls, lazyGetter);
    }

    public static void setLazyInitializer(Initializer initializer) {
        d = initializer;
    }

    public static void setPrinter(Printer printer) {
        c = printer;
    }

    public static <T> T get(@Nullable Node node, Class<T> cls) {
        return (T) get(node, cls, false);
    }

    public static <T> void set(InstanceType instanceType, Class<? super T> cls, T t) {
        a(instanceType, cls, t);
    }

    public static <T> void setLazy(InstanceType instanceType, Class<T> cls, LazyGetter<T> lazyGetter) {
        a(instanceType, cls, lazyGetter);
    }

    public static <T> T get(Class<T> cls, boolean z) {
        return (T) get(null, cls, z);
    }

    public static <T> T get(@Nullable Node node, final Class<T> cls, boolean z) {
        Map<Class<?>, Object> map;
        T t;
        if (!cls.isInterface()) {
            getPrinter().print("got proxy clazz must a Interface:" + cls.getSimpleName());
        }
        InstanceType instanceType = node != null ? node.getInstanceType() : null;
        if (instanceType == null || (map = b.get(instanceType)) == null) {
            map = null;
            t = null;
        } else {
            t = (T) map.get(cls);
        }
        if (t == null) {
            t = (T) f24229a.get(cls);
        }
        if (t != null && !(t instanceof LazyGetter)) {
            return t;
        }
        T t2 = (T) a(map, cls);
        if (t2 != null) {
            return t2;
        }
        if (!sHasSetupProxy) {
            getPrinter().print("get proxy but not initialized! sLazyInitializer: " + d);
            Initializer initializer = d;
            if (initializer != null) {
                initializer.doInitialize();
                T t3 = (T) a(map, cls);
                if (t3 != null) {
                    return t3;
                }
            } else if (z) {
                return null;
            }
        }
        if (z) {
            return null;
        }
        T t4 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.alibaba.ariver.kernel.common.RVProxy.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Class<?> returnType = method.getReturnType();
                RVProxy.getPrinter().print("unimplemented proxy:" + cls.getSimpleName() + Consts.DOT + method.getName());
                if (!returnType.isPrimitive()) {
                    return null;
                }
                Class<?> cls2 = Boolean.TYPE;
                if (returnType == cls2 || returnType == cls2) {
                    return Boolean.FALSE;
                }
                return 0;
            }
        });
        set(cls, t4);
        return t4;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0016 A[Catch: all -> 0x000f, TryCatch #2 {all -> 0x000f, blocks: (B:6:0x0007, B:14:0x0016, B:16:0x001c, B:18:0x0020, B:23:0x004f, B:24:0x0053, B:25:0x0056, B:27:0x0058, B:33:0x0097, B:40:0x00c2, B:41:0x00de), top: B:48:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x001c A[Catch: all -> 0x000f, TryCatch #2 {all -> 0x000f, blocks: (B:6:0x0007, B:14:0x0016, B:16:0x001c, B:18:0x0020, B:23:0x004f, B:24:0x0053, B:25:0x0056, B:27:0x0058, B:33:0x0097, B:40:0x00c2, B:41:0x00de), top: B:48:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0020 A[Catch: all -> 0x000f, TryCatch #2 {all -> 0x000f, blocks: (B:6:0x0007, B:14:0x0016, B:16:0x001c, B:18:0x0020, B:23:0x004f, B:24:0x0053, B:25:0x0056, B:27:0x0058, B:33:0x0097, B:40:0x00c2, B:41:0x00de), top: B:48:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    /* JADX WARN: Code duplicated, block: B:22:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x004f A[Catch: all -> 0x000f, TryCatch #2 {all -> 0x000f, blocks: (B:6:0x0007, B:14:0x0016, B:16:0x001c, B:18:0x0020, B:23:0x004f, B:24:0x0053, B:25:0x0056, B:27:0x0058, B:33:0x0097, B:40:0x00c2, B:41:0x00de), top: B:48:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0053 A[Catch: all -> 0x000f, TryCatch #2 {all -> 0x000f, blocks: (B:6:0x0007, B:14:0x0016, B:16:0x001c, B:18:0x0020, B:23:0x004f, B:24:0x0053, B:25:0x0056, B:27:0x0058, B:33:0x0097, B:40:0x00c2, B:41:0x00de), top: B:48:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0070 A[Catch: all -> 0x00c1, TRY_LEAVE, TryCatch #0 {all -> 0x00c1, blocks: (B:29:0x0062, B:31:0x0070, B:37:0x009c), top: B:45:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009c A[Catch: all -> 0x00c1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c1, blocks: (B:29:0x0062, B:31:0x0070, B:37:0x009c), top: B:45:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:18:0x0020, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x009c, please report this as an issue */
    @Nullable
    private static <T> T a(Map<Class<?>, Object> map, Class<T> cls) {
        T t;
        boolean z;
        DefaultImpl defaultImpl;
        Class<?> cls2;
        T t2;
        Map<Class<?>, Object> map2 = f24229a;
        synchronized (map2) {
            boolean z2 = true;
            if (map != null) {
                try {
                    t = map.get(cls);
                    if (t != null) {
                        z = true;
                    }
                    if (t == null) {
                        t = (T) map2.get(cls);
                    }
                    if (t != null) {
                        if (t instanceof LazyGetter) {
                            Object obj = ((LazyGetter) t).get();
                            getPrinter().print("Lazy initialize of " + cls + " to " + obj);
                            t = (T) obj;
                        } else {
                            z2 = false;
                        }
                        if (t != null) {
                            if (z2) {
                                if (z) {
                                    map.put(cls, t);
                                } else {
                                    map2.put((Class<?>) cls, t);
                                }
                            }
                            return (T) t;
                        }
                    }
                    defaultImpl = (DefaultImpl) cls.getAnnotation(DefaultImpl.class);
                    if (defaultImpl != null) {
                        try {
                            cls2 = Class.forName(defaultImpl.value());
                            if (cls.isAssignableFrom(cls2)) {
                                t2 = (T) cls2.newInstance();
                                try {
                                    getPrinter().print("Default initialize of " + cls + " to " + t2);
                                    set(cls, t2);
                                    return t2;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t2;
                                    getPrinter().print("DefaultImpl instantiate exception!" + th.getMessage());
                                    return (T) t;
                                }
                            }
                            getPrinter().print("Default impl " + defaultImpl.value() + " is not instance of " + cls);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    return (T) t;
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            t = null;
            z = false;
            if (t == null) {
                t = (T) map2.get(cls);
            }
            if (t != null) {
                if (t instanceof LazyGetter) {
                    Object obj2 = ((LazyGetter) t).get();
                    getPrinter().print("Lazy initialize of " + cls + " to " + obj2);
                    t = (T) obj2;
                } else {
                    z2 = false;
                }
                if (t != null) {
                    if (z2) {
                        if (z) {
                            map.put(cls, t);
                        } else {
                            map2.put((Class<?>) cls, t);
                        }
                    }
                    return (T) t;
                }
            }
            defaultImpl = (DefaultImpl) cls.getAnnotation(DefaultImpl.class);
            if (defaultImpl != null) {
                cls2 = Class.forName(defaultImpl.value());
                if (cls.isAssignableFrom(cls2)) {
                    t2 = (T) cls2.newInstance();
                    getPrinter().print("Default initialize of " + cls + " to " + t2);
                    set(cls, t2);
                    return t2;
                }
                getPrinter().print("Default impl " + defaultImpl.value() + " is not instance of " + cls);
            }
            return (T) t;
        }
    }
}
